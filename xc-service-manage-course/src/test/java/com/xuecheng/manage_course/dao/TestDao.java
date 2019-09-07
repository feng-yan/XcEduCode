package com.xuecheng.manage_course.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.CourseMarket;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sound.midi.Soundbank;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDao {
    @Autowired
    CourseBaseRepository courseBaseRepository;

    @Autowired
    CourseMapper courseMapper;// 报错也没问题,正常现象, 想解决的话, 在类上添加一个注解 @Repository 或者 @Component 即可

    @Test
    public void testCourseBaseRepository() {
        Optional<CourseBase> optional = courseBaseRepository.findById("402885816240d276016240f7e5000002");
        if (optional.isPresent()) {
            CourseBase courseBase = optional.get();
            System.out.println(courseBase);
        }

    }

    @Test
    public void testCourseMapper() {
        CourseBase courseBase = courseMapper.findCourseBaseById("402885816240d276016240f7e5000002");
        System.out.println(courseBase);

    }

    @Autowired
    private TeachplanMapper teachplanMapper;

    @Test
    // 测试使用 4028e58161bcf7f40161bcf8b77c0000. 这个数据比较完善
    public void testTeachplanMapper() {
        TeachplanNode selectList = teachplanMapper.selectList("4028e58161bcf7f40161bcf8b77c0000");
        System.err.println(selectList);

    }

    //测试分页
    @Test
    public void testPageHelper() {

        PageHelper.startPage(2, 1);
        CourseListRequest courseListRequest = new CourseListRequest();
        courseListRequest.setCompanyId("2");
        Page<CourseInfo> courseListPage = courseMapper.findCourseListPage(courseListRequest);
        List<CourseInfo> result = courseListPage.getResult();
        System.err.println(courseListPage);
    }

    @Autowired
    CourseMarketRepository courseMarketRepository;

    @Test
    public void testCourseMarker(){
        // 4028e581617f945f01617f9dabc40000

        Optional<CourseMarket> courseMarket = courseMarketRepository.findById("4028e581617f945f01617f9dabc40000");
        CourseMarket market = courseMarket.get();
        System.err.println(market);
    }
}
