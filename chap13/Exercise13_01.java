/*
Author: Aiden Olsen
Date: 03/10/2025

This program is for a geometry abstract class example
 */

import java.util.Scanner;

public class Exercise13_01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String givenValue;
        Triangle triangle;
        double[] side = new double[3];
        boolean filled;
        String color;
        boolean programLoop = true;
        do {
            boolean whileLoop = true;
            while (whileLoop) {
                System.out.print("[-] Please enter three sides (4, 4.5, 6.4)\n[-] ");
                givenValue = input.nextLine();
                if (givenValue.matches("[0-9]+(|.[0-9]+)\\s[0-9]+(|.[0-9]+)\\s[0-9]+(|.[0-9]+)")) {
                    whileLoop = false;
                    Scanner givenInput = new Scanner(givenValue);
                    for (int i = 0; i < side.length; i++) {
                        side[i] = givenInput.nextDouble();
                        if (side[i] <= 0) {
                            System.out.printf("[-] Side %d must be above 0.\n", i);
                            whileLoop = true;
                        }
                    }
                } else
                    System.out.print("[-] Invalid input.\n");
            }
            while (true) {
                System.out.print("[-] Is the triangle filled? true/false\n[-] ");
                givenValue = input.nextLine().toLowerCase();
                if (givenValue.equals("true") || givenValue.equals("false"))
                    break;
                System.out.print("[-] Invalid input\n");
            }
            filled = Boolean.parseBoolean(givenValue);
            System.out.print("[-] What color is the triangle?\n[-] ");
            color = input.nextLine().toLowerCase();
            triangle = new Triangle(side[0], side[1], side[2], filled, color);
            System.out.print("\n\n[-] Triangle complete.");
            System.out.print("\n\n\t\t[Triangle Specs]");
            System.out.print("\n\t[Date Created] " + triangle.getDateCreated());
            System.out.print("\n\t[Filled] " + triangle.isFilled());
            System.out.print("\n\t[Color] " + triangle.getColor());
            System.out.print("\n\t[Side 1] " + triangle.getSide1());
            System.out.print("\n\t[Side 2] " + triangle.getSide2());
            System.out.print("\n\t[Side 3] " + triangle.getSide3());
            System.out.print("\n\t[Perimeter] " + triangle.getPerimeter());
            System.out.print("\n\t[Area] " + triangle.getArea() + "\n\n");
            while (true) {
                System.out.print("[1] Go Again\n[2] Exit Program\n[-] ");
                givenValue = input.nextLine();
                if (givenValue.equals("1")) {
                    break;
                } else if (givenValue.equals("2")) {
                    programLoop = false;
                    break;
                } else {
                    System.out.print("[-] Invalid input\n");
                }
            }
        } while (programLoop);
    }
}

class Triangle extends GeometricObject {
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
    @Override
    public String toString() {
        return "Created on: " + this.dateCreated + " Color: " + this.color + " Filled: " + this.filled;
    }
    public abstract double getArea();
    public abstract double getPerimeter();
}
