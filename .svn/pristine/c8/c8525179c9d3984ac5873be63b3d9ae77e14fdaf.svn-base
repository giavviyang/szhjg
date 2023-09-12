import request from "@/utils/request";

//加工工序通用方法
//领取任务-查询可以领取任务列表
export function queryRetrievesTaskList(params) {
  return request({
    url: '/szhjgApproach/queryRetrievesTaskList',
    method: 'get',
    params: params
  })
}
//领取任务-领取选择任务Id
export function selectFetchTaskIds(id) {
  return request({
    url: '/szhjgApproach/selectFetchTaskIds/' + id,
    method: 'post'
  })
}

//领取任务-领取选择任务Id(目录著录专用)
export function selectRecordTaskIds(id) {
  return request({
    url: '/szhjgApproach/selectRecordTaskIds/' + id,
    method: 'post'
  })
}



//通过-查询下一个工序名称
export function queryNextGxName(params){
  return request({
    url: '/szhjgApproach/queryNextGxName',
    method: 'get',
    params: params
  })
}

//通过-数据加工提交方法
export function  processingSubmitPass(params){
  return request({
    url: '/szhjgApproach/processingSubmitPass',
    method: 'post',
    params: params
  })
}

//通过-目录著录任务提交方法
export function  catalogueSubmitPass(params){
  return request({
    url: '/szhjgApproach/catalogueSubmitPass',
    method: 'post',
    params: params
  })
}


//返工-查询项目对应的工序
export function reworkQueryProject(params) {
  return request({
    url: '/szhjgApproach/reworkQueryProject',
    method: 'get',
    params: params
  })
}
//返工-提交返工方法
export function  reworkSubmitPass(data){
  return request({
    url: '/szhjgApproach/reworkSubmitPass',
    method: 'post',
    data: data
  })
}
//返工-目录著录任务返工方法
export function  catalogDescriptionRework(data){
  return request({
    url: '/szhjgApproach/catalogDescriptionRework',
    method: 'post',
    data: data
  })
}


//查看当前用户记录(查看记录)
export function viewCurrentUserRecord(params) {
  return request({
    url: '/szhjgApproach/viewCurrentUserRecord',
    method: 'get',
    params: params
  })
}

// 获取图片数量
export function  getPicNumber(params){
  return request({
    url: '/szhjgApproach/queryPictureTotal',
    method: 'get',
    params: params
  })
}
