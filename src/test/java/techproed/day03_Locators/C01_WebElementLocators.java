package techproed.day03_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C01_WebElementLocators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//web sayfasindaki tum webelementlerin yuklenebilmesi icin gereken max sure

        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");

        // aramakutusunu locate ediniz ve Nutella aratınız
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);  //bu locators Birde fazla kullanilacaksa assignment edilir

        /*
        Not:Eger bir webelement'i birden fazla kez kullanmayacaksaniz bir webelement'e assignment etmeyebilirsiniz
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
         */


        Thread.sleep(2000);

        // sayfayı kapatınız
        driver.close();
            }
}