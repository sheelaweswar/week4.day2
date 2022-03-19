package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver objcrmdriver = new ChromeDriver();
		objcrmdriver.get("http://leafground.com/pages/table.html");
		objcrmdriver.manage().window().maximize();
		objcrmdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement tablename = objcrmdriver.findElement(By.id("table_id"));
		List<WebElement> rowWebElements = tablename.findElements(By.tagName("tr"));
		int rsize = rowWebElements.size();
		System.out.println("Row count: "+rsize);
		WebElement col = rowWebElements.get(1);
		List<WebElement> column = col.findElements(By.tagName("td"));
		int csize = column.size();
		System.out.println("Column Count: "+csize);

		int findRowNum = 0;
		int findProgressColNum = 0;
		for(int i=0; i<rowWebElements.size(); i++) {
			List<WebElement> columnThElements = rowWebElements.get(i).findElements(By.tagName("th"));
			List<WebElement> columnTdElements = rowWebElements.get(i).findElements(By.tagName("td"));

			for(int j=0; j<columnThElements.size(); j++) {
				if(i == 0) {
					if(columnThElements.get(j).getText().equals("Progress"))
						findProgressColNum = j;

				}
			}

			for(int j=0; j<columnTdElements.size(); j++) {
				if(columnTdElements.get(j).getText().equals("Learn to interact with Elements")) {
					findRowNum = i;

				}
			}
		}

		int findLeastProgressRow = 0;
		int findLeastProgressVal = 100;
		for(int i=0; i<rowWebElements.size(); i++) {
			List<WebElement> columnWebElements = rowWebElements.get(i).findElements(By.tagName("td"));
			for(int j=0; j<columnWebElements.size(); j++) {
				if(i == findRowNum && j == findProgressColNum) {
					System.out.println("Progress %:"+columnWebElements.get(j).getText());
				}
				if(j == findProgressColNum) {
					if(findLeastProgressVal > Integer.parseInt(columnWebElements.get(j).getText().replaceAll("%", ""))) {
						findLeastProgressVal = Integer.parseInt(columnWebElements.get(j).getText().replaceAll("%", ""));
						findLeastProgressRow = i;
					}
				}
			}
		}


		for(int i=0; i<rowWebElements.size(); i++) {
			if(i == findLeastProgressRow) {
				WebElement checkBoxSelected = rowWebElements.get(i).findElement(By.tagName("input"));
				boolean isSelected = checkBoxSelected.isSelected();
				if(isSelected == false) {
					checkBoxSelected.click();
				}
			}
		}

	}

}
