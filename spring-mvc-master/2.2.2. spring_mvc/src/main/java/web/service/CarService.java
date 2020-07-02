package web.service;

import web.model.Car;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class CarService {
    private static volatile CarService carService;
    /* хранилище данных */
    private Map<Long, Car> dataBase = Collections.synchronizedMap(new HashMap<>());
    /* счетчик id */
    private AtomicLong maxId = new AtomicLong(0);

    private CarService() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static CarService getCarService() {
        if (carService == null) {
            synchronized (CarService.class) {
                if (carService == null) {
                    carService = new CarService();
                    carService.addCar(new Car(carService.getMaxIdIncrement(), "ddd", "dda", "a123bc"));
                    carService.addCar(new Car(carService.getMaxIdIncrement(), "ccc", "cca", "a234gh"));
                    carService.addCar(new Car(carService.getMaxIdIncrement(), "ddd", "ddb", "a456as"));
                    carService.addCar(new Car(carService.getMaxIdIncrement(), "eee", "ess", "b587mm"));
                }
            }
        }
        return carService;
    }

    public Car getCarById(Long id) {
        return dataBase.get(id);
    }

    public boolean addCar(Car car) {
        if (carService.getCarBySerial(car.getSerial()) == null ) {
            car.setId(getMaxIdIncrement()*13);
            dataBase.put(car.getId(), car);
            return  true;
        }
        return false;
    }

    public List<Car> getAllCars() {
        return new ArrayList<>(dataBase.values());
    }

    public Car getCarBySerial(String email) {
        for (Map.Entry<Long, Car> entry : dataBase.entrySet()) {
            Long id = entry.getKey();
            Car car = entry.getValue();
            if (car.getSerial().equals(email)) {
                return car ;
            }
        }
        return null ;
    }

    public Long getMaxIdIncrement() {
        return maxId.getAndIncrement() + 1;
    }

}
