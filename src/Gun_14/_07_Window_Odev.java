package Gun_14;

import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class _07_Window_Odev extends BaseStaticDriver {

    /*
    https://techno.study/  sitesine gidiniz
    Get free consultation  butonuna click yapiniz
    acilan windowdaki email textbox  yazi gonderiniz

     */

    public static void main(String[] args)  {

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://techno.study/");

    }
}
