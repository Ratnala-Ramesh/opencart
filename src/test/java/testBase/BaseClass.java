package testBase;

import java.io.File;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;
public class BaseClass {
	public static WebDriver driver;//because this is static due to in utilities package extentreportmanager in line no 88 we create an new base class so this makes to drivers so the working is not perfect so we make this is an static. 
	public Logger logger;
	public Properties p;
      @BeforeClass(groups= {"Sanity","Regression","Master"})
      @Parameters({"browser","os"})
      public void setup(String br,String os) throws IOException {
    	  FileReader file=new FileReader(".//src//test//resources//config.properties");
    	  p=new Properties();
    	  p.load(file);
    	  logger=LogManager.getLogger(this.getClass());
    	  if(p.getProperty("execution_env").equalsIgnoreCase("Remote")) {
    		  String url="http://10.236.7.71:4444/wd/hub";
    		  DesiredCapabilities cap=new DesiredCapabilities();
    		  if(os.equalsIgnoreCase("windows")) {
    			  cap.setPlatform(Platform.WIN11);
    		  }
    		  else if(os.equalsIgnoreCase("edge")) {
    			  cap.setPlatform(Platform.MAC);
    		  }
    		  else {
    			  System.out.println("please enter a valid os name");
    		  }
    		  switch(br.toLowerCase()) {
    		  case "chrome":cap.setBrowserName("chrome");break;
    		  case "edge":cap.setBrowserName("MicrosoftEdge");break;
    		  default:System.out.println("please enter vaild browser name");
    		  }
    		  driver=new RemoteWebDriver(new URL(url),cap);//import from the java net package
    	  }
    	  if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
    	  switch(br.toLowerCase()) {
    	  case "chrome":driver=new ChromeDriver();break;
    	  case "edge":driver=new EdgeDriver();break;
    	  default:System.out.println("please give correct driver");return;
    	  }
    	  }
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	  driver.get(p.getProperty("appURL"));
    	  driver.manage().deleteAllCookies();
    	  driver.manage().window().maximize();
      }
      @AfterClass(groups= {"Sanity","Regression","Master"})
      public void teardown() {
    	  driver.quit();
      }
      public String randomeString()
  	{
  		String generatedString=RandomStringUtils.randomAlphabetic(5);
  		return generatedString;
  	}
  	
  	public String randomeNumber()
  	{
  		String generatedString=RandomStringUtils.randomNumeric(10);
  		return generatedString;
  	}
  	
  	public String randomAlphaNumeric()
  	{
  		String str=RandomStringUtils.randomAlphabetic(3);
  		String num=RandomStringUtils.randomNumeric(3);
  		
  		return (str+"@"+num);
  	}
  	public String captureScreen(String name) {
  		String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
  		TakesScreenshot src=(TakesScreenshot) driver;
  		File sourcefile=src.getScreenshotAs(OutputType.FILE);
  		String filepath=System.getProperty("user.dir")+"//screenShots\\"+name+"_"+timestamp+".png";
  		File targetfile=new File(filepath);
  		sourcefile.renameTo(targetfile);
  		return filepath;
  	}
      
}
