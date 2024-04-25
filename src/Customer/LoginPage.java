package Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By usernameInput = By.cssSelector("input[placeholder='Username']");
    private By passwordInput = By.cssSelector("input[placeholder='Password']");
    private By loginButton = By.xpath("//button[text()='Login']");
    private By errorMessage = By.xpath("//div[@role='alert']");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
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
    
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
    
    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }
}
