import request from "@/utils/request";

//抽检
//抽检查询案卷信息列表
export function queryRandomCase(params) {
  return request({
    url: '/spot/check/queryRandomCase',
    method: 'get',
    params: params
  })
}

//查询案件
export function queryCaseInspection(params) {
  return request({
    url: '/spot/check/queryCaseInspection',
    method: 'get',
    params: params
  })
}

//完成抽检
export function completeSpotCheck(params) {
  return request({
    url: '/spot/check/completeSpotCheck',
    method: 'get',
    params: params
  })
}

//一键完成
export function completeClickList(params) {
  return request({
    url: '/spot/check/completeClickList',
    method: 'get',
    params: params
  })
}

//抽检页面查询抽检人
export function querySamplingPeople() {
  return request({
    url: '/spot/check/querySamplingPeople/',
    method: 'get'
  })
}
