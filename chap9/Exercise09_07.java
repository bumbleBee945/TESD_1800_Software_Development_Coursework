public class Exercise09_01 {
    public static void main(String[] args) {
        Rectangle rectA = new Rectangle(40.0, 4.0);
        printRectangle("A", rectA);
        Rectangle rectB = new Rectangle(35.9, 3.5);
        printRectangle("B", rectB);
        Rectangle[] rectArray = new Rectangle[10];
        for (int i = 0; i < 10; i++) {
            double rectheight = Math.random() * 11.0;
            double rectwidth = Math.random() * 11.0;
            rectArray[i] = new Rectangle(rectheight, rectwidth);
            printRectangle(Integer.toString(i + 1), rectArray[i]);
        }
    }
    static void printRectangle(String name, Rectangle object) {
        System.out.printf("          Rectangle %2s\n", name);
        System.out.printf("Height: %6.2f | Width : %6.2f\n", object.getHeight(), object.getWidth());
        System.out.printf("Area  : %6.2f | Perim.: %6.2f\n", object.getArea(), object.getPerimeter());
    }
}

class Rectangle {
    private double height;
    private double width;

    Rectangle() {
        this.height = 1.0;
        this.width = 1.0;
    }

    Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    double getHeight() { return this.height; }
    double getWidth() { return this.width; }
    double getArea() { return this.height * this.width; }
    double getPerimeter() { return this.height + this.width * 2.0; }

}