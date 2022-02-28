package Gun_11;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.Collections;
import java.util.List;

public class _07_Proje4_Yontem_2 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        WebElement[][] webElements = new WebElement[5][];
        webElements[0] = new WebElement[4];
        webElements[1] = new WebElement[4];
        webElements[2] = new WebElement[4];
        webElements[3] = new WebElement[3];
        webElements[4] = new WebElement[6];

        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");

        Actions builder= new Actions(driver);

        List<WebElement> students = driver.findElements(By.xpath("//ul[@id='allItems']/li"));

        List<WebElement> teams = driver.findElements(By.cssSelector("ul[id^='box']"));

//        Collections.reverse(teams);

        Action action;
//        for (WebElement student : students) {
//            for (WebElement team : teams) {
//                action=builder.clickAndHold(student).moveToElement(team).release(team).build();
//                action.perform();
//            }
//        }



        int ogrSayi=0;
        for (int i = 0; i < teams.size(); i++) {
            String line= teams.get(i).getAttribute("style").replaceAll("[^0-9]","");
            int lineCount=Integer.parseInt(line);
            int tableLine = (int)(lineCount/26);
            for (int j = 0; j < tableLine; j++) {
                builder.clickAndHold(students.get(ogrSayi)).moveToElement(teams.get(i)).release(teams.get(i)).build().perform();
                ogrSayi++;
                if(j==tableLine) break;
            }
        }



//        List<WebElement> boxList;
//
//        for (int i = 1; i <= webElements.length; i++) {
//            boxList = driver.findElements(By.cssSelector("ul#box" + i  + " li"));//li den önce boşluk var ,dikkat
//            Assert.assertEquals(boxList.size(),webElements[i-1].length);
//
//        }

        Thread.sleep(2000);
//        driver.quit();

    }
}
