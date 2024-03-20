package hotelSearchTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class bookingHotelTest extends parameters {

	@BeforeTest
	public void mySetup() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	@Test(invocationCount = 3)
	public void myTest() {
		WebElement hotelTap = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		hotelTap.click();
		WebElement searchHotelInput = driver.findElement(By.xpath("//input[@data-testid='AutoCompleteInput']"));

		int randomArabicCities = rand.nextInt(ArabicCities.length);

		int randomEnglishCities = rand.nextInt(EnglishCities.length);

		if (driver.getCurrentUrl().contains("en")) {
			searchHotelInput.clear();
			searchHotelInput.sendKeys(EnglishCities[randomEnglishCities]);
		} else {
			searchHotelInput.clear();
			searchHotelInput.sendKeys(ArabicCities[randomArabicCities]);

		}
		;

	}

}
