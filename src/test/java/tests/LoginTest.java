package tests;

import api_testing.RegisterUser;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest
{
    SHAFT.GUI.WebDriver driver;
    LoginPage loginPage;
    RegisterUser registerUser;

    @BeforeClass
    public void setUp()
    {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://automationexercise.com/login");

    }
    @Test
    public void loginWithCorrectData()
    {
        loginPage = new LoginPage(driver);
        registerUser=new RegisterUser();
        System.out.println("This Line For Test " +registerUser.getEmail());
        loginPage.enterDataInLoginEmailFiled(registerUser.getEmail(),registerUser.getPassword());
        loginPage.clickLoginButton();
        SHAFT.Validations
                .assertThat()
                .object(loginPage.checkLoginSuccessfully()
                .contains("Logged in as "+registerUser.getName()));
        System.out.println("pass");
    }
}
