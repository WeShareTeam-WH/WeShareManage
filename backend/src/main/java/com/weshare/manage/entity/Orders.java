package com.weshare.manage.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Orders {
    private Long id;
    private Long userId;
    private Long addressId;
    private BigDecimal totalCount;
    private BigDecimal actuallyPaid;
    private String status;
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
    @Column(name = "address_id", nullable = false)
    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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
    @Column(name = "actually_paid", nullable = false, precision = 2)
    public BigDecimal getActuallyPaid() {
        return actuallyPaid;
    }

    public void setActuallyPaid(BigDecimal actuallyPaid) {
        this.actuallyPaid = actuallyPaid;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 10)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        Orders orders = (Orders) o;
        return id == orders.id &&
                userId == orders.userId &&
                addressId == orders.addressId &&
                Objects.equals(totalCount, orders.totalCount) &&
                Objects.equals(actuallyPaid, orders.actuallyPaid) &&
                Objects.equals(status, orders.status) &&
                Objects.equals(addTime, orders.addTime) &&
                Objects.equals(deleted, orders.deleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, addressId, totalCount, actuallyPaid, status, addTime, deleted);
    }
}
