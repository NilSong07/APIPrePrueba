package com.hackerrank.sample.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
    public ResponseEntity<Map<String, String>> setMessage(@RequestBody String message) {
    if (message == null || message.isEmpty()) {
        return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Parameter is not present"));
    } else {
        Map<String, String> response = new HashMap<>();
        response.put("echo", "Hello: " + message);
        return ResponseEntity.ok(response);
    }
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
