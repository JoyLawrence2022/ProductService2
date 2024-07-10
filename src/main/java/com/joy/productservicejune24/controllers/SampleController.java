package com.joy.productservicejune24.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This class will be hosting a set of HTTP APIs
@RestController
@RequestMapping("/say")
public class SampleController {

    //localhost:8075/say/hello/joy
    //read 'name' as 'joy' and copy it to String xy
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String xy){
        return "Hello " + xy;
    }

    @GetMapping("/hello1/{name}/{value}")
    public String sayHello1(@PathVariable("name") String xy, @PathVariable("value") int val){
        String output = "";
        for(int i=0; i<val; i++){
            output = output + "Hello " + xy + " ";
        }

        return output;
    }

    @GetMapping("/bye")
    public String sayBye(){
        return "Bye Everyone!";
    }
}
