package com.example.AsyncMethodDemo.Controller;
import com.example.AsyncMethodDemo.Service.DrivesServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ListDrives {

    public static void main(String[] args) throws JsonProcessingException {
        DrivesServiceImpl drivesServiceImpl = new DrivesServiceImpl();
        drivesServiceImpl.showDrives();
    }
}
