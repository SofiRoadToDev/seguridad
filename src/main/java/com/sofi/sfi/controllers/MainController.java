package com.sofi.sfi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MainController {



    @GetMapping("/admin")
    public String getAdmin(){
        return "THis is admin resource";
    }

    @GetMapping("/public")
    public String getPublic(){
        return "THis is public resource";
    }

    @GetMapping("/user")
    public String getUser(){
        return "THis is user resource";
    }


}
