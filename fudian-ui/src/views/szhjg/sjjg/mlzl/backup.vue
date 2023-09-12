<!--动态修改第一版  时间：2023.05.17-->
<template>
  <div class="dashboard-editor-container">
    <!--搜索框-->
    <div style="height: 38px; padding: 3px 0 3px 10px;;margin-bottom: 6px;border-radius: 8px;">
      <el-form :model="queryForm" ref="queryForm" size="small" :inline="true">
        <el-form-item label="选择批次" prop="pcId" >
          <el-cascader v-model="queryForm.pcId" :options="projectOptions" :props="projectProps" clearable size="mini"
                       filterable :show-all-levels="false" style="width: 120px;height: 28px;line-height: 28px;">
          </el-cascader>
        </el-form-item>
        <el-form-item label="编号" prop="bianHao">
          <el-input v-model="queryForm.bianHao" placeholder="请输入查询内容" clearable style="width: 200px" size="mini"
                    @keyup.enter.native="batchSearch"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="batchSearch">搜索</el-button>
          <el-button type="success" plain icon="el-icon-s-promotion" size="mini" style="margin-left:30px;"
                     @click="submitTask">任务提交</el-button>
          <el-button type="warning" plain icon="el-icon-circle-close" size="mini" @click="submitRework">返工</el-button>
          <el-button type="info" icon="el-icon-edit-outline" size="mini" @click="viewRecord">查看记录</el-button>
        </el-form-item>
      </el-form>
    </div>
    <!--表格-->
    <div class="chart-wrapper">
      <div style="height: 50%">
        <div class="form-basic">案卷信息 :</div>
        <el-table row-key="id" :data="juanFrameList" border  height="80%" ref="juanTable" slot="table"
                  @selection-change="juanSelectionChange" @row-click="juanRowClick" @select="juanSelect"
                  :row-style="juanClass">
          <!--<el-table-column type="selection" width="40"/>-->
          <el-table-column align="center" type="index" label="序号" width="55" :index="juanGetIndex"/>
          <el-table-column align="center" v-for="(item,index) in juanFrameColumns" :key="index" :label="item.label"
                           :prop="item.prop" :min-width="item.width" show-overflow-tooltip></el-table-column>
          <el-table-column align="center" label="操作" width="120">
            <template slot-scope="scope">
              <el-button type="text" size="mini" @click="descriptionFile(scope.row)">案卷著录</el-button>
            </template>
          </el-table-column>
        </el-table>
        <div class="block" style="float: right;margin-top: 2px">
          <el-pagination :page-sizes="[20, 50, 100, 200]" :page-size="pageSizeJuan" :current-page="pageNumJuan"
                         layout="total, sizes, prev, pager, next, jumper" :total="totalJuan" @size-change="pageSizeSJuan"
                         @current-change="pageCurrentJuan" :pager-count="5"/>
        </div>
      </div>
      <div style="height: 65%">
        <div class="form-basic">文件信息 :</div>
        <el-table :data="jianFrameList" border  height="75%" ref="jianTable" slot="table" @select="jianSelect"
                  @selection-change="jianSelectionChange" @row-click="jianRowClick"  :row-style="jianClass" >
          <!--<el-table-column type="selection" width="40"/>-->
          <el-table-column align="center" type="index" label="序号" width="55" show-overflow-tooltip
                           :index="jianGetIndex"/>
          <el-table-column align="center" v-for="(item,index) in jianFrameColumns" :key="index" :label="item.label"
                           :prop="item.prop" :min-width="item.width" show-overflow-tooltip></el-table-column>
          <el-table-column align="center" label="操作" width="120">
            <template slot-scope="scope">
              <el-button type="text" size="mini"  @click="descriptionPiece(scope.row)">文件著录</el-button>
            </template>
          </el-table-column>
        </el-table>
        <div class="block" style="float: right;margin-top: 2px">
          <el-pagination :page-sizes="[20, 50, 100, 200]" :page-size="pageSizeJian" :current-page="pageNumJian"
                         layout="total, sizes, prev, pager, next, jumper" :total="totalJian" @size-change="pageSizeSJian"
                         @current-change="pageCurrentJian" :pager-count="5"/>
        </div>
      </div>
    </div>

    <el-dialog title="案卷著录" :visible.sync="dialogFormVisible1" width="35%" append-to-body  resize remember
               class="dialog-style dialog-basic" :close-on-click-modal="false" :close-on-press-escape="false"
               :before-close="handleClose1">
      <el-col :span="24" style="height: calc(100vh - 140px) ">
        <el-button size="mini" plain type="primary" style="margin-bottom: 5px"
                   @click="insertFileDescription('juanFileForm')">保 存</el-button>
        <el-tabs type="border-card">
          <el-form ref="juanFileForm" :model="juanFileForm" :rules="juanFileRules" :inline="true" label-width="100px">
            <br>
            <el-row><el-col :span="24">
              <el-form-item label="全宗名称" prop="qzmc" v-if="daType!='2'">
                <el-input v-model="juanFileForm.qzmc" clearable size="mini" placeholder="" style="width: 200px"
                          ref="input1" @keyup.enter.native="handelTab(1,$event)"/>
              </el-form-item>
            </el-col></el-row>
            <el-row><el-col :span="24">
              <el-form-item label="案卷题名" prop="ajtm" v-if="daType!='2'">
                <el-input v-model="juanFileForm.ajtm" clearable size="mini" placeholder="" style="width: 200px"
                          ref="input2" @keyup.enter.native="handelTab(2,$event)"/>
              </el-form-item>
            </el-col></el-row>
            <el-row><el-col :span="24">
              <el-form-item label="起始时间" prop="qssj" v-if="daType!='2'">
                <el-input v-model="juanFileForm.qssj" clearable size="mini" placeholder="" style="width: 200px"
                          ref="input3" @keyup.enter.native="handelTab(3,$event)"/>
              </el-form-item>
            </el-col></el-row>
            <el-row><el-col :span="24">
              <el-form-item label="终止时间" prop="zzsj" v-if="daType!='2'">
                <el-input v-model="juanFileForm.zzsj" clearable size="mini" placeholder="" style="width: 200px"
                          ref="input4" @keyup.enter.native="handelTab(4,$event)"/>
              </el-form-item>
            </el-col></el-row>
            <el-row><el-col :span="24">
              <el-form-item label="附注" prop="fz" v-if="daType!='2'">
                <el-input v-model="juanFileForm.fz" clearable size="mini" placeholder="" style="width: 200px"
                          ref="input5" @keyup.enter.native="handelTab(5,$event)"/>
              </el-form-item>
            </el-col></el-row>
            <el-row><el-col :span="24">
              <el-form-item label="备考表说明" prop="bkbsm" v-if="daType!='2'">
                <el-input v-model="juanFileForm.bkbsm" clearable size="mini" placeholder="" style="width: 200px"
                          ref="input6" @keyup.enter.native="handelTab(6,$event)"/>
              </el-form-item>
            </el-col></el-row>

            <el-row><el-col :span="24">
              <el-form-item label="姓名" prop="xm" v-if="daType=='2'">
                <el-input v-model="juanFileForm.xm" clearable size="mini" placeholder="" style="width: 200px"/>
              </el-form-item>
            </el-col></el-row>
            <el-row><el-col :span="24">
              <el-form-item label="性别" prop="xb" v-if="daType=='2'">
                <el-select v-model="juanFileForm.xb" placeholder="" clearable  size="mini" style="width:200px">
                  <el-option label="男" value="男"></el-option>
                  <el-option label="女" value="女"></el-option>
                </el-select>
              </el-form-item>
            </el-col></el-row>
            <el-row><el-col :span="24">
              <el-form-item label="出生日期" prop="csrq" v-if="daType=='2'">
                <el-date-picker v-model="juanFileForm.csrq" clearable size="mini" placeholder="" type="date"
                                value-format="yyyy-MM-dd" :picker-options="pickerOptions" style="width:200px"/>
              </el-form-item>
            </el-col></el-row>
            <el-row><el-col :span="24">
              <el-form-item label="民族" prop="mz" v-if="daType=='2'">
                <el-select v-model="juanFileForm.mz" placeholder="" clearable  size="mini" style="width:200px">
                  <el-option label="汉族" value="汉族"></el-option>
                  <el-option label="回族" value="回族"></el-option>
                  <el-option label="藏族" value="藏族"></el-option>
                  <el-option label="维吾尔族" value="维吾尔族"></el-option>
                </el-select>
              </el-form-item>
            </el-col></el-row>
            <el-row><el-col :span="24">
              <el-form-item label="证件类型" prop="zjlx" v-if="daType=='2'">
                <el-select v-model="juanFileForm.zjlx" clearable  size="mini" placeholder="" style="width:200px">
                  <el-option label="居民身份证" value="居民身份证"></el-option>
                  <el-option label="其他" value="其他"></el-option>
                </el-select>
              </el-form-item>
            </el-col></el-row>
            <el-row><el-col :span="24">
              <el-form-item label="证件号码" prop="zjhm" v-if="daType=='2'">
                <el-input v-model="juanFileForm.zjhm" clearable size="mini" placeholder="" style="width: 200px"/>
              </el-form-item>
            </el-col></el-row>
            <el-row><el-col :span="24">
              <el-form-item label="参加组织时间" prop="cjzzsj" v-if="daType=='2'">
                <el-date-picker v-model="juanFileForm.cjzzsj" clearable size="mini" placeholder="" type="date"
                                value-format="yyyy-MM-dd" :picker-options="pickerOptions" style="width:200px"/>
              </el-form-item>
            </el-col></el-row>
            <el-row><el-col :span="24">
              <el-form-item label="参加工作时间" prop="cjgzsj" v-if="daType=='2'">
                <el-date-picker v-model="juanFileForm.cjgzsj" clearable size="mini" placeholder="" type="date"
                                value-format="yyyy-MM-dd" :picker-options="pickerOptions" style="width:200px"/>
              </el-form-item>
            </el-col></el-row>
          </el-form>
        </el-tabs>
      </el-col>
    </el-dialog>

    <el-dialog title="文件著录" :visible.sync="dialogFormVisible2" width="80%" append-to-body resize remember
               class="dialog-style dialog-basic" :close-on-click-modal="false" :close-on-press-escape="false">
      <el-col :span="8" style="height: calc(100vh - 140px) ">
        <el-button size="mini" plain type="primary" style="margin-bottom: 5px" @click="insertPieceDescription('jianFileForm')">保 存</el-button>
        <el-tabs type="border-card">
          <el-form ref="jianFileForm" :model="jianFileForm" :rules="jianFileRules" :inline="true" label-width="100px">
            <el-form-item label="档号" prop="dh" v-if="daFileType=='1'">
              <el-input v-model="jianFileForm.dh" clearable size="mini" placeholder="请输入档号" style="width: 200px"
                        ref="inputFile1" @keyup.enter.native="handelFileTab(1,$event)"/>
            </el-form-item>
            <el-form-item label="件号" prop="jh" v-if="daFileType=='1'">
              <el-input v-model="jianFileForm.jh" clearable size="mini" placeholder="请输入件号" style="width: 200px"
                        ref="inputFile2" @keyup.enter.native="handelFileTab(2,$event)"/>
            </el-form-item>
            <el-form-item label="责任者" prop="zrz" v-if="daFileType=='1'">
              <el-input v-model="jianFileForm.zrz" clearable size="mini" placeholder="" style="width: 200px"
                        ref="inputFile3" @keyup.enter.native="handelFileTab(3,$event)"/>
            </el-form-item>
            <el-form-item label="题名" prop="tm" v-if="daFileType=='1'">
              <el-input v-model="jianFileForm.tm" clearable size="mini" placeholder="" style="width: 200px"
                        ref="inputFile4" @keyup.enter.native="handelFileTab(4,$event)"/>
            </el-form-item>
            <el-form-item label="形成时间" prop="xcsj" v-if="daFileType=='1'">
              <el-input v-model="jianFileForm.xcsj" clearable size="mini" placeholder="" style="width: 200px"
                        ref="inputFile5" @keyup.enter.native="handelFileTab(5,$event)"/>
            </el-form-item>
            <el-form-item label="民国纪年" prop="mgsj" v-if="daFileType=='1'">
              <el-input v-model="jianFileForm.mgsj" clearable size="mini" placeholder="" style="width: 200px"
                        ref="inputFile6" @keyup.enter.native="handelFileTab(6,$event)"/>
            </el-form-item>
            <el-form-item label="关键词" prop="gjc" v-if="daFileType=='1'">
              <el-input v-model="jianFileForm.gjc" clearable size="mini" placeholder="" style="width: 200px"
                        ref="inputFile7" @keyup.enter.native="handelFileTab(7,$event)"/>
            </el-form-item>
            <el-form-item label="附件题名" prop="fjtm" v-if="daFileType=='1'">
              <el-input v-model="jianFileForm.fjtm" clearable size="mini" placeholder="" style="width: 200px"
                        ref="inputFile8" @keyup.enter.native="handelFileTab(8,$event)"/>
            </el-form-item>
            <el-form-item label="附注" prop="fz" v-if="daFileType=='1'">
              <el-input v-model="jianFileForm.fz" clearable size="mini" placeholder="" style="width: 200px"
                        ref="inputFile9" @keyup.enter.native="handelFileTab(9,$event)"/>
            </el-form-item>
            <el-form-item label="分类号" prop="flh" v-if="daFileType=='1'">
              <el-input v-model="jianFileForm.flh" clearable size="mini" placeholder="" style="width: 200px"
                        ref="inputFile10" @keyup.enter.native="handelFileTab(10,$event)"/>
            </el-form-item>
            <el-form-item label="语种" prop="yz" v-if="daFileType=='1'">
              <el-input v-model="jianFileForm.yz" clearable size="mini" placeholder="" style="width: 200px"
                        ref="inputFile11" @keyup.enter.native="handelFileTab(11,$event)"/>
            </el-form-item>
            <el-form-item label="载体形态" prop="ztxt" v-if="daFileType=='1'">
              <el-input v-model="jianFileForm.ztxt" clearable size="mini" placeholder="" style="width: 200px"
                        ref="inputFile12" @keyup.enter.native="handelFileTab(12,$event)"/>
            </el-form-item>
            <el-form-item label="政权标识" prop="zqbs" v-if="daFileType=='1'">
              <el-input v-model="jianFileForm.zqbs" clearable size="mini" placeholder="" style="width: 200px"
                        ref="inputFile13" @keyup.enter.native="handelFileTab(13,$event)"/>
            </el-form-item>
            <el-form-item label="鉴定词汇" prop="jdch" v-if="daFileType=='1'">
              <el-input v-model="jianFileForm.jdch" clearable size="mini" placeholder="" style="width: 200px"
                        ref="inputFile14" @keyup.enter.native="handelFileTab(14,$event)"/>
            </el-form-item>
            <el-form-item label="控制标识" prop="kzbs" v-if="daFileType=='1'">
              <el-input v-model="jianFileForm.kzbs" clearable size="mini" placeholder="" style="width: 200px"
                        ref="inputFile15" @keyup.enter.native="handelFileTab(15,$event)"/>
            </el-form-item>
            <el-form-item label="密级" prop="mj" v-if="daFileType=='1'">
              <el-input v-model="jianFileForm.mj" clearable size="mini" placeholder="" style="width: 200px"
                        ref="inputFile16" @keyup.enter.native="handelFileTab(16,$event)"/>
            </el-form-item>
            <el-form-item label="修改意见" prop="xgyj" v-if="daFileType=='1'">
              <el-input v-model="jianFileForm.xgyj" clearable size="mini" placeholder="" style="width: 200px"
                        ref="inputFile17" @keyup.enter.native="handelFileTab(17,$event)"/>
            </el-form-item>

            <el-form-item label="材料分类" prop="clfl" v-if="daFileType=='2'">
              <el-select v-model="jianFileForm.clfl" placeholder="" clearable  size="mini" style="width:200px" @change="checkPersonnel">
                <el-option v-for="item in clflOptions" :key="item.value" :label="item.label" :value="item.value" :disabled="item.disabled"/>
              </el-select>
            </el-form-item>
            <el-form-item label="材料名称" prop="clmc" v-if="daFileType=='2'">
              <el-input v-model="jianFileForm.clmc" clearable size="mini" placeholder="" style="width: 200px"/>
            </el-form-item>
            <el-form-item label="类号" prop="cllh" v-if="daFileType=='2'">
              <el-input v-model="jianFileForm.cllh" clearable size="mini" placeholder="" style="width: 200px"
                        :disabled="true" class="rt-input"/>
            </el-form-item>
            <el-form-item label="制成时间-年" prop="makeYear" v-if="daFileType=='2'">
              <el-input v-model="jianFileForm.makeYear" clearable size="mini" placeholder="" style="width: 200px"/>
            </el-form-item>
            <el-form-item label="制成时间-月" prop="makeMonth" v-if="daFileType=='2'">
              <el-input v-model="jianFileForm.makeMonth" clearable size="mini" placeholder="" style="width: 200px"/>
            </el-form-item>
            <el-form-item label="制成时间-日" prop="makeDay" v-if="daFileType=='2'">
              <el-input v-model="jianFileForm.makeDay" clearable size="mini" placeholder="" style="width: 200px"/>
            </el-form-item>
            <el-form-item label="备注" prop="remark" v-if="daFileType=='2'">
              <el-input v-model="jianFileForm.remark" clearable size="mini" placeholder="" style="width: 200px"/>
            </el-form-item>

          </el-form>
        </el-tabs>
      </el-col>
      <!--图像-->
      <el-col :span="16" style="height: calc(100vh - 140px)">
        <div style="font-size:18px;font-weight: 700" v-if="urls.length>0">当前第{{ index + 1 }}张,共有{{ urls.length }}张图片</div>
        <div style="font-size:18px;font-weight: 700" v-else>暂无内容</div>
        <div class="form-basicimg">
          <ImgViewr v-if="visible" :visible="visible" :lockScroll="false" :closeOnClickMask="false" :urls="urls" :initialIndex="index" :on-show="onShow" :on-switch="changeHandle"
                    :on-close="() => (visible = false)"/>
        </div>
      </el-col>
    </el-dialog>

    <el-dialog title="返工" :visible.sync="dialogFormVisible3" width="580px" append-to-body resize remember
               class="dialog-style dialog-basic" :close-on-click-modal="false" :close-on-press-escape="false">
      <el-form ref="reworkForm" :model="reworkForm" :inline="true" :rules="reworkRules" label-width="80px">
        <el-form-item label="当前工序" prop="dqgx" >
          <el-input v-model="reworkForm.dqgx" placeholder="" :disabled="true" clearable size="mini" class="rt-input"
                    style="width: 180px" />
        </el-form-item>
        <el-form-item label="返工工序" prop="reworkId" >
          <el-select v-model="reworkForm.reworkId" placeholder="选择工序" size="mini" clearable style="width: 180px">
            <el-option v-for="item in reworkIdOptions" :key="item.value" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item><br>
        <el-form-item label="返工原因" prop="reworkCause" >
          <el-input v-model="reworkForm.reworkCause" type="textarea" placeholder="请输入返工原因" clearable size="mini"
                    style="width:450px" :onkeyup="reworkForm.reworkCause = reworkForm.reworkCause.replace(/\s/g,'')"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button size="mini" plain  @click="dialogFormVisible3=false">取 消</el-button>
        <el-button size="mini" plain type="primary" @click="insertSubmitRework('reworkForm')">确 定</el-button>
      </div>
    </el-dialog>

    <!--查看记录-->
    <ViewingRecord v-if="dialogViewing" ref="ViewingRecord"></ViewingRecord>

  </div>
</template>

<script>
import {queryProjectBatch, bindingRecipient, selectPictureImage} from "@/api/szhjg/szhjgCommon";
import { queryDirectory, queryCasePiece } from "@/api/szhjg/sjjg/mlzl";
import { insertCaseFile, insertCasePiece } from "@/api/szhjg/sjjg/mlzl";
import { queryDictType, casePersonnelClass } from "@/api/szhjg/sjjg/mlzl";
import { queryNextGxName,processingSubmitPass,reworkQueryProject,reworkSubmitPass }  from '@/api/szhjg/sjjg/approachCommon';
import { Message } from "element-ui";
import {getUserProfile} from "@/api/system/user";
import ImgViewr, {showImages} from "vue-img-viewr";
import 'vue-img-viewr/styles/index.css';
import ViewingRecord from '@/views/szhjg/sjjg/ViewingRecord/index';

const params = {
  pageNum: 1,
  pageSize: 20
}
export default {
  name: "index",

  components: {ImgViewr,ViewingRecord},

  data() {
    return {
      urls: [],
      index: 0,
      visible: false,
      //存放当前登入用户名称
      acquireNickName: '',
      //弹窗
      dialogFormVisible1: false,
      dialogFormVisible2: false,
      dialogFormVisible3: false,
      dialogViewing: false,
      // 遮罩层
      loading: true,
      //搜索
      queryForm:{
        pcId: [],
        bianHao: "",
        dh: '',
      },
      //批次项目信息
      projectOptions: [],
      projectProps: {label: 'projectName', value: 'benId', children: 'pcName'},
      //档案类型类别
      daType: '',
      daFileType: '',

      /*****************************     卷级方法      ****************************************************************/
      totalJuan: 0,
      pageNumJuan: 1,
      pageSizeJuan: 20,
      //案卷复选框
      juanGridCheck: [],
      juanCheck: [],
      //列表
      juanFrameList: [],
      //表头
      juanFrameColumns: [
        {label: '档案类型', prop: 'dalx', width: '100'},
        {label: '编号', prop: 'dh', width: '200'},
        {label: '全宗号', prop: 'qzh', width: '100'},
        {label: '目录号', prop: 'mlh', width: '100'},
        {label: '案卷号', prop: 'ajh', width: '100'},
        {label: '姓名', prop: 'xm', width: '100'},
        {label: '证件类型', prop: 'zjlx', width: '100'},
        {label: '证件号码', prop: 'zjhm', width: '180'},
        {label: '当前状态', prop: 'rwzt', width: '80'},
        {label: '领取人', prop: 'lqr', width: '80'},
        {label: '修改意见', prop: 'xgyj', width: '200'},
      ],
      //字段名称
      juanFileForm: {
        qzmc: '', ajtm: '', qssj: '', zzsj: '', fz: '', bkbsm: '', rwzt: '',lqr: '',
        xm: '', xb: '', csrq: '', mz: '', zjlx: '', zjhm: '', cjzzsj: '', cjgzsj: '',
      },
      juanFileRules: {},

      /*****************************     件级方法      ****************************************************************/
      JianDaType:'',
      JianNameId:'',
      totalJian: 0,
      pageNumJian: 1,
      pageSizeJian: 20,
      //文件复选框
      jianGridCheck: [],
      //列表
      jianFrameList: [],
      //表头
      jianFrameColumns: [
        {label: '编号', prop: 'dh', width: '180'},
        {label: '件号', prop: 'jh', width: '80'},
        {label: '页数', prop: 'ys', width: '80'},
        {label: '责任者', prop: 'zrz', width: '100'},
        {label: '题名', prop: 'tm', width: '150'},
        {label: '形成时间', prop: 'xcsj', width: '150'},
        {label: '材料分类', prop: 'clfl', width: '130'},
        {label: '类号', prop: 'cllh', width: '80'},
        {label: '材料名称', prop: 'clmc', width: '130'},
        {label: '修改意见', prop: 'xgyj', width: '200'},
      ],
      //字段名称
      jianFileForm: {
        dh: '', jh: '', zrz: '', tm: '', xcsj: '', mgsj: '', gjc: '', fz: '', fjtm: '', flh: '', yz: '', ztxt: '',
        zqbs: '', jdch: '', kzbs: '', mj: '', xgyj: '',
        //人事档案
        clfl: '', clmc: '', cllh: '', makeYear: '', makeMonth: '', makeDay: '', remark: '',
      },
      jianFileRules: {

        clfl:[
          {required: true, message: '请选择材料类型', trigger: 'blur,change'}
        ],
        clmc: [
          {required: true, message: '材料名称不能为空', trigger: 'blur'},
          {min: 0, max: 100, message: '姓名长度不得超过100', trigger: 'blur'},
        ],
        makeYear:[
          {required: true, pattern: /^\d+$|^\d+[.]?\d+$/, message: '由数字组成', trigger: 'blur'},
          {pattern:/^(19\d\d|20\d\d|2100)$/,message:"请输入正确的年份"}
        ],
        makeMonth:[
          {required: true, pattern: /^\d+$|^\d+[.]?\d+$/, message: '由数字组成', trigger: 'blur'},
          {pattern:/^(0?[1-9]|1[0-2])$/,message:'请输入正确的月份'}
        ],
        makeDay:[
          {required: true, pattern: /^\d+$|^\d+[.]?\d+$/, message: '由数字组成', trigger: 'blur'},
          {pattern:/^((0?[1-9])|((1|2)[0-9])|30|31)$/,message:'请输入正确的日期'}
        ]
      },

      //返工
      reworkForm: {
        dqgx: '', anJuanId: '', reworkId: '', reworkCause: '',
      },
      reworkIdOptions: [],
      reworkRules:{
        reworkId:[
          {required: true, message: '返工工序不能为空', trigger: 'blur'},
        ],
        reworkCause:[
          {required: true, message: '返工原因不能为空', trigger: 'blur'},
          {min: 0, max:300, message: '输入内容长度不得超过300', trigger: 'blur' }
        ]
      },

      //时间限制
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
      },
      //人事档案材料分类列表
      clflOptions: [],

    }
  },

  created() {
    this.getOptionsData();
    this.getNickName();
    this.queryDictList();
  },
  mounted() {
    this.queryBatchList(params)
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
    //查询当前登入用户
    getNickName() {
      getUserProfile().then(response => {
        this.acquireNickName = response.data.nickName
      });
    },
    //默认查询项目批次
    getOptionsData() {
      queryProjectBatch({gxId:7}).then((res) => {
        this.projectOptions = res.data;
      })
    },
    //弹窗跳转
    handelTab(i, e) {
      let that=this
      if(that.$refs['input'+i]){
        that.$nextTick(()=>{
          e.target.blur()
          let index=i+1;
          if (index>=6){
            that.$refs['input6'].focus()
          }else {
            that.$refs['input'+index].focus()
          }
        })
      }
    },
    handelFileTab(i, e) {
      let that=this
      if(that.$refs['inputFile'+i]){
        that.$nextTick(()=>{
          e.target.blur()
          let index=i+1
          if (index>=17){
            that.$refs['inputFile17'].focus()
          }else {
            that.$refs['inputFile'+index].focus()
          }
        })
      }
    },

    /*****************************     案卷方法      *******************************************************************/
    //搜索
    batchSearch(){
      let params = {
        pageNum: 1,
        pageSize: 20,
        pcId: this.queryForm.pcId[1],
        dh:this.queryForm.bianHao,
      }
      this.queryBatchList(params);
    },
    // 分页
    pageCurrentJuan(val) {
      this.pageNumJuan = val
      params.pageNum = val
      params.pageSize = this.pageSizeJuan;
      params.pcId = this.queryForm.pcId[1];
      this.queryBatchList(params)
    },
    pageSizeSJuan(val) {
      this.pageSizeJuan = val
      params.pageSize = val;
      params.pageNum = this.pageNumJuan;
      params.pcId = this.queryForm.pcId[1];
      this.queryBatchList(params)
    },
    queryBatchList(params){
      const _this = this;
      queryDirectory(params, {emulateJSON: true})
        .then(function (response) {
          _this.juanFrameList = response.rows;
          _this.totalJuan = response.total;
          _this.loading = false;
        })
    },
    //复选框事件
    juanSelectionChange(val) {
      this.juanGridCheck = val;
      this.juanCheck = val.map(item => item.id)
      if (this.juanGridCheck.length == 1){
        this.JianNameId = this.juanGridCheck[0].lqr;
        this.JianDaType = this.juanGridCheck[0].dalx;
        this.queryCaseList(this.juanGridCheck[0].id);
      }
    },
    //行点击事件
    juanRowClick(row, column, event) {
      this.$refs.juanTable.clearSelection();
      if (this.juanGridCheck.length === 0) {
        this.$refs.juanTable.toggleRowSelection(row)
        return;
      }
      this.$refs.juanTable.toggleRowSelection(row)
    },
    async juanSelect(selection, row) {
      // 执行完清空操作在进行下面的勾选
      await this.$refs.juanTable.clearSelection();
      if (selection.length === 0) return;
      this.$refs.juanTable.toggleRowSelection(row, true);
    },
    juanClass( { row,rowIndex }) {
      if (this.juanGridCheck.includes(row)){
        return {"background":"#b9deff !important", "color": "blue",}
      } else {
        return {"——tablebackground" : "#F5F7FA",}
      }
    },
    //翻页后序号连贯
    juanGetIndex($index) {
      return (this.pageNumJuan - 1) * this.pageSizeJuan + $index + 1;
    },
    //案卷著录
    descriptionFile(val){
      let a = val.lqr;
      let b = this.acquireNickName;
      if (a == b || a==null|| a=='' || a==undefined){
        if ( a!=b ){
          this.bindingRecipientName(val.id);
        }
        if (val.dalx == "人事档案"){
          this.daType = "2"
        }
        this.juanFileForm = val;
        this.dialogFormVisible1 = true;
      }else {
        Message.warning("当前任务已被用户‘"+a+"’领取!");
      }
    },
    //案卷著录取消按钮
    handleClose1(){
      this.daType = ""
      this.dialogFormVisible1= false;
      this.fileQuery();
    },
    insertFileDescription(juanFileForm){
      const _this = this;
      this.$refs["juanFileForm"].validate((valid) => {
        if (valid) {
          this.juanFileForm.rwzt ="进行中";
          this.juanFileForm.lqr = this.acquireNickName;
          insertCaseFile(this.juanFileForm).then(response => {
            if (response.code == "200"){
              _this.$message({message: "案卷著录成功", type: 'success'});
              _this.fileQuery();
              _this.daType = "";
              _this.dialogFormVisible1 = false;
            }else {
              this.$message({message: "案卷著录失败", type: 'error'});
            }
          })
        }else {
          return false;
        }
      })
    },
    fileQuery(){
      let params = {
        pageNum: 1,
        pageSize: 20,
        pcId: this.queryForm.pcId[1],
        dh:this.queryForm.bianHao,
      }
      this.queryBatchList(params);
    },

    /*****************************     文件方法      *******************************************************************/
    queryCaseList(val){
      let params = {
        pageNum: 1,
        pageSize: 20,
        ajId:val,
      }
      this.queryPieceList(params)
    },
    // 分页
    pageCurrentJian(val) {
      this.pageNumJian = val
      params.pageNum = val
      params.pageSize = this.pageSizeJian;
      this.queryPieceList(params)
    },
    pageSizeSJian(val) {
      this.pageSizeJian = val
      params.pageSize = val;
      params.pageNum = this.pageNumJian;
      this.queryPieceList(params)
    },
    queryPieceList(params){
      const _this = this;
      queryCasePiece(params, {emulateJSON: true})
        .then(function (response) {
          _this.jianFrameList = response.rows;
          _this.totalJian = response.total;
          _this.loading = false;
        })
    },
    //复选框事件
    jianSelectionChange(val) {
      this.jianGridCheck = val;
    },
    //行点击事件
    jianRowClick(row, column) {
      this.$refs.jianTable.clearSelection();
      if (this.jianGridCheck.length === 0) {
        this.$refs.jianTable.toggleRowSelection(row)
        return;
      }
      this.$refs.jianTable.toggleRowSelection(row)
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
      //表格序号
      return (this.pageNumJian - 1) * this.pageSizeJian + $index + 1;
    },
    //文件著录
    descriptionPiece(val){
      this.getImage(val)
      let a = this.JianNameId;
      let b = this.acquireNickName;
      if (a == b || a==null|| a=='' || a==undefined){
        if (this.JianDaType=="人事档案"){
          this.daFileType = "2";
        }else {
          this.daFileType = "1";
        }
        this.jianFileForm = val;
        this.dialogFormVisible2 = true;
      }else {
        Message.warning("当前任务已被用户‘"+a+"’领取!");
      }
    },
    getImage(row){
      selectPictureImage({jh:row.jh,ajId:row.ajId}).then((res)=>{
        this.urls = res.data.imgs.map((item, index) => {
          return `${process.env.VUE_APP_BASE_API}/szhjgCommonController/ioReadImg2?url=${encodeURIComponent(item)}`;
        });
        this.showImagesByComponent()
      })
    },
    insertPieceDescription(jianFileForm){
      const _this = this;
      this.$refs["jianFileForm"].validate((valid) => {
        if (valid) {
          insertCasePiece(this.jianFileForm).then(response => {
            if (response.code == "200"){
              _this.$message({message: "文件著录成功", type: 'success'});
              _this.pieceQuery();
              _this.dialogFormVisible2 = false;
            }else {
              this.$message({message: "文件著录失败", type: 'error'});
            }
          })
        }else {
          return false;
        }
      })
    },
    pieceQuery(){
      let params = {
        pageNum: 1,
        pageSize: 20,
        ajId:this.jianGridCheck[0].ajId,
      }
      this.queryPieceList(params);
    },
    //查询人事档案分类
    queryDictList(){
      queryDictType().then(res => {
        this.clflOptions = res.map((item) => {
          return item;
        });
      });
    },
    //查询人事档案类号
    checkPersonnel(event){
      let ajIdValue = this.jianGridCheck[0].ajId;
      let clflValue = event;
      casePersonnelClass({ajId:ajIdValue,clfl:clflValue}).then(response =>{
        this.jianFileForm.cllh = response.msg;
      })
    },


    //绑定操作人
    bindingRecipientName(val){
      let nameId = val
      bindingRecipient({nameId:nameId}).then((res) => {
        if (res.code == "200"){
          //不显示提示信息
        }else{
          this.$message({message: "用户绑定失败", type: 'error'});
        }
      });
    },
    //提交
    submitTask(){
      if (this.juanGridCheck.length == 1){
        let a = this.juanGridCheck[0].id;
        let b = this.juanGridCheck[0].dqgx;
        queryNextGxName({id:a, gxName:b}).then(response =>{
          var o;
          if (response.msg =="目录著录"){
            o = "当前工序 :目录著录。已是最后一道工序,是否提交!"
          }else {
            o = "当前工序：目录著录，下一道工序为："+response.msg+"。是否提交!"
          }
          this.$confirm(o, '提示', {
            confirmButtonText: '确定', cancelButtonText: '取消', type: 'warning',
          }).then(() => {
            const _this = this;
            processingSubmitPass({ajId:a, gxId:b}).then(response =>{
              if (response.code == 200) {
                _this.$message({message:"提交成功", type: 'success'})
                _this.fileQuery();
                _this.jianFrameList = [];
                _this.totalJian = 0;
              } else {
                this.$message({message: "提交失败", type: 'error'});
              }
            })
          }).catch(() => {});
        })
      }else {
        Message.warning("请选择一条任务!");
      }
    },
    //返工
    submitRework(){
      if (this.juanGridCheck.length == 1){
        this.dialogFormVisible3 = true;
        let anJuanId = this.juanGridCheck[0].id;
        let dqgx = this.juanGridCheck[0].dqgx;
        this.reworkForm.anJuanId = anJuanId;
        reworkQueryProject({ajId:anJuanId}).then(res => {
          this.reworkIdOptions = res.map((item) => {
            return item
          });
          var arr = this.reworkIdOptions;
          let result;
          for (var i =0;i<arr.length;i++) {
            if (dqgx == arr[i].value) {
              result = arr[i].label
            }
          }
          this.reworkForm.dqgx = result;
        });
      }else {
        Message.warning("请选择一条任务!");
      }
    },
    insertSubmitRework(reworkForm){
      const _this = this;
      this.$refs["reworkForm"].validate((valid) => {
        if (valid) {
          reworkSubmitPass(this.reworkForm).then(response => {
            if (response.code == 200) {
              _this.$message({message:"返工提交成功", type: 'success'})
              _this.fileQuery();
              _this.jianFrameList = [];
              _this.totalJian = 0;
              _this.dialogFormVisible3 = false;
            } else {
              this.$message({message: "返工提交失败", type: 'error'});
            }
          })
        } else {
          return false;
        }
      })
    },
    //查看记录
    viewRecord(){
      this.dialogViewing = true;
      let gxId = "7";
      this.$nextTick(() => {
        this.$refs.ViewingRecord.init(gxId);
      });
    },

  }

}
</script>

<style scoped lang="scss">
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

.form-basic {
  padding-left: 10px;
  margin-bottom: 5px;
  line-height: 20px;
  font-size: 14px;
  font-weight: bold;
}

.block {
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
    margin-bottom: 15px;
    line-height: 30px;
    border-bottom: 1px solid #ccc;
    margin-left: 15px;
    margin-right: 15px;
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

::v-deep .el-tabs__content {
  padding: 10px;
  height: calc(100vh - 175px);
  overflow: auto;
}

//禁止输入框输入,字体颜色黑色
.rt-input ::v-deep .el-input__inner{
  color:  #000000;
}
</style>
