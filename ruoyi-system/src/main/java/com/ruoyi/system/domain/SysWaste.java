package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 大件垃圾对象 sys_waste
 * 
 * @author ruoyi
 * @date 2020-10-15
 */
public class SysWaste extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    private Integer userId;

    private Integer status;


    /** 预约时间 */
    @Excel(name = "预约时间")
    private Long wasteTime;

    /** 预约类型 */
    @Excel(name = "预约类型")
    private Long wasteType;

    /** 房间号 */
    @Excel(name = "房间号")
    private String buildroom;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setWasteTime(Long wasteTime) 
    {
        this.wasteTime = wasteTime;
    }

    public Long getWasteTime() 
    {
        return wasteTime;
    }
    public void setWasteType(Long wasteType) 
    {
        this.wasteType = wasteType;
    }

    public Long getWasteType() 
    {
        return wasteType;
    }
    public void setBuildroom(String buildroom) 
    {
        this.buildroom = buildroom;
    }

    public String getBuildroom() 
    {
        return buildroom;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("wasteTime", getWasteTime())
            .append("wasteType", getWasteType())
            .append("buildroom", getBuildroom())
            .append("remark", getRemark())
            .toString();
    }
}
