package hotelSearchTest;

import java.time.Duration;

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

	@Test(invocationCount = 1, priority = 1, groups = "testNg")
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

	@Test(priority = 2)
	public void randomSelectVisiterNum() {
		WebElement selectorVisitor = driver
				.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
		Select selector = new Select(selectorVisitor);

		selector.selectByIndex(randomVisitor);

		WebElement searchBtn = driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']"));
		searchBtn.click();

	}

}
