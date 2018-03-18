package pageobjects.tests;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import pageobjects.BaseClassTest;
import pageobjects.User;

import static org.junit.Assert.assertTrue;

@RunWith(DataProviderRunner.class)
public class SignUpTest extends BaseClassTest{

    @DataProvider
    public static Object[] testDataforSignUp(){



        String pass = User.setPass("12345");
                


        return new User[]{


                new User("aaaaa",pass, "aaa@wp.pl"),
                new User("12345",pass, "eeee@wp.pl"),
                new User("abc!",pass, "ppp@wp.pl"),
                new User("aabb",pass, "1234@wp.pl"),
                new User("1234567",pass, ""),
                new User("aavvx","123","qqqq@buziaczek.pl"),
        };
    }


    @Before
    public void setUp() {
        prepareDriver();
        initializeBasicPageFactoryWithWaits();
    }

    @Test
    @UseDataProvider("testDataforSignUp")
    public void checkSignUpWithGoodData(User user){

        RegisterAndLogin(user);
        assertTrue("I cant find WYLOGUJ button: ", mainPage.getLogOutbutton().getText().equals("Wyloguj"));
    }


}
