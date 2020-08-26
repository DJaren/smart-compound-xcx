package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.SysBuilding;
import com.ruoyi.system.service.ISysBuildingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.controller.BaseController;
import java.util.List;

@Api("测试会议预约信息demo")
@RestController
@RequestMapping("/test/demo1")
public class SysDemoController extends BaseController {
    @Autowired
    private ISysBuildingService sysBuildingService;

    /**
     * 查询楼栋信息列表
     */
    @ApiOperation("获取三级列表信息")
    @GetMapping("/test/demo1/list")
    public AjaxResult list()
    {
        List<SysBuilding> list = sysBuildingService.selectSysBuildingAllDate(null);
        return AjaxResult.success(list);
    }

}
