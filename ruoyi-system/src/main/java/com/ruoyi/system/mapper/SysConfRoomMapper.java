package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.SysConfRoom;

/**
 * 会议室Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-01
 */
public interface SysConfRoomMapper 
{
    /**
     * 查询会议室
     *
     * @param id 会议室ID
     * @return 会议室
     */
    public Map<String,Object> selectSysConfRoomById(Long id);

    /**
     * 查询会议室列表
     * 
     * @param sysConfRoom 会议室
     * @return 会议室集合
     */
    public List<Map<String,Object>> selectSysConfRoomList(SysConfRoom sysConfRoom);

    /**
     * 新增会议室
     * 
     * @param sysConfRoom 会议室
     * @return 结果
     */
    public int insertSysConfRoom(Map<String,Object> sysConfRoom);

    /**
     * 修改会议室
     * 
     * @param sysConfRoom 会议室
     * @return 结果
     */
    public int updateSysConfRoom(SysConfRoom sysConfRoom);

    /**
     * 删除会议室
     * 
     * @param id 会议室ID
     * @return 结果
     */
    public int deleteSysConfRoomById(Long id);

    /**
     * 批量删除会议室
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysConfRoomByIds(Long[] ids);
}
