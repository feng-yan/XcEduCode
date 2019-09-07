package com.xuecheng.manage_cms.dao;

import com.xuecheng.manage_cms.service.PageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-09-12 18:11
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class PageServiceTest {

    @Autowired
    PageService pageService;

    /**
     * 页面Id 5d3d662360288823d0257765
     *
     * 页面 dataUrl: http://localhost:31001/cms/config/getmodel/5a791725dd573c3574ee333f
     * 页面templateID : 5d4016530024bc0e48b8164b  --> 对应cms_template中的_id
     *
     * cms_template: templateFielId  5d4006000024bc08f88d52 ----> 对应fs_files的id
     *
     *   s_files的id 即为  fs.chunks 中的files_id
     *   找到chunks 就找到了模版
     */
    @Test
    public void testGetPageHtml(){

        String pageHtml = pageService.getPageHtml("5d3d662360288823d0257765");
        System.out.println(pageHtml);


    }

}
