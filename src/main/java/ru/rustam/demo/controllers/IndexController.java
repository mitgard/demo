package ru.rustam.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    @GetMapping(value = "/", produces = "Application/json")
    public ResponseEntity index() {
        String str = "{\"Main\":Mock}";
        return ResponseEntity.ok(str);
    }

}

