package api_testing;


import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.util.Arrays;
import java.util.List;


public class RegisterUser
{
SHAFT.API api;
String url = System.getProperty("automationExerciseBaseUrl");
SHAFT.GUI.WebDriver driver;
LoginPage loginPage;
private String email = "nawara@Test.com";
private String password = "246810";
private String name = "Nourhan";

    @BeforeClass
    public void setup()
    {
    api = new SHAFT.API(url);
    driver = new SHAFT.GUI.WebDriver();
    driver.browser().navigateToURL("https://automationexercise.com/login");
        List <List<Object>> registerData= Arrays.asList
                (
                        Arrays.asList("name","Nourhan"),
                        Arrays.asList("email","nawara@Test.com"),
                        Arrays.asList("password","246810"),
                        Arrays.asList("title","Ms"),
                        Arrays.asList("brith_date","28"),
                        Arrays.asList("birth_month","02"),
                        Arrays.asList("birth_year","2000"),
                        Arrays.asList("firstname","Nourhan"),
                        Arrays.asList("lastname","Fekry"),
                        Arrays.asList("company","VOIS"),
                        Arrays.asList("address1","Mansoura"),
                        Arrays.asList("address2","Mansoura"),
                        Arrays.asList("country","India"),
                        Arrays.asList("zipcode","1234"),
                        Arrays.asList("state","Cairo"),
                        Arrays.asList("city","cairo"),
                        Arrays.asList("mobile_number","01234567890")
                );
        api.post("/createAccount")
                .setParameters(registerData, RestActions.ParametersType.FORM)
                .setContentType(ContentType.URLENC)
                .perform();
    }
    @Test
    public void loginWithCorrectData()
    {
        loginPage = new LoginPage(driver);
        System.out.println("this is for test email "+ email);
        System.out.println("this is for test password "+password);
        loginPage.enterDataInLoginEmailFiled(email,password);
        loginPage.clickLoginButton();
        SHAFT.Validations
                .assertThat()
                .object(loginPage.checkLoginSuccessfully()
                .contains("Logged in as "+name));
        System.out.println("pass");
    }
}
