package POM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import Pages.SuperTestNG;
import io.restassured.path.json.JsonPath;
import net.lightbody.bmp.core.har.HarEntry;

public class InitialOrderPage extends SuperTestNG {

	@FindBy(xpath = "//div[@role='dialog']")
	private WebElement CoachPromoDialog;

	@FindBy(xpath = "//h2[contains(@class,'header2Text')]")
	private WebElement NewCoachPromo;

	@FindBy(xpath = "//h5[contains(@class,'header5Text')]")
	private WebElement NewCoachPromoViewer;

	@FindBy(xpath = "//button[@id='buttonL']")
	private WebElement GetFitContinue;

	@FindBy(xpath = "//a[contains(@class, 'skipautorefill')]")
	private WebElement SkipGetFitAR;

	@FindBy(xpath = "(//button[contains(@ng-click, 'addQty')])[1]")
	private WebElement AddGetFitPack;

	@FindBy(xpath = "//h2[contains(@class,'summary-header')]")
	private WebElement GetFitCoach21;

	@FindBy(xpath = "//ul[@class = 'order-item-details']")
	private WebElement GetFitCertificationFee;

	@FindBy(xpath = "//div[contains(@ng-if, 'order.kit_items.length > 1 && order.getfit')]")
	private WebElement IntialOrder;

	@FindBy(xpath = "//h4")
	private WebElement SubscriptionOrder;

	@FindBy(xpath = "//a[contains(@href, 'AutoRefillTerms')]")
	private WebElement SubscriptionTerms;

	@FindBy(xpath = "//button[contains(@class, 'yes')]")
	private WebElement SubscriptionYES;

	@FindBy(xpath = "//button[contains(@class, 'no')]")
	private WebElement SubscriptionNO;

	@FindBy(xpath = "(//h4//span)[1]")
	private WebElement SetUPSubscriptionOrder;

	@FindBy(xpath = "(//h4//span)[2]")
	private WebElement SkipSubscriptionTerms;

	@FindBy(xpath = "(//h4//span)[4]")
	private WebElement WhichDaySubscriptionYES;

	@FindBy(xpath = "(//span[@class='ng-scope'])[4]")
	private WebElement SubscriptionMessage;

	@FindBy(xpath = "(//span[@class='ng-scope'])[6]")
	private WebElement WhichDaySubscriptionMessage;

	@FindBy(xpath = "//h3[contains(@class, 'subhead-green')]")
	private WebElement ARSummarySection;

	@FindBy(xpath = "(//h3[@class='summary-subhead head-summary ng-scope'])[1]")
	private WebElement EnrollProvider;

	@FindBy(xpath = "(//h3[@class='summary-subhead head-summary ng-scope'])[2]")
	private WebElement SponsorProvider;

	@FindBy(xpath = "//span[contains(@class,'stepper-title')]")
	private WebElement InitialOrder;

	@FindBy(xpath = "(//span[contains(@class,'ng-scope')])[2]")
	private WebElement StartWithBusinessPack;

	@FindBy(xpath = "(//span[contains(@class,'ng-scope')])[2]")
	private WebElement ChooseYourPackType;

	@FindBy(xpath = "(//span[@class='ng-scope'])[3]")
	private WebElement PickYourPack;

	@FindBy(xpath = "(//span[@class='ng-scope'])[3]")
	private WebElement AdditionalProductsAdded;

	@FindBy(xpath = "(//translate[@class='ng-scope'])[1]")
	private WebElement AddAdditionalProducts;

	@FindBy(xpath = "//h2[contains(@class,'summary-header')]")
	private WebElement Summary;

	@FindBy(xpath = "//h3[contains(@class,'summary-subhead')]")
	private WebElement SummaryInitialOrder;

	@FindBy(xpath = "//li[contains(@class, 'item-id')]")
	private WebElement Suman;

	@FindBys(@FindBy(xpath = "//li[@class='ng-scope']//searchproductlist//div//div//span[2]//span//div[@class='secondrow']//div[3]//span"))
	List<WebElement> Kalyan;

	@FindBys(@FindBy(xpath = "//ul[@class='category-packs-container']//li"))
	List<WebElement> Packs;

	@FindBys(@FindBy(xpath = "//ul[contains(@class,'packs-container')]//li"))
	List<WebElement> NonCategoryPacks;

	@FindBys(@FindBy(xpath = "//li[contains(@ng-repeat, 'order.kit_items')]"))
	List<WebElement> StarterKit;

	@FindBys(@FindBy(xpath = "//ul[@class='packs-container-de']//li"))
	List<WebElement> CustomPacks;

	@FindBy(xpath = "//div[contains(@class,'alert-danger')]")
	private WebElement CustomizePackError;

	@FindBy(xpath = "(//li[contains(@class, 'businesspack')]//p//span)[1]")
	private WebElement PriceOnPack;

	@FindBy(xpath = "(//li[contains(@class, 'businesspack')]//p//span)[4]")
	private WebElement PVOnPack;

	@FindBy(xpath = "(//ul[@class='summary-total colombia_sum_section']//li)[4]")
	private WebElement PriceInOrderSummary;

	@FindBy(xpath = "(//ul[@class='summary-total colombia_sum_section']//li)[3]")
	private WebElement PCPriceInOrderSummary;

	@FindBy(xpath = "(//ul[contains(@class, 'item-details')]//li[4])[1]")
	private WebElement PriceInOrderSummary1;

	@FindBy(xpath = "(//ul[@class='summary-total colombia_sum_section']//li)[3]")
	private WebElement PVInOrderSummary;

	@FindBy(xpath = "(//li[contains(@class, 'businesspack')]//div//span)[1]")
	private WebElement MouseOverButton;

	@FindBy(xpath = "//div[contains(@class, 'popover ')]")
	private WebElement MouseOverPoPup;

	@FindBy(xpath = "//div[contains(@class, 'popover ')]//h3[contains(@class, 'popover-title')]")
	private WebElement PopOverInfo;

	@FindBys(@FindBy(xpath = "//div[@class = 'noselections']"))
	List<WebElement> NoSelection;

	@FindBy(xpath = "//li[@ng-repeat='product_obj in order.kit_items']//p")
	private WebElement SelectedPack;

	@FindBys(@FindBy(xpath = "//ul[@class='order-item-details']//li[2]"))
	List<WebElement> ItemCode;

	@FindBys(@FindBy(xpath = "//ul[@class='order-item-details']//li[1]"))
	List<WebElement> ItemQuantity;

	@FindBy(xpath = "(//div[@class='products'])[2]")
	private WebElement AdditionalProductsSection;

	@FindBy(xpath = "//input[@ng-class='searchBox']")
	private WebElement searchitems;

	@FindBy(xpath = "(//h5)[1]")
	private WebElement NoProductsMatch;

	@FindBy(xpath = "//li[@ng-show='order.searchProducts && !(issearchSuggested(order.searchProducts)|| issearchAll(order.searchProducts))']")
	private WebElement SearchProducts;

	@FindBy(xpath = "(//button[contains(@ng-click, 'order.searchProducts')])[3]")
	private WebElement AtoZProducts;

	@FindBy(xpath = "(//button[contains(@ng-click, 'order.searchProducts')])[2]")
	private WebElement HCPAtoZProducts;

	@FindBys(@FindBy(xpath = "//li[@class='ng-scope']//div[contains(@class,'col-xs-4 col-sm-4 col-md-3 col-lg-3')]//span | //li[@class='ng-scope']//div[@class='col-xs-5 col-sm-4 col-md-3 col-lg-5']//span"))
	List<WebElement> CurrencySymbol;

	@FindBy(xpath = "(//button[contains(@ng-click, 'order.searchProducts')])[4]")
	private WebElement SuggestedProducts;

	@FindBy(xpath = "//li[@ng-show='issearchAll(order.searchProducts)']")
	private WebElement AtoZProductsDisplay;

	@FindBy(xpath = "//li[@ng-show='issearchSuggested(order.searchProducts)']")
	private WebElement SuggestedProductsProductsDisplay;

	@FindBy(xpath = "(//li[@class='ng-scope']//i[contains(@class, 'ico ico-add')])[2]")
	private WebElement AddAdditionalPack;

	@FindBy(xpath = "//h4[contains(@ng-if, 'additional_items')]")
	private WebElement AdditionProductsAdded;

	@FindBy(xpath = "//div[@class='row product clearfix ']")
	private WebElement AdditionalPacktoCart;

	@FindBys(@FindBy(xpath = "//ul[contains(@class, 'order-items')]//li[contains(@ng-repeat, 'product')]//p"))
	List<WebElement> Product;

	@FindBys(@FindBy(xpath = "//ul[contains(@class, 'order-items')]//ul//li[1]"))
	List<WebElement> CartQuantity;

	@FindBys(@FindBy(xpath = "//ul[contains(@class, 'order-items')]//ul//li[3]"))
	List<WebElement> PV;

	@FindBys(@FindBy(xpath = "//ul[contains(@class, 'order-items')]//ul//li[4]"))
	List<WebElement> FinalPrice;

	@FindBys(@FindBy(xpath = "//ul[contains(@class, 'order-items')]//ul//li[3]"))
	List<WebElement> PCFinalPrice;

	@FindBy(xpath = "(//ul[@class='summary-total colombia_sum_section']//li)[3]")
	private WebElement PCTotalProductPrice;

	@FindBy(xpath = "(//ul[@class='summary-total colombia_sum_section']//li)[3]")
	private WebElement PersonalVolume;

	@FindBy(xpath = "(//ul[@class='summary-total colombia_sum_section']//li)[4]")
	private WebElement TotalProductPrice;

	@FindBy(xpath = "//div[contains(@ng-if, 'isnopack')]")
	private WebElement NOPack;

	@FindBy(xpath = "//a[contains(@ng-click, 'gotoAccountSetup()')]")
	private WebElement NOPackClick;

	@FindBy(xpath = "//div[contains(@class,'summarysection')][4]/ul/li//ul/li[2]")
	private WebElement ARPackItemCode;

	@FindBy(xpath = "//button[contains(@class, 'continue-btn')]")
	private WebElement Continue;

	public InitialOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void Packs(String Market, String language, String pack)
			throws InterruptedException, JSONException, IOException {
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("(//img[@src='assets/img/ajax-loader.gif'])[1]")));

		if (userdata.get("testcase") == "referalid") {
			Assert.assertEquals(EnrollProvider.getText(), getTranslation("yourenroller", language),
					"Low Referral ID is not displaying");
			Assert.assertEquals(SponsorProvider.getText(), getTranslation("yoursponsor", language),
					"Low Referral ID is not displaying");
			childtest.log(LogStatus.INFO, "", "Referral ID");
		}

		if (pack == "Pack") {
			if (!(Market == "India")) {

				List<HarEntry> entries = server.getHar().getLog().getEntries();
				for (HarEntry entry : entries) {
					if (entry.getRequest().getMethod().equals("POST")) {
						if (entry.getRequest().getUrl().contains("quotes?")) {

							System.out.println("Request URL: " + entry.getRequest().getUrl());
							System.out.println("Entry Quotes response : " + entry.getResponse().getContent().getText());
							System.out.println("Entry request : " + entry.getRequest().getPostData().getText());

							/*
							 * Checking Quotes Call and Pushing the Items codes
							 * in to the array and sorting
							 */

							JSONObject QuotesResponse = new JSONObject(entry.getResponse().getContent().getText()
									.toString()
									.substring(entry.getResponse().getContent().getText().toString().indexOf("{"))
									.trim());
							rrr.add(new JsonPath(QuotesResponse.toString()).get("items.lines.items.item.id.unicity")
									.toString().replace("],", ",").replace(" [", " ").replace("[[", "")
									.replace("]]", ""));
							Collections.sort(rrr);
							num = new JsonPath(QuotesResponse.toString()).get("items.lines.items.item.id.unicity")
									.toString().replace("],", ",").replace(" [", " ").replace("[[", "")
									.replace("]]", "").replace(" ", "");

							if (num.equals("[]")) {
								Assert.fail("Critical Packs not returning from Quotes Call");
							}

							Assert.assertEquals(entry.getRequest().getUrl(),
									userdata.get("proto") + userdata.get("version") + "quotes?&expand=item",
									"Critical Quotes url");
							childtest.log(LogStatus.INFO, "Initial Order", "");
							childtest.log(LogStatus.INFO, "", "<a href=" + entry.getRequest().getUrl() + ">Quotes</a>");
						}
					}
				}

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,250)", "");

				/*
				 * Checking the Price & PV in Order Summary & On the Pack
				 * Ireland, Norway, Poland, Ukraine are Non Category packs flow
				 */

				if (Market == "Ireland" || Market == "Norway" || Market == "Poland" || Market == "Ukraine") {
					for (WebElement CustomPack : NonCategoryPacks) {
						CustomPack.click();

						Assert.assertEquals(PriceOnPack.getText(), PriceInOrderSummary1.getText(),
								"Major Price On Pack");
						Assert.assertEquals(PVOnPack.getText().replaceAll(": ", ""), PVInOrderSummary.getText(),
								"Major PV on Pack");

						Thread.sleep(50);
						jse.executeScript("window.scrollBy(0,50)", "");
						MouseOverButton.click();
						Thread.sleep(50);
						vvv.add(Suman.getText().replace("#", "").replace(", ", ","));
						Assert.assertTrue(MouseOverPoPup.isDisplayed(), "Major");

						/*
						 * Checking the Price & PV in Pack, Order summary, Mouse
						 * over info
						 */

						if (language == "русский") {
							String input = StringUtils.stripAccents(PopOverInfo.getText());
							String[] dfd = input.replace("ТЕКУЩАЯ", "").replace("СТОИМОСТЬ", "")
									.replaceAll("[A-Za-z : _]", "").trim().split("-");

							for (@SuppressWarnings("unused")
							String d : dfd) {
								Assert.assertEquals(dfd[0].trim(), PVOnPack.getText().trim().replaceAll(": ", ""),
										"Major PV in Pop up");
								Assert.assertEquals(dfd[0].trim(), PVInOrderSummary.getText().trim(),
										"Major PV in Order summary");

								Assert.assertEquals(dfd[1].split("\n")[0], PriceOnPack.getText().trim(),
										"Major price in pop up");
								Assert.assertEquals(dfd[1].split("\n")[0], PriceInOrderSummary1.getText().trim(),
										"Major pv in order summary");
							}
						}

						/*
						 * Checking the Price & PV in Pack, Order summary, Mouse
						 * over info
						 */

						if (language == "Polish") {
							String input = StringUtils.stripAccents(PopOverInfo.getText());
							String[] dfd = input.replaceAll("[A-Za-z : _]", "").trim().replace("®", "").split("\n");
							System.out.println(dfd[1]);
							for (@SuppressWarnings("unused")
							String d : dfd) {

								Assert.assertEquals(dfd[0].trim(), PVOnPack.getText().trim().replaceAll(": ", ""),
										"Major PV in pop up");
								Assert.assertEquals(dfd[0].trim(), PVInOrderSummary.getText().trim(),
										"Major PV in order summary");

								Assert.assertEquals(dfd[1].trim().replace("-", ""), PriceOnPack.getText().trim(),
										"Major price in pop up");
								Assert.assertEquals(dfd[1].trim().replace("-", ""),
										PriceInOrderSummary1.getText().trim(), "Major price in order summary");
							}
						}

						/*
						 * Checking the Price & PV in Pack, Order summary, Mouse
						 * over info
						 */

						if (!(language == "русский" || language == "Polish")) {

							String input = StringUtils.stripAccents(PopOverInfo.getText());
							String km = input.replaceAll("\\G(.*\r?\n).*(?:\r?\n|$)", "$1");
							String[] dfd = km.replaceAll("[A-Za-z : _]", "").trim().split("-");
							for (@SuppressWarnings("unused")
							String d : dfd) {

								Assert.assertEquals(dfd[0].trim(), PVOnPack.getText().trim().replaceAll(": ", ""),
										"Major pv in pop up");
								Assert.assertEquals(dfd[0].trim(), PVInOrderSummary.getText().trim(),
										"Major pv in order summary");

								Assert.assertEquals(dfd[1].trim(), PriceOnPack.getText().trim(),
										"Major price in pop up");
								Assert.assertEquals(dfd[1].trim(), PriceInOrderSummary1.getText().trim(),
										"Major price in order summary");
							}
						}
					}
				}

				/*
				 * checking the No Pack error if Customization pack is not there
				 */
				for (int i = 0; i < Packs.size(); i++) {
					Packs.get(i).click();

					if (CustomPacks.size() == 0) {
						try {
							Boolean NoPack = CustomizePackError.isDisplayed();
							Assert.assertTrue(NoPack);
						} catch (Exception e) {
							Assert.fail("Major Customization error");
						}
					}

					if (CustomPacks.size() >= 1) {
						try {
							Boolean NoPack = CustomizePackError.isDisplayed();
							Assert.assertFalse(NoPack, "Major Customization error");
						} catch (Exception e) {

						}
					}

					/*
					 * Checking price & PV for Category flow markets Checking
					 * the Price & PV in Pack, Order summary, Mouse over info
					 */

					for (WebElement CustomPack : CustomPacks) {
						CustomPack.click();
						if (!(Market == "Canada" || Market == "Colombia" || Market == "Bahamas" || Market == "Dominican Republic"
								|| Market == "Jamaica" || Market == "Mexico" || Market == "Puerto Rico"
								|| Market == "United States")) {
							if (StarterKit.size() == 1) {
								
								Assert.assertEquals(PriceOnPack.getText(), PriceInOrderSummary.getText(),
										"Major pirce on pack");
								Assert.assertEquals(PVOnPack.getText().replaceAll(": ", ""), PVInOrderSummary.getText(),
										"Major pv on pack");
							} else {
								Assert.assertEquals(PriceOnPack.getText(), PriceInOrderSummary1.getText(),
										"Major price in order sumary");
								Assert.assertEquals(PVOnPack.getText().replaceAll(": ", ""), PVInOrderSummary.getText(),
										"Major pv in order summary");
							}
						}

						if (Market == "Bahamas" || Market == "Canada" || Market == "Colombia" ||Market == "Dominican Republic"
								|| Market == "Jamaica" || Market == "Mexico" || Market == "Puerto Rico"
								|| Market == "United States") {
							Assert.assertEquals(PriceOnPack.getText(), PriceInOrderSummary.getText(),
									"Major price on pack");
							Assert.assertEquals(PVOnPack.getText().replaceAll(": ", ""), PVInOrderSummary.getText(),
									"Major pv on pack");
						}
						Thread.sleep(50);
						jse.executeScript("window.scrollBy(0,50)", "");
						MouseOverButton.click();
						Thread.sleep(50);
						vvv.add(Suman.getText().replace("#", "").replace(", ", ","));
						Assert.assertTrue(MouseOverPoPup.isDisplayed(), "Major mouse over popup");

						if (StarterKit.size() == 1) {
							if (!(Market == "Switzerland")) {
								String km = PopOverInfo.getText().replaceAll("\\G(.*\r?\n).*(?:\r?\n|$)", "$1");
								String[] dfd = km.replaceAll("[A-Za-z : _]", "").trim().split("-");
								for (@SuppressWarnings("unused")
								String d : dfd) {

									Assert.assertEquals(dfd[0], PVOnPack.getText().replaceAll(": ", ""),
											"Major pv on pack");
									Assert.assertEquals(dfd[0], PVInOrderSummary.getText(),
											"Major pv in order summary");

									Assert.assertEquals(dfd[1], PriceOnPack.getText(), "Major price on pack");
									Assert.assertEquals(dfd[1], PriceInOrderSummary.getText(),
											"Major price in order summary");
								}
							}
						} else {
							if (Market == "Bahamas" || Market == "Canada"  ||  Market == "Colombia" || Market == "Dominican Republic"
									|| Market == "Jamaica" || Market == "Mexico" || Market == "Puerto Rico"
									|| Market == "United States") {
								String km = PopOverInfo.getText().replaceAll("\\G(.*\r?\n).*(?:\r?\n|$)", "$1");
								String[] dfd = km.replaceAll("[A-Za-z : _]", "").trim().split("-");
								for (@SuppressWarnings("unused")
								String d : dfd) {

									Assert.assertEquals(dfd[0], PVOnPack.getText().replaceAll(": ", ""),
											"Major pv on pack");
									Assert.assertEquals(dfd[0], PVInOrderSummary.getText(),
											"Major pv in order summary");

									Assert.assertEquals(dfd[1], PriceOnPack.getText(), "Major price on pack");
									Assert.assertEquals(dfd[1], PriceInOrderSummary.getText(),
											"Major price in order summary");
								}
							} else {
								if (!(Market == "Switzerland")) {
									String km = PopOverInfo.getText().replaceAll("\\G(.*\r?\n).*(?:\r?\n|$)", "$1");
									String[] dfd = km.replaceAll("[A-Za-z : _]", "").trim().split("-");
									for (@SuppressWarnings("unused")
									String d : dfd) {

										Assert.assertEquals(dfd[0], PVOnPack.getText().replaceAll(": ", ""),
												"Major pv on pack");
										Assert.assertEquals(dfd[0], PVInOrderSummary.getText(),
												"Major pv in order summary");

										Assert.assertEquals(dfd[1], PriceOnPack.getText(), "Major pirce on pack");
										Assert.assertEquals(dfd[1], PriceInOrderSummary1.getText(),
												"Major price in order summary");
									}
								}
							}
						}

						if (Market == "Switzerland") {
							if (StarterKit.size() == 1) {
								String km = PopOverInfo.getText().replaceAll("\\G(.*\r?\n).*(?:\r?\n|$)", "$1");
								String[] dfd = km.replaceAll("[A-Za-z : _]", "").trim().split("-");
								for (@SuppressWarnings("unused")
								String d : dfd) {

									Assert.assertEquals(dfd[0], PVOnPack.getText().replaceAll(": ", ""),
											"Major pv on pack");
									Assert.assertEquals(dfd[0], PVInOrderSummary.getText(),
											"Major pv in order summary");

									Assert.assertEquals("chf " + dfd[1], PriceOnPack.getText(), "Major price on pack");
									Assert.assertEquals("chf " + dfd[1], PriceInOrderSummary.getText(),
											"Major price on order summary");
								}
							} else {
								String km = PopOverInfo.getText().replaceAll("\\G(.*\r?\n).*(?:\r?\n|$)", "$1");
								String[] dfd = km.replaceAll("[A-Za-z : _]", "").trim().split("-");
								for (@SuppressWarnings("unused")
								String d : dfd) {

									Assert.assertEquals(dfd[0], PVOnPack.getText().replaceAll(": ", ""),
											"Major pv on pack");
									Assert.assertEquals(dfd[0], PVInOrderSummary.getText(),
											"Major pv in order summary");

									Assert.assertEquals("chf " + dfd[1], PriceOnPack.getText(), "Major price on pack");
									Assert.assertEquals("chf " + dfd[1], PriceInOrderSummary1.getText(),
											"Major price in order summary");
								}
							}
						}

						jse.executeScript("window.scrollBy(0,50)", "");
					}
				}

				childtest.log(LogStatus.INFO, "", "Checked Packs Price & PV");
				
				
				/*if (Market == "Germany") {
					
					AtoZProducts.click();
					AddAdditionalPack.click();
					int totalpv = (Integer.parseInt(PersonalVolume.getText()));
					
					
					
					childtest.log(LogStatus.INFO, "", "Checked PV Offer");
					
				}*/
				
			}
		}

	}

	public void AdditionalProducts(String Market, String pack) {
		if (!(pack == "NoPack")) {
			if (!(Market == "India")) {
				/*
				 * Additional Products Section Suggested Products Section Search
				 * Option Additional Pack Currency
				 */
				try {
					Boolean AdditionalPacksSection = AdditionalProductsSection.isDisplayed();
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy(0,200)", "");
					Assert.assertTrue(AdditionalPacksSection);

					try {
						searchitems.sendKeys("Glucose");
						Assert.assertTrue(NoProductsMatch.isDisplayed() || SearchProducts.isDisplayed(),
								"Major Search result is not working");
						searchitems.clear();
					} catch (Exception e) {
						Assert.fail("Major Search is not working");
					}

					childtest.log(LogStatus.INFO, "Additonal Products", "Search product");

					try {
						if (!(userdata.get("testcase") == "hcp")) {
							Boolean AtoZ = AtoZProducts.isDisplayed();
							Assert.assertTrue(AtoZ, "Major A-Z is not working");
							AtoZProducts.click();
						}

						if (userdata.get("testcase") == "hcp") {
							Boolean AtoZ = HCPAtoZProducts.isDisplayed();
							Assert.assertTrue(AtoZ, "Major A-Z is not working");
							HCPAtoZProducts.click();
						}

						for (int i = 0; i < Kalyan.size(); i++) {
							vvv.add(Kalyan.get(i).getText().replace("#", "").trim());
						}

						Boolean AtoZDisplay = AtoZProductsDisplay.isDisplayed();
						Assert.assertTrue(AtoZDisplay, "Major A-Z is not displaying");
						childtest.log(LogStatus.INFO, "", "A-Z");

						jse.executeScript("window.scrollBy(0,200)", "");
						AddAdditionalPack.click();

						Boolean AdditionalProducts = AdditionProductsAdded.isDisplayed();
						Boolean AddtionaltoCart = AdditionalPacktoCart.isDisplayed();
						Assert.assertTrue(AdditionalProducts, "Major Additional Products not displaying");
						Assert.assertTrue(AddtionaltoCart, "Major Additional Products in cart not displaying");
						childtest.log(LogStatus.INFO, "", "Added A-Z");

						for (WebElement Symbol : CurrencySymbol) {
							String currencysymbol = Symbol.getText().replaceAll("[0-9.,]", "").trim();
							if (Market == "Australia" || Market == "Bahamas" || Market == "Canada"
									|| Market == "Colombia" || Market == "Dominican Republic" || Market == "Jamaica"
									|| Market == "Mexico" || Market == "New Zealand" || Market == "Puerto Rico"
									|| Market == "United States" || Market == "Ukraine") {
								Assert.assertEquals(currencysymbol, "$", "Critical currency symbol");
								userdata.put("Currency", "USD");
							}
							if (Market == "Austria" || Market == "Belgium" || Market == "Denmark" || Market == "France"
									|| Market == "Germany" || Market == "Hungary" || Market == "Italy"
									|| Market == "Ireland" || Market == "Luxembourg" || Market == "Netherlands"
									|| Market == "Norway" || Market == "Poland" || Market == "Sweden"
									|| Market == "Spain") {
								Assert.assertEquals(currencysymbol, "€", "Critical currency symbol");
								userdata.put("Currency", "EUR");
							}
							if (Market == "Switzerland") {
								Assert.assertEquals(currencysymbol, "chf", "Critical currency symbol");
								userdata.put("Currency", "CHF");
							}
							if (Market == "United Kingdom") {
								Assert.assertEquals(currencysymbol, "£", "Critical currency symbol");
								userdata.put("Currency", "EUR");
							}
						}
						childtest.log(LogStatus.INFO, "", "Currency Symbol");

						if (!(userdata.get("testcase") == "hcp")) {
							if (!(Market == "Colombia" || Market == "Mexico" || Market == "Puerto Rico")) {
								Boolean Suggested = SuggestedProducts.isDisplayed();
								Assert.assertTrue(Suggested, "Major Suggested not dispalying");
								SuggestedProducts.click();

								Boolean SuggestedDisplay = SuggestedProductsProductsDisplay.isDisplayed();
								Assert.assertTrue(SuggestedDisplay, "Major suggested products not dispalying");
							}
						}

						for (int i = 0; i < Packs.size(); i++) {
							Packs.get(new Random().nextInt(Packs.size())).click();
							Thread.sleep(200);
							if (NoSelection.size() == 0) {
								break;
							}
						}
						if (Market == "Ukraine") {
							NonCategoryPacks.get(new Random().nextInt(NonCategoryPacks.size())).click();
							Thread.sleep(200);
						}

						/*
						 * Checking the Added Products is displaying in Order
						 * summary or not
						 */

						for (int i = 0; i < ItemCode.size(); i++) {
							packs.add("https://hydraqa.unicity.net/" + userdata.get("version") + "items?id.unicity="
									+ ItemCode.get(i).getText().replace("#", ""));
							Itemcode.add(ItemCode.get(i).getText().replace("#", ""));
						}

						for (int i = 0; i < ItemQuantity.size(); i++) {
							Quantity.add(ItemQuantity.get(i).getText());
						}
						Collections.sort(packs);
						Collections.sort(Itemcode);
						childtest.log(LogStatus.INFO, "Pack selected", SelectedPack.getText());
						childtest.log(LogStatus.INFO, "Item Codes", Itemcode.toString());

					} catch (Exception e) {
						Assert.fail("Critical A-Z section not displaying");
					}
				} catch (Exception e) {
					Assert.fail("Critical A-Z section not displaying");
				}
				childtest.log(LogStatus.INFO, "", "Added Suggested");

				/*
				 * Checking the Total Price & PV in Cart
				 */
				int totalpv = (Integer.parseInt(PersonalVolume.getText()));
				float totalprice = (Float.parseFloat(TotalProductPrice.getText().replaceAll("[^\\d.]+", "").trim()));
				float sum = 0;
				int pvs = 0;
				for (int i = 0; i < Product.size(); i++) {
					String Rama = FinalPrice.get(i).getText().replaceAll("[^\\d.]+", "").trim();
					String Sita = CartQuantity.get(i).getText().replaceAll("[^\\d.]+", "").trim();
					float n = Float.valueOf(Rama) * Float.valueOf(Sita);
					sum = sum + n;
				}
				for (int j = 0; j < Product.size(); j++) {
					String Ravana = PV.get(j).getText().replaceAll("[^\\d.]+", "").trim();
					String Arjuna = CartQuantity.get(j).getText().replaceAll("[^\\d.]+", "").trim();
					int m = Integer.valueOf(Ravana) * Integer.valueOf(Arjuna);
					pvs = pvs + m;
				}
				DecimalFormat df2 = new DecimalFormat("#.##");
				Float result1 = Float.valueOf(df2.format(sum));
				
				if (Market == "Colombia"){
					Assert.assertEquals(sum, totalprice, "Critical total price Mismatch");
				} else {
					Assert.assertEquals(result1, totalprice, "Critical total price Mismatch");
				}
				userdata.put("cartprice", String.valueOf(totalprice));
				Assert.assertEquals(pvs, totalpv, "Critical total PV mismatch");
				childtest.log(LogStatus.INFO, "", "Calculated Total Price, PV");

			}
		}
		if (!(Market == "India")) {
			if (pack == "NoPack") {
				try {
					Boolean NoPack = NOPack.isDisplayed();
					Assert.assertTrue(NoPack, "Major NOPack Click Here");
					NOPackClick.click();
					childtest.log(LogStatus.INFO, "NOPack", "Calculated Total Price, PV");
				} catch (Exception e) {
					Assert.fail("Major NOPack Click Here");
				}
			} else {
				Continue.click();
			}
		}
	}

	public void PCPacks(String Market, String language, String pack) throws InterruptedException, JSONException {

		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath("(//img[@src='assets/img/ajax-loader.gif'])[1]")));

		List<HarEntry> entries = server.getHar().getLog().getEntries();
		for (HarEntry entry : entries) {
			if (entry.getRequest().getMethod().equals("POST")) {
				if (entry.getRequest().getUrl().contains("quotes?")) {

					System.out.println("Request URL: " + entry.getRequest().getUrl());
					System.out.println("Entry Quotes response : " + entry.getResponse().getContent().getText());
					System.out.println("Entry request : " + entry.getRequest().getPostData().getText());

					/*
					 * Checking Quotes Call and Pushing the Items codes in to
					 * the array and sorting
					 */

					JSONObject QuotesResponse = new JSONObject(entry.getResponse().getContent().getText().toString()
							.substring(entry.getResponse().getContent().getText().toString().indexOf("{")).trim());
					rrr.add(new JsonPath(QuotesResponse.toString()).get("items.lines.items.item.id.unicity").toString()
							.replace("],", ",").replace(" [", " ").replace("[[", "").replace("]]", ""));
					Collections.sort(rrr);
					num = new JsonPath(QuotesResponse.toString()).get("items.lines.items.item.id.unicity").toString()
							.replace("],", ",").replace(" [", " ").replace("[[", "").replace("]]", "").replace(" ", "");

					if (num.equals("[]")) {
						Assert.fail("Critical Packs not returning from Quotes Call");
					}

					Assert.assertEquals(entry.getRequest().getUrl(),
							userdata.get("proto") + userdata.get("version") + "quotes?&expand=item",
							"Critical Quotes url");
					childtest.log(LogStatus.INFO, "Initial Order", "");
					childtest.log(LogStatus.INFO, "", "<a href=" + entry.getRequest().getUrl() + ">Quotes</a>");

					/*
					 * checking the No Pack error if Customization pack is not
					 * there
					 */
					for (int i = 0; i < Packs.size(); i++) {
						Packs.get(i).click();

						for (WebElement CustomPack : CustomPacks) {
							CustomPack.click();

							Assert.assertEquals(PriceOnPack.getText(), PCPriceInOrderSummary.getText(),
									"Major price on pack");
							Thread.sleep(50);
							JavascriptExecutor jse = (JavascriptExecutor) driver;
							jse.executeScript("window.scrollBy(0,50)", "");
							MouseOverButton.click();
							Thread.sleep(50);
							vvv.add(Suman.getText().replace("#", "").replace(", ", ","));
							Assert.assertTrue(MouseOverPoPup.isDisplayed(), "Major mouse over popup");

							String km = PopOverInfo.getText().replaceAll("\\G(.*\r?\n).*(?:\r?\n|$)", "$1");
							String[] dfd = km.replaceAll("[A-Za-z : _]", "").trim().split("-");
							for (@SuppressWarnings("unused")
							String d : dfd) {

								Assert.assertEquals(dfd[0], PriceOnPack.getText(), "Major price on pack");
								Assert.assertEquals(dfd[0], PCPriceInOrderSummary.getText(),
										"Major price in order summary");
							}
						}
					}
				}
			}
		}

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

	}

	public void PCAdditionalProducts(String Market, String pack) {

		/*
		 * Additional Products Section Suggested Products Section Search Option
		 * Additional Pack Currency
		 */
		try {
			Boolean AdditionalPacksSection = AdditionalProductsSection.isDisplayed();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,200)", "");
			Assert.assertTrue(AdditionalPacksSection);

			try {
				searchitems.sendKeys("Glucose");
				Assert.assertTrue(NoProductsMatch.isDisplayed() || SearchProducts.isDisplayed(),
						"Major Search result is not working");
				searchitems.clear();
			} catch (Exception e) {
				Assert.fail("Major Search is not working");
			}

			childtest.log(LogStatus.INFO, "Additonal Products", "Search product");

			try {
				Boolean AtoZ = AtoZProducts.isDisplayed();
				Assert.assertTrue(AtoZ, "Major A-Z is not working");
				AtoZProducts.click();
				for (int i = 0; i < Kalyan.size(); i++) {
					vvv.add(Kalyan.get(i).getText().replace("#", "").trim());
				}

				Boolean AtoZDisplay = AtoZProductsDisplay.isDisplayed();
				Assert.assertTrue(AtoZDisplay, "Major A-Z is not displaying");
				childtest.log(LogStatus.INFO, "", "A-Z");

				jse.executeScript("window.scrollBy(0,200)", "");
				AddAdditionalPack.click();

				Boolean AdditionalProducts = AdditionProductsAdded.isDisplayed();
				Boolean AddtionaltoCart = AdditionalPacktoCart.isDisplayed();
				Assert.assertTrue(AdditionalProducts, "Major Additional Products not displaying");
				Assert.assertTrue(AddtionaltoCart, "Major Additional Products in cart not displaying");
				childtest.log(LogStatus.INFO, "", "Added A-Z");

				for (WebElement Symbol : CurrencySymbol) {
					String currencysymbol = Symbol.getText().replaceAll("[0-9.,]", "").trim();

					Assert.assertEquals(currencysymbol, "$", "Critical currency symbol");
					userdata.put("Currency", "USD");
				}
				childtest.log(LogStatus.INFO, "", "Currency Symbol");

				if (!((userdata.get("testcase")) == "PatientPortal")) {

					if (!(Market == "Colombia" || Market == "Mexico" || Market == "Puerto Rico")) {
						Boolean Suggested = SuggestedProducts.isDisplayed();
						Assert.assertTrue(Suggested, "Major Suggested not dispalying");
						SuggestedProducts.click();

						Boolean SuggestedDisplay = SuggestedProductsProductsDisplay.isDisplayed();
						Assert.assertTrue(SuggestedDisplay, "Major suggested products not dispalying");
					}

				}

				for (int i = 0; i < Packs.size(); i++) {
					Packs.get(new Random().nextInt(Packs.size())).click();
					Thread.sleep(200);
					if (NoSelection.size() == 0) {
						break;
					}
				}

				/*
				 * Checking the Added Products is displaying in Order summary or
				 * not
				 */

				for (int i = 0; i < ItemCode.size(); i++) {
					packs.add("https://hydraqa.unicity.net/" + userdata.get("version") + "items?id.unicity="
							+ ItemCode.get(i).getText().replace("#", ""));
					Itemcode.add(ItemCode.get(i).getText().replace("#", ""));
				}

				for (int i = 0; i < ItemQuantity.size(); i++) {
					Quantity.add(ItemQuantity.get(i).getText());
				}
				Collections.sort(packs);
				Collections.sort(Itemcode);
				childtest.log(LogStatus.INFO, "Pack selected", SelectedPack.getText());
				childtest.log(LogStatus.INFO, "Item Codes", Itemcode.toString());

			} catch (Exception e) {
				Assert.fail("Critical A-Z section not displaying");
			}
		} catch (Exception e) {
			Assert.fail("Critical A-Z section not displaying");
		}
		childtest.log(LogStatus.INFO, "", "Added Suggested");

		/*
		 * Checking the Total Price in Cart
		 */
		float totalprice = (Float.parseFloat(PCTotalProductPrice.getText().replaceAll("[^\\d.]+", "").trim()));
		float sum = 0;
		for (int i = 0; i < Product.size(); i++) {
			String Rama = PCFinalPrice.get(i).getText().replaceAll("[^\\d.]+", "").trim();
			String Sita = CartQuantity.get(i).getText().replaceAll("[^\\d.]+", "").trim();
			float n = Float.valueOf(Rama) * Float.valueOf(Sita);
			sum = sum + n;
		}
		DecimalFormat df2 = new DecimalFormat("#.##");
		Float result1 = Float.valueOf(df2.format(sum));
		Assert.assertEquals(result1, totalprice, "Critical total price Mismatch");
		childtest.log(LogStatus.INFO, "", "Calculated Total Price");
		userdata.put("cartprice", String.valueOf(totalprice));
		Continue.click();
	}

	public void GetFitPacks(String Market, String language, String pack) throws IOException {

		childtest.log(LogStatus.INFO, "Intial Order", "");

		try {
			Boolean promo = CoachPromoDialog.isDisplayed();
			Assert.assertTrue(promo, "Low Promo Dialog is not displaying");
			Assert.assertEquals(NewCoachPromo.getText(), getTranslation("getfit_promo", language), "Low promo text");
			Assert.assertEquals(NewCoachPromoViewer.getText(), getTranslation("getfit_promo_viewer", language),
					"Low promo viewer text");
			GetFitContinue.click();

			Boolean skipar = SkipGetFitAR.isDisplayed();
			Assert.assertTrue(skipar, "Skip AR is not Displaying");

		} catch (Exception e) {
			Assert.fail("Major CoachPromo Dialog Not Displaying");
		}

		childtest.log(LogStatus.INFO, "", "Coach Promo Offer");

		for (WebElement Symbol : CurrencySymbol) {
			String currencysymbol = Symbol.getText().replaceAll("[0-9.,]", "").trim();
			if (Market == "Canada" || Market == "United States") {
				Assert.assertEquals(currencysymbol, "$", "Critical currency symbol");
				userdata.put("Currency", "USD");
			}
			if (Market == "United Kingdom") {
				Assert.assertEquals(currencysymbol, "£", "Critical currency symbol");
				userdata.put("Currency", "EUR");
			}
		}
		childtest.log(LogStatus.INFO, "", "Currency Symbol");

		Assert.assertEquals(GetFitCoach21.getText(), getTranslation("getfit_coach_21", language), "Low Order Summary");

		try {
			Boolean fee = GetFitCertificationFee.isDisplayed();
			Assert.assertTrue(fee, "Major Coach Promo fee not Displaying");
		} catch (Exception e) {
			Assert.fail("Major Coach Promo fee is Displaying");
		}

		childtest.log(LogStatus.INFO, "", "Coach Certification fee");

		AddGetFitPack.click();

		try {
			Boolean initialOrder = IntialOrder.isDisplayed();
			Assert.assertTrue(initialOrder, "Major initialOrder not Displaying");
		} catch (Exception e) {
			Assert.fail("Major initialOrder is Displaying");
		}

		childtest.log(LogStatus.INFO, "", "Checked Added Pack");

		for (int i = 0; i < ItemCode.size(); i++) {

			if (ItemCode.get(i).getText().isEmpty()) {
				Itemcode.add(ItemCode.get(i).getText().replace("", "30738"));
				packs.add("https://hydraqa.unicity.net/" + userdata.get("version") + "items?id.unicity=" + "30738");
			} else {
				Itemcode.add(ItemCode.get(i).getText().replace("#", ""));
				packs.add("https://hydraqa.unicity.net/" + userdata.get("version") + "items?id.unicity="
						+ ItemCode.get(i).getText().replace("#", ""));
			}
		}

		for (int i = 0; i < ItemQuantity.size(); i++) {
			if (ItemQuantity.get(i).getText().contains("21")) {
				Quantity.add("1");
			} else {
				Quantity.add(ItemQuantity.get(i).getText());
			}
		}

		Collections.sort(packs);
		Collections.sort(Itemcode);
		childtest.log(LogStatus.INFO, "Pack selected", SelectedPack.getText());
		childtest.log(LogStatus.INFO, "Item Codes", Itemcode.toString());

		Continue.click();

		Assert.assertEquals(SubscriptionOrder.getText(), getTranslation("getfit_monthly_subscription", language),
				"Low Order Summary");

		if (Market == "United States" || Market == "Canada") {
			try {
				Boolean terms = SubscriptionTerms.isDisplayed();
				Boolean termsyes = SubscriptionYES.isDisplayed();
				Boolean termsno = SubscriptionNO.isDisplayed();

				Assert.assertTrue(terms, "Major terms not Displaying");

				Assert.assertTrue(termsyes, "Major termsyes not Displaying");
				Assert.assertTrue(termsno, "Major termsno not Displaying");
			} catch (Exception e) {
				Assert.fail("Major terms not Displaying");
			}
		}
		childtest.log(LogStatus.INFO, "", "Monthly Subscription YES");

		SubscriptionYES.click();

		Assert.assertEquals(SetUPSubscriptionOrder.getText(), getTranslation("getfit_SetUPSubscriptionOrder", language),
				"Low SetUPSubscriptionOrder");

		try {
			Boolean terms = SkipSubscriptionTerms.isDisplayed();
			Assert.assertTrue(terms, "Major SkipSubscriptionTerms not Displaying");
		} catch (Exception e) {
			Assert.fail("Major SkipSubscriptionTerms not Displaying");
		}

		if (Market == "United Kingdom") {
			Assert.assertEquals(SubscriptionMessage.getText(),
					getTranslation("getfit_SubscriptionMessage_uk", language), "Low SubscriptionMessage");
		} else {
			Assert.assertEquals(SubscriptionMessage.getText(), getTranslation("getfit_SubscriptionMessage", language),
					"Low SubscriptionMessage");
		}

		Assert.assertEquals(WhichDaySubscriptionYES.getText(),
				getTranslation("getfit_WhichDaySubscriptionYES", language), "Low WhichDaySubscriptionYES");

		childtest.log(LogStatus.INFO, "", "Checked Translations");

		AddGetFitPack.click();
		childtest.log(LogStatus.INFO, "", "Added Pack");

		try {
			Assert.assertTrue(ARSummarySection.isDisplayed());
		} catch (Exception e) {
			Assert.fail("Major AR Pack is not Displaying");
		}

		childtest.log(LogStatus.INFO, "", "AR is Displaying");
		userdata.put("aritemcode", ARPackItemCode.getText().replace("#", ""));
		childtest.log(LogStatus.INFO, "", ARPackItemCode.getText());

		Continue.click();
	}

}
