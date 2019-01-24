package com.kodilla.testing.shape;

public class Circle implements Shape {

    final double PI = 3.14;
    final  double SQUARE = 2;
    private String shapeName;
    private  double r;

    public Circle(String shapeName, double r){
        this.shapeName = shapeName;
        this.r = r;
    }
    //klasy implementujace interfejs
    @Override
    public String getShapeName() {
        return this.shapeName;
    }
    @Override
    public double getField() {
        return PI * Math.pow( r , SQUARE );
    }

    //klasy wygenerowane przez IntelliJ
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        if (Double.compare(circle.r, r) != 0) return false;
        return shapeName.equals(circle.shapeName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = shapeName.hashCode();
        temp = Double.doubleToLongBits(r);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "shapeName='" + shapeName + '\'' +
                ", r=" + r +
                '}';
    }


}
