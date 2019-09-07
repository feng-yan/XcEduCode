package com.xuecheng.api.cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.domain.course.response.CmsPostPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "cms页面管理接口", description = "cms页面管理接口，提供页面的增、删、改、查")
public interface CmsPageControllerApi {

    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "int"),// paramType 参数放在哪个地方. path 一般用于restful;  query 一般是 ?name=zs
                    @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "path", dataType = "int")
            }
    )
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);


    @ApiOperation("添加页面")
    public CmsPageResult add(CmsPage cmsPage);



    @ApiOperation("通过ID查询页面")
    public CmsPageResult findById(String id);


    @ApiOperation("修改页面")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "id", value = "页面id", required = true, paramType = "path", dataType = "string"),
            }
    )
    public CmsPageResult edit(String id,CmsPage cmsPage);




    @ApiOperation("通过ID删除页面")
    public ResponseResult delete(String id);



    @ApiOperation("发布页面")
    public ResponseResult post(String pageId);


    /**
     * 页面预览时报错页面的方法
     * @param cmsPage
     * @return
     */
    @ApiOperation("保存页面")
    public CmsPageResult save(CmsPage cmsPage);


    @ApiOperation("一键发布页面")
    public CmsPostPageResult postPageQuick(CmsPage cmsPage);

}

