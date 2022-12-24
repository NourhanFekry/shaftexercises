package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List <List<Object>> registerData= Arrays.asList
                (
                        Arrays.asList("name","Nourhan"),
                        Arrays.asList("email","nourhanTest@gmail.com"),
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


         List<Object> email = registerData.get(1);
         String getEmail  = (String) email.get(1).toString();
         List<Object> password = registerData.get(2);
         String getPassword  = password.get(1).toString();


        System.out.println(getEmail);
        System.out.println(getPassword);

    }
}