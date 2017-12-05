package lt.setkus.advenofcode2017.day4;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PassphraseTest {

    @Test
    public void whenInputConsistsFromOnlyUniqueValues_ThenShouldReturnTrue() throws Exception {
        assertTrue(Passphrase.simpleValidation("aaa bbb aa bb"));
    }

    @Test
    public void whenInputHasRepetitiveValues_ThenShouldReturnFalse() throws Exception {
        assertFalse(Passphrase.simpleValidation("aa bb cc dd aa"));
    }

    @Test
    public void whenInputConsistsOfTwoWOrdsWhichAreAnagrams_ThenShouldReturnFalse() throws Exception {
        assertFalse(Passphrase.enhancedValidation("abcde xyz ecdab"));
        assertFalse(Passphrase.enhancedValidation("oiii ioii iioi iiio"));
    }

    @Test
    public void whenInputIsPureOfUniqueWords_ThenShouldReturnTrue() throws Exception {
        assertTrue(Passphrase.enhancedValidation("a ab abc abd abf abj"));
        assertTrue(Passphrase.enhancedValidation("iiii oiii ooii oooi oooo"));
    }
}