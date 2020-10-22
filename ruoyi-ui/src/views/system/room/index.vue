<template>
  <div class="app-container">
    <!--<el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">-->
      <!--<el-form-item label="楼层号" prop="floorId">-->
        <!--<el-select v-model="form.floorId" placeholder="请选择楼层号"  clearable size="small">-->
          <!--<el-option value="">请选择楼层号</el-option>-->
          <!--<el-option-->
            <!--v-for="item in buildList"-->
            <!--:key="item.id"-->
            <!--:label="item.floorNum"-->
            <!--:value="item.id">-->
          <!--</el-option>-->
        <!--</el-select>-->
      <!--</el-form-item>-->
      <!--<el-form-item label="房间号" prop="roomNum">-->
        <!--<el-input-->
          <!--v-model="queryParams.roomNum"-->
          <!--placeholder="请输入房间号"-->
          <!--clearable-->
          <!--size="small"-->
          <!--@keyup.enter.native="handleQuery"-->
        <!--/>-->
      <!--</el-form-item>-->
      <!--<el-form-item>-->
        <!--<el-button type="cyan" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>-->
        <!--<el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>-->
      <!--</el-form-item>-->
    <!--</el-form>-->

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:room:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:room:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:room:remove']"
        >删除</el-button>
      </el-col>
      <!--<el-col :span="1.5">-->
        <!--<el-button-->
          <!--type="warning"-->
          <!--icon="el-icon-download"-->
          <!--size="mini"-->
          <!--@click="handleExport"-->
          <!--v-hasPermi="['system:room:export']"-->
        <!--&gt;导出</el-button>-->
      <!--</el-col>-->
	  <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="roomList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键" align="center" prop="id" />
      <el-table-column label="楼层" align="center" prop="floorId" />
      <el-table-column label="房间号" align="center" prop="roomNum" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:room:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:room:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改房间管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="楼栋号" prop="buildId">
          <el-select v-model="form.buildId"
                     @change="handleChange1"
                     placeholder="请选择楼栋号"
                     clearable
                     size="small">
            <el-option v-for="item in list1"
                       :key="item.id"
                       :label="item.buildNum"
                       :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="楼层号" prop="floorId">
          <el-select v-model="form.floorId"
                     placeholder="请选择楼层号"
                     clearable
                     size="small">
            <el-option v-for="item in list2"
                       :key="item.id"
                       :label="item.floorNum"
                       :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="房间号" prop="roomNum">
          <el-input v-model="form.roomNum" placeholder="请输入房间号" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listRoom,getBuilds,listFloor, getRoom, delRoom, addRoom, updateRoom, exportRoom } from "@/api/system/room";

export default {
  name: "Room",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 房间管理表格数据
      list1: [],
      list2: [],
      roomList: [],
      buildList:[],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        floorId: null,
        roomNum: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        floorId: [
          { required: true, message: "楼层号不能为空", trigger: "blur" }
        ],
        roomNum: [
          { required: true, message: "房间号不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
    this.getBuildList();
  },
  methods: {
    /** 查询房间管理列表 */
    getList() {
      this.loading = true;
      listRoom(this.queryParams).then(response => {
        this.roomList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    getBuildList() {
      this.loading = true;
      getBuilds(this.queryParams).then(response => {
        this.list1 = response.data;
        this.loading = false;
      });
    },
    handleChange1 () {
      let _self = this
      debugger
      this.list1.map(item => {
        if (item.id === this.form.buildId) {
          _self.list2 = item.sysFloorList
        }
      })
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        build:null,
        floorId: null,
        roomNum: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加房间管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getRoom(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改房间管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateRoom(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              }
            });
          } else {
            addRoom(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              }
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除房间管理编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delRoom(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    }
  }
};
</script>
