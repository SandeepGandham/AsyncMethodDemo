package com.example.AsyncMethodDemo.Controller;

import com.example.AsyncMethodDemo.Service.FileWalkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class FileWalkerController {

    private static final Logger logger = LoggerFactory.getLogger(FileWalkerController.class);

    private final FileWalkerService fileWalkerService;

    FileWalkerController(FileWalkerService fileWalkerService){
        this.fileWalkerService=fileWalkerService;
    }

    @RequestMapping(value = "/filewalker", method = RequestMethod.GET)
    public String fileWalker() throws Exception{

        long start = System.currentTimeMillis();

        logger.info("Calling Async 1st time");
        CompletableFuture<String> folder1 = fileWalkerService.callFileWalker("/home/vivek/Sandeep/printName/src/main/java/com/example");
        logger.info("Calling Async 2nd time");
        CompletableFuture<String> folder2 = fileWalkerService.callFileWalker("/home/vivek/Sandeep/Java");
        CompletableFuture.allOf(folder1,folder2);

        //System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
//        System.out.println("--> " + folder1.get());
//        System.out.println("--> " + folder2.get());

        return "Finished";
    }
}
