package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 楼层信息对象 sys_floor
 * 
 * @author ruoyi
 * @date 2020-08-12
 */
public class SysFloor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 楼栋号 */
    @Excel(name = "楼栋号")
    private Long buildId;

    /** 楼层号 */
    @Excel(name = "楼层号")
    private String floorNum;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBuildId(Long buildId) 
    {
        this.buildId = buildId;
    }

    public Long getBuildId() 
    {
        return buildId;
    }
    public void setFloorNum(String floorNum) 
    {
        this.floorNum = floorNum;
    }

    public String getFloorNum() 
    {
        return floorNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("buildId", getBuildId())
            .append("floorNum", getFloorNum())
            .toString();
    }
}
