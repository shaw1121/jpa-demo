package com.siemens.mindsphere.iotmd.integtest;

import static org.junit.Assert.assertEquals;

// import com.example.demo.entity.Tenant;
// import TenantRepository;
import com.siemens.mindsphere.iotmd.integtest.repository.PropSetDefRepository;
import com.siemens.mindsphere.iotmd.integtest.repository.TenantRepository;
import com.siemens.mindsphere.iotmd.integtest.service.CleanupTestDataService;
import com.siemens.mindsphere.iotmd.integtest.service.EntityService;
import com.siemens.mindsphere.iotmd.integtest.service.TypeService;
import com.siemens.mindsphere.iotmd.integtest.service.TenantService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

// @RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories("com.example.demo.repository")
public class DemoApplicationTests extends AbstractTestNGSpringContextTests {

	@Autowired
	TenantService tenantService;

	@Autowired
	TenantRepository tenantRepository;

	@Autowired
	CleanupTestDataService cleanupTestDataService;

	@Autowired
	TypeService typeService;

	@Autowired
	EntityService entityService;

	@Autowired
	PropSetDefRepository propSetDefRepository;

	@Test
    public void setUp(){

		// tenant
		// String identityId = "Tenant14";
    	// System.out.println("\n delete tenant");
    	// tenantRepository.deleteByIdentityId(identityId);

    	String psTypeId = "Ten1.propset3";
    	propSetDefRepository.deleteByPsTypeId(psTypeId);

	    // tenantService.deleteTenantByIdentityId(identityId);

    	// // tenantService.deleteTenantByTenantId(id);
		//
		// System.out.println(tenantService.getIdByIdentityId(identityId));
		//
		// // entity
		// String etTypeId = "Ten1.City";
		// List entityIdList = entityService.getEntityIdByEtTypeId(etTypeId);
    	// System.out.println(entityIdList);
		//
    	// for (int i = 0; i < entityIdList.size(); i++) {
      	// 	System.out.println(entityIdList.get(i));
      	// 	// entityService.deleteEntityByEntityId(entityIdList.get(i).toString());
		// }
		//
		// entityService.deleteEntityByEtTypeId(etTypeId);
		//
		// String tableName = typeService.getTableNameByEtTypeId(etTypeId);
		// System.out.println(tableName);
		// // delete data from dynamic table here !!!




		// // types
		// String psTypeId = "Ten2.propsetDynamic65";
		// String psId = typeService.getIdByPsTypeId(psTypeId);
    	// System.out.println(psId);
		// typeService.deletePsByPsTypeId(psTypeId);
		// typeService.deletePropertyByPsId(psId);
		// System.out.println(typeService.getIdByPsTypeId(psTypeId));
		// //
		// String etTypeId = "Ten2.PublicTen2ET27";
		// String etId = typeService.getEtIdByEtTypeId(etTypeId);
    	// System.out.println(etId);
    	// typeService.deleteEtByEtId(etTypeId);
    	// typeService.deleteEtPropByEtId(etId);
    	// System.out.println(typeService.getEtIdByEtTypeId(etTypeId));
		//
    	// String dynamicTableName = typeService.getTableNameByEtTypeId(etTypeId);
    	// System.out.println(dynamicTableName);

		// drop dynamic table here!!!
    }

	// @Before
	// public void setUp(){
	// 	userRepository.save(new User("deng", "deng@siemnes.com"));
	// 	userRepository.save(new User("yin", "yinc@qq.com"));
	// 	userRepository.save(new User("hao", "hao@siemenc.com"));
	// }

	// @After
	// public void cleanup(){
	// 	userRepository.deleteAll();
	// }
	//
	// @Test
	// public void contextLoads() {
	// 	User originalUser = new User("jerry", "xie.com");
	// 	userRepository.save(originalUser);
	// 	User createdUser = userRepository.findByName("jerry");
	//
	// 	assertEquals(originalUser.getName(), createdUser.getName());
	// }



}

