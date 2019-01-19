package com.kodilla.testing.shape;

public class Triangle implements Shape {
      private String shapeName;
      private double a;
      private double h;

    @Override
    public String toString() {
        return "Triangle{" +
                "shapeName='" + shapeName + '\'' +
                ", a=" + a +
                ", h=" + h +
                '}';
    }

    public Triangle(String shapeName, double a, double h){
        this.shapeName = shapeName;
        this.a = a;
        this.h =h;
    }
    //klasy implementujace interfejs
    @Override
    public String getShapeName() {
        return this.shapeName;
    }

    @Override
    public double getField() {
        return 0.5 * a * h;
    }

    //klasy wygenerowane przez IntelliJ
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (Double.compare(triangle.a, a) != 0) return false;
        if (Double.compare(triangle.h, h) != 0) return false;
        return shapeName.equals(triangle.shapeName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = shapeName.hashCode();
        temp = Double.doubleToLongBits(a);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(h);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }


}
