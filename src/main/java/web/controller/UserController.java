package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    public UserController() {

    }

    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String showUsers(){
//        List<User> usersList = new ArrayList<>();
//        usersList.add(new User("Den", "Izeman", "Senior", 302000));
//        usersList.add(new User("Leo", "Carter", "Middle", 254000));
//        usersList.add(new User("Robert", "Foully", "SJunior", 167000));
//        model.addAttribute("usersList", usersList);
        return "user";
    }
}
