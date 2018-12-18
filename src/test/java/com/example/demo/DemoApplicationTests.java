package com.example.demo;

import static org.junit.Assert.assertEquals;

// import com.example.demo.entity.Tenant;
// import com.example.demo.repository.TenantRepository;
import com.example.demo.repository.TenantRepository;
import com.example.demo.service.TypeService;
import com.example.demo.service.TenantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories("com.example.demo.repository")
public class DemoApplicationTests {

	@Autowired
	TenantService tenantService;

	@Autowired
	TenantRepository tenantRepository;

	@Autowired
	TypeService typeService;

	@Autowired


	@Test
    public void setUp(){

		// tenant
		// String id = tenantService.getIdByIdentityId("Tenant15");
		// System.out.println(id);
    	// System.out.println("\n delete tenant");
	    // tenantService.deleteTenantByIdentityId("Tenant15");
		//
    	// tenantService.deleteTenantByTenantId(id);
		//
		// System.out.println(tenantService.getIdByIdentityId("Tenant15"));

		// types
		String psId = typeService.getIdByPsTypeId("Ten2.propsetStatic8");
    	System.out.println(psId);
		typeService.deletePsByPsTypeId("Ten2.propsetStatic8");
		typeService.deletePropertyByPsId(psId);
		System.out.println(typeService.getIdByPsTypeId("Ten2.propsetStatic8"));

		String etTypeId = "Ten2.PublicTen2ET12";
		String etId = typeService.getEtIdByEtTypeId(etTypeId);
    	System.out.println(etId);
    	typeService.deleteEtByEtId(etTypeId);
    	typeService.deleteEtPropByEtId(etId);
    	System.out.println(typeService.getEtIdByEtTypeId(etTypeId));

    	String dynamicTableName = typeService.getTableNameByEtTypeId(etTypeId);
    	System.out.println(dynamicTableName);
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

