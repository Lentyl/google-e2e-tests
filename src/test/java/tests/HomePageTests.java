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
        driver.manage().window().maximize();
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
        click(CelebratingBubbleTeaPage.foodAndDrinkButton);
        Assert.assertEquals(driver.getCurrentUrl(), "https://doodles.google/search/?topic_tags=food%20and%20drink");
        Assert.assertTrue(isDisplayed(getElementByXpathText( DoodlesPage.filterLabelName, "food and drink")));
        driver.navigate().back();
        click(CelebratingBubbleTeaPage.exploreRandomThemeButton);
        Assert.assertTrue(isDisplayed(DoodlesPage.searchDoodlesInput));
        driver.navigate().back();
        click(CelebratingBubbleTeaPage.interactiveGameButton);
        Assert.assertTrue(isDisplayed(getElementByXpathText( DoodlesPage.filterLabelName, "Interactive Game")));
        driver.navigate().back();
        click(CelebratingBubbleTeaPage.beverageButton);
        Assert.assertTrue(isDisplayed(getElementByXpathText( DoodlesPage.filterLabelName, "food and drink")));
        driver.navigate().back();
        CelebratingBubbleTeaPage.goToReadMorePage();
        Assert.assertTrue(isDisplayed(CelebratingBubbleTeaPage.readMoreModalFirstParagraph));
        click(CelebratingBubbleTeaPage.readMorModalCloseButton);
        click(CelebratingBubbleTeaPage.doodleDate);
        click(DoodlesPage.dateFilter);
        Assert.assertEquals(getText(getElementByXpathText(DoodlesPage.dateComboboxesText, "date_like_year")), "Year: 2023" );
        Assert.assertEquals(getText(getElementByXpathText(DoodlesPage.dateComboboxesText, "date_like_month")), "January" );
        Assert.assertEquals(getText(getElementByXpathText(DoodlesPage.dateComboboxesText, "date_like_year")), "29" );
        click(getElementByXpathText(DoodlesPage.dateComboboxesText, "date_like_year"));
        click(getElementByXpathText(DoodlesPage.comboboxOption, "2020"));
        click(getElementByXpathText(DoodlesPage.comboboxOption, "December"));
        click(getElementByXpathText(DoodlesPage.comboboxOption, "31"));
        Assert.assertEquals(getText(getElementByXpathText(DoodlesPage.dateComboboxesText, "2020")), "Year: 2023" );
        Assert.assertEquals(getText(getElementByXpathText(DoodlesPage.dateComboboxesText, "December")), "January" );
        Assert.assertEquals(getText(getElementByXpathText(DoodlesPage.dateComboboxesText, "31")), "29" );
        click(DoodlesPage.dateFilter);
        Assert.assertEquals()
    }

}
