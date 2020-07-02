package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printWelcome(ModelMap model) {
//        List<String> messages = new ArrayList<>();
//        messages.add("Hello Car!");
//        messages.add("I'm Spring MVC application");
//        messages.add("5.2.0 version by sep'19 ");

        List<Car> carList =  CarService.getCarService().getAllCars();
        Iterator<Car> iterator = carList.iterator();
        while (iterator.hasNext()) {
            messages.add(iterator.next().getId().toString());
            messages.add(iterator.next().getBrand());
            messages.add(iterator.next().getModel());
            messages.add(iterator.next().getSerial());
        }
        model.addAttribute("messages", messages);
        return "cars";
    }
}
