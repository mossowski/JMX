# JMX

Uruchomienie :

REST
```bash
   mvn package jetty:run
```

JMX-Main
```bash
   mvn compile exec:exec
```

JMX-Client
```bash
   mvn compile exec:java -Dexec.mainClass=com.moss.jmx.Client
```

VisualVM
```bash
   service:jmx:rmi:///jndi/rmi://:9999/jmxrmi
```
