package org.sibsutis.voice.assistant.service;

import org.jmorphy.MorphAnalyzer;
import org.sibsutis.voice.assistant.alice.AliceRequestBody;
import org.sibsutis.voice.assistant.devices.initializer.DeviceBehaviorBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrontServiceImpl implements FrontService {

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

        //слова в списке в инфинитиве
//        List<String> commandsList =
//                Arrays.stream(allCommands.split(" "))
//                        .map(command -> analyzer.parse(command).get(0).getNormalForm())
//                        .collect(Collectors.toList());
//         commandsList.forEach(System.out::println);

    }


}
