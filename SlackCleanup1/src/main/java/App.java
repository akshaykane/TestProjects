import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        System.setProperty("webdriver.chrome.driver", "chrome/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://ptcsymphonydev.slack.com/");
        
        // Enter username
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("twx-symphony-dev@ptc.com");
        
        // Enter password
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("twx-symphony-dev@ptc.com");
        
    }
}
