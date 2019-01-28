package com.weshare.manage.entity;

public class GoodsImage {
    private String imgBase64;
    private Goods goods;
    private GoodsDescription goodsDesc;
    private GoodsSku goodsSku;

    public String getImgBase64() {
        return imgBase64;
    }

    public void setImgBase64(String imgBase64) {
        this.imgBase64 = imgBase64;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public GoodsDescription getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(GoodsDescription goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public GoodsSku getGoodsSku() {
        return goodsSku;
    }

    public void setGoodsSku(GoodsSku goodsSku) {
        this.goodsSku = goodsSku;
    }

}
