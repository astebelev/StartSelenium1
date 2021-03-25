import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StartSelenium {

    WebDriver wd;

    @BeforeMethod
    public void preconditions(){
        wd =new ChromeDriver();
    }

    @Test
    public void startGoogle(){
        wd.get("https://www.google.com/");
        // wd.navigate().to("https://www.google.com/");
    }

    @AfterMethod
    public void tearDown(){
        //wd.close();
        wd.quit();
    }

}