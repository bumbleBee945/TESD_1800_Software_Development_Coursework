/*
Author: Aiden Olsen
Date: 03/06/2025

This program is for a geometry inheritance example
 */

import java.util.Scanner;

public class Exercise11_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter three sides (4.23, 23.49, 0.39)\n[-] ");
        double givenValue1 = input.nextDouble();
        double givenValue2 = input.nextDouble();
        double givenValue3 = input.nextDouble();
        System.out.print("What's the color? (white, purple, blue)\n[-] ");
        String givenValue4 = input.next();
        System.out.print("Is it filled? (true, false)\n[-] ");
        boolean givenValue5 = input.nextBoolean();
        Triangle triangle = new Triangle(givenValue1, givenValue2, givenValue3);
        triangle.setColor(givenValue4);
        triangle.setFilled(givenValue5);
        System.out.printf(
                "\tGenerated a triangle.\n" +
                "Area: %.2f\n" +
                "Perimeter: %.2f\n" +
                "Color: %s\n" +
                "Filled: %b\n" +
                "Date Created: %s\n",
                triangle.getArea(), triangle.getPerimeter(), triangle.getColor(),
                triangle.getFilled(), triangle.getDateCreated().toString());
    }
}

class GeometricObject {
    //attributes
    protected String color;
    protected boolean filled;
    protected java.util.Date dateCreated = new java.util.Date();

    //constructors
    public GeometricObject() {}

    //accessors
    public boolean getFilled() { return this.filled; }
    public String getColor() { return this.color; }
    public java.util.Date getDateCreated() { return this.dateCreated; }

    //mutators
    public void setFilled(boolean filled) { this.filled = filled; }
    public void setColor(String color) { this.color = color; }
}

class Triangle extends GeometricObject {
    //attributes
    private double side1;
    private double side2;
    private double side3;

    //constructors
    public Triangle() {}
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    //accessors
    public double getSide1() { return this.side1; }
    public double getSide2() { return this.side2; }
    public double getSide3() { return this.side3; }

    //methods
    public double getArea() {
        double temp = (this.side1 + this.side2 + this.side3) / 2.0;
        double area = Math.sqrt(temp * (temp - this.side1) * (temp - this.side2) * (temp - this.side3));
        return area;
    }
    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }
    public String toString() {
        return "Triangle: side1 = " + this.side1 + " side2 = " + this.side2 + " side3 = " + this.side3;
    }
}