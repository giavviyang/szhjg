import request from "@/utils/request";

//业务管理-字段管理
//查询左侧树信息
export function queryFilesTreeList(params) {
  return request({
    url: '/ywgl/metamapper/queryFilesTreeList',
    method: 'get',
    params: params
  })
}

//查询模板列表
export function queryTemplateList(params) {
  return request({
    url: '/ywgl/metamapper/queryTemplateList',
    method: 'get',
    params: params
  })
}



//查询字段列表
export function queryFieldsList(params) {
  return request({
    url: '/ywgl/metamapper/queryFieldsList',
    method: 'get',
    params: params
  })
}

//查询档案类型名称
export function queryFilesType() {
  return request({
    url: '/ywgl/metamapper/queryFilesType',
    method: 'get',
  })
}

//档案类型和级别重名查询和新增
export function queryFileAndLevelSame(params){
  return request({
    url: '/ywgl/metamapper/queryFileAndLevelSame',
    method: 'get',
    params: params
  })
}

//删除档案类型和级别
export function deleteFileAndLevelSame(id) {
  return request({
    url: `/ywgl/metamapper/deleteFileAndLevelSame/${id}`,
    method: 'delete'
  })
}

//查询实体类字段
export function queryEntityClass(params) {
  return request({
    url: '/ywgl/metamapper/queryEntityClass',
    method: 'get',
    params: params
  })
}

//查询元数据字段
export function queryMetadataFields() {
  return request({
    url: '/ywgl/metamapper/queryMetadataFields',
    method: 'get',
  })
}

// 新增
export function addMetadataFileLevel(data) {
  return request({
    url: '/ywgl/metamapper/addMetadataFileLevel',
    method: 'post',
    data: data
  })
}


//规则设置查询展示字段
export function querySortfieldList(params) {
  return request({
    url: '/ywgl/metamapper/querySortfieldList',
    method: 'get',
    params: params
  })
}

//规则设置查询指定字段
export function querySortAppoint(params) {
  return request({
    url: '/ywgl/metamapper/querySortAppoint',
    method: 'get',
    params: params
  })
}

//保存展示字段设置
export function saveOrDisplayField(params) {
  return request({
    url: '/ywgl/metamapper/saveOrDisplayField',
    method: 'post',
    data: params
  })
}

//保存录入字段设置
export function saveOrInputField(params) {
  return request({
    url: '/ywgl/metamapper/saveOrInputField',
    method: 'post',
    data: params
  })
}

//保存著录字段设置
export function descOrInputField(params) {
  return request({
    url: '/ywgl/metamapper/descOrInputField',
    method: 'post',
    data: params
  })
}

//规则设置字段无值设置
export function queryNoFixField(params) {
  return request({
    url: '/ywgl/metamapper/queryNoFixField',
    method: 'get',
    params: params
  })
}

//查询正则表达式列表
export function queryRegularExpressionList() {
  return request({
    url: '/ywgl/metamapper/queryRegularExpressionList',
    method: 'get',
  })
}

//查询编号字段是否存在
export function queryNumberOne(params){
  return request({
    url: '/ywgl/metamapper/queryNumberOne',
    method: 'get',
    params: params
  })
}

//查询编号组成字段
export function queryNumberFieldList(params) {
  return request({
    url: '/ywgl/metamapper/queryNumberFieldList',
    method: 'get',
    params: params
  })
}

//查询编号组成字段是否存在
export function queryExampleFieldExists(params) {
  return request({
    url: '/ywgl/metamapper/queryExampleFieldExists',
    method: 'get',
    params: params
  })
}

//编号新增
export function addNumberingField (data) {
  return request({
    url: '/ywgl/metamapper/addNumberingField',
    method: 'post',
    data: data
  })
}
