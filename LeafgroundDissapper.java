package week4.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class LeafgroundDissapper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver objcrmdriver = new ChromeDriver();
		objcrmdriver.get("http://www.leafground.com/pages/disapper.html");
		objcrmdriver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(objcrmdriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfAllElements(objcrmdriver.findElements(By.id("btn"))));
		String textmsg = objcrmdriver.findElement(By.tagName("strong")).getText();
		System.out.println("The text message is :" + textmsg);

	}

}
