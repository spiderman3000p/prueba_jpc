package com.developments.vunterslaush.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.call);
        Button btn2 = (Button) findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callService();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);
            }
        });

    }

    public void callService(){
        final TextView response1 = (TextView)findViewById(R.id.response1);
        final TextView response2 = (TextView) findViewById(R.id.response2);


        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://httpbin.org/get";
        String response;


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        try {
                            JSONObject json = new JSONObject(response);
                            response1.setText(json.getString("origin"));
                            StringBuffer str = new StringBuffer(json.getString("origin"));
                            response2.setText(str.reverse());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }




                        //response1.setText(response.toString());
                        //StringBuffer str = new StringBuffer(response.toString());
                        //response1.setText(str.reverse());

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                response1.setText("Error!");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }



}
