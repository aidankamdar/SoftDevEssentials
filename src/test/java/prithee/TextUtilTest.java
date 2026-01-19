package prithee;

public class TextUtilTest {

    public static void main(String[] args) {
        // test normalize removes punctuation and lowercases
        String result = TextUtil.normalizeWord("Verona,");
        if (!result.equals("verona")) {
            System.out.println("Error: normalize failed");
            return;
        }

        // test underscores
        String underscores = TextUtil.underscoresFor("Verona,");
        if (!underscores.equals("______")) {
            System.out.println("Error: underscores failed");
            return;
        }

        // test word detection
        if (!TextUtil.isWordToken("Verona,")) {
            System.out.println("Error: word token detection failed");
            return;
        }

        if (TextUtil.isWordToken(" ")) {
            System.out.println("Error: space should not be a word");
            return;
        }

        System.out.println("All tests passed!");
    }
}
