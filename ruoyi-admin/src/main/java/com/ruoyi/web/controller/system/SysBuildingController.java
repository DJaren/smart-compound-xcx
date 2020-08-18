package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.system.domain.SysBuilding;
import com.ruoyi.system.service.ISysBuildingService;
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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 楼栋信息Controller
 * 
 * @author ruoyi
 * @date 2020-08-11
 */
@RestController
@RequestMapping("/system/building")
public class SysBuildingController extends BaseController
{
    @Autowired
    private ISysBuildingService sysBuildingService;

    /**
     * 查询楼栋信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:building:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysBuilding sysBuilding)
    {
        startPage();
        List<SysBuilding> list = sysBuildingService.selectSysBuildingList(sysBuilding);
        return getDataTable(list);
    }

    /**
     * 查询楼栋信息列表
     */
    @GetMapping("")
    public AjaxResult buildings(SysBuilding sysBuilding)
    {
        List<SysBuilding> list = sysBuildingService.selectSysBuildingList(sysBuilding);
        return AjaxResult.success(list);
    }

    /**
     * 导出楼栋信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:building:export')")
    @Log(title = "楼栋信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysBuilding sysBuilding)
    {
        List<SysBuilding> list = sysBuildingService.selectSysBuildingList(sysBuilding);
        ExcelUtil<SysBuilding> util = new ExcelUtil<SysBuilding>(SysBuilding.class);
        return util.exportExcel(list, "building");
    }

    /**
     * 获取楼栋信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:building:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysBuildingService.selectSysBuildingById(id));
    }

    /**
     * 新增楼栋信息
     */
    @PreAuthorize("@ss.hasPermi('system:building:add')")
    @Log(title = "楼栋信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysBuilding sysBuilding)
    {
        return toAjax(sysBuildingService.insertSysBuilding(sysBuilding));
    }

    /**
     * 修改楼栋信息
     */
    @PreAuthorize("@ss.hasPermi('system:building:edit')")
    @Log(title = "楼栋信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysBuilding sysBuilding)
    {
        return toAjax(sysBuildingService.updateSysBuilding(sysBuilding));
    }

    /**
     * 删除楼栋信息
     */
    @PreAuthorize("@ss.hasPermi('system:building:remove')")
    @Log(title = "楼栋信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysBuildingService.deleteSysBuildingByIds(ids));
    }
}
