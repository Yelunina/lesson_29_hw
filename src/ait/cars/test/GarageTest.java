package ait.cars.test;

import ait.cars.dao.Garage;
import ait.cars.dao.GarageImpl;
import ait.cars.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {
    Garage garage;
    Car[] cars;

    @BeforeEach
    void setUp() {
        garage = new GarageImpl(4);
        cars = new Car[3];
        cars[0] = new Car("AA7733", "Escape", "Ford", 2488.00, "black");
        cars[1] = new Car("AA1155", "Ibiza", "Seat", 1390.00, "red");
        cars[2] = new Car("AA9999", "Slavuta", "Tavria", 1197.00, "blue");

        for (int i = 0; i < cars.length; i++) {
            garage.addCar(cars[i]);
        }
    }

    @Test
    void addCar() {
        assertFalse(garage.addCar(null));
        assertFalse(garage.addCar(cars[1]));
        Car car = new Car("AA1111", "Model X", "Tesla", 1020, "white");
        assertTrue(garage.addCar(car));
        car = new Car("AA7777", "Model X", "Tesla", 1020, "white");
        assertFalse(garage.addCar(car));
    }

    @Test
    void removeCar() {
        Car car = garage.removeCar("AA7733");
        assertEquals(cars[0], car);

    }

    @Test
    void findCarByRegNumber() {
        Car car = garage.findCarByRegNumber("AA1155");
        assertEquals(cars[1], car);
        car = garage.findCarByRegNumber("AA5555");
        assertNull(car);

    }

    @Test
    void findCarsByModel() {
    }

    @Test
    void findCarsByCompany() {
    }

    @Test
    void findCarsByEngine() {
    }

    @Test
    void findCarsByColor() {
    }
}