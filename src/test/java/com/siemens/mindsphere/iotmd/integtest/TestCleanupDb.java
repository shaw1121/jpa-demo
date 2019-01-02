package com.siemens.mindsphere.iotmd.integtest;

import static com.common.restassured.FileList.getFileList;

import com.common.restassured.DeleteOperation;
import com.common.restassured.GetOperation;
import com.common.restassured.JsonWriterAdd;
import com.common.restassured.PostOperation;
import com.common.restassured.PutOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@TestPropertySource(locations = "classpath:test.properties")
@ContextConfiguration(classes = { PutOperation.class, PostOperation.class, DeleteOperation.class, JsonWriterAdd.class, CleanupDb.class })
public class TestCleanupDb extends GetOperation {

    @Autowired
    CleanupDb cleanupDb;

    @Test
    public void setup() {
        System.out.println("setup");
    }

    @BeforeClass()
    public void setUp() throws Exception {

        List<String> entityLists = getFileList("test-input/entities");

        for (String entityList : entityLists) {
            cleanupDb.deleteEntityInstance(entityList, "/entities");
        }

        List<String> typeLists = getFileList("test-input");

        for (String typeList : typeLists) {
            cleanupDb.deleteEntityType(typeList);
            cleanupDb.deletePropertySet(typeList);
        }

        List<String> tenantLists = getFileList("test-input/tenant");
        for (String tenantList : tenantLists) {
            cleanupDb.deleteTenant(tenantList);
        }
    }

}
