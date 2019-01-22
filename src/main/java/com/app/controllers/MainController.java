package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class MainController {

    // http://localhost:8080/
    @GetMapping("/")
    public String helloWorld() {
        // ...
        return "index";
    }

    // parametry - query params / query strings
    // http://localhost:8080/params1?name=JAN&age=20
    @GetMapping("/params1")
    public String params1(@RequestParam(required = false) String name, @RequestParam(defaultValue = "10") Integer age, Model model) {
        System.out.println("NAME = " + name);
        System.out.println("AGE = " + age);

        model.addAttribute("name", name);
        model.addAttribute("age", age);

        return "index";
    }

    // path variables
    @GetMapping("/params2/name/{myName}/age/{age}")
    public String params2(@PathVariable(name = "myName") String name, @PathVariable Integer age, Model model) {
        System.out.println("NAME = " + name);
        System.out.println("AGE = " + age);

        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("m", new HashMap<>());

        return "index";
    }
}
