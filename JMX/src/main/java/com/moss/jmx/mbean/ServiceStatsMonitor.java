package com.moss.jmx.mbean;

import com.moss.jmx.service.Service;

public class ServiceStatsMonitor implements ServiceStatsMonitorInterface {

    private Service service;

    public ServiceStatsMonitor(Service service) {
        this.service = service;
    }

    @Override
    public ServiceStats getServiceStats() {
        return new ServiceStats(service.getSize(), service.getMaxSize());
    }

}
