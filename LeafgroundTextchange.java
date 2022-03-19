package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundTextchange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver objcrmdriver = new ChromeDriver();
		objcrmdriver.get("http://www.leafground.com/pages/TextChange.html");
		objcrmdriver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(objcrmdriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Click ME!']"))).click();
		Alert alert = objcrmdriver.switchTo().alert();
		String alertMessage = alert.getText();
		System.out.println("alertMessage:"+alertMessage);
		alert.accept();
	}

}
