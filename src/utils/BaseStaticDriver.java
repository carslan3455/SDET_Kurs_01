package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.concurrent.TimeUnit;

public class BaseStaticDriver {

    public static WebDriver driver;

    static {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver", "C://Users//moham//OneDrive//Desktop//Noname//Staj Dosyasi//TR-SDET_Kurs//SELENIUM//Driver//chromedriver92.107.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);  // driver ilk acilirken yuklenmesini bekletiyoruz
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//        // her element icin bekleme suresi.

    }


}
