package com.bosonit.block6personcontrollers.services;

import com.bosonit.block6personcontrollers.classes.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CityServices {
    private ArrayList<City> cities = new ArrayList<>();


    public void addCity(City city){
        cities.add(city);
    }

    public ArrayList<City> getCities() {
        return cities;
    }


}
