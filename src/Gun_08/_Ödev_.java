package Gun_08;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _Ödev_ extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://form.jotform.com/220525974190356");

        WebElement firstName = driver.findElement(By.cssSelector("input[id='first_3']"));
        firstName.sendKeys("aba");

        WebElement lastName = driver.findElement(By.cssSelector("input[id='last_3']"));
        lastName.sendKeys("aba");

        WebElement areaCode= driver.findElement(By.cssSelector("input[id='input_13_area']"));
        areaCode.sendKeys("+90");

        WebElement phoneNumber=driver.findElement(By.cssSelector("input[id='input_13_phone']"));
        phoneNumber.sendKeys("3124395649");


        WebElement email=driver.findElement(By.cssSelector("input[id='input_4']"));
        email.sendKeys("abbaba@gmail.com");


        JavascriptExecutor js =(JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,500)");
        //        js.executeScript("arguments[0].scrollIntoView();", element);
        Thread.sleep(1000);

        WebElement sdet=driver.findElement(By.id("label_input_11_1"));
        sdet.click();
        System.out.println("sdet = " + sdet.isSelected());

        WebElement developers=driver.findElement(By.id("label_input_11_2"));
        developers.click();

        WebElement dailyWorking= driver.findElement(By.id("label_input_14_1"));
        dailyWorking.click();

        WebElement goodTest=driver.findElement(By.id("label_input_15_1"));
        goodTest.click();

        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(1000);

        WebElement engineerTest=driver.findElement(By.xpath("//label[@id='label_input_15_0']"));
        engineerTest.click();

        WebElement messageArea=driver.findElement(By.xpath("//textarea[@id='input_8']"));
        messageArea.sendKeys("Bu Bir Test Mesajıdır.");

        js.executeScript("window.scrollBy(0,1000)");   // todo sayfanin scroll yapilan yerinden tekrar scroll yapmasini istedik hata vermedi

        WebElement submit = driver.findElement(By.xpath("//button[@id='input_2']"));
        submit.click();


        driver.quit();


    }
}
