package Gun_06;

import Gun_03._01_Try_Catch;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.ArrayList;
import java.util.List;

public class _01_Xpath extends BaseStaticDriver {

    /**
     * https://www.saucedemo.com/  siteye git
     * Bütün ürünleri sepete ekle
     * Sepete git
     * Sepetteki ürünleri önceki ürünlerle kiyasla
     * dogruysa Checkout butonuna tikla
     * Cikan formu doldur
     * Continue butonuna tikla
     * Total fiyati kiyasla
     * Finish butonuna tikla
     * "THANK YOU FOR YOUR ORDER" yazisinin sayfada oldugunu onayla
     * Back Home basip bulundugu sayfanin url kontrol et "https://www.saucedemo.com/inventory.html"
     */

    public static void main(String[] args) throws InterruptedException {

        _01_Try_Catch.login("standard_user", "secret_sauce");

        List<WebElement> urunlist1 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        // todo Linktext ve PartiallinkText ile olan metinler a tagName ile bulunur. a Tagname ve diger butun textler xPath ile bulunabilir.
        // todo fakat eger site farkli dil secenekleri ile yapilmissa testimiz sadece tek bir dil ile calisir.
        List<String> list1 = new ArrayList<>();
        // todo elementin getText ini alacagimiz icin String List olusturduk.

        for (WebElement urun : urunlist1) {
            list1.add(urun.getText());
        }
        System.out.println(list1);

        List<WebElement> urunPrice1 = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<String> price1 = new ArrayList<>();

        for (WebElement price : urunPrice1) {
            price1.add(price.getText());
        }
        System.out.println(price1);

        List<WebElement> addToCart = driver.findElements(By.xpath("//button[text()='Add to cart']"));

        for (WebElement e : addToCart) {
//            System.out.println(e.getText());
            e.click();

        }

        WebElement sepet = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        sepet.click();

        List<WebElement> urunList2 = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> list2 = elementToString(urunList2);
        // Cleancode mantigi icin elementi String liste atan method olusturduk

        List<WebElement> urunPrice2 = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<String> price2 = elementToString(urunPrice2);

        if (list1.size() == list2.size()) {
            stringListKontrol(list1, list2);
        } else System.out.println("Listenin uzunlugu esit degil");

        System.out.println("*********************");

        if (price1.size() == price2.size()) {
            stringListKontrol(price1, price2);
        } else System.out.println("Listenin uzunlugu esit degil");


        WebElement checkOut = driver.findElement(By.xpath("//button[@data-test='checkout']"));
        checkOut.click();

        WebElement firstName = driver.findElement(By.xpath("//input[starts-with(@data-test,'first')]"));
        firstName.sendKeys("Kraft");

        WebElement lastName = driver.findElement(By.xpath("//input[starts-with(@data-test,'last')]"));
        lastName.sendKeys("Techno");

        WebElement zip = driver.findElement(By.xpath("//input[contains(@data-test,'postal')]"));
        zip.sendKeys("12345");

        WebElement next = driver.findElement(By.xpath("//input[@value='Continue']"));
        next.click();

        WebElement totalPrice = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));

        double sumPrice =0.0;

        for (String p:price2) {
            sumPrice+=stringToDouble(p);
        }

        System.out.println("sumPrice = " + sumPrice);

        double totalDouble = stringToDouble(totalPrice.getText());
        System.out.println("totalDouble = " + totalDouble);
        Assert.assertTrue(sumPrice==totalDouble);

        if (sumPrice==totalDouble){
            System.out.println("Fiyat toplami dogru");
        }


//        String sumText = String.valueOf(sumPrice) ;
//
//        Assert.assertTrue(totalPrice.getText().contains(sumText));
//        if (totalPrice.getText().contains(sumText)){
//            System.out.println("Fiyat toplami dogru");
//        }


        WebElement finish = driver.findElement(By.xpath("//button[contains(text(),'Finis')]"));
        finish.click();

        WebElement success= driver.findElement(By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']"));
        String result=success.getText();
        String expected="THANK YOU FOR YOUR ORDER";

        Assert.assertEquals("Alisverisinizde bir sorun cikti....",result,expected);
        if (result.equalsIgnoreCase(expected))
            System.out.println("**** THANK YOU FOR YOUR ORDER ****");

        WebElement backHome=driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small']"));
        backHome.click();

        String expected_url= driver.getCurrentUrl();
        String url="https://www.saucedemo.com/inventory.html";

        Assert.assertEquals("Yanlis sayfadasiniz....",expected_url,url);


        Thread.sleep(3000);
        driver.quit();

    }


    public static List<String> elementToString(List<WebElement> list) {

        List<String> textList = new ArrayList<>();

        for (WebElement element : list) {
            textList.add(element.getText());
        }

        return textList;
    }

    public static void stringListKontrol(List<String> list1, List<String> list2) {

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).equals(list2.get(i))) {
                System.out.println(list1.get(i) + " Urun sepette var...");
            }

//            Assert.assertEquals("Bilgiler eslesmedi",list1.get(i),list2.get(i));
        }

    }

    public static double  stringToDouble(String text){

        //($12.9) (Item total: $9.99)  rakam ve . disinda herseyi temizle dedigimiz icin ikisi icinde gecerli oldu
        String rakamText = text.replaceAll("[^\\d.]","");  // todo text.replaceAll("[^0-9,.]","")  -   text.replaceAll("[$]","")

        return Double.parseDouble(rakamText);
    }

}
