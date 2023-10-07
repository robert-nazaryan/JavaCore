package homeworks;

public class Test {
    public static void main(String[] args) {
        printWordsByLength("kkk  jjjj    iii uu   rrrr  ", 4);
    }

    private static void printWordsByLength(String s, int l) {
        String[] strings = s.split(" ");
        for (String string : strings) {
            if(string.length() == l){
                System.out.println(string);
            }
        }
    }
}
