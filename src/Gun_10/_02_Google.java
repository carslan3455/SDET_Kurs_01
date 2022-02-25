package Gun_10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _02_Google extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.google.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[text()='Ich stimme zu']")).click();

        WebElement google = driver.findElement(By.cssSelector("input.gLFyf.gsfi"));
        google.click();
        google.sendKeys("Selenium");
        Thread.sleep(1000);
        Actions builder = new Actions(driver);
        Action enter = builder.sendKeys(Keys.SPACE).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build();
        // Tusa sadece bir kere yaptirdigimiz islem icin sendKeys özelligini kullaniyoruz
        enter.perform();

        Thread.sleep(2000);

        enter = builder.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ENTER).build();
        enter.perform();

        Thread.sleep(1000);
        driver.quit();

    }
}
