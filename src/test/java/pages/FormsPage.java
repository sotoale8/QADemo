package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.ClaseBase;

public class FormsPage extends ClaseBase {
    public FormsPage(WebDriver driver) {
        super(driver);
    }
    //Attributes
    By formButton =By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]");
    By FNameField= By.xpath("//input[@id='firstName']");
    By LNameField= By.xpath("//input[@id='lastName']");
    By EmailField= By.xpath("//input[@id='userEmail']");
    By MobileField= By.xpath("//input[@id='userNumber']");
    By SubjectField= By.cssSelector("input#subjectsInput");
    By SubjectFieldOpc=By.cssSelector("div.subjects-auto-complete__menu");
    By AddressField= By.xpath("//textarea[@id='currentAddress']");
    By genderCheck = By.xpath("//label[contains(text(),'Male')]");
    By hobbiesCheck = By.xpath("//label[contains(text(),'Music')]");
    By stateSelect = By.cssSelector("div#state div[class$='placeholder']");
    By stateSelectOpc= By.xpath("//div[contains(text(),'NCR')]");
    By citySelect = By.xpath("//div[@id='city']");
    By citySelecOpc= By.xpath("//div[contains(text(),'Delhi')]");
    By submitButton=By.xpath("//button[@id='submit']");
    By okMessage=By.xpath("//div[@id='example-modal-sizes-title-lg']");
    By uploadButton= By.xpath("//input[@id='uploadPicture']");


    public void clickinFormButton(){
        click(esperaExplicita(formButton));
    }
    public void fNameField(String fname){
        agregarTexto(esperaExplicita(FNameField),fname);
    }
    public void lNameField(String lname){
        agregarTexto(esperaExplicita(LNameField),lname);
    }
    public void emailField(String email){
        agregarTexto(esperaExplicita(EmailField),email);
    }
    public void mobileField(String mobile){
        agregarTexto(esperaExplicita(MobileField),mobile);
    }
    public void subjectField(){
        agregarTexto(esperaClickleable(SubjectField), "English");
        click(esperaClickleable(SubjectFieldOpc));
    }
    public void addressField(String address){
        agregarTexto(esperaExplicita(AddressField),address);
    }
    public void genderCheck(){
        click(esperaExplicita(genderCheck));
    }
    public void hobbiesCheck(){
        click(esperaExplicita(hobbiesCheck));
    }
    public void stateSelect(){
        click(esperaClickleable(stateSelect));
        click(esperaClickleable(stateSelectOpc));

    }
    public void citySelect(){
        click(esperaClickleable(citySelect));
        click(esperaClickleable(citySelecOpc));
    }
    public void uploadPicture(String path){
        agregarTexto(esperaExplicita(uploadButton),path);
    }
    public void clickInSubmit(){
        click(esperaExplicita(submitButton));
    }
    public String getMessage(){
        return obtenerTexto(esperaExplicita(okMessage));
    }
}
