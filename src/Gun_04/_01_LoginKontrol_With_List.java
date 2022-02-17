package Gun_04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _01_LoginKontrol_With_List extends BaseStaticDriver {

    /*
     1- https://www.saucedemo.com/  sitesini acin
     2- Ekranda gorunen usernameleri bir string diziye atiniz
     3- Bu username ve passwordlarını hepsinin login olup olamadığını
        login olduktan sonraki sayfada Products kelimesinin kontrol ederek
        doğrulayınız.
        diğer login kontrolleri için navigate.back kullanınız.
     4- Login olamayan userları ve hata bilgisini yazdırınız.
     */

    public static void main(String[] args) throws InterruptedException {

        driver.navigate().to("https://www.saucedemo.com/");

        WebElement users = driver.findElement(By.cssSelector("div.login_credentials"));

        String userText = users.getText();

//        System.out.println(userText);

        String[] userNames = userText.split("\n");
        System.out.println("userNames.length = " + userNames.length);

        for (int i = 1; i < userNames.length; i++) {

            Thread.sleep(1000);

            WebElement userName = driver.findElement(By.id("user-name"));
            userName.clear();
            userName.sendKeys(userNames[i]);


            WebElement password = driver.findElement(By.id("password"));
            password.clear();
            password.sendKeys("secret_sauce");

            WebElement login = driver.findElement(By.id("login-button"));
            login.click();

            List<WebElement> products = driver.findElements(By.cssSelector("span[class='title']"));
//            WebElement products = driver.findElement(By.cssSelector("span[class='title']"));
//            if (products.isEnabled())
//                 Verdigimiz konumda eger element yoksa hata verir. Sonra yapmak istedigimiz islemleri yapamayiz
            if (products.size()==1){

                System.out.println(userNames[i] + " : Bu username ile Login olundu....");
                Thread.sleep(1000);
                driver.navigate().back();

            }else {

                WebElement erorMessage = driver.findElement(By.cssSelector("div[class='error-message-container error']"));
                System.out.println(userNames[i] + " : Bu username ile Login olunumadi.... " + erorMessage.getText() );
            }





        }



    }
}
