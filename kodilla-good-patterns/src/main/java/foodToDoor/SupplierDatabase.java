package foodToDoor;

import java.util.ArrayList;
import java.util.List;

public class SupplierDatabase {
    List<Supplier> suppliers = new ArrayList<Supplier>();

    public List addSupplier(Supplier supplier){
        suppliers.add(supplier);
        System.out.println("New company: " + supplier.getCompanyName() + " has been added to SupplierDatabase");
        return suppliers;
    }
}
