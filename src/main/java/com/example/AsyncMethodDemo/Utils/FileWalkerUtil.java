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
import java.util.Arrays;


public class FileWalkerUtil extends SimpleFileVisitor<Path> {

    private static final Logger logger = LoggerFactory.getLogger(FileWalkerUtil.class);

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.format("preVisitDirectory: %s\n", dir);
        logger.info(dir.toString());
        return super.preVisitDirectory(dir, attrs);
    }
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        //System.out.format("visitFile: %s\n", file);
        String[] FileTitle = file.getFileName().toString().split("\\.");
        //System.out.println(FileTitle.length);
        FileMetaData fileMetaData=new FileMetaData();
        fileMetaData.setFileName(FileTitle[0]);
        //fileMetaData.setContentType(FileTitle[1]);
        fileMetaData.setCreatedTime(attrs.creationTime());
        fileMetaData.setLastAccessTime(attrs.lastAccessTime());
        fileMetaData.setLastModifiedTime(attrs.lastModifiedTime());
        fileMetaData.setSize(attrs.size());
        fileMetaData.setPath(file.toString());
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//        byte[] array = new byte[7]; // length is bounded by 7
//        new Random().nextBytes(array);
//        String generatedString = new String(array, Charset.forName("UTF-8"));
        File jsonFile = new File("FileMetadata.json");
        if (!jsonFile.exists()) {
            jsonFile.createNewFile();

        }
        //objectMapper.writeValue(jsonFile, fileMetaData);
        String jsonInString = objectMapper.writeValueAsString(fileMetaData);
        Files.write(jsonFile.toPath(), Arrays.asList(jsonInString), StandardOpenOption.APPEND);
        logger.info(jsonInString);
        return super.visitFile(file, attrs);
    }
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        //System.out.format("visitFileFailed: %s\n", file);
        return super.visitFileFailed(file, exc);
    }
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        //System.out.format("postVisitDirectory: %s\n", dir);
        return super.postVisitDirectory(dir, exc);
    }

}
