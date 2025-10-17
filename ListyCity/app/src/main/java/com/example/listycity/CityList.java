package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This returns whether a given city belongs to the list of cities.
     * @param city
     * This is the city that we want to check whether it belongs to the list of cities or not
     * @return
     * Returns true if the given city is in the list, or false if the given city is not in the list
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * This removes a city from the list if it is in the list. Otherwise, an exception is thrown.
     * @param city
     * This is the city we want to remove (if it belongs to the list)
     */
    public void delete(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException("City does not exist in list");
        }
    }

    /**
     * This returns the number of cities in the list
     * @return
     * Returns the number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }

}
