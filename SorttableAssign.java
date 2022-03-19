package week4.day2;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SorttableAssign {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver objcrmdriver = new ChromeDriver();
		objcrmdriver.get("http://www.leafground.com/pages/sortable.html");
		objcrmdriver.manage().window().maximize();
		objcrmdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> getrow = objcrmdriver.findElements(By.xpath("//ul[@id='sortable']/li"));
		WebElement drag = objcrmdriver.findElement(By.xpath("//li[@class='ui-state-default ui-sortable-handle'][1]"));
		WebElement drop = objcrmdriver.findElement(By.xpath("//li[@class='ui-state-default ui-sortable-handle'][7]"));
		Actions build = new Actions(objcrmdriver);
		for(int i = 1;i<=getrow.size();i++) {
			drag = objcrmdriver.findElement(By.xpath("//li[@class='ui-state-default ui-sortable-handle']["+i+"]"));
			drop = objcrmdriver.findElement(By.xpath("//li[@class='ui-state-default ui-sortable-handle']["+getrow.size()+"]"));
			build.clickAndHold(drop).dragAndDrop(drag, drop).perform();
		}
	}
}
