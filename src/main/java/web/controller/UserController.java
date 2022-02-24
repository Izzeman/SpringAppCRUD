package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value="/")
    public String index(Model model){
        model.addAttribute("users", userService.readUsers());
        return "index";
    }

    @GetMapping(value="/{id}")
    public String showUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.readUser(id));
        return "show";
    }

    @GetMapping(value="/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/new")
    public String createUser(@RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String email,
                             Model model){
        User user = new User(firstName, lastName, email);
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model, @PathVariable("id") Long id){
        model.addAttribute("user", userService.readUser(id));
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String updateUser(@PathVariable("id") Long id,
                             @RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam String email,
                             Model model){
        User user = userService.readUser(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        userService.updateUser(user);
        return "redirect:/";
    }

    @PostMapping("/{id}/remove")
    public String deleteUser(@PathVariable("id") Long id, Model model){
        userService.deleteUser(id);
        return "redirect:/";
    }
}
