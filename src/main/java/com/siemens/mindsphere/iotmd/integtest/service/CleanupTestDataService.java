package com.siemens.mindsphere.iotmd.integtest.service;

import com.siemens.mindsphere.iotmd.integtest.util.FileList;
import com.siemens.mindsphere.iotmd.integtest.util.ReadProperties;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CleanupTestDataService {

    @Autowired
    TenantService tenantService;

    public void deleteTenant() {

        List<String> tenantList = FileList.getFileList("test-input/tenant");
        for (String tenant : tenantList) {
            ReadProperties param = new ReadProperties(tenant);
            String tenantIdentityId = param.getProperty("\"identityId\"");
            tenantService.deleteTenantByIdentityId(tenantIdentityId);
        }
    }
}
