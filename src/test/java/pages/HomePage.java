package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
    public static By searchInput = By.cssSelector("#APjFqb");
    public static By firstSearchListRecord = By.cssSelector("div[id='jZ2SBf'] div:nth-child(1) span:nth-child(1)");
    public static By feelingLuckyButton = By.cssSelector("div[class='FPdoLc lJ9FBc'] input[name='btnI']");


    public static void searchInWeb(String searchText){
        sendKeys(searchInput, searchText);
        click(firstSearchListRecord);
    }

}
