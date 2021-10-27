package org.sibsutis;

import org.noggit.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class JSONUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSONUtils.class);

    @SuppressWarnings("unchecked")
    public static Object parseJSON(InputStream stream) throws IOException {
        JSONParser parser = new JSONParser(new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8)));
        Deque<Object> stack = new LinkedList<>();
        Object obj = null, prevObj = null, container;
        int event;

        while ((event = parser.nextEvent()) != JSONParser.EOF) {
            switch (event) {
            case JSONParser.ARRAY_START:
                obj = new ArrayList<>();
                stack.addFirst(obj);
                continue;
            case JSONParser.OBJECT_START:
                obj = new HashMap<>();
                stack.addFirst(obj);
                continue;
            case JSONParser.STRING:
                obj = parser.getString();
                break;
            case JSONParser.LONG:
                obj = parser.getLong();
                break;
            case JSONParser.NUMBER:
                obj = parser.getDouble();
                break;
            case JSONParser.BOOLEAN:
                obj = parser.getBoolean();
                break;
            case JSONParser.NULL:
                parser.getNull();
                obj = null;
                break;
            case JSONParser.ARRAY_END:
            case JSONParser.OBJECT_END:
                obj = stack.removeFirst();
                if (stack.isEmpty()) {
                    return obj;
                }
                break;
            }

            container = stack.peekFirst();
            if (container instanceof List) {
                ((List<Object>) container).add(obj);
            }
            else if (container instanceof Map) {
                if (prevObj != null) {
                    ((Map<Object, Object>) container).put(prevObj, obj);
                    prevObj = null;
                }
                else {
                    prevObj = obj;
                    obj = null;
                }
            }
        }
        return obj;
    }

    public static void log() {
        LOGGER.debug("hello from jmorphy!");
    }

}
