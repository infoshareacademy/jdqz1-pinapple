package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseAccess {

    protected static WebDriver driver;
    private static final String HOMEURL = "http://app.pinapple.jdqz1.is-academy.pl/";
    protected Waits mywait;
    private static String buildEnv = System.getProperty("buildEnv");

    protected static void prepareDriver(){

        if(buildEnv.equals("CI")){
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), new DesiredCapabilities());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        if(buildEnv.equals("DEV")){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            driver = new ChromeDriver();
        }

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static String getURL() {
        return HOMEURL;
    }
}
