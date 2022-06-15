package utility;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperMethods {

	// Multiple Windows Handler
	public void switchWindow(WebDriver driver) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String handle : allWindows) {
			driver.switchTo().window(handle);
		}
	}

	public void closeCurrentWindow(WebDriver driver) {
		driver.close();
	}

	public void getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File capture = ss.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\screenshot\\" + testCaseName + ".png";
		FileUtils.copyFile(capture, new File(destinationFile));
	}

	public void clickHandleList(List<WebElement> elList, WebDriver driver, String expected) {

		for (WebElement el : elList) {
			if (el.getText().equals(expected)) {
				el.click();
				break;
			}
		}
	}

	public void scrollHandleList(List<WebElement> elList, WebDriver driver, String expected) {

		for (WebElement el : elList) {
			if (el.getText().equals(expected)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
				break;
			}
		}
	}

	public void clickIndexHandleList(List<WebElement> elList, WebDriver driver, int expected) {

		int count = 0;
		for (WebElement el : elList) {
			if (count == expected) {
				el.click();
				break;
			} else {
				count++;
			}
		}
	}

	public void selectByVisibleText(WebElement menu, WebDriver driver, String chooseVal) {
		Select drpOption = new Select(menu);
		drpOption.selectByVisibleText(chooseVal);
	}

	public void assertConditionHandleList(List<WebElement> elList, WebDriver driver, String expected) {
		String actual = "";

		for (WebElement el : elList) {
			if (el.getText().equals(expected)) {
				actual = el.getText();
				System.out.println(actual);
				break;
			}
		}
		assertEquals(actual, expected);

	}
	
	public void wait(WebDriver driver, WebElement ele ) {
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
}
