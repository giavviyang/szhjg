import request from "@/utils/request";

//业务管理-档案类型管理
//查询列表
export function queryDalxglList(params) {
  return request({
    url: '/ywgl/dalxgl/queryDalxglList',
    method: 'get',
    params: params
  })
}

// 新增
export function addDalxglOne(data) {
  return request({
    url: '/ywgl/dalxgl/addDalxglOne',
    method: 'post',
    data: data
  })
}

//修改
export function updateDalxglOne(data) {
  return request({
    url: '/ywgl/dalxgl/updateDalxglOne',
    method: 'post',
    data: data
  })
}

//删除
export function deleteDalxglId(id) {
  return request({
    url: `/ywgl/dalxgl/deleteDalxglId/${id}`,
    method: 'delete'
  })
}
