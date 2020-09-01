package com.ruoyi.system.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.SysConfOrder;

/**
 * 会议室预约Service接口
 * 
 * @author ruoyi
 * @date 2020-08-25
 */
public interface ISysConfOrderService 
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
     * 批量删除会议室预约
     * 
     * @param confOrderIds 需要删除的会议室预约ID
     * @return 结果
     */
    public int deleteSysConfOrderByIds(Long[] confOrderIds);

    /**
     * 删除会议室预约信息
     * 
     * @param confOrderId 会议室预约ID
     * @return 结果
     */
    public int deleteSysConfOrderById(Long confOrderId);
}
