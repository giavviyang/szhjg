import request from '@/utils/request'

// 获取项目列表
export const getProject = (params) => {
  return request({
    url: '/xmgl/queryProjectList',
    method: 'GET',
    params,
  })
}

// 新增项目
export const addAProject = (data) => {
  return request({
    url: '/xmgl/addProject',
    method: 'POST',
    data,
  })
}

// 获取全部工序
export const allAstep = (params) => {
  return request({
    url: '/xmgl/queryTGxhjglList',
    method: 'GET',
    params,
  })
}

// 编辑项目
export const EditItem = (data) => {
  return request({
    url: '/xmgl/updateProject',
    method: 'POST',
    data,
  })
}

// 查询项目的工序
export const ProjectGxhjList = (params) => {
  return request({
    url: '/xmgl/queryProjectGxhjList',
    method: 'GET',
    params,
  })
}

// 删除项目
export function deleteProject(id) {
  return request({
    url: `/xmgl/deleteProject/${id}`,
    method: 'delete'
  })
}

//重名查询
export function  queryDuplicate(params){
  return request({
    url: '/xmgl/queryDuplicate',
    method: 'get',
    params: params
  })
}

//完成项目
export function completeProject(params) {
  return request({
    url: '/xmgl/completeProject',
    method: 'get',
    params: params
  })
}


