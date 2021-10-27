package org.sibsutis.units;

import org.sibsutis.ParsedWord;
import org.sibsutis.Tag;

import java.util.Arrays;
import java.util.List;


public class UnknownUnit extends AnalyzerUnit {
    private UnknownUnit(Tag.Storage tagStorage, boolean terminate, float score) {
        super(tagStorage, terminate, score);
    }

    public static class Builder extends AnalyzerUnit.Builder {
        public Builder(boolean terminate, float score) {
            super(terminate, score);
        }

        @Override
        protected AnalyzerUnit newAnalyzerUnit(Tag.Storage tagStorage) {
            tagStorage.newGrammeme(Arrays.asList("UNKN", "", "НЕИЗВ", "неизвестное"));
            tagStorage.newTag("UNKN");
            return new UnknownUnit(tagStorage, terminate, score);
        }
    }

    @Override
    public List<ParsedWord> parse(String word, String wordLower) {
        return Arrays.asList(
            new AnalyzerParsedWord(word, tagStorage.getTag("UNKN"), word, word, score)
        );
    }
}
