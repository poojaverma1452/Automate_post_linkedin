package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }

    public void testCase01() throws InterruptedException {
        // Navigate to URL https://in.linkedin.com/
        driver.navigate().to("https://in.linkedin.com/");
        // click on signIn button Using Locator "XPath"
        // button[@data-id='sign-in-form__submit-btn']
        driver.findElement(By.xpath("//button[@data-id='sign-in-form__submit-btn']")).click();
        // Locate the box for the phone number or email Using Locator "CSS Selector"
        // input#session_key
        driver.findElement(By.cssSelector("input#session_key")).sendKeys("apoojaverma1998@gmail.com");
        // Enter the password Using Locator "CSS Selector" input#session_password
        driver.findElement(By.cssSelector("input#session_password")).sendKeys("poojasudhir@94");
        // click on button for signIn Using Locator "XPath"
        // button[contains(text(),'Sign in')]
        driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();

        Thread.sleep(2000);
        // WebElement countView =
        // driver.findElement(By.xpath("//p[text()='14']"));//here dynamic xpath is not used. that's why used below onw
        WebElement countView = driver
                .findElement(
                        By.xpath("//span[contains(text(),'your profile')]/../../following-sibling::div/span/strong"));
        System.out.println("Printint  the count of `Who's viewed your profile` " + countView.getText());
    }
}
