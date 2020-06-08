package io.shodo.kata.hiragana;

import java.util.Arrays;

public class HiraganaTranslation {
    
    private final String translation;

    private HiraganaTranslation(String translation) {
        this.translation = translation;
    }
    
    public String get() {
        return translation;
    }

    public static HiraganaTranslation from(String valueToTranslate) {
        String translation = buildTranslationFor(valueToTranslate);
        validate(translation);
        
        return new HiraganaTranslation(translation);
    }

    private static String buildTranslationFor(String valueToTranslate) {
        String translationInProgress = valueToTranslate;
        
        for(HiraganaTranscription hiraganaTranscription : Arrays.asList(HiraganaTranscription.values())) {
            translationInProgress = replaceWithHiraganaTranscription(translationInProgress, hiraganaTranscription);
        }
        
        return translationInProgress;
    }

    private static void validate(String translation) {
        for(String character : Arrays.asList(translation.split(""))) {
            hiraganaSymbolsContains(character);
        }
    }

    private static void hiraganaSymbolsContains(String symbol) {
        if (!HiraganaTranscription.containsSymbol(symbol)) {
            throw new HiraganaTranslationException("'" + symbol + "' is not an hiragana symbol");
        }
    }

    private static String replaceWithHiraganaTranscription(String translation, HiraganaTranscription hiraganaTranslation) {
        return translation.replaceAll(hiraganaTranslation.name().toLowerCase(), hiraganaTranslation.getTranscription());
    }

}
