package Gun_08;

import Gun_03._01_Try_Catch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _01_Css_Xpath_Child extends BaseStaticDriver {

    /**
     *      Css
     *      ul li   -> ul tagName in altinda li olanlari veriyor
     *      ul>li   -> ul tagName in altinda li olanlari veriyor
     *      ul.social li:first-child    listenin ilk child almak icin    -> ul[class='social']  li:first-child
     *                                  ->ul[class='social'] > li:first-child
     *      ul.social li:last-child     listenin son child almak icin
     *      ul.social li:nth-child(2)   listede indeksli child secmek icin
     *
     *
     */

    /**
     *      Xpath
     *      //ul/li         -> ul tagName in altinda li olanlari veriyor
     *      //ul/li[1]      ->listenin ilk child almak icin
     *      //ul[@class='social']/li[1]    ->listenin ilk child almak icin
     *      //ul[@class='social']/li[last()]   ->listenin son child almak icin
     *      //ul[@class='social']/li[2]         ->listede indeksli child secmek icin
     *
     */

    public static void main(String[] args) {

        _01_Try_Catch.login("standard_user", "secret_sauce");

        WebElement faceBook = driver.findElement(By.cssSelector("ul.social li:nth-child(2)"));
        System.out.println("faceBook = " + faceBook.getText());
//        faceBook.click();

        WebElement linkedIn = driver.findElement(By.xpath("//ul[@class='social']/li[last()]"));
        System.out.println("linkedIn = " + linkedIn.getText());
//        linkedIn.click();

        List<WebElement> social = driver.findElements(By.xpath("//ul/li"));

        for (WebElement e: social) {
            System.out.println("e = " + e.getText());
        }



    }

}
