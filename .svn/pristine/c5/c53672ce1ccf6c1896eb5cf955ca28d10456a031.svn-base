import request from "@/utils/request";

//业务管理-工序环节管理
//查询列表
export function queryGxhjList(params) {
  return request({
    url: '/ywgl/hjgl/queryGxhjList',
    method: 'get',
    params: params
  })
}

// 新增
export function addGxhjOne(data) {
  return request({
    url: '/ywgl/hjgl/addGxhjOne',
    method: 'post',
    data: data
  })
}

//修改
export function updateGxhjOne(data) {
  return request({
    url: '/ywgl/hjgl/updateGxhjOne',
    method: 'post',
    data: data
  })
}

//删除
export function deleteGxhjId(id) {
  return request({
    url: `/ywgl/hjgl/deleteGxhjId/${id}`,
    method: 'delete'
  })
}

//查询工序序号是否存在
export function  selectGxxhCount(params){
  return request({
    url: '/ywgl/hjgl/selectGxxh',
    method: 'get',
    params: params
  })
}
