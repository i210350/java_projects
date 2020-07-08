package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {
    private UserService userService = new UserServiceImpl();

//    private static web.model.User user;
//
//    static {
//        user = new web.model.User();
//        user.setName("Ivan");
//        user.setLastname("Ivanov");
//        user.setOld(20);
//        user.setMail("aaa@mmm.com");
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allUsers() {
        List<User> users = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("user", users);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editUser");
        return modelAndView;
    }
}