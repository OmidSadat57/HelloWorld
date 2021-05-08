package com.example.springboot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

@RestController
public class HelloController {

//    @Autowired

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")
    public String sayHello() {
//        final long sysDateAnfang = System.currentTimeMillis();
//        String localDateInMilliSecToString = String.valueOf(sysDateAnfang);
        String message = "Hello World, and Greetings from Spring Boot!";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.US);
        LocalTime time = LocalTime.now();
        String f = " \" Es ist: " + formatter.format(time) + " Uhr \"";
        System.out.println(f);
        return message + f;
    }

    @GetMapping("/hello1")
    public String sayHello1(@RequestParam(value = "myName", defaultValue = "World") String name,
                            @RequestParam(value = "age", defaultValue = "alt genug")String age) {
        return String.format("Hello %s ist %s!", name, age);
    }

    @RequestMapping("/hello")
    public String saySimplyHello() {
        return "Hello World, and Greetings from Spring Boot!";
    }

//    @RequestMapping("/addiere")
//    public String addiere() {
//        return "Hello World, and Greetings from Spring Boot! " + klasse1.addiere();
//    }

    @RequestMapping(path="/answer/{name}/{age}")
    public String pathParams(@PathVariable("name") String name,
                             @PathVariable("age") String age) {
        return String.format("%s is %s years old", name, age);
    }

    @RequestMapping("/answer")
    public String queryParams(@RequestParam("name") String name,
                             @RequestParam("age") String age) {
        return String.format("%s is %s years old", name, age);
    }

    @RequestMapping("/header")
    public String header(@RequestHeader(value = "User-Agent") String userAgent) {
        return String.format("User agent is %s years old", userAgent);
    }

    @RequestMapping("/get418")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public void getBadRequest() { }

    @RequestMapping("/get200")
    @ResponseStatus(HttpStatus.OK)
    public void getOk() {
//        return HttpStatus.OK;
    }
//    public HttpStatus getOk() {
//        return HttpStatus.OK;
//    }

    @RequestMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Map<String, String> getJson() {
        return Map.of("name", "Omid", "age", "26");
    }

    @RequestMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User postJson(@RequestBody User user) {
        logger.info("User", user);
        return  user;
    }

}