package tests;

import apitesting.RegisterUser;
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
        registerUser=new RegisterUser();
        System.out.println("nnnnnnn  "+registerUser.getEmail());
        System.out.println("ppppppp  "+registerUser.getPassword());
        loginPage.enterDataInLoginEmailFiled(registerUser.getEmail(),registerUser.getPassword());
        loginPage.clickLoginButton();
    }
}
