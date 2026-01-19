package prithee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PritheeGame {

    private final Sonnet sonnet;
    private final Random rng;

    public PritheeGame(Sonnet sonnet, Random rng) {
        this.sonnet = sonnet;
        this.rng = rng;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        int correct = 0;
        int incorrect = 0;

        while (correct < 3 && incorrect < 3) {
            Round round = this.makeRound();

            System.out.print(round.promptText);
            System.out.println();
            System.out.print("Next word? ");

            String user = sc.nextLine();

            boolean ok = isCorrect(user, round.expectedWord);

            if (ok) {
                correct = correct + 1;
                System.out.println("Correct.");
            } else {
                incorrect = incorrect + 1;
                System.out.println("Incorrect. Expected: " + round.expectedWord);
            }

            System.out.println("Score -> correct: " + correct + ", incorrect: " + incorrect);
            System.out.println();
        }

        if (correct >= 3) {
            System.out.println("You got 3 correct. Nice.");
        } else {
            System.out.println("You got 3 incorrect. Game over.");
        }
    }

    public boolean isCorrect(String userInput, String expectedWordToken) {
        String a = TextUtil.normalizeWord(userInput);
        String b = TextUtil.normalizeWord(expectedWordToken);

        return a.equals(b);
    }

    public Round makeRound() {
        List<String> tokens = this.sonnet.getTokens();
        List<Integer> wordTokenIndexes = new ArrayList<Integer>();

        int i = 0;
        while (i < tokens.size()) {
            String tok = tokens.get(i);

            if (TextUtil.isWordToken(tok)) {
                wordTokenIndexes.add(i);
            }

            i = i + 1;
        }

        int choice = this.rng.nextInt(wordTokenIndexes.size());
        int stopTokenIndex = wordTokenIndexes.get(choice);

        String expected = tokens.get(stopTokenIndex);

        StringBuilder printed = new StringBuilder();
        int j = 0;

        while (j < stopTokenIndex) {
            printed.append(tokens.get(j));
            j = j + 1;
        }

        printed.append(TextUtil.underscoresFor(expected));

        Round r = new Round();
        r.promptText = printed.toString();
        r.expectedWord = expected;

        return r;
    }

    public static class Round {
        public String promptText;
        public String expectedWord;
    }
}
