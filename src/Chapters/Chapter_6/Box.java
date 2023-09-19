package Chapters.Chapter_6;

public class Box {
    double width;
    double height;
    double depth;

    Box(double width, double height, double depth){
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    double volume() {
        return width * height * depth;
    }

    void setDim(double w, double h, double d){
        width = w;
        height = h;
        depth = d;
    }
}
