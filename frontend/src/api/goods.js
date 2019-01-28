import fetch from '../config/fetch'

/**
 * 获取商品列表
 * @param {Object} data 
 */
export const getGoodsList = data => fetch('/goods/all');

/**
 * 获取商品列表
 * @param {Object} data 
 */
export const getGoodsById = data => fetch('/goods/id/'+data);

/**
 * 添加商品
 * @param {Object} data 
 */
export const addGoodsBasic = data => fetch('/goods/goodsBasic', data, 'POST');

/**
 * 编辑商品
 * @param {Object} data 
 */
export const editGoodsBasic = data => fetch('/goods/goodsBasic', data, 'PUT');


/**
 * 删除商品
 * @param {Object} data 
 */
export const deleteGoods = data => fetch('/goods/id', data, 'DELETE');


/**
 * 上传图片
 * @param {Object} data 
 */
export const uploadImage = data => fetch('/goods/imgUpload', data, 'POST');


