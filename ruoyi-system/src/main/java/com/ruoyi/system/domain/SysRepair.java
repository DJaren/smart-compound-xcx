package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 维修设备对象 sys_repair
 * 
 * @author jaren
 * @date 2020-10-14
 */
public class SysRepair extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    private Integer userId;

    private Integer status;

    /** 维修设备类型 */
    @Excel(name = "维修设备类型")
    private Long repairType;

    /** 维修时间 */
    @Excel(name = "维修时间")
    private Long repairTime;

    /** 地址 */
    @Excel(name = "地址")
    private String addr;

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

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRepairType(Long repairType) 
    {
        this.repairType = repairType;
    }

    public Long getRepairType() 
    {
        return repairType;
    }
    public void setRepairTime(Long repairTime) 
    {
        this.repairTime = repairTime;
    }

    public Long getRepairTime() 
    {
        return repairTime;
    }
    public void setAddr(String addr) 
    {
        this.addr = addr;
    }

    public String getAddr() 
    {
        return addr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("repairType", getRepairType())
            .append("repairTime", getRepairTime())
            .append("addr", getAddr())
            .append("remark", getRemark())
            .toString();
    }
}
