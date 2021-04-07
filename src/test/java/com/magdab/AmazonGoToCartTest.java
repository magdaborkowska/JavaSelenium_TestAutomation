package com.magdab;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AmazonGoToCartTest extends BaseTest{

    static final String AMAZON_PAGE_URL = "https://www.amazon.com/";
    static final String CART_BUTTON_ID = "nav-cart";
    static final String CART_PAGE_TXT_XPATH = "//*[@class='a-row sc-your-amazon-cart-is-empty']";


    @Test
    public void basicAmazonSorting(){

//        GO TO CART FROM MAIN PAGE TEST

        driver.get(AMAZON_PAGE_URL);
        driver.findElement(By.id(CART_BUTTON_ID)).click();
        Assert.assertTrue(waitForElementToBePresent(CART_PAGE_TXT_XPATH,5).isDisplayed());
    }
    private static WebElement waitForElementToBePresent(String xPath, long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    }
}



