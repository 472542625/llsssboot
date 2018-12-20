package com.lc.test.test01.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Tree {
    private Integer gid;

    private BigDecimal oid;

    private String contractorid;

    private String id;

    private String area;

    private Date date;

    private String contractor;

    private String recorder;

    private String treespecies;

    private String visitage;

    private BigDecimal treeage;

    private BigDecimal treeheight;

    private BigDecimal grounddiameter;

    private BigDecimal treearea;

    private BigDecimal x;

    private BigDecimal y;

    private String village;

    private String town;

    private String urban;

    private String maintenance;

    private Object geom;

    private Integer gpId;

    private Integer treespeciesId;

    private String treeageVar;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public BigDecimal getOid() {
        return oid;
    }

    public void setOid(BigDecimal oid) {
        this.oid = oid;
    }

    public String getContractorid() {
        return contractorid;
    }

    public void setContractorid(String contractorid) {
        this.contractorid = contractorid == null ? null : contractorid.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor == null ? null : contractor.trim();
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder == null ? null : recorder.trim();
    }

    public String getTreespecies() {
        return treespecies;
    }

    public void setTreespecies(String treespecies) {
        this.treespecies = treespecies == null ? null : treespecies.trim();
    }

    public String getVisitage() {
        return visitage;
    }

    public void setVisitage(String visitage) {
        this.visitage = visitage == null ? null : visitage.trim();
    }

    public BigDecimal getTreeage() {
        return treeage;
    }

    public void setTreeage(BigDecimal treeage) {
        this.treeage = treeage;
    }

    public BigDecimal getTreeheight() {
        return treeheight;
    }

    public void setTreeheight(BigDecimal treeheight) {
        this.treeheight = treeheight;
    }

    public BigDecimal getGrounddiameter() {
        return grounddiameter;
    }

    public void setGrounddiameter(BigDecimal grounddiameter) {
        this.grounddiameter = grounddiameter;
    }

    public BigDecimal getTreearea() {
        return treearea;
    }

    public void setTreearea(BigDecimal treearea) {
        this.treearea = treearea;
    }

    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village == null ? null : village.trim();
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town == null ? null : town.trim();
    }

    public String getUrban() {
        return urban;
    }

    public void setUrban(String urban) {
        this.urban = urban == null ? null : urban.trim();
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance == null ? null : maintenance.trim();
    }

    public Object getGeom() {
        return geom;
    }

    public void setGeom(Object geom) {
        this.geom = geom;
    }

    public Integer getGpId() {
        return gpId;
    }

    public void setGpId(Integer gpId) {
        this.gpId = gpId;
    }

    public Integer getTreespeciesId() {
        return treespeciesId;
    }

    public void setTreespeciesId(Integer treespeciesId) {
        this.treespeciesId = treespeciesId;
    }

    public String getTreeageVar() {
        return treeageVar;
    }

    public void setTreeageVar(String treeageVar) {
        this.treeageVar = treeageVar == null ? null : treeageVar.trim();
    }
}