package lt.setkus.advenofcode2017.day1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CaptchaTest {

    @Test
    public void whenSimpleSequenceProvided_ThenShouldSumNextDigits() {
        assertEquals(3, Captcha.capture("1122"));
    }

    @Test
    public void whenSequenceOfSameNumber_ThenShouldSumAllOfThem() {
        assertEquals(4, Captcha.capture("1111"));
    }

    @Test
    public void whenAllwaysNextDigitIsDifferent_ThenTheSumShouldBeZero() {
        assertEquals(0, Captcha.capture("1234"));
    }

    @Test
    public void firstDigitShouldBeTreatedAsTheNextOfTheLastDigit() {
        assertEquals(9, Captcha.capture("91212129"));
    }
}