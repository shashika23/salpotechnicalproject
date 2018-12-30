package com.salpo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;

    private static String PAGE_URL="https://www.salpo.com";

    @FindBy(how = How.CSS, using = "li#menu-item-search > a")
    private WebElement searchIcon;

    @FindBy(how = How.CSS, using = "input#s")
    private WebElement searchTextBox;

    @FindBy(how = How.CSS, using = "input#searchsubmit")
    private WebElement searchButton;

    @FindBy(how = How.CSS, using = "div#main main > h4")
    private WebElement searchResultHeadLink;

    @FindBy(how = How.CSS, using = "div#main article.post-entry.post-entry-type-standard.post-loop-1.post-parity-odd.custom.page.type-page.status-publish.hentry > div > header > h2 > a")
    private WebElement firstResultSelection;

    @FindBy(how = How.CSS, using = "div#av_section_1 h1")
    private WebElement salpoNavigatedHead;




    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public String searchCRM(String searchText)throws Exception{

        String searchResultText = null;

        searchIcon.click();
        searchTextBox.sendKeys(searchText);
        searchButton.click();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
        if(searchResultHeadLink.isDisplayed()) {
            searchResultText = searchResultHeadLink.getText().trim();
        }else{
            searchResultText = " search result element is not loaded";
        }

        return searchResultText;
    }


    public String getTextSalpoHead()throws Exception{
        return salpoNavigatedHead.getText().trim();
    }

    public String getCurrentURL()throws Exception{

        firstResultSelection.click();
        return  driver.getCurrentUrl().trim();
    }
}