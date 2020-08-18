package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysRoomMapper;
import com.ruoyi.system.domain.SysRoom;
import com.ruoyi.system.service.ISysRoomService;

/**
 * 房间管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-08-12
 */
@Service
public class SysRoomServiceImpl implements ISysRoomService 
{
    @Autowired
    private SysRoomMapper sysRoomMapper;

    /**
     * 查询房间管理
     * 
     * @param id 房间管理ID
     * @return 房间管理
     */
    @Override
    public SysRoom selectSysRoomById(Long id)
    {
        return sysRoomMapper.selectSysRoomById(id);
    }

    /**
     * 查询房间管理列表
     * 
     * @param sysRoom 房间管理
     * @return 房间管理
     */
    @Override
    public List<SysRoom> selectSysRoomList(SysRoom sysRoom)
    {
        return sysRoomMapper.selectSysRoomList(sysRoom);
    }

    /**
     * 新增房间管理
     * 
     * @param sysRoom 房间管理
     * @return 结果
     */
    @Override
    public int insertSysRoom(SysRoom sysRoom)
    {
        return sysRoomMapper.insertSysRoom(sysRoom);
    }

    /**
     * 修改房间管理
     * 
     * @param sysRoom 房间管理
     * @return 结果
     */
    @Override
    public int updateSysRoom(SysRoom sysRoom)
    {
        return sysRoomMapper.updateSysRoom(sysRoom);
    }

    /**
     * 批量删除房间管理
     * 
     * @param ids 需要删除的房间管理ID
     * @return 结果
     */
    @Override
    public int deleteSysRoomByIds(Long[] ids)
    {
        return sysRoomMapper.deleteSysRoomByIds(ids);
    }

    /**
     * 删除房间管理信息
     * 
     * @param id 房间管理ID
     * @return 结果
     */
    @Override
    public int deleteSysRoomById(Long id)
    {
        return sysRoomMapper.deleteSysRoomById(id);
    }
}
