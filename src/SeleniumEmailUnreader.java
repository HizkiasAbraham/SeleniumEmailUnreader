import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SeleniumEmailUnreader {
    public static void main(String[] args) throws InterruptedException {
        // setting up the chrome driver
        System.setProperty("webdriver.chrome.driver", "/home/hizkias/Documents/program setups/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();

        WebDriver driver = new ChromeDriver(chromeOptions);


        // Open the gmail login page
        driver.get("http://mail.google.com");
        driver.manage().timeouts().implicitlyWait(30, SECONDS);

        // logging into my account
        driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("myEmail@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("myPassword");
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span")).click();

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

        driver.close();

    }
}
