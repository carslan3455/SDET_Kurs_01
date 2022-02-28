package Gun_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _03_Alert_Ok extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://demoqa.com/alerts");

        WebElement alert_1 = driver.findElement(By.cssSelector("button#alertButton"));
        alert_1.click();

        Thread.sleep(1000);
        driver.switchTo().alert().accept();



    }
}
