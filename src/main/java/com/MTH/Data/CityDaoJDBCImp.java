package com.MTH.Data;

import com.MTH.Model.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.MTH.Data.MySQLConnection.getConnection;


public class CityDaoJDBCImp implements CityDao {



    private static final String FIND_BY_ID = "SELECT * FROM city WHERE id = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM city WHERE name = ?";
    private static final String FIND_ALL = "SELECT * FROM city";
    private static final String ADD_City = "INSERT INTO city (name, countryCode, district, population) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_City = "UPDATE city SET name = ?, countryCode = ?, district = ?, population = ? WHERE id = ?";
    private static final String DELETE_City = "DELETE FROM city WHERE id = ?";





    @Override
    public City findById(int id)  {

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
               if (resultSet.next()){
                   return extractCityFromResultSet(resultSet);
               }
            }

            }catch (SQLException e){
            e.printStackTrace();
        }
        return null;

    }




    @Override
    public List<City> findByCode(String code) {

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM city WHERE code = ?")) {
            statement.setString(1, code);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    @Override
    public List<City> findByName(String name) {
        List<City> cities = (List<City>) new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_NAME)) {
            statement.setString(1, name);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;

    }

    @Override
    public List<City> findAll() {

        List<City> cities = (List<City>) new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {

                cities.add(extractCityFromResultSet(result));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public void update(com.MTH.Data.City city) {

    }

    @Override
    public void update(City city) {

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_City)) {
            statement.setString(1, city.getName());
            statement.setString(2, city.getCountryCode());
            statement.setString(3, city.getDistrict());
            statement.setInt(4, city.getPopulation());
            statement.setInt(5, city.getId());
            statement.executeUpdate();
            {
                throw new SQLException("Creating city failed, no rows affected.");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private City extractCityFromResultSet(ResultSet result) throws SQLException {
        City city = new City();
        city.setId(result.getInt("id"));
        city.setName(result.getString("name"));
        city.setCountryCode(result.getString("countryCode"));
        city.setDistrict(result.getString("district"));
        city.setPopulation();
        return city;
    }
}








