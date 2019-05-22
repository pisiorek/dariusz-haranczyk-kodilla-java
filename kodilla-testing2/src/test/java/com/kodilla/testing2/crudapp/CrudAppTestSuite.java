package com.kodilla.testing2.crudapp;

import config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://pisiorek.github.io/";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTests(){
        driver = WebDriverConfig.getdriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        generator = new Random();

       /* driverTrello = WebDriverConfig.getdriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);*/
    }

    @After
    public void cleanUpAfterTest()  throws NoAlertPresentException, InterruptedException{

        Thread.sleep(2000);
        driver.close();

    }

    public String createCrudAppTestTask() throws NoAlertPresentException, InterruptedException {
        final  String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
        final  String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final  String XPATH_ADD_BUTTON = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }

    public void sendTestTaskToTrello(String taskName) throws NoAlertPresentException, InterruptedException {

        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed());

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                            .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });

        Thread.sleep(5000);

    }

    private boolean checkTaskExistInTrello(String taskName) throws NoAlertPresentException, InterruptedException {

        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getdriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("dariuszharanczyk");
        driverTrello.findElement(By.id("password")).sendKeys("maciek2000");
        driverTrello.findElement(By.id("login")).submit();

        Thread.sleep(2000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Bootcamp\"]")).size() > 0)
                .forEach(aHref -> aHref.click());

        Thread.sleep(2000);

        result = driverTrello.findElements(By.xpath("//span")).stream()
                .filter(theSpan -> theSpan.getText().contains(taskName))
                .collect(Collectors.toList())
                .size() > 0;

        driverTrello.close();

        return result;
    }

    public void removeTaskFromCrudApp(String taskName) throws NoAlertPresentException, InterruptedException{

        driver.switchTo().alert().accept();
        driver.navigate().refresh();

        Thread.sleep(2000);

        final  String XPATH_REMOVE_BUTTON = "/html/body/main/section[2]/div/form[1]/div/fieldset[1]/button[4]";

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(anyForm -> anyForm.findElement(By.xpath(".//button[4]")).click());

        Thread.sleep(2000);
    }

    @Test
    public  void shouldCreateTrelloCard() throws  InterruptedException{
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        Thread.sleep(5000);
        removeTaskFromCrudApp(taskName);
        assertTrue(checkTaskExistInTrello(taskName));


    }
}