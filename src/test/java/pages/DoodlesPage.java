package pages;

import org.openqa.selenium.By;

import static pages.BasePage.click;
import static pages.BasePage.scrollToElement;

public class DoodlesPage extends BasePage {

    public static By playNowButton = By.xpath("//span[text()='Play now']");
    public static By celebrationBubbleTeaCardTitle = By.xpath("//p[text()='Celebrating Bubble Tea']");
    public static By filterLabelName = By.cssSelector("div.search-doodle__tag-item span");
    public static By searchDoodlesInput = By.cssSelector("input[placeholder='Search Doodles']");
    public static By dateFilterLabels = By.xpath("//span[@class='search-doodle__tag-item-label' and text()='#####']");
    public static By dateFilterMenu = By.xpath("//span[normalize-space()='Date']");
    public static By dateComboboxesText = By.xpath("select[name='#####']");
    public static By comboboxOption = By.xpath("//option[contains(text(), '#####')]");
    public static By DayCombobox = By.xpath("");



    public static void goToCelebrationBubleTeaPage(){
        click(CelebratingBubbleTeaPage.cookiesOKButton);
        scrollToElement(playNowButton);
        click(DoodlesPage.playNowButton);
        scrollToElement(celebrationBubbleTeaCardTitle);
        click(celebrationBubbleTeaCardTitle);
    }

    public static void changeDataInTheFilters(){

    }

}
