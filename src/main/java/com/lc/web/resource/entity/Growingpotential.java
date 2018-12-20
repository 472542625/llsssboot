package com.lc.web.resource.entity;

public class Growingpotential {
    private Integer gpid;

    private String growingpotential;

    public Integer getGpid() {
        return gpid;
    }

    public void setGpid(Integer gpid) {
        this.gpid = gpid;
    }

    public String getGrowingpotential() {
        return growingpotential;
    }

    public void setGrowingpotential(String growingpotential) {
        this.growingpotential = growingpotential == null ? null : growingpotential.trim();
    }
}