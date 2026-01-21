package prithee;

import java.util.Random;

class PritheeGameTest {

    void answerCheckIgnoresCase() {
        Sonnet s = new Sonnet("Hello world");
        PritheeGame g = new PritheeGame(s, new Random(1));
        if (!g.isCorrect("verona", "Verona,")) {
            System.out.println("FAIL: should ignore case");
        }
    }

    void answerCheckIgnoresPunctuation() {
        Sonnet s = new Sonnet("Hello world");
        PritheeGame g = new PritheeGame(s, new Random(1));
        if (!g.isCorrect("Verona", "Verona,")) {
            System.out.println("FAIL: should ignore punctuation");
        }
    }

    void makeRoundCreatesUnderscores() {
        String text = "One two three";
        Sonnet s = new Sonnet(text);
        PritheeGame g = new PritheeGame(s, new Random(0));
        PritheeGame.Round r = g.makeRound();
        if (!r.promptText.contains("_")) {
            System.out.println("FAIL: should have underscores");
        }
    }
}
