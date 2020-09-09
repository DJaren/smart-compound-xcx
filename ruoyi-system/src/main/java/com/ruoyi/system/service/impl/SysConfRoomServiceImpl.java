package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysConfRoomMapper;
import com.ruoyi.system.domain.SysConfRoom;
import com.ruoyi.system.service.ISysConfRoomService;

/**
 * 会议室Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
@Service
public class SysConfRoomServiceImpl implements ISysConfRoomService 
{
    @Autowired
    private SysConfRoomMapper sysConfRoomMapper;

    /**
     * 查询会议室
     * 
     * @param id 会议室ID
     * @return 会议室
     */
    @Override
    public Map<String,Object> selectSysConfRoomById(Long id)
    {
        return sysConfRoomMapper.selectSysConfRoomById(id);
    }

    /**
     * 查询会议室列表
     * 
     * @param sysConfRoom 会议室
     * @return 会议室
     */
    @Override
    public List<Map<String,Object>> selectSysConfRoomList(SysConfRoom sysConfRoom)
    {
        return sysConfRoomMapper.selectSysConfRoomList(sysConfRoom);
    }

    /**
     * 新增会议室
     * 
     * @param sysConfRoom 会议室
     * @return 结果
     */
    @Override
    public int insertSysConfRoom(Map<String,Object> sysConfRoom)
    {
        return sysConfRoomMapper.insertSysConfRoom(sysConfRoom);
    }

    /**
     * 修改会议室
     * 
     * @param sysConfRoom 会议室
     * @return 结果
     */
    @Override
    public int updateSysConfRoom(SysConfRoom sysConfRoom)
    {
        return sysConfRoomMapper.updateSysConfRoom(sysConfRoom);
    }

    /**
     * 批量删除会议室
     * 
     * @param ids 需要删除的会议室ID
     * @return 结果
     */
    @Override
    public int deleteSysConfRoomByIds(Long[] ids)
    {
        return sysConfRoomMapper.deleteSysConfRoomByIds(ids);
    }

    /**
     * 删除会议室信息
     * 
     * @param id 会议室ID
     * @return 结果
     */
    @Override
    public int deleteSysConfRoomById(Long id)
    {
        return sysConfRoomMapper.deleteSysConfRoomById(id);
    }
}
