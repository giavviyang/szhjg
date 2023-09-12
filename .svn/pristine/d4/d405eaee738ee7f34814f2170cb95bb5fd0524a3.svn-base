<template>
  <div class="tableContainer">
    <div class="table" :class="{tableHeight:isPage}">
      <el-table :data="tableData" style="width: 100%" stripe border height="100%" ref="tableRef"
                @selection-change="handleSelectionChange" @row-click="handleRowClick" :row-style="{height:'20px'}"
      >
        <el-table-column type="selection" width="50" v-if="hasSelection"></el-table-column>
        <el-table-column v-if="showNumber" type="index" :index="getIndex" label="序号" width="55" show-overflow-tooltip></el-table-column>
        <slot name="table"/>
      </el-table>
    </div>
    <div class="page" :class="{pageHeight:isPage}">
      <el-pagination
        :page-size="pageSize"
        :current-page="pageNum"
        :total="total"
        :page-sizes="[20, 30, 50, 100]"
        layout="total, sizes, prev, pager, next, jumper"
        @size-change="handleSizeChange"
        @current-change="handlePageNum"
        :pager-count="5"/>
    </div>
  </div>
</template>
<script>
export default {
  name: "TablePage",
  props: {
    showNumber:{
      type: Boolean,
      default: true
    },
    // 表格复选框
    hasSelection: {
      type: Boolean,
      default: true
    },
    // 表格数据
    tableData: {
      type: Array,
      default: () => []
    },
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
    isPage: {
      type: Boolean,
      default: true
    }
  },
  data() {
    return {
      tableContainer: '',
      tableHeight: ''
    }
  },
  mounted() {
    let multipleTable = this.$refs.tableRef.$refs.bodyWrapper;
    multipleTable.addEventListener('scroll', () => {
      // 滚动距离
      const scrollLeft = multipleTable.scrollLeft
      this.$refs.tableRef.$refs.headerWrapper.scrollLeft = scrollLeft
    })
  },
  updated() {
    this.$nextTick(() => {
      this.$refs.tableRef.doLayout();
    })
  },
  methods: {
    /* 翻页后序号连贯 */
    getIndex($index) {
      //  表格序号
      return (this.pageNum - 1) * this.pageSize + $index + 1;
    },
    handleSelectionChange(selection) {
      this.$emit('handleSelectionChange', selection);
    },
    handleRowClick(row, column, event) {
      this.$emit('handleRowClick', {row, column, event});
      this.$refs.tableRef.toggleRowSelection(row, column)
    },
    // handleCellClick(row, column, cell, event){
    //   this.$emit('handleCellClick', {row, column, cell, event});
    // },
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
    height: 100%;
    //height: calc(100% - 38px);
    overflow: hidden;

    ::v-deep .el-table {
      border-right: 1px solid #dfe6ec;
      color: #606266;

      th {
        height: 34px !important;
      }

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
              color: #606266;
              font-size: 12px;
              text-align: center;
              padding: 0 !important;
              height: 34px;

              .el-input__inner {
                border: none;
                padding: 0;
                height: 20px;
              }

              .el-input__suffix {
                width: 12px;

                .el-input__icon {
                  line-height: 23px;
                }
              }
            }
          }

          //& > colgroup {
          //  col {
          //    &:last-of-type {
          //      width: 17px !important;
          //    }
          //  }
          //}
        }
      }

      .el-table__body-wrapper {
        //overflow: auto !important;

        .el-table__row {
          td {
            text-align: center;
            padding: 5px 0 !important;
            font-size: 12px;

            .el-input.is-disabled .el-input__inner {
              color: #606266;
            }

            .el-radio {
              margin-right: 20px;
              font-size: 12px;

              .el-radio__input {
                .el-radio__inner {
                  width: 10px;
                  height: 10px;
                }
              }

              .el-radio__label {
                font-size: 12px;
                padding-left: 5px;
                font-weight: 400;
              }
            }

            .el-radio:last-of-type {
              margin-right: 0;
            }
          }

          .operation {
            .cell {
              display: flex;
              justify-content: space-around;
              width: 100%;
              white-space: nowrap;
              overflow: hidden;
              text-overflow: ellipsis;

              .el-button {
                width: 100%;
                height: 100%;
                position: relative;
                top: 0;
                right: 0;
                margin: 0 2px;
                font-size: 12px;
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
  }

  .page {
    //height: 38px;
    display: none;
    text-align: right;

    ::v-deep .el-pagination {
      height: 28px;
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

  .tableHeight {
    height: calc(100% - 38px);
  }

  .pageHeight {
    height: 38px;
    display: block;
  }
}

</style>
