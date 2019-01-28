package com.weshare.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Table(name = "goods_label")
public class GoodsLabel {
    private Long id;
    private Long goodsTypeId;
    private String label;
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
    @Column(name = "goods_type_id", nullable = false)
    public Long getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Long goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    @Basic
    @Column(name = "label", nullable = false, length = 20)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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
        GoodsLabel that = (GoodsLabel) o;
        return id == that.id &&
                goodsTypeId == that.goodsTypeId &&
                Objects.equals(label, that.label) &&
                Objects.equals(addTime, that.addTime) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, goodsTypeId, label, addTime, deleted);
    }

}
