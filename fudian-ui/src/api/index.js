import request from '@/utils/request'

// 获取累计访问
export const getTotal = () => {
  return request({
    url: '/home/page/queryCumulativeAccess',
    method: 'get'
  })
}

// 获取处理任务(已处理和未处理)
export const getAssignment = () => {
  return request({
    url: '/home/page/queryProcessingTask',
    method: 'get'
  })
}

