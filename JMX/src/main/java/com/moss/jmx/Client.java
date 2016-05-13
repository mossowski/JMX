package com.moss.jmx;

import java.io.IOException;

import javax.management.AttributeChangeNotification;
import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import com.moss.jmx.mbean.ServiceMonitorMBean;


public class Client {

    public static class ClientListener implements NotificationListener {
        public void handleNotification(Notification notification,
                                       Object handback) {
            echo("\nReceived notification:");
            echo("\tClassName: " + notification.getClass().getName());
            echo("\tSource: " + notification.getSource());
            echo("\tType: " + notification.getType());
            echo("\tMessage: " + notification.getMessage());
            if (notification instanceof AttributeChangeNotification) {
                AttributeChangeNotification acn =
                    (AttributeChangeNotification) notification;
                echo("\tAttributeName: " + acn.getAttributeName());
                echo("\tAttributeType: " + acn.getAttributeType());
                echo("\tNewValue: " + acn.getNewValue());
                echo("\tOldValue: " + acn.getOldValue());
            }
        }
    }

    public static void main(String[] args) throws Exception {

        echo("\nOpening connection to server");
        JMXServiceURL url =
            new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);

        ClientListener listener = new ClientListener();

        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

        ObjectName mxbeanName =
            new ObjectName("com.moss.jmx:type=Server,name=Service");
        
        mbsc.addNotificationListener(mxbeanName, listener, null, null);

        
        ServiceMonitorMBean mxbeanProxy =
            JMX.newMXBeanProxy(mbsc, mxbeanName, ServiceMonitorMBean.class);

        int size = RESTClient.getSize();
        mxbeanProxy.setSize(size);

        echo("\nWaiting for notification...");

        waitForEnterPressed();


        echo("\nClose the connection to the server");
        jmxc.close();
        echo("\nBye! Bye!");
    }

    private static void echo(String msg) {
        System.out.println(msg);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void waitForEnterPressed() {
        try {
            echo("\nPress <Enter> to continue...");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
