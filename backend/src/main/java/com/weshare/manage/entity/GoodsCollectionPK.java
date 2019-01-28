package com.weshare.manage.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GoodsCollectionPK implements Serializable {
    private Long userId;
    private Long goodsId;

    @Column(name = "user_id", nullable = false)
    @Id
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "goods_id", nullable = false)
    @Id
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsCollectionPK that = (GoodsCollectionPK) o;
        return userId == that.userId &&
                goodsId == that.goodsId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, goodsId);
    }
}
