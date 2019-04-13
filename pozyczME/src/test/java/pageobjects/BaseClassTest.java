package pageobjects;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.pages.*;



public class BaseClassTest extends BaseAccess{

    protected SignUpPage signUp;
    protected MainPage mainPage;
    protected SignInPage signIn;
    protected User user;

    @Rule
    public ScreenShotOnFailure failure = new ScreenShotOnFailure();

    @Before
    public void getDriverUrl(){
        prepareDriver();
        driver.get(getURL());
    }

    public void prepareEnvForTests(){

        initializeBasicPageFactoryWithWaits();
        RegisterAndLogin(new User("aaaaa", "12345", "www@wp.pl"));
    }

    protected void initializeBasicPageFactoryWithWaits(){
        mywait= new Waits(driver);
        signIn = PageFactory.initElements(driver,SignInPage.class);
        signUp = PageFactory.initElements(driver, SignUpPage.class);
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    protected void RegisterAndLogin(User user){

        mywait.waitForElementToBeVisible( signIn.getUsername());
        signUp.clickOnRegisterSide();
        mywait.waitForElementToBeClickable(signUp.getEmail());
        signUp.setUserData(user);
        signUp.clickOnRegister();
        signIn.clickOnLogSide();
        mywait.waitForElementToBeVisible( signIn.getUsername());
        signIn.setUserData(user);
        signIn.clickOnSignIn();
    }


//    @After
//    public void tearDown() {
//        if(driver != null)
//        driver.quit();
//    }


}
