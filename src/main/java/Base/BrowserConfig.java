package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserConfig {

    static WebDriver driver;

    public static WebDriver getchromeBrowser() {
        ChromeOptions options=new ChromeOptions();
//        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");  // https://www.ajio.com/
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getfirefoxBrowser() {
        FirefoxOptions options =new FirefoxOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver=new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getEdgeBrowser() {
        EdgeOptions options =new EdgeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver=new EdgeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }


}
