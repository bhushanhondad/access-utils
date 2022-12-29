package com.access;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginCtxPayload {

    private String tenantName;
    private String loginCtx;
    private Long id;


    // avoid this "No default constructor for entity"
    public LoginCtxPayload() {
    }

    public LoginCtxPayload(String loginCtx) {
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

    @Override
    public String toString() {
        return "LoginCtxPayload{" +
                "loginCtx='" + loginCtx + '\'' +
                ", id=" + id +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}