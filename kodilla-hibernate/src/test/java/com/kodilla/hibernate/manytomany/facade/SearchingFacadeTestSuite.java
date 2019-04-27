package com.kodilla.hibernate.manytomany.facade;
import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchingFacadeTestSuite {

    @Autowired
    private SearchingFacade searchingFacade;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;


    @Test
    public void testSearchingCompanyNameByPhrase(){
        //Given
        Company company1 = new Company("Polski Cukier ");
        int comp1Id = company1.getId();
        Company company2 = new Company("Popularne Niemieckie Samochody");
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
        List<Company> companies = searchingFacade.searchCompanyByPhrase("po");

        //Then
        Assert.assertEquals(3, companies.size());

        //Clean
        companyDao.deleteAll();
    }

    @Test
    public void testSearchingEmployeesByPhrase(){
        //Given
        Employee employee1 = new Employee("Jan","Kot");
        int employee1Id = employee1.getId();
        Employee employee2 = new Employee("Rafał","Kotowicz");
        int employee2Id = employee2.getId();
        Employee employee3 = new Employee("Janina","Markotna");
        int employee3Id = employee3.getId();
        Employee employee4 = new Employee("Paweł","Koc");
        int employee4Id = employee4.getId();

        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);
        employeeDao.save(employee4);

        //When
        List<Employee> employees = searchingFacade.searchEmployeeByPhrase("kot");

        for(Employee employee: employees){
            System.out.print("Nazwisko " + employee.getLastname() + "\n\n\n");
        }

        //Then
        Assert.assertEquals(3, employees.size());

        //Clean
        employeeDao.deleteAll();
    }
}
