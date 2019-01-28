package com.weshare.manage.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
    private Long id;
    private Long orderId;
    private Long skuId;
    private BigDecimal unitePrice;
    private int goodsNumber;
    private BigDecimal totalCount;
    private Timestamp addTime;
    private Boolean deleted;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_id", nullable = false)
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
    @Column(name = "unite_price", nullable = false, precision = 2)
    public BigDecimal getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(BigDecimal unitePrice) {
        this.unitePrice = unitePrice;
    }

    @Basic
    @Column(name = "goods_number", nullable = false)
    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    @Basic
    @Column(name = "total_count", nullable = false, precision = 2)
    public BigDecimal getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(BigDecimal totalCount) {
        this.totalCount = totalCount;
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
    @Column(name = "deleted", nullable = true)
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return id == that.id &&
                orderId == that.orderId &&
                skuId == that.skuId &&
                goodsNumber == that.goodsNumber &&
                Objects.equals(unitePrice, that.unitePrice) &&
                Objects.equals(totalCount, that.totalCount) &&
                Objects.equals(addTime, that.addTime) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, orderId, skuId, unitePrice, goodsNumber, totalCount, addTime, deleted);
    }
}
