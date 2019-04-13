package pageobjects.tests;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pageobjects.BaseClassTest;
import pageobjects.ScreenShotOnFailure;
import pageobjects.User;
import pageobjects.pages.SearchForPage;

import static org.junit.Assert.assertTrue;

public class SearchForTest extends BaseClassTest {

    private SearchForPage searchForPage;

    @Before
    public void setUp() {

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
