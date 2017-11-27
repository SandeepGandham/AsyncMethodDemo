package com.example.AsyncMethodDemo.Utils;

import com.example.AsyncMethodDemo.Models.FileMetaData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class FileWalkerUtil implements FileVisitor<Path> {

    private int counter = 0;

    private int randomNum = 0;

    private String jsonFileName = null;

    private static final Logger logger = LoggerFactory.getLogger(FileWalkerUtil.class);

    DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
    long millis ;
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
    private String createdDateTime, lastAccessTime, lastModifiedTime;

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.format("preVisitDirectory: %s\n", dir);
        logger.info(dir.toString());
        //return super.preVisitDirectory(dir, attrs);
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        //System.out.format("visitFile: %s\n", file);
        String[] FileTitle = file.getFileName().toString().split("\\.");
//        System.out.println("PARENT ==========="+file.getParent());
//        System.out.println("FILENAME ===========" + file.getFileName());
        //System.out.println(FileTitle.length);
        FileMetaData fileMetaData=new FileMetaData();
        fileMetaData.setFileName(FileTitle[0]);
        fileMetaData.setParent(file.getParent().toString());
//        fileMetaData.setContentType(FileTitle[FileTitle.length - 1]);
//        System.out.println(FileTitle[0] + "*************" + FileTitle[1]);
        date.setTime(attrs.creationTime().toMillis());
        createdDateTime = dateFormat.format(date);
        fileMetaData.setCreatedTime(createdDateTime);

        date.setTime(attrs.lastAccessTime().toMillis());
        lastAccessTime = dateFormat.format(date);
        fileMetaData.setLastAccessTime(lastAccessTime);

        date.setTime(attrs.lastModifiedTime().toMillis());
        lastModifiedTime = dateFormat.format(date);
        fileMetaData.setLastModifiedTime(lastModifiedTime);

        fileMetaData.setSize(attrs.size());
        fileMetaData.setPath(file.toString());
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        if (counter == 0){
            randomNum = 1000 + (int)(Math.random() * ((9999 - 1000) + 1));
        }
        jsonFileName = "FileMetadata" + randomNum + ".json";
        File jsonFile = new File(jsonFileName );
        if (!jsonFile.exists()) {
            jsonFile.createNewFile();
            counter = 1;
        }
        //objectMapper.writeValue(jsonFile, fileMetaData)
        String jsonInString = objectMapper.writeValueAsString(fileMetaData);
        Files.write(jsonFile.toPath(), Arrays.asList(jsonInString), StandardOpenOption.APPEND);
        logger.info(jsonInString);
        //return super.visitFile(file, attrs);
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        //System.out.format("visitFileFailed: %s\n", file);
        //return super.visitFileFailed(file, exc);
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        //System.out.format("postVisitDirectory: %s\n", dir);
        //return super.postVisitDirectory(dir, exc);
        return FileVisitResult.CONTINUE;
    }

    public String getJsonFileName() {
        return jsonFileName;
    }
}
