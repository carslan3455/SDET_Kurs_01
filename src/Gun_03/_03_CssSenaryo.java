package Gun_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _03_CssSenaryo extends BaseStaticDriver {

    /**
     * https://formsmarts.com/form/yu?mode=h5  siteye acin
     * Business  secelim
     * Online Advertising - secelim
     * Every Day    - secelim
     * Average        - secelim
     * I'm using XYZ for about a week  - secelim
     * Message kismina bir yazi gönderelim
     */


    public static void main(String[] args) throws InterruptedException {

        driver.get("https://formsmarts.com/form/yu?mode=h5");
        Thread.sleep(2000);

        WebElement business = driver.findElement(By.cssSelector("input[id='u_Vml_4586_0']"));
        business.click();

        WebElement select_1 = driver.findElement(By.cssSelector("select[id='u_Vml_4588']"));
        select_1.click();

        Thread.sleep(2000);

        WebElement onlineAdvertising = driver.findElement(By.cssSelector("option[value='Online Advertising']"));
        onlineAdvertising.click();

        WebElement everDay = driver.findElement(By.cssSelector("input[id='u_Vml_89585_0']"));
        everDay.click();

        WebElement average = driver.findElement(By.cssSelector("input[id='u_Vml_4589_1']"));
        average.click();

        WebElement select_2 = driver.findElement(By.cssSelector("select[id='u_Vml_4597']"));
        select_2.click();

        WebElement week = driver.findElement(By.cssSelector("option[value=\"I'm using XYZ for about a week\"]"));
           // Eger lokasyon icerisinde tek tirnak ' kullaniliyorsa cift tirnak " kullanarak lokasyunu daha rahat bulabiliriz.
        week.click();

        WebElement message = driver.findElement(By.cssSelector("textarea[id='u_Vml_89597']"));
        message.sendKeys("Bu bir Selenium Testidir");

//        WebElement tarih = driver.findElement(By.cssSelector("input[id='u_Vml_14597']"));
//        tarih.sendKeys("16.02.2022");



//        System.out.println("Test");

        Thread.sleep(4000);
        driver.quit();
    }
}
