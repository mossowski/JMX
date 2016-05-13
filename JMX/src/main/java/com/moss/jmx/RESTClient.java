package com.moss.jmx;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class RESTClient {

    public static int getSize() {
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://localhost:8080/REST/").path("persons/size");
        Invocation.Builder builder = webTarget.request();
        Response response = builder.get();
        return response.readEntity(Integer.class);
    }

}
