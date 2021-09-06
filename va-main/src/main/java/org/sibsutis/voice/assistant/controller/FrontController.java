package org.sibsutis.voice.assistant.controller;

import org.sibsutis.voice.assistant.alice.AliceRequestBody;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

    @PostMapping
    @RequestMapping("/alice")
    public ResponseEntity<String> process(@RequestBody String object) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            AliceRequestBody requestBody = objectMapper.readValue(object, AliceRequestBody.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok("All Right!");
    }

}
