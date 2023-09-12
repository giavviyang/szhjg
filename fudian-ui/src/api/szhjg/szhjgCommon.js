import request from "@/utils/request";

//重名校验查询
export function chongMingCheck(params) {
  return request({
    url: '/szhjgCommonController/chongMingCheck',
    method: 'get',
    params: params
  })
}

//下拉框查询项目批次
export function queryProjectBatch(params) {
  return request({
    url: '/szhjgCommonController/queryProjectBatch',
    method: 'get',
    params: params
  })
}

//页面动态展示工序名称
export function queryDisplayGx() {
  return request({
    url: '/szhjgCommonController/queryDisplayGx/',
    method: 'get'
  })
}

//档案名称查询
export function queryArchivesName(dictType) {
  return request({
    url: '/szhjgCommonController/queryArchivesName',
    method: 'get',
  })
}


//案卷绑定当前操作人员
export function bindingRecipient(params) {
  return request({
    url: '/szhjgCommonController/bindingRecipient',
    method: 'get',
    params: params
  })
}



//查询案卷图像信息
export function  selectPictureImage(params){
  return request({
    url: '/szhjgCommonController/selectPictureImage',
    method: 'get',
    params: params
  })
}

//获取图片路径
export function  toPictureImage(params){
  return request({
    url: '/szhjgCommonController/ioReadImg2',
    method: 'get',
    params: params
  })
}



