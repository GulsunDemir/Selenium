package techproed.day02_DriverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_ManagerMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Browser'ın konumunu yazdıralım
        System.out.println("Sayfanin konumu : " + driver.manage().window().getPosition());

        //Browser'ın boyutlarını yazdıralım
        System.out.println("Sayfanin Boyutlari : " + driver.manage().window().getSize());

        //Browser'ı maximize yapalım
        driver.manage().window().maximize();
        /*
        Bir web sitesine gittiginizde browser default olarak bir boyutta gelir. Ve acilan browsre'daki
        webElementlere browser maximize olmadigi icin ulasamayabiliriz. Dolayisiyla browser'i actiktan
        sonra maximize yaparsak driver butu webElementleri gorur ve rahatlikla mudahale edebilir. Bu yuzden
        browser'ı actiktan sonra ilk olarak  driver.manage().window().maximize(); yapmamiz bizim webElementlere
        ulasmada isimizi kolaylastirir. Böylelikle fail almamış oluruz
         */

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //Browser'ın konumunu yazdıralım
        System.out.println("Sayfanin konumu : " + driver.manage().window().getPosition());

        //Browser'ın boyutlarını yazdıralım
        System.out.println("Sayfanin Boyutlari : " + driver.manage().window().getSize());
        Thread.sleep(3000);

        //Sayfayı minimize yapalım
        driver.manage().window().minimize();
        Thread.sleep(3000);

        //Sayfayı fullScreen yapalım
        driver.manage().window().fullscreen();
        Thread.sleep(3000);

        driver.manage().window().setPosition(new Point(50,50));//Istedigimiz konuma getirir
        driver.manage().window().setSize(new Dimension(600,600)); //istediğimiz size'a getirir

        //sayfayi kapatiniz
        driver.close();
        //Sayfanin icinde gordugumuz tum kutucuklar tum kisimlar birer
        // web elementidir.Bunlarin butunu web sayfasini olusturur.

    }
}
