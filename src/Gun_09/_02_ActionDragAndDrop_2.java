package Gun_09;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _02_ActionDragAndDrop_2 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement norvec = driver.findElement(By.id("box101"));

        System.out.println("oslo tasinmadan önce = " + oslo.getCssValue("background-color"));

        Actions builder = new Actions(driver);
//        Thread.sleep(1000);
        Action action = builder.dragAndDrop(oslo,norvec).build();
                                // tasinan oslo  - hedef norvec
        action.perform();
        System.out.println("oslo tasindiktan sonra = " + oslo.getCssValue("background-color"));

        String expected = "rgba(0, 255, 0, 1)";

        Assert.assertEquals(expected,oslo.getCssValue("background-color"));


        WebElement madrid = driver.findElement(By.id("box7"));
        WebElement ispanya = driver.findElement(By.id("box107"));

        action = builder.dragAndDrop(madrid,ispanya).build();
        // yukarida ( 19.satir) tanimladigimiz action direk kullandik
        action.perform();


        Assert.assertEquals(expected,madrid.getCssValue("background-color"));

        Thread.sleep(1000);
        driver.quit();



    }
}
