package com.ruoyi.web.controller.system;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.VistingPerson;
import com.ruoyi.system.service.IVistingPersonService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 来访人信息Controller
 * 
 * @author jaren
 * @date 2020-10-14
 */
@RestController
@RequestMapping("/system/Vistingperson")
public class VistingPersonController extends BaseController
{
    @Autowired
    private IVistingPersonService vistingPersonService;

    /**
     * 查询来访人信息列表
     */
   // @PreAuthorize("@ss.hasPermi('system:Vistingperson:list')")
    @GetMapping("/list")
    public TableDataInfo list(VistingPerson vistingPerson)
    {
        startPage();
        List<VistingPerson> list = vistingPersonService.selectVistingPersonList(vistingPerson);
        return getDataTable(list);
    }

    /**
     * 导出来访人信息列表
     */
  //  @PreAuthorize("@ss.hasPermi('system:Vistingperson:export')")
    @Log(title = "来访人信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(VistingPerson vistingPerson)
    {
        List<VistingPerson> list = vistingPersonService.selectVistingPersonList(vistingPerson);
        ExcelUtil<VistingPerson> util = new ExcelUtil<VistingPerson>(VistingPerson.class);
        return util.exportExcel(list, "Vistingperson");
    }

    /**
     * 获取来访人信息详细信息
     */
   // @PreAuthorize("@ss.hasPermi('system:Vistingperson:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(vistingPersonService.selectVistingPersonById(id));
    }

    @GetMapping(value = "/user")
    public AjaxResult getUserInfo(@RequestParam("id") Long id)
    {
        return AjaxResult.success(vistingPersonService.selectUserInfoByPid(id));
    }

    /**
     * 新增来访人信息
     */
   // @PreAuthorize("@ss.hasPermi('system:Vistingperson:add')")
    @Log(title = "来访人信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VistingPerson vistingPerson)
    {
        return AjaxResult.success(vistingPersonService.insertVistingPerson(vistingPerson));
    }

    /**
     * 修改来访人信息
     */
   // @PreAuthorize("@ss.hasPermi('system:Vistingperson:edit')")
    @Log(title = "来访人信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VistingPerson vistingPerson)
    {
        return toAjax(vistingPersonService.updateVistingPerson(vistingPerson));
    }

    /**
     * 删除来访人信息
     */
   // @PreAuthorize("@ss.hasPermi('system:Vistingperson:remove')")
    @Log(title = "来访人信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(vistingPersonService.deleteVistingPersonByIds(ids));
    }
}
