import request from "@/utils/request";

//业务管理-元数据管理
//查询列表
export function queryYuanList(params) {
  return request({
    url: '/ywgl/metamapper/queryYuanList',
    method: 'get',
    params: params
  })
}

//重名查询
export function queryDoubleName(params){
  return request({
    url: '/ywgl/metamapper/queryDoubleName',
    method: 'get',
    params: params
  })
}

// 新增
export function addYuanOne(data) {
  return request({
    url: '/ywgl/metamapper/addYuanOne',
    method: 'post',
    data: data
  })
}

//修改
export function updateYuanOne(data) {
  return request({
    url: '/ywgl/metamapper/updateYuanOne',
    method: 'post',
    data: data
  })
}

//删除
export function deleteYuanId(id) {
  return request({
    url: `/ywgl/metamapper/deleteYuanId/${id}`,
    method: 'delete'
  })
}
