package io.shodo.kata.hiragana;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HiraganaTranslationTest {

	// links :
	// https://fr.wikipedia.org/wiki/Hiragana
	// https://www.japanophone.com/main/home/index
	// example : write => Fumikazu => ふみかず
	
	@Test
	void should_return_symbol_from_one_syllabe_with_two_letters() throws Exception {
	    assertThat(HiraganaTranslation.from("fu").get()).isEqualTo("ふ");
	}
	
	@Test
    void should_return_symbols_from_two_syllabes_with_two_letters() throws Exception {
        assertThat(HiraganaTranslation.from("fumi").get()).isEqualTo("ふみ");
    }
	
	@Test
    void should_return_symbols_from_three_syllabes_with_two_letters() throws Exception {
        assertThat(HiraganaTranslation.from("fumika").get()).isEqualTo("ふみか");
    }
	
	@Test
    void should_return_symbols_from_four_syllabes_with_two_letters() throws Exception {
        assertThat(HiraganaTranslation.from("fumikazu").get()).isEqualTo("ふみかず");
    }
	
	@Test
    void should_return_symbol_from_one_syllabe_with_three_letters() throws Exception {
        assertThat(HiraganaTranslation.from("kya").get()).isEqualTo("きゃ");
    }
	
	@Test
    void should_return_symbols_from_two_syllabes_with_three_and_two_letters() throws Exception {
        assertThat(HiraganaTranslation.from("kyazu").get()).isEqualTo("きゃず");
    }
	
	@Test
    void should_return_symbol_from_one_syllabe_with_one_letter() throws Exception {
        assertThat(HiraganaTranslation.from("n").get()).isEqualTo("ん");
    }
	
	@Test
    void should_return_symbols_from_three_syllabes_with_one_two_and_three_letters() throws Exception {
        assertThat(HiraganaTranslation.from("nzukya").get()).isEqualTo("んずきゃ");
    }
	
	@Test
    void should_thow_runtime_exception_when_syllabe_has_no_correspondence() throws Exception {
	    
        Assertions.assertThatThrownBy(() -> {
            HiraganaTranslation.from("nZ");
        })
        .isInstanceOf(RuntimeException.class)
        .hasMessage("'Z' is not an hiragana symbol");
    }
}
