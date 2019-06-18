package job.kambista.training.test;


import java.util.concurrent.TimeUnit;
import job.kambista.training.pageObjets.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class KambistaTest 
{
	WebDriver driver;
	
	@BeforeMethod
	public void antes(){
		System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("http://localhost:4000/register");
	}
	
    @Test(priority=1)
    public void registroCorrecto() throws InterruptedException
    {
    	LoginPage loginPage=new LoginPage(driver);
    	
    	loginPage.ingresarEmail("juan.alvarezm@outlook.com");
    	loginPage.ingresarClave("Interbak");
    	loginPage.darClicBotonRegistrar();

        Assert.assertEquals("SAVED", loginPage.capturarMensaje());
    }
    
    @Test(priority=2)
    public void emailInvalido() throws InterruptedException
    {
    	LoginPage loginPage=new LoginPage(driver);
    	
    	loginPage.ingresarEmail("juan.alvarezmoutlook.com");
    	loginPage.ingresarClave("Interbak");
    	loginPage.darClicBotonRegistrar();

    	Assert.assertEquals("INVALID", loginPage.capturarMensaje());
    }
    
    @Test(priority=3)
    public void claveInvalida() throws InterruptedException
    {
    	LoginPage loginPage=new LoginPage(driver);
    	
    	loginPage.ingresarEmail("juan.alvarezm@outlook.com");
    	loginPage.ingresarClave("Inte");
    	loginPage.darClicBotonRegistrar();

    	Assert.assertEquals("INVALID", loginPage.capturarMensaje());
    }
    
    @Test(priority=4)
    public void emailAndClaveInvalida() throws InterruptedException
    {
    	LoginPage loginPage=new LoginPage(driver);
    	
    	loginPage.ingresarEmail("juan.alvarezmoutlook.com");
    	loginPage.ingresarClave("Inte");
    	loginPage.darClicBotonRegistrar();

    	Assert.assertEquals("INVALID", loginPage.capturarMensaje());
    }
    
    @Test(priority=5)
    public void faltaEmail() throws InterruptedException
    {
    	LoginPage loginPage=new LoginPage(driver);
    	
    	loginPage.ingresarEmail("");
    	loginPage.ingresarClave("Interbank");
    	loginPage.darClicBotonRegistrar();

    	Assert.assertEquals("REQUIRED", loginPage.capturarMensaje());
    }
    
    @Test(priority=6)
    public void faltaClave() throws InterruptedException
    {
    	LoginPage loginPage=new LoginPage(driver);
    	
    	loginPage.ingresarEmail("juan.alvarezm@outlook.com");
    	loginPage.ingresarClave("");
    	loginPage.darClicBotonRegistrar();

    	Assert.assertEquals("REQUIRED", loginPage.capturarMensaje());
    }
    
    @Test(priority=7)
    public void faltaEmailAndClave() throws InterruptedException
    {
    	LoginPage loginPage=new LoginPage(driver);
    	
    	loginPage.ingresarEmail("");
    	loginPage.ingresarClave("");
    	loginPage.darClicBotonRegistrar();

    	Assert.assertEquals("REQUIRED", loginPage.capturarMensaje());
    }
    
    @AfterMethod
    public void despues(){
    	driver.close();
    }
}
