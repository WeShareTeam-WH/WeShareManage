import fetch from '../config/fetch'

/**
 * 获取商品种类
 */

export const getAllGoodsType = data => fetch('/goodsType/getAll');