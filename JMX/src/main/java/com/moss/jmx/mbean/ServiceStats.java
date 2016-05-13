package com.moss.jmx.mbean;

import java.beans.ConstructorProperties;

public class ServiceStats {

    private int size;
    private int maxSize;

    public int getSize() {
        return size;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public ServiceStats() {
        super();
    }

    @ConstructorProperties({"size", "maxSize"})
    public ServiceStats(int size, int maxSize) {
        super();
        this.size = size;
        this.maxSize = maxSize;
    }

}
