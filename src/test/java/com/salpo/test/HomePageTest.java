package com.salpo.test;

import com.salpo.pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.salpo.pages.HomePage;

import java.util.concurrent.TimeUnit;
import java.net.URL;

public class HomePageTest {

    WebDriver driver;

    @Before
    public void setup() throws Exception{

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    }

    @Test
    public void verifySearchResultAndNavigatedUrl() throws Exception{
        //Create object of HomePage Class
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals("59 search results for: crm",homePage.searchCRM("crm"));
        Assert.assertEquals("https://www.salpo.com/customer-relationship-management/integrations/ringcentral-crm-integration/",homePage.getCurrentURL());
        Assert.assertEquals("Salpo CRM + RingCentral",homePage.getTextSalpoHead());
    }

    @After
    public void close(){
      driver.close();
    }
}


