import request from "@/utils/request";

//获取动态(展示/录入)字段

//项目管理--完成项目查询案卷动态展示字段
export function completeDynamicsList(params) {
  return request({
    url: '/ywgl/dynamic/completeDynamicsList',
    method: 'get',
    params: params
  })
}
//项目管理--完成项目查询文件(案件)动态字段
export function completeDescriptionList(params) {
  return request({
    url: '/ywgl/dynamic/completeDescriptionList',
    method: 'get',
    params: params
  })
}


//获取批次管理动态字段
export function headDisplayList(params) {
  return request({
    url: '/ywgl/dynamic/headDisplayList',
    method: 'get',
    params: params
  })
}


//任务管理--获取动态字段(通用)
export function taskDynamicListHead(params) {
  return request({
    url: '/ywgl/dynamic/taskDynamicListHead',
    method: 'get',
    params: params
  })
}
//任务管理--批量添加(新增)动态字段
export function getsDynamicMultiple(params) {
  return request({
    url: '/ywgl/dynamic/getsDynamicMultiple',
    method: 'get',
    params: params
  })
}


//目录著录-根据批次Id查询动态著录字段(专用)
export function catalogueDescriptionList(params) {
  return request({
    url: '/ywgl/dynamic/catalogueDescriptionList',
    method: 'get',
    params: params
  })
}


//抽检页面动态展示字段
export function spotCheckDynamicList(params) {
  return request({
    url: '/ywgl/dynamic/spotCheckDynamicList',
    method: 'get',
    params: params
  })
}

