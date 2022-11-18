package com.Crazy_Ataman.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AudiHomePagePF extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://www.audi.by/by/web/ru.html";

    @FindBy(xpath = "//*[@id=\"audi-header\"]/div/div[1]/div/div[4]/div/button")
    private WebElement magnifierButton;

    @FindBy(id = "search__basic")
    private WebElement searchInputElement;

    public AudiHomePagePF(WebDriver driver) {
        super(driver);
    }

    public AudiHomePagePF openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public AudiHomePagePF clickMagnifier() {
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
//                        ExpectedConditions.elementToBeClickable(magnifierButton))
//                .click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", magnifierButton);
        return this;
    }

    public AudiHomePagePF inputAndEnterSearch() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.elementToBeClickable(searchInputElement))
                .sendKeys("A5");
        searchInputElement.sendKeys(Keys.ENTER);
        return this;
    }

    public List<WebElement> getListOfSearchResults() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                        ExpectedConditions.presenceOfAllElementsLocatedBy(By
                                        .xpath("//span[@class='sc-fznKkj dTlhdB']")));
        List<WebElement> searchResults = driver
                .findElements(By.xpath("//span[@class='sc-fznKkj dTlhdB']"));
        return searchResults;
    }
}
