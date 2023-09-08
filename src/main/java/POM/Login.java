package POM;

import Base.BaseUI;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BaseUI {

    WebDriver driver;
    public Login(WebDriver driver) {
        this.driver=driver;
    }
    //locators
    By username=getlocator("username_name");
    By password=getlocator("password_name");

//    By submit=getlocator("submit_name");
    By submit=getlocator("submit_id");

    //elements as methods
    public void userName(String user) {
        sendtext(username, user);
        logger.log(Status.INFO, "username is entered");
    }
    public void passWord(String pass) {
        sendtext(password, pass);
        logger.log(Status.INFO, "password is entered");
    }
    public void submit() {
        clickOn(submit);
        logger.log(Status.INFO, "submit is clicked");
    }

}
