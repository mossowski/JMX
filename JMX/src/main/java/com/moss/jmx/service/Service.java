package com.moss.jmx.service;

import com.moss.jmx.RESTClient;

public class Service {

    private int size;
    public  int maxSize;
    
    public Service() {
        size = RESTClient.getSize();
        maxSize = 10;
    }

    public void print() {
        setSize(RESTClient.getSize());
        System.out.println("Operating...");
        System.out.println("Size: " + size);
        System.out.println("MaxSize: " + maxSize);
    }

    public int getSize() {
        return size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public int getMaxSize() {
        return maxSize;
    }
    
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
    
}
