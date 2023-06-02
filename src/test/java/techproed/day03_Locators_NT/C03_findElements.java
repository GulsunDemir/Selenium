package techproed.day03_Locators_NT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_findElements {
    public static void main(String[] args) {
        System.setProperty("webDriver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Amazon sayfasina gidelim
        driver.get("https://amazon.com");

        //Sayfadaki linklerin sayısını ve linkleri yazdıralım
        /*
        findelement ile bir webelemente ulasabilirken, birden fazla webelement icin findelements() metodunu kullaniriz
        Bu webelementlerin sayisina ulasmak icin ya da bu webelementlerin yazisini konsola yazdirabilmek icin
        List<Webelement> linklerListesi = driver.findElementd(By.locator(locator degeri")) olarak kullaniriz
        Olusturmus oldugumuz list'i loop ile consola yazdirabiliriz
         */
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin Sayisi: "+ linklerListesi.size());//Linklerin Sayisi: 309
        /*
               for (WebElement w:linklerListesi) {
                   if (!w.getText().isEmpty()){
                       System.out.println(w.getText());
                   }
               }
        */
        //Lambda ile yazdiralim
        linklerListesi.forEach(link -> {if (!link.getText().isEmpty())
        {System.out.println(link.getText());}});

        //Shop deals in Electronics webelementinin yazisini yazdiralim
        System.out.println("*******************************");
        System.out.println(driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText());
        WebElement webElementYazisi =driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        System.out.println(webElementYazisi.getText());
        //webelementin üzerindeki yazıyı almak istiyorsak getText() methodunu kullanırız

        //sayfayi kapatalim
        driver.close();
    }
    //Amazon sayfasına gidiniz
//iphone aratınız
//çıkan sonuç yazısını konsola yazdırınız
//çıkan ürünlerden ilk 5 tanesine tıklayıp sayfa başlıklarını yazdırınız
}
