package com.example.ormabackendtest.resources;

import com.example.ormabackendtest.entities.User;
import com.example.ormabackendtest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeResource {

    @Autowired
    private UserService service;

    @GetMapping("/home")
    public String home(){
        return "home/home";
    }

}
