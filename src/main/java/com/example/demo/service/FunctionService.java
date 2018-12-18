package com.example.demo.service;

import org.springframework.stereotype.Service;

/**
 * @author Zhang Xiao
 * @date 12/15/2018 10:13
 */
@Service
public class FunctionService {
    public String sayHello(String word){
        return "Hello " + word + " !";
    }
}
