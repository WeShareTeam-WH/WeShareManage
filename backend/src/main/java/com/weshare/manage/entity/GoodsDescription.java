package com.weshare.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "goods_description")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class GoodsDescription {
    private Long id;
    private String description;
    private String imageUrl;
    private int imageOrder;
    private String imageDescription;
    private Timestamp addTime;
    private Boolean deleted;
    private Goods goodsByGoodsId;
    private ImageType imageTypeByImageTypeId;
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
    @Column(name = "description", nullable = true, length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Basic
    @Column(name = "image_url", nullable = true, length = 200)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Basic
    @Column(name = "image_order", nullable = false)
    public int getImageOrder() {
        return imageOrder;
    }

    public void setImageOrder(int imageOrder) {
        this.imageOrder = imageOrder;
    }

    @Basic
    @Column(name = "image_description", nullable = true, length = 300)
    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
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
        GoodsDescription that = (GoodsDescription) o;
        return id == that.id &&
                imageOrder == that.imageOrder &&
                Objects.equals(description, that.description) &&
                Objects.equals(imageUrl, that.imageUrl) &&
                Objects.equals(imageDescription, that.imageDescription) &&
                Objects.equals(addTime, that.addTime) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, description, imageUrl, imageOrder, imageDescription, addTime, deleted);
    }

    @ManyToOne
    @JoinColumn(name = "goods_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    public Goods getGoodsByGoodsId() {
        return goodsByGoodsId;
    }

    public void setGoodsByGoodsId(Goods goodsByGoodsId) {
        this.goodsByGoodsId = goodsByGoodsId;
    }

    @ManyToOne
    @JoinColumn(name = "image_type_id", referencedColumnName = "id", nullable = false)
    public ImageType getImageTypeByImageTypeId() {
        return imageTypeByImageTypeId;
    }

    public void setImageTypeByImageTypeId(ImageType imageTypeByImageTypeId) {
        this.imageTypeByImageTypeId = imageTypeByImageTypeId;
    }

    @Transient
    public String getBase64Image() {
        return base64Image;
    }

    public void setBase64Image(String base64Image) {
        this.base64Image = base64Image;
    }
}
