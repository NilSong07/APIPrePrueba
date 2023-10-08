package com.hackerrank.sample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

     @PostMapping("/customHello")
    public ResponseEntity<String> setMessage(@RequestBody String message)
    {
        if (message == null || message.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("parameter is not present");
        }
        else
            return ResponseEntity.status(HttpStatus.OK).body("Hello: " + message);
    }

    @GetMapping("/defaultHello")
    public ResponseEntity<String> obtenerUsuario(@PathVariable ("id") String message)
    {
        if (message == null || message.isEmpty()) {
            return ResponseEntity.ok("Hello World!");
        }
        else
            return ResponseEntity.status(HttpStatus.OK).body("Hello: " + message);

    }

}
