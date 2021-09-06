package org.jmorphy;

import org.sibsutis.morphy.IntegerDAWG;

import java.io.IOException;
import java.io.InputStream;

public class ProbabilityEstimator {
    public static final String PROBABILITY_FILENAME = "p_t_given_w.intdawg";
    public static final String KEY_FORMAT = "%s:%s";
    public static final float MULTIPLIER = 1000000f;

    private final IntegerDAWG dict;

    public ProbabilityEstimator(FileLoader loader) throws IOException {
        InputStream stream = loader.newStream(PROBABILITY_FILENAME);
        dict = new IntegerDAWG(stream);
        stream.close();
    }

    public float getProbability(String word, Tag tag) {
        String key = String.format(KEY_FORMAT, word, tag);
        return dict.get(key, 0) / MULTIPLIER;
    }
}
