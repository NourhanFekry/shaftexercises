package pages;

import apitesting.RegisterUser;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class LoginPage
{
    SHAFT.GUI.WebDriver driver;
    By loginEmailFiled = By.xpath("//*[@data-qa='login-email']");
    By loginPasswordFiled = By.xpath("//*[@data-qa='login-password']");
    By loginButton = By.xpath("//*[@data-qa='login-button']");
    By incorrectLoginData = By.xpath("(//P)[1]");

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void enterDataInLoginEmailFiled(String email,String password)
    {
        driver.element().type(loginEmailFiled, email);
        driver.element().type(loginPasswordFiled, password);
    }
    public void clickLoginButton()
    {
        driver.element().click(loginButton);
    }
    public String checkIncorrectLoginData()
    {
        return driver.element().getText(incorrectLoginData);
    }
}
