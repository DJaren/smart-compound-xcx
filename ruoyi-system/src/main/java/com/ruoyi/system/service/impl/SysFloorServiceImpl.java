package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysFloorMapper;
import com.ruoyi.system.domain.SysFloor;
import com.ruoyi.system.service.ISysFloorService;

/**
 * 楼层信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-11
 */
@Service
public class SysFloorServiceImpl implements ISysFloorService 
{
    @Autowired
    private SysFloorMapper sysFloorMapper;

    /**
     * 查询楼层信息
     * 
     * @param id 楼层信息ID
     * @return 楼层信息
     */
    @Override
    public SysFloor selectSysFloorById(Long id)
    {
        return sysFloorMapper.selectSysFloorById(id);
    }

    /**
     * 查询楼层信息列表
     * 
     * @param sysFloor 楼层信息
     * @return 楼层信息
     */
    @Override
    public List<SysFloor> selectSysFloorList(SysFloor sysFloor)
    {
        return sysFloorMapper.selectSysFloorList(sysFloor);
    }

    /**
     * 新增楼层信息
     * 
     * @param sysFloor 楼层信息
     * @return 结果
     */
    @Override
    public int insertSysFloor(SysFloor sysFloor)
    {
        return sysFloorMapper.insertSysFloor(sysFloor);
    }

    /**
     * 修改楼层信息
     * 
     * @param sysFloor 楼层信息
     * @return 结果
     */
    @Override
    public int updateSysFloor(SysFloor sysFloor)
    {
        return sysFloorMapper.updateSysFloor(sysFloor);
    }

    /**
     * 批量删除楼层信息
     * 
     * @param ids 需要删除的楼层信息ID
     * @return 结果
     */
    @Override
    public int deleteSysFloorByIds(Long[] ids)
    {
        return sysFloorMapper.deleteSysFloorByIds(ids);
    }

    /**
     * 删除楼层信息信息
     * 
     * @param id 楼层信息ID
     * @return 结果
     */
    @Override
    public int deleteSysFloorById(Long id)
    {
        return sysFloorMapper.deleteSysFloorById(id);
    }
}
