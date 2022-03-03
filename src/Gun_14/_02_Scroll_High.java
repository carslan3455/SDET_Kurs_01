package Gun_14;

import org.openqa.selenium.JavascriptExecutor;
import utils.BaseStaticDriver;

import java.time.Duration;

public class _02_Scroll_High extends BaseStaticDriver {

    /*
    js.executeScript("scroll(0, 250);");
    js.executeScript("window.scrollBy(0,500)")
    js.executeScript("arguments[0].scrollIntoView(true);",element);
    js.executeScript("arguments[0].scrollIntoView(false);",element);
    js.executeScript("arguments[0].scrollIntoView();",element);
    js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");


     */

    public static void main(String[] args) throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        // Site Otomatik test edildigini anladiginda kendini korumaya alabiliyor.
        // Cookiesler temizlendiginde bu sorunu asabiliyoruz
        driver.get("https://triplebyte.com/");

        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");  // Scrool ile Sayfanin en sonuna gitmemizi sagliyor

        Thread.sleep(1000);

        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");  // Scrool ile  sayfanin en basina dönmemizi sagliyor




    }
}
