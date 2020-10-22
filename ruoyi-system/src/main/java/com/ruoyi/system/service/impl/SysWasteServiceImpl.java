package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysWasteMapper;
import com.ruoyi.system.domain.SysWaste;
import com.ruoyi.system.service.ISysWasteService;

/**
 * 大件垃圾Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-10-15
 */
@Service
public class SysWasteServiceImpl implements ISysWasteService 
{
    @Autowired
    private SysWasteMapper sysWasteMapper;

    /**
     * 查询大件垃圾
     * 
     * @param id 大件垃圾ID
     * @return 大件垃圾
     */
    @Override
    public SysWaste selectSysWasteById(Long id)
    {
        return sysWasteMapper.selectSysWasteById(id);
    }

    /**
     * 查询大件垃圾列表
     * 
     * @param sysWaste 大件垃圾
     * @return 大件垃圾
     */
    @Override
    public List<SysWaste> selectSysWasteList(SysWaste sysWaste)
    {
        return sysWasteMapper.selectSysWasteList(sysWaste);
    }

    /**
     * 新增大件垃圾
     * 
     * @param sysWaste 大件垃圾
     * @return 结果
     */
    @Override
    public int insertSysWaste(SysWaste sysWaste)
    {
        return sysWasteMapper.insertSysWaste(sysWaste);
    }

    /**
     * 修改大件垃圾
     * 
     * @param sysWaste 大件垃圾
     * @return 结果
     */
    @Override
    public int updateSysWaste(SysWaste sysWaste)
    {
        return sysWasteMapper.updateSysWaste(sysWaste);
    }

    /**
     * 批量删除大件垃圾
     * 
     * @param ids 需要删除的大件垃圾ID
     * @return 结果
     */
    @Override
    public int deleteSysWasteByIds(Long[] ids)
    {
        return sysWasteMapper.deleteSysWasteByIds(ids);
    }

    /**
     * 删除大件垃圾信息
     * 
     * @param id 大件垃圾ID
     * @return 结果
     */
    @Override
    public int deleteSysWasteById(Long id)
    {
        return sysWasteMapper.deleteSysWasteById(id);
    }
}
