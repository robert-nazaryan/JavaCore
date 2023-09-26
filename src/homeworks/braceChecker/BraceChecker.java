package homeworks.braceChecker;

public class BraceChecker {
    private String text;

    BraceChecker(String text) {
        this.text = text;
    }

    public void check() {
        CharsStack chars = new CharsStack();
        for (int i = 0; i < text.length(); i++) {
            if (isOpeningBrace(text.charAt(i))) {
                chars.push(text.charAt(i));
            } else if (!chars.isStackEmpty() && isClosingBrace(text.charAt(i))) {
                char openingBrace = chars.pop();
                if (!isValidBraces(text.charAt(i), openingBrace)) {
                    System.err.println("Error: opened " + openingBrace + " but closed " + text.charAt(i) + " at " + i);
                }
            }
        }
        while (!chars.isStackEmpty()) {
            System.err.println("Errpr: opened " + chars.pop() + " but not closed");
        }
    }

    private boolean isOpeningBrace(char c) {
        if (c == '{' || c == '[' || c == '(') {
            return true;
        }
        return false;
    }

    private boolean isClosingBrace(char c) {
        if (c == '}' || c == ']' || c == ')') {
            return true;
        }
        return false;
    }

    private boolean isValidBraces(char closingBrace, char openingBrace) {
        if ((closingBrace == '}' && openingBrace == '{') || (closingBrace == ']' && openingBrace == '[')
                || (closingBrace == ')' && openingBrace == '(')) {
            return true;
        }
        return false;
    }
}
