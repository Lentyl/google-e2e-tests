package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static pages.BasePage.*;
import data.TestData;
import org.testng.asserts.SoftAssert;
import pages.*;
import org.testng.Assert;

public class HomePageTests {
    public static WebDriver driver;

    @BeforeMethod
    public static void testSetup() {
        driver = new ChromeDriver();
        driver.get(TestData.baseUrl);
        goToGooglePage();
    }

    @Test(priority=1)
    void SearchRecordTest(){
        HomePage.searchInWeb(TestData.searchedPhrase);
        Assert.assertEquals(getText(SearchResultPage.title), "Stork");
    }

    @Test(priority=2)
    void FeelingLuckyButtonTest (){
        SoftAssert softAssert = new SoftAssert();
        HomePage.searchInWeb(TestData.searchedPhrase);
        softAssert.assertEquals(getText(SearchResultPage.title), "Stork"); // wyświetlane są losowe strony
        driver.navigate().back();
        click(HomePage.feelingLuckyButton);
        DoodlesPage.goToCelebrationBubleTeaPage();
        Assert.assertEquals(getText(CelebratingBubbleTeaPage.mainTitle), "Celebrating Bubble Tea");
        click(CelebratingBubbleTeaPage.foodAndDrinkButton);
        Assert.assertEquals(driver.getCurrentUrl(), "https://doodles.google/search/?topic_tags=food%20and%20drink");
        Assert.assertEquals(getText(DoodlesPage.filterLabelName), "Food and Drink");
        CelebratingBubbleTeaPage.goToRandomThemeButtonLink();
        Assert.assertTrue(isDisplayed(DoodlesPage.searchDoodlesInput));
        CelebratingBubbleTeaPage.goTointeractiveGameLink();
        Assert.assertEquals(getText(DoodlesPage.filterLabelName), "Interactive Game");
        CelebratingBubbleTeaPage.goToBeverageLink();
        Assert.assertEquals(getText(DoodlesPage.filterLabelName), "Food and Drink");
        driver.navigate().back();
        CelebratingBubbleTeaPage.goToReadMorePage();
        Assert.assertTrue(isDisplayed(CelebratingBubbleTeaPage.readMoreModalFirstParagraph));
        click(CelebratingBubbleTeaPage.readMorModalCloseButton);
        scrollToElement(CelebratingBubbleTeaPage.doodleDateButton);
    }

    @Test(priority=3)
    void LogInWithIncorrectPassword (){
        LogInPage.logIn(TestData.corretEmail, TestData.incorretPassword);
        Assert.assertEquals(getText(LogInPage.passwordValidationMessage), "Wrong password. Try again or click Forgot password to reset it.");
    }

    @Test(priority=4)
    void LogInWithCorrectCredentials (){
        LogInPage.logIn(TestData.corretEmail, TestData.corretPassword);
        Assert.assertEquals(HomePage.getAttribute(HomePage.avatarIcon, "aria-label"),"Google Account: MariuszTest  \n" +
                "(mariusztest260@gmail.com)");
    }

    @Test(priority=5)
    void CheckFooterLinks (){
        click(getElementByXpathText(HomePage.footerLinks,"About"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://about.google/?utm_source=google-PL&utm_medium=referral&utm_campaign=hp-footer&fg=1");
        driver.navigate().back();
        click(getElementByXpathText(HomePage.footerLinks,"Advertising"));
        click(HomePage.continueToGoogleButton);
        Assert.assertEquals(driver.getCurrentUrl(), "https://ads.google.com/intl/en_pl/home/?subid=ww-ww-et-g-awa-a-g_hpafoot1_1!o2&utm_source=google.com&utm_medium=referral&utm_campaign=google_hpafooter&fg=1");
        driver.navigate().back();
        driver.navigate().back();
        click(getElementByXpathText(HomePage.footerLinks,"Business"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.pl/services/?subid=ww-ww-et-g-awa-a-g_hpbfoot1_1!o2&utm_source=google.com&utm_medium=referral&utm_campaign=google_hpbfooter&fg=1#?modal_active=none");
        driver.navigate().back();
        click(getElementByXpathText(HomePage.footerLinks,"How Search works"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/search/howsearchworks/?fg=1");
        driver.navigate().back();
        click(getElementByXpathText(HomePage.footerLinks,"Privacy"));;
        Assert.assertEquals(driver.getCurrentUrl(), "https://policies.google.com/privacy?hl=en-PL&fg=1");
        driver.navigate().back();
        click(getElementByXpathText(HomePage.footerLinks,"Terms"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://policies.google.com/terms?hl=en-PL&fg=1");
        driver.navigate().back();
        click(HomePage.settingsMenu);
        click(getElementByXpathText(HomePage.footerLinks,"Search settings"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.pl/preferences?hl=en-PL&fg=1");
        driver.navigate().back();
        click(getElementByXpathText(HomePage.footerLinks,"Advanced search"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.pl/advanced_search?hl=en-PL&fg=1");
        driver.navigate().back();
        click(getElementByXpathText(HomePage.footerLinks,"Your data in Search"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://myaccount.google.com/intro/yourdata/search?utm_source=googlemenu&fg=1&cctld=pl");
        driver.navigate().back();
        click(getElementByXpathText(HomePage.footerLinks,"Search history"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.pl/history/optout?hl=en-PL&fg=1");
        driver.navigate().back();
        click(getElementByXpathText(HomePage.footerLinks,"Search help"));
        Assert.assertEquals(getText(howCanWeHelpTitle), "How can we help you?");
    }

    @AfterMethod(alwaysRun = true)
    public static void endTest() {
        driver.close();
    }
}
