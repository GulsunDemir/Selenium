package techproed.day05_XpathCssSelectorNT;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com sayfasına gidiniz
        driver.get("https://www.amazon.com");

        // arama kutusuna "city bike"  yazıp aratın
        /*
        ARAMA KUTUSU HTML KODLARI
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
        placeholder="Search Amazon" class="nav-input nav-progressive-attribute" dir="auto"
        tabindex="0" aria-label="Search Amazon" spellcheck="false">
         */
        //WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        //WebElement aramaKutusu =driver.findElement(By.xpath("//*[@name='field-keywords']"));
        //WebElement aramaKutusu =driver.findElement(By.xpath("//input[@type='text']"));
        WebElement aramaKutusu = driver.findElement(By.xpath("(//*[@class='nav-input nav-progressive-attribute'])[1]"));
        aramaKutusu.sendKeys("city bike" + Keys.ENTER);
        // Hybrid Bikes bölümüne tıklayın
        driver.findElement(By.xpath("//*[text()='Hybrid Bikes']")).click(); //-->//*[.='Hybrid Bike'] bu sekildede alabilirim

        // sonuc sayısını yazdırın
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(sonucYazisi.getText());

        String[] sonucSayisi = sonucYazisi.getText().split(" ");

        //14 results for "city bike" bu yazinin locate'i
        System.out.println("Sonuc Sayisi: " + sonucSayisi[0]);

        // ilk ürününe tıklayın
        //driver.findElement(By.xpath("(//h2)[1]")).click();
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click(); //-->(//h2)[1] baslikla da alinabilir
        // Sayfayı kapatınız
        driver.close();

    }
}
