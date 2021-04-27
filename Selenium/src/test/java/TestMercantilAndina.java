import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestMercantilAndina {


    public WebDriver driver;
    public String baseUrl;
    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver","C:/Users/Crist/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("https://www.mercantilandina.com.ar/");
        driver.findElement(By.linkText("Seguros")).click();
        driver.findElement(By.xpath("//img[@alt='Hogar']")).click();
        driver.findElement(By.linkText("Cotizar")).click();
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).clear();
        driver.findElement(By.id("inputName")).sendKeys("cristhian campazzo");
        driver.findElement(By.id("inputTel")).click();
        driver.findElement(By.id("inputTel")).clear();
        driver.findElement(By.id("inputTel")).sendKeys("3804312798");
        driver.findElement(By.id("inputemail")).click();
        driver.findElement(By.id("inputemail")).clear();
        driver.findElement(By.id("inputemail")).sendKeys("cristhian.campazzo@gmail.com");
        driver.findElement(By.id("tipovivienda")).click();
        new Select(driver.findElement(By.id("tipovivienda"))).selectByVisibleText("Departamento");
        driver.findElement(By.id("tipovivienda")).click();
        driver.findElement(By.id("superficie")).click();
        new Select(driver.findElement(By.id("superficie"))).selectByVisibleText("60 a 70 m2");
        driver.findElement(By.id("superficie")).click();
        driver.findElement(By.id("ubicacion")).click();
        new Select(driver.findElement(By.id("ubicacion"))).selectByVisibleText("Buenos Aires");
        driver.findElement(By.id("ubicacion")).click();
        driver.findElement(By.id("cotizador-submit")).click();
        String edificio = driver.findElement(By.id("incEdificio")).getText();
        String contenido = driver.findElement(By.id("incContenido")).getText();
        String lindero = driver.findElement(By.id("rcLindero")).getText();
        String robo = driver.findElement(By.id("robo")).getText();
        String electro = driver.findElement(By.id("electro")).getText();
        String cristales = driver.findElement(By.id("cristales")).getText();
        String hechoPrivados = driver.findElement(By.id("rcHechos")).getText();
        String agua = driver.findElement(By.id("agua")).getText();
        String pc = driver.findElement(By.id("pc")).getText();
        String costos = driver.findElement(By.id("costo")).getText();
        // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | index=1 | ]]
        // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | relative=parent | ]]
        String EdificioTitle = driver.getTitle();
        String ContenidoTitle = driver.getTitle();
        String LinderoTitle = driver.getTitle();
        String roboTitle = driver.getTitle();
        String electroTitle = driver.getTitle();
        String cristalesTitle = driver.getTitle();
        String HechosTitle = driver.getTitle();
        String aguaTitle = driver.getTitle();
        String pcTitle = driver.getTitle();
        assertEquals(EdificioTitle, "Seguro de hogar - Mercantil andina");
        assertEquals(ContenidoTitle, "Seguro de hogar - Mercantil andina");
        assertEquals(LinderoTitle, "Seguro de hogar - Mercantil andina");
        assertEquals(roboTitle, "Seguro de hogar - Mercantil andina");
        assertEquals(electroTitle, "Seguro de hogar - Mercantil andina");
        assertEquals(cristalesTitle, "Seguro de hogar - Mercantil andina");
        assertEquals(HechosTitle, "Seguro de hogar - Mercantil andina");
        assertEquals(aguaTitle, "Seguro de hogar - Mercantil andina");
        assertEquals(pcTitle, "Seguro de hogar - Mercantil andina");
        assertTrue(driver.findElement(By.id("wc-button")).isDisplayed());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.close();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

}
