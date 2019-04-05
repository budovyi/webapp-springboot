package com.budovyy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public ResponseEntity<HelloObject> helloWorld() {
        return ResponseEntity.ok(new HelloObject("hello from Spring boot"));
    }

    public class HelloObject {
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public HelloObject(String message) {
            this.message = message;
        }
    }
}
