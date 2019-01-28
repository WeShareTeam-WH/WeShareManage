package com.weshare.manage.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "goods_label_mapping")
@IdClass(GoodsLabelMappingPK.class)
public class GoodsLabelMapping {
    private Long goodsId;
    private Long goodsLabelId;
    private Timestamp addTime;
    private Boolean deleted;

    @Id
    @Column(name = "goods_id", nullable = false)
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Id
    @Column(name = "goods_label_id", nullable = false)
    public Long getGoodsLabelId() {
        return goodsLabelId;
    }

    public void setGoodsLabelId(Long goodsLabelId) {
        this.goodsLabelId = goodsLabelId;
    }

    @Basic
    @Column(name = "add_time", nullable = false)
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
        GoodsLabelMapping that = (GoodsLabelMapping) o;
        return goodsId == that.goodsId &&
                goodsLabelId == that.goodsLabelId &&
                Objects.equals(addTime, that.addTime) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(goodsId, goodsLabelId, addTime, deleted);
    }
}
