package com.tjzy.platform.model.bean;

import java.io.Serializable;

public class PlatformDeviceKey implements Serializable {
    private String did;

    private String userId;

    private static final long serialVersionUID = 1L;

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did == null ? null : did.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}