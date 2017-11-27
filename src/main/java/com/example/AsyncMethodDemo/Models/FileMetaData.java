package com.example.AsyncMethodDemo.Models;

import java.nio.file.attribute.FileTime;
import java.util.Date;


public class FileMetaData {

    String fileName;
    String contentType;
    String createdTime;
    String lastAccessTime;
    String lastModifiedTime;
    long size;
    String path;
    String parent;



    public String getFileName(){
        return  fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public String getLastAccessTime() {
        return lastAccessTime;
    }

    public String getLastModifiedTime() {
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

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public void setLastAccessTime(String lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public void setLastModifiedTime(String lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getParent() {return parent;    }

    public void setParent(String parent) {this.parent = parent;}
}
