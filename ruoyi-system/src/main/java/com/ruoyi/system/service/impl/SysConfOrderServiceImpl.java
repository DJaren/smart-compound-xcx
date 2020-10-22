package com.ruoyi.system.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.mapper.SysUserMapper;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysConfOrderMapper;
import com.ruoyi.system.domain.SysConfOrder;
import com.ruoyi.system.service.ISysConfOrderService;

import static io.lettuce.core.MigrateArgs.Builder.replace;

/**
 * 会议室预约Service业务层处理
 *
 * @author ruoyi
 * @date 2020-08-25
 */
@Service
public class SysConfOrderServiceImpl implements ISysConfOrderService
{
    @Autowired
    private SysConfOrderMapper sysConfOrderMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 查询会议室预约
     *
     * @param confOrderId 会议室预约ID
     * @return 会议室预约
     */
    @Override
    public Map<String,Object> selectSysConfOrderById(Long confOrderId)
    {
        return sysConfOrderMapper.selectSysConfOrderById(confOrderId);
    }

    @Override
    public List<Map<String, Object>> selectSysConfOrderByTime(String startTime, String endTime) {
        return sysConfOrderMapper.selectSysConfOrderByTime(startTime,endTime);
    }

    /**
     * 查询会议室预约列表
     *
     * @param sysConfOrder 会议室预约
     * @return 会议室预约
     */
    @Override
    public List<Map<String,Object>> selectSysConfOrderList(SysConfOrder sysConfOrder)
    {
        return sysConfOrderMapper.selectSysConfOrderList(sysConfOrder);
    }

    /**
     * 新增会议室预约
     *
     * @param sysConfOrder 会议室预约
     * @return 结果
     */
    @Override
    public int insertSysConfOrder(SysConfOrder sysConfOrder)
    {
        return sysConfOrderMapper.insertSysConfOrder(sysConfOrder);
    }

    /**
     * 修改会议室预约
     *
     * @param sysConfOrder 会议室预约
     * @return 结果
     */
    @Override
    public int updateSysConfOrder(SysConfOrder sysConfOrder)
    {
        return sysConfOrderMapper.updateSysConfOrder(sysConfOrder);
    }

    /**
     * 批量删除会议室预约
     *
     * @param confOrderIds 需要删除的会议室预约ID
     * @return 结果
     */
    @Override
    public int deleteSysConfOrderByIds(Long[] confOrderIds)
    {
        return sysConfOrderMapper.deleteSysConfOrderByIds(confOrderIds);
    }

    /**
     * 删除会议室预约信息
     *
     * @param confOrderId 会议室预约ID
     * @return 结果
     */
    @Override
    public int deleteSysConfOrderById(Long confOrderId)
    {
        return sysConfOrderMapper.deleteSysConfOrderById(confOrderId);
    }
}
