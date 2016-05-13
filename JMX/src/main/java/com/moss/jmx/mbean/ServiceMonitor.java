package com.moss.jmx.mbean;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

import com.moss.jmx.service.Service;


public class ServiceMonitor extends NotificationBroadcasterSupport implements ServiceMonitorMBean {

    private Service service;
    private int sequenceNumber = 0;

    public ServiceMonitor(Service service) {
        this.service = service;
    }

    @Override
    public void setSize(int size) {

        if (size > service.getMaxSize()) {
            Notification notification = new AttributeChangeNotification(this, sequenceNumber++,
                    System.currentTimeMillis(), "Przekroczenie poziomu", "size", "int", service.getSize(), size);
            notification.setUserData("zmiana levelu na " + size);
            sendNotification(notification);

        }
        service.setSize(size);
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[] {AttributeChangeNotification.ATTRIBUTE_CHANGE};

        String name = AttributeChangeNotification.class.getName();
        String description = "Zmiana wartosci atrybutu";
        MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[] {info};
    }

    @Override
    public int getSize() {
        return service.getSize();
    }

    @Override
    public int getMaxSize() {
        return service.getMaxSize();
    }
    
    @Override
    public void clear() {
       service.setMaxSize(10);
    }

}
