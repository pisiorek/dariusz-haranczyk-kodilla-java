package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testSearchingEmployeeWithGivenLastname(){

        //Given
        Employee employee1 = new Employee("Jan","Kot");
        Employee employee2 = new Employee("Ewa","Pies");
        Employee employee3 = new Employee("Marek","Kot");
        Employee employee4 = new Employee("Jan","Kot");
        Employee employee5 = new Employee("Zbigniew","Mucha");

        employeeDao.save(employee1);
        int emplId1 = employee1.getId();
        employeeDao.save(employee2);
        int emplId2 = employee2.getId();
        employeeDao.save(employee3);
        int emplId3 = employee3.getId();
        employeeDao.save(employee4);
        int emplId4 = employee4.getId();
        employeeDao.save(employee5);
        int emplId5 = employee5.getId();

        //When
        List<Employee> searchingLastname = employeeDao.retrieveEmployeeWithGivenLastname("Kot");

        //Then
        try {
            Assert.assertEquals(3, searchingLastname.size());

        } finally {
            //CleanUp
            employeeDao.deleteById(emplId1);
            employeeDao.deleteById(emplId2);
            employeeDao.deleteById(emplId3);
            employeeDao.deleteById(emplId4);
            employeeDao.deleteById(emplId5);
        }
    }

    @Test
    public void testSearchingCompaniesWithGivenName(){

        //Given
        Company company1 = new Company("Polski Cukier");
        int comp1Id = company1.getId();

        Company company2 = new Company("Niemieckie Samochody");
        int comp2Id = company2.getId();

        Company company3 = new Company("Polskie Mleko");
        int comp3Id = company3.getId();

        Company company4 = new Company("Szwajcarskie Sery");
        int comp4Id = company4.getId();

        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);
        companyDao.save(company4);

        //When
        List<Company> searchingCompanyByName = companyDao.retrieveCompanyByName("Szw");

        //Then
        try {
            Assert.assertEquals(1, searchingCompanyByName.size());

        } finally {

            //CleanUp
/*          companyDao.deleteById(comp1Id);
            companyDao.deleteById(comp2Id);
            companyDao.deleteById(comp3Id);
            companyDao.deleteById(comp4Id);*/
        }
    }
}
