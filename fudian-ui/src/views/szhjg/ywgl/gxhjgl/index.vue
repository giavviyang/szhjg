<template>
  <div class="dashboard-editor-container">
    <div class="chart-wrapper">
      <el-form :model="queryForm" ref="queryForm" size="small" :inline="true" style="margin-top: 0; margin-bottom: 0;"
               v-hasPermi="['szhjg:ywgl:gxhjgl:search']" @submit.native.prevent >
        <el-form-item label="名称" prop="gxmc">
          <el-input v-model="queryForm.gxmc"  clearable style="width: 200px" class="rt-input" size="mini"
                    @keyup.enter.native="batchSearch"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="batchSearch">搜索</el-button>
        </el-form-item>
      </el-form>
      <el-row :gutter="10" class="mb8">
        <el-col :span="1.5">
          <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="addXz"
                     v-hasPermi="['szhjg:ywgl:gxhjgl:add']">新增</el-button>
        </el-col>
        <el-col :span="1.5">
          <el-button type="success" plain icon="el-icon-edit" size="mini" @click="upData"
                     v-hasPermi="['szhjg:ywgl:gxhjgl:updata']">修改</el-button>
        </el-col>
        <el-col :span="1.5">
          <el-button type="danger" plain icon="el-icon-delete" size="mini" @click="deleteForm"
                     v-hasPermi="['szhjg:ywgl:gxhjgl:delete']">删除</el-button>
        </el-col>
      </el-row>
      <!--工序表单信息-->
      <el-table row-key="id" :data="fileList" border width="100%" height="calc(100vh - 230px)" ref="fileTable" slot="table"
                @selection-change="fileSelectionChange" @row-click="fileRowClick" @select="filesSelect"
                :row-style="fileClass">
        <el-table-column type="selection" width="40"></el-table-column>
        <!--<el-table-column align="center" :index="fileGetIndex" type="index" label="序号" width="55"></el-table-column>-->
        <el-table-column align="center" v-for="(item,index) in fileColumns" :key="index" :label="item.label" :prop="item.prop"
                         :min-width="item.width" show-overflow-tooltip>
        </el-table-column>
      </el-table>
      <div class="page" style="margin-top: 5px;">
        <el-pagination :page-sizes="[20, 30, 50, 100]" :page-size="pageSize" :current-page="pageNum" :total="total"
                       layout="total, sizes, prev, pager, next, jumper" @size-change="pageSizeS" :pager-count="5"
                       @current-change="pageCurrent"/>
      </div>
    </div>

    <el-dialog title="新增工序" :visible.sync="dialogVisible1" width="620px" append-to-body class="dialog-style dialog-basic"
               :close-on-click-modal="false" :close-on-press-escape="false">
      <el-form ref="tableFile" :model="tableFile" :inline="true" :rules="formRules" label-width="80px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="工序名称" prop="gxmc">
              <el-input v-model="tableFile.gxmc" placeholder="请输入工序名称" clearable size="mini" style="width:200px" @blur="checkCM('',tableFile.gxmc,'add','gxhjgl')" :onkeyup="tableFile.gxmc = tableFile.gxmc.replace(/\s/g,'')"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="工序序号" prop="gxxh">
              <el-input v-model="tableFile.gxxh" placeholder="请输入工序序号" clearable size="mini" style="width:200px"
                        maxlength="2" @blur="checkXH"/>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-form-item label="工序描述" prop="gxms">
              <el-input v-model="tableFile.gxms" type="textarea" placeholder="请输入工序描述" clearable size="mini"
                        style="width:500px" :onkeyup="tableFile.gxms = tableFile.gxms.replace(/\s/g,'')"/>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button size="mini" plain @click="dialogVisible1=false">取 消</el-button>
        <el-button size="mini" plain type="primary" @click="addForm('tableFile')">保 存</el-button>
      </div>
    </el-dialog>

    <el-dialog title="编辑工序" :visible.sync="dialogVisible2" width="620px" append-to-body class="dialog-style dialog-basic"
               :close-on-click-modal="false" :close-on-press-escape="false">
      <el-form ref="editorForm" :model="editorForm" :inline="true" :rules="formRules" label-width="80px">
        <el-row>
          <el-col :span="12">
            <el-form-item label="工序名称" prop="gxmc">
              <el-input v-model="editorForm.gxmc" placeholder="" :disabled="false" clearable size="mini"
                        style="width:200px" class="rt-input" @blur="checkCM(editorForm.id,editorForm.gxmc,'update','gxhjgl')" :onkeyup="editorForm.gxmc = editorForm.gxmc.replace(/\s/g,'')"/>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="工序序号" prop="gxxh">
              <el-input v-model="editorForm.gxxh" placeholder="" :disabled="true" clearable size="mini"
                        style="width:200px" class="rt-input" maxlength="2" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="24">
            <el-form-item label="工序描述" prop="gxms">
              <el-input v-model="editorForm.gxms" type="textarea" placeholder="" clearable size="mini" style="width:500px" :onkeyup="editorForm.gxms = editorForm.gxms.replace(/\s/g,'')"/>
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
</template>

<script>
import { queryGxhjList, addGxhjOne, updateGxhjOne, deleteGxhjId} from '@/api/szhjg/ywgl/gxhjgl';
import {Message} from "element-ui";
import {chongMingCheck} from "@/api/szhjg/szhjgCommon";
import { selectGxxhCount } from '@/api/szhjg/ywgl/gxhjgl';

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
        gxmc: '',
      },

      //复选框选中
      gridCheck: [],
      //工序列表
      fileList: [],
      //工序表头
      fileColumns: [
        {label: '工序序号', prop: 'gxxh', width: '100'},
        {label: '工序名称', prop: 'gxmc', width: '150'},
        {label: '工序描述', prop: 'gxms', width: '200'},
        {label: '创建人', prop: 'createBy', width: '150'},
        {label: '创建时间', prop: 'createTime', width: '200'},
        {label: '修改人', prop: 'updateBy', width: '150'},
        {label: '修改时间', prop: 'updateTime', width: '200'},
      ],
      //新增表单
      tableFile: {
        gxmc:'', gxxh:'', gxms:'',
      },//编辑表单
      editorForm: {
        id:'', gxmc:'', gxxh:'', gxms:'',
      },
      formRules: {
        gxmc: [
          {required: true, message: '工序名称不能为空', trigger: 'blur'},
          {min: 0, max: 100, message: '工序名称长度不得超过100', trigger: 'blur'},
        ],
        gxxh: [
          {required: true, message: '工序序号不能为空', trigger: 'blur'},
          // {min: 0, max: 2, message: '工序序号长度不得超过2', trigger: 'blur'},
          { pattern:/^[\d]+$/,  message: '工序序号只能输入数字', trigger: 'blur' }
        ],
        gxms: [
          {required: true, message: '工序描述不能为空', trigger: 'blur'},
          {min: 0, max: 100, message: '工序描述长度不得超过250', trigger: 'blur'},
        ],
      },
      //重名验证
      cxGxxh:'',
      chongMingFlag: '',
    }
  },

  mounted() {
    this.queryList(params)
  },

  methods: {
    //重名校验
    checkCM(id,mc,type,entity){
      chongMingCheck({id,mc,type,entity}).then(response => {
        this.chongMingFlag = response.msg;
        if (response.msg == "重名") {
          this.$message({message: "名称重复，请重新输入", type: 'error'})
        }else if(response.msg == null||response.msg == ''){
          //什么提示都不显示
        }else{
          this.$message({message: "名称可用", type: 'success'});
        }
      });
    },
    //工序序号验证
    checkXH(event){
      let gxxhValue = event.target.value;
      selectGxxhCount({gxxh:gxxhValue}).then(response =>{
        this.cxGxxh = response.msg;
        if (this.cxGxxh == "true"){
          this.$message.error("工序序号已存在,请更换工序序号!")
        }
      })
    },


    //上部搜索
    batchSearch() {
      const _this = this;
      this.pageNum = 1;
      let params = {
        pageNum: 1,
        pageSize: 20,
        gxmc: this.queryForm.gxmc,
      }
      this.queryList(params)

    },
    //分页
    pageCurrent(val) {
      this.pageNum = val
      params.pageNum = val
      params.pageSize = this.pageSize;
      this.queryList(params)
    },
    pageSizeS(val) {
      this.pageSize = val
      params.pageSize = val;
      params.pageNum = this.pageNum;
      this.queryList(params)
    },
    // 复选框事件
    fileSelectionChange(val) {
      this.gridCheck = val;
    },
    // 行点击事件
    fileRowClick(row, column, event) {
      this.$refs.fileTable.clearSelection();
      if (this.gridCheck.length === 0) {
        this.$refs.fileTable.toggleRowSelection(row)
        return;
      }
      this.$refs.fileTable.toggleRowSelection(row)
    },
    async filesSelect(selection, row) {
      //执行完清空操作在进行下面的勾选
      await this.$refs.fileTable.clearSelection();
      if (selection.length === 0) return;
      this.$refs.fileTable.toggleRowSelection(row, true);
    },
    fileClass( { row,rowIndex }) {
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
    fileGetIndex($index) {
      return (this.pageNum - 1) * this.pageSize + $index + 1;
    },

    //查询数据展示页面
    queryList(params) {
      const _this = this
      queryGxhjList(params, {emulateJSON: true})
        .then(function (response) {
          _this.fileList = response.rows
          _this.total = response.total
          _this.loading = false
        })
    },

    //新增方法
    addXz(){
      this.dialogVisible1 = true;
    },
    addForm(tableFile){
      //提交的时候先判断是否重名
      if(this.chongMingFlag=="重名"){
        this.$message({
          message: '名称重复，请重新输入！',
          duration: 3000,
          type: 'error'
        });
        return;
      }
      //判断工序序号是否存在
      if (this.cxGxxh == "true"){
        this.$message({message: '工序序号重复，请重新输入！', duration: 3000, type: 'error'});
        return;
      }

      const _this = this;
      this.$refs["tableFile"].validate((valid) => {
        if (valid) {
          addGxhjOne(this.tableFile).then(response => {
            if (response.code == "200") {
              _this.$message({message:"档案类型新增成功", type: 'success'})
              _this.reset();
              _this.dialogVisible1 = false;
            }else {
              this.$message({message: "档案类型新增失败", type: 'error'});
            }
          });
        } else {
          return false;
        }
      })
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
        this.editorForm = JSON.parse(JSON.stringify(this.gridCheck[0]));
        this.dialogVisible2 = true;
      }
    },
    upDataForm(editorForm){
      //提交的时候先判断是否重名
      if(this.chongMingFlag=="重名"){
        this.$message({
          message: '名称重复，请重新输入！',
          duration: 3000,
          type: 'error'
        });
        return;
      }

      const _this = this
      this.$refs[editorForm].validate(valid => {
        if (valid) {
          updateGxhjOne(this.editorForm).then(response => {
            if (response.code == "200") {
              _this.$message({message:"档案类型修改成功", type: 'success'})
              _this.reset();
              _this.dialogVisible2 = false;
            } else {
              this.$message({message: "档案类型修改失败", type: 'error'});
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
        this.$confirm('此操作将永久删除选中数据, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
        }).then(() => {
          const _this = this;
          let id = this.gridCheck[0].id;
          deleteGxhjId(id).then((response) => {
            if (response.code == 200) {
              _this.$message({message:"档案类型删除成功", type: 'success'})
              _this.reset();
            } else {
              this.$message({message: "档案类型删除失败", type: 'error'});
            }
          })
        }).catch(() => {})
      }
    },

    //新增/编辑/删除之后页面查询列表
    reset() {
      this.queryForm.gxmc = '';
      this.queryList(params);
      this.tableFile = {
        gxmc:'',
        gxms:'',
        remark:'',
      }
    },
  }
}
</script>

<style scoped lang="scss">
.el-form-item--small.el-form-item{
  margin-bottom: 5px;
}
::v-deep .el-cascader .el-input .el-input__inner {
  width: 120px;
  height: 28px;
  line-height: 28px;
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
    height: calc(100% - 100px);
  }
}
::v-deep .el-table {
  border-right:1px solid #dfe6ec;
  color: #515a6e;
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
            width: 17px !important;
          }
        }
      }
    }
  }
  .el-table__body-wrapper {
    overflow: auto !important;
    //border-right: 1px solid #dfe6ec;
    //width: calc(100% - 1px);
    .el-table__row {
      td {
        text-align: center;
        font-size: 12px;
        padding: 5px 0 !important;
        &:last-child {
          .cell {
            display: flex;
            //margin: 0 5px;
            //flex-direction: column;
            justify-content: space-around;
            width: 100%;
            white-space:nowrap;
            overflow:hidden;
            text-overflow: ellipsis;
            //padding: 0;
            .el-button {
              width: 100%;
              height: 100%;
              position: relative;
              top: 0;
              right: 0;
              //padding: 0;
              margin: 0 2px;
              //span{
              //  display: inline-block;
              //  height: 100%;
              //}
            }
          }
        }
      }
    }
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
