<template>
  <div class="dashboard-editor-container">
    <div class="chart-wrapper">
      <el-form :model="queryForm" ref="queryForm" size="small" :inline="true" v-hasPermi="['szhjg:rwgl:rwgl:search']"
               style="margin-top:5px;margin-bottom:0;">
        <el-form-item label="选择批次" prop="pcId">
          <el-cascader v-model="queryForm.pcId" :options="projectOptions" :props="projectProps" clearable size="mini"
                       filterable :show-all-levels="false" @change="handleChange"></el-cascader>
        </el-form-item>
        <el-form-item label="编号" prop="bianHao">
          <el-input v-model="queryForm.bianHao" clearable style="width: 200px" class="rt-input" size="mini"
                    @keyup.enter.native="batchSearch"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" icon="el-icon-search" size="mini" @click="batchSearch">搜索</el-button>
        </el-form-item>
      </el-form>
      <!--按钮-->
      <el-row :gutter="10" class="mb8">
        <el-col :span="1.5">
          <el-button type="primary" plain icon="el-icon-plus" size="mini" v-hasPermi="['szhjg:rwgl:rwgl:add']"
                     @click="taskAdd" :disabled="multiple">新增
          </el-button>
        </el-col>
        <el-col :span="1.5">
          <el-button type="primary" plain icon="el-icon-plus" size="mini" v-hasPermi="['szhjg:rwgl:rwgl:batchAdd']"
                     @click="batchAddition" :disabled="multiple">批量新增
          </el-button>
        </el-col>
        <el-col :span="1.5">
          <el-button type="success" plain icon="el-icon-edit" size="mini" v-hasPermi="['szhjg:rwgl:rwgl:updata']"
                     @click="taskUpdate" :disabled="multiple">修改
          </el-button>
        </el-col>
        <el-col :span="1.5">
          <el-button type="danger" plain icon="el-icon-delete" size="mini" v-hasPermi="['szhjg:rwgl:rwgl:delete']"
                     @click="taskDelete" :disabled="multiple">删除
          </el-button>
        </el-col>
        <el-col :span="1.5">
          <el-dropdown>
            <el-button type="info" plain size="mini" v-hasPermi="['szhjg:rwgl:rwgl:taskImport']"
                       :disabled="multiple">任务导入<i class="el-icon-arrow-down el-icon&#45;&#45;right"></i>
            </el-button>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item type="info" plain icon="el-icon-upload2" size="mini"
                                @click.native="batchImport">案卷导入
              </el-dropdown-item>
              <el-dropdown-item type="info" plain icon="el-icon-upload2" size="mini"
                                @click.native="papersImport">文件导入
              </el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-col>
        <el-col :span="1.5">
          <el-button type="info" plain icon="el-icon-unlock" size="mini" v-hasPermi="['szhjg:rwgl:rwgl:release']"
                     @click="releaseCurrentUser" :disabled="multiple">释放当前用户
          </el-button>
        </el-col>
      </el-row>
      <!--任务表单信息-->
      <!--<el-table border v-if="taskColumns.length<=0" height="calc(100vh - 230px)"></el-table>-->
      <div v-if="taskColumns.length<=0" class="taskColumnsFalse">暂无数据</div>
      <el-table v-else row-key="id" :data="taskList" border width="100%" height="calc(100% - 120px)" ref="taskTable"
                slot="table" @selection-change="taskSelectionChange" @row-click="taskRowClick" @select="tasksSelect"
                :row-style="taskClass">
        <el-table-column type="selection" width="40"/>
        <el-table-column align="center" :index="taskGetIndex" type="index" label="序号" width="55"/>
        <el-table-column align="center" v-for="(item,index) in taskColumns" :key="index" :label="item.label"
                         :prop="item.prop" :min-width="item.width" show-overflow-tooltip :formatter="item.formatter"/>
        <el-table-column align="center" label="操作" width="120" fixed="right" class-name="operation">
          <template slot-scope="scope">
            <el-button type="text" size="mini" v-hasPermi="['szhjg:rwgl:rwgl:document']"
                       @click="fileViewing(scope.row)">文件查看</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div class="page" style="margin-top: 5px;">
        <el-pagination :page-sizes="[20, 30, 50, 100]" :page-size="pageSize" :current-page="pageNum" :total="total"
                       layout="total, sizes, prev, pager, next, jumper" @size-change="pageSizeS" :pager-count="5"
                       @current-change="pageCurrent"/>
      </div>
    </div>

    <!--任务新增/编辑-->
    <el-dialog :title="frameDialogType=='add'?'新增任务':frameDialogType=='edit'?'编辑任务':''" width="650px"
               :visible.sync="dialogFormVisible1" :close-on-click-modal="false" :close-on-press-escape="false"
               :destroy-on-close="true" :append-to-body="true" class="dialog-style dialog-basic">
      <el-form ref="tableTask" :model="tableTask" :inline="true" :rules="TaskRules" label-width="90px">
        <br>
        <el-form-item v-for="(item, index) in formItemList" :label="item.label" :key="index" :prop="item.prop">
          <el-input v-if="item.type == 'input'" v-model="tableTask[item.prop]" :placeholder="item.placeholder"
                    :rules="item.rules" size="mini" style="width:200px" :disabled="item.disabled" class="rt-input"
                    @blur="updateBH"></el-input>
          <el-select v-if="item.type == 'select'" v-model="tableTask[item.prop]" placeholder="请选择" size="mini"
                     style="width:200px" @blur="updateBH">
            <el-option v-for="items in item.options" :key="items.value" :label="items.label" :value="items.value"
              :rules="items.rules">
            </el-option>
          </el-select>
          <el-date-picker v-if="item.type == 'date'" v-model="tableTask[item.prop]" clearable size="mini"
                          :placeholder="item.placeholder" type="date" value-format="yyyy-MM-dd HH:mm:ss"
                          :picker-options="pickerOptions" :rules="item.rules" style="width:200px" @blur="updateBH"/>
          <!-- 其他表单项类型 -->
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button size="mini" plain @click="dialogFormVisible1=false">取 消</el-button>
        <el-button size="mini" plain type="primary" @click="insertTaskOne('tableTask')">保 存</el-button>
      </div>
    </el-dialog>

    <!--任务(案卷)批量导入-->
    <el-dialog title="案卷导入" :visible.sync="dialogFormVisible4" width="400px" append-to-body :before-close="batchClose">
      <el-checkbox v-model="checked">要导入指定工序,请勾选之后选择相应工序!</el-checkbox>
      <div style="height:60px">
        <el-form ref="batchWorkingOne" :model="batchWorkingOne" :inline="true" :rules="batchWorkingVerify">
          <el-form-item label="选择工序" prop="gxxh" v-if="checked == true ">
            <el-select v-model="batchWorkingOne.gxxh" placeholder="请选择" size="mini" clearable>
              <el-option v-for="item in projectWorkingName" :key="item.value" :label="item.label"
                         :value="item.value"/>
            </el-select>
          </el-form-item>
        </el-form>
      </div>
      <el-upload ref="upload" :limit="1" accept=".xlsx, .xls" :auto-upload="false" drag action=""
                 :on-change="handleOnChange" :on-exceed="handleExceed" :on-remove="handleRemove">
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip text-center" slot="tip">
          <span>仅允许导入xls、xlsx格式文件。</span>
          <el-link type="primary" :underline="false" style="font-size:12px;vertical-align: baseline;"
                   @click="importTemplate('A')">下载模板
          </el-link>
        </div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button size="mini" plain @click="batchClose">取 消</el-button>
        <el-button size="mini" plain type="primary" @click="batchSave('batchWorkingOne')">确 定</el-button>
      </div>
    </el-dialog>

    <!--文件条目导入-->
    <el-dialog title="文件条目导入" :visible.sync="dialogFormVisible5" width="400px" append-to-body :before-close="papersClose">
      <!--<el-checkbox v-model="checked">要导入指定工序,请勾选之后选择相应工序!</el-checkbox>
      <div style="height:60px">
        <el-form ref="batchWorkingTwo" :model="batchWorkingTwo" :inline="true" :rules="batchWorkingVerify">
          <el-form-item label="选择工序" prop="gxxh" v-if="checked == true ">
            <el-select v-model="batchWorkingTwo.gxxh" placeholder="请选择" size="mini" clearable>
              <el-option v-for="item in projectWorkingName" :key="item.value" :label="item.label"
                         :value="item.value"/>
            </el-select>
          </el-form-item>
        </el-form>
      </div>-->
      <el-upload ref="uploadPapers" :limit="1" accept=".xlsx, .xls" :auto-upload="false" drag action=""
                 :on-change="handlePapersChange" :on-exceed="handlePapersExceed" :on-remove="handlePapersRemove">
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
        <div class="el-upload__tip text-center" slot="tip">
          <span>仅允许导入xls、xlsx格式文件。</span>
          <el-link type="primary" :underline="false" style="font-size:12px;vertical-align: baseline;"
                   @click="importTemplate('B')">下载模板
          </el-link>
        </div>
      </el-upload>
      <div slot="footer" class="dialog-footer">
        <el-button size="mini" plain @click="papersClose">取 消</el-button>
        <el-button size="mini" plain type="primary" @click="papersSave('batchWorkingTwo')">确 定</el-button>
      </div>
    </el-dialog>

    <!--批量添加(新增)-->
    <el-dialog title="批量添加任务" width="720px" :visible.sync="dialogFormVisible2" :close-on-click-modal="false"
               :close-on-press-escape="false" :destroy-on-close="true" :append-to-body="true" class="dialog-style dialog-basic">
      <div type="border-card" >
        <el-form ref="batchAddTask" :model="batchAddTask" :inline="true" :rules="batchAddRules" label-width="120px"><br>
          <el-form-item v-for="(item, index) in batchItemList" :label="item.label" :key="index" :prop="item.prop">
            <el-input v-if="item.type == 'input'" v-model="batchAddTask[item.prop]" :placeholder="item.placeholder"
                      :rules="item.rules" size="mini" style="width:200px" ></el-input>
            <el-select v-if="item.type == 'select'" v-model="batchAddTask[item.prop]" placeholder="请选择" size="mini"
                       style="width:200px">
              <el-option v-for="items in item.options" :key="items.value" :label="items.label" :value="items.value"
                         :rules="items.rules"></el-option>
            </el-select>
            <el-date-picker v-if="item.type == 'date'" v-model="batchAddTask[item.prop]" clearable size="mini"
                            :placeholder="item.placeholder" type="date" value-format="yyyy-MM-dd HH:mm:ss"
                            :picker-options="pickerOptions" :rules="item.rules" style="width:200px"/>
          </el-form-item>
        </el-form>
      </div>
      <div slot="footer" class="dialog-footer">
        <el-button size="mini" plain @click="additionClose">取 消</el-button>
        <el-button size="mini" plain type="primary" @click="insertBatchMore('batchAddTask')">保 存</el-button>
      </div>
    </el-dialog>

    <!--文件条目详情-->
    <el-dialog title="查看文件条目" width="70%" :visible.sync="dialogFormViewing" resize :close-on-click-modal="false"
               remember :close-on-press-escape="false" append-to-body class="dialog-style dialog-basic dialog-tabulation"
               :before-close="viewingClose">
      <div v-if="viewingColumns.length<=0" class="viewingColumnsFalse">暂无数据</div>
      <div v-else>
        <el-table row-key="id" :data="viewingList" border width="100%" height="calc(100% - 40px)" ref="viewingTable">
          <el-table-column type="selection" width="40"></el-table-column>
          <el-table-column align="center" :index="viewingGetIndex" type="index" label="序号" width="55"></el-table-column>
          <el-table-column align="center" v-for="(item,index) in viewingColumns" :formatter="item.formatter" :key="index"
                           :label="item.label" :prop="item.prop" :v-if="viewingColumns[index].isCol" :min-width="item.width"
                           show-overflow-tooltip/>
        </el-table>
        <div class="page" style="margin-top: 5px;">
          <el-pagination :page-sizes="[20, 30, 50, 100]" :page-size="viewingPageSize" :current-page="viewingPageNum"
                         layout="total, sizes, prev, pager, next, jumper" :total="viewingTotal" :pager-count="5"
                         @current-change="viewingPageCurrent" @size-change="viewingPageSizeS"/>
        </div>
      </div>


    </el-dialog>

  </div>
</template>

<script>
  import {Message} from "element-ui";
  import {queryProjectBatch, queryDisplayGx} from "@/api/szhjg/szhjgCommon";
  import {taskDynamicListHead, getsDynamicMultiple, spotCheckDynamicList} from '@/api/szhjg/dynamicCommon';
  import {queryTaskList, insertOneTask, updateOneTask, deleteOneTask} from "@/api/szhjg/rwgl/rwgl";
  import {releaseRecipient} from "@/api/szhjg/rwgl/rwgl";
  import {queryWorking, excelFileImport, importDataPiece, insertBatchAdd} from "@/api/szhjg/rwgl/rwgl";
  import { queryNumberedComposition, checkTaskCount } from "@/api/szhjg/rwgl/rwgl";
  import { queryFileViewing } from "@/api/szhjg/rwgl/rwgl";


  const params = {
    pageNum: 1,
    pageSize: 20
  }
  export default {
    name: "index",
    data() {
      return {
        //默认新增状态
        frameDialogType: 'add',  //任务新增
        //弹窗
        dialogFormVisible1: false, //任务新增/编辑弹窗
        dialogFormVisible2: false, //批量添加弹窗
        dialogFormVisible4: false, //批量导入弹窗
        dialogFormVisible5: false, //文件条目导入弹窗
        dialogFormViewing: false, //查询文件条目弹窗

        // 遮罩层
        loading: true,
        total: 0,
        pageNum: 1,
        pageSize: 20,

        //按钮禁用
        multiple: false,

        //搜索
        queryForm: {
          pcId: [], bianHao: '',
        },
        projectOptions: [],
        projectProps: {label: 'projectName', value: 'benId', children: 'pcName', archives:"batchState",expandTrigger: 'hover'},
        taskGridCheck: [], //复选框选中
        taskList: [],      //任务列表
        taskColumns: [],   //任务表头
        //存放页面展示工序
        optionsProcedure: [],
        //存放动态输入框字段
        formItemList: [],
        //时间限制
        pickerOptions: {
          disabledDate(time) {
            return time.getTime() > Date.now();
          },
        },
        //存放批次id
        batchId: '',
        /*导入文件数据*/
        uploadFiles: [],
        uploadExcel: {
          batchId: ''
        },
        //新增/编辑任务
        tableTask: {},
        TaskRules: {},

        //获取编号组成功能
        compositionLists:[],
        //重名验证
        chongMingFlag: '',

        //批量添加(新增)
        IsOrNot: '',        //是否需要批量添加(新增)
        batchAddTask: {},
        batchAddRules:{},
        batchItemList: [],


        /*****************************     导入方法      ***************************************************************/
        //存放项目中的工序
        projectWorkingName: [],
        batchWorkingVerify: {
          gxxh: [
            {required: true, message: '工序不能为空', trigger: 'blur'},
          ],
        },
        checked: false,

        //任务批量导入工序
        batchWorkingOne: {
          gxxh: '',
        },
        //批次下的案卷导入
        fileList: [],
        depotSize: '',  //file文件长度
        depotFile: [],  //file文件

        //文件条目导入工序
        batchWorkingTwo: {
          gxxh: '',
        },
        //案卷下的文件导入
        papersList: [],
        papersSize: '',  //file文件长度
        papersFile: [],  //file文件
        papersId: '',    //存放文件上传的批次或者任务id
        papersType: '',  //类型 批次为0 , 任务为1
        fileListUpload: [],


        /*****************************     文件条目      ***************************************************************/
        viewingList:[],
        viewingColumns: [],
        viewingTotal: 0,
        viewingPageNum: 1,
        viewingPageSize: 20,
        viewingId: '',


      }
    },

    mounted() {
    },

    created() {
      this.queryOptions();
      this.queryGxOptions();
    },

    watch: {
      projectOptions(val) {
        this.queryForm.pcId = val[0].benId;
        if (val[0].pcName.length > 0) {
          this.queryForm.pcId = [val[0].benId, val[0].pcName[0].benId];
          this.multiple = val[0].pcName[0].batchState === "1";
        }
        this.getTableHeaders(this.queryForm.pcId[1]);
        this.getDynamicForm(this.queryForm.pcId[1]);
        this.getGetsDynamicMultiple(this.queryForm.pcId[1]);
        this.queryNumberedList(this.queryForm.pcId[1]);
        this.viewingTableHeaders(this.queryForm.pcId[1]);
        params.pcId = this.queryForm.pcId[1];
        this.queryList(params);
        this.batchId = this.queryForm.pcId[1];
      }
    },

    methods: {
      //查询项目批次
      queryOptions() {
        queryProjectBatch().then((res) => {
          this.projectOptions = res.data;
          /*if (this.projectOptions[0].pcName.length > 0 ){ //页面初始化展示下拉框字段并进行查询
            this.queryForm.pcId = this.projectOptions[0].pcName[0].benId;
            params.pcId = this.queryForm.pcId[1];
            this.queryList(params);
            this.getTableHeaders(this.queryForm.pcId[1]);
          }*/
        })
      },
      //切换项目批次之后进行查询
      handleChange(value) {
        if (!value || value.length<2) {   //value为空，则不进行查询操作
          return;
        }
        //判断完成项目无法操作案卷任务
        let subproject = this.projectOptions.filter(item => item.benId == value[0])
          .flatMap(item => item.pcName)
          .find(item => item.benId === value[1]);
        //判断subproject是否为空
        if (subproject) {
          this.multiple = (subproject.batchState === "1");
        }
        this.taskColumns = [];
        this.taskList = [];
        //查询动态信息
        this.getTableHeaders(value[1]);
        this.getDynamicForm(value[1]);
        this.getGetsDynamicMultiple(value[1]);
        this.viewingTableHeaders(value[1]);
        this.queryNumberedList(value[1]);
        params.pcId = value[1];
        this.queryList(params);
        this.batchId = value[1];
      },
      //查询页面动态展示工序
      queryGxOptions() {
        queryDisplayGx().then(res => {
          this.optionsProcedure = res.map((item) => {
            return item;
          });
        });
      },

      //上部搜索
      batchSearch() {
        if (this.batchId == '' || this.batchId == null || this.batchId == undefined) {
          this.$message({message: '请选择批次!', type: 'error'});
          return false;
        }
        this.pageNum = 1;
        let params = {
          pageNum: 1,
          pageSize: 20,
          pcId: this.queryForm.pcId[1],
          bh: this.queryForm.bianHao,
        }
        this.queryList(params)
      },
      //分页
      pageCurrent(val) {
        this.pageNum = val
        params.pageNum = val
        params.pageSize = this.pageSize;
        params.pcId = this.queryForm.pcId[1];
        params.bh = this.queryForm.bianHao;
        this.queryList(params)
      },
      pageSizeS(val) {
        this.pageSize = val
        params.pageSize = val;
        params.pageNum = this.pageNum;
        params.pcId = this.queryForm.pcId[1];
        params.bh = this.queryForm.bianHao;
        this.queryList(params)
      },
      //查询数据展示页面
      queryList(params) {
        const _this = this;
        queryTaskList(params, {emulateJSON: true}).then(function (response) {
          if (response.rows != undefined && response.rows != "" && response.rows != null) {
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

      //查询动态表头展示字段
      getTableHeaders(dynamic) {
        taskDynamicListHead({headBatch: dynamic, headPoints: 0, headType: 0}).then((res) => {
          this.taskColumns = res.data
        })
      },
      //查询获取动态录入表单内容
      getDynamicForm(dynamic) {
        this.formItemList = []
        this.TaskRules = {}
        taskDynamicListHead({headBatch: dynamic, headPoints: 0, headType: 1}).then((res) => {
          this.formItemList = res.data
          // 根据后台返回的数据生成表单和验证规则
          this.formItemList.forEach(item => {
            this.$set(this.tableTask, item.prop, ''); // 设置表单数据默认值
            let currentRules = [];
            if (item.isRequired) {
              currentRules.push({required: true, message: `${item.label}不能为空`, trigger: 'blur'})
            }
            if (item.max || item.min) {
              if (item.pattern) {
                let charLength = item.pattern.replace(/[^0-9]/ig, "")
                //console.log(new RegExp(item.pattern.substr(1,item.pattern.length - 2)))
                currentRules.push({
                  pattern: new RegExp(item.pattern.substr(1, item.pattern.length - 2)),
                  message: `输入内容不符合规则`,
                  trigger: 'blur'
                });
                // currentRules.push({ pattern: new RegExp(item.pattern.substr(1,item.pattern.length - 2)), message: `${item.label}全宗号长度为${charLength}，由数字组成`, trigger: 'blur' });
              } else {
                currentRules.push({
                  min: item.min,
                  max: item.max,
                  message: `${item.label}长度在 ${item.min} 到 ${item.max} 个字符`,
                  trigger: 'blur'
                });
              }
            }
            if (currentRules.length > 0) {
              this.$set(this.TaskRules, item.prop, currentRules); // 设置验证规则
            }
          })
        })
      },
      //查询获取动态批量添加(新增)录入字段
      getGetsDynamicMultiple(dynamic){
        this.batchItemList = [];
        this.batchAddRules = {};
        getsDynamicMultiple({headBatch: dynamic}).then((res) => {
          this.IsOrNot = res.msg;
          if (res.msg === "true"){
            this.batchItemList = res.data;
            // 根据后台返回的数据生成表单和验证规则
            this.batchItemList.forEach(item => {
              this.$set(this.batchAddTask, item.prop, ''); // 设置表单数据默认值
              let currentRules = [];
              if (item.isRequired) {
                currentRules.push({required: true, message: `${item.label}不能为空`, trigger: 'blur'})
              }
              if (item.max || item.min) {
                if (item.pattern) {
                  let charLength = item.pattern.replace(/[^0-9]/ig, "")
                  currentRules.push({
                    pattern: new RegExp(item.pattern.substr(1, item.pattern.length - 2)),
                    message: `输入内容不符合规则`,
                    trigger: 'blur'
                  });
                } else {
                  currentRules.push({
                    min: item.min,
                    max: item.max,
                    message: `${item.label}长度在 ${item.min} 到 ${item.max} 个字符`,
                    trigger: 'blur'
                  });
                }
              }
              if (currentRules.length > 0) {
                this.$set(this.batchAddRules, item.prop, currentRules); // 设置验证规则
              }
            })
          }
        })
      },

      //查询编号动态组成
      queryNumberedList(dynamic){
        queryNumberedComposition({batchNameId:dynamic}).then((res) => {
          this.compositionLists = res.data;
        })
      },
      //编号拼接
      updateBH(){
        let result = '';
        this.compositionLists.forEach(item => {
          if (this.tableTask[item.sourceName]) {
            if (item.metadataMode === 'date') {
              const dateStr = this.tableTask[item.sourceName]
              const year = dateStr.split('-')[0]
              result += year + '-'
            } else {
              result += this.tableTask[item.sourceName] + '-'
            }
          }
        });
        this.$set(this.tableTask, 'bh', result.slice(0, -1));
      },

      //查询文件条目信息
      viewingTableHeaders(dynamic){
        spotCheckDynamicList({headBatch: dynamic, headPoints: 1}).then((res) => {
          this.viewingColumns = res.data;
        })
      },

      // 复选框事件
      taskSelectionChange(val) {
        this.taskGridCheck = val;
      },
      // 行点击事件
      taskRowClick(row, column, event) {
        this.$refs.taskTable.clearSelection();
        if (this.taskGridCheck.length === 0) {
          this.$refs.taskTable.toggleRowSelection(row)
          return;
        }
        this.$refs.taskTable.toggleRowSelection(row)
      },
      async tasksSelect(selection, row) {
        //执行完清空操作在进行下面的勾选
        await this.$refs.taskTable.clearSelection();
        if (selection.length === 0) return;
        this.$refs.taskTable.toggleRowSelection(row, true);
      },
      taskClass({row, rowIndex}) {
        if (this.taskGridCheck.includes(row)) {
          return {
            "background": "#b9deff !important", "color": "blue",
          }
        } else {
          return {
            "——tablebackground": "#F5F7FA",
          }
        }
      },
      //翻页后序号连贯
      taskGetIndex($index) {
        return (this.pageNum - 1) * this.pageSize + $index + 1;
      },


      //任务新增
      taskAdd() {
        if (this.batchId == '' || this.batchId == null || this.batchId == undefined || this.queryForm.pcId.length===0) {
          this.$message({message: '请选择批次!', type: 'error'});
          return false;
        }
        this.tableTask = {};
        this.frameDialogType = 'add';
        this.dialogFormVisible1 = true
      },
      //任务编辑
      taskUpdate() {
        if (this.taskGridCheck.length <= 0) {
          Message.warning("请选择要修改的数据");
          return false
        }
        if (this.taskGridCheck.length > 1) {
          Message.warning("请选择一条数据进行修改");
          return false
        }
        if (this.taskGridCheck.length == 1) {
          this.tableTask = JSON.parse(JSON.stringify(this.taskGridCheck[0]));
          this.frameDialogType = 'edit';
          this.dialogFormVisible1 = true;
        }
      },
      //任务新增/编辑保存
      insertTaskOne(tableTask) {
        const _this = this;
        this.$refs["tableTask"].validate((valid) => {
          if (valid) {
            checkTaskCount({BH:this.tableTask.bh,Id:this.tableTask.id}).then(response => {
              if (response.msg === "true") {
                const targetLabel = this.formItemList.find(item => item.prop === "bh").label;
                this.$message({message: targetLabel+"重复，请重新输入!", type: 'error'});
                return false;
              }else {
                if (this.frameDialogType === 'add') {
                  this.tableTask.pcId = this.batchId;
                  insertOneTask(this.tableTask).then(response => {
                    if (response.code == "200") {
                      _this.$message({message: "新增任务成功", type: 'success'});
                      _this.batchTaskQuery();
                      _this.dialogFormVisible1 = false;
                    } else {
                      this.$message({message: "新增任务失败", type: 'error'});
                    }
                  });
                } else if (this.frameDialogType === 'edit') {
                  const arr = _this.optionsProcedure;
                  for (var i in _this.optionsProcedure) {
                    if (this.tableTask.dqgx == arr[i].label) {
                      this.tableTask.dqgx = arr[i].value;
                    }
                  }
                  updateOneTask(this.tableTask).then(response => {
                    if (response.code == "200") {
                      _this.$message({message: "修改任务成功", type: 'success'});
                      _this.batchTaskQuery();
                      _this.dialogFormVisible1 = false;
                    } else {
                      this.$message({message: "修改任务失败", type: 'error'});
                    }
                  });
                }
              }
            })
          } else {
            return false;
          }
        })
      },
      //任务删除
      taskDelete() {
        if (this.taskGridCheck.length <= 0) {
          Message.warning("请选择要删除的数据");
          return false
        }
        if (this.taskGridCheck.length > 1) {
          Message.warning("请选择一条数据进行删除");
          return false
        }
        if (this.taskGridCheck.length == 1) {
          this.$confirm('此操作将删除选中数据,是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
          }).then(() => {
            const _this = this;
            let id = this.taskGridCheck[0].id;
            deleteOneTask(id).then((response) => {
              if (response.code == 200) {
                _this.$message({message: "删除任务成功", type: 'success'})
                _this.batchTaskQuery();
              } else {
                this.$message({message: "删除任务失败", type: 'error'});
              }
            })
          }).catch(() => {
          });
        }
      },

      //批量新增(添加)任务
      batchAddition() {
        if (this.batchId == '' || this.batchId == null || this.batchId == undefined || this.queryForm.pcId.length===0) {
          this.$message({message: '请选择批次!', type: 'error'});
          return false;
        }
        if (this.IsOrNot === "true"){
          this.dialogFormVisible2 = true;
        }else {
          this.$message({message: '当前档案类型没有设置批量新增(添加)功能!', type: 'warning'});
        }
      },
      //批量新增(添加)任务取消
      additionClose() {
        this.batchAddTask = {};
        this.dialogFormVisible2=false;
      },
      //批量新增任务报错
      insertBatchMore(batchAddTask){
        const _this = this;
        this.$refs["batchAddTask"].validate((valid) => {
          if (valid) {
            //判断(起始-终止)是否相等
            const startNumber = this.batchAddTask.startNumber;
            const terminateNumber = this.batchAddTask.terminateNumber;
            if (startNumber.length === terminateNumber.length) {
              this.batchAddTask.pcId = this.batchId;
              insertBatchAdd(this.batchAddTask).then((response) => {
                if (response.code === 200){
                  if (response.data === 2){
                    _this.$message({message:response.msg, type: 'success'});
                    _this.batchTaskQuery();
                    _this.dialogFormVisible2 = false;
                  }else {
                    this.$alert(
                      "<div style='overflow: auto;overflow-x: hidden;max-height: 70vh;padding: 10px 20px 0;'>"
                      + response.msg + "</div>", "批量新增结果", { dangerouslyUseHTMLString: true }
                    );
                  }
                }
              })
            }else {
              this.$message({message: '起始XXX的信息和终止XXX的信息的长度不相等', type: 'warning'});
            }
          } else {
            return false;
          }
        })
      },

      //释放当前用户
      releaseCurrentUser() {
        if (this.taskGridCheck.length <= 0) {
          Message.warning("请选择要删除的数据");
          return false
        }
        if (this.taskGridCheck.length > 1) {
          Message.warning("请选择一条数据进行删除");
          return false
        }
        if (this.taskGridCheck.length == 1) {
          let a = this.taskGridCheck[0].lqr;
          if (a == null || a == '' || a == undefined) {
            Message.warning("当前任务没有绑定领取人,无法释放!");
          } else {
            this.$confirm('当前任务已被用户‘' + a + '’领取，是否解除绑定！', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning',
            }).then(() => {
              const _this = this;
              let nameId = this.taskGridCheck[0].id;
              releaseRecipient({nameId: nameId}).then((res) => {
                if (res.code == "200") {
                  _this.$message({message: "释放成功", type: 'success'})
                  _this.batchTaskQuery();
                } else {
                  this.$message({message: "释放失败", type: 'error'});
                }
              })
            }).catch(() => {
            });
          }
        }
      },

      //查询当前批次对应项目正在进行中的工序
      queryWorkingView(val) {
        let type = "P";
        queryWorking({cxId: val, type: type}).then((res) => {
          this.projectWorkingName = res.map((item) => {
            return item;
          });
        })
      },


      //案卷批量导入
      batchImport() {
        if (this.batchId == '' || this.batchId == null || this.batchId == undefined) {
          this.$message({message: '请选择批次!', type: 'error'});
          return false;
        }
        this.depotFile = [];
        this.dialogFormVisible4 = true;
        this.queryWorkingView(this.batchId);
      },
      //案卷批量导入取消
      batchClose() {
        this.dialogFormVisible4 = false;
        this.$refs.upload.clearFiles();
      },
      //案卷批量导入确定
      batchSave(batchWorkingOne) {
        this.fileListUpload = [];
        if (this.batchWorkingOne.gxxh == '' || this.batchWorkingOne.gxxh == null) {
          this.batchWorkingOne.gxxh = this.projectWorkingName[0];
        }
        if (this.depotFile.length == 0) {
          this.$message.warning("请上传附件");
        } else {
          const formData = new FormData();
          formData.append('file', this.depotFile)
          formData.append('batchId', this.batchId)
          formData.append('gxxh', this.batchWorkingOne.gxxh.value)
          excelFileImport(formData).then(res => {
            if (res.code == "200") {
              this.depotFile = [];
              this.$message.success(res.msg);
              this.batchTaskQuery();
              this.dialogFormVisible4 = false;
              this.$refs.upload.clearFiles();
            }
          });
        }
      },
      handleOnChange(file, fileList) {
        this.uploadFiles = file.raw;
        this.fileList = fileList
        this.depotSize = file.size
        this.depotFile = file.raw
        const fileName = file.name
        const fileType = fileName.substring(fileName.lastIndexOf('.') + 1)
        if (this.depotFile) {
          if (fileType === 'xlsx' || fileType === 'xls') {
            /*this.submitUpload(this.fileContent)*/
          } else {
            this.$message({type: 'warning', message: '附件格式错误，请重新上传'});
            this.depotFile = [];
            this.$refs.upload.clearFiles();
          }
        } else {
          this.$message({
            type: 'warning',
            message: '请上传附件'
          })
        }
      },
      //附件数量过多
      handleExceed() {
        this.$message({
          type: 'warning',
          message: '只能上传一个附件'
        })
        return
      },
      //删除附件
      handleRemove(file, fileList) {
        this.depotFile = []
        this.depotSize = ''
      },
      beforeRemoveFile(file, fileList) {
        this.fileListUpload = fileList.filter(f => f !== file)
        // return this.$confirm(`确定移除 ${file.name}？`);
      },


      //文件条目导入
      papersImport() {
        if (this.batchId == '' || this.batchId == null || this.batchId == undefined) {
          this.$message({message: '请选择批次!', type: 'error'});
          return false;
        }
        if (this.taskGridCheck.length === 0) {
          this.papersType = '0';
          this.papersId = this.batchId;
          this.queryWorkingView(this.batchId);
          this.dialogFormVisible5 = true;
        } else {
          this.papersType = '1';
          this.papersId = this.taskGridCheck[0].id;
          this.queryWorkingView(this.batchId);
          this.dialogFormVisible5 = true;
        }
      },
      papersClose() {
        this.dialogFormVisible5 = false
        this.papersFile = [];
        this.$refs.uploadPapers.clearFiles();
      },
      //文件条目导入确定
      papersSave(batchWorkingOne) {
        this.fileListUpload = [];
        if (this.batchWorkingOne.gxxh == '' || this.batchWorkingOne.gxxh == null) {
          this.batchWorkingOne.gxxh = this.projectWorkingName[0];
        }
        if (this.papersFile.length == 0) {
          this.$message.warning("请上传附件");
        } else {
          const formData = new FormData();
          formData.append('file', this.papersFile)
          formData.append('batchId', this.batchId)
          formData.append('gxxh', this.batchWorkingOne.gxxh.value)
          importDataPiece(formData).then(res => {
            if (res.code == "200") {
              this.papersFile = [];
              this.$message.success(res.msg);
              this.batchTaskQuery(params);
              this.dialogFormVisible5 = false;
              this.$refs.uploadPapers.clearFiles();
            }
          });
        }
      },
      handlePapersChange(file, fileList) {
        this.papersList = fileList
        this.papersSize = file.size
        this.papersFile = file.raw
        const fileName = file.name
        const fileType = fileName.substring(fileName.lastIndexOf('.') + 1)
        if (this.papersFile) {
          if (fileType === 'xlsx' || fileType === 'xls') {
            /*this.submitUpload(this.fileContent)*/
          } else {
            this.$message({type: 'warning', message: '附件格式错误，请重新上传'});
            this.papersFile = [];
            this.$refs.uploadPapers.clearFiles();
          }
        } else {
          this.$message({
            type: 'warning',
            message: '请上传附件'
          })
        }
      },
      handlePapersExceed() {
        this.$message({
          type: 'warning',
          message: '只能上传一个附件'
        })
        return
      },
      handlePapersRemove(file, fileList) {
        this.papersFile = []
        this.papersSize = ''
      },


      //下载模板操作
      importTemplate(buttonName) {
        if (buttonName === 'A') {
          //将批次id添加到请求参数对象中
          const params = {
            batchId : this.batchId,
            pointsId :"0",  //案卷
          };
          this.download('rwgl/importImportfile', params, `案卷导入模板.xlsx`);
        }else if (buttonName === 'B') {
          const params = {
            batchId : this.batchId,
            pointsId :"1",  //文件
          };
          this.download('rwgl/importImportfile', params, `文件导入模板.xlsx`);
        }
        //this.download('rwgl/importImportfile', {}, `批量导入模板_${new Date().getTime()}.xlsx`)
      },


      //查询文件
      fileViewing(val){
        this.pageNum = 1;
        let params = {
          pageNum: 1,
          pageSize: 20,
          ajId: val.id,
        }
        this.queryFileList(params);
        this.viewingId = val.id;
        this.dialogFormViewing = true;
      },
      //翻页后序号连贯
      viewingGetIndex($index) {
        return (this.viewingPageNum - 1) * this.viewingPageSize + $index + 1;
      },
      //分页
      viewingPageCurrent(val) {
        this.viewingPageNum = val
        params.pageNum = val
        params.pageSize = this.viewingPageSize;
        params.ajId = this.viewingId;
        this.queryFileList(params);
      },
      viewingPageSizeS(val) {
        this.viewingPageSize = val
        params.pageSize = val;
        params.pageNum = this.viewingPageNum;
        params.ajId = this.viewingId;
        this.queryFileList(params);
      },
      //查询文件条目详细信息
      queryFileList(params){
        const _this = this;
        queryFileViewing(params, {emulateJSON: true}).then(function (response) {
          _this.viewingList = response.rows;
          _this.viewingTotal = response.total;
          _this.loading = false;
        })
      },
      viewingClose(){
        this.dialogFormViewing = false;
        this.viewingPageNum = 1;
      },



      //查询任务信息(新增/编辑/删除/导入之后用此方法)
      batchTaskQuery() {
        let params = {
          pageNum: 1,
          pageSize: 20,
          pcId: this.batchId,
        }
        this.queryList(params);
      },

    }
  }
</script>

<style scoped lang="scss">
  .el-form-item--small.el-form-item {
    margin-bottom: 5px;
  }

  ::v-deep .el-cascader .el-input .el-input__inner {
    width: 200px;
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
      height: 100%;
    }
  }

  ::v-deep .el-table {
    //border-right: 1px solid #dfe6ec;
    border: 1px solid #dfe6ec;
    color: #515a6e;
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
            border-right: 1px solid #dfe6ec;
          }
        }
        tr:nth-of-type(2) {
          th {
            background: #fff;
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
            .el-input__suffix {
              width: 12px;
              .el-input__icon {
                //line-height: 23px;
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
          border-right: 1px solid #dfe6ec;
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
        .textLeft {
          text-align: left;
        }
        .el-table-column--selection {
          .cell {
            padding-right: 10px;
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
              //width: 100%;
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
      .small-padding {
        .cell {
          color: #515a6e;
        }
      }
      .noticeType {
        .el-tag {
          background-color: transparent;
          color: #515a6e;
          border: none;
        }
      }
    }

    .el-table__fixed {
      height: 100% !important; //设置高优先，以覆盖内联样式
    }
    .el-table__fixed-right {
      height: 100%;
      .el-table__fixed-header-wrapper {
        .operation {
          .cell {
            text-align: center;
            color: #515a6e;
          }
        }
      }
      .el-table__fixed-body-wrapper {
        .operation {
          padding:5px;
          .cell {
            display: flex;
            justify-content: space-around;
            width: 100%;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
            //color: #515a6e;
            .el-button {
              //width: 100%;
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
      padding:0 ;
    }
    .cell{
      line-height: 19px;
    }
  }
  .el-table--medium{
    .el-table__cell {
      padding:0;
    }
  }
  ::v-deep .taskColumnsFalse{
    width: 100%;
    height:calc(100% - 120px);
    border: 1px solid #ddd;
    display: flex;
    justify-content: center;
    align-items: center;
    color:#dfe6ec;
  }
  ::v-deep .viewingColumnsFalse{
    width: 100%;
    height:calc(100% - 40px);
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
      margin-bottom: 15px;
      line-height: 30px;
      border-bottom: 1px solid #ccc;
      margin-left: 15px;
      margin-right: 15px;
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


  .rt-input ::v-deep .el-input__inner {
    color: #000000;
  }
</style>
