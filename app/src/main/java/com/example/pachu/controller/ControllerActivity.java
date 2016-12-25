package com.example.pachu.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputType;
import android.view.View;

public class ControllerActivity extends AppCompatActivity {

    private APIMessenger api = new APIMessenger();
    private AppCompatEditText address;
    private AppCompatButton submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);
        address = (AppCompatEditText) findViewById(getResources().getIdentifier("AddressText", "id", getPackageName()));
        submit = (AppCompatButton) findViewById(getResources().getIdentifier("connectButton", "id", getPackageName()));

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = address.getText().toString();
                api.setUrl(url);
                System.out.println("URL set to " + url);
                new AsyncApiCall().execute("test");

            }
        });

    }

    private class AsyncApiCall extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params){
            System.out.println(params[0]);
            api.getGameState();
            return "Executed";
        }
        @Override
        protected void onPostExecute(String result){}
        @Override
        protected void onPreExecute(){}
        @Override
        protected void onProgressUpdate(Void... values){}
    }
}
