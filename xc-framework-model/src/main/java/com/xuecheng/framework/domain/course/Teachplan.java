package com.xuecheng.framework.domain.course;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@ToString
@Entity
@Table(name = "teachplan")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")//使用uuid 作为主键
public class Teachplan implements Serializable {

    private static final long serialVersionUID = -916357110051689485L;
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    private String pname;
    private String parentid;
    private String grade;
    @ApiModelProperty(value = "课程类型 1 视频 2 文档", example = "1")
    private String ptype;
    private String description;
    private String courseid;
    @ApiModelProperty(value = "课程状态", example = "1")
    private String status;
    private Integer orderby;
    private Double timelength;
    @ApiModelProperty(value = "是否试学", example = "1")
    private String trylearn;


  //  private List<Teachplan> teachplanList;

}
