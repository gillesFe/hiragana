package io.shodo.kata.hiragana;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public enum HiraganaTranscription {
    
    KYA("きゃ"), FU("ふ"), MI("み"), KA("か"), ZU("ず"), N("ん");
    
    private final String transcription;

    private HiraganaTranscription(String transcription) {
        this.transcription = transcription;
    }
    
    public static Optional<String> from(String value) {
        try {
            return Optional.of(HiraganaTranscription.valueOf(value.toUpperCase()).transcription);
        } catch (IllegalArgumentException exception) {
            return Optional.empty();
        }
    }

    public String getTranscription() {
        return transcription;
    }

    static boolean containsSymbol(String transcription) {
        return Arrays.asList(HiraganaTranscription.values())
                            .stream()
                            .map(HiraganaTranscription::getTranscription)
                            .collect(Collectors.joining())
                            .contains(transcription);
    }
    
}
