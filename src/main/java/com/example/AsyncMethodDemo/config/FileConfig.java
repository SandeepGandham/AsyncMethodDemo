package com.example.AsyncMethodDemo.config;

import com.example.AsyncMethodDemo.Models.ResponseObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileConfig {

    @Bean
    public ResponseObject responseObject(){
        return new ResponseObject();
    }
}
