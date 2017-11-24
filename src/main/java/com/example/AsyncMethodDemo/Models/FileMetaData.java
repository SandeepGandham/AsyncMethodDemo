package com.example.AsyncMethodDemo.Models;

import java.nio.file.attribute.FileTime;


public class FileMetaData {

    String fileName;
    String contentType;
    FileTime createdTime;
    FileTime lastAccessTime;
    FileTime lastModifiedTime;
    long size;
    String path;


    public String getFileName(){
        return  fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public FileTime getCreatedTime() {
        return createdTime;
    }

    public FileTime getLastAccessTime() {
        return lastAccessTime;
    }

    public FileTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public long getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setCreatedTime(FileTime createdTime) {
        this.createdTime = createdTime;
    }

    public void setLastAccessTime(FileTime lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public void setLastModifiedTime(FileTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
