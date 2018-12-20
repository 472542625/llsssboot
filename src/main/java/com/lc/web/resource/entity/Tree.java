package com.lc.web.resource.entity;

import java.util.Date;

public class Tree {
	private Integer gid;
	private String treespecies;

	public String getTreespecies() {
		return treespecies;
	}

	public void setTreespecies(String treespecies) {
		this.treespecies = treespecies;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getUrban() {
		return urban;
	}

	public void setUrban(String urban) {
		this.urban = urban;
	}

	public String getMaintenance() {
		return maintenance;
	}

	public void setMaintenance(String maintenance) {
		this.maintenance = maintenance;
	}

	private String id;
	private Double oid;

	private String area;

	private Date date;

	private String contractor;

	private String contractorid;

	private String recorder;




	private String visitage;

	private Double treeage;

	private Double treeheight;

	private Double grounddiameter;

	private Double treearea;

	private Integer gpId;
	private Growingpotential growingpotential;

	private Double x;

	private Double y;

	private String geom;

	private Integer treespeciesId;

	private Treespecies treespeciesvar;

	private Integer treeageId;

	private String treeageVar;

	private String village;

	private String town;
	private String urban;
	private String maintenance;

	@Override
	public String toString() {
		return "Tree{" +
				"gid=" + gid +
				", treespecies='" + treespecies + '\'' +
				", id='" + id + '\'' +
				", oid=" + oid +
				", area='" + area + '\'' +
				", date=" + date +
				", contractor='" + contractor + '\'' +
				", contractorid='" + contractorid + '\'' +
				", recorder='" + recorder + '\'' +
				", visitage='" + visitage + '\'' +
				", treeage=" + treeage +
				", treeheight=" + treeheight +
				", grounddiameter=" + grounddiameter +
				", treearea=" + treearea +
				", gpId=" + gpId +
				", growingpotential=" + growingpotential +
				", x=" + x +
				", y=" + y +
				", geom='" + geom + '\'' +
				", treespeciesId=" + treespeciesId +
				", treespeciesvar=" + treespeciesvar +
				", treeageId=" + treeageId +
				", treeageVar='" + treeageVar + '\'' +
				", village='" + village + '\'' +
				", town='" + town + '\'' +
				", urban='" + urban + '\'' +
				", maintenance='" + maintenance + '\'' +
				'}';
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Double getOid() {
		return oid;
	}

	public void setOid(Double oid) {
		this.oid = oid;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
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
		this.contractor = contractor;
	}

	public String getContractorid() {
		return contractorid;
	}

	public void setContractorid(String contractorid) {
		this.contractorid = contractorid;
	}

	public String getRecorder() {
		return recorder;
	}

	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}



	public String getVisitage() {
		return visitage;
	}

	public void setVisitage(String visitage) {
		this.visitage = visitage;
	}

	public Double getTreeage() {
		return treeage;
	}

	public void setTreeage(Double treeage) {
		this.treeage = treeage;
	}

	public Double getTreeheight() {
		return treeheight;
	}

	public void setTreeheight(Double treeheight) {
		this.treeheight = treeheight;
	}

	public Double getGrounddiameter() {
		return grounddiameter;
	}

	public void setGrounddiameter(Double grounddiameter) {
		this.grounddiameter = grounddiameter;
	}

	public Double getTreearea() {
		return treearea;
	}

	public void setTreearea(Double treearea) {
		this.treearea = treearea;
	}

	public Growingpotential getGrowingpotential() {
		return growingpotential;
	}

	public void setGrowingpotential(Growingpotential growingpotential) {
		this.growingpotential = growingpotential;
	}

	public Double getX() {
		return x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public String getGeom() {
		return geom;
	}

	public void setGeom(String geom) {
		this.geom = geom;
	}

	public Integer getTreespeciesId() {
		return treespeciesId;
	}

	public void setTreespeciesId(Integer treespeciesId) {
		this.treespeciesId = treespeciesId;
	}

	public Treespecies getTreespeciesvar() {
		return treespeciesvar;
	}

	public void setTreespeciesvar(Treespecies treespeciesvar) {
		this.treespeciesvar = treespeciesvar;
	}

	public Integer getTreeageId() {
		return treeageId;
	}

	public void setTreeageId(Integer treeageId) {
		this.treeageId = treeageId;
	}

	public String getTreeageVar() {
		return treeageVar;
	}

	public void setTreeageVar(String treeageVar) {
		this.treeageVar = treeageVar;
	}




	public Integer getGpId() {
		return gpId;
	}

	public void setGpId(Integer gpId) {
		this.gpId = gpId;
	}

}