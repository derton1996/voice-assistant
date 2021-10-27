package org.sibsutis.voice.assistant.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sibsutis.voice.assistant.alice.AliceRequestBody;
import org.sibsutis.voice.assistant.service.FrontService;
import org.sibsutis.voice.assistant.service.FrontServiceImpl;
import org.sibsutis.voice.assistant.service.pattern.command.Switcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//invoker
@Controller
public class FrontController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FrontController.class);

    private final ObjectMapper objectMapper;
    private final FrontService frontService;
    private final Switcher switcher;

    @Autowired
    public FrontController(ObjectMapper objectMapper, FrontService frontService, Switcher switcher) {
        this.objectMapper = objectMapper;
        this.frontService = frontService;
        this.switcher = switcher;
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

    @PostMapping
    @RequestMapping("/light")
    public ResponseEntity<String> light() {
        LOGGER.info("Hello from controller!");
        switcher.toggle();
        return ResponseEntity.ok("ok");
    }

}
