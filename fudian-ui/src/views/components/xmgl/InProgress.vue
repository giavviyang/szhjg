<template>
  <div class="InProgress">
    <div class="InProgress-box">
      <div class="box-pro item" v-for="item in dataList.rows">
        <div class="pro-box">
          <div class="box-pro-right">
            <div class="pro-tit"><a style="color: #7c7c7c">{{ item.projectName }}</a></div>
            <div class="pro-text"><b>档案类型：</b>{{ item.dalx }}</div>
            <div class="pro-text"><b>当前工序：</b>{{ item.dqgx }}</div>
            <div class="pro-text"><b>创建时间：</b>{{ item.createTime }}</div>
            <div class="pro-text"><b>项目描述：</b>{{ item.projectXmms }}</div>
          </div>
        </div>
        <div class="pro-btn">
          <div v-hasPermi="['components:xmgl:taskE']" @click="seePatch(item)">查看批次任务</div>
          <div v-hasPermi="['components:xmgl:taskB']" @click="toPopup('edit',item)">修改</div>
          <div v-hasPermi="['components:xmgl:taskC']" @click="toDelete(item)">删除</div>
          <div v-hasPermi="['components:xmgl:taskD']" @click="toComplete(item)">完成</div>
        </div>
      </div>
      <div class="item" v-hasPermi="['components:xmgl:taskA']" @click="toPopup('add')">
        ✚ 新增
      </div>
    </div>
    <!--    新增/编辑弹窗-->
    <el-dialog :title="buttonType=='add'?'新增项目':'编辑项目'" :visible.sync="dialogFormVisible" width="60%"
               :before-close="handleClose">
      <div class="basicmsg">基本信息</div>
      <el-form :model="form" ref="form" :rules="formRules" style="width: 90%;margin:auto">
        <div style="display: flex;justify-content: space-between">
          <el-form-item label="项目名称" prop="projectName" :label-width="formLabelWidth">
            <el-input v-model="form.projectName" size="mini" autocomplete="off" style="width:200px"
                      @blur="checkDouble"></el-input>
          </el-form-item>
          <el-form-item label="档案类型" prop="dalx" :label-width="formLabelWidth">
            <el-select v-model="form.dalx" size="mini" placeholder="请选择档案类型" clearable style="width:200px">
              <el-option v-for="item in dalxOptions" :key="item.value" :label="item.label"
                         :value="item.value"></el-option>
            </el-select>
          </el-form-item>
        </div>
        <el-form-item label="项目描述" prop="projectXmms" :label-width="formLabelWidth"
                      style="display: inline-block;width: 100%">
          <el-input type="textarea" :rows="2" v-model="form.projectXmms" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div class="basicmsg">工序设置</div>
      <div class="shuttle">
        <div class="all">
          <b style="color: blue">全部工序：</b>
          <!-- 不需要分页添加（:hasSelection="false" :isPage="false"）两个属性-->
          <TablePage :tableData="AllAstep" :showNumber="false" :isPage="false"
                     @handleSelectionChange="handleSelectionChange"
                     @handleRowClick="handleRowClick">
            <template v-slot:table>
              <el-table-column slot="table" v-for="(item,index) in frameColumns" :key="index" :label="item.label"
                               :prop="item.prop" :min-width="item.width" show-overflow-tooltip>
              </el-table-column>
            </template>
          </TablePage>
        </div>
        <div class="btn">
          <el-button type="primary" size="mini" @click="addRight()">添加 >></el-button>
          <el-button type="primary" size="mini" @click="addLeft()"><< 移除</el-button>
        </div>
        <div class="conduct">
          <b style="color: blue">添加项目所需工序：</b>
          <!-- 不需要分页添加（:hasSelection="false" :isPage="false"）两个属性-->
          <TablePage :tableData="AllAstepNeed" :showNumber="false" :isPage="false"
                     @handleSelectionChange="handleSelectionChangeLeft"
                     @handleRowClick="handleRowClickLeft">
            <el-table-column slot="table" v-for="(item,index) in frameColumnsNeed" :key="index" :label="item.label"
                             :prop="item.prop" :min-width="item.width" show-overflow-tooltip>
            </el-table-column>
          </TablePage>
        </div>
      </div>
      <div slot="footer" class="dialog-footer">
        <el-button @click="handleClose" size="mini">取 消</el-button>
        <el-button type="primary" @click="addDoing('form')" size="mini">保 存</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import TablePage from "@/components/public/table/TablePage";
import {addAProject, allAstep, EditItem, ProjectGxhjList, deleteProject, getProject} from "@/api/szhjg/xmpcgl/xmgl";
import {queryDuplicate} from "@/api/szhjg/xmpcgl/xmgl";
import {queryArchivesName} from "@/api/szhjg/szhjgCommon";
import {completeProject} from "@/api/szhjg/xmpcgl/xmgl";


export default {
  name: "InProgress",
  components: {TablePage},
  props: {
    ProjectList: Object,
  },
  watch: {
    ProjectList(val) {
      val.rows.forEach((value, index) => {
        const arr = this.dalxOptions.map((item) => {
          return item
        })
        for (var i in arr) {
          if (value.dalx == arr[i].value) {
            value.dalx = arr[i].label;
          }
        }
      })
      this.dataList = val;
    }
  },
  data() {
    return {
      //表单查询档案字段
      dalxOptions: [],
      dataList: {},
      buttonType: '',
      dialogFormVisible: false,
      AllAstep: [],
      AllAstepNeed: [],
      StagingList: [],
      StagingNeedList: [],
      requiredList: [],
      form: {
        projectName: '',
        dalx: '',
        projectXmms: '',
      },
      //编辑存放数据
      editorForm: {
        id: '', projectName: '', projectXmms: '', dqgx: '', dalx: '', createBy: '', createTime: '', isfinished: '',
        ids: [],
      },
      formRules: {
        projectName: [
          {required: true, message: '请输入项目名称', trigger: 'blur'},
        ],
        dalx: [
          {required: true, message: '请选择项目类型', trigger: 'blur'},
        ],
        projectXmms: [
          {required: true, message: '请输入项目描述', trigger: 'blur'},
        ],
      },
      formLabelWidth: '80px',
      frameColumns: [
        {label: '工序序号', prop: 'gxxh', width: '100'},
        {label: '工序名称', prop: 'gxmc', width: '100'},
      ],
      frameColumnsNeed: [
        {label: '工序序号', prop: 'gxxh', width: '100'},
        {label: '工序名称', prop: 'gxmc', width: '100'},
      ],
      //重名字段
      duplicate: '',
    }
  },
  mounted() {
  },
  created() {
    this.dalxQueryOptions();
  },
  methods: {
    //弹窗查询档案名称字段
    dalxQueryOptions() {
      const dictType = "";
      queryArchivesName(dictType).then(res => {
        this.dalxOptions = res.map((item) => {
          return item;
        });
      });
    },
    // 打开新增编辑弹窗
    async toPopup(type, item) {
      this.buttonType = type
      if (this.buttonType == 'add') {
        this.form = {
          projectName: '',
          dalx: '',
          projectXmms: ''
        }
        this.AllAstep = []
        this.AllAstepNeed = []
        this.getAllAstep()
        this.dialogFormVisible = true;
      } else if (this.buttonType == 'edit') {
        this.dialogFormVisible = true;
        this.AllAstep = []
        this.AllAstepNeed = []
        await this.getAllAstep()
        await this.getEditItem(item)
      }
    },
    // 回显编辑页数据和《需要进行的工序》的数据
    getEditItem(item) {
      this.form.projectName = item.projectName
      this.form.dalx = item.dalx
      this.form.projectXmms = item.projectXmms
      this.editorForm = item;
      ProjectGxhjList({projectId: item.id}).then((res) => {
        this.AllAstepNeed = res.rows
        for (let i = 0; i < this.AllAstepNeed.length; i++) {
          this.AllAstep.filter((item, index) => {
            if (item.gxxh == this.AllAstepNeed[i].gxxh) {
              this.AllAstep.splice(index, 1)
            }
          })
        }
      })
    },
    // 获取弹窗内全部工序
    async getAllAstep() {
      await allAstep({pageNum: 1, pageSize: 20}).then((res) => {
        this.AllAstep = res.rows
      })
    },
    // 新增进行中项目
    toAddAProject() {
      const _this = this;
      let projectName = this.form.projectName
      let dalx = this.form.dalx
      let projectXmms = this.form.projectXmms
      let ids = this.AllAstepNeed.map(item => {
        return item.id
      })
      let dqgx = (this.AllAstepNeed.map((item) => {
        return item.gxmc
      })).join('-')
      addAProject({projectName, dalx, projectXmms, ids, dqgx}).then((res) => {
        if (res.code == 200) {
          this.$message({message: "新增项目成功", type: 'success'});
          _this.dialogFormVisible = false;
          _this.queryList();
        } else {
          this.$message({message: "新增项目失败", type: 'error'});
        }
      })
    },
    // 编辑进行中项目
    toEditAProject() {
      const _this = this;
      let ids = this.AllAstepNeed.map(item => {
        return item.id
      });
      let dqgx = (this.AllAstepNeed.map((item) => {
        return item.gxmc
      })).join('-');

      this.editorForm.projectName = this.form.projectName;

      for (var i in this.dalxOptions) {
        if ( this.form.dalx == this.dalxOptions[i].label) {
          this.form.dalx = this.dalxOptions[i].value
        }
      }

      this.editorForm.dalx = this.form.dalx;
      this.editorForm.projectXmms = this.form.projectXmms;
      this.editorForm.ids = ids;
      this.editorForm.dqgx = dqgx;

      EditItem(this.editorForm).then((res) => {
        if (res.code == 200) {
          this.$message({message: "修改项目成功", type: 'success'});
          _this.dialogFormVisible = false;
          _this.queryList();
        } else {
          this.$message({message: "修改项目失败", type: 'error'});
        }
      })
    },

    //查询列表
    queryList() {
      getProject({isfinished: 0, pageNum: 1, pageSize: 20}).then((res) => {
        res.rows.forEach((value, index) => {
          const arr = this.dalxOptions.map((item) => {
            return item
          })
          for (var i in arr) {
            if (value.dalx == arr[i].value) {
              value.dalx = arr[i].label;
            }
          }
        })
        this.dataList = res
      })
    },

    // 判断提交按钮
    addDoing(form) {
      if (this.duplicate == "true") {
        this.$message.error("项目名称已存在,请更换项目名称!")
        return;
      }
      this.$refs[form].validate((valid) => {
        if (valid) {
          if(this.AllAstepNeed.length>0){
            if (this.buttonType == 'add') {
              this.toAddAProject()
            } else {
              this.toEditAProject()
            }
          }else{
            this.$message.warning('请至少选择一项工序')
          }

        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    // 判断取消按钮
    handleClose() {
      this.duplicate = '';
      this.form = {
        projectName: '',
        dalx: '',
        projectXmms: ''
      }
      this.AllAstep = [];
      this.AllAstepNeed = [];
      this.dialogFormVisible = false
    },
    // 删除项目
    toDelete(item) {
      this.$confirm('此操作将永久删除该项目, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let id = item.id;
        deleteProject(id).then((res) => {
          this.$message.success(res.msg)
          this.queryList();
        })
      }).catch(() => {});
    },
    //是否完成项目
    toComplete(item){
      this.$confirm('此操作将结束该项目, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let id = item.id;
        completeProject({id:id}).then((res) => {
          this.$message.success(res.msg)
          this.queryList();
        })
      }).catch(() => {})
    },
    // 添加需要进行的工序
    addRight() {
      if (this.StagingList.length > 0) {
        this.AllAstepNeed = this.StagingList.concat(this.AllAstepNeed).sort((a,b)=>{
          return a.gxxh - b.gxxh;
        })
        for (let i = 0; i < this.AllAstepNeed.length; i++) {
          this.AllAstep.filter((item, index) => {
            if (item.id == this.AllAstepNeed[i].id) {
              this.AllAstep.splice(index, 1)
            }
          }).sort((a,b)=>{
            return a.gxxh - b.gxxh;
          })
        }

      } else {
        this.$message.warning('请先选择工序再进行添加哦')
      }
    },
    // 移除已经添加需要进行的工序
    addLeft() {
      if (this.StagingNeedList.length > 0) {
        this.AllAstep = this.StagingNeedList.concat(this.AllAstep).sort((a,b)=>{
          return a.gxxh - b.gxxh;
        })
        for (let i = 0; i < this.StagingNeedList.length; i++) {
          this.AllAstepNeed.filter((item, index) => {
            if (item.id == this.StagingNeedList[i].id) {
              this.AllAstepNeed.splice(index, 1)
            }
          }).sort((a,b)=>{
            return a.gxxh - b.gxxh;
          })
        }
      } else {
        this.$message.warning('请先选择需要移除的工序哦')
      }
    },
    seePatch(item) {
      this.$router.push({path: '/szhjg/xmpcgl/pcgl', query: {id: item.id}})
    },
    // 复选框事件
    handleSelectionChange(val) {
      this.StagingList = val
    },
    // 行点击事件
    handleRowClick(row, column, event) {
      // console.log(row, column, event)
    },
    handleSelectionChangeLeft(val) {
      this.StagingNeedList = val
    },
    handleRowClickLeft(row, column, event) {
      // console.log(row, column, event)
    },


    //重名判断
    checkDouble(event) {
      let buttonType = this.buttonType;
      let name = this.form.projectName;
      let id = this.editorForm.id;
      queryDuplicate({type: buttonType, projectName: name, id: id}).then(response => {
        this.duplicate = response.msg;
        if (response.msg == "true") {
          this.$message.error("项目名称已存在!")
        }
      })
    }
  },
}
</script>

<style lang="scss" scoped>
.InProgress {
  width: 100%;
  height: 100%;
  overflow: auto;

  .InProgress-box {
    width: 100%;
    height: 700px;
    //display: grid;
    //grid-template-columns: repeat(3, 1fr);
    //gap: 20px 20px;

  display: flex;
  flex-wrap: wrap;

    .item {
      width: calc(100% /3 - 20px);
      border: #ECECEE solid 1px;
      background: #fff;
      box-shadow: 0 1px 4px rgba(0, 21, 41, .08);
      border-radius: 10px;
      margin:0 10px 10px 10px;
      display: flex;
      height: 300px;

    }
    .box-pro {
      flex-flow: column;
      .pro-box {
        padding: 20px;
        height: 85%;
overflow: auto;
        .box-pro-right {
          width: 100%;
          //margin-left: 10px;
          overflow: auto;

          .pro-tit {
            font-size: 18px;
            font-weight: bold;
          }

          .pro-text {
            font-size: 14px;
            color: #333;
            margin-top: 20px;
          }
        }
      }

      .pro-btn {
        flex: 1;
        width: 100%;
        display: flex;
        align-items: center;
        cursor: pointer;
        justify-content: space-between;
        border-radius: 0 0 10px 10px;
        background: #F8F9FD;
        border-top: #efefef solid 1px;

        div {
          color: #A2A1A2;
          width: 33.3%;
          font-size: 14px;
          text-align: center;
        }

        div:nth-child(2) {
          border-left: #efefef solid 1px;
          border-right: #efefef solid 1px;
        }
      }
    }
    .item:last-of-type{
      justify-content: center;
      align-items: center;
      color: #BBBBBD;
      font-size: 37px;
      cursor: pointer;
      border: #BBBBBD dashed 1px;
    }

  }

  .basicmsg {
    font-weight: 600;
    border-bottom: 1px solid rgba(173, 171, 171, 0.52);
    margin-bottom: 10px;
  }

  .shuttle {
    height: 350px;
    display: flex;
    align-items: center;
    justify-items: center;

    .all {
      height: 100%;
      width: 45%;

      ::v-deep {
        .table {
          height: calc(100% - 25px);
        }
      }
    }

    .btn {
      display: flex;
      align-items: center;
      flex-flow: column;
      flex: 1;
      margin: 0 auto;

      .el-button {
        margin-left: 0;
        margin-bottom: 10px;
      }
    }

    .conduct {
      height: 100%;
      width: 45%;

      ::v-deep {
        .table {
          height: calc(100% - 25px);
        }
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

    .el-dialog__body {
      //padding: 10px;
      overflow: auto;
    }

    .el-dialog__header {
      background: rgba(204, 204, 204, 0.18);
      padding: 10px;
    }

    .el-dialog__title {
      font-weight: 500;
      font-size: 15px
    }

    .el-dialog__headerbtn {
      top: 13px;
    }

    .el-dialog__footer {
      background: rgba(204, 204, 204, 0.18);
      padding-right: 15px;
      padding: 8px;
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
</style>
