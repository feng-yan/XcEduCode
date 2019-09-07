package com.xuecheng.controller;

import com.xuecheng.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RequestMapping("/freemarker")
@Controller
public class FreemarkerCourseController {
    @Autowired
    RestTemplate restTemplate;

    /**
     * 根据模版 id  以及 模版 生成页面
     *
     * @param map
     * @return
     */
    @RequestMapping("/course")
    public String courser(Map<String, Object> map) {

        String dataUrl = "http://localhost:31200/course/courseview/4028e58161bcf7f40161bcf8b77c0000";
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(dataUrl, Map.class);

        Map body = forEntity.getBody();
       // map.put("model", body);// 这里注意, 笔记上写错了.应该直接将结果放到 map 中,
        map.putAll(body);
        return "course";
    }


}