package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.SysRepair;
import com.ruoyi.system.service.ISysRepairService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 维修设备Controller
 * 
 * @author jaren
 * @date 2020-10-14
 */
@RestController
@RequestMapping("/system/repair")
public class SysRepairController extends BaseController
{
    @Autowired
    private ISysRepairService sysRepairService;

    /**
     * 查询维修设备列表
     */
    @PreAuthorize("@ss.hasPermi('system:repair:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysRepair sysRepair)
    {
        startPage();
        List<SysRepair> list = sysRepairService.selectSysRepairList(sysRepair);
        return getDataTable(list);
    }

    /**
     * 导出维修设备列表
     */
    @PreAuthorize("@ss.hasPermi('system:repair:export')")
    @Log(title = "维修设备", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysRepair sysRepair)
    {
        List<SysRepair> list = sysRepairService.selectSysRepairList(sysRepair);
        ExcelUtil<SysRepair> util = new ExcelUtil<SysRepair>(SysRepair.class);
        return util.exportExcel(list, "repair");
    }

    /**
     * 获取维修设备详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:repair:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysRepairService.selectSysRepairById(id));
    }

    /**
     * 新增维修设备
     */
    @PreAuthorize("@ss.hasPermi('system:repair:add')")
    @Log(title = "维修设备", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRepair sysRepair)
    {
        return toAjax(sysRepairService.insertSysRepair(sysRepair));
    }

    /**
     * 修改维修设备
     */
    @PreAuthorize("@ss.hasPermi('system:repair:edit')")
    @Log(title = "维修设备", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRepair sysRepair)
    {
        return toAjax(sysRepairService.updateSysRepair(sysRepair));
    }

    /**
     * 删除维修设备
     */
    @PreAuthorize("@ss.hasPermi('system:repair:remove')")
    @Log(title = "维修设备", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysRepairService.deleteSysRepairByIds(ids));
    }
}
