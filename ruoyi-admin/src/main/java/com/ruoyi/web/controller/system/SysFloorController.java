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
import com.ruoyi.system.domain.SysFloor;
import com.ruoyi.system.service.ISysFloorService;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 楼层信息Controller
 * 
 * @author ruoyi
 * @date 2020-08-11
 */
@RestController
@RequestMapping("/system/floor")
public class SysFloorController extends BaseController
{
    @Autowired
    private ISysFloorService sysFloorService;

    /**
     * 查询楼层信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:floor:list')")
    @GetMapping("/list")
    public AjaxResult list(SysFloor sysFloor)
    {
        List<SysFloor> list = sysFloorService.selectSysFloorList(sysFloor);
        return AjaxResult.success(list);
    }

    /**
     * 导出楼层信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:floor:export')")
    @Log(title = "楼层信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysFloor sysFloor)
    {
        List<SysFloor> list = sysFloorService.selectSysFloorList(sysFloor);
        ExcelUtil<SysFloor> util = new ExcelUtil<SysFloor>(SysFloor.class);
        return util.exportExcel(list, "floor");
    }

    /**
     * 获取楼层信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:floor:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysFloorService.selectSysFloorById(id));
    }

    /**
     * 新增楼层信息
     */
    @PreAuthorize("@ss.hasPermi('system:floor:add')")
    @Log(title = "楼层信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysFloor sysFloor)
    {
        return toAjax(sysFloorService.insertSysFloor(sysFloor));
    }

    /**
     * 修改楼层信息
     */
    @PreAuthorize("@ss.hasPermi('system:floor:edit')")
    @Log(title = "楼层信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysFloor sysFloor)
    {
        return toAjax(sysFloorService.updateSysFloor(sysFloor));
    }

    /**
     * 删除楼层信息
     */
    @PreAuthorize("@ss.hasPermi('system:floor:remove')")
    @Log(title = "楼层信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysFloorService.deleteSysFloorByIds(ids));
    }
}
