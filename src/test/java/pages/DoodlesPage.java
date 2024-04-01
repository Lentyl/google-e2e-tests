package pages;

import org.openqa.selenium.By;

import static pages.BasePage.click;
import static pages.BasePage.scrollToElement;

public class DoodlesPage {

    public static By playNowButton = By.xpath("//span[text()='Play now']");
    public static By celebrationBubbleTeaCardTitle = By.xpath("//p[text()='Celebrating Bubble Tea']");

    public static void goToCelebrationBubleTeaPage(){
        scrollToElement(playNowButton);
        click(DoodlesPage.playNowButton);
        scrollToElement(celebrationBubbleTeaCardTitle);
        click(celebrationBubbleTeaCardTitle);
    }

}
