package com.ruoyi.system.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.system.domain.VistingPerson;

/**
 * 来访人信息Mapper接口
 * 
 * @author jaren
 * @date 2020-10-14
 */
public interface VistingPersonMapper 
{
    /**
     * 查询来访人信息
     * 
     * @param id 来访人信息ID
     * @return 来访人信息
     */
    public VistingPerson selectVistingPersonById(Long id);


    public Map<String,Object> selectUserInfoByPid(Long id);

    /**
     * 查询来访人信息列表
     * 
     * @param vistingPerson 来访人信息
     * @return 来访人信息集合
     */
    public List<VistingPerson> selectVistingPersonList(VistingPerson vistingPerson);

    /**
     * 新增来访人信息
     * 
     * @param vistingPerson 来访人信息
     * @return 结果
     */
    public int insertVistingPerson(VistingPerson vistingPerson);

    /**
     * 修改来访人信息
     * 
     * @param vistingPerson 来访人信息
     * @return 结果
     */
    public int updateVistingPerson(VistingPerson vistingPerson);

    /**
     * 删除来访人信息
     * 
     * @param id 来访人信息ID
     * @return 结果
     */
    public int deleteVistingPersonById(Long id);

    /**
     * 批量删除来访人信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVistingPersonByIds(Long[] ids);
}
