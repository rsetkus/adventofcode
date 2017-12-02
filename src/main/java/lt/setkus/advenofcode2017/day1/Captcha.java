package lt.setkus.advenofcode2017.day1;

public class Captcha {

    private static final String PUZZLE_INPUT = "52288333363558485499154593667379825983129595838174556215459" +
            "767847924894681983659982327227348766123323523761928135529498142759475757743395298119766443615177955" +
            "869983192422416148136227342557975695715776992385926672874281663982215728858694164196826877597439784" +
            "345718212671465143383946245256483387399294799123681726698855773197183892781687668444879487616974387" +
            "225568578824332243937231312988762526266435172368839991156656569355216757728665161858993171324947167" +
            "236154934763971156276878876651947817463773414689959545545182529168592273976938852543296288123556124" +
            "875944455223958535517345674988383822486161379696379713696154435999735883263887928939699248553164379" +
            "523134925516715457142627847383435171665441971945471735151559272441754472964742821541149511816483178" +
            "758275258144537588461945488727899433722819529952227791738124441864911154264761886722532497444789468" +
            "633179151368321991328689178912435911957193547211291162291646882568536283392339196714687819131674156" +
            "242141527938645853329444684288491718768734336215242422894881356753135444982454986374241391537829257" +
            "237452497287438854938777926485766731968899495683172341258633691879537886118413883539998755191728963" +
            "295243465272652317678688396966933282733817727267829491661129329543569237574851393672986999229849259" +
            "777249729442779916868232192959397343138748348617961795916591747264323575331138962127815666591549394" +
            "198667974883474485517194816325722316324635755915996963882233442192283251342332385388542894377563318" +
            "488872424233875422146911572267251796836389674156786976251381776334447651262238854783489513326343982" +
            "916121348528586839424661783299226558222254265343591916961776331679628398479858266769554174266171262" +
            "882553661231691746743484179321582913346467676377643232268427715235985624293999357897882159583673624" +
            "676524448541239519721183584176296794549786873371376754952957684517196319993986178282876719375849986" +
            "979594258458831457363238182251293118459972149876634333756896217466656291872525116439693152833162692" +
            "22835744532431378945137649959158495714472963839397214332815241141327714672141875129895";

    public int captureHalfWayRound(String s) {
        return computeAnswer(s, s.toCharArray().length / 2);
    }

    public int capture(String input) {
        return computeAnswer(input, 1);
    }

    private int computeAnswer(String input, int move) {
        int sum = 0;
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            char next = chars[getNexPosition(chars.length, i, move)];
            if (current == next) {
                sum += Character.digit(current, 10);
            }
        }

        return sum;
    }

    private int getNexPosition(int length, int currentPosition, int move) {
        int nexPosition;
        int temp = (currentPosition + move) - length;
        if (temp < 0) {
            nexPosition = length - Math.abs(temp);
        } else {
            nexPosition = temp;
        }

        return nexPosition;
    }

    public static void main(String[] args) {
        Captcha captcha = new Captcha();
        int firstAnswer = captcha.capture(PUZZLE_INPUT);
        int secondAnswer = captcha.captureHalfWayRound(PUZZLE_INPUT);

        System.out.printf(
                "First star answer: %d" +
                "\nSecond start answer: %d",
                firstAnswer,
                secondAnswer
        );
    }
}
