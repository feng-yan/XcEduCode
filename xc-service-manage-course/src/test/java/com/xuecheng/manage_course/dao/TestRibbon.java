package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRibbon {

    @Autowired
    RestTemplate restTemplate;

    //负载均衡调用
    @Test
    public void testRibbon() {
        //服务id
        String serviceId = "XC-SERVICE-MANAGE-CMS";
        //  for (int i = 0; i < 10; i++) {

        //通过服务id调用
//            ResponseEntity<CmsPage> forEntity = restTemplate.getForEntity("http://" + serviceId
//                    + "/cms/page/get/5d3d662360288823d0257765", CmsPage.class);

        ResponseEntity<CmsPageResult> forEntity = restTemplate.getForEntity("http://" + serviceId + "/cms/page/get/5d3d662360288823d0257765", CmsPageResult.class);
        CmsPageResult cmsPage = forEntity.getBody();
        System.err.println(cmsPage.getCmsPage());
        //   }
    }


}
