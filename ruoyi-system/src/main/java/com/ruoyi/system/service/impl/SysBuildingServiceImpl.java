package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysBuildingMapper;
import com.ruoyi.system.domain.SysBuilding;
import com.ruoyi.system.service.ISysBuildingService;

/**
 * 楼栋信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-11
 */
@Service
public class SysBuildingServiceImpl implements ISysBuildingService 
{
    @Autowired
    private SysBuildingMapper sysBuildingMapper;

    /**
     * 查询楼栋信息
     * 
     * @param id 楼栋信息ID
     * @return 楼栋信息
     */
    @Override
    public SysBuilding selectSysBuildingById(Long id)
    {
        return sysBuildingMapper.selectSysBuildingById(id);
    }

    @Override
    public List<SysBuilding> selectSysBuildingAllDate(SysBuilding sysBuilding) {
        return sysBuildingMapper.selectSysBuildingAllDate(sysBuilding);
    }

    /**
     * 查询楼栋信息列表
     * 
     * @param sysBuilding 楼栋信息
     * @return 楼栋信息
     */
    @Override
    public List<SysBuilding> selectSysBuildingList(SysBuilding sysBuilding)
    {
        return sysBuildingMapper.selectSysBuildingList(sysBuilding);
    }

    /**
     * 新增楼栋信息
     * 
     * @param sysBuilding 楼栋信息
     * @return 结果
     */
    @Override
    public int insertSysBuilding(SysBuilding sysBuilding)
    {
        return sysBuildingMapper.insertSysBuilding(sysBuilding);
    }

    /**
     * 修改楼栋信息
     * 
     * @param sysBuilding 楼栋信息
     * @return 结果
     */
    @Override
    public int updateSysBuilding(SysBuilding sysBuilding)
    {
        return sysBuildingMapper.updateSysBuilding(sysBuilding);
    }

    /**
     * 批量删除楼栋信息
     * 
     * @param ids 需要删除的楼栋信息ID
     * @return 结果
     */
    @Override
    public int deleteSysBuildingByIds(Long[] ids)
    {
        return sysBuildingMapper.deleteSysBuildingByIds(ids);
    }

    /**
     * 删除楼栋信息信息
     * 
     * @param id 楼栋信息ID
     * @return 结果
     */
    @Override
    public int deleteSysBuildingById(Long id)
    {
        return sysBuildingMapper.deleteSysBuildingById(id);
    }
}
