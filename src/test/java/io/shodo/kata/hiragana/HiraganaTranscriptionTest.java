package io.shodo.kata.hiragana;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HiraganaTranscriptionTest {

    @Test
    void should_return_hiragana_translation() throws Exception {
        assertThat(HiraganaTranscription.from("mi").get()).isEqualTo("み");
    }
    
    @Test
    void should_not_return_hiragana_translation_when_hiragana_not_exists() throws Exception {
        assertThat(HiraganaTranscription.from("test")).isEmpty();
    }
    
    @Test
    void should_return_true_when_hiragana_traslation_is_found() throws Exception {
        assertThat(HiraganaTranscription.containsSymbol("み")).isTrue();
    }
    
    @Test
    void should_return_false_when_hiragana_traslation_is_unknown() throws Exception {
        assertThat(HiraganaTranscription.containsSymbol("test")).isFalse();
    }
    
}
