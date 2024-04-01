package pages;

import org.openqa.selenium.By;

import static pages.BasePage.click;
import static pages.BasePage.scrollToElement;

public class DoodlesPage extends BasePage {

    public static By playNowButton = By.xpath("//span[text()='Play now']");
    public static By celebrationBubbleTeaCardTitle = By.xpath("//p[text()='Celebrating Bubble Tea']");
    public static By filterLabelName = By.xpath("//div[contains(@class, 'search-doodle__tag-item') and contains(@data-value, 'xxxxx')]");
    public static By searchDoodlesInput = By.cssSelector("input[placeholder='Search Doodles']");
    public static By dateFilter = By.xpath(".glue-expansion-panel__button[data-glue-expansion-panel-toggle-for='search-doodle__filter-1-content']");
    public static By dateComboboxesText = By.xpath("select[name='xxxxx']");
    public static By comboboxOption = By.xpath("//option[contains(text(), 'xxxxx')]");
    public static By DayCombobox = By.xpath("");



    public static void goToCelebrationBubleTeaPage(){
        scrollToElement(playNowButton);
        click(DoodlesPage.playNowButton);
        scrollToElement(celebrationBubbleTeaCardTitle);
        click(celebrationBubbleTeaCardTitle);
    }

}
