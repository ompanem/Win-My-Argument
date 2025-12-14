package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpActions {
    private String uri;
    private HttpRequest httpRequest;
    private HttpClient httpClient;
    private HttpResponse<String> httpResponse;
    public HttpActions(String uri)
    {
        httpClient = HttpClient.newHttpClient();
        this.uri = uri;
        initHttpRequest();
        httpResponse = getHttpResponse();

    }

    public void initHttpRequest()
    {
        try{
            httpRequest = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .GET()
                    .build();
        } catch (URISyntaxException e) {
            System.out.println("Link didn't open properly");
        }
    }

    public HttpResponse<String> getHttpResponse(){
        try{
            return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println("Error occured");
        }
        return null;

    }

    public String getXml(){
        return httpResponse.body();
    }

    int getStatusCode(){
        return httpResponse.statusCode();
    }
}
