package com.Crazy_Ataman.test;

import com.Crazy_Ataman.page.AudiHomePagePF;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AudiSearchTest {
    private WebDriver driver;

    @BeforeEach
    @DisplayName("Setup Chrome Driver")
    public void initializeDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Test: search input and results")
    void clickMagnifierButtonAndInputTextAndPressEnterAndCheckResults()
            throws InterruptedException {
        AudiHomePagePF audiHomePagePF =
                new AudiHomePagePF(driver).openPage()
                        .clickMagnifier()
                        .inputAndEnterSearch();
        Assertions.assertTrue(audiHomePagePF.getListOfSearchResults().size() > 0,
                "Search results are empty!");
        Thread.sleep(5000);
    }

    @AfterEach
    @DisplayName("Close Chrome Driver")
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
