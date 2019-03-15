package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave(){

        Item item = new Item(new BigDecimal(10), 10, new BigDecimal(100));
        Item item1 = new Item(new BigDecimal(15), 10, new BigDecimal(150));

        item.setProduct(new Product("Gruszka"));
        item1.setProduct(new Product("Mleko"));

        Invoice invoice = new Invoice("AA/01");

        invoice.getItems().add(item);
        invoice.getItems().add(item1);

        item.setInvoice(invoice);
        item1.setInvoice(invoice);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        Assert.assertNotEquals(0, id);

        //CleanUp
        invoiceDao.deleteById(id);


    }
}
