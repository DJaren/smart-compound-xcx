package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysClear;

/**
 * 打扫卫生Mapper接口
 * 
 * @author jaren
 * @date 2020-10-14
 */
public interface SysClearMapper 
{
    /**
     * 查询打扫卫生
     * 
     * @param id 打扫卫生ID
     * @return 打扫卫生
     */
    public SysClear selectSysClearById(Integer id);

    /**
     * 查询打扫卫生列表
     * 
     * @param sysClear 打扫卫生
     * @return 打扫卫生集合
     */
    public List<SysClear> selectSysClearList(SysClear sysClear);

    /**
     * 新增打扫卫生
     * 
     * @param sysClear 打扫卫生
     * @return 结果
     */
    public int insertSysClear(SysClear sysClear);

    /**
     * 修改打扫卫生
     * 
     * @param sysClear 打扫卫生
     * @return 结果
     */
    public int updateSysClear(SysClear sysClear);

    /**
     * 删除打扫卫生
     * 
     * @param id 打扫卫生ID
     * @return 结果
     */
    public int deleteSysClearById(Integer id);

    /**
     * 批量删除打扫卫生
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysClearByIds(Integer[] ids);
}
