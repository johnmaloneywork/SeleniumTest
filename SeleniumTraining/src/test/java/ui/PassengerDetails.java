package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PassengerDetails {
	
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
	public void priceSelection() {
		//Selecting the first price options for departure and return
		//Skipping login
		driver.findElement(By.className("flight-card-summary__select-btn")).click();
		driver.findElement(By.className("flight-card-summary__select-btn")).click();
		driver.findElement(By.className("fare-table__fare-column-border")).click();
		driver.findElement(By.className("fare-footer__submit-btn")).click();
		driver.findElement(By.className("login-touchpoint__expansion-bar")).click();
	}

	@Test
	public void passengerInfo() {
		//Passenger 1 details
		//Drop down list, Mr Ms Mrs
		driver.findElement(By.className("dropdown__toggle-chevron")).click();
		driver.findElement(By.xpath("//*[contains(text(), 'Mr')]")).click();
		
		//First name and surname
		driver.findElement(By.id("form.passengers.ADT-0.name")).click();
		driver.findElement(By.id("form.passengers.ADT-0.name")).sendKeys("John");
		driver.findElement(By.id("form.passengers.ADT-0.surname")).click();
		driver.findElement(By.id("form.passengers.ADT-0.surname")).sendKeys("Doe");
		driver.findElement(By.id("form.passengers.ADT-0.surname")).sendKeys(Keys.TAB);

		//Passenger 2 details
		//Drop down list, Mr Ms Mrs
		driver.findElement(By.xpath("//*[@id=\"title-0-error-message\"]/div[2]/button")).click();
		driver.findElement(By.xpath("//*[contains(text(), 'Ms')]")).click();
		
		//First name and surname
		driver.findElement(By.id("form.passengers.ADT-1.name")).click();
		driver.findElement(By.id("form.passengers.ADT-1.name")).sendKeys("Jane");
		driver.findElement(By.id("form.passengers.ADT-1.surname")).click();
		driver.findElement(By.id("form.passengers.ADT-1.surname")).sendKeys("Doe");
		
		
		String passengerOnePreFix = driver.findElement(By.xpath("/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-passengers/"
				+ "ry-spinner/pax-app-container/pax-app/ry-spinner/div/div/div[2]/pax-app-form-container/pax-app-form/form/pax-passenger-container[1]/pax-passenger"
				+ "/div/pax-passenger-details-container/pax-passenger-details/pax-passenger-details-form-container/pax-details-form/ry-dropdown/div[2]/button/span")).getText();
		
		Assertions.assertEquals("Mr", passengerOnePreFix);
		
		String passengerTwoPreFix = driver.findElement(By.xpath("/html/body/app-root/flights-root/div/div/div/div/flights-lazy-content/flights-passengers/"
				+ "ry-spinner/pax-app-container/pax-app/ry-spinner/div/div/div[2]/pax-app-form-container/pax-app-form/form/pax-passenger-container[2]/pax-passenger"
				+ "/div/pax-passenger-details-container/pax-passenger-details/pax-passenger-details-form-container/pax-details-form/ry-dropdown/div[2]/button/span")).getText();
		
		Assertions.assertEquals("Ms", passengerTwoPreFix);
		
		
		//Assertions for first and surnames
		WebElement passengerOneFirstName = driver.findElement(By.id("form.passengers.ADT-0.name"));
		Assertions.assertEquals(null, passengerOneFirstName.getText());
		WebElement passengerOneSurname = driver.findElement(By.id("form.passengers.ADT-0.surname"));
		Assertions.assertEquals(null, passengerOneSurname.getText());
		
		WebElement passengerTwoFirstName = driver.findElement(By.id("form.passengers.ADT-1.name"));
		Assertions.assertEquals(null, passengerTwoFirstName.getText());
		WebElement passengerTwoSurname = driver.findElement(By.id("form.passengers.ADT-1.surname"));
		Assertions.assertEquals(null, passengerTwoSurname.getText());

		//Continue to next page
		driver.findElement(By.className("continue-flow__button")).click();
	}

}
