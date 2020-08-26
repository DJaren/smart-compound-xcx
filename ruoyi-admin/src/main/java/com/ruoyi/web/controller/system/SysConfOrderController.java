package com.ruoyi.web.controller.system;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysConfOrder;
import com.ruoyi.system.service.ISysConfOrderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会议室预约Controller
 * 
 * @author ruoyi
 * @date 2020-08-25
 */
@RestController
@RequestMapping("/system/order")
public class SysConfOrderController extends BaseController
{
    @Autowired
    private ISysConfOrderService sysConfOrderService;

    /**
     * 查询会议室预约列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysConfOrder sysConfOrder)
    {
        startPage();
        List<SysConfOrder> list = sysConfOrderService.selectSysConfOrderList(sysConfOrder);
        return getDataTable(list);
    }

    /**
     * 导出会议室预约列表
     */
    @PreAuthorize("@ss.hasPermi('system:order:export')")
    @Log(title = "会议室预约", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysConfOrder sysConfOrder)
    {
        List<SysConfOrder> list = sysConfOrderService.selectSysConfOrderList(sysConfOrder);
        ExcelUtil<SysConfOrder> util = new ExcelUtil<SysConfOrder>(SysConfOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 获取会议室预约详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:order:query')")
    @GetMapping(value = "/{confOrderId}")
    public AjaxResult getInfo(@PathVariable("confOrderId") Long confOrderId)
    {
        return AjaxResult.success(sysConfOrderService.selectSysConfOrderById(confOrderId));
    }

    /**
     * 新增会议室预约
     */
    @PreAuthorize("@ss.hasPermi('system:order:add')")
    @Log(title = "会议室预约", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysConfOrder sysConfOrder)
    {
        return toAjax(sysConfOrderService.insertSysConfOrder(sysConfOrder));
    }

    /**
     * 修改会议室预约
     */
    @PreAuthorize("@ss.hasPermi('system:order:edit')")
    @Log(title = "会议室预约", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysConfOrder sysConfOrder)
    {
        return toAjax(sysConfOrderService.updateSysConfOrder(sysConfOrder));
    }

    /**
     * 删除会议室预约
     */
    @PreAuthorize("@ss.hasPermi('system:order:remove')")
    @Log(title = "会议室预约", businessType = BusinessType.DELETE)
	@DeleteMapping("/{confOrderIds}")
    public AjaxResult remove(@PathVariable Long[] confOrderIds)
    {
        return toAjax(sysConfOrderService.deleteSysConfOrderByIds(confOrderIds));
    }
}
