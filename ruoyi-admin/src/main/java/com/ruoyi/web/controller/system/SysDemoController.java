package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.SysBuilding;
import com.ruoyi.system.domain.SysConfOrder;
import com.ruoyi.system.service.ISysBuildingService;
import com.ruoyi.system.service.ISysConfOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.core.controller.BaseController;
import java.util.List;
import java.util.Map;

@Api("测试会议预约信息demo")
@RestController
@RequestMapping("/test/demo1")
public class SysDemoController extends BaseController {
    @Autowired
    private ISysBuildingService sysBuildingService;

    @Autowired
    private ISysConfOrderService sysConfOrderService;

    /**
     * 查询楼栋信息列表
     */
    @ApiOperation("获取三级列表信息")
    @GetMapping("/listThreeConf")
    public AjaxResult listThree() {
        List<SysBuilding> list = sysBuildingService.selectSysBuildingAllDate(null);
        return AjaxResult.success(list);
    }

    /**
     * 查询会议室预约列表
     */
    @ApiOperation("获取会议室预约信息列表")
    @GetMapping("/listConfOrder")
    public AjaxResult listConfOrder() {
        List<Map<String,Object>> list = sysConfOrderService.selectSysConfOrderList(null);
        return AjaxResult.success(list);
    }

    /**
     * 获取会议室预约详细信息
     */
    @ApiOperation("按id获取会议室预约详情")
    @ApiImplicitParam(name = "confOrderId",value = "会议预约ID",required = true, dataType = "int", paramType = "path")
    @GetMapping(value = "/getOrder/{confOrderId}")
    public AjaxResult getInfo(@PathVariable("confOrderId") Long confOrderId) {
        return AjaxResult.success(sysConfOrderService.selectSysConfOrderById(confOrderId));
    }

    /**
     * 新增
     */
    @ApiOperation("新增会议室预约信息")
    @PostMapping
    public AjaxResult add(@RequestBody SysConfOrder sysConfOrder) {
        return toAjax(sysConfOrderService.insertSysConfOrder(sysConfOrder));
    }

    /**
     * 修改
     */
    @ApiOperation("修改会议室预约信息")
    @PutMapping
    public AjaxResult edit(@RequestBody SysConfOrder sysConfOrder) {
        return toAjax(sysConfOrderService.updateSysConfOrder(sysConfOrder));
    }

    /**
     * 删除多个
     */
    @ApiOperation("删除会议室预约信息")
    @DeleteMapping("/deleteMulti/{confOrderIds}")
    public AjaxResult remove(@PathVariable Long[] confOrderIds) {
        return toAjax(sysConfOrderService.deleteSysConfOrderByIds(confOrderIds));
    }
    /**
     * 删除单个
     */
    @ApiOperation("删除单个会议室预约信息")
    @DeleteMapping("/deleteOne/{confOrderId}")
    public AjaxResult removeSingle(@PathVariable Long confOrderId) {
        return toAjax(sysConfOrderService.deleteSysConfOrderById(confOrderId));
    }
}
