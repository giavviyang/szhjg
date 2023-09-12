import request from "@/utils/request";

//数据加工 -- 图像处理
//查询任务列表(案卷)
export function queryTxclTaskList(params) {
  return request({
    url: '/sjjg/txcl/queryTxclTaskList',
    method: 'get',
    params: params
  })
}






//查询文件图片(图像)列表
export function queryFileImageList(params){
  return request({
    url: '/sjjg/txcl/queryFileImageList',
    method: 'get',
    params: params
  })
}

//图片(图像)上下移动
export function  pictureMoveUpAndDown(data){
  return request({
    url: '/sjjg/txcl/pictureMoveUpAndDown',
    method: 'post',
    data: data
  })
}

//查询上(下)一件图片(图像)列表
export function queryNextPiece(params){
  return request({
    url: '/sjjg/txcl/queryNextPiece',
    method: 'get',
    params: params
  })
}

//图片(图像)替换/保存
export function  imageReplacement(data){
  return request({
    url: '/sjjg/txcl/imageReplacement',
    method: 'post',
    data: data
  })
}





//图片上传
export function  uploadEditImg(data){
  return request({
    url: '/sjjg/txcl/viewPictureImage',
    method: 'post',
    data: data
  })
}
