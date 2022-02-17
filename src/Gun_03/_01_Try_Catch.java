package Gun_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _01_Try_Catch extends BaseStaticDriver {

    public static void main(String[] args){

        login("standard_user","secret_sauce");

        try {
            WebElement urun = driver.findElement(By.cssSelector("img[alt='Sauce Labs Backpac']"));
                                                // Dogru Lokasyon "img[alt='Sauce Labs Backpack']"
            urun.click();

        }catch (Exception ex){
            System.out.println("***** Element Bulunamadi **** = " + ex.getMessage());
        }

        WebElement urun = driver.findElement(By.cssSelector("img[alt='Sauce Labs Backpack']"));
        urun.getText();

    }

    public static void login(String user, String pass){

        driver.get("https://www.saucedemo.com/");
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys(user);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(pass);

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();


    }

}
