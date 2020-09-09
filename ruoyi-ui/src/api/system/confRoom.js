import request from '@/utils/request'

// 查询会议室列表
export function listConfRoom(query) {
  return request({
    url: '/system/confRoom/list',
    method: 'get',
    params: query
  })
}

//
export function getBuilds(query) {
  return request({
    url: '/system/building/',
    method: 'get'
  })
}
// 查询会议室详细
export function getConfRoom(id) {
  return request({
    url: '/system/confRoom/' + id,
    method: 'get'
  })
}

// 新增会议室
export function addConfRoom(data) {
  return request({
    url: '/system/confRoom',
    method: 'post',
    data: data
  })
}

// 修改会议室
export function updateConfRoom(data) {
  return request({
    url: '/system/confRoom',
    method: 'put',
    data: data
  })
}

// 删除会议室
export function delConfRoom(id) {
  return request({
    url: '/system/confRoom/' + id,
    method: 'delete'
  })
}

// 导出会议室
export function exportConfRoom(query) {
  return request({
    url: '/system/confRoom/export',
    method: 'get',
    params: query
  })
}
