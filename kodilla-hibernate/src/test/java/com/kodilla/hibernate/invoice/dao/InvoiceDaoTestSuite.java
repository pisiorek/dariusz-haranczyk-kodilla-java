package com.kodilla.hibernate.invoice.dao;


import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    ItemDao itemDao;

    @Test
    public void testSaveProductToDatabase() {
       //Given
        Item item = new Item(new BigDecimal(10), 10, new BigDecimal(100));
        item.setProduct(new Product("Mango"));

        //When
        itemDao.save(item);


        //Then
        int id = item.getId();
        Assert.assertNotEquals(0, id);

        //Clear
        //itemDao.deleteById(id);

    }
}
