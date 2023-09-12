<template>
  <div>
    <el-dialog title="质检"  width="90%" :visible.sync="dialogFormVisible" append-to-body :close-on-click-modal="false" resize remember
               class="dialog-style dialog-basic" :close-on-press-escape="false" :before-close="beforeClose">
      <el-col :span="6" style="height: calc(100vh - 140px) ">
        <el-tabs type="border-card">
          <div class="form-basic">文件信息 :</div>
          <el-table v-loading="loading" :data="jianFrameList" border height="calc(100vh - 200px)"  ref="jianTable" @row-click="jianRowClick"
                    @selection-change="jianSelectionChange" @select="jianSelect" :row-style="jianClass" highlight-current-row>
            <el-table-column type="selection" width="40" ></el-table-column>
            <el-table-column align="center"  type="index" label="序号" width="50" :index="jianGetIndex"></el-table-column>
            <el-table-column align="center"  v-for="(item,index) in jianFrameColumns" :key="index" :label="item.label"
                             :prop="item.prop" :min-width="item.width" show-overflow-tooltip>
            </el-table-column>
          </el-table>
        </el-tabs>
      </el-col>
      <el-col :span="8" style="height: calc(100vh - 140px) ">
        <el-tabs type="border-card">
          <el-form ref="jianFileForm" :model="jianFileForm" :inline="true" label-width="90px">
            <el-form-item label="档号" prop="dh" v-if="daType!='2'">
              <el-input v-model="jianFileForm.dh" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="件号" prop="jh" v-if="daType!='2'">
              <el-input v-model="jianFileForm.jh" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="责任者" prop="zrz" v-if="daType!='2'">
              <el-input v-model="jianFileForm.zrz" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="题名" prop="tm" v-if="daType!='2'">
              <el-input v-model="jianFileForm.tm" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="形成时间" prop="xcsj" v-if="daType!='2'">
              <el-input v-model="jianFileForm.xcsj" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="民国纪年" prop="mgsj" v-if="daType!='2'">
              <el-input v-model="jianFileForm.mgsj" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="关键词" prop="gjc" v-if="daType!='2'">
              <el-input v-model="jianFileForm.gjc" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="附件题名" prop="fjtm" v-if="daType!='2'">
              <el-input v-model="jianFileForm.fjtm" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="附注" prop="fz" v-if="daType!='2'">
              <el-input v-model="jianFileForm.fz" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="分类号" prop="flh" v-if="daType!='2'">
              <el-input v-model="jianFileForm.flh" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="语种" prop="yz" v-if="daType!='2'">
              <el-input v-model="jianFileForm.yz" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="载体形态" prop="ztxt" v-if="daType!='2'">
              <el-input v-model="jianFileForm.ztxt" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="政权标识" prop="zqbs" v-if="daType!='2'">
              <el-input v-model="jianFileForm.zqbs" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="鉴定词汇" prop="jdch" v-if="daType!='2'">
              <el-input v-model="jianFileForm.jdch" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="控制标识" prop="kzbs" v-if="daType!='2'">
              <el-input v-model="jianFileForm.kzbs" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="密级" prop="mj" v-if="daType!='2'">
              <el-input v-model="jianFileForm.mj" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>

            <el-form-item label="材料分类" prop="clfl" v-if="daType=='2'">
              <el-input v-model="jianFileForm.clfl" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="材料名称" prop="clmc" v-if="daType=='2'">
              <el-input v-model="jianFileForm.clmc" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="类号" prop="cllh" v-if="daType=='2'">
              <el-input v-model="jianFileForm.cllh" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="制成时间-年" prop="makeYear" v-if="daType=='2'">
              <el-input v-model="jianFileForm.makeYear" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="制成时间-月" prop="makeMonth" v-if="daType=='2'">
              <el-input v-model="jianFileForm.makeMonth" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="制成时间-日" prop="makeDay" v-if="daType=='2'">
              <el-input v-model="jianFileForm.makeDay" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="备注" prop="remark" v-if="daType=='2'">
              <el-input v-model="jianFileForm.remark" clearable size="mini" placeholder="" style="width: 300px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>



          </el-form>
        </el-tabs>
      </el-col>
      <el-col :span="10" style="height: calc(100vh - 140px)">
        <div style="font-size:18px;font-weight: 700" v-if="urls.length>0">当前第{{ index + 1 }}张,共有{{ urls.length }}张图片</div>
        <div style="font-size:18px;font-weight: 700" v-else>暂无内容</div>
        <div class="form-basicimg">
          <ImgViewr v-if="visible" :visible="visible" :lockScroll="false" :closeOnClickMask="false" :urls="urls" :initialIndex="index" :on-show="onShow" :on-switch="changeHandle"
                    :on-close="() => (visible = false)"/>
        </div>
      </el-col>

    </el-dialog>
  </div>
</template>

<script>
import { queryCasePiece } from "@/api/szhjg/sjjg/sjzj";
import ImgViewr, {showImages} from "vue-img-viewr";
import 'vue-img-viewr/styles/index.css'
import {selectPictureImage} from "@/api/szhjg/szhjgCommon";

const params = {
  pageNum: 1,
  pageSize: 20
}
export default {
  components: {ImgViewr},

  name: "FileLists",

  props:{
  },

  data() {
    return {
      urls: [],
      index: 0,
      visible: false,
      dialogFormVisible: false,
      // 遮罩层
      loading: true,

      /*****************************     件级方法      ****************************************************************/
      totalJian: 0,
      pageNumJian: 1,
      pageSizeJian: 20,
      //案件复选框
      jianGridCheck: [],
      //列表
      jianFrameList: [],
      //表头
      jianFrameColumns: [
        /*{label: '编号', prop: 'dh', width: '200'},*/
        {label: '件号', prop: 'jh', width: '100'},
        {label: '页数', prop: 'ys', width: '80'},
        /*{label: '是否首页', prop: 'sfsy', width: '80'},
        {label: '责任者', prop: 'zrz', width: '100'},
        {label: '题名', prop: 'tm', width: '200'},
        {label: '形成时间', prop: 'xcsj', width: '150'},
        {label: '民国纪年', prop: 'mgsj', width: '150'},
        {label: '关键词', prop: 'gjc', width: '100'},
        {label: '附件题名', prop: 'fjtm', width: '100'},
        {label: '附注', prop: 'fz', width: '100'},
        {label: '分类号', prop: 'flh', width: '80'},
        {label: '语种', prop: 'yz', width: '80'},
        {label: '载体形态', prop: 'ztxt', width: '80'},
        {label: '政权标识', prop: 'zqbs', width: '80'},
        {label: '鉴定词汇', prop: 'jdch', width: '80'},
        {label: '控制标识', prop: 'kzbs', width: '80'},
        {label: '密级', prop: 'mj', width: '80'},
        {label: '修改意见', prop: 'xgyj', width: '200'},*/
      ],

      //字段名称
      jianFileForm: {
        dh: '', jh: '', zrz: '', tm: '', xcsj: '', mgsj: '', gjc: '', fz: '', fjtm: '', flh: '', yz: '', ztxt: '',
        zqbs: '', jdch: '', kzbs: '', mj: '', xgyj: '',
        //人事档案
        clfl: '', clmc: '', cllh: '', makeYear: '', makeMonth: '', makeDay: '', remark: '',
      },

      //档案类型类别
      daType: '',

    }
  },

  mounted() {

  },

  methods: {
    // 通过组件方式
    showImagesByComponent(index) {
      this.visible = true
      this.index = index|0
    },
    onShow(isShow) {
      console.log(isShow)
    },
    changeHandle(i) {
      this.index = i
      console.log(`current image index: ${i}`)
    },
    showImagesByJs(index) {
      // 通过js方式显示
      showImages({
        urls: this.urls,
        index,
        onShow: this.onShow,
        onClose: () => {
          console.log('close with js')
          return true
        },
      })
    },
    // 窗口初始化方法，nextTick方法可以添加逻辑，如打开窗口时查询数据填充
    init(bizId,bizDalx) {
      this.dialogFormVisible = true;
      this.$nextTick(() => {
        if (bizDalx== "人事档案"){
          this.daType = "2"
        }else {
          this.daType = "1"
        }
        this.queryCaseList(bizId);
        this.dialogFormVisible = true;
      });
    },
    //关闭页面弹窗
    beforeClose(){
      this.dialogFormVisible = false;
      this.$emit("beforeCloseData","刷新");
    },


    /*****************************     案件方法      *******************************************************************/
    queryCaseList(val){
      const _this = this
      let params = {
        pageNum: 1,
        pageSize: 20,
        ajId:val,
      }
      queryCasePiece(params, {emulateJSON: true})
        .then(function (response) {
          _this.jianFrameList = response.rows;
          _this.totalJian = response.total;
          _this.loading = false;
        })
    },
    // 分页
    pageCurrentJian(val) {
      this.pageNumJian = val
      params.pageNum = val
      params.pageSize = this.pageSizeJian;
      this.queryBatchList(params)
    },
    pageSizeSJian(val) {
      this.pageSizeJian = val
      params.pageSize = val;
      params.pageNum = this.pageNumJian;
      this.queryBatchList(params)
    },
    //复选框事件
    jianSelectionChange(val) {
      // console.log(val)
      this.jianGridCheck = val;
      if (this.jianGridCheck.length == 1){
        this.jianFileForm = this.jianGridCheck[0];
      }

    },
    //行点击事件
    jianRowClick(row, column) {
      this.getImage(row)
      this.$refs.jianTable.clearSelection();
      if (this.jianGridCheck.length === 0) {
        this.$refs.jianTable.toggleRowSelection(row)
        return;
      }
      this.$refs.jianTable.toggleRowSelection(row)
    },
    getImage(row){
      selectPictureImage({jh:row.jh,ajId:row.ajId}).then((res)=>{
        this.urls = res.data.imgs.map((item, index) => {
          return `${process.env.VUE_APP_BASE_API}/szhjgCommonController/ioReadImg2?url=${encodeURIComponent(item)}`;
        });
        this.showImagesByComponent()
      })
    },
    async jianSelect(selection, row) {
      // 执行完清空操作在进行下面的勾选
      await this.$refs.jianTable.clearSelection();
      if (selection.length === 0) return;
      this.$refs.jianTable.toggleRowSelection(row, true);
    },
    jianClass( { row,rowIndex }) {
      if (this.jianGridCheck.includes(row)){
        return {"background":"#b9deff !important", "color": "blue",}
      } else {
        return {"——tablebackground" : "#F5F7FA",}
      }
    },
    //翻页后序号连贯
    jianGetIndex($index) {
      return (this.pageNumJian - 1) * this.pageSizeJian + $index + 1;
    },


  }

}
</script>

<style scoped lang="scss">

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

::v-deep .el-tabs__content {
  padding: 10px;
  height: calc(100vh - 140px);
  overflow: auto;
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

//弹框样式
.dialog-style {
  ::v-deep .el-dialog__body {
    padding: 5px;
  }
  ::v-deep .el-dialog__header {
    background: rgba(204, 204, 204, 0.18);
    padding: 10px;
  }
  ::v-deep .el-dialog__title {
    font-weight: 500;
    font-size: 15px
  }
  ::v-deep .el-dialog__headerbtn {
    top: 13px;
  }
  ::v-deep .el-dialog__footer {
    background: rgba(204, 204, 204, 0.18);
    padding-right: 15px;
    padding: 8px;
  }
  ::v-deep .el-button + .el-button {
    margin-left: 6px;
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

  .form-basicimg{
    position: relative;
    height: calc(100% - 23px);
    margin-bottom: 5px;
    line-height: 25px;
    border-bottom: 1px solid #ccc;
    //margin-left: 15px;
    //margin-right: 15px;
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
//弹窗样式修改
::v-deep .el-dialog {
  display: flex;
  flex-direction: column;
  margin: 0 !important;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  max-height: calc(100% - 30px);
  max-width: calc(100% - 30px);
}

//禁止输入框输入,字体颜色黑色
.rt-input ::v-deep .el-input__inner{
  color:  #000000;
}
</style>
