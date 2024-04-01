package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static pages.BasePage.*;

import pages.CelebratingBubbleTeaPage;
import pages.DoodlesPage;
import pages.HomePage;
import pages.SearchResultPage;
import org.testng.Assert;



public class HomePageTests {
    public static WebDriver driver;

    @BeforeTest
    public static void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.google.pl/");
        click(HomePage.confirmationButton);
    }

    @Test
    void SearchTest(){
        HomePage.searchInWeb("Bociany");
        Assert.assertEquals(getText(SearchResultPage.firstSearchedRecord), "Bociany online");
    }

    @Test
    void FeelingLuckyTest (){
        click(HomePage.feelingLuckyButton);
        DoodlesPage.goToCelebrationBubleTeaPage();
        Assert.assertEquals(getText(CelebratingBubbleTeaPage.mainTitle), "Celebrating Bubble Tea");
    }

}
