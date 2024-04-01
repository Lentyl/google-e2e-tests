package pages;

import org.openqa.selenium.By;

import static pages.BasePage.click;
import static pages.BasePage.scrollToElement;

public class CelebratingBubbleTeaPage extends BasePage {
    public static By mainTitle = By.cssSelector("h1.title");
    public static By readMoreButton = By.xpath("//button[contains(text(),'Read More')]");
    public static By foodAndDrinkButton = By.cssSelector(".theme.surface-4-outline");
    public static By aboutBubbleTeaDescription = By.cssSelector("div[class='paragraph add_link_class'] p");
    public static By readMoreModalFirstParagraph = By.xpath("//p[contains(text(),'Tangy and fruity or sweet and milky?')]");
    public static By readMorModalCloseButton = By.xpath("//div[@class='glue-page modal-content']//button[@id='modal-close-btn']");
    public static By exploreRandomThemeButton = By.cssSelector(".key-themes-cta");
    public static By interactiveGameButton = By.xpath("//a[normalize-space()='interactive game']");
    public static By beverageButton = By.xpath("//a[normalize-space()='beverage']");
    public static By doodleDate = By.cssSelector("a[class='theme-word']");





    public static void goToReadMorePage(){
        scrollToElement(aboutBubbleTeaDescription);
        click(readMoreButton);
    }
}
