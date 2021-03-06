package Gun_02;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.List;

public class _05_AddToCart {

    /**
     * https://www.saucedemo.com/  siteye git
     * username ve password gir
     * login click yap
     * AddToCart Butonlarini listeye alip click yap
     * Sonra Remove Butonlarini listeye alip click yap
     * Sitenin link Assert ile kontrol edelim
     *
     *
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
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


        List<WebElement> addToCarts=driver.findElements(By.cssSelector("button[class='btn btn_primary btn_small btn_inventory']"));

        for (WebElement elementCarts: addToCarts) {

            System.out.println("elementCarts.getText() = " + elementCarts.getText());
            elementCarts.click();
        }


        Thread.sleep(2000);

        List<WebElement> addToCartsRemove=driver.findElements(By.cssSelector("button[class='btn btn_secondary btn_small btn_inventory']"));

        for (WebElement remove:addToCartsRemove) {
            remove.click();

        }

        String url = driver.getCurrentUrl();
        String expected="https://www.saucedemo.com/inventory.html";

        Assert.assertEquals("Yanlis adrestesiniz",expected,url);  // Buradaki mesaj kod hata verdiginde ekrana yansiyor.
//        Assert.assertFalse("Testiniz Basari ile tamamlandi",url.equals(expected));  // Bu kod kodlama mantigina uygun degil

        //  Eger Assert sonucu dogruysa bu mesaji ekrana yazdiralim.
        //  "Testiniz Basari ile tamamlandi"


        if (url.equals(expected)){
            System.out.println("Testiniz Basari ile tamamlandi");
        }


    }
}
