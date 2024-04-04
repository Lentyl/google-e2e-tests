package pages;
import static tests.HomePageTests.driver;
import org.openqa.selenium.By;

public class CelebratingBubbleTeaPage extends BasePage {
    public static By mainTitle = By.cssSelector("h1.title");
    public static By readMoreButton = By.xpath("//button[contains(text(),'Read More')]");
    public static By foodAndDrinkButton = By.cssSelector(".theme.surface-4-outline");
    public static By aboutBubbleTeaDescription = By.cssSelector("div[class='paragraph add_link_class'] p");
    public static By readMoreModalFirstParagraph = By.xpath("//p[contains(text(),'Tangy and fruity or sweet and milky?')]");
    public static By readMorModalCloseButton = By.xpath("//div[@class='glue-page modal-content']//button[@id='modal-close-btn']");
    public static By exploreRandomThemeButton = By.cssSelector(".key-themes-cta");
    public static By interactiveGameButton = By.xpath("//a[normalize-space()='interactive game']");
    public static By beverageButton = By.xpath("//a[@class='theme-word main-outline' and normalize-space()='beverage']");
    public static By doodleDateButton = By.xpath("//a[@class='theme-word' and text()='Jan 29, 2023']");

    public static void goToReadMorePage(){
        scrollToElement(aboutBubbleTeaDescription);
        click(readMoreButton);
    }

    public static void goTointeractiveGameLink(){
        driver.navigate().back();
        scroll(0, 30);
        click(CelebratingBubbleTeaPage.interactiveGameButton);
    }

    public static void goToBeverageLink(){
        driver.navigate().back();
        scroll(0, -50);
        click(CelebratingBubbleTeaPage.beverageButton);
    }




}
