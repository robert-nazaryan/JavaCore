package homeworks.figurePainter;

public class FigurePainter {
    void figureOne() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void figureTwo(int n, char c) {
        for (int i = n; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    void figureThree(char c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i - 1; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    void figureFour() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i - 1; j++) {
                System.out.print("  ");
            }
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    void figureFive(int n, char c) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
