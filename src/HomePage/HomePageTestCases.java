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

	@Test(invocationCount = 1, description = "test defult langeuge", priority = 1, enabled = false)
	public void checkDefultLangugege() {
		String ActualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
		Assert.assertEquals(ActualLang, expectesEngilshLangauge, "this is for check page defult languege");

	}

	@Test(description = "test defult currency", priority = 2, enabled = false)
	public void checkCurrencyDefult() {
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);

	}

	@Test(description = "test contact number", priority = 3, enabled = false)
	public void checkContactNumDefult() {
		String ActualContactNum = driver.findElement(By.tagName("Strong")).getText();
		Assert.assertEquals(ActualContactNum, ExpextedContactNum);

	}

	@Test(description = "test qitaf logo ", priority = 4, enabled = false)
	public void checkisDisplayedQitafLogo() {
		WebElement QitafLogo = driver.findElement(By.xpath("//div[@class='sc-fihHvN eYrDjb']//*[name()='svg']"));
		Boolean ActualResults = QitafLogo.isDisplayed();

		Assert.assertEquals(ActualResults, true);

	}

	@Test(description = "test top tap selected by defult", priority = 5, enabled = false)
	public void CheckTapNotSelected() {
		WebElement hotelBtn = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualSelected = hotelBtn.getAttribute("aria-selected");

		Assert.assertEquals(ActualSelected, "false");

	}

	@Test(description = "test depature and return date", priority = 6, enabled = false)
	public void checkDepatureDate() throws InterruptedException {
		int tomorrow = currentDate.plusDays(1).getDayOfMonth();
		int afterTomorrow = currentDate.plusDays(2).getDayOfMonth();
		System.out.println(tomorrow);
		System.out.println(afterTomorrow);
		Thread.sleep(3000);
		String dateOfDepature = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']"))
				.getText();
		int dateOfDepatureAsInt = Integer.parseInt(dateOfDepature);
		String dateOfReturn = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-cPuPxo LiroG']"))
				.getText();
		int dateOfReturnAsInt = Integer.parseInt(dateOfReturn);

		Assert.assertEquals(dateOfDepatureAsInt, tomorrow);
		Assert.assertEquals(dateOfReturnAsInt, afterTomorrow);

	}

	@Test()
	public void changeLangaugeRandomly() throws InterruptedException {

		driver.get(webSite[randomLangaugeIndex]);

		if (driver.getCurrentUrl().contains(expectesEngilshLangauge)) {
			String ActualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
			Assert.assertEquals(ActualLang, expectesEngilshLangauge);

		} else {
			String ActualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
			Assert.assertEquals(ActualLang, expectesArabicLangauge);

		}
		;

		Thread.sleep(2000);
	}

}
