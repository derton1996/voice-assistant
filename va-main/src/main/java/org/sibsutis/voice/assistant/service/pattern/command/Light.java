package org.sibsutis.voice.assistant.service.pattern.command;

import org.jmorphy.MorphAnalyzer;
import org.sibsutis.voice.assistant.service.ParameterStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

//receiver
@Service
public class Light {

    private static final String ON = "0";
    private static final String OFF = "1";

    public void on() {
        send(ON);
    }

    public void off() {
        send(OFF);
    }

    private void send(String state) {
        URL url = null;
        try {
            url = new URL("http://blynk-cloud.com/exOSi8EAEVpZq73CYJbpCuwmHgwtd6eY/update/V1");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            con.setRequestMethod("GET");

            Map<String, String> parameters = new HashMap<>();
            parameters.put("value", state);

            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.connect();

            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
            out.flush();
            out.close();

            int status = con.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.disconnect();
        }
    }

}
