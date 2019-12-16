package POM;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Pages.SuperTestNG;

public class AutoRefillPage extends SuperTestNG {

	@FindBys(@FindBy(xpath = "//div[@class='secondrow']/div[3]/span"))
	List<WebElement> Suman;

	@FindBy(xpath = "(//h4)[1]")
	private WebElement LikeSetupAR;

	@FindBy(xpath = "(//h4)[2]")
	private WebElement SignARFreeShip;

	@FindBy(xpath = "//a[contains(@href, 'AutoRefillTerms')]")
	private WebElement ARTerms;

	@FindBy(xpath = "//button[contains(@class, 'continue-btn')]")
	private WebElement Continue;

	@FindBy(xpath = "(//a[contains(@class, 'skipautorefill')])[1]")
	private WebElement SkipAR;

	@FindBy(xpath = "(//div[@class='products'])[2]")
	private WebElement AdditionalProductsSection;

	@FindBys(@FindBy(xpath = "//i[@class='ico ico-add']"))
	List<WebElement> PopularProducts;
	
	@FindBy(xpath = "(//button[contains(@ng-click, 'order.arsearchProducts')])[2]")
	private WebElement HCPAtoZProducts;

	@FindBy(xpath = "(//i[@class='ico ico-add'])[1]")
	private WebElement AddARPack;

	@FindBy(xpath = "//div[contains(@ng-click, 'order.arInput.arPack')]")
	private WebElement USPopularProducts;

	@FindBy(xpath = "//h3[contains(@class, 'subhead-green')]")
	private WebElement ARSummarySection;

	@FindBy(xpath = "//div[contains(@class,'summarysection')][2]/ul/li/p")
	private WebElement ARProduct;

	@FindBy(xpath = "//div[contains(@class,'summarysection')][2]/ul/li//ul/li[2]")
	private WebElement ARPackItemCode;

	@FindBy(xpath = "//div[@class='row auto_day_ship ng-scope']//h4")
	private WebElement WhichDateToShip;

	@FindBy(xpath = "//div[@class='row auto_day_ship ng-scope']//div[2]")
	private WebElement WhichDateToShipMessage;

	@FindBy(xpath = "//div[@class='row auto_day_ship ng-scope']//div[3]")
	private WebElement WhichDateToShipDates;

	@FindBy(xpath = "(//section[contains(@class,'radio-custom')]//div/h4)[2]")
	private WebElement USWhichDateToShip;

	@FindBy(xpath = "//section[contains(@class,'radio-custom')]//div/p")
	private WebElement USWhichDateToShipMessage;

	@FindBy(xpath = "(//section[contains(@class,'radio-custom')])[2]//div/div/div")
	private WebElement USWhichDateToShipDates;

	public AutoRefillPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void AutoRefill(String Market, String pack) {
		if (pack == "Pack") {
			if (!(Market == "India" || Market == "Mexico" || Market == "Ukraine")) {

				childtest.log(LogStatus.INFO, "Auto Refill", "");

				/*
				 * Set UP AR Sign UP Free Ship AR Terms Skip AR AR Addition
				 * Product Section AR Suggested Product Section
				 * 
				 */

				try {
					Boolean SetUpAR = LikeSetupAR.isDisplayed();
					Assert.assertTrue(SetUpAR, "Minor Setup AR Not displaying");
				} catch (Exception e) {
					Assert.fail("Minor SetupAR is not Displaying");
				}

				if (Market == "United States") {
					try {
						Boolean SignUPAR = SignARFreeShip.isDisplayed();
						Boolean TermsAR = ARTerms.isDisplayed();
						Assert.assertTrue(SignUPAR);
						Assert.assertTrue(TermsAR);
					} catch (Exception e) {
						Assert.fail("Minor SignARFreeShip is not Displaying");
					}
				}

				Continue.click();

				try {
					Boolean ARSkip = SkipAR.isDisplayed();
					Assert.assertTrue(ARSkip);
				} catch (Exception e) {
					Assert.fail("Minor ARSkip is not Displaying");
				}

				try {
					Boolean AdditionalPacksSection = AdditionalProductsSection.isDisplayed();
					Assert.assertTrue(AdditionalPacksSection);
				} catch (Exception e) {
					Assert.fail("Major AdditionalProducts is Missing");
				}

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,100)", "");
				if (Market == "Austria" || Market == "Belgium" || Market == "Denmark" || Market == "France"
						|| Market == "Germany" || Market == "Hungary" || Market == "Italy" || Market == "Ireland"
						|| Market == "Luxembourg" || Market == "Netherlands" || Market == "Norway" || Market == "Poland"
						|| Market == "Sweden" || Market == "Switzerland" || Market == "Spain" || Market == "Ukraine"
						|| Market == "United Kingdom") {

					// PopularProducts.get(new
					// Random().nextInt(PopularProducts.size())).click();

					for (int i = 0; i < Suman.size(); i++) {
						vvv.add(Suman.get(i).getText().replace("#", "").replace(", ", ","));
					}

					Collections.sort(vvv);
					List<Object> newList = vvv.stream().distinct().collect(Collectors.toList());

					String str[] = num.split(",");

					al = Arrays.asList(str);
					Collections.sort(al);
					List<Object> deduped = al.stream().distinct().collect(Collectors.toList());
					Assert.assertEquals(newList, deduped, "Major Quotes Call Packs is not Displaying");
					childtest.log(LogStatus.INFO, "", "All Quotes Call Packs Displaying");

					WebElement Element = PopularProducts.get(new Random().nextInt(PopularProducts.size()));
					jse.executeScript("arguments[0].scrollIntoView();", Element);
					Element.click();

					try {
						Assert.assertTrue(ARSummarySection.isDisplayed());
					} catch (Exception e) {
						Assert.fail("Major AR Pack is not Displaying");
					}
				}

				if (!(userdata.get("testcase") == "PatientPortal" || userdata.get("testcase") == "hcp" )) {
					if (Market == "Bahamas" || Market == "Canada" || Market == "Colombia"
							|| Market == "Dominican Republic" || Market == "Jamaica" || Market == "Puerto Rico"
							|| Market == "United States") {
						USPopularProducts.click();
						try {
							Assert.assertTrue(ARSummarySection.isDisplayed());
						} catch (Exception e) {
							Assert.fail("Major AR Pack is not Displaying");
						}
					}
				}
				
				if (userdata.get("testcase") == "hcp"){
					HCPAtoZProducts.click();
				}

				if (userdata.get("testcase") == "PatientPortal" || userdata.get("testcase") == "hcp") {
					AddARPack.click();
				}

				userdata.put("arpack", ARProduct.getText());
				userdata.put("aritemcode", ARPackItemCode.getText().replace("#", ""));
				childtest.log(LogStatus.INFO, "AR Pack", ARProduct.getText());
				childtest.log(LogStatus.INFO, "", ARPackItemCode.getText());

				if (Market == "Austria" || Market == "Belgium" || Market == "Denmark" || Market == "France"
						|| Market == "Germany" || Market == "Hungary" || Market == "Italy" || Market == "Ireland"
						|| Market == "Luxembourg" || Market == "Netherlands" || Market == "Norway" || Market == "Poland"
						|| Market == "Sweden" || Market == "Switzerland" || Market == "Spain" || Market == "Ukraine"
						|| Market == "United Kingdom") {
					try {
						Assert.assertTrue(WhichDateToShip.isDisplayed());
						Assert.assertTrue(WhichDateToShipMessage.isDisplayed());
						Assert.assertTrue(WhichDateToShipDates.isDisplayed());
						childtest.log(LogStatus.INFO, "", "AR Pack Ship Date");
					} catch (Exception e) {
						Assert.fail("Major Which Day TO Ship is Not Displaying");
					}
				}

				if (!(userdata.get("testcase") == "PatientPortal" || userdata.get("testcase") == "hcp")) {

					if (Market == "Bahamas" || Market == "Canada" || Market == "Dominican Republic"
							|| Market == "Jamaica" || Market == "Puerto Rico" || Market == "United States") {
						try {
							Assert.assertTrue(USWhichDateToShip.isDisplayed());
							Assert.assertTrue(USWhichDateToShipMessage.isDisplayed());
							Assert.assertTrue(USWhichDateToShipDates.isDisplayed());
							childtest.log(LogStatus.INFO, "", "AR Pack Ship Date");
						} catch (Exception e) {
							Assert.fail("Minor Which Day TO Ship is Not Displaying");
						}
					}

				}

				Continue.click();
			}
		}
	}

}
