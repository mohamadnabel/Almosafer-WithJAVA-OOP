package HomePage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTestCases extends parameters {

	@BeforeTest
	public void mySetup() {
//		parameters par = new parameters();
//		par.driver.get(par.URL);

		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

//		WebElement popMsg = driver.findElement(By.cssSelector(".sc-iBmynh.izXFRL"));
//
//		if (popMsg.isDisplayed()) {
//
//			WebElement sarBtn = driver
//					.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
//			sarBtn.click();
//		}

	}

	@Test(invocationCount = 1, description = "test defult langeuge", priority = 1, enabled = true)
	public void checkDefultLangugege() {
		String ActualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
		Assert.assertEquals(ActualLang, ExpectedLang, "this is for check page defult languege");

	}

	@Test(description = "test defult currency", priority = 2, enabled = true)
	public void checkCurrencyDefult() {
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);

	}

	@Test(description = "test contact number", priority = 3, enabled = true)
	public void checkContactNumDefult() {
		String ActualContactNum = driver.findElement(By.tagName("Strong")).getText();
		Assert.assertEquals(ActualContactNum, ExpextedContactNum);

	}

	@Test(description = "test qitaf logo ", priority = 4, enabled = true)
	public void checkisDisplayedQitafLogo() {
		WebElement QitafLogo = driver.findElement(By.xpath("//div[@class='sc-fihHvN eYrDjb']//*[name()='svg']"));
		Boolean ActualResults = QitafLogo.isDisplayed();

		Assert.assertEquals(ActualResults, true);

	}

	@Test(description = "test top tap selected by defult", priority = 5, enabled = true)
	public void CheckTapNotSelected() {
		WebElement hotelBtn = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualSelected = hotelBtn.getAttribute("aria-selected");

		Assert.assertEquals(ActualSelected, "false");

	}

	@Test
	public void checkDepatureDate() {
		int tomorrow = currentDate.plusDays(1).getDayOfMonth();
		int afterTomorrow = currentDate.plusDays(2).getDayOfMonth();
		System.out.println(tomorrow);
		System.out.println(afterTomorrow);

	}

}
