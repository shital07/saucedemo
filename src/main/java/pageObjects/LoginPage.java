package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(className = "title")
    WebElement title;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement logoutError;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void setUserName(String user) {
        username.sendKeys(user);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getTitle() {
        return title.getAttribute("innerHTML");
    }

    public String getLogoutError() {
        return logoutError.getText();
    }

    public void login(String user, String password) {
        setUserName(user);
        setPassword(password);
        clickLogin();

    }

}
