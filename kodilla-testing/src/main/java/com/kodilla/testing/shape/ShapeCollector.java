package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
   ArrayList<Shape> shapeList = new ArrayList<>();

    //metoda dodająca do listy figurę
    public void addFigure(Shape shape){
        this.shapeList.add(shape);
    }
    //metoda usuwająca z listy figurę
    public void removeFigure(Shape shape){
        this.shapeList.remove(shape);
    }
    //metoda pobiera figurę z listy
    public  Shape getFigure(int n){
        return this.shapeList.get(n);
    }
    public  void showFigures(){
        for(int i=0; i<shapeList.size();i++) {
            System.out.println(shapeList.get(i));
        }
    }
    public int getListQuantity(){
        return shapeList.size();
    }
}
