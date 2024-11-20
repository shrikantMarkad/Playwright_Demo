package org.browserfactory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import test_utils.ConfigReader;

public class BrowserDriver {
	
	static ConfigReader config = ConfigReader.getInstance();
    static String test_browser = config.getBrowser();
    public String test_url = config.getBaseUrl();
    public static Browser browser;
    public Playwright playwright;
    
	public Browser createInstance()
	{

		playwright = Playwright.create();
		

		      if (test_browser.equals("chromium")) 
		      {
		        browser = playwright.chromium().launch();
		      } 
		      else if (test_browser.equals("firefox")) 
		      {
		        browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
		                .setHeadless(true)
		                .setChannel("firefox"));
		      } 
		      else if (test_browser.equals("webkit")) 
		      {
		        browser = playwright.webkit().launch(new BrowserType.LaunchOptions()
		                .setHeadless(true)
		                .setChannel("webkit"));
		      }

		return browser;
	}
}




