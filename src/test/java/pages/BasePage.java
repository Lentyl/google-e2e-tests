package pages;
import org.openqa.selenium.By;
import static tests.HomePageTests.driver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static By acceptAllButton = By.id("W0wltc");
    public static By cookiesOKButton = By.cssSelector(".glue-cookie-notification-bar__accept");
    public static By continueToGoogleButton = By.xpath("(//span[@class='VfPpkd-vQzf8d'][normalize-space()='Accept all'])[1]");
    public static By howCanWeHelpTitle = By.cssSelector("h1[class='promoted-search__greeting'] div");

    public static void goToGooglePage() {
        driver.manage().window().maximize();
        click(HomePage.acceptAllButton);
    }
    public static String getAttribute(By el, String atr) {
        return new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(el)).getAttribute(atr);
    }
    public static void click(By el) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(el))
                .click();
    }
    public static void sendKeys(By el, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(el)).sendKeys(text);
    }
    public static String getText(By el) {
        return new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(el)).getText();
    }
    public static void scroll(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
    }
    public static void scrollToElement(By el) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(el));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(el));
    }
    public static Boolean isDisplayed(By el) {
        boolean visability = false;
        for (int i = 0; i < 20; i++) {
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            try {
                driver.findElement(el);
                visability = true;
            } catch (org.openqa.selenium.NoSuchElementException e) {
                visability = false;
            }
        }
        return visability;
    }
    public static By getElementByXpathText(By xpath, String text) {

        String name = xpath.toString();
        name = name.replace("#####", text);
        name = name.replace("By.xpath: ", "");
        return By.xpath(name);
    }

    public static void refreshPageIfElementIsNotVisable(By selector) {// Metoda stworzona na potrzeby rekrutacji problemy z poprawnym ładowaniem strony

        for (int i = 0; i < 4; i++) {
            try {
                if (driver.findElements(selector).size() > 0 && driver.findElements(selector).get(0).isDisplayed()) {
                    i = 4;
                } else {
                    i++;
                    System.out.println("Element not found " + i + " try");
                    driver.navigate().refresh();
                    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                };
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println(e);
            }
        }
        scrollToElement(selector);
    }
}
