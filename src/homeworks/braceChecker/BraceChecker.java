package homeworks.braceChecker;

public class BraceChecker {
    private String text;

    BraceChecker(String text) {
        this.text = text;
    }

    public void check() {
        CharsStack chars = new CharsStack();

        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case '{', '(', '[':
                    chars.push(text.charAt(i));
                    break;
                case '}', ')', ']':
                    if (!chars.isStackEmpty()) {
                        char openingBrace = chars.pop();
                        if (!isPairedBraces(text.charAt(i), openingBrace)) {
                            System.err.println("Error: opened " + openingBrace + " but closed " + text.charAt(i) + " at " + i);
                        }
                    } else {
                        System.err.println("Error: closed " + text.charAt(i) + " but not opened");
                    }
            }

        }
        while (!chars.isStackEmpty()) {
            System.err.println("Errpr: opened " + chars.pop() + " but not closed");
        }
    }

    private boolean isPairedBraces(char closingBrace, char openingBrace) {
        if ((closingBrace == '}' && openingBrace == '{') || (closingBrace == ']' && openingBrace == '[')
                || (closingBrace == ')' && openingBrace == '(')) {
            return true;
        }
        return false;
    }
}
