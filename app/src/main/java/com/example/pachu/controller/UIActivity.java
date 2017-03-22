package com.example.pachu.controller;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.util.Log;
import com.jmedeisis.bugstick.Joystick;
import com.jmedeisis.bugstick.JoystickListener;

import org.json.JSONObject;

public class UIActivity extends AppCompatActivity {

    private ControllerState cs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        cs = new ControllerState();
        //event listener on joystick
        Joystick joystick = (Joystick) findViewById(R.id.joystick);
        joystick.setJoystickListener(new JoystickListener() {
            @Override
            public void onDown() {
                System.out.println("Joystick down");
            }

            @Override
            public void onDrag(float degrees, float offset) {
                cs.setJoystick(degrees, offset);
            }

            @Override
            public void onUp() {
                cs.setJoystick(0, 0);
            }
        });
        //on a button
        Button Abutton = (Button) findViewById(R.id.abutton);
        Abutton.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    cs.setA(true);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    cs.setA(false);
                }
                return false;
            }
        });
        //on b button
        Button Bbutton = (Button) findViewById(R.id.bbutton);
        Bbutton.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    cs.setB(true);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    cs.setB(false);
                }
                return false;
            }
        });
        //etc
        Button Xbutton = (Button) findViewById(R.id.xbutton);
        Xbutton.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    cs.setX(true);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    cs.setX(false);
                }
                return false;
            }
        });
        //etc
        Button Ybutton = (Button) findViewById(R.id.ybutton);
        Ybutton.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    cs.setY(true);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    cs.setY(false);
                }
                return false;
            }
        });
        //call async task to continuously post the controller state.
        new AsyncControllerState().execute("");
    }

    private class AsyncControllerState extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params){
            try{
                while(true){
                    JSONObject json = cs.getControllerState();
                    Thread.sleep(1);
                }
            }
            catch (Exception e){

            }
            return "";

        }
        @Override
        protected void onPostExecute(String result){}
        @Override
        protected void onPreExecute(){}
        @Override
        protected void onProgressUpdate(Void... values){}
    }


}
