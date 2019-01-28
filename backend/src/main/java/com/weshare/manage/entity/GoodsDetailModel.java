package com.weshare.manage.entity;

import java.io.Serializable;
import java.util.List;

public class GoodsDetailModel implements Serializable{
    private static final long serialVersionUID = 8682409656439588549L;

    private  Goods goods;

    private List<GoodsLabel> goodsLabels;

    private List<GoodsSku> goodsSkus;

    private  List<GoodsDescription> goodsDescriptions;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<GoodsLabel> getGoodsLabels() {
        return goodsLabels;
    }

    public void setGoodsLabels(List<GoodsLabel> goodsLabels) {
        this.goodsLabels = goodsLabels;
    }

    public List<GoodsSku> getGoodsSkus() {
        return goodsSkus;
    }

    public void setGoodsSkus(List<GoodsSku> goodsSkus) {
        this.goodsSkus = goodsSkus;
    }

    public List<GoodsDescription> getGoodsDescriptions() {
        return goodsDescriptions;
    }

    public void setGoodsDescriptions(List<GoodsDescription> goodsDescriptions) {
        this.goodsDescriptions = goodsDescriptions;
    }
}
