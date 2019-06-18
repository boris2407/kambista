package job.kambista.training.pageObjets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	private WebElement txtEmail;
	
	@FindBy(id="password")
	private WebElement txtClave;
	
	@FindBy(id="register")
	private WebElement btnRegistrar;
	
	@FindBy(xpath="//label[@id='msg']")
	private WebElement message;
	
	public void ingresarEmail(String temail){
		txtEmail.sendKeys(temail);
	}
	
	public void ingresarClave(String tclave){
		txtClave.sendKeys(tclave);
	}
	
	public void darClicBotonRegistrar(){
			btnRegistrar.click();
	}
	
	public String capturarMensaje() throws InterruptedException{
		Thread.sleep(1000);
		return message.getText();
	}
	
	

}
