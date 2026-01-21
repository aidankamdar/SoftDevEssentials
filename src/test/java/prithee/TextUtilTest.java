package prithee;

class TextUtilTest {

    void normalizeRemovesPunctuation() {
        String result = TextUtil.normalizeWord("Verona,");
        if (!result.equals("verona")) {
            System.out.println("FAIL: normalize failed");
        }
    }

    void underscoresMatchLength() {
        String result = TextUtil.underscoresFor("Verona,");
        if (!result.equals("______")) {
            System.out.println("FAIL: underscores failed");
        }
    }

    void isWordTokenDetectsWords() {
        if (!TextUtil.isWordToken("Verona,")) {
            System.out.println("FAIL: word detection failed");
        }
        if (TextUtil.isWordToken(" ")) {
            System.out.println("FAIL: space should not be a word");
        }
    }
}
