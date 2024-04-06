import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SimpleTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }//setUp

    @Test
    public void VerifyValidLogin() {
        driver.get("https://www.saucedemo.com/v1/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("btn_action")).click();
        driver.close();
    }//VerifyValidLogin

    @Test
    public void VerifyInvalidLogin(){
        driver.get("https://www.saucedemo.com/v1/");
        driver.findElement(By.id("user-name")).sendKeys("standard12_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.className("btn_action")).click();
        driver.close();
    }//VerifyInvalidLogin

    @Test
    public void NoLoginDetails() {
        driver.get("https://www.saucedemo.com/v1/");
        driver.findElement(By.className("btn_action")).click();
        driver.close();
    }//NoLoginDetails

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }//tearDown
}//SimpleTest
