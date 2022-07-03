package com.easybuy.entity;

import java.util.Date;

public class TOrders {
    private Integer id;

    private Integer custmerId;

    private Date createTime;

    private String targetAddr;

    private Float totalCount;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustmerId() {
        return custmerId;
    }

    public void setCustmerId(Integer custmerId) {
        this.custmerId = custmerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTargetAddr() {
        return targetAddr;
    }

    public void setTargetAddr(String targetAddr) {
        this.targetAddr = targetAddr == null ? null : targetAddr.trim();
    }

    public Float getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Float totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}