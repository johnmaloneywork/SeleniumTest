package ui;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Homepage extends ui.Test{

	private static ChromeDriver driver;

	@BeforeAll
	public static void setUpChromeDriver() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	public static void createDriverInstance() {
		driver = new ChromeDriver();
	}

	@Test
	public void openWebPage() {
		//Go to web site
		driver.get("https://www.ryanair.com/");
		driver.manage().window().maximize();
		
		//Accept cookies
		driver.findElement(By.className("cookie-popup-with-overlay__button")).click();

		//Assert URL is correct
		String correctURL = "https://www.ryanair.com/";
		Assertions.assertEquals(driver.getCurrentUrl(), correctURL);

	}

	@Test
	public void flightDetails() {
		//Enter initial flight information
		driver.findElement(By.id("input-button__departure")).click();
		driver.findElement(By.id("input-button__departure")).clear();
		driver.findElement(By.id("input-button__departure")).sendKeys("Dublin");

		driver.findElement(By.id("input-button__destination")).sendKeys("Barcelona");
		driver.findElement(By.xpath("//*[contains(text(), 'Barcelona')]")).click();

		driver.findElement(By.xpath("//*[contains(text(), 'Nov')]")).click();
		driver.findElement(By.xpath("//*[contains(text(), ' 20 ')]")).click();
		driver.findElement(By.xpath("//*[contains(text(), ' 26 ')]")).click();

		driver.findElement(By.className("counter__button-wrapper--enabled")).click();

		driver.findElement(By.className("passengers__confirm-button")).click();
		
		//Assert flight details are correct
		/*Start - Not sure in this block*/
		WebElement departureElement = driver.findElement(By.id("input-button__departure"));
		Assertions.assertEquals("Dublin", departureElement.getText());
		
		WebElement destinationElement = driver.findElement(By.id("input-button__destination"));
		Assertions.assertEquals("Barcelona (All Airports)", destinationElement.getText());
		/*End of block*/
		
		String departureDate = driver.findElement(By.xpath("/html/body/hp-app-root/hp-home-container/hp-home/hp-search-widget-container/hp-search-widget/div/"
				+ "hp-flight-search-widget-container/fsw-flight-search-widget-container/fsw-flight-search-widget/div/fsw-flight-search-widget-controls-container/"
				+ "fsw-flight-search-widget-controls/div[1]/div[2]/div/fsw-input-button[1]/div/div[2]")).getText();
		Assertions.assertEquals("20", departureDate);
		
		String returnDate = driver.findElement(By.xpath("/html/body/hp-app-root/hp-home-container/hp-home/hp-search-widget-container/hp-search-widget/div/hp-"
				+ "flight-search-widget-container/fsw-flight-search-widget-container/fsw-flight-search-widget/div/fsw-flight-search-widget-controls-container/"
				+ "fsw-flight-search-widget-controls/div[1]/div[2]/div/fsw-input-button[2]/div/div[2]")).getText();
		Assertions.assertEquals("26", null);
		
		String numOfPassengers = driver.findElement(By.xpath("/html/body/hp-app-root/hp-home-container/hp-home/hp-search-widget-container/hp-search-widget/"
				+ "div/hp-flight-search-widget-container/fsw-flight-search-widget-container/fsw-flight-search-widget/div/fsw-flight-search-widget-"
				+ "controls-container/fsw-flight-search-widget-controls/div[1]/div[2]/fsw-input-button/div/div[2]")).getText();
		
		Assertions.assertEquals("2 Adults", numOfPassengers);
		
		//Onto next page
		driver.findElement(By.className("flight-search-widget__start-search-cta")).click();

	}

}
