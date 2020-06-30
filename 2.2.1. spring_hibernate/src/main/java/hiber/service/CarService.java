package hiber.service;

import hiber.model.Car;
import org.springframework.stereotype.Component;

import java.util.List;


public interface CarService {
    void add(Car car);
    List<Car> listCars();
}
