package com.weshare.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "goods_attributes")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class GoodsAttributes implements Serializable {
    private static final long serialVersionUID = -1208619459847219727L;

    private Long id;
    private Long goodsTypeId;
    private String attribute;
    private Timestamp addTime;
    private Boolean deleted;
    private List<AttributesSkuMapping> attributesSkuMappings;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "attribute", nullable = false, length = 20)
    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
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
        GoodsAttributes that = (GoodsAttributes) o;
        return id == that.id &&
                goodsTypeId == that.goodsTypeId &&
                Objects.equals(attribute, that.attribute) &&
                Objects.equals(addTime, that.addTime) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, goodsTypeId, attribute, addTime, deleted);
    }

    @OneToMany(mappedBy = "goodsAttributes", cascade = CascadeType.ALL)
    @JsonIgnore
    public List<AttributesSkuMapping> getAttributesSkuMappings() {
        return attributesSkuMappings;
    }

    public void setAttributesSkuMappings(List<AttributesSkuMapping> attributesSkuMappings) {
        this.attributesSkuMappings = attributesSkuMappings;
    }
}
