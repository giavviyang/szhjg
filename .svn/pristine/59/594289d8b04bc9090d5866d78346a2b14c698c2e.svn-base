import request from "@/utils/request";

//统计查询
//1、个人工作统计
export function individualWorkload(params) {
  return request({
    url: '/dataStatisticalQuery/individualWorkload',
    method: 'get',
    params: params
  })
}



//3、批次产量统计
//3.1、批次产量查询完成项目选择框
export function batchYieldProject() {
  return request({
    url: '/dataStatisticalQuery/batchYieldProject',
    method: 'get',
  })
}
//3.2、批次产量统计
export function batchYieldStatistics(params) {
  return request({
    url: '/dataStatisticalQuery/batchYieldStatistics',
    method: 'get',
    params: params
  })
}



//4、加工进度统计
export function processProgressStatistics(params) {
  return request({
    url: '/dataStatisticalQuery/processProgressStatistics',
    method: 'get',
    params: params
  })
}

