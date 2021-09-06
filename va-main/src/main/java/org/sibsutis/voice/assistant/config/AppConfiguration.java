package org.sibsutis.voice.assistant.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import({AppInitializer.class})
@ComponentScan("org.sibsutis.voice.assistant")
@EnableWebMvc
public class AppConfiguration {
}
