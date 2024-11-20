package app;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Test2 extends BaseTest {

	  @Test
	  void forget_password() {
	      page.getByPlaceholder("Username").click();
	      page.getByPlaceholder("Username").fill("admin");
	      page.getByPlaceholder("Password").fill("adm1234");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
	      assertThat(page.getByRole(AriaRole.ALERT)).containsText("Invalid credentials");
	      page.getByText("Forgot your password?").click();
	      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Reset Password"))).isVisible();
	      assertThat(page.getByRole(AriaRole.HEADING)).containsText("Reset Password");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset Password")).click();
	      assertThat(page.locator("span")).containsText("Required");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancel")).click();
		  
	  }
}
