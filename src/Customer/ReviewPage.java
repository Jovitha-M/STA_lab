package Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReviewPage {
    private WebDriver driver;
    private By commentInput = By.xpath("//*[@id=\"root\"]/div/div/div/input");
    private By reviewSubmitButton = By.xpath("//*[@id=\"root\"]/div/div/div/button");
    private By[] starReviewInputs = new By[] {
            By.cssSelector("#root > div > div > div > div > input:nth-child(1)"), // Assuming CSS selectors for each star
            By.cssSelector("#root > div > div > div > div > input:nth-child(2)"),
            By.cssSelector("#root > div > div > div > div > input:nth-child(3)"),
            By.cssSelector("#root > div > div > div > div > input:nth-child(4)"),
            By.cssSelector("#root > div > div > div > div > input:nth-child(5)")
        };
    
    public ReviewPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void setStarReview(int starReview) {
        WebElement starReviewElement = driver.findElement(starReviewInputs[starReview - 1]);
        starReviewElement.click();
    }
    
    public void setComment(String comment) {
        WebElement commentElement = driver.findElement(commentInput);
        commentElement.clear();
        commentElement.sendKeys(comment);
    }
    
    public void clickReviewSubmitButton() {
        driver.findElement(reviewSubmitButton).click();
    }
    
}
