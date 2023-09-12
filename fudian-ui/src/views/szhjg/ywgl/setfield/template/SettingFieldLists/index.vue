<template>
  <div>
    <el-dialog title="展示字段设置"  width="60%" :visible.sync="dialogFormVisible1" append-to-body :close-on-click-modal="false" resize remember
               class="dialog-style dialog-basic" :close-on-press-escape="false" :before-close="beforeClose1">
      <el-row>
        <el-col :span="24" style="height: 100%;">
          <!--<el-col :span="8" :style="showLeftStyleName" style="height: calc(100vh - 86px)">-->
          <el-col :span="8" :style="showLeftStyleName">
            <el-tree :data="showTree" :props="showTreeProps" :highlight-current="true" :expand-on-click-node="false"
              @node-click="showTreeClick"/>
          </el-col>

          <!--<el-col :span="16" style="height: calc(100vh - 86px)" :style="sortRightStyleName">-->
          <el-col :span="16" :style="sortRightStyleName">
            <el-table size="mini" :data="showFieldData" height="100%" tooltip-effect="light" border empty-text="暂无数据"
                      :header-cell-style="headClass" stripe  @selection-change="selectChecked">
              <el-table-column label="序号" type="index" align="center" width="50"/>
              <el-table-column label="字段名称" prop="metadataName" align="center" show-overflow-tooltip min-width="100"/>
              <el-table-column align="center" label="展示顺序" width="80">
                <template slot-scope="scope">
                  <el-button type="text" size="small" :disabled="scope.$index==0"
                             @click="showUp(scope.row,scope.$index)">上移
                  </el-button>
                  <el-button type="text" size="small" :disabled="scope.$index+1 == showFieldData.length"
                             @click="showDown(scope.row,scope.$index)">下移
                  </el-button>
                </template>
              </el-table-column>
              <el-table-column align="center" label="字段宽度" min-width="100">
                <template slot-scope="scope">
                  <el-input v-model="scope.row.displayWidth" placeholder="px" clearable size="mini"/>
                </template>
              </el-table-column>
              <el-table-column align="center" width="80" label="操作">
                <template slot-scope="scope">
                  <el-button type="text" size="small" @click="deleteShowRow(scope.row,scope.$index)">删除</el-button>
                </template>
              </el-table-column>
            </el-table>
          </el-col>
        </el-col>
      </el-row>
      <div slot="footer" class="dialog-footer">
        <el-button size="mini" plain @click="beforeClose1">取消</el-button>
        <el-button size="mini" plain type="primary" @click="editShowFormSave">保存</el-button>
      </div>
    </el-dialog>


    <el-dialog title="任务录入字段设置"  width="70%" :visible.sync="dialogFormVisible2" append-to-body :close-on-click-modal="false" resize remember
               class="dialog-style dialog-basic" :close-on-press-escape="false" :before-close="beforeClose2">
      <el-row>
        <el-col :span="24" style="height: 100%;">
          <el-col :span="8" :style="showLeftStyleName">
            <el-tree :data="sortTree" :props="sortTreeProps" :highlight-current="true" :expand-on-click-node="false"
                     @node-click="sortTreeClick"/>
          </el-col>

          <el-col :span="16" :style="sortRightStyleName">
            <el-table size="mini" :data="sortFieldData" height="100%" tooltip-effect="light" border empty-text="暂无数据"
                      :header-cell-style="headClass" stripe  @selection-change="selectChecked">
              <el-table-column label="序号" type="index" align="center" width="50"/>
              <el-table-column show-overflow-tooltip prop="metadataName" label="字段名称" align="center" min-width="100"/>
              <el-table-column show-overflow-tooltip prop="metadataType" label="字段类型" align="center" min-width="70"/>
              <el-table-column show-overflow-tooltip prop="metadataMode" label="录入方式" align="center" min-width="110">
                <template slot-scope="scope">
                  <el-select v-model="scope.row.metadataMode" clearable size="mini">
                    <el-option label="文本框" value="input"></el-option>
                    <!--<el-option label="多行文本框" value="textarea"></el-option>-->
                    <el-option label="下拉选" value="select"></el-option>
                    <el-option label="日期选择框" value="date"></el-option>
                  </el-select>
                </template>
              </el-table-column>
              <el-table-column show-overflow-tooltip label="字段长度" align="center" min-width="80">
                <template slot-scope="scope">
                  <el-input v-model="scope.row.metadataLength" placeholder="" clearable size="mini"/>
                </template>
              </el-table-column>
              <el-table-column show-overflow-tooltip label="正则验证" align="center" min-width="120">
                <template slot-scope="scope">
                  <el-select v-model="scope.row.metadataRegular" clearable size="mini">
                    <el-option v-for="item in regexOptions" :key="item.value" :label="item.label" :value="item.value" />
                  </el-select>
                </template>
              </el-table-column>
              <el-table-column align="center" label="展示顺序" width="80">
                <template slot-scope="scope">
                  <el-button type="text" size="small" :disabled="scope.$index==0"
                             @click="sortUp(scope.row,scope.$index)">上移
                  </el-button>
                  <el-button type="text" size="small" :disabled="scope.$index+1 == sortFieldData.length"
                             @click="sortDown(scope.row,scope.$index)">下移
                  </el-button>
                </template>
              </el-table-column>
              <el-table-column align="center" width="60" label="操作">
                <template slot-scope="scope">
                  <el-button type="text" size="small" @click="deleteSortRow(scope.row,scope.$index)">删除</el-button>
                </template>
              </el-table-column>
            </el-table>
          </el-col>
        </el-col>
      </el-row>
      <div slot="footer" class="dialog-footer">
        <el-button size="mini" plain @click="beforeClose2">取消</el-button>
        <el-button size="mini" plain type="primary" @click="editSortFormSave">保存</el-button>
      </div>
    </el-dialog>


    <el-dialog title="编号设置"  width="40%" :visible.sync="dialogFormVisible3" append-to-body :close-on-click-modal="false" resize remember
               class="dialog-style dialog-basic" :close-on-press-escape="false" :before-close="beforeClose3">
      <el-row>
        <el-col :span="24" style="width: 100%; padding: 10px; height: calc(80vh - 86px)">
          <div>
            <el-form ref="tableFile" :model="tableFile" :inline="true" size="small" style="margin-top: 0; margin-bottom: 0;">
              <el-form-item label="编号字段" prop="metadataName">
                <el-select size="mini" v-model="tableFile.metadataName" disabled filterable clearable class="rt-input"
                           @change="handleSearch" style="width:200px">
                  <el-option v-for="metaDataItem in metaDataOptionList" :key="metaDataItem.id"
                             :label="metaDataItem.metadataName" :value="metaDataItem.id" />
                </el-select>
              </el-form-item>
            </el-form>
          </div>

          <div style="height: 90%; display:flex;flex-direction:column;"  v-show="mainPopover">
            <div style="height: 50%">
              <TableMetadata :tableData="selectedTableData" :isPage="false" :hasSelection="false" :isTitle="false">
                <template slot="table">
                  <el-table-column label="编号组成字段" prop="metadataName" min-width="100">
                    <template slot-scope="scope">
                      <el-select size="mini" v-model="scope.row.metadataId" placeholder="请选择元数据中文名称" maxlength="30"
                                 filterable @change="handleChangeMeta(scope.row)" @clear="handleClear(scope.row)" clearable>
                        <el-option v-for="metaDataItem in metaDataOptions" :key="metaDataItem.metadataId"
                                   :label="metaDataItem.metadataName" :value="metaDataItem.metadataId"
                                   :disabled="!!selectedTableData.find(val => val.metadataId === metaDataItem.metadataId)"/>
                      </el-select>
                    </template>
                  </el-table-column>
                  <el-table-column label="字段名称" min-width="100" prop="sourceName"></el-table-column>
                  <el-table-column align="center" label="展示顺序" width="100">
                    <template slot-scope="scope">
                      <el-button type="text" size="small" :disabled="scope.$index==0"
                                 @click="numberUp(scope.row,scope.$index)">上移
                      </el-button>
                      <el-button type="text" size="small" :disabled="scope.$index+1 == sortFieldData.length"
                                 @click="numberDown(scope.row,scope.$index)">下移
                      </el-button>
                    </template>
                  </el-table-column>
                  <el-table-column label="操作" width="100" class-name="operation">
                    <template slot-scope="scope">
                      <el-button type="text" size="mini" @click="addItem(selectedTableData,scope.$index)" v-if="scope.$index===selectedTableData.length-1">
                        新增
                      </el-button>
                      <el-button type="text" size="mini" :disabled="scope.$index===0"
                                 @click="deleteItem(selectedTableData,scope.$index)">移除
                      </el-button>
                    </template>
                  </el-table-column>
                </template>
              </TableMetadata>
            </div>
            <div style="height: 25%">
              <div style="margin-top: 15px;display: flex;justify-content: center;align-items: center;">
                <el-button  type="info" plain size="mini" @click="displayNumber">编 号 查 看</el-button>
              </div>
              <div style="margin-top: 15px">
                <el-input placeholder="" v-model="mainDisplay" :disabled="true" class="rt-input"></el-input>
              </div>
            </div>
            <div style="height: 25%; display:flex;justify-content:flex-start;align-items:center;">
              <el-form ref="tableFile" :model="tableFile" :rules="bulkRules" :inline="true" size="small"
                       style="margin-right:auto;margin-left:0;">
                <el-form-item label="是否允许批量添加任务" prop="bulkAdd">
                  <el-radio-group v-model="tableFile.bulkAdd">
                    <el-radio label="是">是</el-radio>
                    <el-radio label="否">否</el-radio>
                  </el-radio-group>
                </el-form-item><br>
                <el-form-item label="请选择对应的批量任务字段" prop="bulkField" v-if="tableFile.bulkAdd ==='是'">
                  <el-select size="mini" v-model="tableFile.bulkField" placeholder="请选择" clearable>
                    <el-option v-for="item in selectedTableData" :key="item.id" :label="item.metadataName" :value="item.id" />
                  </el-select>
                </el-form-item>
              </el-form>
            </div>
          </div>

        </el-col>
      </el-row>
      <div slot="footer" class="dialog-footer">
        <el-button size="mini" plain @click="beforeClose3">取消</el-button>
        <el-button size="mini" plain type="primary" @click="numberFormSave">保存</el-button>
      </div>
    </el-dialog>


    <el-dialog title="著录录入字段设置"  width="70%" :visible.sync="dialogFormVisible4" append-to-body :close-on-click-modal="false" resize remember
               class="dialog-style dialog-basic" :close-on-press-escape="false" :before-close="beforeClose4">
      <el-row>
        <el-col :span="24" style="height: 100%;">
          <el-col :span="8" :style="showLeftStyleName">
            <el-tree :data="inputTree" :props="inputTreeProps" :highlight-current="true" :expand-on-click-node="false"
                     @node-click="inputTreeClick"/>
          </el-col>
          <el-col :span="16" :style="sortRightStyleName">
            <el-table size="mini" :data="inputFieldData" height="100%" tooltip-effect="light" border empty-text="暂无数据"
                      :header-cell-style="headClass" stripe  @selection-change="selectChecked">
              <el-table-column label="序号" type="index" align="center" width="50"/>
              <el-table-column show-overflow-tooltip prop="metadataName" label="字段名称" align="center" min-width="100"/>
              <el-table-column show-overflow-tooltip prop="metadataType" label="字段类型" align="center" min-width="70"/>
              <el-table-column show-overflow-tooltip prop="metadataMode" label="录入方式" align="center" min-width="110">
                <template slot-scope="scope">
                  <el-select v-model="scope.row.metadataMode" clearable size="mini">
                    <el-option label="文本框" value="input"></el-option>
                    <!--<el-option label="多行文本框" value="textarea"></el-option>-->
                    <el-option label="下拉选" value="select"></el-option>
                    <el-option label="日期选择框" value="date"></el-option>
                  </el-select>
                </template>
              </el-table-column>
              <el-table-column show-overflow-tooltip label="字段长度" align="center" min-width="80">
                <template slot-scope="scope">
                  <el-input v-model="scope.row.metadataLength" placeholder="" clearable size="mini"/>
                </template>
              </el-table-column>
              <el-table-column show-overflow-tooltip label="正则验证" align="center" min-width="120">
                <template slot-scope="scope">
                  <el-select v-model="scope.row.metadataRegular" clearable size="mini">
                    <el-option v-for="item in regexOptions" :key="item.value" :label="item.label" :value="item.value" />
                  </el-select>
                </template>
              </el-table-column>
              <el-table-column align="center" label="展示顺序" width="80">
                <template slot-scope="scope">
                  <el-button type="text" size="small" :disabled="scope.$index==0"
                             @click="inputUp(scope.row,scope.$index)">上移
                  </el-button>
                  <el-button type="text" size="small" :disabled="scope.$index+1 == inputFieldData.length"
                             @click="inputDown(scope.row,scope.$index)">下移
                  </el-button>
                </template>
              </el-table-column>
              <el-table-column align="center" width="60" label="操作">
                <template slot-scope="scope">
                  <el-button type="text" size="small" @click="deleteInputRow(scope.row,scope.$index)">删除</el-button>
                </template>
              </el-table-column>
            </el-table>
          </el-col>
        </el-col>
      </el-row>
      <div slot="footer" class="dialog-footer">
        <el-button size="mini" plain @click="beforeClose4">取消</el-button>
        <el-button size="mini" plain type="primary" @click="editInputFormSave">保存</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import TableMetadata from "@/components/public/MainBody/TableMetadata";
import { Message } from "element-ui";
import { querySortfieldList, querySortAppoint } from '@/api/szhjg/ywgl/setfield/template';
import { saveOrDisplayField, saveOrInputField, descOrInputField, queryNoFixField } from '@/api/szhjg/ywgl/setfield/template';
import { queryMetadataType } from '@/api/szhjg/ywgl/setfield/generalPurpose';
import { queryRegularExpressionList } from '@/api/szhjg/ywgl/setfield/template';
import { queryNumberOne, queryNumberFieldList, queryExampleFieldExists } from '@/api/szhjg/ywgl/setfield/template';
import { addNumberingField } from '@/api/szhjg/ywgl/setfield/template';


export default {
  name: "SettingFieldLists",
  components: { TableMetadata },
  data() {
    return {
      isNotNull:'',
      dialogFormVisible1: false,
      dialogFormVisible2: false,
      dialogFormVisible3: false,
      dialogFormVisible4: false,
      // 遮罩层
      loading: true,
      //展示表单左侧布局
      showLeftStyleName: {width: '25%', height: 'calc(80vh - 86px)', position: 'relative'},
      //排序表单右侧布局
      sortRightStyleName: {width: '75%', padding: ' 10px', height: 'calc(80vh - 86px)'},

      showTree: [],//展示设置tree数据
      showTreeProps: {//展示设置tree数据展示规则
        label: 'metadataName',
      },
      showFieldData: [],   //展示字段表数据
      selectRowData: [],  //表单选择row数据

      sortTree: [],//任务录入设置tree数据
      sortTreeProps: {//任务录入设置tree数据展示规则
        label: 'metadataName',
      },
      sortFieldData: [],   //任务录入字段表数据

      inputTree: [],//著录录入设置tree数据
      inputTreeProps: {//著录录入设置tree数据展示规则
        label: 'metadataName',
      },
      inputFieldData: [],   //著录录入字段表数据

      eventData: [],//编号设置tree数据

      fixId:'',
      fixPoints:'',

      //字段类型列表
      typeOptions: [],
      //正则表达式列表
      regexOptions: [],

      //编号信息
      //编号主字段
      tableFile:{metadataName:'', bulkAdd:'', bulkField:'', },
      //编号主字段选择框
      metaDataOptionList: [],
      //编号主字段是否存在
      mainExample:'',
      //编号组成字段选择框
      metaDataOptions: [],
      mainPopover:false,
      //编号拼接展示字段
      mainDisplay:'',
      selectedTableData: [
        //{id:'', metadataName:'', sourceName:'', metadataId:'', fieldOrder:'',}
      ],
      //批量添加-存放可选字段
      bulkOptions: [
        {value: '选项A', label: '麻辣香锅'},
        {value: '选项B', label: '麻辣火锅'},
        {value: '选项C', label: '麻辣烤鱼'},
      ],
      //批量添加-任务验证
      bulkRules: {
        bulkField:[
          {required: true, message: '请选择字段类型', trigger: 'blur,change'}
        ],
      },
    }
  },

  created(){
    this.queryDictList();
    this.queryRegularList();
  },

  methods: {
    // 窗口初始化方法，nextTick方法可以添加逻辑，如打开窗口时查询数据填充
    init(bizForm) {
      this.$nextTick(() => {
        this.fixId =  bizForm.idJump;
        this.fixPoints =  bizForm.typeJump;
        this.queryCaseList(bizForm);
        if (bizForm.setNumber==="show"){
          this.dialogFormVisible1 = true;
        }else if (bizForm.setNumber==="enter"){
          this.dialogFormVisible2 = true;
        }else if (bizForm.setNumber==="edit"){
          this.queryNumberLists(bizForm);
          this.queryExistsOne(bizForm);
        }else if (bizForm.setNumber==="input"){
          this.dialogFormVisible4 = true;
        }
      });
    },
    queryCaseList(val){
      const _this = this
      querySortfieldList({daId: val.idJump, points: val.typeJump}).then(response => {
        if (val.setNumber === "show"){
          _this.showTree = response.data;
        }else if (val.setNumber === "enter"){
          _this.sortTree = response.data;
        }else if (val.setNumber === "input"){
          _this.inputTree = response.data;
        }
      });
      querySortAppoint({daId: val.idJump, points: val.typeJump, appoint: val.setNumber}).then(response => {
        if (val.setNumber === "show"){
          _this.showFieldData = response.data;
        }else if (val.setNumber === "enter"){
          _this.sortFieldData = response.data;
        }else if (val.setNumber === "input"){
          _this.inputFieldData = response.data;
        }
      });
    },

    //查询元数据字段类型
    queryDictList(){
      queryMetadataType().then(res => {
        this.typeOptions = res.map((item) => {
          return item;
        });
      });
    },
    //查询正则表达式列表
    queryRegularList(){
      queryRegularExpressionList().then(res => {
        this.regexOptions = res.map((item) => {
          return item;
        });
      });
    },

    headClass() {
      return 'background:rgba(204, 204, 204, 0.18);color:#909399;height:31px;font-size:12px'
    },

    //获取table表格中的row
    selectChecked(row) {
      this.selectRowData = row;
    },

    //展示tree点击
    showTreeClick(data) {
      for (let i = 0; i < this.showFieldData.length; i++) {
        if (this.showFieldData[i].metadataName == data.metadataName) {
          this.$message.info(data.metadataName + ' 字段已存在')
          return;
        }
      }
      let len = this.showFieldData.length == 0 ? 0 : this.showFieldData[this.showFieldData.length - 1].fieldOrder + 1;
      const tb = {
        id: data.id,
        metadataName: data.metadataName,
        fieldOrder: len,
      };
      this.showFieldData.push(tb);
    },
    //展示上移方法
    showUp(row, index) {
      let upData = this.showFieldData[index - 1];
      let data = this.showFieldData[index];
      const upOrder = upData.fieldOrder;
      upData.fieldOrder = data.fieldOrder;
      data.fieldOrder = upOrder;
      this.showFieldData.splice(index - 1, 1);
      this.showFieldData.splice(index, 0, upData);
    },
    //展示下移方法
    showDown(row, index) {
      let downData = this.showFieldData[index + 1];
      let data = this.showFieldData[index];
      const downOrder = downData.fieldOrder;
      downData.fieldOrder = data.fieldOrder;
      data.fieldOrder = downOrder;
      this.showFieldData.splice(index + 1, 1);
      this.showFieldData.splice(index, 0, downData);
    },
    //删除展示字段
    deleteShowRow(row, len) {
      this.showFieldData.splice(len, 1);
    },
    //展示字段提交
    editShowFormSave() {
      if (this.showFieldData.length == 0) {
        queryNoFixField({daId:this.fixId, points:this.fixPoints, king:"ex"}).then(response => {
          if (response.code == "200") {
            this.$message({message: "字段设置成功", type: 'success'})
            this.dialogFormVisible1 = false;
          }
        })
      }else {
        let showData = this.showFieldData;
        saveOrDisplayField(showData).then((res) => {
          if (res.code == 200) {
            this.$message({message: "字段设置成功", type: 'success'})
            this.dialogFormVisible1 = false;
          }
        })
      }
    },


    //任务录入tree点击
    sortTreeClick(data) {
      for (let i = 0; i < this.sortFieldData.length; i++) {
        if (this.sortFieldData[i].metadataName == data.metadataName) {
          this.$message.info(data.metadataName + ' 字段已存在')
          return;
        }
      }
      let len = this.sortFieldData.length == 0 ? 0 : this.sortFieldData[this.sortFieldData.length - 1].fieldOrder + 1;
      this.sortFieldData.map(item => {
        this.typeOptions.forEach((item2) => {
          if (item.metadataType === item2.value) {
            item.metadataType = item2.label;
          }
        });
      })
      this.typeOptions.forEach((item) => {
        if (data.metadataType === item.value) {
          data.metadataType = item.label;
        }
      });
      const tb = {
        id: data.id,
        metadataName: data.metadataName,
        metadataType: data.metadataType,
        metadataMode: data.metadataMode,
        metadataLength: data.metadataLength,
        metadataRegular: data.metadataRegular,
        fieldOrder: len,
      };
      this.sortFieldData.push(tb);
    },
    //任务录入上移方法
    sortUp(row, index) {
      let upData = this.sortFieldData[index - 1];
      let data = this.sortFieldData[index];
      const upOrder = upData.fieldOrder;
      upData.fieldOrder = data.fieldOrder;
      data.fieldOrder = upOrder;
      this.sortFieldData.splice(index - 1, 1);
      this.sortFieldData.splice(index, 0, upData);
    },
    //任务录入下移方法
    sortDown(row, index) {
      let downData = this.sortFieldData[index + 1];
      let data = this.sortFieldData[index];
      const downOrder = downData.fieldOrder;
      downData.fieldOrder = data.fieldOrder;
      data.fieldOrder = downOrder;
      this.sortFieldData.splice(index + 1, 1);
      this.sortFieldData.splice(index, 0, downData);
    },
    //删除任务录入字段
    deleteSortRow(row, len) {
      this.sortFieldData.splice(len, 1);
    },
    //任务录入字段提交
    editSortFormSave() {
      if (this.sortFieldData.length == 0) {
        queryNoFixField({daId:this.fixId, points:this.fixPoints, king:"en"}).then(response => {
          if (response.code == "200") {
            this.$message({message: "字段设置成功", type: 'success'})
            this.dialogFormVisible2 = false;
          }
        })
      }else {
        let sortData = this.sortFieldData;
        saveOrInputField(sortData).then((res) => {
          if (res.code == 200) {
            this.$message({message: "字段设置成功", type: 'success'})
            this.dialogFormVisible2 = false;
          }
        })
      }
    },


    //编号需要字段列表
    queryNumberLists(val){
      queryNumberFieldList({daId: val.idJump, points: val.typeJump}).then(response => {
        this.metaDataOptionList = response.rows;
      });
    },
    handleSearch(item) {
      //this.tableFile.metadataName = item;
      this.mainPopover = true;
      this.mainExample = item;
      this.selectedTableData =  [{id:'',metadataName:'',sourceName:'',metadataId:'',fieldOrder:1,}];
      this.queryFieldList(item);
    },
    //查询编号是否存在
    queryExistsOne(val){
      //查询是否有编号字段
      queryNumberOne({daId: val.idJump, points: val.typeJump}).then(response => {
        //this.tableFile.metadataName = response.msg;
        this.mainExample = response.data.msg1;
        if ( this.mainExample === null || this.mainExample === undefined || this.mainExample.trim() === ''){
          this.mainPopover = false;
          Message.warning("未设置[bh]映射字段, 无法进行编号设置, 请到 '设置映射字段' 功能中设置!");
        }else {
          this.mainPopover = true;
          this.tableFile.metadataName = response.data.msg1;
          this.tableFile.bulkAdd = response.data.msg2;
          this.tableFile.bulkField = response.data.msg3;
          this.queryExistsLists(val);
          this.queryFieldList(response.data.msg1);
          this.dialogFormVisible3 = true;
        }
      });
      //this.dialogFormVisible3 = true;
    },
    queryExistsLists(val){
      queryExampleFieldExists({daId: val.idJump, points: val.typeJump}).then(response => {
        let arr = response.rows;
        if (arr.length === 0 || !arr || arr == undefined) {
          this.selectedTableData =  [{id:'',metadataName:'',sourceName:'',metadataId:'',fieldOrder:1,}];
        }else {
          arr.map(item => {
            const obj = {
              id: item.id,
              metadataName:item.metadataName,
              sourceName: item.sourceName,
              metadataId: item.metadataId,
              fieldOrder: item.berSort,
            };
            this.selectedTableData.push(obj);
          })
        }
      })
    },
    queryFieldList(val){
      queryNumberFieldList({daId:this.fixId, points:this.fixPoints, nameId:val}).then(response => {
        this.metaDataOptions = response.rows;
      });
    },

    //映射弹窗表格选中的值发生变化
    handleChangeMeta(row) {
      //元数据下拉框选择任意一个后，元数据类型、元数据长度同步变成对应的值
      let item = this.metaDataOptions.find(item => item.metadataId === row.metadataId);
      /*判断是否可选择*/
      if (item) {
        row.id = item.id;
        row.metadataName = item.metadataName;
        row.sourceName = item.sourceName;
        row.metadataId = item.metadataId;
      } else {
        row.id = '';
        row.metadataName = '';
        row.sourceName = '';
        row.metadataId = '';
      }
    },
    //清空时，被清空的值可被再次选择，判断tableData与选择数组中metaDataOptions的
    handleClear(row) {
      row.metadataName = '';
      row.sourceName = '';
      row.id = '';
    },
    //设置映射弹窗内新增映射
    addItem(arr) {
      let len = this.selectedTableData.length == 0 ? 0 : this.selectedTableData[this.selectedTableData.length - 1].fieldOrder + 1;
      let obj = {id:'',metadataName:'',sourceName:'',metadataId:'',fieldOrder:len,};
      arr.push(obj);
    },
    //移除映射
    deleteItem(arr, index) {
      arr.splice(index, 1);
    },
    //编号上移方法
    numberUp(row, index) {
      let upData = this.selectedTableData[index - 1];
      let data = this.selectedTableData[index];
      const upOrder = upData.fieldOrder;
      upData.fieldOrder = data.fieldOrder;
      data.fieldOrder = upOrder;
      this.selectedTableData.splice(index - 1, 1);
      this.selectedTableData.splice(index, 0, upData);
    },
    //编号下移方法
    numberDown(row, index) {
      let downData = this.selectedTableData[index + 1];
      let data = this.selectedTableData[index];
      const downOrder = downData.fieldOrder;
      downData.fieldOrder = data.fieldOrder;
      data.fieldOrder = downOrder;
      this.selectedTableData.splice(index + 1, 1);
      this.selectedTableData.splice(index, 0, downData);
    },
    //查看编号
    displayNumber(){
      let name1 = '';
      this.metaDataOptionList.forEach((item2) => {
        if (this.mainExample === item2.id) {
          name1 = item2.metadataName;
        }
      });

      let name2 = '';
      //this.selectedTableData.sort((a, b) => a.fieldOrder - b.fieldOrder)
      let names = this.selectedTableData.map(item => item.metadataName)
      names.forEach((item, index) => {
        //判断是否为最后一个元素
        if (index === names.length - 1) {
          name2 = name2 + item;
        }else {
          name2 = name2 + item +"-";
        }
      });
      this.mainDisplay = name1 + " = " + name2;
    },
    //保存编号
    numberFormSave(){
      const _this = this;
      let setForm = {
        daId:this.fixId,
        points:this.fixPoints,
        numberName: this.mainExample,
        numberList: this.selectedTableData,
        appendPermit: this.tableFile.bulkAdd,
        appendField: this.tableFile.bulkField,
      }
      addNumberingField(setForm).then(response => {
        _this.$message({message:"设置编号成功", type: 'success'})
        _this.clearATrace();
        _this.dialogFormVisible3 = false;
      })
    },


    //著录录入tree点击
    inputTreeClick(data) {
      for (let i = 0; i < this.inputFieldData.length; i++) {
        if (this.inputFieldData[i].metadataName == data.metadataName) {
          this.$message.info(data.metadataName + ' 字段已存在')
          return;
        }
      }
      let len = this.inputFieldData.length == 0 ? 0 : this.inputFieldData[this.inputFieldData.length - 1].fieldOrder + 1;
      this.inputFieldData.map(item => {
        this.typeOptions.forEach((item2) => {
          if (item.metadataType === item2.value) {
            item.metadataType = item2.label;
          }
        });
      })
      this.typeOptions.forEach((item) => {
        if (data.metadataType === item.value) {
          data.metadataType = item.label;
        }
      });
      const tb = {
        id: data.id,
        metadataName: data.metadataName,
        metadataType: data.metadataType,
        metadataMode: data.metadataMode,
        metadataLength: data.metadataLength,
        metadataRegular: data.metadataRegular,
        fieldOrder: len,
      };
      this.inputFieldData.push(tb);
    },
    //著录录入上移方法
    inputUp(row, index) {
      let upData = this.inputFieldData[index - 1];
      let data = this.inputFieldData[index];
      const upOrder = upData.fieldOrder;
      upData.fieldOrder = data.fieldOrder;
      data.fieldOrder = upOrder;
      this.inputFieldData.splice(index - 1, 1);
      this.inputFieldData.splice(index, 0, upData);
    },
    //著录录入下移方法
    inputDown(row, index) {
      let downData = this.inputFieldData[index + 1];
      let data = this.inputFieldData[index];
      const downOrder = downData.fieldOrder;
      downData.fieldOrder = data.fieldOrder;
      data.fieldOrder = downOrder;
      this.inputFieldData.splice(index + 1, 1);
      this.inputFieldData.splice(index, 0, downData);
    },
    //删除著录录入字段
    deleteInputRow(row, len) {
      this.inputFieldData.splice(len, 1);
    },
    //著录录入字段提交
    editInputFormSave() {
      if (this.inputFieldData.length == 0) {
        queryNoFixField({daId:this.fixId, points:this.fixPoints, king:"zl"}).then(response => {
          if (response.code == "200") {
            this.$message({message: "字段设置成功", type: 'success'})
            this.dialogFormVisible4 = false;
          }
        })
      }else {
        let sortData = this.inputFieldData;
        descOrInputField(sortData).then((res) => {
          if (res.code == 200) {
            this.$message({message: "字段设置成功", type: 'success'})
            this.dialogFormVisible4 = false;
          }
        })
      }
    },


    //关闭页面弹窗
    beforeClose1(){
      this.dialogFormVisible1 = false;
    },
    beforeClose2(){
      this.dialogFormVisible2 = false;
    },
    beforeClose3(){
      this.dialogFormVisible3 = false;
      this.clearATrace();
    },
    clearATrace(){
      this.selectedTableData = [];
      //this.tableFile.metadataName = '';
      this.tableFile = { metadataName:'', bulkAdd:'', bulkField:'', };
      this.mainDisplay = '';
    },
    beforeClose4(){
      this.dialogFormVisible4 = false;
    },


  },

}
</script>

<style scoped lang="scss">
.el-form-item--small.el-form-item{
  margin-bottom: 5px;
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

//禁止输入框输入,字体颜色黑色
.rt-input ::v-deep .el-input__inner{
  color:  #000000;
}

</style>
