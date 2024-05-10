package com.MTH.Model;

public class City {

    private int id;
    private String name;
    private String countryCode;
    private String district;
    private int population;

    public City() {

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
    }

    public void setCountryCode(String countryCode) {
    }

    public void setDistrict(String district) {
    }

    public City(int population) {
        this.population = population;
        this.name = null;
        this.countryCode = null;
        this.district = null;
    }

    public void setPopulation() {
    }
}

