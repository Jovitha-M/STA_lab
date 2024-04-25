package Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private String baseUrl = "http://localhost:5173"; // Change this to your app's URL
    private BookingPage bookingPage;
    private ConfirmationPage confirmPage;
    
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        bookingPage = new BookingPage(driver);
        confirmPage = new ConfirmationPage(driver);
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"jovi", "jovi@123"},
            {"invalid_name","invalid_password"},
            {"",""}
        };
    }

    @Test(dataProvider = "loginData", priority=0)
    public void testLogin(String username, String password) throws InterruptedException{
    	System.out.println("Entering the credentials for login");
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/home");
        System.out.println("After successful login, redirected to home");
    }
    
    @Test(priority=1)
    public void testBooking() throws InterruptedException{
		Thread.sleep(2000);
		System.out.println("Booking a service");
    	bookingPage.clickBookingButton();
		Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/service");
        System.out.println("List of services");
        Thread.sleep(2000);
        bookingPage.clickChooseServiceButton();
        Thread.sleep(2000);
        System.out.println("Selecting the type of service");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/service/workers");
        System.out.println("Redirection to workers selection page");
        Thread.sleep(2000);
        
    }
    
    @Test(priority=2)
    public void testBookingRequest() throws InterruptedException{
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("scrollBy(0, 2500)");
    	Thread.sleep(2000);
    	System.out.println("Accepting the worker");
    	driver.findElement(By.xpath("//*[@id=\"actions\"]/button[2]/div")).click();
		Thread.sleep(5000);
		js.executeScript("scrollTo(0, 0)");
		System.out.println("Redirection to previous page after successful request for service");
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/a")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/service");
		System.out.println("Check status of the bookings");
        confirmPage.clickMyBookingsButton();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/bookings");
        System.out.println("Pending status");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
