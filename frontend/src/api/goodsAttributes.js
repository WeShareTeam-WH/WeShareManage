import fetch from '../config/fetch'

/**
 * 获取商品SKU attributes
 */
export const getSKUAttributes = data => fetch('/goodsAttributes/getAll');