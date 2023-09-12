<template>
  <div>
    <el-dialog title="抽检" width="90%" :visible.sync="dialogFormVisible" :close-on-click-modal="false"
               :close-on-press-escape="false" class="dialog-style dialog-basic dialog-history"
               :before-close="beforeClose">
      <el-form :model="queryForm" ref="queryForm" size="small" :inline="true"
               style="height:40px;margin-top:5px;margin-bottom:0;">
        <el-form-item label="选择批次" prop="pcId">
          <el-cascader v-model="queryForm.pcId" :options="projectOptions" :props="projectProps" clearable size="mini"
                       filterable :show-all-levels="false" @change="handleChange"></el-cascader>
        </el-form-item>
        <el-form-item label="编号" prop="bh">
          <el-input v-model="queryForm.bh" clearable style="width: 200px" class="rt-input" size="mini"
                    @keyup.enter.native="toSearch"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="toSearch">搜索</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="fallBack">回退</el-button>
        </el-form-item>
      </el-form>
      <!--表单信息-->
      <div v-if="FrameColumns.length<=2" class="historyColumnsFalse">暂无数据</div>
      <div v-else>
        <el-table row-key="id" v-loading="loading" :data="dataList" border height="calc(100% - 40px)" ref="historyTable"
                  @row-click="RowClick" @selection-change="selectionChange" @select="toSelect" :row-style="checkClass"
                  highlight-current-row>
          <el-table-column type="selection" width="40"></el-table-column>
          <el-table-column align="center" type="index" label="序号" width="50"></el-table-column>
          <el-table-column align="center" v-for="(item,index) in FrameColumns" :key="index" :label="item.label"
                           :prop="item.prop" :min-width="item.width" show-overflow-tooltip :formatter="item.formatter"
                           :v-if="FrameColumns[index].isCol">
          </el-table-column>
        </el-table>
        <div class="page">
          <el-pagination :page-sizes="[20, 30, 50, 100]" :page-size="pageSize" :current-page="pageNum" :total="total"
                         layout="total, sizes, prev, pager, next, jumper" @size-change="pageSizeChange" :pager-count="5"
                         @current-change="pageCurrent"/>
        </div>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { completeProjectBatch } from "@/api/szhjg/check/spotCheckTask";
import { spotCheckDynamicList } from "@/api/szhjg/dynamicCommon";
import {getFallBack, historyList, querySamplingTime} from "@/api/szhjg/check/history";


const params = {
  pageNum: 1,
  pageSize: 20
}
export default {
  name: "index",
  data() {
    return {
      dialogFormVisible: false,
      loading: true,
      dataList: [],
      total: 0,
      queryForm: {
        pcId: [],
        bh: '',
      },
      pageNum: 1,
      pageSize: 20,
      projectOptions: [],
      //projectProps: {label: 'projectName', value: 'benId', children: 'pcName',emitPath:false},
      //emitPath: 表示是否返回所有节点的路径信息。默认情况下，该值为 false，即不返回所有节点的路径信息。
      projectProps: {label: 'projectName', value: 'benId', children: 'pcName'},
      FrameColumns: [],
      GridCheck: [],
      seleData: null,

      optionsSamplingTime: [],
    }
  },

  created() {},

  watch:{
    projectOptions(val){
      this.queryForm.pcId = [val[0].benId,val[0].pcName[0].benId];
      if(val[0].pcName[0].pcName.length > 0){
        this.queryForm.pcId = [val[0].benId,val[0].pcName[0].benId,val[0].pcName[0].pcName[0].benId]
      }
      this.tableHeaders(this.queryForm.pcId[2]);
      params.pcId = this.queryForm.pcId[2];
      this.getHistory(params);
    }
  },

  methods: {
    // 窗口初始化方法，nextTick方法可以添加逻辑，如打开窗口时查询数据填充
    init() {
      this.$nextTick(() => {
        this.queryOptions();
        this.samplingTimeList();
        this.dialogFormVisible = true;
      });
    },

    //查询项目批次
    queryOptions() {
      completeProjectBatch().then((res) => {
        this.projectOptions = res.data;
      })
    },
    //查询抽检时间
    samplingTimeList() {
      querySamplingTime().then(res => {
        this.optionsSamplingTime = res.map((item) => {
          return item;
        });
      })
    },

    //切换项目批次之后进行查询
    handleChange(value) {
      this.FrameColumns = [];
      this.dataList = [];
      this.tableHeaders(value[2]);
      params.pcId = value[2];
      this.getHistory(params)
    },
    //查询动态表头展示字段（案卷【任务/著录字段】）
    tableHeaders(dynamic){
      spotCheckDynamicList({headBatch: dynamic, headPoints: 0}).then((res) => {
        this.FrameColumns = res.data;
        // 添加两个默认的展示字段
        this.FrameColumns.push({label: '领取时间', prop: 'aTime', width: '150', formatter: this.SamplingOptions1});
        this.FrameColumns.push({label: '完成时间', prop: 'bTime', width: '150', formatter: this.SamplingOptions2});
      })
    },

    //转换时间
    SamplingOptions1(row, column, cellValue) {
      let result;
      cellValue = row.id;
      const arr = this.optionsSamplingTime;
      for (var i in arr) {
        if (cellValue == arr[i].value) {
          result = arr[i].label1;
        }
      }
      return result;
    },
    SamplingOptions2(row, column, cellValue) {
      let result;
      cellValue = row.id;
      const arr = this.optionsSamplingTime;
      for (var i in arr) {
        if (cellValue == arr[i].value) {
          result = arr[i].label2;
        }
      }
      return result;
    },

    //查询案卷列表
    getHistory(params) {
      const _this = this;
      historyList(params, {emulateJSON: true}).then(function (res) {
        _this.dataList = res.rows;
        _this.total = res.total;
        _this.loading = false;
      })
    },

    //搜索
    toSearch() {
      this.pageNum = 1;
      let params = {
        pageNum: 1,
        pageSize: 20,
        pcId: this.queryForm.pcId[2],
        bh: this.queryForm.bh,
      }
      this.getHistory(params)
    },
    //分页
    pageCurrent(val) {
      this.pageNum = val
      params.pageNum = val
      params.pageSize = this.pageSize;
      params.pcId = this.queryForm.pcId[2];
      params.bh = this.queryForm.bh;
      this.getHistory(params)
    },
    pageSizeChange(val) {
      this.pageSize = val
      params.pageSize = val;
      params.pageNum = this.pageNum;
      params.pcId = this.queryForm.pcId[2];
      params.bh = this.queryForm.bh;
      this.getHistory(params)
    },

    async toSelect(selection, row) {
      // 执行完清空操作在进行下面的勾选
      await this.$refs.historyTable.clearSelection();
      if (selection.length === 0) return;
      this.$refs.historyTable.toggleRowSelection(row, true);
    },
    //行点击事件
    RowClick(row, column) {
      this.$refs.historyTable.clearSelection();
      this.seleData = row
      if (this.GridCheck.length === 0) {
        this.$refs.historyTable.toggleRowSelection(row)
        return;
      }
      this.$refs.historyTable.toggleRowSelection(row)
    },
    //复选框事件
    selectionChange(val) {
      this.GridCheck = val;
    },
    checkClass({row, rowIndex}) {
      if (this.GridCheck.includes(row)) {
        return {
          "background": "#b9deff !important", "color": "blue",
        }
      } else {
        return {
          "——tablebackground": "#F5F7FA",
        }
      }
    },

    //回退
    fallBack() {
      if (this.seleData == null) {
        this.$message.warning('请先选择一条数据')
      } else {
        getFallBack({id: this.seleData.id}).then((res) => {
          if (res.code == 200) {
            this.toSearch()
            this.$message.success(res.msg)
          } else {
            this.$message.success(res.msg)
          }
        })
      }
    },


    //关闭页面弹窗
    beforeClose() {
      this.dialogFormVisible = false;
      this.$emit("HistoryCloseData", "刷新");
    },
  }
}
</script>

<style lang="scss" scoped>

.page {
  margin-top: 5px;
  text-align: right;
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

::v-deep .historyColumnsFalse{
  width: 100%;
  height:calc(100% - 40px);
  border: 1px solid #ddd;
  display: flex;
  justify-content: center;
  align-items: center;
  color:#dfe6ec;
}

::v-deep .el-table tbody tr:hover > td {
  background: var(--tablebackground) !important;
}

//表格鼠标悬浮时的样式 （高亮）
::v-deep {
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

    .img-viewr__wrapper {
      position: absolute;
    }

    ::v-deep .icon__circle-close {
      display: none;
    }

    ::v-deep .img-viewr__canvas {
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
.dialog-history{
  ::v-deep .el-dialog{
    height: calc(80vh);
    .el-dialog__body{
      height: 100%;
      &>div{
        height: calc(100% - 45px);
      }
    }
  }
}

</style>
