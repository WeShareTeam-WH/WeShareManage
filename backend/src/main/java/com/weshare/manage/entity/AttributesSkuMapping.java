package com.weshare.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "attributes_sku_mapping")
public class AttributesSkuMapping {
    private Long id;
    private GoodsSku goodsSku;
    private GoodsAttributes goodsAttributes;
    private Timestamp addTime;
    private String value;
    private Boolean deleted;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Basic
    @Column(name = "value", nullable = true)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @ManyToOne
    @JoinColumn(name = "sku_id", unique = true)
    @JsonIgnore
    public GoodsSku getGoodsSku() {
        return goodsSku;
    }

    public void setGoodsSku(GoodsSku goodsSku) {
        this.goodsSku = goodsSku;
    }

    @ManyToOne
    @JoinColumn(name = "attribute_id", unique = true)
    public GoodsAttributes getGoodsAttributes() {
        return goodsAttributes;
    }

    public void setGoodsAttributes(GoodsAttributes goodsAttributes) {
        this.goodsAttributes = goodsAttributes;
    }
}
