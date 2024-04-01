package pages;
import org.openqa.selenium.By;
import static tests.HomePageTests.driver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class BasePage {



    public static By confirmationButton = By.id("W0wltc");


    public static void click(By el) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(el))
                .click();
    }

    public static void sendKeys(By el, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(el)).sendKeys(text);
    }
    public static String getText(By el) {
        return new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(el)).getText();
    }

    public static void scroll(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
    }

    public static void scrollToElement(By el) {
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(el));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(el));
    }
    public static Boolean isDisplayed(By el) {
        boolean visability = false;
        for (int i = 0; i < 20; i++) {
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


}
