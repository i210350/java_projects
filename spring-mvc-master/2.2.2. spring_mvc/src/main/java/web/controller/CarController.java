package web.controller;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.Car;
import web.service.CarService;

import java.util.*;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printWelcome(ModelMap model) {
        List<List<String>> messages = new ArrayList<>();


        List<Car> carList =  CarService.getCarService().getAllCars();
        Iterator<Car> iterator = carList.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            messages.add(new ArrayList<String>(Arrays.asList(car.getId().toString(),car.getBrand(),car.getModel(),car.getSerial())));
        }
        model.addAttribute("messages", messages);

        
//        model.addAttribute("localeCars", localeCars);
        return "cars";
    }
}
