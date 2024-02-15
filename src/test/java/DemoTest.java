import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LoginPage;
import utility.DriverFactory;

public class DemoTest extends DriverFactory {

    private WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void validTest() {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(loginPage.getTitle(), "Products");

    }

    @Test
    public void invalidTest() {
        driver.get("https://www.saucedemo.com/");
        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertEquals(loginPage.getLogoutError(), "Epic sadface: Sorry, this user has been locked out.");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
