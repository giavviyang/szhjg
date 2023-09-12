<template>
  <div>
    <el-dialog title="查看历史记录"  width="70%" :visible.sync="dialogViewing" append-to-body :close-on-click-modal="false"
               resize remember :close-on-press-escape="false" class="dialog-style dialog-basic dialog-tabulation">
      <div>
        <el-table row-key="id" :data="viewingList" border width="100%" height="calc(100% - 35px)" ref="viewingTable">
          <el-table-column type="selection" width="40"></el-table-column>
          <el-table-column align="center" :index="getIndex" type="index" label="序号" width="55"></el-table-column>
          <el-table-column align="center" v-for="(item,index) in viewingColumns" :formatter="item.formatter" :key="index"
                           :label="item.label" :prop="item.prop" :v-if="viewingColumns[index].isCol" :min-width="item.width"
                           show-overflow-tooltip/>
        </el-table>
        <div class="page" style="margin-top: 3px;">
          <el-pagination :page-sizes="[20, 30, 50, 100]" :page-size="pageSize" :current-page="pageNum" :total="total"
                         layout="total, sizes, prev, pager, next, jumper" @size-change="pageSizeS" :pager-count="5"
                         @current-change="pageCurrent"/>
        </div>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {viewCurrentUserRecord} from '@/api/szhjg/sjjg/approachCommon';


const params = {
  pageNum: 1,
  pageSize: 20
}
export default {
  name: "ViewingRecord",
  data() {
    return {
      dialogViewing: false,
      // 遮罩层
      loading: true,
      total: 0,
      pageNum: 1,
      pageSize: 20,
      gId: '',
      //列表
      viewingList: [],
      viewingColumns: [
        {label: '状态', prop: 'state', width: '80'},
        {label: '编号', prop: 'bh', width: '200'},
        {label: '件数', prop: 'jianShu', width: '80'},
        {label: '页数', prop: 'ys', width: '80'},
        {label: '领取时间', prop: 'claimTime', width: '150'},
        {label: '完成时间', prop: 'finishTime', width: '150'},
        {label: '修改意见', prop: 'xgyj', width: '200'},
      ],
    }
  },

  methods: {
    // 窗口初始化方法，nextTick方法可以添加逻辑，如打开窗口时查询数据填充
    init(bizId) {
      this.dialogViewing = true;
      this.$nextTick(() => {
        this.gId = bizId;
        this.queryList(bizId);
        this.dialogViewing = true;
      });
    },
    queryList(val){
      let params = {
        pageNum: 1,
        pageSize: 20,
        jggx:val,
      }
      this.queryCurrentList(params)
    },
    //分页
    pageCurrent(val) {
      this.pageNum = val
      params.pageNum = val
      params.pageSize = this.pageSize;
      params.jggx = this.gId;
      this.queryCurrentList(params)
    },
    pageSizeS(val) {
      this.pageSize = val
      params.pageSize = val;
      params.pageNum = this.pageNum;
      params.jggx = this.gId;
      this.queryCurrentList(params)
    },
    queryCurrentList(params){
      const _this = this
      viewCurrentUserRecord(params, {emulateJSON: true})
        .then(function (response) {
          _this.viewingList = response.rows;
          _this.total = response.total;
          _this.loading = false;
        })
    },


    //翻页后序号连贯
    getIndex($index) {
      return (this.pageNum - 1) * this.pageSize + $index + 1;
    },


  }
}
</script>

<style scoped lang="scss">
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
.dialog-tabulation{
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

.page {
  float: right;
  height: 32px;
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

</style>
