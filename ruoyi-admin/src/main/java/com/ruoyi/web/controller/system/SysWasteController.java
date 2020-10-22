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
import com.ruoyi.system.domain.SysWaste;
import com.ruoyi.system.service.ISysWasteService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 大件垃圾Controller
 * 
 * @author ruoyi
 * @date 2020-10-15
 */
@RestController
@RequestMapping("/system/waste")
public class SysWasteController extends BaseController
{
    @Autowired
    private ISysWasteService sysWasteService;

    /**
     * 查询大件垃圾列表
     */
    @PreAuthorize("@ss.hasPermi('system:waste:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysWaste sysWaste)
    {
        startPage();
        List<SysWaste> list = sysWasteService.selectSysWasteList(sysWaste);
        return getDataTable(list);
    }

    /**
     * 导出大件垃圾列表
     */
    @PreAuthorize("@ss.hasPermi('system:waste:export')")
    @Log(title = "大件垃圾", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysWaste sysWaste)
    {
        List<SysWaste> list = sysWasteService.selectSysWasteList(sysWaste);
        ExcelUtil<SysWaste> util = new ExcelUtil<SysWaste>(SysWaste.class);
        return util.exportExcel(list, "waste");
    }

    /**
     * 获取大件垃圾详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:waste:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysWasteService.selectSysWasteById(id));
    }

    /**
     * 新增大件垃圾
     */
    @PreAuthorize("@ss.hasPermi('system:waste:add')")
    @Log(title = "大件垃圾", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysWaste sysWaste)
    {
        return toAjax(sysWasteService.insertSysWaste(sysWaste));
    }

    /**
     * 修改大件垃圾
     */
    @PreAuthorize("@ss.hasPermi('system:waste:edit')")
    @Log(title = "大件垃圾", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysWaste sysWaste)
    {
        return toAjax(sysWasteService.updateSysWaste(sysWaste));
    }

    /**
     * 删除大件垃圾
     */
    @PreAuthorize("@ss.hasPermi('system:waste:remove')")
    @Log(title = "大件垃圾", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysWasteService.deleteSysWasteByIds(ids));
    }
}
