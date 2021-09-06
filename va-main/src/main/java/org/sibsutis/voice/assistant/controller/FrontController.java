package org.sibsutis.voice.assistant.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sibsutis.voice.assistant.alice.AliceRequestBody;
import org.sibsutis.voice.assistant.service.FrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontController {

    private final ObjectMapper objectMapper;
    private final FrontService frontService;

    @Autowired
    public FrontController(ObjectMapper objectMapper, FrontService frontService) {
        this.objectMapper = objectMapper;
        this.frontService = frontService;
    }


    @PostMapping
    @RequestMapping("/alice")
    public ResponseEntity<String> process(@RequestBody String object) {
        try {
            AliceRequestBody requestBody = objectMapper.readValue(object, AliceRequestBody.class);
            frontService.doSomething(requestBody);
            return ResponseEntity.ok("All Right!");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Something wrong");
        }

    }

}
