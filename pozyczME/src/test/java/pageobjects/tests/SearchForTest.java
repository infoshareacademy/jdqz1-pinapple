package pageobjects.tests;

import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.pages.SearchForPage;
import pageobjects.pages.SignInPage;
import pageobjects.BaseClassTest;
import pageobjects.User;
import pageobjects.Waits;
import pageobjects.pages.MainPage;
import pageobjects.pages.SignUpPage;
import pageobjects.utils.ScreenShotOnFailure;

import java.io.File;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class SearchForTest extends BaseClassTest {

    private SearchForPage searchForPage;

    @Rule
    public ScreenShotOnFailure failure = new ScreenShotOnFailure(driver);

    @Before
    public void setUp() {

        prepareDriver();
        initializeBasicPageFactoryWithWaits();
        searchForPage = PageFactory.initElements(driver, SearchForPage.class);
        RegisterAndLogin(new User("aaaaa", "12345", "www@wp.pl"));

    }

    @Test
    public void addLettersSearchbb() {

        searchForPage.clickOnOurGamesbutton();
        searchForPage.setSearchField("bb");
        assertTrue("SearchField is not displayed", searchForPage.isSearchFieldVisible());
    }

    @Test
    public void addLettersSearchsc() {

        searchForPage.clickOnOurGamesbutton();
        searchForPage.setSearchField("sc");
        assertTrue("OurGamesbutton is not displayed", searchForPage.isOurGamesbuttonVisible());
    }

    @Test
    public void addSearchWordScrrable() {

        searchForPage.clickOnOurGamesbutton();
        searchForPage.setSearchField("Scrabble");
        assertTrue("SearchField is not displayed", searchForPage.isSearchFieldVisible());
    }


}
