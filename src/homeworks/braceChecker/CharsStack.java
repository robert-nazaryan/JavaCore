package homeworks.braceChecker;

public class CharsStack {
    private char[] stck = new char[10];
    private int tos;

    CharsStack() {
        tos = -1;
    }

    public void push(char item) {
        if (tos == 9) {
            extend();
        } else {
            stck[++tos] = item;
        }
    }

    public char pop() {
        if (tos < 0) {
            System.out.println("Stack is empty");
            return 0;
        } else {
            return stck[tos--];
        }
    }

    public boolean isStackEmpty() {
        if (tos == -1) {
            return true;
        }
        return false;
    }

    private void extend() {
        char[] newStck = new char[stck.length + 10];
        for (int i = 0; i < stck.length; i++) {
            newStck[i] = stck[i];
        }
        stck = newStck;
    }
}
