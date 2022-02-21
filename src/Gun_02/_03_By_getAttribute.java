package Gun_02;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _03_By_getAttribute {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C://Users//moham//OneDrive//Desktop//Noname//Staj Dosyasi//TR-SDET_Kurs//SELENIUM//Driver//chromedriver92.107.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        String attributeAutocorrect = password.getAttribute("autocorrect");

//        Assert.assertTrue("off".equals(attributeAutocorrect));


        System.out.println("attributeAutocorrect = " + attributeAutocorrect);

        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        String a_Class = login.getAttribute("class");       // todo linkText ve partialLinkText ile sonuc alinmiyor
        String a_Type  = login.getAttribute("type");

        System.out.println("a_Type = " + a_Type);
        System.out.println("a_Class = " + a_Class);

        login.click();






    }
}
