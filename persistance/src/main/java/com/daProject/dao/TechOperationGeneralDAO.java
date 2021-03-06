package com.daProject.dao;

import com.daProject.dao.entity.TechOperationGeneral;

import java.sql.SQLException;

public interface TechOperationGeneralDAO {

    void saveTechOperation(TechOperationGeneral to) throws SQLException;
    TechOperationGeneral getTOGByTitle(String title) throws SQLException;
}
