package testcases;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import base.BaseTest;
import objectrepository.AmazonHomePage;
import utility.HelperMethods;

public class AmazonOrderLifecycle extends BaseTest {
	HelperMethods hm = new HelperMethods();
	AmazonHomePage ahp;

	@Test
	public void amazonAssert() throws InterruptedException {
		ahp = new AmazonHomePage(driver);
		Actions actions = new Actions(driver);
		actions.moveToElement(ahp.hamburgerMenu()).click().build().perform();
		hm.wait(driver, ahp.customerName());
		List<WebElement> deptList = ahp.shopByDept();
		hm.scrollHandleList(deptList, driver, "Shop By Department");

		List<WebElement> electronicsCatList = ahp.electronicsCatList();
		hm.clickHandleList(electronicsCatList, driver, "TV, Appliances, Electronics");

		List<WebElement> televisionsCatList = ahp.televisionsCatList();
		hm.clickHandleList(televisionsCatList, driver, "Televisions");

		List<WebElement> brandsList = ahp.shopByDept();
		hm.scrollHandleList(brandsList, driver, "Brands");

		List<WebElement> selSamsungList = ahp.selSamsungList();
		hm.clickHandleList(selSamsungList, driver, "Samsung");

		hm.wait(driver, ahp.selHighToLow());
		hm.selectByVisibleText(ahp.selHighToLow(), driver, "Price: High to Low");
		hm.clickIndexHandleList(ahp.finalProductList(), driver, 1);
		hm.switchWindow(driver);
		hm.scrollHandleList(ahp.aboutThisItemList(), driver, "About this item");
		hm.assertConditionHandleList(ahp.aboutThisItemList(), driver, "About this item");
		hm.closeCurrentWindow(driver);
		hm.switchWindow(driver);

	}

}
