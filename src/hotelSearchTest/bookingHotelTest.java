package hotelSearchTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class bookingHotelTest extends parameters {

	@BeforeTest
	public void mySetup() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test(invocationCount = 1, priority = 1, groups = "testNg", enabled = true)
	public void myTest() {
		WebElement hotelTap = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		hotelTap.click();
		WebElement searchHotelInput = driver.findElement(By.xpath("//input[@data-testid='AutoCompleteInput']"));

		int randomArabicCities = rand.nextInt(ArabicCities.length);

		int randomEnglishCities = rand.nextInt(EnglishCities.length);

		if (driver.getCurrentUrl().contains("en")) {
			searchHotelInput.clear();
			searchHotelInput.sendKeys(EnglishCities[randomEnglishCities]);
			WebElement listSearchResult = driver.findElement(By.xpath("//ul[@data-testid='AutoCompleteResultsList']"));
			listSearchResult.findElements(By.tagName("li")).get(1).click();

		} else {
			searchHotelInput.clear();
			searchHotelInput.sendKeys(ArabicCities[randomArabicCities]);
			WebElement listSearchResult = driver.findElement(By.xpath("//ul[@data-testid='AutoCompleteResultsList']"));
			listSearchResult.findElements(By.tagName("li")).get(1).click();

		}
		;

	}

	@Test(priority = 2, enabled = true)
	public void randomSelectVisiterNum() {
		WebElement selectorVisitor = driver
				.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
		Select selector = new Select(selectorVisitor);

		selector.selectByIndex(randomVisitor);

		WebElement searchBtn = driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		searchBtn.click();

	}

	@Test(priority = 3, enabled = true)
	public void pageFullyCompleted() throws InterruptedException {
		Thread.sleep(10000);
		WebElement MsgCompleatedSearch = driver
				.findElement(By.xpath("//span[@data-testid='HotelSearchResult__resultsFoundCount']"));
		String MsgResulte = MsgCompleatedSearch.getText();
		MsgResulte.contains("found");
		System.out.println(MsgResulte);
		Assert.assertEquals(MsgResulte.contains("found"), true);

	}

	@Test(priority = 4, enabled = true)
	public void checkLowestFunctionSearch() {
		WebElement lowestPriceBtn = driver
				.findElement(By.cssSelector("button[data-testid='HotelSearchResult__sort__LOWEST_PRICE']"));
		lowestPriceBtn.click();

		WebElement containerOfThePrices = driver.findElement(By.cssSelector(".sc-htpNat.KtFsv.col-9"));

		List<WebElement> Prices = containerOfThePrices.findElements(By.className("Price__Value"));

		int firstPrice = Integer.parseInt(Prices.get(0).getText());

		int lastPrice = Integer.parseInt(Prices.get(Prices.size() - 1).getText());

		boolean isPriceComparisonTrue = firstPrice < lastPrice;
//		Boolean expactedResulte = true;
//		Assert.assertEquals(firstPrice < lastPrice, true);

//		Assert.assertEquals(isPriceComparisonTrue, expactedResulte);

		System.out.println(isPriceComparisonTrue + "@@@@@@@@@@");

		System.out.println(firstPrice);
		System.out.println(lastPrice);

		System.out.println(date.getMonth());
		System.out.println(date.getDayOfMonth());
		System.out.println(date.getDayOfWeek());

		System.out.print(Prices.get(5).getText() + "@@@@@@@@@@@@@@@@@@@@@@2");

	}

}
