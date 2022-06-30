package com.example.ormabackendtest.resources;

import com.example.ormabackendtest.entities.User;
import com.example.ormabackendtest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class RegisterResource {

    @Autowired
    private UserService service;

    @GetMapping("/")
    public String index(){
        return "redirect:register";
    }

    @GetMapping("/register")
    public String register(){
        return "register/register";
    }

    @PostMapping("/register/create")
    public String createWithToken(@RequestParam(value = "token", required = false) Long token, User user){
        if(token == null){
            service.insert(user);
            Long tokenSend = user.getToken();
            return "redirect:/home?token=" + tokenSend;
        }
        service.insert(user);
        Long tokenSend = user.getToken();
        User userFound = service.findByToken(token);
        service.update(token, userFound);
        return "redirect:/home?token=" + tokenSend;
    }
}
