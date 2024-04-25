package Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

	private WebDriver driver;
	
	private By nameInput = By.cssSelector("#root > div > div > label:nth-child(3) > input");
	private By usernameInput = By.cssSelector("#root > div > div > label:nth-child(4) > input");
	private By passwordInput = By.cssSelector("#root > div > div > label:nth-child(5) > input");
	private By emailInput = By.cssSelector("#root > div > div > label:nth-child(6) > input");
	private By phoneInput = By.cssSelector("#root > div > div > label:nth-child(7) > input");
	private By typeInput = By.xpath("//*[@id=\"root\"]/div/div/label[6]/select");
	private By registerButton = By.xpath("//*[@id=\"root\"]/div/div/button");
	
	
	public RegisterPage(WebDriver driver) {
	
		this.driver = driver;
	
	}
	
	
	public void setName(String name) {
	
		WebElement nameElement = driver.findElement(nameInput);
		
		nameElement.clear();
		
		nameElement.sendKeys(name);
		
	}
	
	
	public void setUsername(String username) {
	
		WebElement usernameElement = driver.findElement(usernameInput);
		
		usernameElement.clear();
		
		usernameElement.sendKeys(username);
	
	}
	
	
	public void setPassword(String password) {
	
		WebElement passwordElement = driver.findElement(passwordInput);
		
		passwordElement.clear();
		
		passwordElement.sendKeys(password);
	
	}
	
	
	public void setEmail(String email) {
	
		WebElement emailElement = driver.findElement(emailInput);
		
		emailElement.clear();
		
		emailElement.sendKeys(email);
	
	}
	
	
	public void setPhone(String phone) {
	
		WebElement phoneElement = driver.findElement(phoneInput);
		
		phoneElement.clear();
		
		phoneElement.sendKeys(phone);
	
	}
	
	public void setType(int index) {
		Select dropDown = new Select(driver.findElement(typeInput));
		dropDown.selectByIndex(index);
	}
	
	public void clickRegisterButton() {
	
		driver.findElement(registerButton).click();
	
	}

}