package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 sys_conf_order
 *
 * @author ruoyi
 * @date 2020-08-19
 */
public class SysConfOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 会议室预约ID */
    private Long confOrderId;

    /** 用户ID,外键 */
    @Excel(name = "用户ID,外键")
    private Long userId;

    /** 会议室ID，外键 */
    @Excel(name = "会议室ID，外键")
    private Long confId;

    /** 预约开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh-mm")
    @Excel(name = "预约开始时间", width = 30, dateFormat = "yyyy-MM-dd hh-mm")
    private Date startTime;

    /** 预约结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh-mm")
    @Excel(name = "预约结束时间", width = 30, dateFormat = "yyyy-MM-dd hh-mm")
    private Date endTime;

    /** 会议主题 */
    @Excel(name = "会议主题")
    private String confTitle;

    /** 会议室状态 */
    @Excel(name = "会议室状态")
    private Long status;

    public void setConfOrderId(Long confOrderId)
    {
        this.confOrderId = confOrderId;
    }

    public Long getConfOrderId()
    {
        return confOrderId;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setConfId(Long confId)
    {
        this.confId = confId;
    }

    public Long getConfId()
    {
        return confId;
    }
    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getStartTime()
    {
        return startTime;
    }
    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public String getEndTime()
    {
        return String.valueOf(endTime);
    }
    public void setConfTitle(String confTitle)
    {
        this.confTitle = confTitle;
    }

    public String getConfTitle()
    {
        return confTitle;
    }
    public void setStatus(Long status)
    {
        this.status = status;
    }

    public Long getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("confOrderId", getConfOrderId())
            .append("userId", getUserId())
            .append("confId", getConfId())
            .append("createTime", getCreateTime())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("confTitle", getConfTitle())
            .append("status", getStatus())
            .toString();
    }
}
