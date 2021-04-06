package com.magdab;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AmazonSortingTest extends BaseTest{

    static final String AMAZON_PAGE_URL = "https://www.amazon.com/s?k=Led+Zeppelin+vinyl&i=music-intl-ship&ref=nb_sb_noss_2";
    static final String COOKIES_DISMISS_XPATH = "//*[@data-action-type='DISMISS']";
    static final String DELIVER_TO_BUTTON_XPATH = "//*[@id='nav-global-location-popover-link']";
    static final String DELIVER_TO_LIST_XPATH = "//span[@role='radiogroup' and @data-action='a-dropdown-button']";
    static final String PICK_POLAND_XPATH = "//a[@id='GLUXCountryList_178' and text()='Poland']";
    static final String CONFIRM_POLAND_BUTTON_XPATH = "//button[@name='glowDoneButton' and text()='Done']";

    static final String SORT_BY_LIST_XPATH = "//span[@data-action and @aria-hidden]";
    static final String SORT_BY_NEWEST_XPATH = "//span[@class='a-button-text a-declarative']";
    static final String RESULT_SELECT_XPATH = "(//*[@class='a-section aok-relative s-image-fixed-height'])[1]";


    @Test
    public void basicAmazonSorting() throws InterruptedException {
        driver.get(AMAZON_PAGE_URL);
        driver.findElement(By.xpath(DELIVER_TO_BUTTON_XPATH)).click();
        waitForElementToBePresent(DELIVER_TO_LIST_XPATH,3).click();
        waitForElementToBePresent(PICK_POLAND_XPATH,2).click();
        driver.findElement(By.xpath(CONFIRM_POLAND_BUTTON_XPATH)).click();

        waitForElementToBePresent(COOKIES_DISMISS_XPATH,3).click();
        driver.findElement(By.xpath(SORT_BY_LIST_XPATH)).click();
//        Thread.sleep(5000);
        waitForElementToBePresent(SORT_BY_NEWEST_XPATH,2).click();
        Assert.assertTrue(driver.findElement(By.xpath(RESULT_SELECT_XPATH)).isDisplayed());

    }
    private static WebElement waitForElementToBePresent(String xPath, long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
    }
}



