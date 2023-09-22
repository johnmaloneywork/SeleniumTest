package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeatSelection {
	
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
	public void chooseSeats() {
		//Seat selection
		driver.findElement(By.xpath("//*[@id=\"seat-23B\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"seat-23C\"]")).click();

		driver.findElement(By.xpath(
				"/html/body/seats-root/div/div/div/seats-container-root/seats-container-v2/main/div[2]/div/div/div[2]/div[1]/div[2]/div[3]/div/passenger-carousel/div[2]/button"))
				.click();

		driver.findElement(By.xpath("//*[@id=\"seat-23B\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"seat-23C\"]")).click();

		driver.findElement(By.xpath(
				"/html/body/seats-root/div/div/div/seats-container-root/seats-container-v2/main/div[2]/div/div/div[2]/div[1]/div[2]/div[3]/div/passenger-carousel/div[2]/button"))
				.click();
		
		String departSeat1 = driver.findElement(By.xpath("//*[@id=\"seat-23B\"]")).getText();
		String departSeat2 = driver.findElement(By.xpath("//*[@id=\"seat-23C\"]")).getText();
		
		String returnSeat1 = driver.findElement(By.xpath("//*[@id=\"seat-23B\"]")).getText();
		String returnSeat2 = driver.findElement(By.xpath("//*[@id=\"seat-23C\"]")).getText();
		
		Assertions.assertEquals("23B", departSeat1);
		Assertions.assertEquals("23C", departSeat2);
		Assertions.assertEquals("23B", returnSeat1);
		Assertions.assertEquals("23C", returnSeat2);
		

		//Next page
		driver.findElement(By.xpath(
				"/html/body/seats-root/personalization-takeovers/ry-message-renderer[3]/ng-component/ry-enhanced-takeover-beta-desktop/div/div[3]/div[2]/div[1]/button"))
				.click();
	}

}
