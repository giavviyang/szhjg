<template>
  <div class="tableContainer">
    <div class="table" ref="table">
      <slot name="table"/>
    </div>
    <div class="page" v-if="isPage">
      <el-pagination
        :page-size="pageSize"
        :current-page="pageNum"
        :total="total"
        :page-sizes="[20, 30, 50, 100]"
        layout="total, sizes, prev, pager, next, jumper"
        @size-change="handleSizeChange"
        @current-change="handlePageNum"/>
    </div>
  </div>
</template>

<script>
export default {
  name: "SlotTable",
  props: {
    //单页数据量
    pageSize: {
      type: Number,
      default: 20
    },
    //当前页码
    pageNum: {
      type: Number,
      default: 1
    },
    //分页数据总数
    total: {
      type: Number,
      default: 0
    },
    isPage:{
      type:Boolean,
      default:true
    }
  },
  data(){
    return{
      tableContainer:'',
      tableHeight:''
    }
  },
  mounted() {
    // let tableContainer=
    this.tableContainer=document.querySelector('.tableContainer');
    // watch:{
    //   height:{
    //     let tableContainer=
    //   },
  },
  methods: {
    handleSizeChange(pageSize) {
      this.$emit('handleChange', pageSize, this.pageNum);
    },
    handlePageNum(pageNum) {
      this.$emit('handleChange', this.pageSize, pageNum);
    },
  }
}
</script>

<style lang="scss" scoped>

.tableContainer {
  width: 100%;
  height: 100%;
  $fontSize: 12px;
  //ie浏览器兼容
  box-sizing: content-box;
  -moz-box-sizing: inherit;
  -webkit-box-sizing: inherit;

  .table {
    height: calc(100% - 38px);
    overflow: hidden;

    ::v-deep .el-table {
      border-right:1px solid #dfe6ec;
      //height: 100%;
      color: #515a6e;
      //border: 3px rgba(204, 204, 204, 0.18) solid;
      //overflow: auto;

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
  }

  .page {
    height: 38px;
    text-align: right;

    ::v-deep .el-pagination {
      height: 28px;
      //position: relative;
      margin-top: 5px;
      font-size: $fontSize;

      & > .el-pagination__total {
        font-size: $fontSize;
      }

      & > .el-pagination__sizes {
        .el-input {
          input {
            font-size: $fontSize;
            height: 26px;
          }
        }
      }
      button {
        background-color: transparent;
      }

      & > .el-pager {
        li {
          font-size: $fontSize;
          background-color: transparent;
        }
      }

      & > .el-pagination__jump {
        font-size: $fontSize;

        .el-input {
          input {
            font-size: $fontSize;
            height: 26px;
          }
        }
      }
    }
  }
}
</style>
