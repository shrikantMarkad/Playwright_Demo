package app;


import java.awt.Dimension;
import java.awt.Toolkit;

import org.browserfactory.BrowserDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;




public class BaseTest extends BrowserDriver {	

	Browser browser;
	
	BrowserContext context;
	Page page;
	
	
	@BeforeMethod
	void setup() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int)dimension.getWidth();
		int height = (int)dimension.getHeight();
		browser = createInstance();
		context = browser.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		page = context.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/");
	}
	
	@AfterMethod
	void teardown() {
		context.close();
		browser.close();
		playwright.close();
	}

}
