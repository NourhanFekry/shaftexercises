package api_testing;


import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ApiCreateUser;
import pages.LoginPage;



public class RegisterUser
{
SHAFT.API api;
String url = "https://automationexercise.com/api";
SHAFT.GUI.WebDriver driver;
LoginPage loginPage;
ApiCreateUser apiCreateUser;

    @BeforeClass
    public void setup()
    {
    api = new SHAFT.API(url);
    apiCreateUser = new ApiCreateUser(api);
    apiCreateUser.createUser();
    driver = new SHAFT.GUI.WebDriver();
    driver.browser().navigateToURL("https://automationexercise.com/login");
    }
    @Test
    public void loginWithCorrectData()
    {
        loginPage = new LoginPage(driver);
        System.out.println("this is for test email "+ apiCreateUser.getEmail());
        System.out.println("this is for test password "+apiCreateUser.getPassword());
        loginPage.enterDataInLoginEmailFiled(apiCreateUser.getEmail(),apiCreateUser.getPassword());
        loginPage.clickLoginButton();
        SHAFT.Validations
                .assertThat()
                .object(loginPage.checkLoginSuccessfully()
                .contains("Logged in as "+apiCreateUser.getName()));
        System.out.println("pass");
    }
}
