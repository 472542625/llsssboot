package com.lc.web.resource.entity;

public class Coordinate {
    private Integer coordinateid;



    private String geom;

    public Integer getCoordinateid() {
        return coordinateid;
    }

    public void setCoordinateid(Integer coordinateid) {
        this.coordinateid = coordinateid;
    }

    public String getGeom() {
        return geom;
    }

    public void setGeom(String geom) {
        this.geom = geom;
    }

    public String getCoordinatename() {
        return coordinatename;
    }

    public void setCoordinatename(String coordinatename) {
        this.coordinatename = coordinatename;
    }

    private String coordinatename;


}