package W13ZhilinComQALightOldByAnnotation.ComQALightOld;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


@RunWith(Parameterized.class)
public class Parent {
  public RemoteWebDriver driver;
  WebDriver iE, fireFox, chrome;
  public Logger log = Logger.getLogger(getClass());

  @Rule 
  public TestName name = new TestName();

  @Parameterized.Parameters
  public static Collection<String[]> data() {
   return Arrays.asList(new String[][] { 
	{ "fireFoxString" }
    /*,
    { "chromeString" }
    ,
    {"internetExplorer"}
    ,
    {"edge"}*/

    });
  }
  
  public Parent(String browser) throws MalformedURLException {
   if (browser.equals("fireFoxString")) {
    this.driver = new FirefoxDriver();
   } else {
    if (browser.equals("chromeString")) {
     this.driver = new ChromeDriver();
    } else {
    	if (browser.equals("internetExplorer")) {
    		this.driver = new InternetExplorerDriver();
    	} else {
    		if (browser.equals("edge")) {
    			this.driver = new EdgeDriver();
    		}
    	}
    }
    
   }
   log.info(" ----- " + driver.getClass() + " -------" );   
  }}