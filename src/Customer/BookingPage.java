package Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingPage {
	private WebDriver driver;
	private By bookingButton = By.xpath("//*[@id=\"root\"]/div/nav/div/div/div[2]/div[2]/div/a[1]");
	private By chooseServiceButton = By.xpath("//*[@id=\"root\"]/div/div/div/div[1]");
	
	public BookingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickBookingButton() {
        driver.findElement(bookingButton).click();
    }

	public void clickChooseServiceButton() {
        driver.findElement(chooseServiceButton).click();
    }
}
