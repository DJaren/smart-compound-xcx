import request from '@/utils/request'

// 查询会议室预约列表
export function listOrder(query) {
  return request({
    url: '/system/order/list',
    method: 'get',
    params: query
  })
}

// 查询会议室预约详细
export function getOrder(confOrderId) {
  return request({
    url: '/system/order/' + confOrderId,
    method: 'get'
  })
}

// 新增会议室预约
export function addOrder(data) {
  return request({
    url: '/system/order',
    method: 'post',
    data: data
  })
}

// 修改会议室预约
export function updateOrder(data) {
  return request({
    url: '/system/order',
    method: 'put',
    data: data
  })
}

// 删除会议室预约
export function delOrder(confOrderId) {
  return request({
    url: '/system/order/' + confOrderId,
    method: 'delete'
  })
}

// 导出会议室预约
export function exportOrder(query) {
  return request({
    url: '/system/order/export',
    method: 'get',
    params: query
  })
}