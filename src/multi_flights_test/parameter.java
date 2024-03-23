package multi_flights_test;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class parameter {

	WebDriver driver = new ChromeDriver();
	Random rand = new Random();
	String URL = "https://www.almosafer.com/en";
	String[] randomFromCities = { "amman", "riyadh", "dubai", "Turkistan", "Doha" };
	String[] randomToCities = { "jeddah", "dammam", "cairo", "Manila", "Managua" };

}
