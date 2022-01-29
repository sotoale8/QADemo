package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import util.DataDriven;
import util.PropertiesDriven;

import java.util.ArrayList;


public class CasosDePrueba {
    private WebDriver driver;
    private String url= PropertiesDriven.obtenerProperty("url");
    private String rutaDriver=PropertiesDriven.obtenerProperty("rutaDriver");
    private String propertyDriver=PropertiesDriven.obtenerProperty("propertyDriver");
    private String browser = PropertiesDriven.obtenerProperty("browser");

    private HomePage homePage;
    private FormsPage formsPage;

    ArrayList<String> datosCP;

    @BeforeMethod
    public void preparacionTest(){
        datosCP= new ArrayList<>();
        homePage= new HomePage(driver);
        homePage.conexionDriver(browser,rutaDriver,propertyDriver);
        homePage.cargarPagina(url);
        homePage.maximizarBrowser();

        formsPage=new FormsPage(homePage.getDriver());

    }

    @AfterMethod
    public void cerrarNavegador(){
        formsPage.esperarXSegundos(3000);
        formsPage.cerrarBrowser();
    }

    @Test
    public void CP001_RellenarFormulario(){
        datosCP= DataDriven.getData("CP001_RellenarFormulario");
        homePage.clickOnFormsButton();
        formsPage.clickinFormButton();
        formsPage.fNameField(datosCP.get(1));
        formsPage.lNameField(datosCP.get(2));
        formsPage.emailField(datosCP.get(3));
        formsPage.mobileField(datosCP.get(5));
        formsPage.addressField(datosCP.get(8));
        formsPage.genderCheck();
        formsPage.hobbiesCheck();
        formsPage.subjectField();
        formsPage.stateSelect();
        formsPage.citySelect();
        formsPage.uploadPicture(datosCP.get(9));
        formsPage.clickInSubmit();
        Assert.assertEquals(formsPage.getMessage(),datosCP.get(10));

      }
}
