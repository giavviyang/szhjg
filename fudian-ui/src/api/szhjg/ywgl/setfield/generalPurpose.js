import request from "@/utils/request";

//业务管理-元数据和字段管理通用方法
//查询元数据字段类型
export function queryMetadataType() {
  return request({
    url: '/ywgl/metamapper/queryMetadataType',
    method: 'get',
  })
}
