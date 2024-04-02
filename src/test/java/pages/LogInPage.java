package pages;

import data.TestData;
import org.openqa.selenium.By;

import static pages.BasePage.click;
import static pages.BasePage.sendKeys;

public class LogInPage {

    public static By emailInput = By.xpath("//input[@type='email']");
    public static By passwordInput = By.xpath("//input[@type='password']");
    public static By nextButton = By.xpath("//span[@class='VfPpkd-vQzf8d' and text()='Next']");
    public static By passwordValidationMessage = By.xpath("//span[text()='Wrong password. Try again or click Forgot password to reset it.']");


    public static void logIn(String email, String prassword){
        click(HomePage.logInButton);
        sendKeys(emailInput,email);
        click(nextButton);
        sendKeys(passwordInput, prassword);
        click(nextButton);
    }




}
