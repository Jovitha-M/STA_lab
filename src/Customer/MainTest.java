package Customer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private String baseUrl = "http://localhost:5173"; // Change this to your app's URL
    private BookingPage bookingPage;
    private ConfirmationPage confirmPage;
    private RegisterPage registerPage;
    private ProfilePage profilePage;
    
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        bookingPage = new BookingPage(driver);
        confirmPage = new ConfirmationPage(driver);
        registerPage = new RegisterPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"arul", "arul@123"},
            {"jovi","jovi@123"},
            {"Invalid","invalid"}
            
        };
    }
    
    @DataProvider(name = "registerData")
    public Object[][] getRegisterData() {
        return new Object[][] {
            {"John Doe", "John", "john@doe.com", "password123", "1234567890", 0},
            {"Jane Smith", "Jane", "jane@smith.com", "password456", "0987654321", 0},
            {"Invalid User", "Invalid", "invalid@email", "invalid", "1234567890", 0}
        };
    }

    @Test(dataProvider = "registerData", priority=0)
    public void testRegister(String name, String username, String email, String password, String phone, int typeIndex) throws InterruptedException {
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/a")).click();
    	Thread.sleep(1000);
        System.out.println("Entering the credentials for registration");
        registerPage.setName(name);
        registerPage.setUsername(username);
        registerPage.setEmail(email);
        registerPage.setPassword(password);
        registerPage.setPhone(phone);
        registerPage.setType(typeIndex);
        registerPage.clickRegisterButton();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl);
        System.out.println("After successful register, redirected to login page.");
    }


    @Test(dataProvider = "loginData", priority=1)
    public void testLogin(String username, String password) throws InterruptedException{
    	System.out.println("Entering the credentials for login");
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/home");
        System.out.println("After successful login, redirected to home");
    }
    
    @DataProvider(name = "updateProfileData")
    public Object[][] getUpdateData() {
        return new Object[][] {
            {"Jovitha Melcy", "jovi@gmail.com", "1234569874"}
        };
    }
    
    @Test(dataProvider = "updateProfileData", priority=2)
    public void testUpdateProfile(String name, String email, String phone) throws InterruptedException{
        driver.get(baseUrl + "/home");
        Thread.sleep(2000);
        profilePage.clickProfileImage();
        Thread.sleep(2000);
        profilePage.clickProfileLink();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/profile");
        Thread.sleep(2000);
        profilePage.clickEditProfile();
        Thread.sleep(2000);
        profilePage.setName(name);
        profilePage.setEmail(email);
        profilePage.setPhone(phone);
        Thread.sleep(2000);
        profilePage.clickUpdateProfile();
        Thread.sleep(2000);
        profilePage.clickSaveProfile();
        Thread.sleep(2000);
        driver.get(baseUrl + "/profile");
        Thread.sleep(2000);
        Assert.assertEquals(profilePage.getName(), "Jovitha Melcy");
        Assert.assertEquals(profilePage.getEmail(), "jovi@gmail.com");
        Assert.assertEquals(profilePage.getPhone(), "1234569874");
        Thread.sleep(2000);
    }
    
    @Test(priority=3)
    public void testBooking() throws InterruptedException{
		Thread.sleep(3000);
		System.out.println("Booking a service");
    	bookingPage.clickBookingButton();
		Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/service");
        System.out.println("List of services");
        Thread.sleep(1000);
        bookingPage.clickChooseServiceButton();
        Thread.sleep(1000);
        System.out.println("Selecting the type of service");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/service/workers");
        System.out.println("Redirection to workers selection page");
        Thread.sleep(1000);
        
    }
    
    @Test(priority=4)
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
