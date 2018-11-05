package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PageReservation {
	private WebDriver driver;
	private By titleText;
	private By passengerDrop;
	private By fromDrop;
	private By toDrop;
	public PageReservation(WebDriver driver) {
		this.driver = driver;
		titleText = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font");
		passengerDrop = By.name("passCount");
		fromDrop = By.name("fromPort");
		toDrop = By.name("toPort");
	}
	public void assertPage() {
		Assert.assertTrue(driver.findElement(titleText).getText().contains("Use our Flight Finder to search"));
	}
	public void selectPassengers(int CantidadPasajeros) {
		Select selectPasajeros = new Select(driver.findElement(passengerDrop));
		selectPasajeros.selectByVisibleText(Integer.toString(CantidadPasajeros));
	}
	public void selectFromPort(int index) {
		Select selectFrom = new Select(driver.findElement(fromDrop));
		selectFrom.selectByIndex(index);
	}
	public void selectToPort(String city) {
		Select selectTo = new Select(driver.findElement(toDrop));
		selectTo.selectByValue(city);
	}
	

}
