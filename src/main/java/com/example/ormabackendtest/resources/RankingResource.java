package com.example.ormabackendtest.resources;

import com.example.ormabackendtest.entities.User;
import com.example.ormabackendtest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RankingResource {

    @Autowired
    private UserService service;

    @GetMapping("/ranking")
    public String ranking(Model model){
        List<User> users = service.findAll();
        model.addAttribute("users", users);
        return "ranking/ranking";
    }
}
