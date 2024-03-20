package hotelSearchTest;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class parameters {
	WebDriver driver = new ChromeDriver();
	String URL = "https://www.almosafer.com/en";
	String[] ArabicCities = { "دبي", "جدة" };
	String[] EnglishCities = { "dubai", "jeddah", "riyadh" };
	Random rand = new Random();
	int randomVisitor = rand.nextInt(2);

}
