package org.sibsutis.voice.assistant.service;

import org.sibsutis.JSONUtils;
import org.sibsutis.MorphAnalyzer;
import org.sibsutis.voice.assistant.alice.AliceRequestBody;
import org.sibsutis.voice.assistant.devices.initializer.DeviceBehaviorBinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrontServiceImpl implements FrontService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FrontServiceImpl.class);

    private final MorphAnalyzer analyzer;
    private final DeviceBehaviorBinder deviceBehaviorBinder;

    @Autowired
    public FrontServiceImpl(MorphAnalyzer analyzer, DeviceBehaviorBinder deviceBehaviorBinder) {
        this.analyzer = analyzer;
        this.deviceBehaviorBinder = deviceBehaviorBinder;
    }

    @Override
    public void doSomething(AliceRequestBody requestBody) {
        String allCommands = requestBody.getRequest().getCommand();

        LOGGER.debug("logger is works!");
        JSONUtils.log();

        //слова в списке в инфинитиве
//        List<String> commandsList =
//                Arrays.stream(allCommands.split(" "))
//                        .map(command -> analyzer.parse(command).get(0).getNormalForm())
//                        .collect(Collectors.toList());
//         commandsList.forEach(System.out::println);

    }


}
