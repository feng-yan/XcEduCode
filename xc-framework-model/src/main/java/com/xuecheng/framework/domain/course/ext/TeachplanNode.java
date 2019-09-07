package com.xuecheng.framework.domain.course.ext;

import com.xuecheng.framework.domain.course.Teachplan;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@ToString(callSuper = true)
@NoArgsConstructor
public class TeachplanNode extends Teachplan {


    List<TeachplanNode> children;

//    @Override
//    public String toString() {
//        return super.toString()+ "TeachplanNode{" +
//                "children=" + children +
//                '}';
//    }
//
    //媒资信息   这两个属性第14天用
    private String mediaId;

    private String mediaFileOriginalName;


}
