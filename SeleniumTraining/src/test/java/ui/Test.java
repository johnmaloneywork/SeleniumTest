package ui;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	
	private static ChromeDriver driver;
	
	@BeforeAll
	public static void setUpChromeDriver() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	public static void createDriverInstance() {
		driver = new ChromeDriver();
	}

}
