package prithee;

public class TextUtil {

    public static boolean isWordToken(String token) {
        if (token == null) {
            return false;
        }

        String trimmed = token.trim();
        if (trimmed.length() == 0) {
            return false;
        }

        int i = 0;
        boolean hasLetterOrDigit = false;

        while (i < trimmed.length()) {
            char ch = trimmed.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                hasLetterOrDigit = true;
            }

            i = i + 1;
        }

        return hasLetterOrDigit;
    }

    public static String normalizeWord(String token) {
        if (token == null) {
            return "";
        }

        String lower = token.toLowerCase();

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < lower.length()) {
            char ch = lower.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                sb.append(ch);
            }

            i = i + 1;
        }

        return sb.toString();
    }

    public static String underscoresFor(String token) {
        String normalized = normalizeWord(token);

        if (normalized.length() == 0) {
            return "____";
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < normalized.length()) {
            sb.append("_");
            i = i + 1;
        }

        return sb.toString();
    }
}
