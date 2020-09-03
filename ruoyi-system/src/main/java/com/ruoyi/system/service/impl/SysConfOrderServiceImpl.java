package com.ruoyi.system.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.utils.DateUtils;
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
        String startTime = sysConfOrder.getStartTime();
        String endTime = sysConfOrder.getStartTime();
        String temp1=startTime.replace('年','-');
        String temp2=temp1.replace('月','-');
        String temp3=temp2.replace('日',' ');
        String temp4 = temp3;
        String temp5=temp4.substring(0,temp3.indexOf("周")-1)+temp4.substring(temp3.indexOf("周")+3);
        String temp6 = temp5.concat(":00");

        String temp7=endTime.replace('年','-');
        String temp8=temp7.replace('月','-');
        String temp9=temp8.replace('日',' ');
        String temp10 = temp9;
        String temp11=temp10.substring(0,temp9.indexOf("周")-1)+temp10.substring(temp9.indexOf("周")+3);
        String temp12 = temp11.concat(":00");

        sysConfOrder.setStartTime(temp6);
        sysConfOrder.setEndTime(temp12);
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
