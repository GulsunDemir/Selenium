package techproed.day06day06_relativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class C01_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazona gidelim
        driver.get("https://amazon.com");

        //city bike aratalim
        WebElement aramaKutusu = driver.findElement(By.xpath("(//*[@class='nav-input nav-progressive-attribute'])[1]"));
        aramaKutusu.sendKeys("city bike" + Keys.ENTER);

        //relative locator kullanarak hybrid bikes altindaki elemente tiklayalim
        //WebElementleri yazisini consola yazdiralim
        WebElement hybridBike = driver.findElement(By.xpath("//*[text()='Hybrid Bikes']"));
        System.out.println(hybridBike.getText());
        WebElement electircBike = driver.findElement(with(By.tagName("a")).below(hybridBike));
        System.out.println(electircBike.getText());
        WebElement completeBike = driver.findElement(with(By.tagName("a")).below(electircBike));
        System.out.println(completeBike.getText());
        System.out.println("****************************");

        //Bikes altindaki tum linkleri(webelement) konsola yazdiralim

        List<WebElement> linklerListesi = driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>=9 and position()<=15]"));
        /*
            XPATH kullaniminda bir sayfadaki webelementlere mudehale etmek istedigimizde xpath ile locate aldigimizda
       birden fazla sonuc verebilir. [position()>=9 and position()<=15] bu kullanimla aralik belirterek istedigimiz
       WE leri seciğ mudehale edebiliriz
         */

        //lambda ile yazdirdik
        linklerListesi.forEach(t-> System.out.println(t.getText()));
        System.out.println("***************************************");

        //forech ile yazdirdik
        for (WebElement w:linklerListesi){
            System.out.println(w.getText());
        }
        //Bu linklerin hepsini tıklayalim ve sayfa basliklarini alalim
        for (int i = 0; i < linklerListesi.size(); i++) {
            linklerListesi = driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>=9 and position()<=15]"));
            System.out.println(linklerListesi.get(i).getText());
            linklerListesi.get(i).click();
            Thread.sleep(3000);

            driver.navigate().back();

            Thread.sleep(3000);

        }
//        //Bu linklerin hepsini tıklayalım ve sayfa başlıklarını alalım
//        for (int i = 0; i < linlkerListesi.size(); i++) {
//            linlkerListesi = driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>=9 and position()<=15]"));
//            System.out.println(linlkerListesi.get(i).getText());
//            linlkerListesi.get(i).click();
//            Thread.sleep(3000);
//            driver.navigate().back();
//            Thread.sleep(3000);
//        }
        ////Bu linklerin hepsini tıklayalım ve sayfa başlıklarını alalım
        //for (int i = 0; i < linlkerListesi.size(); i++) {
        //    linlkerListesi = driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>=9 and position()<=15]"));
        //    linlkerListesi.get(i).click();
        //    Thread.sleep(3000);
        //    driver.navigate().back();
        //    Thread.sleep(3000);
        //}
        //List<WebElement> linlkerListesi2 = driver.findElements(By.xpath("(//*[@class='a-list-item'])[position()>=10 and position()<=16]"));
        //linlkerListesi2.forEach(t-> System.out.println(t.getText()));




        completeBike.click();


    }
}
