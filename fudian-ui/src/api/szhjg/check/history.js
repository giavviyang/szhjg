import request from "@/utils/request";

//抽检历史列表
export function historyList(params) {
  return request({
    url: '/spot/check/queryRandomHistory',
    method: 'get',
    params: params
  })
}

//抽检回退
export function getFallBack(params) {
  return request({
    url: '/spot/check/spotCheckRollback',
    method: 'get',
    params: params
  })
}

//抽检历史记录中查询抽检时间
export function querySamplingTime() {
  return request({
    url: '/spot/check/querySamplingTime/',
    method: 'get'
  })
}
