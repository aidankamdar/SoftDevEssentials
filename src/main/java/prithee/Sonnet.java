package prithee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sonnet {

    private final String text;
    private final List<String> tokens;

    public Sonnet(String text) {
        this.text = text;
        this.tokens = tokenize(text);
    }

    public String getText() {
        return this.text;
    }

    public List<String> getTokens() {
        return Collections.unmodifiableList(this.tokens);
    }

    private List<String> tokenize(String t) {
        List<String> out = new ArrayList<String>();

        StringBuilder current = new StringBuilder();
        int i = 0;

        while (i < t.length()) {
            char ch = t.charAt(i);

            boolean isSpace = Character.isWhitespace(ch);

            if (isSpace) {
                if (current.length() > 0) {
                    out.add(current.toString());
                    current.setLength(0);
                }
                out.add(String.valueOf(ch));
            } else {
                current.append(ch);
            }

            i = i + 1;
        }

        if (current.length() > 0) {
            out.add(current.toString());
        }

        return out;
    }

    public int countWordTokens() {
        int count = 0;
        int i = 0;

        while (i < this.tokens.size()) {
            String tok = this.tokens.get(i);

            if (TextUtil.isWordToken(tok)) {
                count = count + 1;
            }

            i = i + 1;
        }

        return count;
    }
}
