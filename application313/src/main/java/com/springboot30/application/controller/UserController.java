package com.springboot30.application.controller;

import com.springboot30.application.model.Role;
import com.springboot30.application.model.UserApp;
import com.springboot30.application.service.RoleServiceImpl;
import com.springboot30.application.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private RoleServiceImpl roleServiceImpl;

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


    @RequestMapping(value= {"/test100"}, method=RequestMethod.GET)
    public ModelAndView testGET100() {
        ModelAndView model = new ModelAndView();
        model.setViewName("test100");
        return model;
    }

    @RequestMapping(value= {"/test100"}, method=RequestMethod.POST)
    public ModelAndView testPOST100() {
        ModelAndView model = new ModelAndView();
        List<UserApp> usersList = userServiceImpl.getAllByActive(1);
        model.addObject("usersList", usersList);
        model.setViewName("deleteModal");
        return model;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("userAdd") UserApp userApp, @RequestParam(required = false) Long[] idRoles) {
        ModelAndView modelAndView = new ModelAndView();
        for (Long idRole : idRoles) {
            Role role = roleServiceImpl.getRoleById(idRole);
            userApp.getRoles().add(role);
        }
        userServiceImpl.saveUser(userApp);
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }


    @RequestMapping(value= "/delete/{id}", method=RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Long id, ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<UserApp> usersList = userServiceImpl.getAllByActive(1);
        UserApp userAdd = new UserApp();
        UserApp user = userServiceImpl.findUserByEmail(auth.getName());
        UserApp deleteUser = userServiceImpl.getUserById(id);
        List<Role> rolesAll = roleServiceImpl.findAllRoles();
        model.addAttribute("rolesAll", rolesAll);
        model.addAttribute("deleteUser", deleteUser);
        return "/fragments/deleteModal :: deleteModal";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView deleteUser(@ModelAttribute("userApp") UserApp deleteUser) {
        ModelAndView modelAndView = new ModelAndView();
        userServiceImpl.deleteUser(deleteUser);
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }


    @RequestMapping(value= "/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editUser(@PathVariable("id") Long id) {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<UserApp> usersList = userServiceImpl.getAllByActive(1);
        UserApp userAdd = new UserApp();
        UserApp user = userServiceImpl.findUserByEmail(auth.getName());
        UserApp editUser = userServiceImpl.getUserById(id);
        editUser.setPassword("");
        List<Role> rolesAll = roleServiceImpl.findAllRoles();
        model.addObject("usersList", usersList);
        model.addObject("userAdd", userAdd);
        model.addObject("rolesAll", rolesAll);
        model.addObject("userCurrent",user);
        model.addObject("editUser", editUser);
        model.setViewName("editUser");
        return model;
    }



    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("userApp") UserApp editUser,
                                 @RequestParam(required = false) Long[] idRoles) {
        ModelAndView modelAndView = new ModelAndView();
        Set<Role> roleSet = new HashSet<>();
        for (Long idRole: idRoles) {
            roleSet.add(roleServiceImpl.getRoleById(idRole));
        }
        editUser.setRoles(new HashSet<>(roleSet));
        userServiceImpl.saveUser(editUser);
        modelAndView.setViewName("redirect:/admin");
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
    public ModelAndView createUser(@Valid UserApp user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        UserApp userExists = userServiceImpl.findUserByEmail(user.getMail());

        if(userExists != null) {
            bindingResult.rejectValue("email", "error.user", "This email already exists!");
        }
        if(bindingResult.hasErrors()) {
            model.setViewName("signup");
        } else {
            userServiceImpl.saveUser(user);
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
        List<UserApp> usersList = userServiceImpl.getAllByActive(1);
        UserApp userAdd = new UserApp();
        UserApp user = userServiceImpl.findUserByEmail(auth.getName());
        UserApp editUser = user;
        List<Role> rolesAll = roleServiceImpl.findAllRoles();
        model.addObject("usersList", usersList);
        model.addObject("userAdd", userAdd);
        model.addObject("rolesAll", rolesAll);
        model.addObject("userCurrent",user);
        model.addObject("editUser", editUser);
        model.setViewName("admin_home");
        return model;
    }

    @RequestMapping(value= {"/user"}, method=RequestMethod.GET)
    public ModelAndView user_home() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserApp user = userServiceImpl.findUserByEmail(auth.getName());
        String isAdmin = null;
        if (user.getStingRoles().contains("ADMIN")) {
            isAdmin = "ADMIN";
        }
        model.addObject("userCurrent",user);
        model.addObject("isAdmin",isAdmin);
        model.setViewName("user_home");
        return model;
    }

    @RequestMapping(value= {"/access_denied"}, method=RequestMethod.GET)
    public ModelAndView accessDenied() {
        ModelAndView model = new ModelAndView();
        model.setViewName("access_denied");
        return model;
    }
//    ------------------------------------------------------------------------------------
}
