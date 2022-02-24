package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/users")
public class UserController {
    private UserDao userDao;

    @Autowired
    public void setUserService(UserDao userDao) {
        this.userDao = userDao;
    }
//    private UserService userService;
//
//    public UserController() {
//
//    }
//
//    @Autowired
//    public UserController(UserService userService) {
//
//        this.userService = userService;
//    }

    @GetMapping(value="/")
    public String index(Model model){
//        userService.createUser(new User("Den", "Izeman", "Den.Izeman@mail.com"));
//        model.addAttribute("users", userService.readUsers());
        model.addAttribute("users", userDao.readUsers());
        return "index";
    }

    @GetMapping(value="/{id}")
    public String showUser(@PathVariable("id") Long id, Model model){
//        model.addAttribute("user", userService.readUser(id));
        model.addAttribute("user", userDao.readUser(id));
        return "show";
    }

    @GetMapping(value="/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "new2";
    }

    @PostMapping("/new")
    public String createUser(@RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String email,
                             Model model){
        User user = new User(firstName, lastName, email);
        userDao.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") Long id){
        model.addAttribute("user", userDao.readUser(id));
        return "edit2";
    }

    @PostMapping("/{id}/edit")
    public String updateUser(@PathVariable("id") Long id,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String email,
                             Model model){
        User user = userDao.readUser(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        userDao.updateUser(user);
        return "redirect:/";
    }

    @PostMapping("/{id}/remove")
    public String deleteUser(@PathVariable("id") Long id, Model model){
        userDao.deleteUser(id);
        return "redirect:/";
    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id){
//        userDao.updateUser(id);
//        return "redirect:/";
//    }

//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
//        personDAO.update(id, person);
//        return "redirect:/people";
//    }
//    @PostMapping("/new")
//    public String createUser(@ModelAttribute("user") User user){
//        userService.createUser(user);
//        return "redirect:/";
//    }



//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("person", personDAO.show(id));
//        return "people/show";
//    }

//    @GetMapping(value = "/")
//    public String showUsers(Model model){
//        List<User> usersList = new ArrayList<>();
//        usersList.add(new User("Den", "Izeman", "Senior"));
//        usersList.add(new User("Leo", "Carter", "Middle"));
//        usersList.add(new User("Robert", "Foully", "SJunior"));
////        model.addAttribute("usersList", usersList);
//        model.addAttribute("usersList", userService.readUsers());
//        return "user";
//    }
//    @GetMapping(value = "/")
//    public String printWelcome(ModelMap model) {
//        List<String> messages = new ArrayList<>();
//        messages.add("Hello!");
//        messages.add("I'm Spring MVC application");
//        messages.add("5.2.0 version by sep'19 ");
//        model.addAttribute("messages", messages);
//        return "user";
//    }
}
