package com.moss.jmx.mbean;

import javax.management.MXBean;

@MXBean
public interface ServiceStatsMonitorInterface {

    ServiceStats getServiceStats();

}
