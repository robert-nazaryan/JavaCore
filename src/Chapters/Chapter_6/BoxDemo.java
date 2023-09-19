package Chapters.Chapter_6;

public class BoxDemo {
    public static void main(String[] args) {
        Box box1 = new Box(10, 20, 15);
        Box box2 = new Box(3, 6, 9);


        System.out.println("Volume is: " + box1.volume());
        System.out.println("Volume is: " + box2.volume());
    }
}
