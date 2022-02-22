package Gun_07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _03_CssValueOrnegi {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C://Users//moham//OneDrive//Desktop//Noname//Staj Dosyasi//TR-SDET_Kurs//SELENIUM//Driver//chromedriver92.107.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://form.jotform.com/220466667555061");

        WebElement name= driver.findElement(By.id("first_3"));

        System.out.println("Click ten önce : "+name.getCssValue("border-color"));

        name.click();
        WebElement surname= driver.findElement(By.id("last_3"));
        surname.click();


        WebElement email= driver.findElement(By.id("input_4"));
        email.click();
//        System.out.println(surname.getCssValue("border-color"));
        System.out.println("Clickten sonra : "+name.getCssValue("border-color"));



    }
}
