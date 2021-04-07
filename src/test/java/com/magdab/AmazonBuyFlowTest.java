package com.magdab;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonBuyFlowTest extends BaseTest{

    static final String AMAZON_HOME_PAGE_URL = "https://www.amazon.com/";
    static final String DELIVER_TO_BUTTON_ID = "nav-global-location-popover-link";
    static final String DELIVER_TO_LIST_XPATH = "//span[@role='radiogroup' and @data-action='a-dropdown-button']";
    static final String PICK_POLAND_XPATH = "//a[@id='GLUXCountryList_178' and text()='Poland']";
    static final String CONFIRM_POLAND_BUTTON_XPATH = "//button[@name='glowDoneButton' and text()='Done']";

    static final String DROP_DOWN_SEARCH_IN_XPATH = "//*[@id='nav-search-dropdown-card']/div";
    static final String CATEGORY_PICK_XPATH = "//*[@value='search-alias=music-intl-ship']";
    static final String SEARCH_FIELD_ID = "twotabsearchtextbox";
    static final String SEARCH_BUTTON_ID = "nav-search-submit-button";
    static final String SEARCH_TERM = "Led Zeppelin vinyl";
    static final String SORT_BY_LIST_XPATH = "//span[@data-action and @aria-hidden]";
    static final String SORT_BY_NEWEST_ID = "s-result-sort-select_4";
    static final String RESULT_SELECT_XPATH = "(//*[@class='a-section aok-relative s-image-fixed-height'])[1]";
    static final String BY_IT_NOW_XPATH = "//*[@id='buy-now-button']";
    static final String SIGN_IN_TEXT_XPATH = "//h1[contains(text(),'Sign-In')]";


    @Test

    public void basicAmazonBuyFlow(){

    /* BUY FLOW TEST - FROM SEARCH TO BUY:
     IF FAILS, TRY AGAIN - SOMETIMES THIS PAGE IS NOT STABLE, MOST OF THE CASES IT WORKS
     - MAIN FUNCTIONALITIES CHECKED: CHANGE COUNTRY, SEARCH, FILTER, ADD TO CART
     - pick the country
     - pick the category in search field
     - type term to search, send
     - get the results
     - filter results, from newest, to avoid case when item sold out
     - pick item and add to cart
     - go to the checkout page (end at the SIGN IN page, to avoid fake account usage, typically should go further) */

        driver.get(AMAZON_HOME_PAGE_URL);
        driver.findElement(By.id(DELIVER_TO_BUTTON_ID)).click();
        waitForElementToBePresent(DELIVER_TO_LIST_XPATH,3).click();
        waitForElementToBePresent(PICK_POLAND_XPATH,2).click();
        driver.findElement(By.xpath(CONFIRM_POLAND_BUTTON_XPATH)).click();

        waitForElementToBePresent(DROP_DOWN_SEARCH_IN_XPATH,3).click();
        driver.findElement(By.xpath(CATEGORY_PICK_XPATH)).click();
        driver.findElement(By.id(SEARCH_FIELD_ID)).sendKeys(SEARCH_TERM);
        driver.findElement(By.id(SEARCH_BUTTON_ID)).click();
        waitForElementToBePresent(SORT_BY_LIST_XPATH, 3).click();
        driver.findElement(By.id(SORT_BY_NEWEST_ID)).click();
        waitForElementToBePresent(RESULT_SELECT_XPATH, 5).click();
        waitForElementToBePresent(BY_IT_NOW_XPATH, 5).click();
        Assert.assertTrue(driver.findElement(By.xpath(SIGN_IN_TEXT_XPATH)).isDisplayed());

    }
    private static WebElement waitForElementToBePresent(String xPath, long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    }
}



