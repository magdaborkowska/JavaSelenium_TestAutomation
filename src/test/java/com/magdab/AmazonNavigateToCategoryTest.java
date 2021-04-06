package com.magdab;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonNavigateToCategoryTest extends BaseTest{

    static final String AMAZON_HOME_PAGE_URL = "https://www.amazon.com/";
    static final String PICK_CATEGORY_MAIN_PAGE = "//img[@alt='Computers & Accessories' and @class='landscape-image']";
    static final String CATEGORY_PAGE_ELEMENT_XPATH = "//b[text()='Computers, Tablets and IT Accessories']";
    static final String PICK_SUBCATEGORY_NEXT_PAGE = "//a[@aria-label='COMPUTER ACCESSORIES']";
    static final String SUBCATEGORY_PAGE_ELEMENT_XPATH = "//span[text()='Audio & Video Accessories']";

    @Test
    public void basicAmazonNavigate(){

        driver.get(AMAZON_HOME_PAGE_URL);
        driver.findElement(By.xpath(PICK_CATEGORY_MAIN_PAGE)).click();
        Assert.assertTrue(waitForElementToBePresent(CATEGORY_PAGE_ELEMENT_XPATH,3).isDisplayed());
        driver.findElement(By.xpath(PICK_SUBCATEGORY_NEXT_PAGE)).click();
        Assert.assertTrue(waitForElementToBePresent(SUBCATEGORY_PAGE_ELEMENT_XPATH,5).isDisplayed());
    }

    private static WebElement waitForElementToBePresent(String xPath, long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    }
}



