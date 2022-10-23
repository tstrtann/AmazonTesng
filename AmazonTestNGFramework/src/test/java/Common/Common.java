package Common;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.codec.DateFormatter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;

public class Common {
	public WebDriver driver;
	public String path = System.getProperty("user.dir");
	
	@Parameters({"browser", "website"})
 
  @BeforeClass
  public void drivers(String browser, String website) {
	  if(browser.equalsIgnoreCase("chrome")) {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  driver.navigate().to(website);
		  driver.manage().window().maximize();
	  } else if (browser.equalsIgnoreCase("edge")) {
		  WebDriverManager.edgedriver().setup();
		  driver = new EdgeDriver();
		  driver.navigate().to(website);
		  driver.manage().window().maximize();

	} else if (browser.equalsIgnoreCase("safari")) {
		  WebDriverManager.safaridriver().setup();
		  driver = new SafariDriver();
		  driver.navigate().to(website);
		  driver.manage().window().maximize();

	} else if (browser.equalsIgnoreCase("firefox")) {
		  WebDriverManager.edgedriver().setup();
		  driver = new FirefoxDriver();
		  driver.navigate().to(website);
		  driver.manage().window().maximize();

	}
  }
  

  
 

  @AfterClass
  public void afterClass() throws IOException {
//	  driver.close();
//	  driver.quit();
  }
  
//  public void Screenshots(String folder) throws IOException {
//		Date dateSS = new Date();
//		String screenshotDate = dateSS.toString().replace(" ", "_").replace(":", "_");
//		File snap = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileHandler.copy(snap,
//				new File(path + "/snapshot//" + folder + "//"
//						+ screenshotDate + "AmazonPractice.png")); 
//		}
  
  public void Screenshots(String folder) throws IOException {
	  LocalDateTime dateObj = LocalDateTime.now();
	  DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
	  String formattedDate = dateObj.format(dateFormat);
	  File snap = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  FileHandler.copy(snap, new File(path + "/snapshot//" + folder + "//"
						+ formattedDate + "AmazonPractice.png"));
  }

}
