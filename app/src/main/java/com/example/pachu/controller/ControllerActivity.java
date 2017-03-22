package com.example.pachu.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ControllerActivity extends AppCompatActivity {

    private APIMessenger api = new APIMessenger();
    private EditText gameid;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);
        gameid = (EditText) findViewById(R.id.gameID);
        submit = (Button) findViewById(R.id.connectButton);
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

    public void api_connection(View view){
        //String url = address.getText().toString();
        //api.setUrl(url);
        //System.out.println("URL set to " + url);
        //new AsyncApiCall().execute("test");
        String game_id = gameid.getText().toString().toUpperCase();
        System.out.println(game_id);
        api.setGame_id(game_id);
        Intent intent = new Intent(this, UIActivity.class);
        startActivity(intent);
    }
}
