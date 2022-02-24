package Gun_09;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _03_ActionDragandDropBy extends BaseStaticDriver {
    public static void main(String[] args) {

        driver.get("http://talkerscode.com/webtricks/demo/demo_price-range-slider-using-jquery-css-and-php.php");

        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement slider_1 =driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-state-default ui-corner-all'])[1]"));
        WebElement slider_2 =driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-state-default ui-corner-all'])[2]"));

        Actions builder = new Actions(driver);

        Action slider_1_Geri = builder.dragAndDropBy(slider_1,-48,0).build();
                // islem yapacagim elementi seciyorum, x ekseninde hangi yöne hareket edeceksem onu yaziyorum.
               // y ekseninde hareket olmayacagi icin sifir kaldi

        slider_1_Geri.perform();

        Action slider_2_Ileri = builder.dragAndDropBy(slider_2,50,50).build();
        slider_2_Ileri.perform();


    }
}
