package org.example;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpActions {
    private String uri;
    private HttpRequest httpRequest; //used to describe what type of data does httpClient want
    private HttpClient httpClient;  //used to send HTTP Requests
    private HttpResponse<String> httpResponse; //holds the data from the request that httpClient sends out


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
                    .GET()  //gets data from the site without changing anything
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
