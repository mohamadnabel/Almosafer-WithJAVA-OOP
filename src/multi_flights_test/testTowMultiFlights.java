package multi_flights_test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testTowMultiFlights extends parameter {
	@BeforeTest
	public void mySetup() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));

	}

	@Test(priority = 1, enabled = true)
	public void testTow() throws InterruptedException {
		WebElement multiFlightBtn = driver
				.findElement(By.xpath("//div[@data-testid='FlightSearchBox__MultiCityButton']"));
		multiFlightBtn.click();
		WebElement checkBoxBaggage = driver.findElement(By.cssSelector("label[for='has-baggage-only-checkbox']"));
		checkBoxBaggage.click();
	}

	@Test(priority = 2, invocationCount = 1, enabled = true)
	public void randomCitiesTest() throws InterruptedException {

		WebElement fromAirFlight = driver
				.findElement(By.cssSelector("input[data-testid='FlightSearchBox__FromAirportInput']"));

		WebElement toAirFlight = driver
				.findElement(By.cssSelector("input[data-testid='FlightSearchBox__ToAirportInput']"));

		int randomCitiesOne = rand.nextInt(randomFromCities.length);

		int randomCitiesTwo = rand.nextInt(randomToCities.length);

		fromAirFlight.sendKeys(randomFromCities[randomCitiesTwo]);

		toAirFlight.sendKeys(randomToCities[randomCitiesOne]);

		WebElement divClick = driver.findElement(By.xpath("//div[@class='sc-iHhHRJ sc-kqlzXE blwiEW']"));
		divClick.click();

		WebElement selectMonthOfDepatur = driver
				.findElement(By.xpath("//div[@class='DayPicker-wrapper']//div[1]//form[1]//div[1]//div[1]//select[1]"));
		Select selector = new Select(selectMonthOfDepatur);
		int randomMonth = rand.nextInt(12);

		selector.selectByIndex(randomMonth);

		List<WebElement> listOfDays = driver.findElements(By.cssSelector(
				"body > div:nth-child(2) > section:nth-child(3) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3)"));
		int randomDayOfMounth = rand.nextInt(listOfDays.size());

		listOfDays.get(randomDayOfMounth).click();

//		WebElement depaturInput = driver
//				.findElement(By.xpath("//input[@data-testid='FlightSearchBox__Flight2FromAirportInput']"));
//		WebElement returnInput = driver
//				.findElement(By.xpath("//input[@data-testid='FlightSearchBox__Flight2ToAirportInput']"));
//
//		depaturInput.sendKeys(randomFromCities[randomCitiesOne]);
//		returnInput.sendKeys(randomFromCities[randomCitiesTwo]);

	}

	@Test(priority = 3, enabled = true)
	public void randomNumberOfFlight() throws InterruptedException {
		Thread.sleep(3000);

		WebElement addMoreFlightsBtn = driver
				.findElement(By.xpath("//div[@data-testid='FlightSearchBox__AddFlightButton']"));

		int randomCountClick = rand.nextInt(3);

		for (int i = 0; i < randomCountClick; i++) {
			addMoreFlightsBtn.click();
		}
		if (randomCountClick == 0) {
			WebElement flightTowDepaturlaInput = driver
					.findElement(By.xpath("//input[@data-testid='FlightSearchBox__Flight2FromAirportInput']"));
			WebElement flightTowReturnInput = driver
					.findElement(By.xpath("//input[@data-testid='FlightSearchBox__Flight2ToAirportInput']"));
			flightTowDepaturlaInput.sendKeys("dubai");
			flightTowReturnInput.sendKeys("amman");

		} else if (randomCountClick == 1) {
			WebElement flightTowDepaturlaInput = driver
					.findElement(By.xpath("//input[@data-testid='FlightSearchBox__Flight2FromAirportInput']"));
			WebElement flightTowReturnInput = driver
					.findElement(By.xpath("//input[@data-testid='FlightSearchBox__Flight2ToAirportInput']"));
			WebElement flightThreeDepaturlaInput = driver
					.findElement(By.xpath("//input[@data-testid='FlightSearchBox__Flight3FromAirportInput']"));
			WebElement flightThreeReturnInput = driver
					.findElement(By.xpath("//input[@data-testid='FlightSearchBox__Flight3ToAirportInput']"));

			flightTowDepaturlaInput.sendKeys("dubai");
			flightTowReturnInput.sendKeys("amman");
			flightThreeDepaturlaInput.sendKeys("dammam");
			flightThreeReturnInput.sendKeys("amman");

		}
		driver.findElement(By.xpath("//button[@data-testid='FlightSearchBox__SearchButton']")).click();
	}

}
