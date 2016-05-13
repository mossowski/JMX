package com.moss.jmx;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import com.moss.jmx.mbean.ServiceMonitor;
import com.moss.jmx.mbean.ServiceStatsMonitor;
import com.moss.jmx.service.Service;

public class Main {
    
    public static void main(String[] args) throws Exception {

        Service service = new Service();
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName monitorName = new ObjectName("com.moss.jmx:type=Server,name=Service");
        ServiceMonitor sm = new ServiceMonitor(service);
        mbs.registerMBean(sm, monitorName);

        ObjectName statsMonitorName = new ObjectName("com.moss.jmx:type=Server,name=ServiceStats");
        ServiceStatsMonitor ssm = new ServiceStatsMonitor(service);
        mbs.registerMBean(ssm, statsMonitorName);

        while (true) {
            service.print();
            Thread.sleep(5000);
        }
    }

}
