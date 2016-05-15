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

REST :

Show all resources
```bash
   http://localhost:8080/REST/persons
```

Show size of resources
```bash
   http://localhost:8080/REST/persons/size
```

Add resource
```bash
   http://localhost:8080/REST/persons/add/{id}
```

Delete resource
```bash
   http://localhost:8080/REST/persons/delete/{id}
```
