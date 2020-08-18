import request from '@/utils/request'

// 查询楼栋信息列表
export function listBuilding(query) {
  return request({
    url: '/system/building/list',
    method: 'get',
    params: query
  })
}

// 查询楼栋信息详细
export function getBuilding(id) {
  return request({
    url: '/system/building/' + id,
    method: 'get'
  })
}

// 新增楼栋信息
export function addBuilding(data) {
  return request({
    url: '/system/building',
    method: 'post',
    data: data
  })
}

// 修改楼栋信息
export function updateBuilding(data) {
  return request({
    url: '/system/building',
    method: 'put',
    data: data
  })
}

// 删除楼栋信息
export function delBuilding(id) {
  return request({
    url: '/system/building/' + id,
    method: 'delete'
  })
}

// 导出楼栋信息
export function exportBuilding(query) {
  return request({
    url: '/system/building/export',
    method: 'get',
    params: query
  })
}