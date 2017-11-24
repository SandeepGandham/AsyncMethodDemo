package com.example.AsyncMethodDemo.Service;

import com.example.AsyncMethodDemo.Utils.FileWalkerUtil;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class FileWalkerService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(FileWalkerService.class);


    @Async
    public CompletableFuture<String> callFileWalker(String drivePath) throws InterruptedException {

        Path path = Paths.get(drivePath);
        FileWalkerUtil fileWalkerUtil = new FileWalkerUtil();
        String result = null;
        try {
            Files.walkFileTree(path, fileWalkerUtil);
            Thread.sleep(5000L);
            //Read Data from Json file
//            logger.info("********************************************************************************");
//            final List<String> lines = Files.readAllLines(new File("FilesMetadata.json").toPath());
//            logger.info(lines.toString());
            result = "Successful";

        } catch (IOException ex) {
            Logger.getLogger(FileWalkerUtil.class.getName()).log(Level.SEVERE, null, ex);
            result = "Failed";
        }
        return CompletableFuture.completedFuture(result);
    }

}
