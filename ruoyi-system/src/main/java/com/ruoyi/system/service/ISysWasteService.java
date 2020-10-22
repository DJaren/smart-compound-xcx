package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysWaste;

/**
 * 大件垃圾Service接口
 * 
 * @author ruoyi
 * @date 2020-10-15
 */
public interface ISysWasteService 
{
    /**
     * 查询大件垃圾
     * 
     * @param id 大件垃圾ID
     * @return 大件垃圾
     */
    public SysWaste selectSysWasteById(Long id);

    /**
     * 查询大件垃圾列表
     * 
     * @param sysWaste 大件垃圾
     * @return 大件垃圾集合
     */
    public List<SysWaste> selectSysWasteList(SysWaste sysWaste);

    /**
     * 新增大件垃圾
     * 
     * @param sysWaste 大件垃圾
     * @return 结果
     */
    public int insertSysWaste(SysWaste sysWaste);

    /**
     * 修改大件垃圾
     * 
     * @param sysWaste 大件垃圾
     * @return 结果
     */
    public int updateSysWaste(SysWaste sysWaste);

    /**
     * 批量删除大件垃圾
     * 
     * @param ids 需要删除的大件垃圾ID
     * @return 结果
     */
    public int deleteSysWasteByIds(Long[] ids);

    /**
     * 删除大件垃圾信息
     * 
     * @param id 大件垃圾ID
     * @return 结果
     */
    public int deleteSysWasteById(Long id);
}
