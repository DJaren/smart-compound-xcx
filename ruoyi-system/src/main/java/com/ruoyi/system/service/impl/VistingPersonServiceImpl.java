package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.VistingPersonMapper;
import com.ruoyi.system.domain.VistingPerson;
import com.ruoyi.system.service.IVistingPersonService;

/**
 * 来访人信息Service业务层处理
 * 
 * @author jaren
 * @date 2020-10-14
 */
@Service
public class VistingPersonServiceImpl implements IVistingPersonService 
{
    @Autowired
    private VistingPersonMapper vistingPersonMapper;

    /**
     * 查询来访人信息
     * 
     * @param id 来访人信息ID
     * @return 来访人信息
     */
    @Override
    public VistingPerson selectVistingPersonById(Long id)
    {
        return vistingPersonMapper.selectVistingPersonById(id);
    }

    /**
     * 查询来访人信息列表
     * 
     * @param vistingPerson 来访人信息
     * @return 来访人信息
     */
    @Override
    public List<VistingPerson> selectVistingPersonList(VistingPerson vistingPerson)
    {
        return vistingPersonMapper.selectVistingPersonList(vistingPerson);
    }

    /**
     * 新增来访人信息
     * 
     * @param vistingPerson 来访人信息
     * @return 结果
     */
    @Override
    public int insertVistingPerson(VistingPerson vistingPerson)
    {
        vistingPersonMapper.insertVistingPerson(vistingPerson);
        return vistingPerson.getId();
    }

    @Override
    public Map<String, Object> selectUserInfoByPid(Long id) {
        return vistingPersonMapper.selectUserInfoByPid(id);
    }

    /**
     * 修改来访人信息
     * 
     * @param vistingPerson 来访人信息
     * @return 结果
     */
    @Override
    public int updateVistingPerson(VistingPerson vistingPerson)
    {
        return vistingPersonMapper.updateVistingPerson(vistingPerson);
    }

    /**
     * 批量删除来访人信息
     * 
     * @param ids 需要删除的来访人信息ID
     * @return 结果
     */
    @Override
    public int deleteVistingPersonByIds(Long[] ids)
    {
        return vistingPersonMapper.deleteVistingPersonByIds(ids);
    }

    /**
     * 删除来访人信息信息
     * 
     * @param id 来访人信息ID
     * @return 结果
     */
    @Override
    public int deleteVistingPersonById(Long id)
    {
        return vistingPersonMapper.deleteVistingPersonById(id);
    }
}
