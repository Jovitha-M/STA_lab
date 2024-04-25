package Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
	private WebDriver driver;
	private By myBookingsButton = By.xpath("//*[@id=\"root\"]/div/nav/div/div/div[2]/div[2]/div/a[2]");
	
	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickMyBookingsButton() {
        driver.findElement(myBookingsButton).click();
    }
}
