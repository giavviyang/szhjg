import request from "@/utils/request";

//任务管理
//查询任务列表
export function queryTaskList(params) {
  return request({
    url: '/rwgl/queryTaskList',
    method: 'get',
    params: params
  })
}

//新增任务
export function insertOneTask(data) {
  return request({
    url: '/rwgl/insertOneTask',
    method: 'post',
    data: data
  })
}

//修改任务
export function updateOneTask(data) {
  return request({
    url: '/rwgl/updateOneTask',
    method: 'post',
    data: data
  })
}

//删除任务
export function deleteOneTask(id) {
  return request({
    url: `/rwgl/deleteOneTask/${id}`,
    method: 'delete'
  })
}

//释放当前用户
export function releaseRecipient(params) {
  return request({
    url: '/rwgl/releaseRecipient',
    method: 'get',
    params: params
  })
}


//查询编号组成字段信息
export function queryNumberedComposition(data){
  return request({
    url: '/rwgl/queryNumberedComposition',
    method: 'post',
    params: data
  })
}
//查询新增任务是否重名
export function  checkTaskCount(params){
  return request({
    url: '/rwgl/checkTaskCount',
    method: 'get',
    params: params
  })
}



//查询当前批次对应项目正在进行中的工序
export function queryWorking(params) {
  return request({
    url: '/rwgl/queryWorking',
    method: 'get',
    params: params
  })
}


//excel案卷(任务)导入
export function excelFileImport(fromData) {
  return request({
    url: '/rwgl/excelFileImport',
    method: 'post',
    data: fromData
  })
}

//excel案件(文件)导入
export function importDataPiece(fromData) {
  return request({
    url: '/rwgl/importDataPiece',
    method: 'post',
    data: fromData
  })
}


//批量添加任务
export function insertBatchAdd(data) {
  return request({
    url: '/rwgl/insertBatchAdd',
    method: 'post',
    data: data
  })
}


//查询案卷下文件条目详细信息
export function queryFileViewing(params) {
  return request({
    url: '/rwgl/queryFileViewing',
    method: 'get',
    params: params
  })
}



//获案卷图像信息
export function getPictureImage(params) {
  return request({
    url: '/szhjgCommonController/selectPictureImage',
    method: 'get',
    params: params
  })
}

