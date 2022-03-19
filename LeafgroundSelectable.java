package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundSelectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver objcrmdriver = new ChromeDriver();
		objcrmdriver.get("http://www.leafground.com/pages/selectable.html");
		objcrmdriver.manage().window().maximize();
		objcrmdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement item1 = objcrmdriver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item2 = objcrmdriver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item3 = objcrmdriver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement item4 = objcrmdriver.findElement(By.xpath("//li[text()='Item 4']"));
		WebElement item5 = objcrmdriver.findElement(By.xpath("//li[text()='Item 5']"));
		WebElement item6 = objcrmdriver.findElement(By.xpath("//li[text()='Item 6']"));
		WebElement item7 = objcrmdriver.findElement(By.xpath("//li[text()='Item 7']"));
		Actions build = new Actions(objcrmdriver);
		build.keyDown(Keys.CONTROL).click(item1).click(item2).click(item3).click(item4).click(item5).click(item6).click(item7).keyUp(Keys.CONTROL).perform();
	}

}
