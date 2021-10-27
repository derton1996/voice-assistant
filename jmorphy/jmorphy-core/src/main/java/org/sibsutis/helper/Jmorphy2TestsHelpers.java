package org.sibsutis.helper;

import org.sibsutis.MorphAnalyzer;
import org.sibsutis.ResourceFileLoader;

import java.io.IOException;

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
