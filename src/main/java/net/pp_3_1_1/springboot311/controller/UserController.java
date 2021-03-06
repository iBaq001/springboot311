package net.pp_3_1_1.springboot311.controller;

import net.pp_3_1_1.springboot311.model.User;
import net.pp_3_1_1.springboot311.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }
    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }
    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
    @DeleteMapping("user-delete/{id}")
    public String deleteUser(@PathVariable ("id") long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
    @GetMapping("user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") @Validated User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
}
