package Gun_07;

import Gun_03._01_Try_Catch;
import Gun_06._01_Xpath;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _01_RandomUrunKontrol extends BaseStaticDriver {

    /**
     * https://www.saucedemo.com/  siteye git
     * random bir urun sec
     * urune tikla
     * bilgilerini kontrol et
     *
     */

    public static void main(String[] args) throws InterruptedException {

        _01_Try_Catch.login("standard_user", "secret_sauce");

        List<WebElement> urunlist1 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> list1 = _01_Xpath.elementToString(urunlist1);

        List<WebElement> urunPrice1 = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<String> price1 = _01_Xpath.elementToString(urunPrice1);

        List<WebElement> addToCart = driver.findElements(By.xpath("//button[text()='Add to cart']"));

        int random = randomSayi(urunlist1.size());
        String randamUrunText = list1.get(random);
        String randamUrunPrice = price1.get(random);

        addToCart.get(random).click();
        urunlist1.get(random).click();

        String sepetUrunName = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText();
        String sepetUrunPrice = driver.findElement(By.xpath("//div[@class='inventory_details_price']")).getText();

        Assert.assertEquals(randamUrunText,sepetUrunName);
        Assert.assertEquals(randamUrunPrice,sepetUrunPrice);

        System.out.println("sepetUrunPrice = " + sepetUrunPrice);
        System.out.println("sepetUrunName = " + sepetUrunName);


        Thread.sleep(2000);
        driver.quit();

    }


    public static int randomSayi(int size){

        return (int) (Math.random()*size);
    }

}
