package org.sibsutis.voice.assistant.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * @return дополнительные классы в корневом контексте приложения
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    /**
     * @return дополнительные классы в контексте сервлета
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * @return маппинг DispatcherServlet
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
