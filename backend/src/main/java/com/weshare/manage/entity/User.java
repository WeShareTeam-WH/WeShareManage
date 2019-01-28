package com.weshare.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class User {
    private Long id;
    private String openId;
    private Long roleId;
    private Long agentAreaId;
    private String userName;
    private String password;
    private String passwordSalt;
    private String nickName;
    private String realName;
    private String tel;
    private String email;
    private Boolean emailTrue;
    private String phone;
    private Boolean phoneTrue;
    private String picUrl;
    private String headImgUrl;
    private Byte sex;
    private String country;
    private String province;
    private String city;
    private String district;
    private String address;
    private String note;
    private Integer type;
    private Timestamp thisLoginTime;
    private String thisLoginIp;
    private Timestamp lastLoginTime;
    private String lastLoginIp;
    private Timestamp lastWeixinSiginTime;
    private BigDecimal wallet;
    private Timestamp addTime;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "open_id", nullable = true, length = 100)
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Basic
    @Column(name = "role_id", nullable = false)
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "agent_area_id", nullable = false)
    public Long getAgentAreaId() {
        return agentAreaId;
    }

    public void setAgentAreaId(Long agentAreaId) {
        this.agentAreaId = agentAreaId;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "password_salt", nullable = false, length = 50)
    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    @Basic
    @Column(name = "nick_name", nullable = true, length = 50)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "real_name", nullable = true, length = 50)
    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 50)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "email_true", nullable = true)
    public Boolean getEmailTrue() {
        return emailTrue;
    }

    public void setEmailTrue(Boolean emailTrue) {
        this.emailTrue = emailTrue;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "phone_true", nullable = true)
    public Boolean getPhoneTrue() {
        return phoneTrue;
    }

    public void setPhoneTrue(Boolean phoneTrue) {
        this.phoneTrue = phoneTrue;
    }

    @Basic
    @Column(name = "pic_url", nullable = true, length = 200)
    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Basic
    @Column(name = "head_img_url", nullable = true, length = 200)
    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    @Basic
    @Column(name = "sex", nullable = true)
    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "country", nullable = true, length = 20)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "province", nullable = true, length = 20)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 20)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "district", nullable = true, length = 20)
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 250)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "note", nullable = true, length = -1)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "type", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "this_login_time", nullable = false)
    public Timestamp getThisLoginTime() {
        return thisLoginTime;
    }

    public void setThisLoginTime(Timestamp thisLoginTime) {
        this.thisLoginTime = thisLoginTime;
    }

    @Basic
    @Column(name = "this_login_ip", nullable = true, length = 50)
    public String getThisLoginIp() {
        return thisLoginIp;
    }

    public void setThisLoginIp(String thisLoginIp) {
        this.thisLoginIp = thisLoginIp;
    }

    @Basic
    @Column(name = "last_login_time", nullable = false)
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Basic
    @Column(name = "last_login_ip", nullable = true, length = 50)
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    @Basic
    @Column(name = "last_weixin_sigin_time", nullable = true)
    public Timestamp getLastWeixinSiginTime() {
        return lastWeixinSiginTime;
    }

    public void setLastWeixinSiginTime(Timestamp lastWeixinSiginTime) {
        this.lastWeixinSiginTime = lastWeixinSiginTime;
    }

    @Basic
    @Column(name = "wallet", nullable = true, precision = 2)
    public BigDecimal getWallet() {
        return wallet;
    }

    public void setWallet(BigDecimal wallet) {
        this.wallet = wallet;
    }

    @Basic
    @Column(name = "add_time", nullable = false)
    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                roleId == user.roleId &&
                agentAreaId == user.agentAreaId &&
                Objects.equals(openId, user.openId) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(passwordSalt, user.passwordSalt) &&
                Objects.equals(nickName, user.nickName) &&
                Objects.equals(realName, user.realName) &&
                Objects.equals(tel, user.tel) &&
                Objects.equals(email, user.email) &&
                Objects.equals(emailTrue, user.emailTrue) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(phoneTrue, user.phoneTrue) &&
                Objects.equals(picUrl, user.picUrl) &&
                Objects.equals(headImgUrl, user.headImgUrl) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(country, user.country) &&
                Objects.equals(province, user.province) &&
                Objects.equals(city, user.city) &&
                Objects.equals(district, user.district) &&
                Objects.equals(address, user.address) &&
                Objects.equals(note, user.note) &&
                Objects.equals(type, user.type) &&
                Objects.equals(thisLoginTime, user.thisLoginTime) &&
                Objects.equals(thisLoginIp, user.thisLoginIp) &&
                Objects.equals(lastLoginTime, user.lastLoginTime) &&
                Objects.equals(lastLoginIp, user.lastLoginIp) &&
                Objects.equals(lastWeixinSiginTime, user.lastWeixinSiginTime) &&
                Objects.equals(wallet, user.wallet) &&
                Objects.equals(addTime, user.addTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, openId, roleId, agentAreaId, userName, password, passwordSalt, nickName, realName, tel, email, emailTrue, phone, phoneTrue, picUrl, headImgUrl, sex, country, province, city, district, address, note, type, thisLoginTime, thisLoginIp, lastLoginTime, lastLoginIp, lastWeixinSiginTime, wallet, addTime);
    }
}
