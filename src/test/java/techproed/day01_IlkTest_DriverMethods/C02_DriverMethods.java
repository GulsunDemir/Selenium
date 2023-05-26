package techproed.day01_IlkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");
        //getTitle() Sayfa basligini verir
        System.out.println("Amazon Actual Title = " + driver.getTitle());
        System.out.println("Amazon Actual url= " + driver.getCurrentUrl());
        String amazonWindowHanle = driver.getWindowHandle();
        System.out.println("Amazon Window Handle Değeri : "+amazonWindowHanle);

        driver.get("https://techproeducation.com");
        System.out.println("Techproeducation Actual Title : "+driver.getTitle()); //getTitle() metodu basligini verir

        //getCurrent() Gidilen sayfanin url'ini verir.
        System.out.println("Techroed Actual url= " + driver.getCurrentUrl());

        //getPageSource() Acilan sayfanin kaynak kodlarini verir
        //System.out.println("Sayfa Kaynak Kodlari = " + driver.getPageSource()); bilerek yoruma aldik her calistirdigimizda consola butun kaynak kodlarini verecegi icin

        //getWindowHandle() Gidilen sayfanin handle degerini(hashKod) verir. Bu handle degerini sayfalar arasi gecis icin kullaniriz
        System.out.println("Techproed Window Handle Degeri = " + driver.getWindowHandle()); //3969F5CF612086A4E4D96D5F3A209833


    }
}
