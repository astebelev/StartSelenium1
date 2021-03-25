import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimpleTask {

    WebDriver wd;

    @BeforeMethod
    public void precondition() {
        wd = new ChromeDriver();
        wd.navigate().to("file:///C:/Users/Stebelev/Downloads/index.html");
//        wd.navigate().back();
//        wd.navigate().refresh();
//        wd.navigate().forward();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


    }

    @Test
    public void fillForm() {
        //find el-> click->clear - > send text
        WebElement name = wd.findElement(By.name("name"));
        WebElement surname = wd.findElement(By.name("surname"));
        WebElement sendBtn = wd.findElement(By.tagName("button"));
        WebElement textBox = wd.findElement(By.className("message"));

        fillField(name, "Tom");
        fillField(surname, "Dou");
        sendBtn.click();

        String result = textBox.getText();
        System.out.println(result);

        Assert.assertEquals(result, "Tom Dou");

    }


    public void fillField(WebElement el, String text) {
        el.click();
        el.clear();
        el.sendKeys(text);
    }

    @Test
    public void selectItemTest() {
        WebElement item = wd.findElement(By.tagName("a"));
        item.click();
        String itemText = item.getText();
        System.out.println(itemText);

        WebElement textBox = wd.findElement(By.className("message"));
        String result = textBox.getText();
        System.out.println(result);

        Assert.assertTrue(result.contains(itemText));
    }

    @Test
    public void selectItemFromList() {
        List<WebElement> items = wd.findElements(By.tagName("a"));
        System.out.println(items.size());

        WebElement item = items.get(2);
        String itemText = item.getText();
        System.out.println(itemText);
        item.click();
        WebElement textBox = wd.findElement(By.className("message"));
        String result = textBox.getText();
        System.out.println(result);

        Assert.assertTrue(result.contains(itemText));

    }

    @AfterMethod
    public void tearDown() {

        wd.quit();
    }
}
