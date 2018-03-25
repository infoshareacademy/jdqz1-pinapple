package pageobjects.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageobjects.BaseAccess;
import pageobjects.User;

public class SignUpPage extends BaseAccess{

    @FindBy(linkText = "Rejestracja")
    private WebElement registationSide;

    @FindBy(xpath = "//div[@id='tab-pane-2']//input[@id='username']")
    private WebElement username;

    @FindBy(xpath = "//div[@id='tab-pane-2']//input[@id='password']")
    private WebElement password;

    public WebElement getEmail() {
        return email;
    }

    @FindBy(xpath = "//div[@id='tab-pane-2']//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//button[text()='Zarejestruj się']")
    private WebElement registerButton;

    public void clickOnRegisterSide(){
        registationSide.click();
    }

    public WebElement getRegistationSide() {
        return registationSide;
    }

    public void setUserData(User user){
        username.sendKeys(user.getName());
        password.sendKeys(user.getPass());
        email.sendKeys(user.getEmail());
    }
    public void clickOnRegister() {
        registerButton.click();}
}
