package Gun_12;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _03_WaitOrnek extends BaseStaticDriver {
    /**
     * https://www.demoblaze.com/index.html  siteye gidiniz
     *     Samsung galaxy s6  ürününü aciniz
     *     AddToCart butonuna basiniz
     *     alert kutusu cikana kadar bekleyiniz
     *     Alert kabul edin.
     *
     */


    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement product_S6 = driver.findElement(By.linkText("Samsung galaxy s6"));
        product_S6.click();

        WebElement addToCart = driver.findElement(By.cssSelector("a[onclick='addToCart(1)']"));
        addToCart.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());  // Alert görünür oluncaya kadar bekle
        wait.until(ExpectedConditions.attributeToBe(By.xpath("a[onclick='addToCart(1)']"),"class","addToCart"));

        String alertMesaj = driver.switchTo().alert().getText();
        System.out.println("alertMesaj = " + alertMesaj);
        Assert.assertEquals("Product added",alertMesaj);
//        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        driver.quit();

    }
}
