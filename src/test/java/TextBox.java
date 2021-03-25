import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TextBox {
    WebDriver wd;


    @BeforeMethod
    public void precondition() {
        wd = new ChromeDriver();
        wd.navigate().to("https://demoqa.com/text-box");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void fillForm() {
        WebElement fullName = wd.findElement(By.id("userName"));
        WebElement email = wd.findElement(By.id("userEmail"));
        WebElement currentAddress = wd.findElement(By.id("currentAddress"));
        WebElement permanentAddress = wd.findElement(By.id("permanentAddress"));
        WebElement submitBtn = wd.findElement(By.id("submit"));

        extractWithString(fullName, "John Tiv");

        String text = "johntiv@gmail.com";
        fillField2(email, text);

        fillField(currentAddress, "Dror 15, Tel Aviv, Israel");
        fillField(permanentAddress, "Dror 15, Tel Aviv, Israel");
        submitBtn.click();


    }

    public void extractWithString(WebElement element, String s) {
        element.click();
        element.clear();
        element.sendKeys(s);
    }

    public void fillField2(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void fillField(WebElement el, String text) {
        el.click();
        el.clear();
        el.sendKeys(text);
    }
}
