import fetch from '../config/fetch'

/**
 * 添加商品SKU
 * @param {Object} data 
 */
export const addOrUpdateGoodsSku = data => fetch('/goodsSku/goodsSku', data, 'POST');