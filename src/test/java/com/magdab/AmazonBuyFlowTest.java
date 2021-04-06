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
    static final String DELIVER_TO_BUTTON_XPATH = "//*[@id='nav-global-location-popover-link']";
    static final String DELIVER_TO_LIST_XPATH = "//span[@role='radiogroup' and @data-action='a-dropdown-button']";
    static final String PICK_POLAND_XPATH = "//a[@id='GLUXCountryList_178' and text()='Poland']";
    static final String CONFIRM_POLAND_BUTTON_XPATH = "//button[@name='glowDoneButton' and text()='Done']";

    static final String DROP_DOWN_SEARCH_IN_XPATH = "//*[@id='nav-search-dropdown-card']/div";
    static final String CATEGORY_PICK_XPATH = "//*[@value='search-alias=music-intl-ship']";
    static final String SEARCH_FIELD_XPATH = "//input[@id='twotabsearchtextbox']";
    static final String SEARCH_BUTTON_XPATH = "//*[@id='nav-search-submit-button']";
    static final String SEARCH_TERM = "Led Zeppelin vinyl";
    static final String SORT_BY_LIST_XPATH = "//span[@data-action and @aria-hidden]";
    static final String SORT_BY_NEWEST_XPATH = "//*[@id='s-result-sort-select_4']";
    static final String RESULT_SELECT_XPATH = "(//*[@class='a-section aok-relative s-image-fixed-height'])[1]";
    static final String BY_IT_NOW_XPATH = "//*[@id='buy-now-button']";
    static final String SIGN_IN_TEXT_XPATH = "//h1[contains(text(),'Sign-In')]";


    @Test
    public void basicAmazonBuyFlow(){
        driver.get(AMAZON_HOME_PAGE_URL);
        driver.findElement(By.xpath(DELIVER_TO_BUTTON_XPATH)).click();
        waitForElementToBePresent(DELIVER_TO_LIST_XPATH,3).click();
        waitForElementToBePresent(PICK_POLAND_XPATH,2).click();
        driver.findElement(By.xpath(CONFIRM_POLAND_BUTTON_XPATH)).click();

        waitForElementToBePresent(DROP_DOWN_SEARCH_IN_XPATH,3).click();
        driver.findElement(By.xpath(CATEGORY_PICK_XPATH)).click();
        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).sendKeys(SEARCH_TERM);
        driver.findElement(By.xpath(SEARCH_BUTTON_XPATH)).click();
        waitForElementToBePresent(SORT_BY_LIST_XPATH, 3).click();
        driver.findElement(By.xpath(SORT_BY_NEWEST_XPATH)).click();
        waitForElementToBePresent(RESULT_SELECT_XPATH, 5).click();
        waitForElementToBePresent(BY_IT_NOW_XPATH, 5).click();
        Assert.assertTrue(driver.findElement(By.xpath(SIGN_IN_TEXT_XPATH)).isDisplayed());


    }
    private static WebElement waitForElementToBePresent(String xPath, long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    }
}



