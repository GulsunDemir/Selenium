package techproed.day01_IlkTest_DriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_IlkTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        //Java uygulamarinda system ozelliklerini ayarlamak icin setProperty methodu ile kullaniriz
        //setProperty metodu ile class'imiza driver'in fiziki yolunu belirtiriz.
        System.out.println(System.getProperty("webdriver.chrome.driver"));
        //getProperty ile "Key" değerini girerek "value" a ulaşılabilir.
        WebDriver driver = new ChromeDriver();
        //ChromeDriver turunde yeni bir obje olusturduk
        driver.get("https:techproeducation.com"); //get() metodu ile String olarak girilen url'e gideriz

    }
}
