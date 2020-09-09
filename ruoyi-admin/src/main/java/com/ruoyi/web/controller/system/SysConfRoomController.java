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
import com.ruoyi.system.domain.SysConfRoom;
import com.ruoyi.system.service.ISysConfRoomService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会议室Controller
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
@RestController
@RequestMapping("/system/confRoom")
public class SysConfRoomController extends BaseController
{
    @Autowired
    private ISysConfRoomService sysConfRoomService;

    /**
     * 查询会议室列表
     */
    @PreAuthorize("@ss.hasPermi('system:confRoom:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysConfRoom sysConfRoom)
    {
        startPage();
        List<Map<String,Object>> list = sysConfRoomService.selectSysConfRoomList(sysConfRoom);
        return getDataTable(list);
    }

//    /**
//     * 导出会议室列表
//     */
//    @PreAuthorize("@ss.hasPermi('system:confRoom:export')")
//    @Log(title = "会议室", businessType = BusinessType.EXPORT)
//    @GetMapping("/export")
//    public AjaxResult export(SysConfRoom sysConfRoom)
//    {
//        List<SysConfRoom> list = sysConfRoomService.selectSysConfRoomList(sysConfRoom);
//        ExcelUtil<SysConfRoom> util = new ExcelUtil<SysConfRoom>(SysConfRoom.class);
//        return util.exportExcel(list, "confRoom");
//    }

    /**
     * 获取会议室详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:confRoom:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysConfRoomService.selectSysConfRoomById(id));
    }

    /**
     * 新增会议室
     */
    @PreAuthorize("@ss.hasPermi('system:confRoom:add')")
    @Log(title = "会议室", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Map<String,Object> sysConfRoom)
    {
        return toAjax(sysConfRoomService.insertSysConfRoom(sysConfRoom));
    }

    /**
     * 修改会议室
     */
    @PreAuthorize("@ss.hasPermi('system:confRoom:edit')")
    @Log(title = "会议室", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysConfRoom sysConfRoom)
    {
        return toAjax(sysConfRoomService.updateSysConfRoom(sysConfRoom));
    }

    /**
     * 删除会议室
     */
    @PreAuthorize("@ss.hasPermi('system:confRoom:remove')")
    @Log(title = "会议室", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysConfRoomService.deleteSysConfRoomByIds(ids));
    }
}
