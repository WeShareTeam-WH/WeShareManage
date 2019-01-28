package com.weshare.manage.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Table(name = "agent_area")
public class AgentArea {
    private Long id;
    private String areaName;
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
    @Column(name = "area_name", nullable = false, length = 20)
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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
        AgentArea agentArea = (AgentArea) o;
        return id == agentArea.id &&
                Objects.equals(areaName, agentArea.areaName) &&
                Objects.equals(addTime, agentArea.addTime) &&
                Objects.equals(deleted, agentArea.deleted);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, areaName, addTime, deleted);
    }

}
