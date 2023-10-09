package com.hackerrank.sample.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SampleController 
{


    @PostMapping("/customHello")
    public ResponseEntity<Map<String, String>> customHello(@RequestParam Map<String, String> params) 
    {
        
        ResponseEntity<Map<String, String>> ls_return = null;
        try
        {
            
            if(params != null)
            {
                String customMessage;
                
                customMessage = params.get("message");

                if(customMessage == null)
                    ls_return = ResponseEntity.badRequest().build();
                else if (customMessage.isEmpty()) 
                {
                    customMessage ="";
                    
                    Map<String, String> response = new HashMap<>();
                    response.put("echo", "Hello " + customMessage);
                    ls_return =  ResponseEntity.ok(response);
                }
                else
                {
                    Map<String, String> response = new HashMap<>();
                    response.put("echo", "Hello " + customMessage);
                    ls_return =  ResponseEntity.ok(response);
                }
            }
            else
                ls_return = ResponseEntity.badRequest().build();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        return ls_return;
    }

    @GetMapping("/defaultHello")
    public ResponseEntity<Map<String, String>> defaultHello(@RequestParam(name = "message", required = false) String message)
    {
        if (message == null || message.isEmpty()) {
            return ResponseEntity.ok(Collections.singletonMap("echo", "Hello World!")); 
        }
        else
            return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("echo", "Hello " + message));

    }

}
