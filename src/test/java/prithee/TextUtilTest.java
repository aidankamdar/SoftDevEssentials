package prithee;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TextUtilTest {

    @Test
    public void normalizeStripsPunctuationAndLowercases() {
        assertEquals("verona", TextUtil.normalizeWord("Verona,"));
        assertEquals("starcrossd", TextUtil.normalizeWord("star-cross'd"));
        assertEquals("hours", TextUtil.normalizeWord("hours'"));
    }

    @Test
    public void underscoresMatchesNormalizedLength() {
        assertEquals("______", TextUtil.underscoresFor("Verona,"));
        assertEquals("__________", TextUtil.underscoresFor("star-cross'd"));
    }

    @Test
    public void isWordTokenDetectsWordishThings() {
        assertTrue(TextUtil.isWordToken("Verona,"));
        assertTrue(TextUtil.isWordToken("love,"));
        assertFalse(TextUtil.isWordToken(" "));
        assertFalse(TextUtil.isWordToken("\n"));
    }
}
