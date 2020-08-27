package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 房间管理对象 sys_room
 *
 * @author ruoyi
 * @date 2020-08-12
 */
public class SysRoom
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 楼层 */
    @Excel(name = "楼层")
    private Long floorId;

    /** 房间号 */
    @Excel(name = "房间号")
    private String roomNum;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setFloorId(Long floorId)
    {
        this.floorId = floorId;
    }

    public Long getFloorId()
    {
        return floorId;
    }
    public void setRoomNum(String roomNum)
    {
        this.roomNum = roomNum;
    }

    public String getRoomNum()
    {
        return roomNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("floorId", getFloorId())
            .append("roomNum", getRoomNum())
            .toString();
    }
}
