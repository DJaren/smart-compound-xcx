package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.SysConfOrder;

/**
 * 会议室预约Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-25
 */
public interface SysConfOrderMapper 
{
    /**
     * 查询会议室预约
     * 
     * @param confOrderId 会议室预约ID
     * @return 会议室预约
     */
    public Map<String,Object> selectSysConfOrderById(Long confOrderId);

    /**
     * 查询会议室预约列表
     * 
     * @param sysConfOrder 会议室预约
     * @return 会议室预约集合
     */
    public List<Map<String,Object>> selectSysConfOrderList(SysConfOrder sysConfOrder);

    /**
     * 新增会议室预约
     * 
     * @param sysConfOrder 会议室预约
     * @return 结果
     */
    public int insertSysConfOrder(SysConfOrder sysConfOrder);

    /**
     * 修改会议室预约
     * 
     * @param sysConfOrder 会议室预约
     * @return 结果
     */
    public int updateSysConfOrder(SysConfOrder sysConfOrder);

    /**
     * 删除会议室预约
     * 
     * @param confOrderId 会议室预约ID
     * @return 结果
     */
    public int deleteSysConfOrderById(Long confOrderId);

    /**
     * 批量删除会议室预约
     * 
     * @param confOrderIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysConfOrderByIds(Long[] confOrderIds);
}
