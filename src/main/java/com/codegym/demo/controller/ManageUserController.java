package com.codegym.demo.controller;

import com.codegym.demo.model.User;
import com.codegym.demo.service.IUserService;
import com.codegym.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/manageUser")
public class ManageUserController {
    @Autowired
    private final IUserService userService;

    public ManageUserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String manageUser(Model model) {
        List<User> userList = userService.getListUser();
        model.addAttribute("userList", userList);
        return "manageUser/list";
    }

    @GetMapping("/showAddForm")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "manageUser/add";
    }

    @GetMapping("/{id}/showUpdateForm")
    public String showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "manageUser/edit";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/manageUser";
    }

    @PostMapping("/add")
    public String add(User user) {
        user.setId((int) (Math.random() * 10000));
        userService.save(user);
        return "redirect:/manageUser";
    }
    @PostMapping("/save")
    public String save(User user) {
        userService.updateUser(user);
        return "redirect:/manageUser";
    }
}

