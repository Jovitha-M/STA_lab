package Customer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {
    private WebDriver driver;
    List<WebElement> statusButtons;
    //private By paymentButton = By.xpath("//*[@id=\"root\"]/div/div/div/table/tbody/tr/th/button");
    private By cardNumberInput = By.cssSelector("#root > div > div > div > div:nth-child(4) > div > input:nth-child(2)");
    private By expiryDateInput = By.cssSelector("#root > div > div > div > div:nth-child(4) > div > input:nth-child(4)");
    private By cvvInput = By.xpath("//*[@id=\"root\"]/div/div/div/div[4]/div/input[3]");
    private By payButton = By.xpath("//*[@id=\"root\"]/div/div/div/div[5]/button");
    
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void setCardNumber(String cardNumber) {
        WebElement cardNumberElement = driver.findElement(cardNumberInput);
        cardNumberElement.clear();
        cardNumberElement.sendKeys(cardNumber);
    }
    
    public void setExpiryDate(String expiryDate) {
        WebElement expiryDateElement = driver.findElement(expiryDateInput);
        expiryDateElement.clear();
        expiryDateElement.sendKeys(expiryDate);
    }
    
    public void setCvv(String cvv) {
        WebElement cvvElement = driver.findElement(cvvInput);
        cvvElement.clear();
        cvvElement.sendKeys(cvv);
    }
    
    public void clickPaymentButton() {
        statusButtons = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div/div/table/tbody/tr/th/button"));
        for (WebElement button : statusButtons) {
            if (button.getText().equals("Pay Now")) {
                button.click();
                break;
            }
        }
    }
    
    public void clickPayButton() {
        driver.findElement(payButton).click();
    }
    
}
