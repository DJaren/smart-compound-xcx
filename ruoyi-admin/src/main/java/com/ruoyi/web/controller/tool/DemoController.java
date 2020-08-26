package com.ruoyi.web.controller.tool;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysBuilding;
import com.ruoyi.system.service.ISysBuildingService;
import com.ruoyi.system.service.ISysConfigService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * swagger 会议室预约测试
 *
 * @author wpr
 */
@Api("测试会议预约信息")
@RestController
@RequestMapping("/test/demo")
public class DemoController {

//    private final static Map<Integer, ConfEntity> conf = new LinkedHashMap<Integer, ConfEntity>();
//    {
//        conf.put(1, new ConfEntity(1, "pdd", "1号会议室","2020-8-18 15:30","2020-8-18 16:30", "会议预约1"));
//        conf.put(2, new ConfEntity(2, "xdd", "2号会议室","2020-8-17 15:30","2020-8-17 16:30", "会议预约2"));
//    }

    ConfRoom conf1 = new ConfRoom(1, "1号会议室");
    ConfRoom conf2 = new ConfRoom(2, "2号会议室");
    ConfRoom conf3 = new ConfRoom(3, "3号会议室");
    ConfRoom conf4 = new ConfRoom(4, "4号会议室");
    ArrayList<ConfRoom> confList1=new ArrayList<>();
    ArrayList<ConfRoom> confList2=new ArrayList<>();
    {
        confList1.add(conf1);
        confList1.add(conf2);
        confList2.add(conf3);
        confList2.add(conf4);
    }
    Floor floor1 =new Floor(1,"1楼",confList1);
    Floor floor2 =new Floor(2,"2楼",confList2);
    ArrayList<Floor> floorList1 = new ArrayList<>();
    {
        floorList1.add(floor1);
        floorList1.add(floor2);
    }
    Building building1 = new Building(1,"1号楼",floorList1);
    ArrayList<Object> bfrList = new ArrayList<>();
    {
        bfrList.add(building1);
    }

    @ApiOperation("获取三级列表")
    @GetMapping("/listThree")
    public AjaxResult bfrList(){
        return AjaxResult.success(bfrList);
    }


//    @ApiOperation("获取会议室预约信息详细")
//    @ApiImplicitParam(name = "confOrderId",value = "会议预约ID",required = true, dataType = "int", paramType = "path")
//    @GetMapping("/{confOrderId}")
//    public AjaxResult getConf(@PathVariable Integer confOrderId){
//        if(!conf.isEmpty()&&conf.containsKey(confOrderId)) {
//            return AjaxResult.success(conf.get(confOrderId));
//        }else {
//            return AjaxResult.error("此会议室预约信息不存在！");
//        }
//    }
//
//    @ApiOperation("获取会议室预约信息列表")
//    @GetMapping("/listConf")
//    public AjaxResult confList(){
//        List<ConfEntity> confList = new ArrayList<>(conf.values());
//        return AjaxResult.success(confList);
//    }
//
//    @ApiOperation("新增会议室预约信息")
//    @PostMapping("/saveConf")
//    public AjaxResult saveConf(ConfEntity confEntity){
//        if(StringUtils.isNull(confEntity)||StringUtils.isNull((confEntity.getConfId()))){
//            return AjaxResult.error("会议室预约ID不能为空。");
//        }
//        return AjaxResult.success(conf.put(confEntity.getConfId(),confEntity));
//    }
//
//    @ApiOperation("更新会议室预约信息")
//    @ApiImplicitParam(name = "confEntity", value = "更新会议室预约信息", dataType = "ConfEntity")
//    @PutMapping("/update")
//    public AjaxResult update(ConfEntity confEntity)
//    {
//        if (StringUtils.isNull(confEntity) || StringUtils.isNull(confEntity.getConfId()))
//        {
//            return AjaxResult.error("会议室预约信息ID不能为空");
//        }
//        if (conf.isEmpty() || !conf.containsKey(confEntity.getConfId()))
//        {
//            return AjaxResult.error("会议室预约信息不存在");
//        }
//        conf.remove(confEntity.getConfId());
//        return AjaxResult.success(conf.put(confEntity.getConfId(),confEntity));
//    }
//
//    @ApiOperation("删除会议室预约信息")
//    @ApiImplicitParam(name = "confOrderId",value = "会议室预约信息ID",required = true,dataType = "int",paramType = "path")
//    @DeleteMapping("/{confOrderId}")
//    public AjaxResult deleteConf(@PathVariable Integer confOrderId){
//        if(!conf.isEmpty()&&conf.containsKey(confOrderId)){
//            conf.remove(confOrderId);
//            return AjaxResult.success();
//        }else {
//            return AjaxResult.error("会议室预约信息不存在");
//        }
//    }
}
@ApiModel("会议室实体")
class ConfRoom{
    @ApiModelProperty("会议室ID")
    private Integer confId;
    @ApiModelProperty("会议室名称")
    private String confName;

    public Integer getConfId() {
        return confId;
    }

    public void setConfId(Integer confId) {
        this.confId = confId;
    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
    }

    public ConfRoom() {
    }

    public ConfRoom(Integer confId, String confName) {
        this.confId = confId;
        this.confName = confName;
    }
}

@ApiModel("会议室预约实体")
class ConfEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 会议室预约ID
     */
    @ApiModelProperty("会议室预约ID")
    private Integer confId;

    /**
     * 用户名称,外键
     */
    @ApiModelProperty("用户名称")
    private String userName;

    /**
     * 会议室名称，外键
     */
    @ApiModelProperty("会议室名称")
    private String confName;

    /**
     * 预约开始时间
     */
    @ApiModelProperty("开始时间")
    private String startTime;

    /**
     * 预约结束时间
     */
    @ApiModelProperty("结束时间")
    private String endTime;


    /**
     * 会议主题
     */
    @ApiModelProperty("会议主题")
    private String confTitle;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getConfId() {
        return confId;
    }

    public void setConfId(Integer confId) {
        this.confId = confId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getConfName() {
        return confName;
    }

    public void setConfName(String confName) {
        this.confName = confName;
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

    public ConfEntity() {

    }

    public ConfEntity(Integer confId,  String confName) {
        this.confId = confId;
        this.confName = confName;
    }

//    public ConfEntity(Integer confId, String userName, String confName, String startTime, String endTime, String confTitle) {
//        this.confId = confId;
//        this.userName = userName;
//        this.confName = confName;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.confTitle = confTitle;
//    }
}

@ApiModel("楼栋")
class Building{

    private Integer buildingId;

    private String buildingName;

    private ArrayList floorId;



    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public ArrayList getFloorId() {
        return floorId;
    }

    public void setFloorId(ArrayList floorId) {
        this.floorId = floorId;
    }

    public Building(Integer buildingId, String buildingName, ArrayList floorId) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
        this.floorId = floorId;
    }

    public  Building(){

    }
}

@ApiModel("楼层")
class Floor{

    private Integer floorId;

    private String floorName;

    private ArrayList<ConfRoom> confId;

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public ArrayList<ConfRoom> getConfId() {
        return confId;
    }

    public void setConfId(ArrayList<ConfRoom> confId) {
        this.confId = confId;
    }

    public Floor(Integer floorId, String floorName, ArrayList<ConfRoom> confId) {
        this.floorId = floorId;
        this.floorName = floorName;
        this.confId = confId;
    }

    public Floor(int floorId, String floorName, ArrayList<Object> confList1) {
    }
}
