package com.example.FirstHello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//rest
@RestController
public class FirstController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello World ! ";
    }
}
