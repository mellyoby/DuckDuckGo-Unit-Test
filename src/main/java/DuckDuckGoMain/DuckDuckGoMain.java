package DuckDuckGoMain;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert.*;

public class DuckDuckGoMain {
    private WebDriver driver;

    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://duckduckgo.com");
        Thread.sleep(5000);

        //1.maximize the window
        driver.manage().window().maximize();

        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("Lesson");
        driver.findElement(By.id("search_button_homepage")).click();
        driver.findElement(By.cssSelector(".result__a")).click();

        String text =  "https://www.toptal.com";
        String bodyText = driver.findElement(By.tagName("body")).getText();
        if(bodyText.contains(text) == false){
            System.out.println("wrong URL returned!");
        }
        
        //Assert.assertTrue("wrong URL returned!", bodyText.contains(text));
    }

    public static void main(String args[]) throws InterruptedException {
        DuckDuckGoMain test= new DuckDuckGoMain();
        test.setUp();


    }
}
