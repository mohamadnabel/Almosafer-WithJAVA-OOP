package HomePage;

import java.time.LocalDate;
//import java.util.Date;
//import java.sql.Date;
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
	String ExpextedContactNum = "+966554400000";
	Assertion Assert = new Assertion();
//	Date currentDate = new Date();
	LocalDate currentDate = LocalDate.now();
}
