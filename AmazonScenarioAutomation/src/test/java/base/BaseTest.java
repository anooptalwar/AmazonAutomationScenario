package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private static final String CHROME = "chrome";
	private static final String FIREFOX = "firefox";
	public static WebDriver driver;
	private static Properties prop = new Properties();
	private static FileReader file;
	private String browser;
	private String baseUrl;
	private String headless;

	public int count = 0;

	@BeforeTest
	public void setUp() {

		if (driver == null) {
			try {
				file = new FileReader(
						System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
				prop.load(file);
			} catch (IOException e) {
				System.out.println("config.properties File not found");
				e.printStackTrace();
			}

			browser = prop.getProperty("browser");
			baseUrl = prop.getProperty("url");
			headless = prop.getProperty("headless");
		}

		switch (browser) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			if (headless.equals("yes")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				driver = new ChromeDriver(options);
			} else {
				driver = new ChromeDriver();
			}
			driver.get(baseUrl);
			driver.manage().window().maximize();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			if (headless.equals("yes")) {
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setHeadless(true);
				driver = new FirefoxDriver(firefoxOptions);
			} else {
				driver = new FirefoxDriver();
			}
			driver.get(baseUrl);
			driver.manage().window().maximize();
			break;
		default:
			throw new IllegalStateException(
					" Browser input given is not a valid browser choice. Please choose from the given options");
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// Tear down Function
	@AfterTest
	public void tearDown() throws IOException {
		driver.close();
		file.close();
	}
}
