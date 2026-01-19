package prithee;

import java.util.Random;

public class PritheeGameTest {

    public static void main(String[] args) {
        // test answer checking ignores case and punctuation
        Sonnet s = new Sonnet("Hello world");
        PritheeGame g = new PritheeGame(s, new Random(1));

        if (!g.isCorrect("Verona", "Verona,")) {
            System.out.println("Error: should ignore punctuation");
            return;
        }

        if (!g.isCorrect("verona", "Verona,")) {
            System.out.println("Error: should ignore case");
            return;
        }

        if (g.isCorrect("wrong", "Verona,")) {
            System.out.println("Error: wrong answer should fail");
            return;
        }

        // test that round creates underscores
        String text = "One two three";
        Sonnet sonnet = new Sonnet(text);
        PritheeGame game = new PritheeGame(sonnet, new Random(0));
        PritheeGame.Round round = game.makeRound();

        if (!round.promptText.contains("_")) {
            System.out.println("Error: should have underscores");
            return;
        }

        System.out.println("All tests passed!");
    }
}
