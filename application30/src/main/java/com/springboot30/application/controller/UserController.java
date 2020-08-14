package com.springboot30.application.controller;

//import com.springboot30.apllication.model.Role;
//import com.springboot30.apllication.model.User;
//import com.springboot30.apllication.service.UserService;
import com.springboot30.application.model.Role;
import com.springboot30.application.model.UserApp;
import com.springboot30.application.repository.RoleRepository;
import com.springboot30.application.repository.UserRepository;
import com.springboot30.application.service.RoleServiceImpl;
//import com.springboot30.application.service.UserService;
import com.springboot30.application.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//import javax.validation.Valid;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

//    @Qualifier("userRepository")
    @Autowired
//    UserRepository userRepository;
    private UserServiceImpl userServiceImpl;

    @Autowired
//    RoleRepository roleRepository;
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") UserApp userApp, @ModelAttribute("roleCurrent") String roleCurrent) {
        ModelAndView modelAndView = new ModelAndView();
        Role role = roleServiceImpl.findByName("USER");
        HashSet<Role> hashSet = new HashSet<>();
        hashSet.add(role);
        userApp.getRoles().add(role);
        userServiceImpl.saveUser(userApp);
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }


    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        userServiceImpl.deleteById(id);
        return modelAndView;
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable("id") int id) {
        UserApp userApp = userServiceImpl.getById(id);
//        List<Role> listRoles = roleService.allRolesExist();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editUser");
        modelAndView.addObject("userApp", userApp);
//        modelAndView.addObject("listRoles", listRoles);
        return modelAndView;
    }
//
//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
//    public ModelAndView editUser(@ModelAttribute("userApp") UserApp userApp,
//                                 @RequestParam(required = false) Integer[] idRoles) {
//        ModelAndView modelAndView = new ModelAndView();
//        Set<Role> roleSet = new HashSet<>();
//        for (int idRole: idRoles) {
//            roleSet.add(getRoleService().getById(idRole));
//        }
//        userApp.setRoles(new HashSet<>(roleSet));
//        userService.edit(userApp);
//        userServiceImpl.saveUser(userApp);
//        modelAndView.setViewName("redirect:/admin");
//        return modelAndView;
//    }



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
//        UserApp userExists = userService.findUserByEmail(user.getMail());
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
        model.addObject("usersList", usersList);
//        model.setViewName("admin_home");
        model.setViewName("admin_home1");
        return model;
    }

    @RequestMapping(value= {"/user"}, method=RequestMethod.GET)
    public ModelAndView user_home() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserApp user = userServiceImpl.findUserByEmail(auth.getName());

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
