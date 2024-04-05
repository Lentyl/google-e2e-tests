package pages;

import org.openqa.selenium.By;


public class DoodlesPage extends BasePage {

    public static By playNowButton = By.xpath("//span[text()='Play now']");
    public static By celebrationBubbleTeaCardTitle = By.xpath("//p[text()='Celebrating Bubble Tea']");
    public static By filterLabelName = By.cssSelector("div.search-doodle__tag-item span");
    public static By searchDoodlesInput = By.cssSelector("input[placeholder='Search Doodles']");

    public static void goToCelebrationBubleTeaPage(){
        click(CelebratingBubbleTeaPage.cookiesOKButton);
        click(DoodlesPage.playNowButton);
        refreshPageIfElementIsNotVisible(celebrationBubbleTeaCardTitle);
        click(celebrationBubbleTeaCardTitle);
    }
}
