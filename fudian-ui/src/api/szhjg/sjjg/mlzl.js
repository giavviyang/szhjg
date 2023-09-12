import request from "@/utils/request";

//数据加工 -- 目录著录
//查询案卷
export function queryDirectory(params) {
  return request({
    url: '/sjjg/mlzl/queryDirectory',
    method: 'get',
    params: params
  })
}

//文件查询图片列表方法
export function queryCasePiece(params) {
  return request({
    url: '/sjjg/mlzl/queryCasePiece',
    method: 'get',
    params: params
  })
}

//查询案件
export function queryPicturePiece(params) {
  return request({
    url: '/sjjg/mlzl/queryPicturePiece',
    method: 'get',
    params: params
  })
}


//案卷著录
export function insertCaseFile(data) {
  return request({
    url: '/sjjg/mlzl/insertCaseFile',
    method: 'post',
    data: data
  })
}
//案件著录
export function insertCasePiece(data) {
  return request({
    url: '/sjjg/mlzl/insertCasePiece',
    method: 'post',
    data: data
  })
}

//查询人事档案分类
export function queryDictType() {
  return request({
    url: '/sjjg/mlzl/queryDictType',
    method: 'get',
  })
}
//著录--案件著录查询人事档案分类类号
export function casePersonnelClass(params){
  return request({
    url: '/sjjg/mlzl/casePersonnelClass',
    method: 'get',
    params: params
  })
}
