import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SeleniumEmailUnreader {
    public static void main(String[] args) throws InterruptedException {
        // setting up the chrome driver
        System.setProperty("webdriver.chrome.driver", "/home/hizkias/Documents/program setups/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();

        WebDriver driver = new ChromeDriver(chromeOptions);


        // Open the gmail login page
        driver.get("https://accounts.google.com/ServiceLogin?");

        // logging into my account
        driver.findElement(By.id("Email")).sendKeys("hizkiasnew@gmail.com");
        driver.findElement(By.id("next")).click();
        driver.findElement(By.id("Passwd")).sendKeys("here in my password");
        driver.findElement(By.id("signIn")).click();

        // Wait for some time until it loggs into the account
        Thread.sleep(5000);

        // Now, get list of readed emails
        List<WebElement> markedReadMails = driver.findElements(By.xpath("//*[@class='zF']"));

        // The mail entry to be marked as un read

        WebElement theFirstMarkedReadMail = null;

        // The option that makes mail unread

        WebElement markAsUnreadOption = driver.findElement(By.xpath("//*[@class='context-menu-list context-menu-root']//li[7]"));

        // TO get the un read mail

        for(int i=0;i<markedReadMails.size();i++){
            if(markedReadMails.get(i).isDisplayed()==true){
                // now verify if you have got mail form a specific mailer (Note Un-read mails)
                theFirstMarkedReadMail  = markedReadMails.get(i);
                }
            }
        // Action object to perform click operations
        Actions actions = new Actions(driver);

        // right click the already read mail entry
        actions.contextClick(theFirstMarkedReadMail).build().perform();

        // Click the option element

        markAsUnreadOption.click();



    }
}
