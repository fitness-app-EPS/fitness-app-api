/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnessapp.utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import org.json.JSONObject;

/**
 *
 * @author Erox
 */
public class FCMNotification {
    // Method to send Notifications from server to client end.
		public final static String AUTH_KEY_FCM = "AAAAJABDkcI:APA91bFWFsxmOYAhkPEzBuxT5qs96LmpbsVe50AN07RRN7NGYgjzpVXDbDCX-8touSlbz-ciZMMe5qN2xymvm6l54uvWim-wN3ECGRYmrtwcQfiqgOe_v6GaFbcI5rMML-7IaCUEr2FE";
		public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

		public static void pushFCMNotification(String DeviceIdKey) throws Exception {

		    String authKey = AUTH_KEY_FCM; // You FCM AUTH key
		    String FMCurl = API_URL_FCM;

		    URL url = new URL(FMCurl);
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		    conn.setUseCaches(false);
		    conn.setDoInput(true);
		    conn.setDoOutput(true);

		    conn.setRequestMethod("POST");
		    conn.setRequestProperty("Authorization", "key=" + authKey);
		    conn.setRequestProperty("Content-Type", "application/json");
		    
		    JSONObject data = new JSONObject();
		    
		    data.put("to", DeviceIdKey.trim());
		    
		    
		    JSONObject info = new JSONObject();
		    
		    //notification message
		    //info.put("title", "FCM Notification Title"); // Notification title
		    //info.put("body", "Hello First Test notification"); // Notification body
		    //data.put("notification", info);
		    
		    //data message
		    info.put("title", "Fit 4 u notification"); // Notification title
		    info.put("body", "A new TAG has been created"); // Notification body
		    data.put("data", info);

		    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		    wr.write(data.toString());
		    wr.flush();
		    wr.close();

		    int responseCode = conn.getResponseCode();
		    System.out.println("Response Code : " + responseCode);

		    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    String inputLine;
		    StringBuffer response = new StringBuffer();

		    while ((inputLine = in.readLine()) != null) {
		        response.append(inputLine);
		    }
		    System.out.println("Response : " + response);
		    in.close();

		}
}
