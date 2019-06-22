import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumEmailUnreader {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/home/hizkias/Documents/program setups/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless");
//        chromeOptions.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://google.com");

        Thread.sleep(5000);
        System.out.println(driver.getTitle());
        if(driver.getPageSource().contains("I'm Feeling Lucky")){
            System.out.println("Pass");
        }
        else {
            System.out.println("Failed");
        }
    }
}
