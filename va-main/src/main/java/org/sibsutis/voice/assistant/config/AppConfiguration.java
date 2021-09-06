package org.sibsutis.voice.assistant.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jmorphy.MorphAnalyzer;
import org.jmorphy.helper.Jmorphy2TestsHelpers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;

@Configuration
@Import({AppInitializer.class})
@ComponentScan("org.sibsutis.voice.assistant")
@EnableWebMvc
public class AppConfiguration {

    @Bean
    public MorphAnalyzer analyzer() throws IOException {
        return Jmorphy2TestsHelpers.newMorphAnalyzer();
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

}
