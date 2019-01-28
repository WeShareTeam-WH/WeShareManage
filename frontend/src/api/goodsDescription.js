import fetch from '../config/fetch'

/**
 * 添加商品
 * @param {Object} data 
 */
export const addGoodsDescription = data => fetch('/goods/goodsDescription', data, 'POST');