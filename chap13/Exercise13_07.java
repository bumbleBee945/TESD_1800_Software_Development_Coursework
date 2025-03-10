/*
Author: Aiden Olsen
Date: 03/10/2025

This program is for an interface how to color example
 */

public class Exercise13_07 {
    public static void main(String[] args) {
        GeometricObject[] objectArray = new GeometricObject[5];
        for (int i = 0; i < 5; i++)
            objectArray[i] = new Triangle(
                    20+(Math.random() * 30), 20+(Math.random() * 30), 20+(Math.random() * 30),
                    true, "white");
        for (int i = 0; i < 5; i++) {
            System.out.printf("Triangle %d's Area is %.4f.\n", i+1, objectArray[i].getArea());
            if (objectArray[i] instanceof Colorable)
                objectArray[i].howToColor();
        }
    }
}

interface Colorable {
    public abstract void howToColor();
}

class Triangle extends GeometricObject implements Colorable {
    //attributes
    private double side1;
    private double side2;
    private double side3;

    //constructors
    public Triangle() {}
    public Triangle(double side1, double side2, double side3, boolean filled, String color) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.setFilled(filled);
        this.setColor(color);
    }

    //accessors
    public double getSide1() { return this.side1; }
    public double getSide2() { return this.side2; }
    public double getSide3() { return this.side3; }

    //mutators
    public void setSides(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    //methods
    public double getArea() {
        double temp = (this.side1 + this.side2 + this.side3) / 2.0;
        return Math.sqrt(temp * (temp - this.side1) * (temp - this.side2) * (temp - this.side3));
    }
    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }
}
abstract class GeometricObject {
    //attributes
    private String color;
    private boolean filled;
    private java.util.Date dateCreated = new java.util.Date();

    //constructors
    protected GeometricObject() {}
    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    //accessors
    public String getColor() { return this.color; }
    public boolean isFilled() { return this.filled; }
    public java.util.Date getDateCreated() { return this.dateCreated; }

    //mutators
    public void setColor(String color) { this.color = color; }
    public void setFilled(boolean filled) { this.filled = filled; }

    //methods
    public void howToColor() {
        System.out.print("Color all three sides\n");
    }

    @Override
    public String toString() {
        return "Created on: " + this.dateCreated + " Color: " + this.color + " Filled: " + this.filled;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
}
