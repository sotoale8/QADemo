package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class ClaseBase {
    //Definir atributos
    private WebDriver driver;
    public WebDriver getDriver() {
        return driver;
    } //get
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    } //set
    public ClaseBase(WebDriver driver) {
        this.driver = driver;

    } //Constructor
    //Acciones que podemos realizar en el browser
    public void cargarPagina(String url) {
        this.driver.get(url);

    }  //Cargar URL
    public WebElement buscarElementoWeb(By localizador) {
        return this.driver.findElement(localizador);
    } // Retorna un elemento web
    public List<WebElement> buscarElementosWeb(By localizador) {
        return this.driver.findElements(localizador);
    } // Retorna una lista de elementos web
    public void esperarXSegundos(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            System.out.println("No se pudo aplicar la espera");
            System.out.println("Error:  " + e.getStackTrace());
        }
    } //Realizar una espera
    public WebElement esperaExplicita(By localizador) {
        WebDriverWait espera = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        return espera.until(ExpectedConditions.presenceOfElementLocated(localizador));
    } //Realiza la espera de un elemento web hasta que aparezca
    public  WebElement esperaClickleable(By localizador){
        WebDriverWait espera = new WebDriverWait(this.driver,Duration.ofSeconds(3));
        return espera.until(ExpectedConditions.elementToBeClickable(localizador));
    } // Realiza la espera de un elemento web hasta sea clickleable
    public void click(By localizador) {
        this.driver.findElements(localizador);
    } //Hace click a un elemento web
    public void click(WebElement elemento) {
        elemento.click();
    }//Hace click a un elemento web
    public String obtenerTexto(By localizador) {
        return this.driver.findElement(localizador).getText();
    } //Obtiene el texto de un elemento web
    public String obtenerTexto(WebElement elemento) {
        return elemento.getText();
    }//Obtiene el texto de un elemento web
    public void agregarTexto(By localizador, String texto) {
        this.driver.findElement(localizador).sendKeys(texto);
    } //Envia el texto a un elemento web
    public void agregarTexto(WebElement elemento, String texto) {
        elemento.sendKeys(texto);
    }//Envia el texto a un elemento web
    public void limpiarCajadeTexto(WebElement elemento) {
        elemento.clear();
    }// Limpia el texto de una caja
    public void limpiarCajadeTexto(By localizador) {
        this.driver.findElement(localizador).clear();
    } //// Limpia el texto de una caja
    public void maximizarBrowser() {
        this.driver.manage().window().maximize();
    }//Maximiza el navegador
    public void cerrarBrowser() {
        this.driver.close();
    }//Cierra el navegador
    public boolean estaDesplegado(By localizador) {
        try {
            return this.driver.findElement(localizador).isDisplayed();

        } catch (Exception e) {
            System.out.println("Error al encontrar el elemento Web: " + e.getStackTrace());
            return false;
        }
    }//Verifica su se desplego un elemento web
    public WebDriver conexionDriver(String browser, String rutaDriver, String propertyDriver) {

        switch (browser) {
            case "chrome":
                System.setProperty(propertyDriver, rutaDriver);
                this.driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty(propertyDriver, rutaDriver);
                this.driver = new FirefoxDriver();
                break;
            default:
                this.driver = null;
                break;

        }
        return this.driver;

    } //Configura el driver según el navegador
    public void irAlprimerframe(){
        this.driver.switchTo().frame(0);
    } //Posiciona sobre el primer frame
    public void irAlFrame(String id) {
        this.driver.switchTo().frame(id);
    }//Posiciona sobre el frame seleccionado.

}