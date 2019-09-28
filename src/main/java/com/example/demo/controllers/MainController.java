package com.example.demo.controllers;

import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class MainController {
    private UserService userService;

    @RequestMapping("/mvc/greet/{userId}")
    public String showAllUsers(Model model, @PathVariable Integer userId) {
        model.addAttribute("userName", userService.getUserName(userId));
        return "welcome";
    }

    @RequestMapping("/mvc/user/showAll")
    public ModelAndView showAllUsers() {
      ModelAndView mv = new ModelAndView("users");
      mv.addObject("users", userService.getAllUsers());
      return mv;
    }

    @GetMapping("mvc/user/insert")
    public String insertUser(){
        return "insertUser";

    }
    @PostMapping("mvc/user/insert")
    public ModelAndView insertUser(String name, String email){
        userService.insertUser(name, email);
        return showAllUsers();
    }

}
