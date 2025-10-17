package com.example.listycity;

import java.util.Objects;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * Initializes the attributes for a City object.
     * @param city
     * This is the name of the city
     * @param province
     * This is the name of the province
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * This is a getter that returns the city name
     * @return
     * Returns the city name
     */
    public String getCityName() {
        return this.city;
    }

    /**
     * This is a getter that returns the province name
     * @return
     * Returns the province name
     */
    public String getProvinceName() {
        return this.province;
    }

    /**
     * Compares the name of this city with the name of another city
     * @param o
     * The city to be compared
     * @return
     * Returns 0 if the names are equal, a negative integer if this city name is less than the other
     * city's name, or a positive integer if this city name is greater than the other city's name
     */
    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }

    /**
     * Returns whether two cities are equal (i.e., if they have the same city and province name)
     * @param o
     * The city to be compared
     * @return
     * Returns true if the cities are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        /*
        * Source used for this method: https://www.infoworld.com/article/2256967/comparing-java-objects-with-equals-and-hashcode.html
        * Authored by: Rafael del Nero
        * Taken by: Juliane Phan
        * Taken on: October 16 2025
        */

        // Checks whether the 2 objects have the same values
        if (this == o) {
            return true;
        }

        // Checks whether the passed object is null or of a different class
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        // Checks whether the 2 objects have the same fields
        City comparedCity = (City) o;
        return city.equals(comparedCity.getCityName()) && province.equals(comparedCity.getProvinceName());
    }

    /**
     * Returns a hashcode (integer) for this city
     * @return
     * Return a hashcode for this city
     */
    @Override
    public int hashCode() {
        /*
        * Source used: https://stackoverflow.com/a/24433315
        * Authored by: Holder on Stack Overflow https://stackoverflow.com/users/2711488/holger
        * Taken by: Juliane Phan
        * Taken on: October 16 2025
        */
        return Objects.hash(city, province);
    }
}
