package org.sibsutis.voice.assistant.service;

import org.jmorphy.MorphAnalyzer;
import org.sibsutis.voice.assistant.alice.AliceRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FrontServiceImpl implements FrontService {

    private final MorphAnalyzer analyzer;

    @Autowired
    public FrontServiceImpl(MorphAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    @Override
    public void doSomething(AliceRequestBody requestBody) {
        String allCommands = requestBody.getRequest().getCommand();

        //слова в списке в инфинитиве
        List<String> commandsList =
                Arrays.stream(allCommands.split(" "))
                        .map(command -> analyzer.parse(command).get(0).getNormalForm())
                        .collect(Collectors.toList());
        commandsList.forEach(System.out::println);

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

        InputStream conStream = null;
        try {
            con.setRequestMethod("GET");

            Map<String, String> parameters = new HashMap<>();
            parameters.put("value", "1");

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

        BufferedReader in = new BufferedReader(new InputStreamReader(conStream));
        try {
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
