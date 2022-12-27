package pages;

import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;

import java.util.Arrays;
import java.util.List;

public class ApiCreateUser

{
    SHAFT.API api;
    private String email;
    private String password;
    private String name ;

    public ApiCreateUser(SHAFT.API api) {
        this.api = api;
    }

    public void createUser()
    {
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

    public String getEmail() {
        email = "nawara@Test.com";
        return email;
    }
    public String getPassword() {
        password = "246810";
        return password;
    }
    public String getName() {
        name = "Nourhan";
        return name;
    }
}
