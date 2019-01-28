package com.weshare.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "goods_collection")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@IdClass(GoodsCollectionPK.class)
public class GoodsCollection {
    private Long userId;
    private Long goodsId;
    private Timestamp collectionTime;
    private Boolean cancel;

    @Id
    @Column(name = "user_id", nullable = false)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "goods_id", nullable = false)
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "collection_time", nullable = true)
    public Timestamp getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Timestamp collectionTime) {
        this.collectionTime = collectionTime;
    }

    @Basic
    @Column(name = "cancel", nullable = true)
    public Boolean getCancel() {
        return cancel;
    }

    public void setCancel(Boolean cancel) {
        this.cancel = cancel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsCollection that = (GoodsCollection) o;
        return userId == that.userId &&
                goodsId == that.goodsId &&
                Objects.equals(collectionTime, that.collectionTime) &&
                Objects.equals(cancel, that.cancel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, goodsId, collectionTime, cancel);
    }
}
