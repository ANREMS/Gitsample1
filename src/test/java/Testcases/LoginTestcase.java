package Testcases;

import Base.BaseUI;
import POM.Login;
import lombok.extern.java.Log;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Utilities.ListenerUtils.class)
public class LoginTestcase extends BaseUI {

    WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = invokebrowser();
        openWebsite("applicationURL");

    }

    @Test
    public void test1(){
        Login login = new Login(driver);
//        login.userName("user");
//        login.passWord("pass");
//        login.submit();
//        System.out.println("Test1 execution");
        login.userName("student");
        login.passWord("Password123");
        login.submit();

    }
}
