package com.paypal.example.paypalandroidsdkexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by acer on 2017-01-04.
 */

public class secondActivity extends Activity{

    private static final String TAG=secondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        final TextView textview= (TextView) findViewById(R.id.textView);
        final StringBuilder msg = new StringBuilder("");

        final TextView mTextView = (TextView) findViewById(R.id.textView2);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.google.com";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.

                        Intent intent = getIntent();
                        Bundle b = intent.getExtras();
                        String username = b.getString("username");
                        String amount = b.getString("amount");
                        msg.append(username).append(". You have successfully transfered \n").append(amount);
                        textview.setText(msg);



                        mTextView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("That didn't work!");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);










    }
}
