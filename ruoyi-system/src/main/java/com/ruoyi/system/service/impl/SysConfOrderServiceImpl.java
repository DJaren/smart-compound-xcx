package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.SysConfOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysConfOrderMapper;
import com.ruoyi.system.service.ISysConfOrderService;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2020-08-19
 */
@Service
public class SysConfOrderServiceImpl implements ISysConfOrderService
{
    @Autowired
    private SysConfOrderMapper sysConfOrderMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param confOrderId 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public SysConfOrder selectSysConfOrderById(Long confOrderId)
    {
        return sysConfOrderMapper.selectSysConfOrderById(confOrderId);
    }

    @Override
    public List<SysConfOrder> selectSysConfOrderList(SysConfOrder sysConfOrder) {
        return null;
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param sysConfOrder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertSysConfOrder(SysConfOrder sysConfOrder)
    {
        sysConfOrder.setCreateTime(DateUtils.getNowDate());
        return sysConfOrderMapper.insertSysConfOrder(sysConfOrder);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param sysConfOrder 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateSysConfOrder(SysConfOrder sysConfOrder)
    {
        return sysConfOrderMapper.updateSysConfOrder(sysConfOrder);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param confOrderIds 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteSysConfOrderByIds(Long[] confOrderIds)
    {
        return sysConfOrderMapper.deleteSysConfOrderByIds(confOrderIds);
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param confOrderId 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteSysConfOrderById(Long confOrderId)
    {
        return sysConfOrderMapper.deleteSysConfOrderById(confOrderId);
    }
}
