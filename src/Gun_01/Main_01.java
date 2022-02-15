package Gun_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main_01 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C://Users//moham//OneDrive//Desktop//Noname//Staj Dosyasi//TR-SDET_Kurs//SELENIUM//Driver//chromedriver92.107.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.de/");

        WebElement onay = driver.findElement(By.id("L2AGLb"));
        onay.click();

        WebElement arama = driver.findElement(By.cssSelector("input[title='Suche']"));
        arama.sendKeys("telefon");

        // Class    .
        //id       #

//        Thread.sleep(1000);
//        driver.quit();

    }

}
