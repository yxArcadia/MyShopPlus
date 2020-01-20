import axios from '@/libs/api.request'

export const login = ({ username, password }) => {
  const data = {
    username,
    password
  }
  return axios.request({
    url: 'user/login',
    data,
    method: 'post'
  })
}

export const getUserInfo = (token) => {
  return axios.request({
    url: 'user/get_info',
    method: 'get'
  })
}
export const info = (name) => {
  return axios.request({
    url: 'profile/info/'+name,
    method: 'get'
  })
}
export const logout = (token) => {
  return axios.request({
    url: 'user/logout',
    params: {
      access_token:token
    },
    method: 'post'
  })
}

export const getUnreadCount = () => {
  return axios.request({
    url: 'message/count',
    method: 'get'
  })
}

export const getMessage = () => {
  return axios.request({
    url: 'message/init',
    method: 'get'
  })
}

export const getContentByMsgId = msg_id => {
  return axios.request({
    url: 'message/content',
    method: 'get',
    params: {
      msg_id
    }
  })
}

export const hasRead = msg_id => {
  return axios.request({
    url: 'message/has_read',
    method: 'post',
    data: {
      msg_id
    }
  })
}

export const removeReaded = msg_id => {
  return axios.request({
    url: 'message/remove_readed',
    method: 'post',
    data: {
      msg_id
    }
  })
}

export const restoreTrash = msg_id => {
  return axios.request({
    url: 'message/restore',
    method: 'post',
    data: {
      msg_id
    }
  })
}

/**
 * 更新个人信息
 * @param data
 */
export function update(data) {
  return axios.request({
    url: '/profile/update',
    method: 'post',
    data
  })
}

/**
 * 更新头像
 * @param data
 */
export function modifyIcon(data) {
  return axios.request({
    url: '/profile/modify/icon',
    method: 'post',
    data
  })
}
