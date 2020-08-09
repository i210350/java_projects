package com.springboot30.application.controller;

//import com.springboot30.apllication.model.Role;
//import com.springboot30.apllication.model.User;
//import com.springboot30.apllication.service.UserService;
import com.springboot30.application.model.Role;
import com.springboot30.application.model.UserApp;
import com.springboot30.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value= {"/", "/login"}, method=RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();

        model.setViewName("login");
        return model;
    }

    @RequestMapping(value= {"/add"}, method=RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView model = new ModelAndView();
        model.setViewName("addUser");
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") UserApp userApp, @ModelAttribute("roleCurrent") String roleCurrent) {
        ModelAndView modelAndView = new ModelAndView();
        Role role = new Role("User");
        HashSet<Role> hashSet = new HashSet<>();
        hashSet.add(role);
        userApp.getRoles().add(role);
        userService.saveUser(userApp);
        modelAndView.setViewName("redirect:/admin_home");
        return modelAndView;
    }

    @RequestMapping(value= {"/signup"}, method=RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView model = new ModelAndView();
        UserApp user = new UserApp();
        model.addObject("user", user);
        model.setViewName("signup");

        return model;
    }

    @RequestMapping(value= {"/signup"}, method=RequestMethod.POST)
    public ModelAndView createUser( UserApp user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        UserApp userExists = userService.findUserByEmail(user.getEmail());

        if(userExists != null) {
            bindingResult.rejectValue("email", "error.user", "This email already exists!");
        }
        if(bindingResult.hasErrors()) {
            model.setViewName("signup");
        } else {
            userService.saveUser(user);
            model.addObject("msg", "User has been registered successfully!");
            model.addObject("user", new UserApp());
            model.setViewName("signup");
        }

        return model;
    }

    @RequestMapping(value= {"/admin"}, method=RequestMethod.GET)
    public ModelAndView admin_home() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<UserApp> usersList = userService.getAllByActive(1);
        model.addObject("usersList", usersList);
        model.setViewName("admin_home");
        return model;
    }

    @RequestMapping(value= {"/user"}, method=RequestMethod.GET)
    public ModelAndView user_home() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserApp user = userService.findUserByEmail(auth.getName());

        model.addObject("userName", user.getName() + " " + user.getLastname());
        model.setViewName("user_home");
        return model;
    }

    @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView();
        model.setViewName("access_denied");
        return model;
    }
}
