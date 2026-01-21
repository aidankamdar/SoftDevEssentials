Prithee (HW1)

Overview
This program prints a fixed sonnet, stops at a random word, replaces that word with underscores, and stops printing the rest. The user must type the next word. The game continues until the user gets 3 correct or 3 incorrect.

Design
- `Sonnet` stores the source text and tokenizes it into "word tokens" while preserving punctuation.
- `TextUtil` provides:
  - normalization (lowercase, strip punctuation)
  - masking logic (build the partial printed output)
- `PritheeGame` runs the loop:
  - picks a random word index
  - prints sonnet up to that word (masked) and stops
  - prompts and checks user input
  - tracks correct/incorrect counts


Testing
The project includes JUnit tests that verify:
- normalization and punctuation handling
- masking output stops correctly
- answer checking ignores case/punctuation
