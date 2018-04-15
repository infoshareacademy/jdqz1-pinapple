package pageobjects.tests;
import org.junit.Before;
import org.junit.Test;
import pageobjects.BaseClassTest;
import pageobjects.User;
import pageobjects.pages.MyProfilePage;
import static org.junit.Assert.*;


public class FavoritesTest extends BaseClassTest {

    private MyProfilePage myProfilePage;

    @Before
    public void setUp() {
        prepareEnvForTests();
        myProfilePage = new MyProfilePage(driver);
        RegisterAndLogin(new User("aaaaa", "12345", "www@wp.pl"));
    }

    @Test
    public void addToFavorites() {

        mywait.waitForElementToBeVisible(mainPage.getMenuButtonOurGames());
        mainPage.clickOnOurGames();
        mainPage.clickOnHeartbutton();
        mywait.waitForElementToBeClickable(mainPage.getMenuButtonMyProfile());
        mainPage.clickOnMyProfile();
        assertTrue(myProfilePage.getGameName().getText().length() > 0);
    }

    @Test
    public void removeFromFavorites(){

        mainPage.clickOnOurGames();
        mainPage.clickOnHeartbutton();
        mywait.waitForElementToBeClickable( mainPage.getMenuButtonMyProfile());
        mainPage.clickOnMyProfile();
        mywait.waitForElementToBeClickable( myProfilePage.getAlertName());
        assertTrue("Game was not removed from favorites", myProfilePage.getAlertName().getText().contains("Nie masz"));
    }

}
