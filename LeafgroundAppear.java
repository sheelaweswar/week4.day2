package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundAppear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver objcrmdriver = new ChromeDriver();
		objcrmdriver.get("http://www.leafground.com/pages/appear.html");
		objcrmdriver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(objcrmdriver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOfAllElements(objcrmdriver.findElements(By.xpath("//button[@id='btn']"))));
		System.out.println("The text is : "+ objcrmdriver.findElement(By.xpath("//button[@id='btn']/b")).getText());
		

	}

}
