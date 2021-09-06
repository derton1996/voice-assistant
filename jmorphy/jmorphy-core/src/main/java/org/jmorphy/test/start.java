package org.jmorphy.test;

import org.jmorphy.MorphAnalyzer;
import org.jmorphy.ParsedWord;

import java.io.IOException;
import java.util.List;

public class start {

    public static void main(String[] args) throws IOException {
        MorphAnalyzer analyzer = Jmorphy2TestsHelpers.newMorphAnalyzer();
        List<ParsedWord> result = analyzer.parse("сигарету");
        System.out.println(result);
    }

}
