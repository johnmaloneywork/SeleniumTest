package ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StepByStep {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		//Figuring out the flow of instructions step by step
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//First Page
		driver.get("https://www.ryanair.com/");
		driver.manage().window().maximize();
		driver.findElement(By.className("cookie-popup-with-overlay__button")).click();
		
		driver.findElement(By.id("input-button__departure")).click();
		driver.findElement(By.id("input-button__departure")).clear();
		driver.findElement(By.id("input-button__departure")).sendKeys("Dublin");
		
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.id("input-button__destination")).sendKeys("Barcelona");
		
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		driver.findElement(By.xpath("//*[contains(text(), 'Barcelona')]")).click();
		
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[contains(text(), 'Nov')]")).click();
		
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		//driver.findElement(By.className("calendar-body__cell")).findElement(By.xpath("//*[contains(text(), ' 20 ')]")).click();
		
		driver.findElement(By.xpath("//*[contains(text(), ' 20 ')]")).click();
		
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[contains(text(), ' 26 ')]")).click();
		
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.className("counter__button-wrapper--enabled")).click();
		
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.className("passengers__confirm-button")).click();
		
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.className("flight-search-widget__start-search-cta")).click();
		
		try {
			Thread.sleep(3 * 1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		//Second Page
		driver.findElement(By.className("flight-card-summary__select-btn")).click();
		
		try {
			Thread.sleep(3 * 1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.className("flight-card-summary__select-btn")).click();
		
		try {
			Thread.sleep(3 * 1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.className("fare-table__fare-column-border")).click();
		
		try {
			Thread.sleep(5 * 1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.className("fare-footer__submit-btn")).click();
		
		try {
			Thread.sleep(5 * 1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.className("login-touchpoint__expansion-bar")).click();
		
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.className("dropdown__toggle-chevron")).click();
	
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[contains(text(), 'Mr')]")).click();
		
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.id("form.passengers.ADT-0.name")).click();
		driver.findElement(By.id("form.passengers.ADT-0.name")).sendKeys("John");
		
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.id("form.passengers.ADT-0.surname")).click();
		driver.findElement(By.id("form.passengers.ADT-0.surname")).sendKeys("Doe");
		
		driver.findElement(By.id("form.passengers.ADT-0.surname")).sendKeys(Keys.TAB);
		
		
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		driver.findElement(By.xpath("//*[@id=\"title-0-error-message\"]/div[2]/button")).click();
		driver.findElement(By.xpath("//*[contains(text(), 'Ms')]")).click();
		
		
		driver.findElement(By.id("form.passengers.ADT-1.name")).click();
		driver.findElement(By.id("form.passengers.ADT-1.name")).sendKeys("Jane");
		
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.id("form.passengers.ADT-1.surname")).click();
		driver.findElement(By.id("form.passengers.ADT-1.surname")).sendKeys("Doe");
		
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.className("continue-flow__button")).click();
		
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//Third Page
		driver.findElement(By.xpath("//*[@id=\"seat-23B\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"seat-23C\"]")).click();
		
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("/html/body/seats-root/div/div/div/seats-container-root/seats-container-v2/main/div[2]/div/div/div[2]/div[1]/div[2]/div[3]/div/passenger-carousel/div[2]/button")).click();
		
		try {
			Thread.sleep(4 * 1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id=\"seat-23B\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"seat-23C\"]")).click();
		
		
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("/html/body/seats-root/div/div/div/seats-container-root/seats-container-v2/main/div[2]/div/div/div[2]/div[1]/div[2]/div[3]/div/passenger-carousel/div[2]/button")).click();
		
		try {
			Thread.sleep(1 * 1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("/html/body/seats-root/personalization-takeovers/ry-message-renderer[3]/ng-component/ry-enhanced-takeover-beta-desktop/div/div[3]/div[2]/div[1]/button")).click();
	}

}
