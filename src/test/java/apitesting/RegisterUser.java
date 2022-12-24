package apitesting;


import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;


public class RegisterUser
{
SHAFT.API api;
String url = System.getProperty("automationExerciseBaseUrl");

private String email;

private String password;


    @BeforeClass
    public void setup()
{
    api = new SHAFT.API(url);
}

   //////////API 11: POST To Create/Register User Account\\\\\\\\\\\\
    @Test
    public void createRegisterUser()
    {
        List <List<Object>> registerData= Arrays.asList
        (
                Arrays.asList("name","Nourhan"),
                Arrays.asList("email","nourhaanTest@gmail.com"),
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

        List<Object> emailValue = registerData.get(1);
        email  = emailValue.get(1).toString();
        List<Object> passwordValue = registerData.get(2);
        password  = passwordValue.get(1).toString();
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return  password;
    }
}
