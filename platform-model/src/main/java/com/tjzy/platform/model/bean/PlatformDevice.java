package com.tjzy.platform.model.bean;

import java.io.Serializable;
import java.util.Date;

public class PlatformDevice extends PlatformDeviceKey implements Serializable {
    private String hostname;

    private String ip;

    private String loginPassword;

    private String localIp;

    private String sys;

    private String disksize;

    private String enabled;

    private String hdcapacityCpu;

    private String region;

    private Date startTime;

    private Date endTime;

    private static final long serialVersionUID = 1L;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname == null ? null : hostname.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword == null ? null : loginPassword.trim();
    }

    public String getLocalIp() {
        return localIp;
    }

    public void setLocalIp(String localIp) {
        this.localIp = localIp == null ? null : localIp.trim();
    }

    public String getSys() {
        return sys;
    }

    public void setSys(String sys) {
        this.sys = sys == null ? null : sys.trim();
    }

    public String getDisksize() {
        return disksize;
    }

    public void setDisksize(String disksize) {
        this.disksize = disksize == null ? null : disksize.trim();
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled == null ? null : enabled.trim();
    }

    public String getHdcapacityCpu() {
        return hdcapacityCpu;
    }

    public void setHdcapacityCpu(String hdcapacityCpu) {
        this.hdcapacityCpu = hdcapacityCpu == null ? null : hdcapacityCpu.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}