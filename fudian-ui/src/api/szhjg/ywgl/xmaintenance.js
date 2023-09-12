import request from "@/utils/request";

//业务管理-元数据字段下拉框管理
//查询数据列表
export function queryDropDownList(params) {
  return request({
    url: '/ywgl/metamapper/queryDropDownList',
    method: 'get',
    params: params
  })
}

//查询元数据字段
export function queryChooseFields1() {
  return request({
    url: '/ywgl/metamapper/queryChooseFields1',
    method: 'get',
  })
}

//查询指定元数据字段
export function queryChooseFields2() {
  return request({
    url: '/ywgl/metamapper/queryChooseFields2',
    method: 'get',
  })
}

//保存添加下拉框数据
export function addChooseFields(data) {
  return request({
    url: '/ywgl/metamapper/addChooseFields',
    method: 'post',
    data: data
  })
}

//查询下拉框数据
export function queryFromDropList(params) {
  return request({
    url: '/ywgl/metamapper/queryFromDropList',
    method: 'get',
    params: params
  })
}

// 删除
export function deleteChooseFields(ids) {
  return request({
    url: '/ywgl/metamapper/deleteChooseFields/' + ids,
    method: 'post'
  })
}
