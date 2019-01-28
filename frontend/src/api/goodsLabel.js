import fetch from '../config/fetch'


/**
 * 获取商品Label
 */

export const getAllGoodsLabels = data => fetch('/goodsLabel/getAll');