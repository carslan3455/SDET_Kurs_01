package Gun_03;

import com.sun.source.tree.TryTree;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _02_NavigateTo extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

//        _Try_Catch.login("standard_user","secret_sauce");
// Metodun icinde driver.get () özelligi kullanildigi icin burada bu methodu kullanmadik

        driver.navigate().to("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        Thread.sleep(5000);

        WebElement urun = driver.findElement(By.cssSelector("img[alt='Sauce Labs Backpack']"));
        urun.click();

        Thread.sleep(5000);

        driver.navigate().back();
        //https://www.saucedemo.com/inventory.html
        String backSite = driver.getCurrentUrl();   // Chrome uzerinden islem yaptigimiz icin driver kullanildi
//        String text = element.getText();     // element uzerinden islem yaparken elementi baz aliyoruz

        try {
            String expected1 = "https://www.saucedemo.com/inventory.html.";
            Assert.assertEquals("Yanlış Url !", expected1, backSite);

        }catch (AssertionError e){
         // url Assert yapilacagi zaman kendi ozel hata type yazmamiz gerekiyor  - AssertionError
            System.out.println("e.getMessage() = " + e.toString());
            System.out.println(" Assert islemi yapilamadi "  );
        }


        Thread.sleep(5000);
        driver.navigate().forward();
        // https://www.saucedemo.com/inventory-item.html?id=4
        String forwardSite = driver.getCurrentUrl();
        String expected2 = "https://www.saucedemo.com/inventory-item.html?id=4";

        Assert.assertEquals("Yanlış Url Girdiniz", expected2, forwardSite);

        if (forwardSite.equals(expected2)){
            System.out.println("**********  Dogru Sayfadasiniz  **********");
        }

        Thread.sleep(1000);
        driver.quit();      // Senaryo ile acilan butun sayfalari kapatir
       // driver.close();     // Sadece en son acik olan sayfayi kapatir


    }
}
