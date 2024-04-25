package Customer;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;



public class sta {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("http://localhost:5173");
		System.out.println("Login Started");

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/label[1]/input")).sendKeys("jovi");

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/label[2]/input")).sendKeys("jovi@123");

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/button")).click();

		try {

			Thread.sleep(3000);

		} catch (InterruptedException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/nav/div/div/div[2]/div[2]/div/a[1]")).click();

		try {

			Thread.sleep(2000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.navigate().back();
		try {

			Thread.sleep(2000);

		} catch (InterruptedException e) {
			e.printStackTrace();

		}
		driver.close();	

	}

}
