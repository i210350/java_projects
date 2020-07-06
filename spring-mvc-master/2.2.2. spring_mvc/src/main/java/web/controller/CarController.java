package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.Car;
import web.service.CarService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printWelcome(ModelMap model, HttpServletRequest request) {
        List<List<String>> messages = new ArrayList<>();
        List<Car> carList =  CarService.getCarService().getAllCars();
        Iterator<Car> iterator = carList.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            messages.add(new ArrayList<String>(Arrays.asList(car.getId().toString(),car.getBrand(),car.getModel(),car.getSerial())));
        }
        model.addAttribute("messages", messages);
        String localeCars ;
        if (request.getParameter("locale").equals("ru")){
            localeCars = "МАШИНЫ";
        } else {
            localeCars = "CARS";
        }
        model.addAttribute("localeCars", localeCars);
        return "cars";
    }
}
