package com.feelingtouch.networkprobe;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.net.ConnectivityManager;
import com.android.volley.*;
import com.android.volley.toolbox.*;
import java.io.*;
import java.net.*;
import android.util.*;

public class networkprobe extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Context mainCtx = getApplicationContext();

        TextView currNetwork = (TextView)findViewById(R.id.CurrNetwork);
        CharSequence cs = "当前网络：";
        currNetwork.setText(cs + Connectivity.getNetworkInfo(mainCtx).getTypeName());

        TextView isConnect = (TextView)findViewById(R.id.IsConnect);

        if(Connectivity.isConnected(mainCtx)){
            cs = "是否连接：是";
            isConnect.setText(cs);
        }
        else{
            cs = "是否连接：否";
            isConnect.setText(cs);
        }

        TextView isMobileConnect = (TextView)findViewById(R.id.isMobileConnect);
        if(Connectivity.isConnectedMobile(mainCtx)){
            cs = "是否使用蜂窝数据：是";
            isMobileConnect.setText(cs);
        }
        else{
            cs = "是否使用蜂窝数据：否";
            isMobileConnect.setText(cs);
        }


        TextView isConnectFast = (TextView)findViewById(R.id.IsConnectFast);
        if(Connectivity.isConnectedFast(mainCtx)){
            cs = "当前网速：快 (> 400kbs)";
            isConnectFast.setText(cs);
        }
        else{
            cs = "当前网速：慢 (< 400kbs)";
            isConnectFast.setText(cs);
        }

        final TextView hResultView = (TextView)findViewById(R.id.HttpResult);


        // Instantiate the RequestQueue.
//        RequestQueue queue = Volley.newRequestQueue(this);
////        String url ="http://114.215.141.238/Test/echo/echoHtml.php";
//        String url ="http://www.baidu.com";
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        // Display the first 500 characters of the response string.
//                        hResultView.setText("Response is: "+ response.substring(0,500));
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                hResultView.setText("That didn't work!");
//            }
//        });
//
//        queue.add(stringRequest);

        String txtMsg = "\r\n";
        DataOutputStream dos = null;
        BufferedReader dis = null;
        try {

            Log.d("ClientActivity", "Connecting...");
            Socket socket = new Socket("192.168.0.108", 7000);
            String data = "";

            try {
                Log.d("ClientActivity", "C: Sending command.");

                dos = new DataOutputStream(socket.getOutputStream());
                dis = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                dos.write(txtMsg.getBytes());
                Log.i("ClientActivity", "RequestMsg Sent");

                StringBuilder sb = new StringBuilder();

                while ((data = dis.readLine()) != null) {
                    sb.append(data);
                }
                Log.i("ClientActivity", "C: Sent.");
                Log.i("ClientActivity", "C: Received " + sb.toString());
            } catch (Exception e) {
                Log.e("ClientActivity", "S: Error", e);

            }

            socket.close();
            Log.d("ClientActivity", "C: Closed.");
        } catch (Exception e) {
            Log.e("ClientActivity", "C: Error", e);
        }
    }
}
