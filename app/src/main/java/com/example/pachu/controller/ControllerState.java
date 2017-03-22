package com.example.pachu.controller;
import org.json.JSONObject;

public class ControllerState {

    private float joystickAngle, joystickOffset;
    private boolean A, B, X, Y;
    public ControllerState(){
        A = B = X = Y = false;
        joystickAngle = joystickOffset = 0;
    }
    public void setA(boolean a) {A = a;}
    public void setB(boolean b) {B = b;}
    public void setX(boolean x) {X = x;}
    public void setY(boolean y) {Y = y;}
    public void setJoystick(float ja, float jo){
        joystickAngle = ja;
        joystickOffset = jo;
    }
    public JSONObject getControllerState(){
        JSONObject json = new JSONObject();
        try {
            json.put("Joystick Offset", joystickOffset);
            json.put("Joystick Angle", joystickAngle);
            json.put("A Button", A);
            json.put("B Button", B);
            json.put("X Button", X);
            json.put("Y Button", Y);
        }
        catch (Exception e){
            System.out.println("An exception occured: " + e);
        }
        return json;
    }
}
