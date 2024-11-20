package app;

import static org.testng.Assert.assertEquals;
import java.util.regex.Pattern;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Test1 extends BaseTest{
	
	
	@Test
	 void test_login1(){
	    String page_Title = page.title();
	    System.out.println("Page title from test 1="+page_Title);
	    assertEquals("OrangeHRM",page_Title);
	    page.getByPlaceholder("UserName").fill("Admin");
	    page.getByPlaceholder("Password").fill("admin123");
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(Pattern.compile("Login", Pattern.CASE_INSENSITIVE))).click();
	    page.getByPlaceholder("Search").fill("Time");
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Time")).click();
	    page.getByAltText("profile picture").click();
	    //page.getByRole(AriaRole.NAVIGATION, new Page.GetByRoleOptions().setName("Logout")).click();
	    page.getByText("Logout").click();

	  }

	  @Test
	  void test_login2() {
		  String page_Title = page.title();
		    System.out.println("Page title from test 1="+page_Title);
		    assertEquals("OrangeHRM",page_Title);
		    page.getByPlaceholder("UserName").fill("Admin");
		    page.getByPlaceholder("Password").fill("admin123");
		    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(Pattern.compile("Login", Pattern.CASE_INSENSITIVE))).click();
		    page.getByPlaceholder("Search").fill("Time");
		    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Time")).click();
		    page.getByAltText("profile picture").click();
		    //page.getByRole(AriaRole.NAVIGATION, new Page.GetByRoleOptions().setName("Logout")).click();
		    page.getByText("Logout").click();
	  }		  

}
