package org.jmorphy.units;

import org.jmorphy.ParsedWord;
import org.jmorphy.Tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NumberUnit extends AnalyzerUnit {
    private NumberUnit(Tag.Storage tagStorage, boolean terminate, float score) {
        super(tagStorage, terminate, score);
    }

    public static class Builder extends AnalyzerUnit.Builder {
        public Builder(boolean terminate, float score) {
            super(terminate, score);
        }

        @Override
        protected AnalyzerUnit newAnalyzerUnit(Tag.Storage tagStorage) {
            tagStorage.newGrammeme(Arrays.asList("NUMB", "", "ЧИСЛО", "число"));
            tagStorage.newGrammeme(Arrays.asList("intg", "", "цел", "целое"));
            tagStorage.newGrammeme(Arrays.asList("real", "", "вещ", "вещественное"));
            tagStorage.newTag("NUMB,intg");
            tagStorage.newTag("NUMB,real");
            return new NumberUnit(tagStorage, terminate, score);
        }
    }

    @Override
    public List<ParsedWord> parse(String word, String wordLower) {
        Tag tag = null;
        try {
            // First try to parse as an integer
            float number = Integer.parseInt(word);
            tag = tagStorage.getTag("NUMB,intg");
        } catch (NumberFormatException erInt) {
            try {
                // then as a float
                float number = Float.parseFloat(word);
                tag = tagStorage.getTag("NUMB,real");
            } catch (NumberFormatException ignored) {}
        }

        if (tag != null) {
            List<ParsedWord> parseds = new ArrayList<>();
            parseds.add(new AnalyzerParsedWord(word, tag, word, word, score));
            return parseds;
        }
        return null;
    }
}
