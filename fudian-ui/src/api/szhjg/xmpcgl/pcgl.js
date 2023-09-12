import request from "@/utils/request";

//项目批次管理 --批次管理
//查询进行中项目名称
export function queryProjectName() {
  return request({
    url: '/pcgl/queryProjectName',
    method: 'get',
  })
}


//查询批次列表
export function queryBatchList(params) {
  return request({
    url: '/pcgl/queryBatchList',
    method: 'get',
    params: params
  })
}

//新增
export function insertOneBatch(data) {
  return request({
    url: '/pcgl/insertOneBatch',
    method: 'post',
    data: data
  })
}

//修改
export function updateOneBatch(data) {
  return request({
    url: '/pcgl/updateOneBatch',
    method: 'post',
    data: data
  })
}

//删除
export function deleteOneBatch(id) {
  return request({
    url: `/pcgl/deleteOneBatch/${id}`,
    method: 'delete'
  })
}

//完成批次
export function completeBatch(params) {
  return request({
    url: '/pcgl/completeBatch',
    method: 'get',
    params: params
  })
}


//查询任务列表
export function queryBatchTaskList(params) {
  return request({
    url: '/pcgl/queryBatchTaskList',
    method: 'get',
    params: params
  })
}

