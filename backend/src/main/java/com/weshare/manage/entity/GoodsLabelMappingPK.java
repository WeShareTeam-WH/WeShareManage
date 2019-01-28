package com.weshare.manage.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GoodsLabelMappingPK implements Serializable {
    private Long goodsId;
    private Long goodsLabelId;

    @Column(name = "goods_id", nullable = false)
    @Id
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Column(name = "goods_label_id", nullable = false)
    @Id
    public Long getGoodsLabelId() {
        return goodsLabelId;
    }

    public void setGoodsLabelId(Long goodsLabelId) {
        this.goodsLabelId = goodsLabelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsLabelMappingPK that = (GoodsLabelMappingPK) o;
        return goodsId == that.goodsId &&
                goodsLabelId == that.goodsLabelId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(goodsId, goodsLabelId);
    }
}
