package Gun_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class _04_Elements_List {
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

        List<WebElement> urunIsimListesi = driver.findElements(By.className("inventory_item_name"));

        for (WebElement webElement : urunIsimListesi) {
            System.out.println(webElement.getText());
        }


    }
}
