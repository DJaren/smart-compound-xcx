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
public class SysConfOrder
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

    /** 创建时间 */
    private String createTime;

    /** 预约开始时间 */

    private String startTime;

    /** 预约结束时间 */
    private String endTime;

    /** 会议主题 */
    @Excel(name = "会议主题")
    private String confTitle;

    /** 会议室状态 */
    @Excel(name = "会议室状态")
    private Long status;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getConfOrderId() {
        return confOrderId;
    }

    public void setConfOrderId(Long confOrderId) {
        this.confOrderId = confOrderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getConfId() {
        return confId;
    }

    public void setConfId(Long confId) {
        this.confId = confId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getConfTitle() {
        return confTitle;
    }

    public void setConfTitle(String confTitle) {
        this.confTitle = confTitle;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
