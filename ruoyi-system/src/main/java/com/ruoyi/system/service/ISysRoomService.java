package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.SysRoom;

/**
 * 房间管理Service接口
 * 
 * @author ruoyi
 * @date 2020-08-12
 */
public interface ISysRoomService 
{
    /**
     * 查询房间管理
     * 
     * @param id 房间管理ID
     * @return 房间管理
     */
    public SysRoom selectSysRoomById(Long id);

    /**
     * 查询房间管理列表
     * 
     * @param sysRoom 房间管理
     * @return 房间管理集合
     */
    public List<Map<String,Object>> selectSysRoomList(SysRoom sysRoom);

    /**
     * 新增房间管理
     * 
     * @param sysRoom 房间管理
     * @return 结果
     */
    public int insertSysRoom(SysRoom sysRoom);

    /**
     * 修改房间管理
     * 
     * @param sysRoom 房间管理
     * @return 结果
     */
    public int updateSysRoom(SysRoom sysRoom);

    /**
     * 批量删除房间管理
     * 
     * @param ids 需要删除的房间管理ID
     * @return 结果
     */
    public int deleteSysRoomByIds(Long[] ids);

    /**
     * 删除房间管理信息
     * 
     * @param id 房间管理ID
     * @return 结果
     */
    public int deleteSysRoomById(Long id);
}
