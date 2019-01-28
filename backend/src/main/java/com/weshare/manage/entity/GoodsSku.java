package com.weshare.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Table(name = "goods_sku")
public class GoodsSku {
    private Long id;
    private BigDecimal unitPrice;
    private Long avaliableNum;
    private String url;
    private Timestamp collectionTime;
    private Boolean cancel;
    private Goods goodsByGoodsId;
    private List<AttributesSkuMapping> attributeSkuMappings;
    private String base64Image;

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
    @Column(name = "unit_price", nullable = false, precision = 2)
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "avaliable_num", nullable = false)
    public Long getAvaliableNum() {
        return avaliableNum;
    }

    public void setAvaliableNum(Long avaliableNum) {
        this.avaliableNum = avaliableNum;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 255)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        GoodsSku goodsSku = (GoodsSku) o;
        return id == goodsSku.id &&
                Objects.equals(unitPrice, goodsSku.unitPrice) &&
                Objects.equals(url, goodsSku.url) &&
                Objects.equals(collectionTime, goodsSku.collectionTime) &&
                Objects.equals(cancel, goodsSku.cancel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, unitPrice, url, collectionTime, cancel);
    }

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "goods_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    public Goods getGoodsByGoodsId() {
        return goodsByGoodsId;
    }

    public void setGoodsByGoodsId(Goods goodsByGoodsId) {
        this.goodsByGoodsId = goodsByGoodsId;
    }

    @OneToMany(mappedBy = "goodsSku", cascade = CascadeType.DETACH)
    public List<AttributesSkuMapping> getAttributeSkuMappings() {
        return attributeSkuMappings;
    }
    public void setAttributeSkuMappings(List<AttributesSkuMapping> attributeSkuMappings) {
        this.attributeSkuMappings = attributeSkuMappings;
    }

    @Transient
    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}
