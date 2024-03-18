package HomePage;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

public class parameters {
	WebDriver driver = new ChromeDriver();
	String URL = "https://www.almosafer.com/en";
	Random rand = new Random();
	String ExpectedLang = "en";
	String ExpectedCurrency = "SAR";
	String ExpextedContactNum ="+966554400000";
	Assertion Assert = new Assertion();
}
