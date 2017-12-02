package lt.setkus.advenofcode2017.day1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CaptchaTest {

    private Captcha captcha;

    @Before
    public void setUp() {
        captcha = new Captcha();
    }

    @Test
    public void whenSimpleSequenceProvided_ThenShouldSumNextDigits() {
        assertEquals(3, captcha.capture("1122"));
    }

    @Test
    public void whenSequenceOfSameNumber_ThenShouldSumAllOfThem() {
        assertEquals(4, captcha.capture("1111"));
    }

    @Test
    public void whenAlwaysNextDigitIsDifferent_ThenTheSumShouldBeZero() {
        assertEquals(0, captcha.capture("1234"));
    }

    @Test
    public void firstDigitShouldBeTreatedAsTheNextOfTheLastDigit() {
        assertEquals(9, captcha.capture("91212129"));
    }

    @Test
    public void whenAllDigitsMatchByHalfWayMovesAhead_ThenShouldSumAllOfThem() {
        assertEquals(6, captcha.captureHalfWayRound("1212"));
        assertEquals(12, captcha.captureHalfWayRound("123123"));
        assertEquals(4, captcha.captureHalfWayRound("123425"));
        assertEquals(4, captcha.captureHalfWayRound("12131415"));
    }

    @Test
    public void whenNoneDigitsMatchByHalfWay_ThenShouldProduceZero(){
        assertEquals(0, captcha.captureHalfWayRound("1221"));
    }
}