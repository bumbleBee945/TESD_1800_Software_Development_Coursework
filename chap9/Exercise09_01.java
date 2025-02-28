public class exercise0901 {
    public static void main(String[] args) {
        Rectangle[] rectArray = new Rectangle[10];
        for (i = 0; i < 10; i++) {
            double rectheight = Math.random() * 11.0;
            double rectwidth = Math.random() * 11.0;
            rectArray[i] = new Rectangle(rectheight, rectwidth);
            System.out.println("\tRectangle %2d", (i + 1));
            System.out.printf("Height: %6.2f | Weight: %6.2f\n", rectArray[i].getHeight(), rectArray[i].getWidth());
            System.out.printf("Area  : %6.2f | Perim.: %6.2f\n", rectArray[i].getArea(), rectArray[i].getPerimeter());
        }
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
    double getArea() { return this.height * this.width }
    double getPerimeter() { return this.height + this.width * 2.0 }

}