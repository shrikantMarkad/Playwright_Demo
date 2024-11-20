package org.browserfactory;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserContext;

import utils.ConfigReader;

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

		return browser;
	}
}




