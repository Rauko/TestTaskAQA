import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckLinkInBrowserTask {
	// TEST-3 (iFrame)
	@Test
	public static void openBrowser() {
		
		System.out.println("TEST-3 (iFrame)");
		
		System.setProperty("webdriver.chrome.driver", "C:\\TestTaskResources\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
		driver.findElement(By.xpath("//*[contains(@id, 'textareacontainer')]"));//.getText().replace("https://www.w3schools.com","https://www.bing.com");
		driver.executeScript("span[0].innerHTML = 'https://www.bing.com';", "https://www.w3schools.com");
		System.err.println("It will only open Chrom browser... to modify DOM need to use javascript");
		WebElement runButton = driver.findElement(By.xpath("//button[contains(.,'Run »')]"));
		runButton.click();
		driver.close();
	}
}
