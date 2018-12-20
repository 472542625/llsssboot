package com.lc.web.resource.entity;

public class Treespecies {
    private Integer treespeciesid;

    private String treespeciesname;

    private String section;

    private String genus;

    private String imgpath;

    public Integer getTreespeciesid() {
        return treespeciesid;
    }

    public void setTreespeciesid(Integer treespeciesid) {
        this.treespeciesid = treespeciesid;
    }

    public String getTreespeciesname() {
        return treespeciesname;
    }

    public void setTreespeciesname(String treespeciesname) {
        this.treespeciesname = treespeciesname == null ? null : treespeciesname.trim();
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section == null ? null : section.trim();
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus == null ? null : genus.trim();
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath == null ? null : imgpath.trim();
    }
}