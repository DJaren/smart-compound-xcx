package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 来访人信息对象 visting_person
 * 
 * @author jaren
 * @date 2020-10-14
 */
public class VistingPerson extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private int id;

    private Integer userId;

    private String openId;

    private Integer status;

    private Long visitingTime;
    private String visitingName;

    /** 来访事由 */
    @Excel(name = "来访事由")
    private String vistingReason;

    /** 来访人单位 */
    @Excel(name = "来访人单位")
    private String vistingDept;

    /** 来访人数 */
    @Excel(name = "来访人数")
    private Long vistingNum;

    /** 车辆号牌 */
    @Excel(name = "车辆号牌")
    private String carCode;

    public String getVisitingName() {
        return visitingName;
    }

    public void setVisitingName(String visitingName) {
        this.visitingName = visitingName;
    }

    /** 来访人员身份证 */
    @Excel(name = "来访人员身份证")
    private String vistingCode;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getVisitingTime() {
        return visitingTime;
    }

    public void setVisitingTime(Long visitingTime) {
        this.visitingTime = visitingTime;
    }

    public void setVistingReason(String vistingReason)
    {
        this.vistingReason = vistingReason;
    }

    public String getVistingReason() 
    {
        return vistingReason;
    }
    public void setVistingDept(String vistingDept) 
    {
        this.vistingDept = vistingDept;
    }

    public String getVistingDept() 
    {
        return vistingDept;
    }
    public void setVistingNum(Long vistingNum) 
    {
        this.vistingNum = vistingNum;
    }

    public Long getVistingNum() 
    {
        return vistingNum;
    }
    public void setCarCode(String carCode) 
    {
        this.carCode = carCode;
    }

    public String getCarCode() 
    {
        return carCode;
    }
    public void setVistingCode(String vistingCode) 
    {
        this.vistingCode = vistingCode;
    }

    public String getVistingCode() 
    {
        return vistingCode;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("visitingTime", getVisitingTime())
            .append("vistingReason", getVistingReason())
            .append("vistingDept", getVistingDept())
            .append("vistingNum", getVistingNum())
            .append("carCode", getCarCode())
            .append("vistingCode", getVistingCode())
            .toString();
    }
}
