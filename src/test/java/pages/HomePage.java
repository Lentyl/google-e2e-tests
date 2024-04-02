package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    public static By searchInput = By.cssSelector("#APjFqb");
    public static By firstSearchListRecord = By.cssSelector("div[id='jZ2SBf'] div:nth-child(1) span:nth-child(1)");
    public static By feelingLuckyButton = By.cssSelector("div[class='FPdoLc lJ9FBc'] input[name='btnI']");
    public static By footerLinks = By.xpath("//a[normalize-space()='#####']");
    public static By settingsMenu = By.xpath("//div[@class='ayzqOc pHiOh']");
    public static By sendAnOpinionModalLink = By.cssSelector("span[role='menuitem']");
    public static By sendFeedbackToGoogleTitle = By.xpath("//h1[@class='uvFeedbackFormtitle']");
    public static By logInButton = By.cssSelector("span.gb_Kd");
    public static By avatarIcon = By.cssSelector(".gb_d.gb_Fa.gb_J");



    public static void searchInWeb(String searchText){
        sendKeys(searchInput, searchText);
        click(firstSearchListRecord);
    }

}
