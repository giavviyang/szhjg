<template>
  <div class="dashboard-editor-container">
    <div class="dashboard-top">
      <el-form :model="queryForm" ref="queryForm" class="search-form" size="small" :inline="true" @submit.native.prevent >
        <el-form-item label="工序" prop="name">
          <el-select v-model="queryForm.name" size="mini" placeholder="请选择工序" style="width:150px" @keyup.enter.native="search">
            <el-option label="添加任务" value="添加任务"></el-option>
            <el-option label="分件" value="分件"></el-option>
            <el-option label="图像扫描" value="图像扫描"></el-option>
            <el-option label="图像处理" value="图像处理"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="起始时间" @keyup.enter.native="search" prop="startDate">
          <el-date-picker v-model="queryForm.startDate"  value-format="yyyy-MM-dd" placeholder="" type="date" clearable
                          style="width: 150px" size="mini"/>
        </el-form-item>
        <el-form-item label="结束时间" @keyup.enter.native="search" prop="endDate">
          <el-date-picker v-model="queryForm.endDate"  value-format="yyyy-MM-dd" placeholder="" type="date" clearable
                          style="width: 150px" size="mini"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="search"
                     v-hasPermi="['szhjg:tongji:gzltj:search']">统计</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div class="dashboard-down">
      <el-table row-key="id" :data="tableData" height="calc(100% - 90px)" slot="table" :show-overflow-tooltip="true" border
                ref="tableGrid" @row-click="StepsListRowClick" @selection-change="handleSelectionChange">
        <el-table-column :show-overflow-tooltip="true" type="index" width="55" label="序号"/>
        <el-table-column show-overflow-tooltip  v-for="(item, index) in columnOptions" :formatter="item.formatter"
                         :v-if="columnOptions[index].isCol" :key="index" :prop="item.prop" :label="item.label"/>
      </el-table>
      <div class="paging">
        <el-pagination :page-sizes="[20, 30, 50, 100]"
                       :page-size="pageSize"
                       :current-page="pageNum"
                       @size-change="handleSizeChange"
                       @current-change="handleCurrentChange"
                       layout="total, sizes, prev, pager, next, jumper"
                       :total="total">

        </el-pagination>
      </div>
    </div>
  </div>
</template>

<script>

const params = {
  pageNum: 1,
  pageSize: 20
}

export default {
  name: "index",
  data() {
    return {
      //总页数
      total: 0,
      pageNum: 1,
      pageSize: 20,
      //搜索
      queryForm: {
        name: '',       //起始时间
        startDate: '',  //起始时间
        endDate: '',    //终止时间
      },
      //复选框选中
      gridCheck: [],

      tableData: [
        {name: '张一', gx: '分件', juans: '10', jians: '100',  },
        {name: '赵二', gx: '扫描', juans: '40', jians: '70',  },
        {name: '李三', gx: '质检', juans: '77', jians: '210',  },
        {name: '王四', gx: '著录', juans: '33', jians: '200',  }
      ],

      columnOptions: [
        {label: '用户姓名', prop: 'name', isCol: true},
        {label: '工序', prop: 'gx', isCol: true},
        {label: '卷数', prop: 'juans', isCol: true},
        {label: '件数', prop: 'jians', isCol: true},
        {label: '页数', prop: 'ys', isCol: true},
        {label: '折算A4', prop: 'zsa4', isCol: true},
      ],

    }
  },

  methods: {
    //搜索
    search(){
      let params = {
        pageNum: 1,
        pageSize: 20,
        name: this.queryForm.name,
        startDate: this.queryForm.startDate,
        endDate: this.queryForm.endDate,
      }
      this.userTabeGrid(params)
    },
    //分页
    handleSizeChange(val) {
      this.pageSize = val
      params.pageSize = val;
      params.pageNum = this.pageNum;
      this.userTabeGrid(params)
    },
    handleCurrentChange(val) {
      this.pageNum = val
      params.pageNum = val
      params.pageSize = this.pageSize;
      this.userTabeGrid(params)
    },
    userTabeGrid(params) {
      alert(JSON.stringify(params))
    },

    StepsListRowClick(row) {
      console.log(row)
      this.$refs.tableGrid.clearSelection()
      if (this.gridCheck.length === 0) {
        this.$refs.tableGrid.toggleRowSelection(row)
        return;
      }
      this.$refs.tableGrid.toggleRowSelection(row)
    },
    // 复选框事件
    handleSelectionChange(val) {
      this.gridCheck = val;
    },

  }
}
</script>

<style lang="scss" scoped>
.dashboard-editor-container {
  padding: 10px;
  width: 100%;
  height: 100%;

  .dashboard-top {
    width: 100%;
    display: flex;
    align-items: center;
    height: 48px;
    //搜索框样式
    .search-form {
      width: 100%;
      padding: 10px;
      display: flex;
      ::v-deep .el-form-item {
        margin-bottom: 0 !important;
      }
      //按钮左侧距离
      .el-button--mini {
        margin-left: 5px;
      }
    }
  }

  .dashboard-down {
    width: 100%;
    height: 100%;
    //background:rgba(204, 204, 204, 0.18);
  }
  //分页
  .paging {
    width: 100%;
    display: block;
    text-align: right;
    margin-top: 10px;
  }

}

::v-deep .el-table {
  border-right:0 solid #dfe6ec;
  color: #515a6e;
  & > .el-table__header-wrapper {
    & > table {
      tr:first-of-type {
        th {
          background: rgba(204, 204, 204, 0.18);
          color: #515a6e;
          font-size: 12px;
          text-align: center;
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

</style>
