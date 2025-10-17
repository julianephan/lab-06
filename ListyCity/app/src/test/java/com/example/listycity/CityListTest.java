package com.example.listycity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();

        // Checks whether hasCity returns true for a city already in cityList
        City cityA = new City("Edmonton", "Alberta");
        assertTrue(cityList.hasCity(cityA));

        // Checks whether hasCity returns false for a city that is not in cityList
        City cityB = new City("Montreal", "Quebec");
        assertFalse(cityList.hasCity(cityB));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        // Check if deleting a city (that exists in the list) actually removes it from the list
        City existingCity = new City("Edmonton", "Alberta");
        cityList.delete(existingCity);
        assertEquals(0, cityList.getCities().size());
        assertFalse(cityList.getCities().contains(existingCity));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();

        // Check if deleting a city that doesn't exist in the list throws an exception
        City newCity = new City("Montreal", "Quebec");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(newCity);
        });
    }

    @Test
    void testCountCities() {
        // Check the case for 1 city
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        // Check the case for removing the city (i.e., 0 cities)
        City existingCity = new City("Edmonton", "Alberta");
        cityList.delete(existingCity);
        assertEquals(0, cityList.getCities().size());

        // Check the case for adding cities
        City newCity1 = new City("Montreal", "Quebec");
        City newCity2 = new City("Calgary", "Alberta");
        cityList.add(newCity1);
        cityList.add(newCity2);
        assertEquals(2, cityList.getCities().size());

    }
}
