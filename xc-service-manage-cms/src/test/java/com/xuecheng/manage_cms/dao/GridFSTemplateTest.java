package com.xuecheng.manage_cms.dao;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GridFSTemplateTest {


    @Autowired
    GridFsTemplate gridFsTemplate;

    // 保存文件
    @Test
    public void testGridFs() throws FileNotFoundException {
        //要存储的文件
        File file = new File("C:\\CODE\\JAVA\\xczx\\XcEduCode\\freemaker-test\\src\\main\\resources\\templates\\index_banner.ftl");
        //定义输入流
        FileInputStream inputStram = new FileInputStream(file);
        //向GridFS存储文件
        ObjectId objectId = gridFsTemplate.store(inputStram, "轮播图测试文件01", "");
        //得到文件ID
        String fileId = objectId.toString();

        System.err.println("Object ID" + objectId);
    }


    @Autowired
    GridFSBucket gridFSBucket;


    // 根据id 查询文件
    @Test
    public void queryFile() throws IOException {

        // 插入文件的Id
        String fileId = "5d4006000024bc08f88d5232";
        //根据id查询文件
        GridFSFile gridFSFile =
                gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId)));
        //打开下载流对象
        GridFSDownloadStream gridFSDownloadStream =
                gridFSBucket.openDownloadStream(gridFSFile.getObjectId());
        //创建gridFsResource，用于获取流对象
        GridFsResource gridFsResource = new GridFsResource(gridFSFile, gridFSDownloadStream);
        //获取流中的数据
        String s = IOUtils.toString(gridFsResource.getInputStream(), "UTF-8");

        System.err.println(s);

    }


    //删除文件
    @Test
    public void testDelFile() throws IOException {
        //根据文件id删除fs.files和fs.chunks中的记录
        gridFsTemplate.delete(Query.query(Criteria.where("_id").is("5d4006000024bc08f88d5232")));
    }


    //存储 course模版
    @Test
    public void testStore2() throws FileNotFoundException {

        //要存储的文件
        File file = new File("C:\\CODE\\JAVA\\xczx\\XcEduCode\\freemaker-test\\src\\main\\resources\\templates\\course.ftl");
        //定义输入流
        FileInputStream inputStram = new FileInputStream(file);
        //向GridFS存储文件
        ObjectId objectId = gridFsTemplate.store(inputStram, "课程详情预览模版", "");
        //得到文件ID
        String fileId = objectId.toString();

        System.err.println("Object ID" + objectId);//5d563d3959ae0131a4fddcf0
    }

}
