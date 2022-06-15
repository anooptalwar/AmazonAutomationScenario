package objectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
	public WebDriver driver;

	public AmazonHomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	};

	@FindBy(css = "i[class*='hm-icon']")
	private WebElement hamburgerMenu;
	
	@FindBy(css = "#hmenu-customer-name")
	private WebElement customerName;

	@FindBy(css = "div[class*='hmenu-title']")
	private List<WebElement> shopByDept;
	
	@FindBy(css = "a[class='hmenu-item']")
	private List<WebElement> electronicsCatList;
	
	@FindBy(css = "a[class='hmenu-item']")
	private List<WebElement> televisionsCatList;
	
	@FindBy(css = "span[class*='a-text-bold']")
	private List<WebElement> brandsList;
	
	@FindBy(css = "span[class*='a-size-base']")
	private List<WebElement> selSamsungList;

	@FindBy(css = "#s-result-sort-select")
	private WebElement selHighToLow;
	
	@FindBy(css = "span[class*='a-size-base-plus']")
	private List<WebElement> finalProductList;
	
	@FindBy(css = "h1[class*='a-text-bold']")
	private List<WebElement> aboutThisItemList;
	
	public List<WebElement> aboutThisItemList() {
		return aboutThisItemList;
	}
	
	public List<WebElement> finalProductList() {
		return finalProductList;
	}
	
	public WebElement selHighToLow() {
		return selHighToLow;
	}
	
	public WebElement customerName() {
		return customerName;
	}
	
	public List<WebElement> selSamsungList() {
		return selSamsungList;
	}
	
	public WebElement hamburgerMenu() {
		return hamburgerMenu;
	}

	public List<WebElement> shopByDept() {
		return shopByDept;
	}
	
	public List<WebElement> electronicsCatList() {
		return electronicsCatList;
	}
	
	public List<WebElement> televisionsCatList() {
		return televisionsCatList;
	}

	public List<WebElement> brandsList() {
		return brandsList;
	}
}
