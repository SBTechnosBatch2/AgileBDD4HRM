package orangehrm;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by User on 24/01/2016.
 */
public class StepDefinitions {

    WebDriver driver;

    @Before
    public void startBrowser()
    {
        driver=new FirefoxDriver();
        driver.get("http://insoft5.trial412.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @After
    public void stopBrowser()
    {
        driver.quit();
    }
    @Given("^Admin is on login page$")
    public void verifyAdminIsInLoginpage() {
        Assert.assertTrue(driver.findElement(By.id("btnLogin")).isDisplayed());
    }

    @When("^Admin enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void enterUsernameAndPassword(String username, String password)  {
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);

    }

    @When("^Admin selects login$")
    public void selectsLogin() {
    driver.findElement(By.id("btnLogin")).click();
    }

    @Then("^Admin should login successfully$")
    public void loginSuccessfully()  {
//    Assert.assertFalse(driver.findElement(By.id("btnLogin")).isEnabled());

        Assert.assertTrue(driver.findElement(By.id("menu_pim_viewPimModule")).isEnabled());
    }

    @Then("^Admin should see welcome message as \"([^\"]*)\"$")
    public void welcomeMessage(String message) {
        Assert.assertTrue(driver.findElement(By.id("welcome")).getText().contains(message));

    }
}
