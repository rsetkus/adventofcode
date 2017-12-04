package lt.setkus.advenofcode2017.day4;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PassphraseTest {

    @Test
    public void whenInputConsistsFromOnlyUniqueValues_ThenShouldReturnTrue() throws Exception {
        assertTrue(Passphrase.isValidPassphrase("aaa bbb aa bb"));
    }

    @Test
    public void whenInputHasRepetitiveValues_ThenShouldReturnFalse() throws Exception {
        assertFalse(Passphrase.isValidPassphrase("aa bb cc dd aa"));
    }
}