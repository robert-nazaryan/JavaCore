package homeworks.braceChecker;

public class BraceCheckerDemo {
    public static void main(String[] args) {
        BraceChecker braceChecker = new BraceChecker("{ (} ) [) ]");
        braceChecker.check();
    }
}
