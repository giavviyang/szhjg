<template>
  <div class="dashboard-editor-container">
    <div class="chart-wrapper">
      <el-form :model="queryForm" ref="queryForm" size="small" :inline="true" style="margin-top: 0; margin-bottom: 0;"
               v-hasPermi="['szhjg:ywgl:setfield:metadata:search']" @submit.native.prevent >
        <el-form-item label="元数据名称" prop="nameMD">
          <el-input v-model="queryForm.nameMD"  clearable style="width: 200px" class="rt-input" size="mini"
                    @keyup.enter.native="batchSearch"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="batchSearch">搜索</el-button>
        </el-form-item>
      </el-form>
      <el-row :gutter="10" class="mb8">
        <el-col :span="1.5">
          <el-button type="primary" plain icon="el-icon-plus" size="mini"  @click="addXz"
                     v-hasPermi="['szhjg:ywgl:setfield:metadata:add']">新增</el-button>
        </el-col>
        <el-col :span="1.5">
          <el-button type="success" plain icon="el-icon-edit" size="mini" @click="upData"
                     v-hasPermi="['szhjg:ywgl:setfield:metadata:edit']">修改</el-button>
        </el-col>
        <el-col :span="1.5">
          <el-button type="danger" plain icon="el-icon-delete" size="mini" @click="deleteForm"
                     v-hasPermi="['szhjg:ywgl:setfield:metadata:remove']">删除</el-button>
        </el-col>
      </el-row>
      <!--任务表单信息-->
      <el-table row-key="id" :data="metaList" border width="100%" height="calc(100% - 120px)" ref="metaTable" slot="table"
                @selection-change="metaSelectionChange" @row-click="metaRowClick" @select="metasSelect"
                :row-style="metaClass">
        <el-table-column type="selection" width="40"></el-table-column>
        <el-table-column align="center" :index="metaGetIndex" type="index" label="序号" width="55"></el-table-column>
        <el-table-column align="center" v-for="(item,index) in metaColumns" :key="index" :label="item.label" :prop="item.prop"
                         :formatter="item.formatter" :min-width="item.width" show-overflow-tooltip>
        </el-table-column>
      </el-table>
      <div class="page" style="margin-top: 5px;">
        <el-pagination :page-sizes="[20, 30, 50, 100]" :page-size="pageSize" :current-page="pageNum"  :total="total"
                       layout="total, sizes, prev, pager, next, jumper" @size-change="pageSizeS" :pager-count="5"
                       @current-change="pageCurrent"/>
      </div>

      <el-dialog title="新增元数据" :visible.sync="dialogVisible1" width="40%" append-to-body class="dialog-style dialog-basic"
                 :close-on-click-modal="false" :close-on-press-escape="false">
        <el-form ref="tableMeta" :model="tableMeta" :inline="true" :rules="formRules" label-width="120px"
                 style="display: flex;flex-flow: column;align-items: center"><br>
          <el-row>
            <el-col :span="24">
              <el-form-item label="元数据字段名称" prop="metadataName">
                <el-input v-model="tableMeta.metadataName" placeholder="请输入名称" clearable size="mini" style="width:200px"/>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="元数据字段简称" prop="metadataChinese">
                <el-input v-model="tableMeta.metadataChinese" placeholder="请输入简称" clearable size="mini" style="width:200px"
                          @blur="checkDoubleOne"/>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="元数据字段类型" prop="metadataType">
                <el-select v-model="tableMeta.metadataType" placeholder="" clearable  size="mini" style="width:200px">
                  <el-option v-for="item in typeOptions" :key="item.value" :label="item.label" :value="item.value" :disabled="item.disabled"/>
                </el-select>
                <!--<el-select v-model="tableMeta.metadataType" size="mini" clearable style="width:200px" placeholder="请选择">
                  <el-option label="字符" value="varchar"></el-option>
                  <el-option label="数字" value="int"></el-option>
                  <el-option label="时间" value="datetime"></el-option>
                </el-select>-->
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="是否允许为空" prop="isNotNull">
                <el-radio-group style="width: 200px" v-model="tableMeta.isNotNull" >
                  <el-radio label="0">是</el-radio>
                  <el-radio label="1">否</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="备注" prop="remarks">
                <el-input v-model="tableMeta.remarks" type="textarea" placeholder="" clearable size="mini" autosize
                          style="width:200px"/>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button size="mini" plain @click="addCancel">取 消</el-button>
          <el-button size="mini" plain type="primary" @click="addForm('tableMeta')">保 存</el-button>
        </div>
      </el-dialog>

      <el-dialog title="编辑元数据" :visible.sync="dialogVisible2" width="40%" append-to-body class="dialog-style dialog-basic"
                 :close-on-click-modal="false" :close-on-press-escape="false">
        <el-form ref="editorForm" :model="editorForm" :inline="true" :rules="formRules" label-width="120px"
                 style="display: flex;flex-flow: column;align-items: center"><br/>
          <el-row>
            <el-col :span="24">
              <el-form-item label="元数据字段名称" prop="metadataName">
                <el-input v-model="editorForm.metadataName" placeholder="请输入名称" clearable size="mini" style="width:200px"/>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="元数据字段简称" prop="metadataChinese">
                <el-input v-model="editorForm.metadataChinese" placeholder="请输入简称" clearable size="mini" style="width:200px"
                          @blur="checkDoubleTwo"/>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="元数据字段类型" prop="metadataType">
                <el-select v-model="editorForm.metadataType" placeholder="" clearable  size="mini" style="width:200px">
                  <el-option v-for="item in typeOptions" :key="item.value" :label="item.label" :value="item.value" :disabled="item.disabled"/>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="是否允许为空" prop="isNotNull">
                <el-radio-group style="width: 200px" v-model="editorForm.isNotNull" >
                  <el-radio label="0">是</el-radio>
                  <el-radio label="1">否</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item label="备注" prop="remarks">
                <el-input v-model.trim="editorForm.remarks" type="textarea" placeholder="" clearable size="mini" autosize
                          style="width:200px"/>
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button size="mini" plain @click="dialogVisible2=false">取 消</el-button>
          <el-button size="mini" plain type="primary" @click="upDataForm('editorForm')">保 存</el-button>
        </div>
      </el-dialog>


    </div>
  </div>
</template>

<script>
import { queryYuanList, addYuanOne, updateYuanOne, deleteYuanId } from '@/api/szhjg/ywgl/setfield/metadata';
import { queryDoubleName } from '@/api/szhjg/ywgl/setfield/metadata';
import { queryMetadataType } from '@/api/szhjg/ywgl/setfield/generalPurpose';
import {Message} from "element-ui";


const params = {
  pageNum: 1,
  pageSize: 20
}
export default {
  name: "index",
  data() {
    return {
      dialogVisible1: false,
      dialogVisible2: false,
      // 遮罩层
      loading: true,
      total: 0,
      pageNum: 1,
      pageSize: 20,

      /* 搜索 */
      queryForm: {
        nameMD: '',
      },

      //字段类型列表
      typeOptions: [],

      //重名字段
      duplicate: '',

      //复选框选中
      gridCheck: [],
      //任务列表
      metaList: [],
      //任务表头
      metaColumns: [
        {label: '字段名称', prop: 'metadataName', width: '150'},
        {label: '字段简称', prop: 'metadataChinese', width: '150'},
        {label: '字段类型', prop: 'metadataType', width: '100', formatter: this.zdTypeOptions},
        {
          label: '是否允许为空', prop: 'isNotNull', width: '100', formatter: function (row, column, cellValue) {
            return cellValue == "0" ? "是" : "否";
          }
        },
        //{label: '是否为系统内置', prop: 'isSysBuilt', width: '100'},
        {label: '创建人', prop: 'createBy', width: '80'},
        {label: '创建时间', prop: 'createTime', width: '150'},
        //{label: '修改人', prop: 'updateBy', width: '80'},
        //{label: '修改时间', prop: 'updateTime', width: '150'},
        {label: '备注', prop: 'remarks',  width: '300'},
      ],
      //新增表单
      tableMeta: {
        metadataName:'', metadataChinese:'', metadataType:'', isNotNull:'', remarks:'',
      },
      //编辑表单
      editorForm: {
        id:'', metadataName:'', metadataChinese:'', metadataType:'', isNotNull:'', remarks:'',
      },
      formRules: {
        metadataName: [
          {required: true, message: '字段名称不能为空', trigger: 'blur'},
          {min: 0, max: 20, message: '字段名称长度不得超过20', trigger: 'blur'},
          {pattern:/^[a-zA-Z][a-zA-Z0-9_]{0,15}$/,  message: '内容不符合规则，由字母开头(包括字母/数字)' },
        ],
        metadataChinese: [
          {required: true, message: '字段简称内容不能为空', trigger: 'blur'},
          {min: 0, max: 30, message: '字段简称长度不得超过30', trigger: 'blur'},
        ],
        metadataType:[
          {required: true, message: '请选择字段类型', trigger: 'blur,change'}
        ],
        isNotNull:[
          {required: true, message: '请选择是否允许为空', trigger: 'blur,change'}
        ],
      },

    }
  },

  created(){
    this.queryDictList();
  },
  mounted() {
    this.queryList(params)
  },

  methods: {
    //查询元数据字段类型
    queryDictList(){
      queryMetadataType().then(res => {
        this.typeOptions = res.map((item) => {
          return item;
        });
      });
    },
    //转换元数据字段
    zdTypeOptions(row, column, cellValue) {
      let result;
      for (var i in this.typeOptions) {
        if (cellValue == this.typeOptions[i].value) {
          result = this.typeOptions[i].label
        }
      }
      return result;
    },
    //上部搜索
    batchSearch() {
      const _this = this;
      this.pageNum = 1;
      let params = {
        pageNum: 1,
        pageSize: 20,
        metadataName: this.queryForm.nameMD,
      }
      this.queryList(params)
    },
    //分页
    pageCurrent(val) {
      this.pageNum = val
      params.pageNum = val
      params.pageSize = this.pageSize;
      params.metadataName = this.queryForm.nameMD;
      this.queryList(params)
    },
    pageSizeS(val) {
      this.pageSize = val
      params.pageSize = val;
      params.pageNum = this.pageNum;
      params.metadataName = this.queryForm.nameMD;
      this.queryList(params)
    },
    //查询数据展示页面
    queryList(params) {
      const _this = this
      queryYuanList(params, {emulateJSON: true})
        .then(function (response) {
          _this.metaList = response.rows
          _this.total = response.total
          _this.loading = false
        })
    },

    // 复选框事件
    metaSelectionChange(val) {
      this.gridCheck = val;
    },
    // 行点击事件
    metaRowClick(row, column, event) {
      this.$refs.metaTable.clearSelection();
      if (this.gridCheck.length === 0) {
        this.$refs.metaTable.toggleRowSelection(row)
        return;
      }
      this.$refs.metaTable.toggleRowSelection(row)
    },
    async metasSelect(selection, row) {
      //执行完清空操作在进行下面的勾选
      await this.$refs.metaTable.clearSelection();
      if (selection.length === 0) return;
      this.$refs.metaTable.toggleRowSelection(row, true);
    },
    metaClass( { row,rowIndex }) {
      if (this.gridCheck.includes(row)){
        return {
          "background":"#b9deff !important", "color": "blue",
        }
      } else {
        return {
          "——tablebackground" : "#F5F7FA",
        }
      }
    },
    //翻页后序号连贯 (表格序号)
    metaGetIndex($index) {
      return (this.pageNum - 1) * this.pageSize + $index + 1;
    },

    //新增方法
    addXz(){
      this.dialogVisible1 = true;
    },
    addForm(tableMeta){
      if (this.duplicate == "true") {
        this.$message.error("元数据名称已存在,请更换名称!")
        return;
      }
      const _this = this;
      this.$refs["tableMeta"].validate((valid) => {
        if (valid) {
          addYuanOne(this.tableMeta).then(response => {
            if (response.code == "200") {
              this.$message({message:"元数据新增成功", type: 'success'})
              _this.reset();
              _this.dialogVisible1 = false;
            }else {
              this.$message({message: "元数据新增失败", type: 'error'});
            }
          });
        } else {
          return false;
        }
      })
    },
    //新增取消
    addCancel(){
      this.tableMeta = {metadataName:'', metadataChinese:'', metadataType:'', isNotNull:'', remarks:''};
      this.dialogVisible1=false
    },

    //编辑
    upData(){
      if (this.gridCheck.length <= 0) {
        Message.warning("请选择要修改的数据");
        return false
      }
      if (this.gridCheck.length > 1) {
        Message.warning("请选择一条数据进行修改");
        return false
      }
      if (this.gridCheck.length == 1) {
        let da = this.gridCheck[0].dabh;
        if ( da =="1"|| da=="2"){
          Message.warning("当前档案类型不支持编辑");
          return false
        }
        this.editorForm = JSON.parse(JSON.stringify(this.gridCheck[0]));
        this.dialogVisible2 = true;
      }
    },
    upDataForm(editorForm){
      if (this.duplicate == "true") {
        this.$message.error("元数据名称已存在,请更换名称!")
        return;
      }
      const _this = this
      this.$refs[editorForm].validate(valid => {
        if (valid) {
          updateYuanOne(this.editorForm).then(response => {
            if (response.code == "200") {
              this.$message({message:"元数据修改成功", type: 'success'})
              _this.reset();
              _this.dialogVisible2 = false;
            } else {
              this.$message({message:"元数据修改失败", type: 'error'});
            }
          });
        } else {
          return false
        }
      })
    },

    //删除
    deleteForm(){
      if (this.gridCheck.length <= 0) {
        Message.warning("请选择要删除的数据");
        return false
      }
      if (this.gridCheck.length > 1) {
        Message.warning("请选择一条数据进行删除");
        return false
      }
      if (this.gridCheck.length == 1) {
        this.$confirm('此操作将永久删除该元数据, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          const _this = this;
          let id = this.gridCheck[0].id;
          deleteYuanId(id).then((response) => {
            if (response.code == 200) {
              this.$message({message:"元数据删除成功", type: 'success'})
              _this.reset();
            } else {
              this.$message({message:"元数据删除失败", type: 'error'});
            }
          })
        }).catch(() => {});
      }
    },

    //新增/编辑/删除之后页面查询列表
    reset() {
      this.queryForm.nameMD = '';
      this.queryList(params);
      this.tableMeta = { metadataName:'', metadataChinese:'', metadataType:'', isNotNull:'', remarks:''};
    },

    //重名判断--新增
    checkDoubleOne(event){
      let params = {
        type : 'add',
        name : event.target.value,
      }
      this.checkDouble(params)
    },
    //重名判断--编辑
    checkDoubleTwo(event){
      let params = {
        type : 'edit',
        name : event.target.value,
        id : this.editorForm.id,
      }
      this.checkDouble(params)
    },
    //重名查询
    checkDouble(params){
      queryDoubleName(params, {emulateJSON: true}).then(response => {
        this.duplicate = response.msg;
        if (response.msg == "true") {
          this.$message.error("元数据名称已存在!")
        }
      })
    }

  }
}
</script>

<style scoped lang="scss">
.el-form-item--small.el-form-item{
  margin-bottom: 5px;
}

.dashboard-editor-container {
  padding: 10px;
  width: 100%;
  height: 100%;
  position: relative;
  .github-corner {
    position: absolute;
    top: 0;
    border: 0;
    right: 0;
  }
  .chart-wrapper {
    width: 100%;
    height: 100%;
  }
}

::v-deep .el-table {
  border-right:1px solid #dfe6ec;
  color: #515a6e;
  th{
    height: 34px !important;
  }
  & > .el-table__header-wrapper {
    & > table {
      tr:first-of-type {
        th {
          background: rgba(204, 204, 204, 0.18);
          color: #515a6e;
          font-size: 12px;
          //text-align: center;
          height: 34px !important;
          padding: 5px 0 !important;
        }
      }
      tr:nth-of-type(2) {
        th {
          background: #fff;
          //background: rgba(204, 204, 204, 0.05);
          color: #515a6e;
          font-size: 12px;
          text-align: center;
          padding: 0 !important;
          height: 34px;
          .el-input__inner {
            border: none;
            padding: 0;
            height: 20px;
          }
        }
      }
      & > colgroup {
        col {
          &:last-of-type {
            width: 10px !important;
          }
        }
      }
    }
  }
  .el-table__body-wrapper {
    overflow: auto !important;
    .el-table__row {
      td {
        text-align: center;
        font-size: 12px;
        padding: 5px 0 !important;
      }
      .operation {
        .cell {
          display: flex;
          justify-content: space-around;
          width: 100%;
          white-space:nowrap;
          overflow:hidden;
          text-overflow: ellipsis;

          .el-button {
            width: 100%;
            height: 100%;
            position: relative;
            top: 0;
            right: 0;
            margin: 0 2px;
          }
        }
      }
    }
  }
  .el-table__cell {
    padding: 5px 0 !important;
  }
  //滚动条
  /**滚动条的宽度*/
  ::-webkit-scrollbar {
    width: 10px !important; /*竖向*/
    height: 10px !important; /*横向*/
  }
  /*滚动条的滑块*/
  ::-webkit-scrollbar-thumb {
    background-color: #ddd !important;
    border-radius: 8px !important;
  }
}

.page {
  float: right;
  height: 38px;
  text-align: right;
  ::v-deep .el-pagination {
    height: 28px;
    //position: relative;
    //margin-top: 5px;
    font-size: 12px;
    & > .el-pagination__total {
      font-size: 12px;
    }
    & > .el-pagination__sizes {
      .el-input {
        input {
          font-size: 12px;
          height: 26px;
        }
      }
    }
    button {
      background-color: transparent;
    }
    & > .el-pager {
      li {
        font-size: 12px;
        background-color: transparent;
      }
    }
    & > .el-pagination__jump {
      font-size: 12px;
      .el-input {
        input {
          font-size: 12px;
          height: 26px;
        }
      }
    }
  }
}

::v-deep .el-table tbody tr:hover>td {
  background: var(--tablebackground) !important;
}

//表格鼠标悬浮时的样式 （高亮）
::v-deep  {
  .el-table--enable-row-hover {
    .el-table__body tr {
      &:hover {
        background: rgb(223 239 253);
        border: 1px solid #313463;
      }
    }
  }
}

// 基本信息弹框
.dialog-basic {
  margin-left: 10px;
  .form-basic {
    margin-bottom: 15px;
    line-height: 30px;
    border-bottom: 1px solid #ccc;
    margin-left: 15px;
    margin-right: 15px;
  }
}

//禁止输入框输入,字体颜色黑色
.rt-input ::v-deep .el-input__inner{
  color:  #000000;
}

</style>
