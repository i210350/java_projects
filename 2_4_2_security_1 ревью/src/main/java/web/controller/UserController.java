package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.Role;
import web.model.UserApp;
import web.service.RoleService;
import web.service.UserService;
import web.service.UsersRolesService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {
    private UserService userService;
    private RoleService roleService;
//    private UsersRolesService usersRolesService;

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

//    public UserService getUserService() {
//        return userService;
//    }

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
        return "login";
    }

    @RequestMapping(value = "/homepage_user", method = RequestMethod.GET)
    public ModelAndView loginUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserApp userApp = userService.getByName(user.getUsername());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("homepage");
        modelAndView.addObject("userApp", userApp);
        return modelAndView;
    }

    @RequestMapping(value = "/homepage/{userName}", method = RequestMethod.GET)
    public ModelAndView editUser(@PathVariable("userName") String userName) {
        UserApp userApp = userService.getByName(userName);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("homepage");
        modelAndView.addObject("userApp", userApp);
        return modelAndView;
    }


//    @RequestMapping(value = "/edit", method = RequestMethod.GET)
//    public ModelAndView editUser() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("editUser");
//        return modelAndView;
//    }


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


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    разница   //инерсептор перехватчик

    public ModelAndView editUser(@ModelAttribute("userApp") UserApp userApp,
                                 @RequestParam(required = false) Integer[] idRoles) {
        ModelAndView modelAndView = new ModelAndView();
        Set<Role> roleSet = new HashSet<>();
        for (int idRole : idRoles) {
            roleSet.add(getRoleService().getById(idRole));
        }
        userApp.setRoles(new HashSet<>(roleSet));
        userService.edit(userApp);
        modelAndView.setViewName("redirect:/users");
        return modelAndView;
    }


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

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteUser(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        UserApp userApp = userService.getById(id);
        userService.delete(userApp);
        return modelAndView;
    }

}