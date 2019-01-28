import fetch from '../config/fetch'

/**
 * 登陆
 * @param {Object} data 
 */
export const login = data => fetch('/user/login', data, 'POST');


export const getAdminInfo = () => fetch('/admin/info');

export const signout = () => fetch('/admin/logout', data);
