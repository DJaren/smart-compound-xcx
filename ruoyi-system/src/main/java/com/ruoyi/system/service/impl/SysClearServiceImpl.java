package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysClearMapper;
import com.ruoyi.system.domain.SysClear;
import com.ruoyi.system.service.ISysClearService;

/**
 * 打扫卫生Service业务层处理
 * 
 * @author jaren
 * @date 2020-10-14
 */
@Service
public class SysClearServiceImpl implements ISysClearService 
{
    @Autowired
    private SysClearMapper sysClearMapper;

    /**
     * 查询打扫卫生
     * 
     * @param id 打扫卫生ID
     * @return 打扫卫生
     */
    @Override
    public SysClear selectSysClearById(Integer id)
    {
        return sysClearMapper.selectSysClearById(id);
    }

    /**
     * 查询打扫卫生列表
     * 
     * @param sysClear 打扫卫生
     * @return 打扫卫生
     */
    @Override
    public List<SysClear> selectSysClearList(SysClear sysClear)
    {
        return sysClearMapper.selectSysClearList(sysClear);
    }

    /**
     * 新增打扫卫生
     * 
     * @param sysClear 打扫卫生
     * @return 结果
     */
    @Override
    public int insertSysClear(SysClear sysClear)
    {
        return sysClearMapper.insertSysClear(sysClear);
    }

    /**
     * 修改打扫卫生
     * 
     * @param sysClear 打扫卫生
     * @return 结果
     */
    @Override
    public int updateSysClear(SysClear sysClear)
    {
        return sysClearMapper.updateSysClear(sysClear);
    }

    /**
     * 批量删除打扫卫生
     * 
     * @param ids 需要删除的打扫卫生ID
     * @return 结果
     */
    @Override
    public int deleteSysClearByIds(Integer[] ids)
    {
        return sysClearMapper.deleteSysClearByIds(ids);
    }

    /**
     * 删除打扫卫生信息
     * 
     * @param id 打扫卫生ID
     * @return 结果
     */
    @Override
    public int deleteSysClearById(Integer id)
    {
        return sysClearMapper.deleteSysClearById(id);
    }
}
