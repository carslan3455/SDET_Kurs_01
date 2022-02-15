package Gun_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _02_By_partialLinktext {

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "C://Users//moham//OneDrive//Desktop//Noname//Staj Dosyasi//TR-SDET_Kurs//SELENIUM//Driver//chromedriver92.107.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();


        WebElement urun_1_partial = driver.findElement(By.partialLinkText("Backpack")); // partialLinkText yalnizca "a" Tagname li lokasyonda kullanilir
                                                                                        // Text in bir parcasini alarak arama yapiyoruz(contains gibi)
        System.out.println("urun_1_partial = " + urun_1_partial.getText());
        urun_1_partial.click();





    }
}
