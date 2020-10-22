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
import com.ruoyi.system.domain.SysClear;
import com.ruoyi.system.service.ISysClearService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 打扫卫生Controller
 * 
 * @author jaren
 * @date 2020-10-14
 */
@RestController
@RequestMapping("/system/clear")
public class SysClearController extends BaseController
{
    @Autowired
    private ISysClearService sysClearService;

    /**
     * 查询打扫卫生列表
     */
   // @PreAuthorize("@ss.hasPermi('system:clear:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysClear sysClear)
    {
        startPage();
        List<SysClear> list = sysClearService.selectSysClearList(sysClear);
        return getDataTable(list);
    }

    /**
     * 导出打扫卫生列表
     */
    @PreAuthorize("@ss.hasPermi('system:clear:export')")
    @Log(title = "打扫卫生", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysClear sysClear)
    {
        List<SysClear> list = sysClearService.selectSysClearList(sysClear);
        ExcelUtil<SysClear> util = new ExcelUtil<SysClear>(SysClear.class);
        return util.exportExcel(list, "clear");
    }

    /**
     * 获取打扫卫生详细信息
     */
   // @PreAuthorize("@ss.hasPermi('system:clear:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(sysClearService.selectSysClearById(id));
    }

    /**
     * 新增打扫卫生
     */
    //@PreAuthorize("@ss.hasPermi('system:clear:add')")
    @Log(title = "打扫卫生", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysClear sysClear)
    {
        return toAjax(sysClearService.insertSysClear(sysClear));
    }

    /**
     * 修改打扫卫生
     */
   // @PreAuthorize("@ss.hasPermi('system:clear:edit')")
    @Log(title = "打扫卫生", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysClear sysClear)
    {
        return toAjax(sysClearService.updateSysClear(sysClear));
    }

    /**
     * 删除打扫卫生
     */
    //@PreAuthorize("@ss.hasPermi('system:clear:remove')")
    @Log(title = "打扫卫生", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(sysClearService.deleteSysClearByIds(ids));
    }
}
