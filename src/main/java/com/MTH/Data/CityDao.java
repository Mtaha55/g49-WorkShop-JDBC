package com.MTH.Data;



import java.sql.SQLException;

interface CityDao {
    com.MTH.Model.City findById(int id) throws SQLException;
    List<com.MTH.Model.City> findByCode(String code);
    List<com.MTH.Model.City> findByName(String name);
    List<com.MTH.Model.City> findAll();

    void update(City city);

    void update(com.MTH.Model.City city);
}
