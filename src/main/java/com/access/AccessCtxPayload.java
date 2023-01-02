package com.access;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AccessCtxPayload {

    private String tenantName;
    private String loginCtx;

    private String errorCtx;

    private Long id;


    // avoid this "No default constructor for entity"
    public AccessCtxPayload() {
    }

    public AccessCtxPayload(String loginCtx) {
        this.loginCtx = loginCtx;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getLoginCtx() {
        return loginCtx;
    }

    public void setLoginCtx(String loginCtx) {
        this.loginCtx = loginCtx;
    }

    public String getErrorCtx() {
        return errorCtx;
    }

    public void setErrorCtx(String errorCtx) {
        this.errorCtx = errorCtx;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AccessCtxPayload{" +
                "tenantName='" + tenantName + '\'' +
                ", loginCtx='" + loginCtx + '\'' +
                ", errorCtx='" + errorCtx + '\'' +
                ", id=" + id +
                '}';
    }
}