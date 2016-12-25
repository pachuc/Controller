package com.example.pachu.controller;
import org.json.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.converter.StringHttpMessageConverter;

public class APIMessenger {

    private String url;
    private int controllerNum;
    public APIMessenger(){
        url = "";
        controllerNum = 0;
    }
    public APIMessenger(String urlin){
        url = urlin;
        controllerNum = 0;
    }
    public APIMessenger(String urlin, int controllerin){
        url = urlin;
        controllerNum = controllerin;
    }

    public void getGameState(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        String result = restTemplate.getForObject(url, String.class, "Android");
        System.out.println(result);
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getControllerNum() {
        return controllerNum;
    }
    public void setControllerNum(int controllerNum) {
        this.controllerNum = controllerNum;
    }
}
