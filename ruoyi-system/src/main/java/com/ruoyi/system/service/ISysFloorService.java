package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysFloor;

/**
 * 楼层信息Service接口
 * 
 * @author ruoyi
 * @date 2020-08-11
 */
public interface ISysFloorService 
{
    /**
     * 查询楼层信息
     * 
     * @param id 楼层信息ID
     * @return 楼层信息
     */
    public SysFloor selectSysFloorById(Long id);

    /**
     * 查询楼层信息列表
     * 
     * @param sysFloor 楼层信息
     * @return 楼层信息集合
     */
    public List<SysFloor> selectSysFloorList(SysFloor sysFloor);

    /**
     * 新增楼层信息
     * 
     * @param sysFloor 楼层信息
     * @return 结果
     */
    public int insertSysFloor(SysFloor sysFloor);

    /**
     * 修改楼层信息
     * 
     * @param sysFloor 楼层信息
     * @return 结果
     */
    public int updateSysFloor(SysFloor sysFloor);

    /**
     * 批量删除楼层信息
     * 
     * @param ids 需要删除的楼层信息ID
     * @return 结果
     */
    public int deleteSysFloorByIds(Long[] ids);

    /**
     * 删除楼层信息信息
     * 
     * @param id 楼层信息ID
     * @return 结果
     */
    public int deleteSysFloorById(Long id);
}
