package com.kodilla.good.patterns.foodtodoor;

import java.util.ArrayList;
import java.util.List;

public class SupplierDatabase {

    public  List<Supplier> suppliers = new ArrayList<Supplier>();

    public void addSupplier(Supplier supplier){
        suppliers.add(supplier);
        System.out.println("New company: " + supplier.getCompanyName() + " has been added to SupplierDatabase");
    }

    public  Supplier getSupplier(int index){
        return suppliers.get(index);
    }
}
