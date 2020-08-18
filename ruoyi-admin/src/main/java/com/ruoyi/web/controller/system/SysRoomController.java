package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.Map;

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
import com.ruoyi.system.domain.SysRoom;
import com.ruoyi.system.service.ISysRoomService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 房间管理Controller
 * 
 * @author ruoyi
 * @date 2020-08-12
 */
@RestController
@RequestMapping("/system/room")
public class SysRoomController extends BaseController
{
    @Autowired
    private ISysRoomService sysRoomService;

    /**
     * 查询房间管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:room:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysRoom sysRoom)
    {
        startPage();
        List<Map<String,Object>> list = sysRoomService.selectSysRoomList(sysRoom);
        return getDataTable(list);
    }

//    /**
//     * 导出房间管理列表
//     */
//    @PreAuthorize("@ss.hasPermi('system:room:export')")
//    @Log(title = "房间管理", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(SysRoom sysRoom)
//    {
//        List<Map<String,Object>> list = sysRoomService.selectSysRoomList(sysRoom);
//        ExcelUtil<SysRoom> util = new ExcelUtil<SysRoom>(SysRoom.class);
//        return util.exportExcel(list, "room");
//    }

    /**
     * 获取房间管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:room:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysRoomService.selectSysRoomById(id));
    }

    /**
     * 新增房间管理
     */
    @PreAuthorize("@ss.hasPermi('system:room:add')")
    @Log(title = "房间管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysRoom sysRoom)
    {
        return toAjax(sysRoomService.insertSysRoom(sysRoom));
    }

    /**
     * 修改房间管理
     */
    @PreAuthorize("@ss.hasPermi('system:room:edit')")
    @Log(title = "房间管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRoom sysRoom)
    {
        return toAjax(sysRoomService.updateSysRoom(sysRoom));
    }

    /**
     * 删除房间管理
     */
    @PreAuthorize("@ss.hasPermi('system:room:remove')")
    @Log(title = "房间管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysRoomService.deleteSysRoomByIds(ids));
    }
}
