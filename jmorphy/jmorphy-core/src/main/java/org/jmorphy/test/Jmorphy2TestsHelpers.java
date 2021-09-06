package org.jmorphy.test;

import org.jmorphy.MorphAnalyzer;
import org.jmorphy.ResourceFileLoader;

import java.io.IOException;
import java.util.Map;

public class Jmorphy2TestsHelpers {

    public static MorphAnalyzer newMorphAnalyzer()
            throws IOException
    {

        return new MorphAnalyzer.Builder<>()
                .fileLoader(new ResourceFileLoader("D:/VoiceAssistant/jmorphy/jmorphy-core/src/main/resources/org/jmorphy/dicts"))
                .charSubstitutes(null)
                .build();
    }

}
