/*
Author: Aiden Olsen
Date: 03/10/2025

This program is for a clone and compare octagon example
 */

public class Exercise13_11 {
    public static void main(String[] args) {
        Octagon octagon = new Octagon(4.50);
        System.out.println("[-] Made an octagon with eight 4.50u sides");
        Octagon octagon2 = (Octagon)octagon.clone();
        System.out.println("[-] Cloned octagon to octagon2");
        System.out.println("[-] octagon == octagon2: " + (octagon == octagon2));
        System.out.println("[-] octagon.equals(octagon2): " + (octagon.equals(octagon2)));
        System.out.println("[-] octagon.compareTo(octagon2): " + octagon.compareTo(octagon2));
    }
}

class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon> {
    //attributes
    double[] side = new double[8];

    //constructors
    public Octagon() {
        for (int i = 0; i < 8; i ++)
            this.side[i] = 5.00;
    }
    public Octagon(double length) {
        for (int i = 0; i < 8; i ++)
            this.side[i] = length;
    }

    //accessors
    public double getSide(int side) { return this.side[side]; }

    //mutators
    public void setSide(int side, double length) { this.side[side] = length; }
    public void setSideAll(double length) {
        for (int i = 0; i < 8; i ++)
            this.side[i] = length;
    }

    //methods
    public double getPerimeter() {
        double result = 0.00;
        for (int i = 0; i < 8; i++)
            result += this.side[i];
        return result;
    }
    public double getArea() {
        double temp = 2 + (4/Math.sqrt(2));
        return temp * this.side[0] * this.side[0];
    }
    @Override
    public int compareTo(Octagon o) {
        int matchingSides = 0;
        for (int i = 0; i < 8; i++)
            if (this.side[i] == o.side[i])
                matchingSides++;
        if (this.getColor().equals(o.getColor()) && (this.isFilled() == o.isFilled()) && matchingSides == 8)
            return 0; //fully identical
        if (this.getArea() >= o.getArea())
            return 1; //this is bigger
        return -1; //o is bigger
    }
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

abstract class GeometricObject {
    //attributes
    private String color = "unset";
    private boolean filled = false;
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

