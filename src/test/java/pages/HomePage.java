package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ClaseBase;

public class HomePage extends ClaseBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    //Attributes
    By btnElements =By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/*[1]");
    By btnForms =By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/*[1]");
    By btnAlerts =By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/*[1]");
    By btnWidgets =By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]");
    By btnInteractions =By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[5]/div[1]/div[1]");
    By btnBookStore= By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]");

    //Methods
    public void clickOnElementsButton(){
        click(esperaExplicita(btnElements));
    }
    public void clickOnFormsButton(){
        click(esperaExplicita(btnForms));
    }
    public void clickOnAlertsButton(){
        click(esperaExplicita(btnAlerts));
    }
    public void clickOnWidgetsButton(){
        click(esperaExplicita(btnWidgets));
    }
    public void clickOnInteractionsButton(){
        click(esperaExplicita(btnInteractions));
    }
    public void clickOnBookStoreButton(){
        click(esperaExplicita(btnBookStore));
    }
}
