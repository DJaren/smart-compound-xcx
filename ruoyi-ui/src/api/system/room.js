import request from '@/utils/request'

// 查询房间管理列表
export function listRoom(query) {
  return request({
    url: '/system/room/list',
    method: 'get',
    params: query
  })
}

export function listFloor(query) {
  return request({
    url: '/system/floor/',
    method: 'get',
    params: query
  })
}


// 查询楼栋信息列表
export function listBuild(query) {
  return request({
    url: '/system/building',
    method: 'get',
    params: query
  })
}
// 查询房间管理详细
export function getRoom(id) {
  return request({
    url: '/system/room/' + id,
    method: 'get'
  })
}

// 新增房间管理
export function addRoom(data) {
  return request({
    url: '/system/room',
    method: 'post',
    data: data
  })
}

// 修改房间管理
export function updateRoom(data) {
  return request({
    url: '/system/room',
    method: 'put',
    data: data
  })
}

// 删除房间管理
export function delRoom(id) {
  return request({
    url: '/system/room/' + id,
    method: 'delete'
  })
}

// 导出房间管理
export function exportRoom(query) {
  return request({
    url: '/system/room/export',
    method: 'get',
    params: query
  })
}
