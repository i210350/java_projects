package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.Role;
import web.model.UserApp;
import web.model.UserApp;
import web.model.Users_Roles;
import web.service.RoleService;
import web.service.UserService;
import web.service.UsersRolesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
public class UserController {
    private UserService userService;
    private RoleService roleService;
    private UsersRolesService usersRolesService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setUsersRolesService(UsersRolesService usersRolesService) {
        this.usersRolesService = usersRolesService;
    }

    public UserService getUserService() {
        return userService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public UsersRolesService getUsersRolesService() {
        return usersRolesService;
    }



    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView allUsers() {
        List<UserApp> users = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("usersList", users);
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return  "login";
    }
    ////////////////////////////////////////////////////////////////////

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editUser");
        return modelAndView;
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable("id") int id) {
        UserApp userApp = userService.getById(id);
        List<Role> listRoles = roleService.allRolesExist();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editUser");
        modelAndView.addObject("userApp", userApp);
        modelAndView.addObject("listRoles", listRoles);
        return modelAndView;
    }


//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
//    public ModelAndView editUser(@ModelAttribute("userApp") UserApp userApp ) {
//        ModelAndView modelAndView = new ModelAndView();
////        userApp.setRoles(new HashSet<>(listRoles));
//        userService.edit(userApp);
//        modelAndView.setViewName("redirect:/users");
//        return modelAndView;
//    }

//

//    @RequestMapping(value = "/edit" , method = RequestMethod.POST)
//    public String editUser(@RequestParam(value = "userApp", required = false) UserApp userApp,
////                           @RequestParam(value = "listRoles", required = false) List<Role> listRoles,
//                           Model model) {
////        listRoles = new ArrayList<>();
////        model.addAttribute("listRoles", listRoles);
//        model.addAttribute("userApp", userApp);
////        userApp.getRoles().clear();
////        userApp.setRoles(new HashSet<>(listRoles));
//        userService.edit(userApp);
//        return "redirect:/users";
//    }

    /////////work
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("userApp") UserApp userApp) {
        ModelAndView modelAndView = new ModelAndView();
        userService.edit(userApp);
        modelAndView.setViewName("redirect:/users");
        return modelAndView;
    }


/////////////////////////////////////////////////////////////////////////////////////////////


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") UserApp userApp, @ModelAttribute("roleCurrent") String roleCurrent) {
        ModelAndView modelAndView = new ModelAndView();
        Role role = new Role(roleCurrent);
        userApp.getRoles().add(role);
        userService.add(userApp);
        modelAndView.setViewName("redirect:/users");
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        UserApp userApp = userService.getById(id);
        userService.delete(userApp);
        return modelAndView;
    }

}