package com.example.AsyncMethodDemo.Controller;


import com.example.AsyncMethodDemo.Models.SelectedDrives;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProcessDrives {

    @RequestMapping(value = "process", method = RequestMethod.POST)
//    void processDrives(@RequestBody JsonNode jsonNode){
//        JsonNode key = jsonNode.get("Key");
//        ArrayNode arrayNode=(ArrayNode)key;
//        System.out.println(arrayNode.get(0));
    void processDrives(@RequestBody SelectedDrives selectedDrives){
        List<String> drives =  selectedDrives.getKey();
        System.out.println(drives.size());
        System.out.println(drives.get(0));
    }
}
