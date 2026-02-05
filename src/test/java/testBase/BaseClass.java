package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	 public static WebDriver driver;
	 public Logger logger;
	 public Properties p;
	 
	 public static String registeredEmail;
	  public  static  String registeredPassword;
 
@BeforeClass(groups= {"Sanity", "Regression", "Master"})
 @Parameters({"os", "browser"})
	public void Setup(String os, String br) throws IOException, InterruptedException {
	
	 ChromeOptions op= new ChromeOptions();
	 Map<String, Object> prefs = new HashMap<>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    prefs.put("profile.password_manager_leak_detection", false);
	    op.setExperimentalOption("prefs", prefs);
	
//		
	    op.addArguments("--headless=new");
	    op.addArguments("--window-size=1920,1080");
	    op.addArguments("--disable-gpu");
	    op.addArguments("--no-sandbox");
	    op.addArguments("--disable-dev-shm-usage");
	    op.addArguments("--disable-notifications");
	    op.addArguments("--disable-infobars");
	 logger= LogManager.getLogger(this.getClass());
	 FileReader file= new FileReader("./src//test//resources//config.properties");
	 p= new Properties();
		p.load(file);
		
//		String execEnv = p.getProperty("execution_eve");
//	    if (execEnv == null) {
//	        throw new RuntimeException("execution_eve not found in config.properties");
//	    }

//	    try (FileReader file = new FileReader("./src/test/resources/config.properties")) {
//	        p = new Properties();
//	        p.load(file);
//	    }
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
//	
			switch(br.toLowerCase()) {
			case "chrome":
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setPlatformName(os.toLowerCase());
				driver= new RemoteWebDriver(new URL(p.getProperty("remoteUrl")), chromeOptions);break;
			case "firefox":
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setPlatformName(os.toLowerCase());
				driver = new RemoteWebDriver(new URL(p.getProperty("remoteUrl")), firefoxOptions);break;
			case "edge" :
				EdgeOptions edgeOptions= new EdgeOptions();
				edgeOptions.setPlatformName(os.toLowerCase());
				driver = new RemoteWebDriver(new URL(p.getProperty("remoteUrl")),edgeOptions);break;
				default: throw new RuntimeException("Invalid browser value: " + br);
				
			}
			
			
		}
	if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
		 switch(br.toLowerCase()) {
		 case "chrome": WebDriverManager.chromedriver().setup();
			 driver= new ChromeDriver(op); break; 
			
		
		 case "firefox" : WebDriverManager.firefoxdriver().setup();
			 driver= new FirefoxDriver(); break;
		 case  "edge" : WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver(); break;
//		 default : System.out.println(" Invalid Browser ........"); return;
			 default:throw new RuntimeException("Invalid browser value: " + br);
		 }
		 
	}
	
	
	
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	 
		 driver.get(p.getProperty("appUrl"));
//		 driver.manage().window().maximize();
		 logger.info(" Driver Setup  Completed....");
		 
	}
 public String randomString() {
	 String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomNumber() {
		String generatedNumber= RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}
	public String randomEmail() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		String generatedNumber= RandomStringUtils.randomNumeric(10);
		String pass=  generatedString +generatedNumber;
		return pass ;
	}
	public String captureScreenShot(String tname)throws IOException {

	    if (driver == null) {
	        System.out.println("Driver is NULL. Screenshot cannot be taken.");
	        return null;
	    }
		String timeStamp= new SimpleDateFormat("yyyy.MM..dd..HH.mm.ss").format(new Date());
		TakesScreenshot takeScreenShot= (TakesScreenshot) driver;
		File sourceFile= takeScreenShot.getScreenshotAs(OutputType.FILE);
		String TargetFilePath= System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File TargetFile= new File(TargetFilePath);
		sourceFile.renameTo(TargetFile);
		
		return TargetFilePath;
	}
 @AfterClass(groups= {"Sanity", "Regression", "Master"})
 public void tearDown() {
	 if (driver != null) {
	        driver.quit();
	    }
	
 }

}
