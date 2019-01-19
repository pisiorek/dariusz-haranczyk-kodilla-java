package com.kodilla.testing.shape;

public class Square implements Shape {
    private String shapeName;
    private int a;
    private int b;

    public Square(String shapeName, int a, int b){
        this.shapeName = shapeName;
        this.a = a;
        this.b = b;
    }

    //klasy implementujace interfejs
    @Override
    public String getShapeName() {
        return this.shapeName;
    }
    @Override
    public double getField() {
        return a * b;
    }

    @Override
    public String toString() {
        return "Square{" +
                "shapeName='" + shapeName + '\'' +
                ", a=" + a +
                ", b=" + b +
                '}';
    }

    //klasy wygenerowane przez IntelliJ
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if (a != square.a) return false;
        if (b != square.b) return false;
        return shapeName.equals(square.shapeName);
    }

    @Override
    public int hashCode() {
        int result = shapeName.hashCode();
        result = 31 * result + a;
        result = 31 * result + b;
        return result;
    }


}
