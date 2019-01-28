package com.weshare.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Table(name = "user_address")
public class UserAddress {
    private Long id;
    private Long userId;
    private String country;
    private String province;
    private String city;
    private String county;
    private String township;
    private String street;
    private String zipCode;
    private String detailAddress;
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
    @Column(name = "user_id", nullable = false)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "country", nullable = true, length = 10)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "province", nullable = true, length = 10)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 10)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "county", nullable = true, length = 10)
    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Basic
    @Column(name = "township", nullable = true, length = 20)
    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    @Basic
    @Column(name = "street", nullable = true, length = 20)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "zip_code", nullable = true, length = 6)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "detail_address", nullable = true, length = 50)
    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
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
        UserAddress that = (UserAddress) o;
        return id == that.id &&
                userId == that.userId &&
                Objects.equals(country, that.country) &&
                Objects.equals(province, that.province) &&
                Objects.equals(city, that.city) &&
                Objects.equals(county, that.county) &&
                Objects.equals(township, that.township) &&
                Objects.equals(street, that.street) &&
                Objects.equals(zipCode, that.zipCode) &&
                Objects.equals(detailAddress, that.detailAddress) &&
                Objects.equals(addTime, that.addTime) &&
                Objects.equals(deleted, that.deleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, country, province, city, county, township, street, zipCode, detailAddress, addTime, deleted);
    }
}
