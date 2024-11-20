package org.browserfactory;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import utils.ConfigReader;

public class BrowserDriver {
	
    public static Page page = null;
	public static Page createInstance() 
	{
		ConfigReader config = ConfigReader.getInstance();
	    String test_browser = config.getBrowser();
		try (Playwright playwright = Playwright.create()) 
		{
			Browser browser = null;
		      if (test_browser.equals("chromium")) 
		      {
		        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		                .setHeadless(false)
		                .setChannel("chrome"));
		      } 
		      else if (test_browser.equals("firefox")) 
		      {
		        browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
		                .setHeadless(false)
		                .setChannel("firefox"));
		      } 
		      else if (test_browser.equals("webkit")) 
		      {
		        browser = playwright.webkit().launch(new BrowserType.LaunchOptions()
		                .setHeadless(false)
		                .setChannel("webkit"));
		      }
		      page = browser.newPage();
		      // ...
		}
		return page;
	}
}




