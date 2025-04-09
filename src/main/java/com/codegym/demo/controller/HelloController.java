package com.codegym.demo.controller;

import com.codegym.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller()
public class HelloController {
    @GetMapping("")
    public String hello(Model model){
        model.addAttribute("message", "Xin chào thymeleaf");
        int a = 5;
        int b = 6;
        User user = new User(1,"Th Can","vy@","1234");
        User user2 = new User(2,"Th Can2","vy@","1234");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);
        model.addAttribute("users", users);
        model.addAttribute("b", b);
        model.addAttribute("a", a);
        model.addAttribute("user", user);
        return "hello";
    }
}
