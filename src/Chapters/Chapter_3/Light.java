package Chapters.Chapter_3;

public class Light {
    public static void main(String[] args) {
        int lightspeed;
        long days;
        long seconds;
        long dinstance;

        lightspeed = 186000;
        days = 1000;
        seconds = days * 24 * 60 * 60;
        dinstance = lightspeed * seconds;

        System.out.print("In " + days);
        System.out.print(" days light will be trevel about ");
        System.out.println(dinstance + " miles.");

    }
}
