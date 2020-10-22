package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 打扫卫生对象 sys_clear
 * 
 * @author jaren
 * @date 2020-10-14
 */
public class SysClear extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    private Integer userId;

    /** 预约时间 */
    @Excel(name = "预约时间")
    private Long appointmentTime;

    /** 楼号&房间号 */
    @Excel(name = "楼号&房间号")
    private String buildroom;

    private String remark;

    private int status;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setAppointmentTime(Long appointmentTime) 
    {
        this.appointmentTime = appointmentTime;
    }

    public Long getAppointmentTime() 
    {
        return appointmentTime;
    }
    public void setBuildroom(String buildroom) 
    {
        this.buildroom = buildroom;
    }



    public String getBuildroom()
    {
        return buildroom;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("appointmentTime", getAppointmentTime())
            .append("buildroom", getBuildroom())
            .append("remark", getRemark())
            .toString();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
