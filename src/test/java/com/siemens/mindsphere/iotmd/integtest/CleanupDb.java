package com.siemens.mindsphere.iotmd.integtest;


import static io.restassured.RestAssured.given;

import ReadProperties.ReadProperties;
import com.common.restassured.GetOperation;
import com.common.restassured.SetTenantData;
import com.common.restassured.oAuthWithPermission;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;


@TestPropertySource(locations = "classpath:test.properties")
@ContextConfiguration(classes = { GetOperation.class, oAuthWithPermission.class})
public class CleanupDb {

    @Autowired
    SetTenantData prePro;
    @Autowired
    oAuthWithPermission oAuth;

    @Value("${basicUsername}")
    protected String basicUsername;
    @Value("${basicPassword}")
    protected String basicPassword;
    @Value("${entityURI}")
    protected String entityURI;

    @Value("${mySqlDriver}")
    protected String mySqlDriver;
    @Value("${mySqlUrl}")
    protected String mySqlUrl;
    @Value("${remoteDatabaseUsername}")
    protected  String remoteDatabaseUsername;
    @Value("${databaseUserPassword}")
    protected String databaseUserPassword;

    // connect database
    private Connection getConn(){
        Connection conn = null;
        try {
            Class.forName(mySqlDriver);
            conn = DriverManager.getConnection(mySqlUrl, remoteDatabaseUsername, databaseUserPassword);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return  conn;
    }

    // delete entity instance
    public void deleteEntityInstance(String paramFile, String path) throws SQLException, IOException, JSONException{

        Connection connection = null;

        // get entity instance id
        String entityInstanceId = getIdOfEntityInstance(paramFile, path);

        PreparedStatement pstmt = null;

        if(!entityInstanceId.isEmpty()){
            connection = getConn();

            String tenantPrefix = prePro.getTenantPrefix();

            try {
                // delete entity from entities table
                String deleteEntitySql = "delete from entities.ENTITIES where id=?";
                pstmt = connection.prepareStatement(deleteEntitySql);
                pstmt.setString(1, entityInstanceId);
                pstmt.executeUpdate();

            } catch (SQLException e){
                e.printStackTrace();
            } finally {
                pstmt.close();
                connection.close();
            }

            ReadProperties param = new ReadProperties(paramFile);
            String etTypeId = tenantPrefix + "." + param.getProperty("entityName");
            String tableName = getTableName(etTypeId);
            String paramTableName = tableName + "_Param";
            try {
                // delete entity from entity table and entity_param table
                connection = getConn();
                String deleteEntityFromEntityTableSql = "delete from entities." + tableName + " where id=?;";
                pstmt = connection.prepareStatement(deleteEntityFromEntityTableSql);
                pstmt.setString(1, entityInstanceId);
                pstmt.executeUpdate();
                String deleteEntityFromEntityParmTableSql = "delete from entities." + paramTableName + " where entityId=?;";
                pstmt = connection.prepareStatement(deleteEntityFromEntityParmTableSql);
                pstmt.setString(1, entityInstanceId);
                pstmt.executeUpdate();
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                pstmt.close();
                connection.close();
            }

            // clear redis cache
        }
        // clear redis cache
    }

    public void deleteEntityType(String paramFile) throws SQLException{

        // delete sub entity type first if exist
        String tenantPrefix = prePro.getTenantPrefix();

        Connection connection = null;
        ReadProperties param = new ReadProperties(paramFile);
        String etTypeId = tenantPrefix + "." + param.getProperty("entityName");
        PreparedStatement pstmt = null;
        Boolean hasSuperType = hasSuperType(etTypeId);
        String entityTypeId = getIdOfEntityType(etTypeId);
        String tableName = getTableName(etTypeId);

        try {
            connection = getConn();
            String deleteEntityTypeFromEntityTypeTableSql = "delete from types.ENTITY_TYPE_DEF where etTypeId=?";
            pstmt = connection.prepareStatement(deleteEntityTypeFromEntityTypeTableSql);
            pstmt.setString(1, etTypeId);
            pstmt.executeUpdate();
            String deleteEntityTypeFromEntityTypePropertyTableSql = "delete from types.ENTITY_TYPE_PROPERTY_DEF where etId=?";
            pstmt = connection.prepareStatement(deleteEntityTypeFromEntityTypePropertyTableSql);
            pstmt.setString(1, entityTypeId);
            pstmt.executeUpdate();

            if(!hasSuperType){
                Statement statement = connection.createStatement();
                String dropEntityTableSql = "drop table if exists entities." + tableName;
                String dropEntityParamTableSql = "drop table if exists entities." + tableName + "_Param";
                statement.addBatch(dropEntityTableSql);
                statement.addBatch(dropEntityParamTableSql);
                statement.executeBatch();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pstmt.close();
            connection.close();
        }
    }

    public void deletePropertySet(String paramFile) throws SQLException{

        String tenantPrefix = prePro.getTenantPrefix();
        ReadProperties param = new ReadProperties(paramFile);
        String psTypeId = tenantPrefix + "." + param.getProperty("propName");

        String propertySetId = getIdOfPropertySet(psTypeId);

        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = getConn();
            String deletePropertySetFromPropertySetTableSql = "delete from types.PROPERTY_SET_DEF where psTypeId=?";
            pstmt = connection.prepareStatement(deletePropertySetFromPropertySetTableSql);
            pstmt.setString(1, psTypeId);
            pstmt.executeUpdate();
            String deletePropertySetFromPropertyTableSql = "delete from types.PROPERTY_SET_PROPERTY_DEF where psId=?";
            pstmt = connection.prepareStatement(deletePropertySetFromPropertyTableSql);
            pstmt.setString(1, propertySetId);
            pstmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pstmt.close();
            connection.close();
        }
    }

    public void deleteTenant(String paramfile) throws SQLException{
        ReadProperties param = new ReadProperties(paramfile);
        String tenantIdentityId = param.getProperty("tenantId"); // tenantId is the identityID?
        String tenantId = getIdOfTenant(tenantIdentityId);

        Connection connection = getConn();
        PreparedStatement pstmt = null;

        try {
            String deleteTenantFromTenantTableSql = "delete from tenants.tenant where identity_id=?";
            pstmt = connection.prepareStatement(deleteTenantFromTenantTableSql);
            pstmt.setString(1, tenantIdentityId);
            pstmt.executeUpdate();
            String deleteTenantFromTenantPreferenceTableSql = "delete from tenants.tenant_preference where tenant_id=?";
            pstmt = connection.prepareStatement(deleteTenantFromTenantPreferenceTableSql);
            pstmt.setString(1, tenantId);
            pstmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            pstmt.close();
            connection.close();
        }

    }

    // get tableName from entity_type_def
    public String getTableName(String etTypeId) throws SQLException {
        Connection connection = getConn();
        PreparedStatement pstmt = null;
        String tableName = null;
        try {
            String getTableNameSql = "select tableName from types.ENTITY_TYPE_DEF where etTypeId=?";
            pstmt = connection.prepareStatement(getTableNameSql);
            pstmt.setString(1, etTypeId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                tableName = rs.getString("tableName");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pstmt.close();
            connection.close();
        }
        return tableName;
    }

    // get id of entity type from entity_type_def
    public String getIdOfEntityType(String etTypeId) throws SQLException {
        Connection connection = getConn();
        PreparedStatement pstmt = null;
        String entityTypeId = null;
        try {
            String getIdOfEntityTypeSql = "select id from types.ENTITY_TYPE_DEF where etTypeId=?";
            pstmt = connection.prepareStatement(getIdOfEntityTypeSql);
            pstmt.setString(1, etTypeId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                entityTypeId = rs.getString("id");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pstmt.close();
            connection.close();
        }
        return entityTypeId;
    }

    public String getIdOfPropertySet(String psTypeId) throws SQLException {
        Connection connection = getConn();
        PreparedStatement pstmt = null;
        String propertySetId = null;
        try {
            String getPropertySetIdSql = "select id from types.PROPERTY_SET_DEF where psTypeId=?";
            pstmt = connection.prepareStatement(getPropertySetIdSql);
            pstmt.setString(1, psTypeId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                propertySetId = rs.getString("id");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pstmt.close();
            connection.close();
        }
        return propertySetId;
    }

    public String getIdOfTenant(String tenantIdentityId) throws SQLException{
        Connection connection = getConn();
        PreparedStatement pstmt = null;
        String tenantId = null;
        try {
            String getTenantIdSql = "select id from tenants.tenant where identity_id=?";
            pstmt = connection.prepareStatement(getTenantIdSql);
            pstmt.setString(1, tenantIdentityId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                tenantId = rs.getString("id");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pstmt.close();
            connection.close();
        }
        return tenantId;
    }

    public Boolean hasSuperType(String etTypeId) throws SQLException {
        Connection connection = getConn();
        PreparedStatement pstmt = null;
        String getSuperTypeSql = null;
        String superType = null;
        try {
            getSuperTypeSql = "select superType from types.ENTITY_TYPE_DEF where etTypeId=?";
            pstmt = connection.prepareStatement(getSuperTypeSql);
            pstmt.setString(1, etTypeId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                superType = rs.getString("superType");
            }
        }catch (SQLException e){
            pstmt.close();
            connection.close();
        }

        if(superType != null){
            return true;
        }
        return false;

    }

    public String getIdOfEntityInstance(String paramFile, String path, String tenantVar, String tenantPreVar)
            throws JSONException, IOException {
        ReadProperties param = new ReadProperties(paramFile);
        prePro.setTenant(tenantVar, tenantPreVar);
        String tenantPrefix = prePro.getTenantPrefix();
        String tenantId = prePro.getTenant();
        String token = oAuth.authenticateUser(basicUsername, basicPassword, paramFile, tenantId);
        String entityName = param.getProperty("entityName");
        String entityInstanceName = param.getProperty("entityInstanceName");
        System.out.println(entityName);

        String id = tenantPrefix + "." + param.getProperty("entityName");

        RestAssured.urlEncodingEnabled = true;
        Response res = given().baseUri(entityURI).contentType("application/json")
                .auth().oauth2(token)
                .log().all()
                .get(path + "?type=" + id + "&filter=name eq '" + entityInstanceName + "'");

        String response = res.getBody().asString();

        System.out.println("-------------------------"+response);

        if(response.isEmpty() || response.contains("Insufficient scope for this resource") || response.contains("7045") || response.contains("7028")){
            return "";
        }
        JSONArray jo = new JSONArray(response);
        return jo.getJSONObject(0).getString("id");
    }

    public String getIdOfEntityInstance(String paramFile, String path)
            throws JSONException, IOException {
        return getIdOfEntityInstance(paramFile, path, null, null);
    }
}
