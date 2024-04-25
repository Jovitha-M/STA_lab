package Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    private WebDriver driver;
    private By profileImage = By.xpath("//*[@id=\"root\"]/div/nav/div/div/div[3]/div");
    private By profileLink = By.id("headlessui-menu-item-:r9:");
    private By editProfileButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[4]/button[2]");
    private By nameInput = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[1]/label/input");
    private By emailInput = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[2]/label/input");
    private By phoneInput = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[3]/label/input");
    private By updateButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[4]/button[1]");
    private By saveButton = By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[4]/button[2]");
    
    public ProfilePage(WebDriver driver)
    {
        this.driver = driver;
    }
    
    public void setName(String name) {
        WebElement usernameElement = driver.findElement(nameInput);
        usernameElement.clear();
        usernameElement.sendKeys(name);
    }
    
    public void setEmail(String email) {
        WebElement usernameElement = driver.findElement(emailInput);
        usernameElement.clear();
        usernameElement.sendKeys(email);
    }
    
    public void setPhone(String phone) {
        WebElement usernameElement = driver.findElement(phoneInput);
        usernameElement.clear();
        usernameElement.sendKeys(phone);
    }
    
    public void clickProfileImage() {
        driver.findElement(profileImage).click();
    }
    
    public void clickProfileLink() {
        driver.findElement(profileLink).click();
    }
    
    public void clickEditProfile() {
        driver.findElement(editProfileButton).click();
    }
    
    public void clickUpdateProfile() {
        driver.findElement(updateButton).click();
    }
    
    public void clickSaveProfile() {
        driver.findElement(saveButton).click();
    }
    
    public String getName() {
        return driver.findElement(nameInput).getAttribute("value");
    }

    public String getEmail() {
        return driver.findElement(emailInput).getAttribute("value");
    }

    public String getPhone() {
        return driver.findElement(phoneInput).getAttribute("value");
    }
}