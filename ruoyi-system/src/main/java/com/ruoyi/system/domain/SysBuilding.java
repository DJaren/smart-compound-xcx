package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 楼栋信息对象 sys_building
 * 
 * @author ruoyi
 * @date 2020-08-11
 */
public class SysBuilding extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 楼号 */
    @Excel(name = "楼号")
    private String buildNum;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setBuildNum(String buildNum) 
    {
        this.buildNum = buildNum;
    }

    public String getBuildNum() 
    {
        return buildNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("buildNum", getBuildNum())
            .toString();
    }
}
