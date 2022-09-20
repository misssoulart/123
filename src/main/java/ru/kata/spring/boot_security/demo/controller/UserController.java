package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.service.RoleService;

import java.security.Principal;

@Controller
public class UserController {
    private final RoleService userService;

    public UserController(RoleService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String userPage(Principal principal, Model model){
        model.addAttribute("user", userService.loadUserByUsername(principal.getName()));
        return "user";
    }
}