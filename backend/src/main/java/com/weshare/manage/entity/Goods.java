package com.weshare.manage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class Goods {
    private Long id;
    private Long goodsTypeId;
    private String goodsTitle;
    private String goodsDescripe;
    private String goodsMateriel;
    private String goodsAddress;
    private Timestamp addTime;
    private Boolean deleted;
    private String goodsImageUrl;
    private String base64Image;

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
    @Column(name = "goods_type_id", nullable = false)
    public Long getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Long goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    @Basic
    @Column(name = "goods_title", nullable = false, length = 50)
    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    @Basic
    @Column(name = "goods_descripe", nullable = false, length = 200)
    public String getGoodsDescripe() {
        return goodsDescripe;
    }

    public void setGoodsDescripe(String goodsDescripe) {
        this.goodsDescripe = goodsDescripe;
    }

    @Basic
    @Column(name = "goods_materiel", nullable = false, length = 20)
    public String getGoodsMateriel() {
        return goodsMateriel;
    }

    public void setGoodsMateriel(String goodsMateriel) {
        this.goodsMateriel = goodsMateriel;
    }

    @Basic
    @Column(name = "goods_address", nullable = true, length = 100)
    public String getGoodsAddress() {
        return goodsAddress;
    }

    public void setGoodsAddress(String goodsAddress) {
        this.goodsAddress = goodsAddress;
    }

    @Basic
    @Column(name = "add_time", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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

    @Transient
    public String getGoodsImageUrl() {
        return goodsImageUrl;
    }

    public void setGoodsImageUrl(String goodsImageUrl) {
        this.goodsImageUrl = goodsImageUrl;
    }

    @Transient
    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}
