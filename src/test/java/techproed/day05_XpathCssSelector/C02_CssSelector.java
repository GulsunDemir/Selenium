package techproed.day05_XpathCssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CssSelector {
    /*
   cssSelector ile xpath arasındaki farklar;
   1- cssSelector de @ işareti ve // işaretleri kullanılmaz
   2- xpath ile index alabiliriz ama cssSelector ile index alamayız
   3- xpath ile text olarak locate edebiliriz ama cssSelector ile bunu yapamayız
   4- cssSelector xpath'e göre daha hızlı çalışır
    */
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //Add Element butonuna basin
        WebElement addElementButton =driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        addElementButton.click();

        Thread.sleep(2000);

        //Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButton = driver.findElement(By.cssSelector("button[class='added-manually']"));
        //System.out.println("deleteButton Gorunuyor mu = " + deleteButton.isDisplayed());
        if (deleteButton.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //Delete tusuna basin
        deleteButton.click();
        Thread.sleep(2000);

        //“Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoceElements = driver.findElement(By.cssSelector("h3"));
        if (addRemoceElements.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");

        //Sayfayi kapatalim
        driver.close();

    }
}
