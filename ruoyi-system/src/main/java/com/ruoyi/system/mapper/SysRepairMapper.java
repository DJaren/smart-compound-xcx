package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysRepair;

/**
 * 维修设备Mapper接口
 * 
 * @author jaren
 * @date 2020-10-14
 */
public interface SysRepairMapper 
{
    /**
     * 查询维修设备
     * 
     * @param id 维修设备ID
     * @return 维修设备
     */
    public SysRepair selectSysRepairById(Long id);

    /**
     * 查询维修设备列表
     * 
     * @param sysRepair 维修设备
     * @return 维修设备集合
     */
    public List<SysRepair> selectSysRepairList(SysRepair sysRepair);

    /**
     * 新增维修设备
     * 
     * @param sysRepair 维修设备
     * @return 结果
     */
    public int insertSysRepair(SysRepair sysRepair);

    /**
     * 修改维修设备
     * 
     * @param sysRepair 维修设备
     * @return 结果
     */
    public int updateSysRepair(SysRepair sysRepair);

    /**
     * 删除维修设备
     * 
     * @param id 维修设备ID
     * @return 结果
     */
    public int deleteSysRepairById(Long id);

    /**
     * 批量删除维修设备
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysRepairByIds(Long[] ids);
}
