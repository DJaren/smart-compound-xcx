package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SysBuilding;

/**
 * 楼栋信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-08-11
 */
public interface SysBuildingMapper 
{
    /**
     * 查询楼栋信息
     * 
     * @param id 楼栋信息ID
     * @return 楼栋信息
     */
    public SysBuilding selectSysBuildingById(Long id);

    /**
     * 查询楼栋信息列表
     * 
     * @param sysBuilding 楼栋信息
     * @return 楼栋信息集合
     */
    public List<SysBuilding> selectSysBuildingList(SysBuilding sysBuilding);

    /**
     * 新增楼栋信息
     * 
     * @param sysBuilding 楼栋信息
     * @return 结果
     */
    public int insertSysBuilding(SysBuilding sysBuilding);

    /**
     * 修改楼栋信息
     * 
     * @param sysBuilding 楼栋信息
     * @return 结果
     */
    public int updateSysBuilding(SysBuilding sysBuilding);

    /**
     * 删除楼栋信息
     * 
     * @param id 楼栋信息ID
     * @return 结果
     */
    public int deleteSysBuildingById(Long id);

    /**
     * 批量删除楼栋信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysBuildingByIds(Long[] ids);
}
