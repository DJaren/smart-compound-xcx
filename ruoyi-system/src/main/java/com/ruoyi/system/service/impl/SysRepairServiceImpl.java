package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysRepairMapper;
import com.ruoyi.system.domain.SysRepair;
import com.ruoyi.system.service.ISysRepairService;

/**
 * 维修设备Service业务层处理
 * 
 * @author jaren
 * @date 2020-10-14
 */
@Service
public class SysRepairServiceImpl implements ISysRepairService 
{
    @Autowired
    private SysRepairMapper sysRepairMapper;

    /**
     * 查询维修设备
     * 
     * @param id 维修设备ID
     * @return 维修设备
     */
    @Override
    public SysRepair selectSysRepairById(Long id)
    {
        return sysRepairMapper.selectSysRepairById(id);
    }

    /**
     * 查询维修设备列表
     * 
     * @param sysRepair 维修设备
     * @return 维修设备
     */
    @Override
    public List<SysRepair> selectSysRepairList(SysRepair sysRepair)
    {
        return sysRepairMapper.selectSysRepairList(sysRepair);
    }

    /**
     * 新增维修设备
     * 
     * @param sysRepair 维修设备
     * @return 结果
     */
    @Override
    public int insertSysRepair(SysRepair sysRepair)
    {
        return sysRepairMapper.insertSysRepair(sysRepair);
    }

    /**
     * 修改维修设备
     * 
     * @param sysRepair 维修设备
     * @return 结果
     */
    @Override
    public int updateSysRepair(SysRepair sysRepair)
    {
        return sysRepairMapper.updateSysRepair(sysRepair);
    }

    /**
     * 批量删除维修设备
     * 
     * @param ids 需要删除的维修设备ID
     * @return 结果
     */
    @Override
    public int deleteSysRepairByIds(Long[] ids)
    {
        return sysRepairMapper.deleteSysRepairByIds(ids);
    }

    /**
     * 删除维修设备信息
     * 
     * @param id 维修设备ID
     * @return 结果
     */
    @Override
    public int deleteSysRepairById(Long id)
    {
        return sysRepairMapper.deleteSysRepairById(id);
    }
}
