package com.jk.timemrgapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/added")
public class NewTaskAddedController {

    @GetMapping("/task")
    public String getTaskAddedSuccessfully(){
        return "taskadded";
    }
}
