package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 会议室对象 sys_conf_room
 * 
 * @author ruoyi
 * @date 2020-08-17
 */
public class SysConfRoom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 房间id */
    @Excel(name = "房间id")
    private Long roomid;

    /** 会议室名称 */
    @Excel(name = "会议室名称")
    private String name;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRoomid(Long roomid) 
    {
        this.roomid = roomid;
    }

    public Long getRoomid() 
    {
        return roomid;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("roomid", getRoomid())
            .append("name", getName())
            .toString();
    }
}
