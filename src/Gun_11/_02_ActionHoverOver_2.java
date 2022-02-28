package Gun_11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.List;

public class _02_ActionHoverOver_2 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://www.etsy.com/");

        Thread.sleep(1000);
        WebElement akzeptieren = driver.findElement(By.xpath("//button[@class='wt-btn wt-btn--filled wt-mb-xs-0']"));
        akzeptieren.click();
        Thread.sleep(1000);

        WebElement clothing = driver.findElement(By.cssSelector("span#catnav-primary-link-10923"));
        WebElement kids = driver.findElement(By.cssSelector("span#side-nav-category-link-10941"));

        Actions builder = new Actions(driver);

//        Action action = builder.moveToElement(clothing).build();
//        action.perform();
//
//        Thread.sleep(1000);
//
//        action = builder.moveToElement(kids).build();
//        action.perform();
//

        List<WebElement> menubar = driver.findElements(By.cssSelector("ul[class='wt-list-unstyled wt-grid__item-xs-12 wt-body-max-width wt-display-flex-xs wt-justify-content-space-between'] li"));

        for (WebElement e: menubar) {
           Action action = builder.moveToElement(e).build();
            action.perform();
            Thread.sleep(1000);
        }

        Thread.sleep(1000);
        driver.quit();


    }
}
