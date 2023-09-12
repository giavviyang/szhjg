<template>
  <div>
    <el-dialog title="领取任务"  width="70%" :visible.sync="dialogReceive" append-to-body :close-on-click-modal="false"
               :close-on-press-escape="false" class="dialog-style dialog-basic dialog-grid" :before-close="beforeClose">
      <div style="white-space:nowrap; overflow-x:auto; overflow-y:hidden;">
        <el-form :model="queryForm" ref="queryForm" size="small" :inline="true" style="height: 35px">
          <el-form-item label="选择批次" prop="pcId">
            <el-cascader v-model="queryForm.pcId" :options="projectOptions" :props="projectProps" clearable
                         size="mini" filterable :show-all-levels="false" @change="handleChange"
                         style="width: 160px;height: 28px;line-height: 28px;"></el-cascader>
          </el-form-item>
          <el-form-item label="编号" prop="bianHao">
            <el-input v-model="queryForm.bianHao" placeholder="请输入查询内容" clearable size="mini" style="width: 160px"
                      @keyup.enter.native="queryTaskNameSearch"/>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" icon="el-icon-search" size="mini" @click="queryTaskNameSearch">搜索</el-button>
            <el-button type="primary" plain icon="el-icon-collection-tag" size="mini" @click="multipleClaim">领取任务</el-button>
          </el-form-item>
        </el-form>
        <div v-if="taskColumns.length<=0" class="dialogColumnsFalse">暂无数据</div>
        <div v-else style=" height:calc(100% - 35px)">
          <el-table row-key="id" :data="taskList" border width="100%" height="calc(100% - 30px)" ref="receiveTable"
                    @selection-change="selectionChange" @row-click="rowClick" :row-style="taskClass">
            <el-table-column type="selection" width="40"></el-table-column>
            <el-table-column align="center" :index="getIndex" type="index" label="序号" width="55"></el-table-column>
            <el-table-column align="center" v-for="(item,index) in taskColumns" :formatter="item.formatter" :key="index"
                             :label="item.label" :prop="item.prop" :min-width="item.width" show-overflow-tooltip/>
          </el-table>
          <div class="page" style="margin-top: 0;" >
            <el-pagination :page-sizes="[20, 30, 50, 100]" :page-size="pageSize" :current-page="pageNum" :total="total"
                           layout="total, sizes, prev, pager, next, jumper" @size-change="pageSizeS" :pager-count="5"
                           @current-change="pageCurrent"/>
          </div>
        </div>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {queryDisplayGx, queryProjectBatch} from "@/api/szhjg/szhjgCommon";
import {taskDynamicListHead} from "@/api/szhjg/dynamicCommon";
import { queryRetrievesTaskList, selectFetchTaskIds, selectRecordTaskIds } from '@/api/szhjg/sjjg/approachCommon';


const params = {
  pageNum: 1,
  pageSize: 20
}
export default {
  name: "ViewingReceive",
  data() {
    return {
      dialogReceive: false,
      // 遮罩层
      loading: true,
      total: 0,
      pageNum: 1,
      pageSize: 20,
      //批次项目信息
      projectOptions: [],
      projectProps: {label: 'projectName', value: 'benId', children: 'pcName'},
      queryForm: {
        pcId: [],
        bianHao: "",
      },
      //工序id
      gId: '',
      //任务列表
      taskList: [],
      //任务表头
      taskColumns: [],

      //任务复选框选中
      gridCheckOne: [],
      taskGridMore: [],

    }
  },

  created() {
    this.queryGxOptions();
  },

  watch:{
    projectOptions(val){
      this.queryForm.pcId = val[0].benId
      if(val[0].pcName.length > 0){
        this.queryForm.pcId = [val[0].benId,val[0].pcName[0].benId]
      }
      this.getTableHeaders(this.queryForm.pcId[1]);
      params.pcId = this.queryForm.pcId[1];
      params.dqgx = this.gId;
      this.queryTaskNameList(params);
      this.batchId = this.queryForm.pcId[1];
    }
  },

  methods: {
    // 窗口初始化方法，nextTick方法可以添加逻辑，如打开窗口时查询数据填充
    init(bizId) {
      this.dialogReceive = true;
      this.$nextTick(() => {
        this.gId = bizId;
        this.getOptionsData(bizId);
        this.dialogReceive = true;
      });
    },
    //默认查询项目批次
    getOptionsData(val) {
      queryProjectBatch({gxId:val}).then((res) => {
        this.projectOptions = res.data;
      })
    },
    //查询页面动态展示工序
    queryGxOptions() {
      queryDisplayGx().then(res => {
        this.optionsProcedure = res.map((item) => {
          return item;
        });
      });
    },
    //切换项目批次之后进行查询
    handleChange(value) {
      this.taskColumns = [];
      this.taskList = [];
      this.getTableHeaders(value[1]);
      params.pcId = value[1];
      params.dqgx = this.gId;
      this.queryTaskNameList(params);
      this.batchId = value[1];
    },
    //查询动态表头展示字段
    getTableHeaders(dynamic) {
      taskDynamicListHead({headBatch: dynamic, headPoints: 0, headType: 0}).then((res) => {
        this.taskColumns = res.data
      })
    },

    //搜索
    queryTaskNameSearch (){
      let params = {
        pageNum: 1,
        pageSize: 20,
        pcId: this.queryForm.pcId[1],
        bh:this.queryForm.bianHao,
        dqgx:this.gId,
      }
      this.queryTaskNameList(params)
    },
    queryTaskNameList(params){
      const _this = this
      queryRetrievesTaskList(params, {emulateJSON: true}).then(function (response) {
        if(response.rows != undefined && response.rows != "" && response.rows != null){
          response.rows.forEach((value, index) => {
            const arr = _this.optionsProcedure;
            for (var i in arr) {
              if (value.dqgx == arr[i].value) {
                value.dqgx = arr[i].label;
              }
            }
          })
        }
        _this.taskList = response.rows;
        _this.total = response.total;
        _this.loading = false;
      })
    },
    //分页
    pageCurrent(val) {
      this.pageNum = val
      params.pageNum = val
      params.pageSize = this.pageSize;
      params.pcId = this.queryForm.pcId[1];
      params.bh = this.queryForm.bianHao;
      params.dqgx = this.gId;
      this.queryTaskNameList(params)
    },
    pageSizeS(val) {
      this.pageSize = val
      params.pageSize = val;
      params.pageNum = this.pageNum;
      params.pcId = this.queryForm.pcId[1];
      params.bh = this.queryForm.bianHao;
      params.dqgx = this.gId;
      this.queryTaskNameList(params)
    },

    //复选框事件
    selectionChange(val) {
      this.gridCheckOne = val;
      this.taskGridMore = val.map(item => item.id)
    },
    //行点击事件
    rowClick(row, column, event) {
      this.$refs.receiveTable.clearSelection();
      if (this.gridCheckOne.length === 0) {
        this.$refs.receiveTable.toggleRowSelection(row)
        return;
      }
      this.$refs.receiveTable.toggleRowSelection(row)
    },
    taskClass( { row,rowIndex }) {
      if (this.gridCheckOne.includes(row)){
        return {
          "background":"#b9deff !important", "color": "blue",
        }
      } else {
        return {
          "——tablebackground" : "#F5F7FA",
        }
      }
    },

    //翻页后序号连贯
    getIndex($index) {
      return (this.pageNum - 1) * this.pageSize + $index + 1;
    },

    //领取任务
    multipleClaim(){
      const _this = this
      if (this.taskGridMore.length == 0) {
        this.$message({
          type: "warning",
          message: "请选择要领取的任务"
        })
      }else {
        this.$confirm('是否要领取当前选择的任务,是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
        }).then(() => {
          if (_this.gId === "7" ){
            selectRecordTaskIds(this.taskGridMore).then((response) => {
              if (response.code == 200) {
                _this.$message({message: "任务领取成功", type: 'success'})
                _this.queryTaskNameSearch();
              }
            })
          }else {
            selectFetchTaskIds(this.taskGridMore).then((response) => {
              if (response.code == 200) {
                _this.$message({message: "任务领取成功", type: 'success'})
                _this.queryTaskNameSearch();
              }
            })
          }
        }).catch(() => {});
      }
    },

    //关闭页面弹窗
    beforeClose() {
      this.dialogReceive = false;
      this.$emit("TaskClaimCloseData", "刷新");
    },

  }
}
</script>

<style scoped lang="scss">
.el-form-item--small.el-form-item {
  margin-bottom: 5px;
}

// 基本信息弹框
.dialog-basic {
  margin-left: 10px;
  .form-basic {
    margin-bottom: 5px;
    line-height: 25px;
    border-bottom: 1px solid #ccc;
    //margin-left: 15px;
    //margin-right: 15px;
    font-size: 14px;
    font-weight: bold;
  }
  .form-imgs {
    position: relative;
    height: 100%;
    margin-bottom: 5px;
    line-height: 25px;
    border-bottom: 1px solid #ccc;
    font-size: 14px;
    font-weight: bold;
    .img-viewr__wrapper{
      position: absolute;
    }
    ::v-deep .icon__circle-close{
      display: none;
    }
    ::v-deep .img-viewr__canvas{
      overflow: hidden;
    }
    .imgs {
      display: flex;
    }
    .img {
      width: 150px;
      height: 100px;
      border: 1px solid #EEE;
      display: flex;
      align-items: center;
      justify-content: center;
      margin: 20px;
    }
    .img img {
      max-width: 100%;
      max-height: 100%;
      cursor: pointer;
    }
  }

}
.dialog-grid{
  ::v-deep .el-dialog{
    height: calc(80vh);
    .el-dialog__body{
      height: calc(100% - 40px);
      &>div{
        height: 100%;
      }
    }
  }
}

::v-deep .el-table {
  border-right: 1px solid #dfe6ec;
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
            white-space: nowrap;
            overflow: hidden;
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
::v-deep .dialogColumnsFalse{
  width: 100%;
  height:calc(100% - 30px);
  border: 1px solid #ddd;
  display: flex;
  justify-content: center;
  align-items: center;
  color:#dfe6ec;
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

</style>
