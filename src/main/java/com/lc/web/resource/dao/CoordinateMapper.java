package com.lc.web.resource.dao;

import com.lc.web.resource.entity.Coordinate;

import java.util.List;

public interface CoordinateMapper {

    List<Coordinate> listCoordinate();
    Coordinate listCoordinateById(int coordinateid);
}