package com.weshare.manage.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    private Long id;
    private Long userId;
    private Long goodsId;
    private Long skuId;
    private int purchaseQuantity;
    private Timestamp addTime;
    private String status;
    private Boolean remove;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "goods_id", nullable = false)
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "sku_id", nullable = false)
    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    @Basic
    @Column(name = "purchase_quantity", nullable = false)
    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    @Basic
    @Column(name = "add_time", nullable = true)
    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 10)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "remove", nullable = true)
    public Boolean getRemove() {
        return remove;
    }

    public void setRemove(Boolean remove) {
        this.remove = remove;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return id == that.id &&
                userId == that.userId &&
                goodsId == that.goodsId &&
                skuId == that.skuId &&
                purchaseQuantity == that.purchaseQuantity &&
                Objects.equals(addTime, that.addTime) &&
                Objects.equals(status, that.status) &&
                Objects.equals(remove, that.remove);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, goodsId, skuId, purchaseQuantity, addTime, status, remove);
    }
}
