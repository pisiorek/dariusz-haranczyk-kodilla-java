package com.kodilla.hibernate.invoice.dao;


import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    ProductDao productDao;

    @Test
    public void testSaveProductToDatabase() {
       //Given
        Product product = new Product("Banan");

        //When
        productDao.save(product);

        //Then
        int id = product.getId();
        List<Product> readProduct = productDao.findById(id);

        Assert.assertEquals(1, readProduct.size());

        //Clear
        productDao.deleteById(id);



    }
}
