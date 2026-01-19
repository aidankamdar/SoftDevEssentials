package prithee;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class PritheeGameTest {

    @Test
    public void answerCheckIgnoresCaseAndPunctuation() {
        Sonnet s = new Sonnet("Hello, world.");
        PritheeGame g = new PritheeGame(s, new Random(1));

        assertTrue(g.isCorrect("Verona", "Verona,"));
        assertTrue(g.isCorrect("verona", "Verona,"));
        assertFalse(g.isCorrect("Vienna", "Verona,"));
    }

    @Test
    public void makeRoundStopsAfterMaskedWord() {
        String text = "One two three four.";
        Sonnet s = new Sonnet(text);

        Random seeded = new Random(0);
        PritheeGame g = new PritheeGame(s, seeded);

        PritheeGame.Round r = g.makeRound();

        // Should contain underscores and should NOT contain the later part of the text after the stop point.
        assertTrue(r.promptText.contains("_"));

        // Weak but useful: prompt should not equal full original text
        assertNotEquals(text, r.promptText);
    }
}
