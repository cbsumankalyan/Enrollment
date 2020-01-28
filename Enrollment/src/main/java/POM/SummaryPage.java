package POM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class SummaryPage extends SuperTestNG {

	@FindBys(@FindBy(xpath = "//h3[@class='summary-subhead head-summary ng-scope']"))
	List<WebElement> EnrollerSponsor;

	@FindBys(@FindBy(xpath = "//h2"))
	List<WebElement> Headings;

	@FindBys(@FindBy(xpath = "//a[contains(@href,'.pdf')]"))
	List<WebElement> TermsandConditonsPDF;

	@FindBy(xpath = "((//ul[@class='group-wrapper table-list'])[1]//li//span[2])[1]")
	private WebElement market;

	@FindBy(xpath = "((//ul[@class='group-wrapper table-list'])[1]//li//span[2])[2]")
	private WebElement Lan;

	@FindBy(xpath = "//span[@class='ng-binding']")
	private WebElement CustomerType;

	@FindBy(xpath = "((//ul[@class='group-wrapper table-list'])[1]//li//span[2])[3]")
	private WebElement Enroller;

	@FindBy(xpath = "((//ul[@class='group-wrapper table-list'])[1]//li//span[2])[4]")
	private WebElement Sponsor;

	@FindBy(xpath = "//span[contains(@ng-model, 'firstname')]")
	private WebElement Fname;

	@FindBy(xpath = "//span[contains(@ng-model, 'lastname')]")
	private WebElement Lname;

	@FindBy(xpath = "//span[contains(@ng-model, 'dob')]")
	private WebElement DOB;

	@FindBy(xpath = "//span[contains(@ng-model, 'gender')]")
	private WebElement Gender;

	@FindBy(xpath = "//span[contains(@ng-model, 'marital')]")
	private WebElement Martial;

	@FindBy(xpath = "//span[contains(@ng-model, 'government_id')]")
	private WebElement GovID;

	@FindBy(xpath = "(//span[contains(@ng-model, 'government_id')])[2]")
	private WebElement RFC;

	@FindBy(xpath = "//span[contains(@ng-model, 'phone')]")
	private WebElement Phone;

	@FindBy(xpath = "//span[contains(@ng-model, 'mobilePhone')]")
	private WebElement Mobile;

	@FindBy(xpath = "//span[contains(@ng-model, 'Phone')]")
	private WebElement INDPhone;

	@FindBy(xpath = "//span[contains(@ng-model, 'email')]")
	private WebElement Email;

	@FindBy(xpath = "//span[contains(@ng-model, 'fax')]")
	private WebElement Fax;

	@FindBy(xpath = "//span[contains(@ng-model, 'spouse')]")
	private WebElement Coapplicant;

	@FindBy(xpath = "//span[contains(@ng-model, 'companyname')]")
	private WebElement CompanyName;

	@FindBy(xpath = "//span[contains(@ng-model, 'companytype')]")
	private WebElement CompanyType;

	@FindBy(xpath = "(//li[contains(@ng-if, 'DirectDeposit')]/span[2])[1]")
	private WebElement IBAN;

	@FindBy(xpath = "(//li[contains(@ng-if, 'DirectDeposit')]/span[2])[2]")
	private WebElement AccountTitle;

	@FindBy(xpath = "(//li[contains(@ng-if, 'DirectDeposit')]/span[2])[3]")
	private WebElement BankName;

	@FindBy(xpath = "(//li[contains(@ng-if, 'DirectDeposit')]/span[2])[4]")
	private WebElement BIC;

	@FindBy(xpath = "//span[@ng-model='order.payment.sepabankpayment.accountNumber']")
	private WebElement SEPAIBAN;

	@FindBy(xpath = "//span[@ng-model='order.payment.sepabankpayment.bankName']")
	private WebElement SEPABANKNAME;

	@FindBy(xpath = "//span[@ng-model='order.payment.sepabankpayment.accountHolder']")
	private WebElement SEPAACCOUNT;

	@FindBy(xpath = "//span[@ng-model='order.payment.sepabankpayment.bin']")
	private WebElement SEPABIC;

	@FindBy(xpath = "//span[contains(@ng-model, 'cc_name')]")
	private WebElement CCName;

	@FindBy(xpath = "//span[contains(@ng-model, 'shipping.address.line_1')]")
	private WebElement ShippingAddress1;

	@FindBy(xpath = "//span[contains(@ng-model, 'order.shipping.line_1')]")
	private WebElement FitShippingAddress1;

	@FindBy(xpath = "//span[contains(@ng-model, 'shipping.address.line_2')]")
	private WebElement ShippingAddress2;

	@FindBy(xpath = "//span[contains(@ng-model, 'order.shipping.line_2')]")
	private WebElement FitShippingAddress2;

	@FindBy(xpath = "//li[contains(@ng-if, 'shipping.address.city')]//span[2]")
	private WebElement ShippingCity;

	@FindBy(xpath = "//li/span[contains(@ng-model, 'order.shipping.city')]")
	private WebElement FitShippingCity;

	@FindBy(xpath = "((//ul[@class='group-wrapper table-list'])[5]//li//span[2])[4]")
	private WebElement ShippingState;

	@FindBy(xpath = "//li[contains(@ng-if, 'shipping.address.postal_code')]//span[2]")
	private WebElement ShippingZip;

	@FindBy(xpath = "//li/span[contains(@ng-model, 'order.shipping.postal')]")
	private WebElement FitShippingZip;

	@FindBy(xpath = "(//li[contains(@ng-if, 'country_name')]//span[2])[1]")
	private WebElement ShippingCountry;

	@FindBy(xpath = "//span[contains(@ng-model, 'payment.address.line_1')]")
	private WebElement BillingAddress1;

	@FindBy(xpath = "//span[contains(@ng-model, 'payment.address.line_2')]")
	private WebElement BillingAddress2;

	@FindBy(xpath = "//li[contains(@ng-if, 'payment.address.city')]//span[2]")
	private WebElement BillingCity;

	@FindBy(xpath = "((//ul[@class='group-wrapper table-list'])[5]//li//span[2])[4]")
	private WebElement BillingState;

	@FindBy(xpath = "//span[contains(@ng-model, 'payment.address.state')]")
	private WebElement State;

	@FindBy(xpath = "//li[contains(@ng-if, 'payment.address.postal_code')]//span[2]")
	private WebElement BillingZip;

	@FindBy(xpath = "//li/span[contains(@ng-model, 'order.payment.address.postal_code')]")
	private WebElement FitBillingZip;

	@FindBy(xpath = "(//li[contains(@ng-if, 'country_name')]//span[2])[2]")
	private WebElement BillingCountry;

	@FindBy(xpath = "//span[contains(@ng-model, 'shipping.line_1')]")
	private WebElement USShippingAddress1;

	@FindBy(xpath = "//span[contains(@ng-model, 'shipping.postal')]")
	private WebElement USShippingZip;

	@FindBy(xpath = "//span[contains(@ng-model, 'shipping.city')]")
	private WebElement USShippingCity;

	@FindBy(xpath = "//span[contains(@ng-model, 'shipping.country')]")
	private WebElement USShippingCountry;

	@FindBy(xpath = "//span[contains(@ng-model, 'payment.address.line_1')]")
	private WebElement USBillingAddress1;

	@FindBy(xpath = "//span[contains(@ng-model, 'payment.address.postal_code')]")
	private WebElement USBillingZip;

	@FindBy(xpath = "//span[contains(@ng-model, 'payment.address.city')]")
	private WebElement USBillingCity;

	@FindBy(xpath = "//span[contains(@ng-model, 'payment.address.country')]")
	private WebElement USBillingCountry;

	@FindBy(xpath = "//span[contains(@ng-model, 'profile.address.line_1')]")
	private WebElement ProfileBillingAddress1;

	@FindBy(xpath = "//span[contains(@ng-model, 'profile.address.line_2')]")
	private WebElement ProfileBillingAddress2;

	@FindBy(xpath = "//li[contains(@ng-if, 'address.postal_code')]/span[2]")
	private WebElement ProfileBillingZip;

	@FindBy(xpath = "//li[contains(@ng-if, 'profile.address.city')]/span[2]")
	private WebElement ProfileBillingCity;

	@FindBy(xpath = "//li[contains(@ng-if, 'selectedCountry')]/span[2]")
	private WebElement ProfileBillingCountry;

	@FindBy(id = "order.signature")
	private WebElement Signature;

	@FindBy(id = "disclaimar")
	private WebElement Disclaimar;

	@FindBy(id = "privacy")
	private WebElement PersonalData;

	@FindBy(id = "NRFDownload")
	private WebElement NFR;

	@FindBy(xpath = "//h2[@class='summary-header pull-left ng-scope']")
	private WebElement Click;

	@FindBy(xpath = "(//ul[@class='summary-total colombia_sum_section']//li[contains(@class,'ng')])[3]")
	private WebElement TotalPrice;

	@FindBy(xpath = "(//ul[@class='summary-total colombia_sum_section']//li[3])[1]")
	private WebElement PCTotalPrice;

	@FindBy(xpath = "(//div[contains(@class,'col-xs-5 text-right')])[1]")
	private WebElement ShippingPrice;

	@FindBy(xpath = "(//div[contains(@class,'col-xs-5 text-right')])[2]")
	private WebElement Tax;

	@FindBy(xpath = "(//div[contains(@class,'col-xs-5 text-right')])[3]")
	private WebElement Discount;

	@FindBy(xpath = "(//div[contains(@class,'col-xs-5 text-right')])[4]")
	private WebElement GrandTotal;

	@FindBy(xpath = "(//ul[@class='summary-total row']//li[3])[1]")
	private WebElement PCARTotalPrice;

	@FindBy(xpath = "(//ul[@class='summary-total row']//li[contains(@class,'ng')])[3]")
	private WebElement ARTotalPrice;

	@FindBy(xpath = "(//ul[@class='order-items']//div//div[2])[6]")
	private WebElement ARShippingPrice;

	@FindBy(xpath = "(//ul[@class='order-items']//div//div[2])[7]")
	private WebElement ARTax;

	@FindBy(xpath = "(//ul[@class='order-items']//div//div[2])[8]")
	private WebElement ARDiscount;

	@FindBy(xpath = "(//ul[@class='order-items']//div//div[2])[9]")
	private WebElement ARGrandTotal;

	@FindBy(xpath = "(//ul[@class='order-items']//div//div[2])[5]")
	private WebElement PCARShippingPrice;

	@FindBy(xpath = "(//ul[@class='order-items']//div//div[2])[6]")
	private WebElement PCARTax;

	@FindBy(xpath = "(//ul[@class='order-items']//div//div[2])[7]")
	private WebElement PCARDiscount;

	@FindBy(xpath = "(//ul[@class='order-items']//div//div[2])[8]")
	private WebElement PCARGrandTotal;

	@FindBy(xpath = "//button[contains(@class, 'continue-btn')]")
	private WebElement Continue;

	@FindBys(@FindBy(xpath = "//ul[@class='group-wrapper table-list']//li//span[2]"))
	List<WebElement> Summary;

	@FindBy(xpath = "(//p[@ng-if='bean.order_number']//strong)[2]")
	private WebElement OrderNumber;

	@FindBy(xpath = "(//strong[contains(@class,'text-info ng-binding')])[1]")
	private WebElement ITOrderNumber;

	@FindBy(xpath = "(//p[@ng-if='bean.order_number']//strong)")
	private WebElement MXOrderNumber;

	@FindBy(xpath = "(//p[3]//strong)[2]")
	private WebElement AccountNumber;

	@FindBy(xpath = "//p[3]//strong")
	private WebElement ITAccountNumber;

	@FindBy(xpath = "(//p[2]//strong)[2]")
	private WebElement NONopackAccountNumber;

	@FindBy(xpath = "(//strong[contains(@class,'text-info ng-binding')])[2]")
	private WebElement ARNumber;

	@FindBy(xpath = "//a[contains(.,'haga clic aquí')]")
	private WebElement MexicoBankPaymentLink;

	@FindBys(@FindBy(xpath = "//select[@ng-model='selectedCountry']//option"))
	List<WebElement> Country;

	@FindBy(xpath = "//h4[@class='ng-scope']")
	private WebElement StartCertification;

	@FindBy(xpath = "//h3[@class='ng-scope']")
	private WebElement Congratulations;

	@FindBy(xpath = "//label[@class='bold ng-scope']")
	private WebElement RegisteredAsCoach;

	@FindBy(xpath = "//label[@class='confimation-resgister_getfit ng-scope']")
	private WebElement GetFitSucessMSG1;

	@FindBy(xpath = "//label[contains(@class,'confirm_color ng-scope')]")
	private WebElement GetFitSucesMSG2;

	@FindBy(xpath = "//span[@ng-model='order.profile.firstname']")
	private WebElement GetFitFName;

	@FindBy(xpath = "//span[@ng-model='order.profile.lastname']")
	private WebElement GetFitLName;

	@FindBy(xpath = "//span[@ng-model='order.profile.email']")
	private WebElement GetFitEmail;

	@FindBy(xpath = "//span[@ng-model='order.payment.address.line_1']")
	private WebElement GetFitAddress1;

	@FindBy(xpath = "//span[@ng-model='order.payment.address.line_2']")
	private WebElement GetFitAddress2;

	@FindBy(xpath = "//span[@ng-model='order.payment.city']")
	private WebElement GetFitCity;

	@FindBy(xpath = "//span[@ng-model='order.payment.postal_code']")
	private WebElement GetFitPostal;

	@FindBy(xpath = "//button[contains(@ng-click,'goredirect()')]")
	private WebElement SignInToCourseNow;

	public SummaryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void OrderSubmit(String Market, String language, String pack)
			throws JsonGenerationException, JsonMappingException, IOException, InterruptedException, JSONException {

		String sign = "TestSignature";

		Thread.sleep(10000);

		childtest.log(LogStatus.INFO, "Summary", "");

		ArrayList<String> Labels = new ArrayList<String>();

		for (int i = 0; i < Headings.size(); i++) {
			Labels.add(Headings.get(i).getText());
		}

		if (Market == "Bahamas" || Market == "Canada" || Market == "Dominican Republic" || Market == "Jamaica"
				|| Market == "United States" || Market == "Mexico") {
			Assert.assertEquals(Labels.toString(), getTranslation("summary_us", language),
					"Minor Summary Labels is Displaying");
		}

		if (Market == "Colombia") {
			Assert.assertEquals(Labels.toString(), getTranslation("summary_co", language),
					"Minor Summary Labels is Displaying");
		}

		if (Market == "Puerto Rico") {
			Assert.assertEquals(Labels.toString(), getTranslation("summary_pr", language),
					"Minor Summary Labels is Displaying");
		}

		if (Market == "Australia" || Market == "Austria" || Market == "France" || Market == "Hungary"
				|| Market == "Netherlands" || Market == "New Zealand" || Market == "Ukraine" || Market == "Poland") {
			Assert.assertEquals(Labels.toString(), getTranslation("summary_eu", language),
					"Minor Summary Labels is Displaying");
		}

		if (Market == "Norway") {
			if (pack == "NoPack") {
				Assert.assertEquals(Labels.toString(), getTranslation("summary_no_nopack", language),
						"Minor Summary Labels is Displaying");
			} else {
				Assert.assertEquals(Labels.toString(), getTranslation("summary_no", language),
						"Minor Summary Labels is Displaying");
			}
		}

		if (Market == "Belgium") {
			Assert.assertEquals(Labels.toString(), getTranslation("summary_eu_a", language),
					"Minor Summary Labels is Displaying");
		}

		if (Market == "Denmark" || Market == "Ireland" || Market == "Luxembourg" || Market == "Sweden"
				|| Market == "Spain") {
			Assert.assertEquals(Labels.toString(), getTranslation("summary_dn", language),
					"Minor Summary Labels is Displaying");
		}
		if (Market == "Switzerland") {
			Assert.assertEquals(Labels.toString(), getTranslation("summary_ch", language),
					"Minor Summary Labels is Displaying");
		}
		if (Market == "Germany") {
			Assert.assertEquals(Labels.toString(), getTranslation("summary_de", language),
					"Minor Summary Labels is Displaying");
		}
		if (Market == "India") {
			Assert.assertEquals(Labels.toString(), getTranslation("summary_in", language),
					"Minor Summary Labels is Displaying");
		}
		if (Market == "Italy") {
			Assert.assertEquals(Labels.toString(), getTranslation("summary_it", language),
					"Minor Summary Labels is Displaying");
		}

		Assert.assertEquals(market.getText(), getTranslation(userdata.get("marketcode"), language),
				"Major Market is Displaying");
		Assert.assertEquals(Lan.getText(), language, "Langauge is Displaying");

		if (EnrollerSponsor.size() == 2) {
			Assert.assertEquals(Enroller.getText(), userdata.get("enroller"), "Major Enroller is Displaying");
			Assert.assertEquals(Sponsor.getText(), userdata.get("sponsor"), "Major Sponsor is Displaying");
		}

		if (EnrollerSponsor.size() == 0) {
			Assert.assertEquals(Enroller.getText(), userdata.get("enrollerName"), "Major Enroller is Displaying");
			Assert.assertEquals(Sponsor.getText(), userdata.get("sponsorName"), "Major Sponsor is Displaying");
		}

		Assert.assertEquals(Fname.getText(), userdata.get("fname"), "Major Summary FName");
		Assert.assertEquals(Lname.getText(), userdata.get("lname"), "Major Summary LName");
		Assert.assertEquals(DOB.getText(), userdata.get("dob"), "Major Summary DOB");
		Assert.assertEquals(Gender.getText(), userdata.get("genderoption"), "Major Summary Gender");
		if (!(Market == "Austria" || Market == "Belgium" || Market == "Denmark" || Market == "France"
				|| Market == "Germany" || Market == "Hungary" || Market == "Italy" || Market == "Ireland"
				|| Market == "Luxembourg" || Market == "Netherlands" || Market == "Norway" || Market == "Poland"
				|| Market == "Sweden" || Market == "Switzerland" || Market == "Spain" || Market == "Ukraine"
				|| Market == "United Kingdom")) {
			Assert.assertEquals(Martial.getText(), userdata.get("maritaloption"), "Major Summary Marital");
		}

		if (!(Market == "Austria" || Market == "Belgium" || Market == "Canada" || Market == "Denmark"
				|| Market == "France" || Market == "Germany" || Market == "Hungary" || Market == "Italy"
				|| Market == "Ireland" || Market == "Luxembourg" || Market == "Mexico" || Market == "Netherlands"
				|| Market == "Norway" || Market == "Poland" || Market == "Sweden" || Market == "Switzerland"
				|| Market == "Spain" || Market == "Ukraine" || Market == "United Kingdom")) {
			Assert.assertEquals(GovID.getText(), userdata.get("govid"), "Major Summary GovID");
		}

		if (Market == "Mexico") {
			Assert.assertEquals(GovID.getText(), userdata.get("documentid"), "Summary CURP");
			Assert.assertEquals(RFC.getText(), userdata.get("govid"), "Major Summary RFC");
		}

		if (Market == "Austria" || Market == "Belgium" || Market == "Denmark" || Market == "France"
				|| Market == "Germany" || Market == "Hungary" || Market == "Italy" || Market == "Ireland"
				|| Market == "Luxembourg" || Market == "Netherlands" || Market == "Norway" || Market == "Poland"
				|| Market == "Sweden" || Market == "Switzerland" || Market == "Spain" || Market == "Ukraine"
				|| Market == "United Kingdom") {
			Assert.assertEquals(Fax.getText(), userdata.get("fax"), "Major Summary Fax");
		}

		if (Market == "India") {
			Assert.assertEquals(INDPhone.getText(), userdata.get("phone"), "Major Summary Phone");
		}
		if (!(Market == "India" || Market == "Switzerland")) {
			Assert.assertEquals(Phone.getText(), userdata.get("phone"), "Major Summary Phone");
		}
		if (Market == "Switzerland") {
			Assert.assertEquals(Mobile.getText(), userdata.get("phone"), "Major Summary Phone");
		}
		Assert.assertEquals(Email.getText(), userdata.get("email"), "Major Summary Email");
		if (!(Market == "India" || pack == "NoPack")) {
			if (Market == "Austria" || Market == "Germany") {
				if (userdata.get("payment") == "sepa") {
					Assert.assertEquals(SEPAIBAN.getText(), userdata.get("sepaiban"), "Major Summary sepa iban");
					Assert.assertEquals(SEPABANKNAME.getText(), userdata.get("sepabankname"),
							"Major Summary sepa bankname");
					Assert.assertEquals(SEPAACCOUNT.getText(), userdata.get("sepaholder"),
							"Major Summary sepa account holder");
					Assert.assertEquals(SEPABIC.getText(), userdata.get("sepabic"), "Major Summary sepa bic");
				} else {
					Assert.assertEquals(CCName.getText(), userdata.get("ccname"), "Major Summary CCName");
				}
			} else {
				Assert.assertEquals(CCName.getText(), userdata.get("ccname"), "Major Summary CCName");
			}
		}
		if (Market == "United States" || Market == "Canada") {
			Assert.assertEquals(TermsandConditonsPDF.size(), 4, "Major Terms & Condition PDF's");
			childtest.log(LogStatus.INFO, "Terms and Condtions PDF", Integer.toString(TermsandConditonsPDF.size()));
		}

		if (!(Market == "Norway" || Market == "Italy")) {
			if (userdata.get("coapplicanttype") == "Spouse") {
				Assert.assertEquals(Coapplicant.getText(), userdata.get("coapplicant"), "Major Summary CoApplicant");
			} else {
				Assert.assertEquals(CompanyName.getText(), userdata.get("coapplicant"), "Major Summary Company Name");
				Assert.assertEquals(CompanyType.getText(), userdata.get("companynametype"),
						"Major Summary Company Type");
			}
		}

		if (userdata.get("commission") == "DD") {
			Assert.assertEquals(IBAN.getText(), userdata.get("iban"), "Major IBAN");
			Assert.assertEquals(AccountTitle.getText(), userdata.get("holder"), "Major Account Holder");
			Assert.assertEquals(BankName.getText(), userdata.get("bankname"), "Major Bank Name");
			Assert.assertEquals(BIC.getText(), userdata.get("bic"), "Major BIC");
		}

		if (pack == "Pack") {
			if (Market == "Australia" || Market == "Austria" || Market == "Belgium" || Market == "Denmark"
					|| Market == "France" || Market == "Germany" || Market == "Hungary" || Market == "Italy"
					|| Market == "Ireland" || Market == "Luxembourg" || Market == "Netherlands" || Market == "Norway"
					|| Market == "Poland" || Market == "Sweden" || Market == "Switzerland" || Market == "Spain"
					|| Market == "Ukraine" || Market == "United Kingdom") {
				Assert.assertEquals(ShippingAddress1.getText(), userdata.get("address1"), "Major Shipping Address1");
				Assert.assertEquals(ShippingAddress2.getText(), userdata.get("address2"), "Major Shipping Address 2");
				Assert.assertEquals(ShippingCity.getText(), userdata.get("city"), "Major Shipping City");
				Assert.assertEquals(ShippingZip.getText(), userdata.get("zip"), "Major Shipping Postal");
				Assert.assertEquals(ShippingCountry.getText(), getTranslation(userdata.get("marketcode"), language),
						"Shipping country");

				Assert.assertEquals(BillingAddress1.getText(), userdata.get("address1"), "Major Billing Address1");
				Assert.assertEquals(BillingAddress2.getText(), userdata.get("address2"), "Major Billing Address 2");
				Assert.assertEquals(BillingCity.getText(), userdata.get("city"), "Major Billing City");
				Assert.assertEquals(BillingZip.getText(), userdata.get("zip"), "Major Billing Postal");
				Assert.assertEquals(BillingCountry.getText(), getTranslation(userdata.get("marketcode"), language),
						"Major Shipping Billing");
			}

			if (Market == "Colombia") {
				Assert.assertEquals(BillingAddress1.getText(), userdata.get("address1"), "Major Billing Address1");
				Assert.assertEquals(BillingAddress2.getText(), userdata.get("address2"), "Major Billing Address 2");
				Assert.assertEquals(BillingCity.getText(), userdata.get("city"), "Major Billing City");
				Assert.assertEquals(USBillingCountry.getText(), getTranslation(userdata.get("marketcode"), language),
						"Major Shipping Billing");
			}
		}
		if (Market == "Puerto Rico") {
			Assert.assertEquals(USShippingAddress1.getText(), userdata.get("address1"), "Major Shipping Address1");
			Assert.assertEquals(USShippingZip.getText(), userdata.get("zip"), "Major Shipping Postal");
			Assert.assertEquals(USShippingCity.getText(), userdata.get("city"), "Major Shipping City");
			Assert.assertEquals(USShippingCountry.getText(), getTranslation(userdata.get("marketcode"), language),
					"Major Shipping Country");

			Assert.assertEquals(USBillingAddress1.getText(), userdata.get("address1"), "Major Billing Address1");
			Assert.assertEquals(USBillingZip.getText(), userdata.get("zip"), "Major Billing Postal");
			Assert.assertEquals(USBillingCity.getText(), userdata.get("city"), "Major Billing City");
			if (language == "English") {
				Assert.assertEquals(USBillingCountry.getText(), "United States", "Major Billing Country");
			} else {
				Assert.assertEquals(USBillingCountry.getText(), "Estados Unidos", "Major Billing Country");
			}
		}

		if (Market == "United States") {
			Assert.assertEquals(USShippingAddress1.getText(), userdata.get("address1"), "Major Shipping Address1");
			Assert.assertEquals(USShippingZip.getText(), userdata.get("zip"), "Major Shipping Postal");
			Assert.assertEquals(USShippingCity.getText(), userdata.get("city"), "Major Shipping City");
			Assert.assertEquals(USShippingCountry.getText(), getTranslation(userdata.get("marketcode"), language),
					"Major Shipping Country");

			Assert.assertEquals(USBillingAddress1.getText(), userdata.get("address1"), "Major Billing Address1");
			Assert.assertEquals(USBillingZip.getText(), userdata.get("zip"), "Major Billing Postal");
			Assert.assertEquals(USBillingCity.getText(), userdata.get("city"), "Major Billing City");
			Assert.assertEquals(USBillingCountry.getText(), "United States", "Major Billing Country");
		}

		if (Market == "Canada") {
			Assert.assertEquals(USShippingAddress1.getText(), userdata.get("address1"), "Major Shipping Address1");
			Assert.assertEquals(USShippingZip.getText(), userdata.get("zip"), "Major Shipping Postal");
			Assert.assertEquals(USShippingCity.getText(), userdata.get("city"), "Major Shipping City");
			Assert.assertEquals(USShippingCountry.getText(), getTranslation(userdata.get("marketcode"), language),
					"Major Shipping Country");

			Assert.assertEquals(USBillingAddress1.getText(), userdata.get("address1"), "Major Billing Address1");
			Assert.assertEquals(USBillingZip.getText(), userdata.get("zip"), "Major Billing Postal");
			Assert.assertEquals(USBillingCity.getText(), userdata.get("city"), "Major Billing City");
			Assert.assertEquals(USBillingCountry.getText(), "Canada", "Major Billing Country");
		}

		if (Market == "Bahamas" || Market == "Jamaica") {
			Assert.assertEquals(USShippingAddress1.getText(), userdata.get("address1"), "Major Shipping Address1");
			Assert.assertEquals(USShippingZip.getText(), userdata.get("zip"), "Major Shipping Postal");
			Assert.assertEquals(USShippingCity.getText(), userdata.get("city"), "Major Shipping City");
			Assert.assertEquals(USShippingCountry.getText(), getTranslation("US", language), "Major Shipping Country");

			Assert.assertEquals(USBillingAddress1.getText(), "Address 1", "Major Billing Address1");
			Assert.assertEquals(USBillingCity.getText(), "TestCity", "Major Billing City");
			if (Market == "Bahamas") {
				Assert.assertEquals(USBillingCountry.getText(), getTranslation(userdata.get("marketcode"), language),
						"Major Billing Country");
			} else {
				Assert.assertEquals(USBillingCountry.getText(), getTranslation(userdata.get("marketcode"), language),
						"Major Billing Country");
			}
		}
		if (Market == "Dominican Republic") {
			Assert.assertEquals(USShippingAddress1.getText(), userdata.get("address1"), "Major Shipping Address1");
			Assert.assertEquals(USShippingZip.getText(), userdata.get("zip"), "Major Shipping Postal");
			Assert.assertEquals(USShippingCity.getText(), userdata.get("city"), "Major Shipping City");
			Assert.assertEquals(USShippingCountry.getText(), "United States", "Major Shipping Country");

			Assert.assertEquals(USBillingAddress1.getText(), "Address 1", "Major Billing Address1");
			Assert.assertEquals(USBillingCity.getText(), "TestCity", "Major Billing City");
			Assert.assertEquals(USBillingCountry.getText(), "Dominican Republic", "Major Billing Country");
		}

		if (Market == "Mexico") {
			Assert.assertEquals(USShippingAddress1.getText(), userdata.get("address1"), "Major Shipping Address1");
			Assert.assertEquals(USShippingZip.getText(), userdata.get("zip"), "Major Shipping Postal");
			Assert.assertEquals(USShippingCity.getText(), userdata.get("city"), "Major Shipping City");
			Assert.assertEquals(USShippingCountry.getText(), getTranslation(userdata.get("marketcode"), language),
					"Major Shipping Country");

			Assert.assertEquals(USBillingAddress1.getText(), userdata.get("address1"), "Major Billing Address1");
			Assert.assertEquals(USBillingZip.getText(), userdata.get("zip"), "Major Billing Postal");
			Assert.assertEquals(USBillingCity.getText(), userdata.get("city"), "Major Billing City");
			Assert.assertEquals(USBillingCountry.getText(), "Mexico", "Major Billing Country");
		}

		if (Market == "India") {
			Assert.assertEquals(BillingAddress1.getText(), userdata.get("address1"), "Major Billing Address1");
			Assert.assertEquals(BillingAddress2.getText(), userdata.get("address2"), "Major Billing Address 2");
			Assert.assertEquals(USBillingCity.getText(), userdata.get("city"), "Major Billing City");
			Assert.assertEquals(USBillingZip.getText(), userdata.get("zip"), "Major Billing Postal");
			Assert.assertEquals(State.getText(), "KA", "Major Shipping Billing");
		}

		if (pack == "NoPack") {
			if (Market == "Norway") {
				Assert.assertEquals(ProfileBillingAddress1.getText(), userdata.get("address1"),
						"Major Billing Address1");
				Assert.assertEquals(ProfileBillingAddress2.getText(), userdata.get("address2"),
						"Major Billing Address 2");
				Assert.assertEquals(ProfileBillingCity.getText(), userdata.get("city"), "Major Billing City");
				Assert.assertEquals(ProfileBillingZip.getText(), userdata.get("zip"), "Major Billing Postal");
				Assert.assertEquals(ProfileBillingCountry.getText(), userdata.get("market"), "Major Billing Country");
			}
		}

		if (!(Market == "India")) {
			Signature.sendKeys(sign);
			userdata.put("signature", sign);
		} else {
			Signature.sendKeys(userdata.get("fname"));
			userdata.put("signature", userdata.get("fname"));
		}

		if (pack == "Pack") {
			if (Market == "Dominican Republic") {
				Click.click();
				float total = (Float.parseFloat(TotalPrice.getText().replaceAll("[^\\d.]+", "").trim()));
				float shipprice = (Float.parseFloat(ShippingPrice.getText().replaceAll("[^\\d.]+", "").trim()));
				float tax = (Float.parseFloat(Tax.getText().replaceAll("[^\\d.]+", "").trim()));
				float discount = (Float.parseFloat(Discount.getText().replaceAll("[^\\d.]+", "").trim()));
				float grandtotal = (Float.parseFloat(GrandTotal.getText().replaceAll("[^\\d.]+", "").trim()));
				float result = total + shipprice + tax - discount;

				DecimalFormat df2 = new DecimalFormat("#.##");
				Float result1 = Float.valueOf(df2.format(result));

				Assert.assertEquals(grandtotal, result1, "Major Total Price is Wrong");
			}

			if (Market == "Australia" || Market == "New Zealand" || Market == "Colombia") {
				Click.click();
				float total = (Float.parseFloat(TotalPrice.getText().replaceAll("[^\\d.]+", "").trim()));
				float shipprice = (Float.parseFloat(ShippingPrice.getText().replaceAll("[^\\d.]+", "").trim()));
				float discount = (Float.parseFloat(Discount.getText().replaceAll("[^\\d.]+", "").trim()));
				float grandtotal = (Float.parseFloat(GrandTotal.getText().replaceAll("[^\\d.]+", "").trim()));
				float result = total + shipprice - discount;
				Assert.assertEquals(grandtotal, result, "Major Total Price is Wrong");
			} else {
				if (!(Market == "India")) {
					Click.click();
					float total = (Float.parseFloat(TotalPrice.getText().replaceAll("[^\\d.]+", "").trim()));
					float shipprice = (Float.parseFloat(ShippingPrice.getText().replaceAll("[^\\d.]+", "").trim()));
					float tax = (Float.parseFloat(Tax.getText().replaceAll("[^\\d.]+", "").trim()));
					float discount = (Float.parseFloat(Discount.getText().replaceAll("[^\\d.]+", "").trim()));
					float grandtotal = (Float.parseFloat(GrandTotal.getText().replaceAll("[^\\d.]+", "").trim()));
					float result = total + shipprice + tax - discount;
					DecimalFormat df2 = new DecimalFormat("#.##");
					Float result1 = Float.valueOf(df2.format(result));
					Assert.assertEquals(grandtotal, result1, "Major Total Price is Wrong");
				}
			}

			if (!(Market == "Australia" || Market == "New Zealand" || Market == "Colombia"
					|| Market == "Dominican Republic" || Market == "India" || Market == "Jamaica" || Market == "Mexico"
					|| Market == "Ukraine")) {
				Click.click();
				float ARTotal = (Float.parseFloat(ARTotalPrice.getText().replaceAll("[^\\d.]+", "").trim()));
				float ARShipprice = (Float.parseFloat(ARShippingPrice.getText().replaceAll("[^\\d.]+", "").trim()));
				float ARtax = (Float.parseFloat(ARTax.getText().replaceAll("[^\\d.]+", "").trim()));
				float ARdiscount = (Float.parseFloat(ARDiscount.getText().replaceAll("[^\\d.]+", "").trim()));
				float ARgrandTotal = (Float.parseFloat(ARGrandTotal.getText().replaceAll("[^\\d.]+", "").trim()));
				float ARresult = ARTotal + ARShipprice + ARtax - ARdiscount;
				DecimalFormat df2 = new DecimalFormat("#.##");
				Float result1 = Float.valueOf(df2.format(ARresult));
				Assert.assertEquals(ARgrandTotal, result1, "Major AR Total Price is Wrong");
			}

		}

		Disclaimar.click();
		if (Market == "Australia" || Market == "Austria" || Market == "Belgium" || Market == "Denmark"
				|| Market == "France" || Market == "Germany" || Market == "Hungary" || Market == "Italy"
				|| Market == "Ireland" || Market == "Luxembourg" || Market == "Netherlands" || Market == "New Zealand"
				|| Market == "Norway" || Market == "Sweden" || Market == "Switzerland" || Market == "Spain"
				|| Market == "Ukraine" || Market == "Poland" || Market == "United Kingdom") {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,250)", "");
			PersonalData.click();
		}
		if (Market == "Bahamas" || Market == "Dominican Republic" || Market == "Jamaica") {
			NFR.click();
			NFR.sendKeys(Keys.CONTROL, Keys.TAB);
		}
		Continue.click();
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@src='assets/img/spinner.gif']")));
		System.out.println(userdata);

		List<HarEntry> entries = server.getHar().getLog().getEntries();
		for (HarEntry entry : entries) {

			if (entry.getRequest().getMethod().equals("POST")) {

				if (entry.getRequest().getUrl().contains("orders.js")) {

					if (entry.getRequest().getUrl().contains(userdata.get("version"))) {
						System.out.println("Request URL: " + entry.getRequest().getUrl());
						System.out.println("Entry request : " + entry.getRequest().getPostData().getText());
						System.out.println("Entry response : " + entry.getResponse().getContent().getText());

						System.out.println("Headers-->" + entry.getRequest().getHeaders().get(1).getValue());
						System.out.println("Headers-->" + entry.getRequest().getHeaders().get(2).getValue());
						System.out.println("Headers-->" + entry.getRequest().getHeaders().get(3).getValue());
						System.out.println("Headers-->" + entry.getRequest().getHeaders().get(4).getValue());
						System.out.println("Headers-->" + entry.getRequest().getHeaders().get(5).getValue());

						Assert.assertEquals(userdata.get("locale") + "-" + userdata.get("marketcode"),
								entry.getRequest().getHeaders().get(5).getValue());

						JSONObject Orders = new JSONObject(entry.getRequest().getPostData().getText().toString()
								.substring(entry.getRequest().getPostData().getText().toString().indexOf("{")).trim());

						childtest.log(LogStatus.INFO, "Request Parameter", "");

						if (!(Market == "Australia" || Market == "New Zealand" || Market == "Colombia"
								|| Market == "Dominican Republic" || Market == "India" || Market == "Jamaica"
								|| Market == "Mexico" || Market == "Ukraine")) {

							Assert.assertEquals(
									new JsonPath(Orders.toString())
											.get("customer.autoorders.items.lines.items.item.href").toString()
											.replace("[", "").replace("]", ""),
									"https://hydraqa.unicity.net/" + userdata.get("version") + "items?id.unicity="
											+ userdata.get("aritemcode"),
									"Major AR Pack href");

							Assert.assertEquals(
									new JsonPath(Orders.toString()).get("customer.autoorders.items.shippingMethod.href")
											.toString().replace("[", "").replace("]", ""),
									"https://hydraqa.unicity.net/" + userdata.get("version") + "shippingmethods?"
											+ userdata.get("shippingmethod"),
									"Major AR Ship Method href");

							if (Market == "Bahamas" || Market == "Puerto Rico") {
								Assert.assertEquals(
										new JsonPath(Orders.toString())
												.get("customer.autoorders.items.shipToAddress.country").toString()
												.replace("[", "").replace("]", ""),
										"US", "Major AR Market Code");
							} else {
								Assert.assertEquals(
										new JsonPath(Orders.toString())
												.get("customer.autoorders.items.shipToAddress.country").toString()
												.replace("[", "").replace("]", ""),
										userdata.get("marketcode"), "Major AR Market Code");
							}
							Assert.assertEquals(
									new JsonPath(Orders.toString()).get("customer.autoorders.items.shipToAddress.zip")
											.toString().replace("[", "").replace("]", ""),
									userdata.get("zip"), "Major AR Zip Code");
							Assert.assertEquals(
									new JsonPath(Orders.toString())
											.get("customer.autoorders.items.shipToAddress.address1").toString()
											.replace("[", "").replace("]", ""),
									userdata.get("address1"), "Major AR Address1");
							Assert.assertEquals(
									new JsonPath(Orders.toString()).get("customer.autoorders.items.shipToAddress.city")
											.toString().replace("[", "").replace("]", ""),
									userdata.get("city"), "Major AR City");

							Assert.assertEquals(
									new JsonPath(Orders.toString()).get("customer.autoorders.items.shipToEmail")
											.toString().replace("[", "").replace("]", ""),
									userdata.get("email"), "Major AR Email");
							Assert.assertEquals(
									new JsonPath(Orders.toString())
											.get("customer.autoorders.items.shipToName.firstName").toString()
											.replace("[", "").replace("]", ""),
									userdata.get("fname"), "Major AR FirstName");
							Assert.assertEquals(
									new JsonPath(Orders.toString()).get("customer.autoorders.items.shipToName.lastName")
											.toString().replace("[", "").replace("]", ""),
									userdata.get("lname"), "Major AR LastName");
							Assert.assertEquals(
									new JsonPath(Orders.toString()).get("customer.autoorders.items.shipToPhone")
											.toString().replace("[", "").replace("]", ""),
									userdata.get("phone"), "Major AR Phone");
						}

						if (Market == "Bahamas" || Market == "Dominican Republic" || Market == "Jamaica"
								|| Market == "Puerto Rico") {
							Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.mainAddress.country"),
									"US", "Major Market Code");
						} else {
							Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.mainAddress.country"),
									userdata.get("marketcode"), "Major Market Code");
						}
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.mainAddress.zip"),
								userdata.get("zip"), "Major zip code");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.mainAddress.address1"),
								userdata.get("address1"), "Major Address");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.mainAddress.city"),
								userdata.get("city"), "Major City");
						// Assert.assertEquals(new
						// JsonPath(Orders.toString()).get("customer.mainAddress.state"),
						// "UT");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.humanName.firstName"),
								userdata.get("fname"), "Major FirstName");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.humanName.lastName"),
								userdata.get("lname"), "Major LastName");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.email"),
								userdata.get("email"), "Major Email");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.preferredLocale"),
								userdata.get("locale") + "-" + userdata.get("marketcode"), "Major Preferred-Locale");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.password.value"),
								userdata.get("password"), "Major Password");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.gender"),
								userdata.get("gender").toLowerCase(), "Major Gender");
						if (!(Market == "Austria" || Market == "Belgium" || Market == "Denmark" || Market == "France"
								|| Market == "Germany" || Market == "Hungary" || Market == "Italy"
								|| Market == "Ireland" || Market == "Luxembourg" || Market == "Mexico"
								|| Market == "Netherlands" || Market == "New Zealand" || Market == "Norway"
								|| Market == "Sweden" || Market == "Switzerland" || Market == "Spain"
								|| Market == "Ukraine")) {
							Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.maritalStatus"),
									userdata.get("martial"), "Major Martial Status");
						}
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.type"), userdata.get("type"),
								"Major Customer Type");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.sponsor.href"),
								"https://hydraqa.unicity.net/" + userdata.get("version") + "customers?id.unicity="
										+ userdata.get("sponsor"),
								"Major Sponsor href");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.enroller.href"),
								"https://hydraqa.unicity.net/" + userdata.get("version") + "customers?id.unicity="
										+ userdata.get("enroller"),
								"Major Enroller href");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.homePhone"),
								userdata.get("phone"), "Major Customer Phone");
						if (Market == "Switzerland") {
							Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.mobilePhone"),
									userdata.get("phone"), "Major Customer Mobile");
						}
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.birthDate"),
								userdata.get("responsedob"), "Major DOB");

						if (!(Market == "Norway" || Market == "Italy")) {
							if (userdata.get("coapplicant") == "TestSpouseName") {
								Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.coapplicant.type"),
										userdata.get("coapplicanttype"), "Major Co-App Type");
								Assert.assertEquals(
										new JsonPath(Orders.toString())
												.get("customer.coapplicant.details.humanName.firstName"),
										userdata.get("coapplicant"), "Major Co-App");
							} else {
								Assert.assertEquals(
										new JsonPath(Orders.toString()).get("customer.businessEntity.companyName"),
										userdata.get("coapplicant"), "Major Company Name");
								Assert.assertEquals(
										new JsonPath(Orders.toString()).get("customer.businessEntity.legalType"),
										"Corporation", "Major Legal Type");
							}
						}

						if (userdata.get("commission") == "DD") {
							Assert.assertEquals(
									new JsonPath(Orders.toString()).get("customer.depositBankAccount.accountHolder"),
									userdata.get("holder"), "Major Account Holder");
							Assert.assertEquals(
									new JsonPath(Orders.toString()).get("customer.depositBankAccount.bankName"),
									userdata.get("bankname"), "Major Bank name");
							Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.depositBankAccount.bic"),
									userdata.get("bic"), "Major BIC");
							Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.depositBankAccount.iban"),
									userdata.get("iban"), "Major IBAN");
						}

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.signature.value"),
								userdata.get("signature"), "Major Signature");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.taxTerms.taxId"),
								userdata.get("govid"), "Major GovID");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("lines.items.item.href"), packs,
								"Major Packs");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("lines.items.quantity").toString(),
								Quantity.toString(), "Major Quantity");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToName.firstName"),
								userdata.get("fname"), "Major Ship FirstName");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToName.lastName"),
								userdata.get("lname"), "Major Ship LastName");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToPhone"), userdata.get("phone"),
								"Major Ship Phone");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToEmail"), userdata.get("email"),
								"Major Ship Email");

						if (Market == "Bahamas" || Market == "Dominican Republic" || Market == "Jamaica"
								|| Market == "Puerto Rico") {
							Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToAddress.country"), "US",
									"Major Ship Country");
						} else {
							Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToAddress.country"),
									userdata.get("marketcode"), "Major Ship Country");
						}
						Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToAddress.zip"),
								userdata.get("zip"), "Major Ship zip");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToAddress.address1"),
								userdata.get("address1"), "Major Ship Address");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("shippingMethod.href"),
								"https://hydraqa.unicity.net/" + userdata.get("version") + "shippingmethods?"
										+ userdata.get("shippingmethod"),
								"Major Ship Method href");
						childtest.log(LogStatus.INFO, "", "<a href=" + entry.getRequest().getUrl() + ">Orders.js</a>");

						if (userdata.get("version").equals("v5a-test/")) {
							JSONObject OrdersResponse = new JSONObject(entry.getResponse().getContent().getText()
									.toString()
									.substring(entry.getResponse().getContent().getText().toString().indexOf("{"))
									.trim());

							childtest.log(LogStatus.INFO, "Response", "");

							if (Market == "Bahamas" || Market == "Dominican Republic" || Market == "Jamaica"
									|| Market == "Puerto Rico") {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.market"), "US",
										"Major Market");
							} else {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.market"),
										userdata.get("marketcode"), "Major Market");
							}

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.lines.items.item.id.unicity"),
									Itemcode, "Major Packs");
							if (Market == "Bahamas" || Market == "Dominican Republic" || Market == "Jamaica"
									|| Market == "Puerto Rico") {
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString()).get("data.shipToAddress.country"), "US",
										"Major Ship Country");
							} else {
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString()).get("data.shipToAddress.country"),
										userdata.get("marketcode"), "Major Ship Country");
							}
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.shipToAddress.zip"),
									userdata.get("zip"), "Major Ship zip");
							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.shipToAddress.address1"),
									userdata.get("address1"), "Major Ship Address");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.shipToName.firstName"),
									userdata.get("fname"), "Major Ship FirstName");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.shipToName.lastName"),
									userdata.get("lname"), "Major Ship LastName");

							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.shipToEmail"),
									userdata.get("email"), "Major Ship Email");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.shipToPhone"),
									userdata.get("phone"), "Major Ship Phone");

							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.shippingMethod.href"),
									"https://hydraqa.unicity.net/" + userdata.get("version") + "shippingmethods?"
											+ userdata.get("shippingmethod"),
									"Major Ship Method href");
							if (Market == "Puerto Rico") {
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString()).get("data.shippingMethod.type"),
										userdata.get("shippingmethod").split("=")[1].replace("&location", ""),
										"Major Response Ship Method");
							} else {
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString()).get("data.shippingMethod.type"),
										userdata.get("shippingmethod").split("=")[1], "Major Response Ship Method");
							}

							if (Market == "Canada") {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.currency"), "CAD",
										"Major Response Currency");
							}

							if (Market == "Mexico") {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.currency"), "MXN",
										"Major Response Currency");
							}

							if (Market == "United Kingdom") {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.currency"), "GBP",
										"Major Response Currency");
							}

							if (!(Market == "Canada" || Market == "Mexico" || Market == "United Kingdom")) {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.currency"),
										userdata.get("Currency"), "Major Response Currency");
							}

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.humanName.firstName"),
									userdata.get("fname"), "Major Customer FirstName");
							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.humanName.lastName"),
									userdata.get("lname"), "Major Customer LastName");

							if (Market == "Bahamas" || Market == "Dominican Republic" || Market == "Jamaica"
									|| Market == "Puerto Rico") {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString())
										.get("data.customer.mainAddress.country"), "US", "Major Customer Country");
							} else {
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.mainAddress.country"),
										userdata.get("marketcode"), "Major Customer Country");
							}
							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.mainAddress.zip"),
									userdata.get("zip"), "Major Customer Zip");
							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.mainAddress.address1"),
									userdata.get("address1"), "Major Customer address1");

							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.type"),
									userdata.get("type"), "Major Customer Type");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.email"),
									userdata.get("email"), "Major Customer Email");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.taxTerms.taxId"),
									userdata.get("govid"), "Major Customer GovID");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.signature.value"),
									userdata.get("signature"), "Major Customer signature");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.gender"),
									userdata.get("gender").toLowerCase(), "Major Customer Gender");
							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.password.value"),
									userdata.get("password"), "Major Customer Password");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString())
									.get("data.customer.enroller.id.unicity").toString(), userdata.get("enroller"),
									"Major Customer Enroller");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString())
									.get("data.customer.sponsor.id.unicity").toString(), userdata.get("sponsor"),
									"Major Customer Sponsor");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.birthDate"),
									userdata.get("responsedob"), "Major Customer DOB");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.homePhone"),
									userdata.get("phone"), "Major Customer Phone");
							if (Market == "Switzerland") {
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString()).get("data.customer.mobilePhone"),
										userdata.get("phone"), "Major Customer Mobile");
							}
							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.preferredLocale"),
									userdata.get("locale") + "-" + userdata.get("marketcode"),
									"Major Customer Prefered-Locale");
							if (userdata.get("commission") == "DD") {

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.depositBankAccount.accountHolder"),
										userdata.get("holder"), "Major Account Holder");
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.depositBankAccount.bankName"),
										userdata.get("bankname"), "Major Bank name");
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.depositBankAccount.bic"),
										userdata.get("bic"), "Major BIC");
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.depositBankAccount.iban"),
										userdata.get("iban"), "Major IBAN");
							}
							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.maritalStatus"),
									userdata.get("martial"), "Major Customer Martial");
							if (!(userdata.get("coapplicanttype") == "company")) {

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.coapplicant.details.humanName.firstName"),
										userdata.get("coapplicant"), "Major Customer Co-Applicant");

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString()).get("data.customer.coapplicant.type"),
										userdata.get("coapplicanttype"), "Major Customer Co-Applicant Type");

							} else {

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.businessEntity.companyName"),
										userdata.get("coapplicant"), "Major Customer Co-Applicant Type");
							}
							if (Market == "Mexico") {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.status"),
										"Pending", "Major Customer Status");
							} else {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.status"),
										"Active", "Major Customer Status");
							}

							if (!(Market == "Australia" || Market == "New Zealand" || Market == "Colombia"
									|| Market == "Dominican Republic" || Market == "India" || Market == "Jamaica"
									|| Market == "Mexico" || Market == "Ukraine")) {

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.autoorders.items.lines.items.item.href").toString()
												.replace("[", "").replace("]", ""),
										"https://hydraqa.unicity.net/" + userdata.get("version") + "items?id.unicity="
												+ userdata.get("aritemcode"),
										"Major AR Pack href");

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.autoorders.items.shipToName.firstName").toString()
												.replace("[", "").replace("]", ""),
										userdata.get("fname"), "Major AR First name");

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.autoorders.items.shipToName.lastName").toString()
												.replace("[", "").replace("]", ""),
										userdata.get("lname"), "Major AR Last name");

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.autoorders.items.shipToPhone").toString()
												.replace("[", "").replace("]", ""),
										userdata.get("phone"), "Major AR Phone");

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.autoorders.items.shipToEmail").toString()
												.replace("[", "").replace("]", ""),
										userdata.get("email"), "Major AR Email");

								if (Market == "Bahamas" || Market == "Puerto Rico") {
									Assert.assertEquals(
											new JsonPath(OrdersResponse.toString())
													.get("data.customer.autoorders.items.shipToAddress.country")
													.toString().replace("[", "").replace("]", ""),
											"US", "Major AR Country");
								} else {
									Assert.assertEquals(
											new JsonPath(OrdersResponse.toString())
													.get("data.customer.autoorders.items.shipToAddress.country")
													.toString().replace("[", "").replace("]", ""),
											userdata.get("marketcode"), "Major AR Country");
								}

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.autoorders.items.shipToAddress.zip").toString()
												.replace("[", "").replace("]", ""),
										userdata.get("zip"), "Major AR Zip");

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.autoorders.items.shipToAddress.address1").toString()
												.replace("[", "").replace("]", ""),
										userdata.get("address1"), "Major AR Address1");

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.autoorders.items.shippingMethod.href").toString()
												.replace("[", "").replace("]", ""),
										"https://hydraqa.unicity.net/" + userdata.get("version") + "shippingmethods?"
												+ userdata.get("shippingmethod"),
										"Major AR Ship Method href");

							}

							if (Market == "Italy") {
								if (language == "Italiano") {
									Assert.assertEquals(
											new JsonPath(OrdersResponse.toString()).get("data.customer.id.unicity"),
											ITAccountNumber.getText(), "Major Customer Account Number");
									Assert.assertTrue(new JsonPath(OrdersResponse.toString())
											.get("data.customer.id.unicity").toString().length() != 0,
											"Major Customer Account Number");
									childtest.log(LogStatus.INFO, "Account Number", ITAccountNumber.getText());
								} else {
									Assert.assertEquals(
											new JsonPath(OrdersResponse.toString()).get("data.customer.id.unicity"),
											AccountNumber.getText(), "Major Customer Account Number");
									Assert.assertTrue(new JsonPath(OrdersResponse.toString())
											.get("data.customer.id.unicity").toString().length() != 0,
											"Major Customer Account Number");
									childtest.log(LogStatus.INFO, "Account Number", AccountNumber.getText());
								}
							} else {
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString()).get("data.customer.id.unicity"),
										AccountNumber.getText(), "Major Customer Account Number");
								Assert.assertTrue(new JsonPath(OrdersResponse.toString())
										.get("data.customer.id.unicity").toString().length() != 0,
										"Major Customer Account Number");
								childtest.log(LogStatus.INFO, "Account Number", AccountNumber.getText());
							}

							if (Market == "Mexico") {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.id.unicity"),
										MXOrderNumber.getText(), "Major Customer Order Number");
								Assert.assertTrue(new JsonPath(OrdersResponse.toString()).get("data.id.unicity")
										.toString().length() != 0, "Major Customer Order Number");
								childtest.log(LogStatus.INFO, "Account Number", MXOrderNumber.getText());

								if (userdata.get("paymenttype") == "bank") {
									try {
										Boolean paymentlink = MexicoBankPaymentLink.isDisplayed();
										Assert.assertTrue(paymentlink);
									} catch (Exception e) {
										Assert.fail("Major paymentlink is not displaying");
									}
								}
							}
							if (Market == "Italy") {
								if (language == "Italiano") {
									Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.id.unicity"),
											ITOrderNumber.getText(), "Major Customer Account Number");
									Assert.assertTrue(new JsonPath(OrdersResponse.toString()).get("data.id.unicity")
											.toString().length() != 0, "Major Customer Order Number");
									childtest.log(LogStatus.INFO, "Order Number", ITOrderNumber.getText());
								} else {
									Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.id.unicity"),
											OrderNumber.getText(), "Major Customer Account Number");
									Assert.assertTrue(new JsonPath(OrdersResponse.toString()).get("data.id.unicity")
											.toString().length() != 0, "Major Customer Order Number");
									childtest.log(LogStatus.INFO, "Order Number", OrderNumber.getText());
								}
							}

							if (!(Market == "Mexico" || Market == "Italy")) {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.id.unicity"),
										OrderNumber.getText(), "Major Customer Account Number");
								Assert.assertTrue(new JsonPath(OrdersResponse.toString()).get("data.id.unicity")
										.toString().length() != 0, "Major Customer Order Number");
								childtest.log(LogStatus.INFO, "Order Number", OrderNumber.getText());
							}

							if (!(Market == "Australia" || Market == "New Zealand" || Market == "Colombia"
									|| Market == "Dominican Republic" || Market == "India" || Market == "Jamaica"
									|| Market == "Mexico" || Market == "Ukraine")) {

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.autoorders.items.id.unicity").toString()
												.replace("[", "").replace("]", ""),
										ARNumber.getText(), "Major AR Number");
								Assert.assertTrue(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.autoorders.items.id.unicity").toString()
												.replace("[", "").replace("]", "").length() != 0,
										"Major AR Number");

								childtest.log(LogStatus.INFO, "AR Number", ARNumber.getText());
							}
						}

						if (userdata.get("version").equals("v5/")) {
							JSONObject OrdersResponse = new JSONObject(entry.getResponse().getContent().getText()
									.toString()
									.substring(entry.getResponse().getContent().getText().toString().indexOf("{"))
									.trim());
							Assert.assertEquals(
									((String) new JsonPath(OrdersResponse.toString()).get("data.error.error_message"))
											.split("#")[0],
									"Could not authorize and capture credit card payment. Error");
						}
					}
				}

				if (pack == "NoPack") {
					if (entry.getRequest().getUrl().contains("customers.js")) {
						System.out.println("Request URL: " + entry.getRequest().getUrl());
						System.out.println("Entry request : " + entry.getRequest().getPostData().getText());
						System.out.println("Entry response : " + entry.getResponse().getContent().getText());

						childtest.log(LogStatus.INFO, "Request Parameter", "");

						JSONObject Orders = new JSONObject(entry.getRequest().getPostData().getText().toString()
								.substring(entry.getRequest().getPostData().getText().toString().indexOf("{")).trim());

						Assert.assertEquals(new JsonPath(Orders.toString()).get("birthDate"),
								userdata.get("responsedob"), "Major Request DOB");

						if (Market == "Norway") {
							if (userdata.get("commission") == "DD") {
								Assert.assertEquals(
										new JsonPath(Orders.toString()).get("depositBankAccount.accountHolder"),
										userdata.get("holder"), "Major Account Holder");
								Assert.assertEquals(new JsonPath(Orders.toString()).get("depositBankAccount.bankName"),
										userdata.get("bankname"), "Major Bank name");
								Assert.assertEquals(new JsonPath(Orders.toString()).get("depositBankAccount.bic"),
										userdata.get("bic"), "Major BIC");
								Assert.assertEquals(
										new JsonPath(Orders.toString()).get("depositBankAccount.accountNumber"),
										userdata.get("iban"), "Major IBAN");
							}
						}

						Assert.assertEquals(
								new JsonPath(Orders.toString()).get("coapplicant.details.humanName.firstName"),
								userdata.get("coapplicant"), "Major Request coapplicant");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("email"), userdata.get("email"),
								"Major Request email");

						Assert.assertEquals(
								new JsonPath(Orders.toString()).get("enroller.href"), "https://hydraqa.unicity.net/"
										+ userdata.get("version") + "customers?id.unicity=" + userdata.get("enroller"),
								"Major Enroller href");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("gender"), userdata.get("gender"),
								"Major Request gender");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("homePhone"), userdata.get("phone"),
								"Major Request homePhone");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("humanName.firstName"),
								userdata.get("fname"), "Major Request firstName");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("humanName.lastName"),
								userdata.get("lname"), "Major Request lastName");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("mainAddress.address1"),
								userdata.get("address1"), "Major Request address1");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("mainAddress.address2"),
								userdata.get("address2"), "Major Request address2");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("mainAddress.city"),
								userdata.get("city"), "Major Request city");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("mainAddress.country"),
								userdata.get("marketcode"), "Major Request country");

						if (Market == "India") {
							Assert.assertEquals(new JsonPath(Orders.toString()).get("mainAddress.state"), "KA",
									"Major Request state");
						}
						Assert.assertEquals(new JsonPath(Orders.toString()).get("mainAddress.zip"), userdata.get("zip"),
								"Major Request zip");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("maritalStatus"),
								userdata.get("martial"), "Major Request homePhone");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("preferredLocale"),
								userdata.get("locale") + "-" + userdata.get("marketcode"), "Major Preferred-Locale");

						if (Market == "India") {
							Assert.assertTrue(
									new JsonPath(Orders.toString()).get("signature.value").toString().length() != 0,
									"Major Signature");
						} else {
							Assert.assertEquals(new JsonPath(Orders.toString()).get("signature.value"),
									userdata.get("signature"), "Major Signature");
						}

						Assert.assertEquals(
								new JsonPath(Orders.toString()).get("sponsor.href"), "https://hydraqa.unicity.net/"
										+ userdata.get("version") + "customers?id.unicity=" + userdata.get("sponsor"),
								"Major sponsor href");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("status"), "Active", "Major Status");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("type"), userdata.get("type"),
								"Major type");

						JSONObject OrdersResponse = new JSONObject(entry.getResponse().getContent().getText().toString()
								.substring(entry.getResponse().getContent().getText().toString().indexOf("{")).trim());

						childtest.log(LogStatus.INFO, "Response", "");

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.birthDate"),
								userdata.get("responsedob"), "Major Response DOB");

						Assert.assertEquals(
								new JsonPath(OrdersResponse.toString())
										.get("data.coapplicant.details.humanName.firstName"),
								userdata.get("coapplicant"), "Major Response coapplicant");

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.email"),
								userdata.get("email"), "Major Response email");

						Assert.assertEquals(
								String.valueOf(String.valueOf(
										new JsonPath(OrdersResponse.toString()).get("data.enroller.id.unicity"))),
								userdata.get("enroller"), "Major Response Enroller ");

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.gender"),
								userdata.get("gender"), "Major Response gender");

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.homePhone"),
								userdata.get("phone"), "Major Response homePhone");

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.humanName.firstName"),
								userdata.get("fname"), "Major Response firstName");
						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.humanName.lastName"),
								userdata.get("lname"), "Major Response lastName");

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.mainAddress.address1"),
								userdata.get("address1"), "Major Response address1");
						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.mainAddress.address2"),
								userdata.get("address2"), "Major Response address2");
						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.mainAddress.city"),
								userdata.get("city"), "Major Request city");
						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.mainAddress.country"),
								userdata.get("marketcode"), "Major Response country");
						if (Market == "India") {
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.mainAddress.state"),
									"KA", "Major Response state");
						}
						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.mainAddress.zip"),
								userdata.get("zip"), "Major Response zip");

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.maritalStatus"),
								userdata.get("martial"), "Major Response homePhone");

						if (Market == "India") {
							Assert.assertTrue(new JsonPath(OrdersResponse.toString()).get("data.password.value")
									.toString().length() != 0, "Major Response password");
							Assert.assertTrue(new JsonPath(OrdersResponse.toString()).get("data.id.unicity").toString()
									.length() != 0, "Major Response Order ID");
						} else {
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.password.value"),
									userdata.get("password"), "Major Response password");
						}

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.preferredLocale"),
								userdata.get("locale") + "-" + userdata.get("marketcode"), "Major Preferred-Locale");

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.signature.value"),
								userdata.get("signature"), "Major Response Signature");

						Assert.assertEquals(
								String.valueOf(String.valueOf(
										new JsonPath(OrdersResponse.toString()).get("data.sponsor.id.unicity"))),
								userdata.get("sponsor"), "Major Response sponsor ");

						if (Market == "India") {
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.status"), "Pending",
									"Major Status");
						} else {
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.status"), "Active",
									"Major Status");
						}

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.type"),
								userdata.get("type"), "Major Response type");
						if (Market == "Norwary") {
							Assert.assertEquals(NONopackAccountNumber.getText(),
									new JsonPath(OrdersResponse.toString()).get("data.id.unicity"));
						}
					}
				}
			}
		}

		driver.findElement(By.cssSelector(".btn.btn-danger.uppercase")).click();

		Thread.sleep(5000);
		Assert.assertEquals(driver.getCurrentUrl(), url, "Low return url");
		String[] expected = { "Australia", "Austria", "Bahamas", "Belgium", "Cambodia ", "Canada ", "Colombia",
				"Denmark ", "Dominican Republic", "France", "Germany", "Hong Kong", "Hungary", "India", "Indonesia",
				"Italy", "Ireland", "Jamaica", "Japan", "Korea", "Laos", "Luxembourg", "Malaysia", "Mexico",
				"Netherlands", "New Zealand", "Norway", "Philippines", "Poland", "Puerto Rico ", "Singapore", "Sweden",
				"Switzerland", "Spain", "Taiwan", "Thailand", "United States", "Ukraine", "United Kingdom" };

		for (int i = 0; i < expected.length; i++) {
			Assert.assertEquals(Country.get(i).getText(), expected[i], "Major market is missing");
		}

	}

	public void PCOrderSubmit(String Market, String language, String pack)
			throws JsonGenerationException, JsonMappingException, IOException, InterruptedException, JSONException {

		Thread.sleep(10000);

		childtest.log(LogStatus.INFO, "Summary", "");

		ArrayList<String> Labels = new ArrayList<String>();

		for (int i = 0; i < Headings.size(); i++) {
			Labels.add(Headings.get(i).getText());
		}
		if (Market == "Puerto Rico") {
			Assert.assertEquals(Labels.toString(), getTranslation("summary_pr_pc", language),
					"Minor Summary Labels is Displaying");
		}

		if (Market == "Colombia") {
			Assert.assertEquals(Labels.toString(), getTranslation("summary_co_pc", language),
					"Minor Summary Labels is Displaying");
		}

		if (!(Market == "Puerto Rico" || Market == "Colombia")) {
			Assert.assertEquals(Labels.toString(), getTranslation("summary_us_pc", language),
					"Minor Summary Labels is Displaying");
		}

		Assert.assertEquals(market.getText(), getTranslation(userdata.get("marketcode"), language),
				"Major Market is Displaying");
		Assert.assertEquals(Lan.getText(), language, "Langauge is Displaying");

		if (EnrollerSponsor.size() == 1) {
			Assert.assertEquals(Enroller.getText(), userdata.get("enroller"), "Major Enroller is Displaying");
		}

		if (EnrollerSponsor.size() == 0) {
			Assert.assertEquals(Enroller.getText(), userdata.get("enrollerName"), "Major Enroller is Displaying");
		}

		Assert.assertEquals(CustomerType.getText(), getTranslation("type", language));

		Assert.assertEquals(Fname.getText(), userdata.get("fname"), "Major Summary FName");
		Assert.assertEquals(Lname.getText(), userdata.get("lname"), "Major Summary LName");
		Assert.assertEquals(Phone.getText(), userdata.get("phone"), "Major Summary Phone");
		Assert.assertEquals(Email.getText(), userdata.get("email"), "Major Summary Email");
		Assert.assertEquals(Gender.getText(), userdata.get("genderoption"), "Major Summary Gender");
		Assert.assertEquals(Martial.getText(), userdata.get("maritaloption"), "Major Summary Marital");

		if (Market == "Puerto Rico") {
			Assert.assertEquals(USShippingAddress1.getText(), userdata.get("address1"), "Major Shipping Address1");
			Assert.assertEquals(USShippingZip.getText(), userdata.get("zip"), "Major Shipping Postal");
			Assert.assertEquals(USShippingCity.getText(), userdata.get("city"), "Major Shipping City");
			Assert.assertEquals(USShippingCountry.getText(), getTranslation(userdata.get("marketcode"), language),
					"Major Shipping Country");

			Assert.assertEquals(USBillingAddress1.getText(), userdata.get("address1"), "Major Billing Address1");
			Assert.assertEquals(USBillingZip.getText(), userdata.get("zip"), "Major Billing Postal");
			Assert.assertEquals(USBillingCity.getText(), userdata.get("city"), "Major Billing City");
			if (language == "English") {
				Assert.assertEquals(USBillingCountry.getText(), "United States", "Major Billing Country");
			} else {
				Assert.assertEquals(USBillingCountry.getText(), "Estados Unidos", "Major Billing Country");
			}
		}

		if (Market == "United States") {
			Assert.assertEquals(USShippingAddress1.getText(), userdata.get("address1"), "Major Shipping Address1");
			Assert.assertEquals(USShippingZip.getText(), userdata.get("zip"), "Major Shipping Postal");
			Assert.assertEquals(USShippingCity.getText(), userdata.get("city"), "Major Shipping City");
			Assert.assertEquals(USShippingCountry.getText(), getTranslation(userdata.get("marketcode"), language),
					"Major Shipping Country");

			Assert.assertEquals(USBillingAddress1.getText(), userdata.get("address1"), "Major Billing Address1");
			Assert.assertEquals(USBillingZip.getText(), userdata.get("zip"), "Major Billing Postal");
			Assert.assertEquals(USBillingCity.getText(), userdata.get("city"), "Major Billing City");
			Assert.assertEquals(USBillingCountry.getText(), "United States", "Major Billing Country");
		}

		if (Market == "Canada") {
			Assert.assertEquals(USShippingAddress1.getText(), userdata.get("address1"), "Major Shipping Address1");
			Assert.assertEquals(USShippingZip.getText(), userdata.get("zip"), "Major Shipping Postal");
			Assert.assertEquals(USShippingCity.getText(), userdata.get("city"), "Major Shipping City");
			Assert.assertEquals(USShippingCountry.getText(), getTranslation(userdata.get("marketcode"), language),
					"Major Shipping Country");

			Assert.assertEquals(USBillingAddress1.getText(), userdata.get("address1"), "Major Billing Address1");
			Assert.assertEquals(USBillingZip.getText(), userdata.get("zip"), "Major Billing Postal");
			Assert.assertEquals(USBillingCity.getText(), userdata.get("city"), "Major Billing City");
			Assert.assertEquals(USBillingCountry.getText(), "Canada", "Major Billing Country");
		}

		if (Market == "Bahamas") {
			Assert.assertEquals(USShippingAddress1.getText(), userdata.get("address1"), "Major Shipping Address1");
			Assert.assertEquals(USShippingZip.getText(), userdata.get("zip"), "Major Shipping Postal");
			Assert.assertEquals(USShippingCity.getText(), userdata.get("city"), "Major Shipping City");
			Assert.assertEquals(USShippingCountry.getText(), getTranslation("US", language), "Major Shipping Country");

			Assert.assertEquals(USBillingAddress1.getText(), "Address 1", "Major Billing Address1");
			Assert.assertEquals(USBillingCity.getText(), "TestCity", "Major Billing City");
			if (Market == "Bahamas") {
				Assert.assertEquals(USBillingCountry.getText(), getTranslation(userdata.get("marketcode"), language),
						"Major Billing Country");
			} else {
				Assert.assertEquals(USBillingCountry.getText(), getTranslation(userdata.get("marketcode"), language),
						"Major Billing Country");
			}
		}
		if (Market == "Dominican Republic") {
			Assert.assertEquals(USShippingAddress1.getText(), userdata.get("address1"), "Major Shipping Address1");
			Assert.assertEquals(USShippingZip.getText(), userdata.get("zip"), "Major Shipping Postal");
			Assert.assertEquals(USShippingCity.getText(), userdata.get("city"), "Major Shipping City");
			Assert.assertEquals(USShippingCountry.getText(), "United States", "Major Shipping Country");

			Assert.assertEquals(USBillingAddress1.getText(), "Address 1", "Major Billing Address1");
			Assert.assertEquals(USBillingCity.getText(), "TestCity", "Major Billing City");
			Assert.assertEquals(USBillingCountry.getText(), "Dominican Republic", "Major Billing Country");
		}

		if (Market == "Mexico") {
			Assert.assertEquals(USShippingAddress1.getText(), userdata.get("address1"), "Major Shipping Address1");
			Assert.assertEquals(USShippingZip.getText(), userdata.get("zip"), "Major Shipping Postal");
			Assert.assertEquals(USShippingCity.getText(), userdata.get("city"), "Major Shipping City");
			Assert.assertEquals(USShippingCountry.getText(), getTranslation(userdata.get("marketcode"), language),
					"Major Shipping Country");

			Assert.assertEquals(USBillingAddress1.getText(), userdata.get("address1"), "Major Billing Address1");
			Assert.assertEquals(USBillingZip.getText(), userdata.get("zip"), "Major Billing Postal");
			Assert.assertEquals(USBillingCity.getText(), userdata.get("city"), "Major Billing City");
			Assert.assertEquals(USBillingCountry.getText(), "Mexico", "Major Billing Country");
		}

		if (Market == "Colombia") {
			Assert.assertEquals(BillingAddress1.getText(), userdata.get("address1"), "Major Billing Address1");
			Assert.assertEquals(BillingAddress2.getText(), userdata.get("address2"), "Major Billing Address 2");
			Assert.assertEquals(BillingCity.getText(), userdata.get("city"), "Major Billing City");
			Assert.assertEquals(USBillingCountry.getText(), getTranslation(userdata.get("marketcode"), language),
					"Major Shipping Billing");
		}

		Click.click();
		float total = (Float.parseFloat(PCTotalPrice.getText().replaceAll("[^\\d.]+", "").trim()));
		float shipprice = (Float.parseFloat(ShippingPrice.getText().replaceAll("[^\\d.]+", "").trim()));
		float tax = (Float.parseFloat(Tax.getText().replaceAll("[^\\d.]+", "").trim()));
		float discount = (Float.parseFloat(Discount.getText().replaceAll("[^\\d.]+", "").trim()));
		float grandtotal = (Float.parseFloat(GrandTotal.getText().replaceAll("[^\\d.]+", "").trim()));
		float result = total + shipprice + tax - discount;
		DecimalFormat df2 = new DecimalFormat("#.##");
		Float result1 = Float.valueOf(df2.format(result));

		if (Market == "Colombia") {
			Assert.assertEquals(total, grandtotal, "Major Total Price is Wrong");
		} else {
			Assert.assertEquals(grandtotal, result1, "Major Total Price is Wrong");
		}

		if (!(Market == "Colombia" || Market == "Dominican Republic" || Market == "Mexico")) {
			Click.click();
			float ARTotal = (Float.parseFloat(PCARTotalPrice.getText().replaceAll("[^\\d.]+", "").trim()));
			float ARShipprice = (Float.parseFloat(PCARShippingPrice.getText().replaceAll("[^\\d.]+", "").trim()));
			float ARtax = (Float.parseFloat(PCARTax.getText().replaceAll("[^\\d.]+", "").trim()));
			float ARdiscount = (Float.parseFloat(PCARDiscount.getText().replaceAll("[^\\d.]+", "").trim()));
			float ARgrandTotal = (Float.parseFloat(PCARGrandTotal.getText().replaceAll("[^\\d.]+", "").trim()));
			float ARresult = ARTotal + ARShipprice + ARtax - ARdiscount;
			DecimalFormat df3 = new DecimalFormat("#.##");
			Float result3 = Float.valueOf(df3.format(ARresult));
			Assert.assertEquals(ARgrandTotal, result3, "Major AR Total Price is Wrong");
		}

		Continue.click();
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@src='assets/img/spinner.gif']")));
		System.out.println(userdata);

		List<HarEntry> entries = server.getHar().getLog().getEntries();
		for (HarEntry entry : entries) {

			if (entry.getRequest().getMethod().equals("POST")) {

				if (entry.getRequest().getUrl().contains("orders.js")) {

					if (entry.getRequest().getUrl().contains(userdata.get("version"))) {
						System.out.println("Request URL: " + entry.getRequest().getUrl());
						System.out.println("Entry request : " + entry.getRequest().getPostData().getText());
						System.out.println("Entry response : " + entry.getResponse().getContent().getText());

						System.out.println("Headers-->" + entry.getRequest().getHeaders().get(1).getValue());
						System.out.println("Headers-->" + entry.getRequest().getHeaders().get(2).getValue());
						System.out.println("Headers-->" + entry.getRequest().getHeaders().get(3).getValue());
						System.out.println("Headers-->" + entry.getRequest().getHeaders().get(4).getValue());
						System.out.println("Headers-->" + entry.getRequest().getHeaders().get(5).getValue());

						Assert.assertEquals(userdata.get("locale") + "-" + userdata.get("marketcode"),
								entry.getRequest().getHeaders().get(5).getValue());

						JSONObject Orders = new JSONObject(entry.getRequest().getPostData().getText().toString()
								.substring(entry.getRequest().getPostData().getText().toString().indexOf("{")).trim());

						childtest.log(LogStatus.INFO, "Request Parameter", "");

						if (!(Market == "Colombia" || Market == "Dominican Republic" || Market == "Mexico")) {

							Assert.assertEquals(
									new JsonPath(Orders.toString())
											.get("customer.autoorders.items.lines.items.item.href").toString()
											.replace("[", "").replace("]", ""),
									"https://hydraqa.unicity.net/" + userdata.get("version") + "items?id.unicity="
											+ userdata.get("aritemcode"),
									"Major AR Pack href");

							Assert.assertEquals(
									new JsonPath(Orders.toString()).get("customer.autoorders.items.shippingMethod.href")
											.toString().replace("[", "").replace("]", ""),
									"https://hydraqa.unicity.net/" + userdata.get("version") + "shippingmethods?"
											+ userdata.get("shippingmethod"),
									"Major AR Ship Method href");

							if (Market == "Bahamas" || Market == "Puerto Rico") {
								Assert.assertEquals(
										new JsonPath(Orders.toString())
												.get("customer.autoorders.items.shipToAddress.country").toString()
												.replace("[", "").replace("]", ""),
										"US", "Major AR Market Code");
							} else {
								Assert.assertEquals(
										new JsonPath(Orders.toString())
												.get("customer.autoorders.items.shipToAddress.country").toString()
												.replace("[", "").replace("]", ""),
										userdata.get("marketcode"), "Major AR Market Code");
							}
							Assert.assertEquals(
									new JsonPath(Orders.toString()).get("customer.autoorders.items.shipToAddress.zip")
											.toString().replace("[", "").replace("]", ""),
									userdata.get("zip"), "Major AR Zip Code");
							Assert.assertEquals(
									new JsonPath(Orders.toString())
											.get("customer.autoorders.items.shipToAddress.address1").toString()
											.replace("[", "").replace("]", ""),
									userdata.get("address1"), "Major AR Address1");
							Assert.assertEquals(
									new JsonPath(Orders.toString()).get("customer.autoorders.items.shipToAddress.city")
											.toString().replace("[", "").replace("]", ""),
									userdata.get("city"), "Major AR City");

							Assert.assertEquals(
									new JsonPath(Orders.toString())
											.get("customer.autoorders.items.shipToName.firstName").toString()
											.replace("[", "").replace("]", ""),
									userdata.get("fname"), "Major AR FirstName");
							Assert.assertEquals(
									new JsonPath(Orders.toString()).get("customer.autoorders.items.shipToName.lastName")
											.toString().replace("[", "").replace("]", ""),
									userdata.get("lname"), "Major AR LastName");
							Assert.assertEquals(
									new JsonPath(Orders.toString()).get("customer.autoorders.items.shipToPhone")
											.toString().replace("[", "").replace("]", ""),
									userdata.get("phone"), "Major AR Phone");
						}

						if (Market == "Bahamas" || Market == "Dominican Republic" || Market == "Jamaica"
								|| Market == "Puerto Rico") {
							Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.mainAddress.country"),
									"US", "Major Market Code");
						} else {
							Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.mainAddress.country"),
									userdata.get("marketcode"), "Major Market Code");
						}
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.mainAddress.zip"),
								userdata.get("zip"), "Major zip code");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.mainAddress.address1"),
								userdata.get("address1"), "Major Address");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.mainAddress.city"),
								userdata.get("city"), "Major City");
						// Assert.assertEquals(new
						// JsonPath(Orders.toString()).get("customer.mainAddress.state"),
						// "UT");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.humanName.firstName"),
								userdata.get("fname"), "Major FirstName");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.humanName.lastName"),
								userdata.get("lname"), "Major LastName");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.email"),
								userdata.get("email"), "Major Email");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.preferredLocale"),
								userdata.get("locale") + "-" + userdata.get("marketcode"), "Major Preferred-Locale");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.password.value"),
								userdata.get("password"), "Major Password");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.gender"),
								userdata.get("gender").toLowerCase(), "Major Gender");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.maritalStatus"),
								userdata.get("martial"), "Major Martial Status");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.type"), userdata.get("type"),
								"Major Customer Type");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.sponsor.href"),
								"https://hydraqa.unicity.net/" + userdata.get("version") + "customers?id.unicity="
										+ userdata.get("sponsor"),
								"Major Sponsor href");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.enroller.href"),
								"https://hydraqa.unicity.net/" + userdata.get("version") + "customers?id.unicity="
										+ userdata.get("enroller"),
								"Major Enroller href");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.homePhone"),
								userdata.get("phone"), "Major Customer Phone");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("lines.items.item.href"), packs,
								"Major Packs");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("lines.items.quantity").toString(),
								Quantity.toString(), "Major Quantity");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToName.firstName"),
								userdata.get("fname"), "Major Ship FirstName");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToName.lastName"),
								userdata.get("lname"), "Major Ship LastName");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToPhone"), userdata.get("phone"),
								"Major Ship Phone");

						if (Market == "Bahamas" || Market == "Dominican Republic" || Market == "Puerto Rico") {
							Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToAddress.country"), "US",
									"Major Ship Country");
						} else {
							Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToAddress.country"),
									userdata.get("marketcode"), "Major Ship Country");
						}
						Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToAddress.zip"),
								userdata.get("zip"), "Major Ship zip");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToAddress.address1"),
								userdata.get("address1"), "Major Ship Address");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("shippingMethod.href"),
								"https://hydraqa.unicity.net/" + userdata.get("version") + "shippingmethods?"
										+ userdata.get("shippingmethod"),
								"Major Ship Method href");
						childtest.log(LogStatus.INFO, "Orders",
								"<a href=" + entry.getRequest().getUrl() + ">Orders.js</a>");

						if (userdata.get("version").equals("v5a-test/")) {
							JSONObject OrdersResponse = new JSONObject(entry.getResponse().getContent().getText()
									.toString()
									.substring(entry.getResponse().getContent().getText().toString().indexOf("{"))
									.trim());

							childtest.log(LogStatus.INFO, "Response", "");

							if (Market == "Bahamas" || Market == "Dominican Republic" || Market == "Jamaica"
									|| Market == "Puerto Rico") {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.market"), "US",
										"Major Market");
							} else {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.market"),
										userdata.get("marketcode"), "Major Market");
							}

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.lines.items.item.id.unicity"),
									Itemcode, "Major Packs");
							if (Market == "Bahamas" || Market == "Dominican Republic" || Market == "Puerto Rico") {
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString()).get("data.shipToAddress.country"), "US",
										"Major Ship Country");
							} else {
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString()).get("data.shipToAddress.country"),
										userdata.get("marketcode"), "Major Ship Country");
							}
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.shipToAddress.zip"),
									userdata.get("zip"), "Major Ship zip");
							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.shipToAddress.address1"),
									userdata.get("address1"), "Major Ship Address");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.shipToName.firstName"),
									userdata.get("fname"), "Major Ship FirstName");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.shipToName.lastName"),
									userdata.get("lname"), "Major Ship LastName");

							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.shipToPhone"),
									userdata.get("phone"), "Major Ship Phone");

							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.shippingMethod.href"),
									"https://hydraqa.unicity.net/" + userdata.get("version") + "shippingmethods?"
											+ userdata.get("shippingmethod"),
									"Major Ship Method href");
							if (Market == "Puerto Rico") {
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString()).get("data.shippingMethod.type"),
										userdata.get("shippingmethod").split("=")[1].replace("&location", ""),
										"Major Response Ship Method");
							} else {
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString()).get("data.shippingMethod.type"),
										userdata.get("shippingmethod").split("=")[1], "Major Response Ship Method");
							}

							if (Market == "Canada") {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.currency"), "CAD",
										"Major Response Currency");
							}

							if (Market == "Mexico") {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.currency"), "MXN",
										"Major Response Currency");
							}

							if (!(Market == "Canada" || Market == "Mexico")) {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.currency"),
										userdata.get("Currency"), "Major Response Currency");
							}

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.humanName.firstName"),
									userdata.get("fname"), "Major Customer FirstName");
							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.humanName.lastName"),
									userdata.get("lname"), "Major Customer LastName");

							if (Market == "Bahamas" || Market == "Dominican Republic" || Market == "Puerto Rico") {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString())
										.get("data.customer.mainAddress.country"), "US", "Major Customer Country");
							} else {
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.mainAddress.country"),
										userdata.get("marketcode"), "Major Customer Country");
							}
							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.mainAddress.zip"),
									userdata.get("zip"), "Major Customer Zip");
							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.mainAddress.address1"),
									userdata.get("address1"), "Major Customer address1");

							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.type"),
									userdata.get("type"), "Major Customer Type");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.email"),
									userdata.get("email"), "Major Customer Email");

							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.gender"),
									userdata.get("gender").toLowerCase(), "Major Customer Gender");
							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.password.value"),
									userdata.get("password"), "Major Customer Password");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString())
									.get("data.customer.enroller.id.unicity").toString(), userdata.get("enroller"),
									"Major Customer Enroller");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString())
									.get("data.customer.sponsor.id.unicity").toString(), userdata.get("sponsor"),
									"Major Customer Sponsor");

							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.homePhone"),
									userdata.get("phone"), "Major Customer Phone");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.preferredLocale"),
									userdata.get("locale") + "-" + userdata.get("marketcode"),
									"Major Customer Prefered-Locale");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.maritalStatus"),
									userdata.get("martial"), "Major Customer Martial");

							if (Market == "Mexico") {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.status"),
										"Active", "Major Customer Status");
							} else {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.status"),
										"Active", "Major Customer Status");
							}

							if (!(Market == "Colombia" || Market == "Dominican Republic" || Market == "Mexico")) {

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.autoorders.items.lines.items.item.href").toString()
												.replace("[", "").replace("]", ""),
										"https://hydraqa.unicity.net/" + userdata.get("version") + "items?id.unicity="
												+ userdata.get("aritemcode"),
										"Major AR Pack href");

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.autoorders.items.shipToName.firstName").toString()
												.replace("[", "").replace("]", ""),
										userdata.get("fname"), "Major AR First name");

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.autoorders.items.shipToName.lastName").toString()
												.replace("[", "").replace("]", ""),
										userdata.get("lname"), "Major AR Last name");

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.autoorders.items.shipToPhone").toString()
												.replace("[", "").replace("]", ""),
										userdata.get("phone"), "Major AR Phone");

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.autoorders.items.shipToEmail").toString()
												.replace("[", "").replace("]", ""),
										userdata.get("email"), "Major AR Email");

								if (Market == "Bahamas" || Market == "Puerto Rico") {
									Assert.assertEquals(
											new JsonPath(OrdersResponse.toString())
													.get("data.customer.autoorders.items.shipToAddress.country")
													.toString().replace("[", "").replace("]", ""),
											"US", "Major AR Country");
								} else {
									Assert.assertEquals(
											new JsonPath(OrdersResponse.toString())
													.get("data.customer.autoorders.items.shipToAddress.country")
													.toString().replace("[", "").replace("]", ""),
											userdata.get("marketcode"), "Major AR Country");
								}

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.autoorders.items.shipToAddress.zip").toString()
												.replace("[", "").replace("]", ""),
										userdata.get("zip"), "Major AR Zip");

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.autoorders.items.shipToAddress.address1").toString()
												.replace("[", "").replace("]", ""),
										userdata.get("address1"), "Major AR Address1");

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.autoorders.items.shippingMethod.href").toString()
												.replace("[", "").replace("]", ""),
										"https://hydraqa.unicity.net/" + userdata.get("version") + "shippingmethods?"
												+ userdata.get("shippingmethod"),
										"Major AR Ship Method href");

							}

							if (!(Market == "Mexico")) {
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString()).get("data.customer.id.unicity"),
										AccountNumber.getText(), "Major Customer Account Number");
								Assert.assertTrue(new JsonPath(OrdersResponse.toString())
										.get("data.customer.id.unicity").toString().length() != 0,
										"Major Customer Account Number");
								childtest.log(LogStatus.INFO, "Account Number", AccountNumber.getText());

								if (Market == "Mexico") {
									Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.id.unicity"),
											MXOrderNumber.getText(), "Major Customer Order Number");
									Assert.assertTrue(new JsonPath(OrdersResponse.toString()).get("data.id.unicity")
											.toString().length() != 0, "Major Customer Order Number");
									childtest.log(LogStatus.INFO, "Account Number", MXOrderNumber.getText());

									if (userdata.get("paymenttype") == "bank") {
										try {
											Boolean paymentlink = MexicoBankPaymentLink.isDisplayed();
											Assert.assertTrue(paymentlink);
										} catch (Exception e) {
											Assert.fail("Major paymentlink is not displaying");
										}
									}
								}

								if (!(Market == "Mexico")) {
									Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.id.unicity"),
											OrderNumber.getText(), "Major Customer Account Number");
									Assert.assertTrue(new JsonPath(OrdersResponse.toString()).get("data.id.unicity")
											.toString().length() != 0, "Major Customer Order Number");
									childtest.log(LogStatus.INFO, "Order Number", OrderNumber.getText());
								}

								if (!(Market == "Colombia" || Market == "Dominican Republic" || Market == "Mexico")) {

									Assert.assertEquals(
											new JsonPath(OrdersResponse.toString())
													.get("data.customer.autoorders.items.id.unicity").toString()
													.replace("[", "").replace("]", ""),
											ARNumber.getText(), "Major AR Number");
									Assert.assertTrue(
											new JsonPath(OrdersResponse.toString())
													.get("data.customer.autoorders.items.id.unicity").toString()
													.replace("[", "").replace("]", "").length() != 0,
											"Major AR Number");

									childtest.log(LogStatus.INFO, "AR Number", ARNumber.getText());
								}
							}

							if (userdata.get("version").equals("v5/")) {
								JSONObject OrdersResponse1 = new JSONObject(entry.getResponse().getContent().getText()
										.toString()
										.substring(entry.getResponse().getContent().getText().toString().indexOf("{"))
										.trim());
								Assert.assertEquals(
										((String) new JsonPath(OrdersResponse1.toString())
												.get("data.error.error_message")).split("#")[0],
										"Could not authorize and capture credit card payment. Error");
							}
						}
					}

					driver.findElement(By.cssSelector(".btn.btn-danger.uppercase")).click();

					Thread.sleep(5000);
					Assert.assertEquals(driver.getCurrentUrl(), url, "Low return url");
					String[] expected = { "Australia", "Austria", "Bahamas", "Belgium", "Cambodia ", "Canada ",
							"Colombia", "Denmark ", "Dominican Republic", "France", "Germany", "Hong Kong", "Hungary",
							"India", "Indonesia", "Italy", "Ireland", "Jamaica", "Japan", "Korea", "Laos", "Luxembourg",
							"Malaysia", "Mexico", "Netherlands", "New Zealand", "Norway", "Philippines", "Poland",
							"Puerto Rico ", "Singapore", "Sweden", "Switzerland", "Spain", "Taiwan", "Thailand",
							"United States", "Ukraine", "United Kingdom", };

					for (int i = 0; i < expected.length; i++) {
						Assert.assertEquals(Country.get(i).getText(), expected[i], "Major market is missing");
					}
				}
			}
		}
	}

	public void GetFitOrderSubmit(String Market, String language, String pack)
			throws JsonGenerationException, JsonMappingException, IOException, InterruptedException, JSONException {

		String sign = "TestSignature";

		Thread.sleep(10000);

		childtest.log(LogStatus.INFO, "Summary", "");

		ArrayList<String> Labels = new ArrayList<String>();

		for (int i = 0; i < Headings.size(); i++) {
			Labels.add(Headings.get(i).getText());
		}

		if (Market == "Canada" || Market == "United States") {
			Assert.assertEquals(Labels.toString(), getTranslation("summary_getfit", language),
					"Minor Summary Labels is Displaying");
		}

		Assert.assertEquals(market.getText(), getTranslation(userdata.get("marketcode"), language),
				"Major Market is Displaying");
		Assert.assertEquals(Lan.getText(), getTranslation("getfit_coach_21", language), "Account Type is Displaying");

		Assert.assertEquals(Enroller.getText(), userdata.get("enroller"), "Major Enroller is Displaying");

		Assert.assertEquals(Fname.getText(), userdata.get("fname"), "Major Summary FName");
		Assert.assertEquals(Lname.getText(), userdata.get("lname"), "Major Summary LName");
		Assert.assertEquals(DOB.getText(), userdata.get("dob"), "Major Summary DOB");
		Assert.assertEquals(Gender.getText(), userdata.get("genderoption"), "Major Summary Gender");

		if (!(Market == "United States" || Market == "Canada")) {
			Assert.assertEquals(Fax.getText(), userdata.get("fax"), "Major Summary Fax");
		}

		Assert.assertEquals(Phone.getText(), userdata.get("phone"), "Major Summary Phone");

		Assert.assertEquals(Email.getText(), userdata.get("email"), "Major Summary Email");

		if (Market == "United States" || Market == "Canada") {
			Assert.assertEquals(TermsandConditonsPDF.size(), 3, "Major Terms & Condition PDF's");
			childtest.log(LogStatus.INFO, "Terms and Condtions PDF", Integer.toString(TermsandConditonsPDF.size()));
		}

		if (!(Market == "United States" || Market == "Canada")) {
			if (userdata.get("coapplicanttype") == "Spouse") {
				Assert.assertEquals(Coapplicant.getText(), userdata.get("coapplicant"), "Major Summary CoApplicant");
			} else {
				Assert.assertEquals(CompanyName.getText(), userdata.get("coapplicant"), "Major Summary Company Name");
				Assert.assertEquals(CompanyType.getText(), userdata.get("companynametype"),
						"Major Summary Company Type");
			}
		}

		if (!(Market == "United States" || Market == "Canada")) {
			if (userdata.get("commission") == "DD") {
				Assert.assertEquals(IBAN.getText(), userdata.get("iban"), "Major IBAN");
				Assert.assertEquals(AccountTitle.getText(), userdata.get("holder"), "Major Account Holder");
				Assert.assertEquals(BankName.getText(), userdata.get("bankname"), "Major Bank Name");
				Assert.assertEquals(BIC.getText(), userdata.get("bic"), "Major BIC");
			}
		}

		if (Market == "United Kingdom") {
			Assert.assertEquals(FitShippingAddress1.getText(), userdata.get("address1"), "Major Shipping Address1");
			Assert.assertEquals(FitShippingAddress2.getText(), userdata.get("address2"), "Major Shipping Address 2");
			Assert.assertEquals(FitShippingCity.getText(), userdata.get("city"), "Major Shipping City");
			Assert.assertEquals(FitShippingZip.getText(), userdata.get("zip"), "Major Shipping Postal");

			Assert.assertEquals(BillingAddress1.getText(), userdata.get("address1"), "Major Billing Address1");
			Assert.assertEquals(BillingAddress2.getText(), userdata.get("address2"), "Major Billing Address 2");
			Assert.assertEquals(BillingCity.getText(), userdata.get("city"), "Major Billing City");
			Assert.assertEquals(FitBillingZip.getText(), userdata.get("zip"), "Major Billing Postal");

		}

		if (Market == "United States") {
			Assert.assertEquals(USShippingAddress1.getText(), userdata.get("address1"), "Major Shipping Address1");
			Assert.assertEquals(USShippingZip.getText(), userdata.get("zip"), "Major Shipping Postal");
			Assert.assertEquals(USShippingCity.getText(), userdata.get("city"), "Major Shipping City");
			

			Assert.assertEquals(USBillingAddress1.getText(), userdata.get("address1"), "Major Billing Address1");
			Assert.assertEquals(USBillingZip.getText(), userdata.get("zip"), "Major Billing Postal");
			Assert.assertEquals(USBillingCity.getText(), userdata.get("city"), "Major Billing City");
			
		}

		if (Market == "Canada") {
			Assert.assertEquals(USShippingAddress1.getText(), userdata.get("address1"), "Major Shipping Address1");
			Assert.assertEquals(USShippingZip.getText(), userdata.get("zip"), "Major Shipping Postal");
			Assert.assertEquals(USShippingCity.getText(), userdata.get("city"), "Major Shipping City");

			Assert.assertEquals(USBillingAddress1.getText(), userdata.get("address1"), "Major Billing Address1");
			Assert.assertEquals(USBillingZip.getText(), userdata.get("zip"), "Major Billing Postal");
			Assert.assertEquals(USBillingCity.getText(), userdata.get("city"), "Major Billing City");

		}

		Signature.sendKeys(sign);
		userdata.put("signature", sign);

		Disclaimar.click();

		Continue.click();
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@src='assets/img/spinner.gif']")));
		System.out.println(userdata);

		List<HarEntry> entries = server.getHar().getLog().getEntries();
		for (HarEntry entry : entries) {

			if (entry.getRequest().getMethod().equals("POST")) {

				if (entry.getRequest().getUrl().contains("orders.js")) {

					if (entry.getRequest().getUrl().contains(userdata.get("version"))) {
						System.out.println("Request URL: " + entry.getRequest().getUrl());
						System.out.println("Entry request : " + entry.getRequest().getPostData().getText());
						System.out.println("Entry response : " + entry.getResponse().getContent().getText());

						JSONObject Orders = new JSONObject(entry.getRequest().getPostData().getText().toString()
								.substring(entry.getRequest().getPostData().getText().toString().indexOf("{")).trim());

						childtest.log(LogStatus.INFO, "Request Parameter", "");

						Assert.assertEquals(
								new JsonPath(Orders.toString()).get("customer.autoorders.items.lines.items.item.href")
										.toString().replace("[", "").replace("]", ""),
								"https://hydraqa.unicity.net/" + userdata.get("version") + "items?id.unicity="
										+ userdata.get("aritemcode"),
								"Major AR Pack href");

						Assert.assertEquals(
								new JsonPath(Orders.toString()).get("customer.autoorders.items.shippingMethod.href")
										.toString().replace("[", "").replace("]", ""),
								"https://hydraqa.unicity.net/" + userdata.get("version") + "shippingmethods?"
										+ userdata.get("shippingmethod"),
								"Major AR Ship Method href");

						Assert.assertEquals(
								new JsonPath(Orders.toString()).get("customer.autoorders.items.shipToAddress.country")
										.toString().replace("[", "").replace("]", ""),
								userdata.get("marketcode"), "Major AR Market Code");

						Assert.assertEquals(
								new JsonPath(Orders.toString()).get("customer.autoorders.items.shipToAddress.zip")
										.toString().replace("[", "").replace("]", ""),
								userdata.get("zip"), "Major AR Zip Code");
						Assert.assertEquals(
								new JsonPath(Orders.toString()).get("customer.autoorders.items.shipToAddress.address1")
										.toString().replace("[", "").replace("]", ""),
								userdata.get("address1"), "Major AR Address1");
						Assert.assertEquals(
								new JsonPath(Orders.toString()).get("customer.autoorders.items.shipToAddress.city")
										.toString().replace("[", "").replace("]", ""),
								userdata.get("city"), "Major AR City");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.autoorders.items.shipToEmail")
								.toString().replace("[", "").replace("]", ""), userdata.get("email"), "Major AR Email");
						Assert.assertEquals(
								new JsonPath(Orders.toString()).get("customer.autoorders.items.shipToName.firstName")
										.toString().replace("[", "").replace("]", ""),
								userdata.get("fname"), "Major AR FirstName");
						Assert.assertEquals(
								new JsonPath(Orders.toString()).get("customer.autoorders.items.shipToName.lastName")
										.toString().replace("[", "").replace("]", ""),
								userdata.get("lname"), "Major AR LastName");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.autoorders.items.shipToPhone")
								.toString().replace("[", "").replace("]", ""), userdata.get("phone"), "Major AR Phone");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.mainAddress.country"),
								userdata.get("marketcode"), "Major Market Code");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.mainAddress.zip"),
								userdata.get("zip"), "Major zip code");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.mainAddress.address1"),
								userdata.get("address1"), "Major Address");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.mainAddress.city"),
								userdata.get("city"), "Major City");
						// Assert.assertEquals(new
						// JsonPath(Orders.toString()).get("customer.mainAddress.state"),
						// "UT");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.humanName.firstName"),
								userdata.get("fname"), "Major FirstName");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.humanName.lastName"),
								userdata.get("lname"), "Major LastName");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.email"),
								userdata.get("email"), "Major Email");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.preferredLocale"),
								userdata.get("locale") + "-" + userdata.get("marketcode"), "Major Preferred-Locale");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.password.value"),
								userdata.get("password"), "Major Password");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.gender"),
								userdata.get("gender").toLowerCase(), "Major Gender");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.maritalStatus"),
								userdata.get("martial"), "Major Martial Status");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.type"), "Associate",
								"Major Customer Type");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.sponsor.href"),
								"https://hydraqa.unicity.net/" + userdata.get("version") + "customers?id.unicity="
										+ userdata.get("sponsor"),
								"Major Sponsor href");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.enroller.href"),
								"https://hydraqa.unicity.net/" + userdata.get("version") + "customers?id.unicity="
										+ userdata.get("enroller"),
								"Major Enroller href");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.homePhone"),
								userdata.get("phone"), "Major Customer Phone");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.birthDate"),
								userdata.get("responsedob"), "Major DOB");

						if (userdata.get("coapplicant") == "TestSpouseName") {
							Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.coapplicant.type"),
									userdata.get("coapplicanttype"), "Major Co-App Type");
							Assert.assertEquals(
									new JsonPath(Orders.toString())
											.get("customer.coapplicant.details.humanName.firstName"),
									userdata.get("coapplicant"), "Major Co-App");
						} else {
							Assert.assertEquals(
									new JsonPath(Orders.toString()).get("customer.businessEntity.companyName"),
									userdata.get("coapplicant"), "Major Company Name");
							Assert.assertEquals(
									new JsonPath(Orders.toString()).get("customer.businessEntity.legalType"),
									"Corporation", "Major Legal Type");
						}

						if (userdata.get("commission") == "DD") {
							Assert.assertEquals(
									new JsonPath(Orders.toString()).get("customer.depositBankAccount.accountHolder"),
									userdata.get("holder"), "Major Account Holder");
							Assert.assertEquals(
									new JsonPath(Orders.toString()).get("customer.depositBankAccount.bankName"),
									userdata.get("bankname"), "Major Bank name");
							Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.depositBankAccount.bic"),
									userdata.get("bic"), "Major BIC");
							Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.depositBankAccount.iban"),
									userdata.get("iban"), "Major IBAN");
						}

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.signature.value"),
								userdata.get("signature"), "Major Signature");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("customer.taxTerms.taxId"),
								userdata.get("govid"), "Major GovID");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("lines.items.item.href"), packs,
								"Major Packs");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("lines.items.quantity").toString(),
								Quantity.toString(), "Major Quantity");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToName.firstName"),
								userdata.get("fname"), "Major Ship FirstName");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToName.lastName"),
								userdata.get("lname"), "Major Ship LastName");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToPhone"), userdata.get("phone"),
								"Major Ship Phone");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToEmail"), userdata.get("email"),
								"Major Ship Email");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToAddress.country"),
								userdata.get("marketcode"), "Major Ship Country");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToAddress.zip"),
								userdata.get("zip"), "Major Ship zip");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("shipToAddress.address1"),
								userdata.get("address1"), "Major Ship Address");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("shippingMethod.href"),
								"https://hydraqa.unicity.net/" + userdata.get("version") + "shippingmethods?"
										+ userdata.get("shippingmethod"),
								"Major Ship Method href");
						childtest.log(LogStatus.INFO, "", "<a href=" + entry.getRequest().getUrl() + ">Orders.js</a>");

						if (userdata.get("version").equals("v5a-test/")) {
							JSONObject OrdersResponse = new JSONObject(entry.getResponse().getContent().getText()
									.toString()
									.substring(entry.getResponse().getContent().getText().toString().indexOf("{"))
									.trim());

							childtest.log(LogStatus.INFO, "Response", "");

							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.market"),
									userdata.get("marketcode"), "Major Market");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.lines.items.item.id.unicity"),
									Itemcode, "Major Packs");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.shipToAddress.country"),
									userdata.get("marketcode"), "Major Ship Country");

							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.shipToAddress.zip"),
									userdata.get("zip"), "Major Ship zip");
							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.shipToAddress.address1"),
									userdata.get("address1"), "Major Ship Address");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.shipToName.firstName"),
									userdata.get("fname"), "Major Ship FirstName");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.shipToName.lastName"),
									userdata.get("lname"), "Major Ship LastName");

							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.shipToEmail"),
									userdata.get("email"), "Major Ship Email");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.shipToPhone"),
									userdata.get("phone"), "Major Ship Phone");

							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.shippingMethod.href"),
									"https://hydraqa.unicity.net/" + userdata.get("version") + "shippingmethods?"
											+ userdata.get("shippingmethod"),
									"Major Ship Method href");

							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.shippingMethod.type"),
									userdata.get("shippingmethod").split("=")[1], "Major Response Ship Method");

							if (Market == "Canada") {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.currency"), "CAD",
										"Major Response Currency");
							}

							if (Market == "United Kingdom") {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.currency"), "GBP",
										"Major Response Currency");
							}

							if (!(Market == "Canada" || Market == "United Kingdom")) {
								Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.currency"),
										userdata.get("Currency"), "Major Response Currency");
							}

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.humanName.firstName"),
									userdata.get("fname"), "Major Customer FirstName");
							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.humanName.lastName"),
									userdata.get("lname"), "Major Customer LastName");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.mainAddress.country"),
									userdata.get("marketcode"), "Major Customer Country");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.mainAddress.zip"),
									userdata.get("zip"), "Major Customer Zip");
							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.mainAddress.address1"),
									userdata.get("address1"), "Major Customer address1");

							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.type"),
									"Associate", "Major Customer Type");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.email"),
									userdata.get("email"), "Major Customer Email");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.taxTerms.taxId"),
									userdata.get("govid"), "Major Customer GovID");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.signature.value"),
									userdata.get("signature"), "Major Customer signature");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.gender"),
									userdata.get("gender").toLowerCase(), "Major Customer Gender");
							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.password.value"),
									userdata.get("password"), "Major Customer Password");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString())
									.get("data.customer.enroller.id.unicity").toString(), userdata.get("enroller"),
									"Major Customer Enroller");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString())
									.get("data.customer.sponsor.id.unicity").toString(), userdata.get("sponsor"),
									"Major Customer Sponsor");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.birthDate"),
									userdata.get("responsedob"), "Major Customer DOB");
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.homePhone"),
									userdata.get("phone"), "Major Customer Phone");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.preferredLocale"),
									userdata.get("locale") + "-" + userdata.get("marketcode"),
									"Major Customer Prefered-Locale");
							if (userdata.get("commission") == "DD") {

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.depositBankAccount.accountHolder"),
										userdata.get("holder"), "Major Account Holder");
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.depositBankAccount.bankName"),
										userdata.get("bankname"), "Major Bank name");
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.depositBankAccount.bic"),
										userdata.get("bic"), "Major BIC");
								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.depositBankAccount.iban"),
										userdata.get("iban"), "Major IBAN");
							}
							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString()).get("data.customer.maritalStatus"),
									userdata.get("martial"), "Major Customer Martial");
							if (!(userdata.get("coapplicanttype") == "company")) {

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.coapplicant.details.humanName.firstName"),
										userdata.get("coapplicant"), "Major Customer Co-Applicant");

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString()).get("data.customer.coapplicant.type"),
										userdata.get("coapplicanttype"), "Major Customer Co-Applicant Type");

							} else {

								Assert.assertEquals(
										new JsonPath(OrdersResponse.toString())
												.get("data.customer.businessEntity.companyName"),
										userdata.get("coapplicant"), "Major Customer Co-Applicant Type");
							}

							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.customer.status"),
									"Active", "Major Customer Status");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString())
											.get("data.customer.autoorders.items.lines.items.item.href").toString()
											.replace("[", "").replace("]", ""),
									"https://hydraqa.unicity.net/" + userdata.get("version") + "items?id.unicity="
											+ userdata.get("aritemcode"),
									"Major AR Pack href");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString())
											.get("data.customer.autoorders.items.shipToName.firstName").toString()
											.replace("[", "").replace("]", ""),
									userdata.get("fname"), "Major AR First name");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString())
											.get("data.customer.autoorders.items.shipToName.lastName").toString()
											.replace("[", "").replace("]", ""),
									userdata.get("lname"), "Major AR Last name");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString())
											.get("data.customer.autoorders.items.shipToPhone").toString()
											.replace("[", "").replace("]", ""),
									userdata.get("phone"), "Major AR Phone");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString())
											.get("data.customer.autoorders.items.shipToEmail").toString()
											.replace("[", "").replace("]", ""),
									userdata.get("email"), "Major AR Email");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString())
											.get("data.customer.autoorders.items.shipToAddress.country").toString()
											.replace("[", "").replace("]", ""),
									userdata.get("marketcode"), "Major AR Country");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString())
											.get("data.customer.autoorders.items.shipToAddress.zip").toString()
											.replace("[", "").replace("]", ""),
									userdata.get("zip"), "Major AR Zip");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString())
											.get("data.customer.autoorders.items.shipToAddress.address1").toString()
											.replace("[", "").replace("]", ""),
									userdata.get("address1"), "Major AR Address1");

							Assert.assertEquals(
									new JsonPath(OrdersResponse.toString())
											.get("data.customer.autoorders.items.shippingMethod.href").toString()
											.replace("[", "").replace("]", ""),
									"https://hydraqa.unicity.net/" + userdata.get("version") + "shippingmethods?"
											+ userdata.get("shippingmethod"),
									"Major AR Ship Method href");

							Assert.assertTrue(new JsonPath(OrdersResponse.toString()).get("data.customer.id.unicity")
									.toString().length() != 0, "Major Customer Account Number");
							childtest.log(LogStatus.INFO, "Account Number",
									new JsonPath(OrdersResponse.toString()).get("data.customer.id.unicity").toString());

							Assert.assertTrue(
									new JsonPath(OrdersResponse.toString())
											.get("data.customer.autoorders.items.id.unicity").toString()
											.replace("[", "").replace("]", "").length() != 0,
									"Major AR Number");

							childtest.log(LogStatus.INFO, "AR Number", new JsonPath(OrdersResponse.toString())
									.get("data.customer.autoorders.items.id.unicity").toString());

							Assert.assertTrue(new JsonPath(OrdersResponse.toString()).get("data.id.unicity").toString()
									.replace("[", "").replace("]", "").length() != 0, "Major AR Number");

							childtest.log(LogStatus.INFO, "Order ID",
									new JsonPath(OrdersResponse.toString()).get("data.id.unicity").toString());
						}

						if (userdata.get("version").equals("v5/")) {
							JSONObject OrdersResponse = new JSONObject(entry.getResponse().getContent().getText()
									.toString()
									.substring(entry.getResponse().getContent().getText().toString().indexOf("{"))
									.trim());
							Assert.assertEquals(
									((String) new JsonPath(OrdersResponse.toString()).get("data.error.error_message"))
											.split("#")[0],
									"Could not authorize and capture credit card payment. Error");
						}
					}
				}

				if (pack == "NoPack") {
					if (entry.getRequest().getUrl().contains("customers.js")) {
						System.out.println("Request URL: " + entry.getRequest().getUrl());
						System.out.println("Entry request : " + entry.getRequest().getPostData().getText());
						System.out.println("Entry response : " + entry.getResponse().getContent().getText());

						childtest.log(LogStatus.INFO, "Request Parameter", "");

						JSONObject Orders = new JSONObject(entry.getRequest().getPostData().getText().toString()
								.substring(entry.getRequest().getPostData().getText().toString().indexOf("{")).trim());

						Assert.assertEquals(new JsonPath(Orders.toString()).get("birthDate"),
								userdata.get("responsedob"), "Major Request DOB");

						if (Market == "Norway") {
							if (userdata.get("commission") == "DD") {
								Assert.assertEquals(
										new JsonPath(Orders.toString()).get("depositBankAccount.accountHolder"),
										userdata.get("holder"), "Major Account Holder");
								Assert.assertEquals(new JsonPath(Orders.toString()).get("depositBankAccount.bankName"),
										userdata.get("bankname"), "Major Bank name");
								Assert.assertEquals(new JsonPath(Orders.toString()).get("depositBankAccount.bic"),
										userdata.get("bic"), "Major BIC");
								Assert.assertEquals(
										new JsonPath(Orders.toString()).get("depositBankAccount.accountNumber"),
										userdata.get("iban"), "Major IBAN");
							}
						}

						Assert.assertEquals(
								new JsonPath(Orders.toString()).get("coapplicant.details.humanName.firstName"),
								userdata.get("coapplicant"), "Major Request coapplicant");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("email"), userdata.get("email"),
								"Major Request email");

						Assert.assertEquals(
								new JsonPath(Orders.toString()).get("enroller.href"), "https://hydraqa.unicity.net/"
										+ userdata.get("version") + "customers?id.unicity=" + userdata.get("enroller"),
								"Major Enroller href");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("gender"), userdata.get("gender"),
								"Major Request gender");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("homePhone"), userdata.get("phone"),
								"Major Request homePhone");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("humanName.firstName"),
								userdata.get("fname"), "Major Request firstName");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("humanName.lastName"),
								userdata.get("lname"), "Major Request lastName");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("mainAddress.address1"),
								userdata.get("address1"), "Major Request address1");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("mainAddress.address2"),
								userdata.get("address2"), "Major Request address2");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("mainAddress.city"),
								userdata.get("city"), "Major Request city");
						Assert.assertEquals(new JsonPath(Orders.toString()).get("mainAddress.country"),
								userdata.get("marketcode"), "Major Request country");

						if (Market == "India") {
							Assert.assertEquals(new JsonPath(Orders.toString()).get("mainAddress.state"), "KA",
									"Major Request state");
						}
						Assert.assertEquals(new JsonPath(Orders.toString()).get("mainAddress.zip"), userdata.get("zip"),
								"Major Request zip");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("maritalStatus"),
								userdata.get("martial"), "Major Request homePhone");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("preferredLocale"),
								userdata.get("locale") + "-" + userdata.get("marketcode"), "Major Preferred-Locale");

						if (Market == "India") {
							Assert.assertTrue(
									new JsonPath(Orders.toString()).get("signature.value").toString().length() != 0,
									"Major Signature");
						} else {
							Assert.assertEquals(new JsonPath(Orders.toString()).get("signature.value"),
									userdata.get("signature"), "Major Signature");
						}

						Assert.assertEquals(
								new JsonPath(Orders.toString()).get("sponsor.href"), "https://hydraqa.unicity.net/"
										+ userdata.get("version") + "customers?id.unicity=" + userdata.get("sponsor"),
								"Major sponsor href");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("status"), "Active", "Major Status");

						Assert.assertEquals(new JsonPath(Orders.toString()).get("type"), userdata.get("type"),
								"Major type");

						JSONObject OrdersResponse = new JSONObject(entry.getResponse().getContent().getText().toString()
								.substring(entry.getResponse().getContent().getText().toString().indexOf("{")).trim());

						childtest.log(LogStatus.INFO, "Response", "");

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.birthDate"),
								userdata.get("responsedob"), "Major Response DOB");

						Assert.assertEquals(
								new JsonPath(OrdersResponse.toString())
										.get("data.coapplicant.details.humanName.firstName"),
								userdata.get("coapplicant"), "Major Response coapplicant");

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.email"),
								userdata.get("email"), "Major Response email");

						Assert.assertEquals(
								String.valueOf(String.valueOf(
										new JsonPath(OrdersResponse.toString()).get("data.enroller.id.unicity"))),
								userdata.get("enroller"), "Major Response Enroller ");

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.gender"),
								userdata.get("gender"), "Major Response gender");

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.homePhone"),
								userdata.get("phone"), "Major Response homePhone");

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.humanName.firstName"),
								userdata.get("fname"), "Major Response firstName");
						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.humanName.lastName"),
								userdata.get("lname"), "Major Response lastName");

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.mainAddress.address1"),
								userdata.get("address1"), "Major Response address1");
						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.mainAddress.address2"),
								userdata.get("address2"), "Major Response address2");
						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.mainAddress.city"),
								userdata.get("city"), "Major Request city");
						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.mainAddress.country"),
								userdata.get("marketcode"), "Major Response country");
						if (Market == "India") {
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.mainAddress.state"),
									"KA", "Major Response state");
						}
						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.mainAddress.zip"),
								userdata.get("zip"), "Major Response zip");

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.maritalStatus"),
								userdata.get("martial"), "Major Response homePhone");

						if (Market == "India") {
							Assert.assertTrue(new JsonPath(OrdersResponse.toString()).get("data.password.value")
									.toString().length() != 0, "Major Response password");
							Assert.assertTrue(new JsonPath(OrdersResponse.toString()).get("data.id.unicity").toString()
									.length() != 0, "Major Response Order ID");
						} else {
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.password.value"),
									userdata.get("password"), "Major Response password");
						}

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.preferredLocale"),
								userdata.get("locale") + "-" + userdata.get("marketcode"), "Major Preferred-Locale");

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.signature.value"),
								userdata.get("signature"), "Major Response Signature");

						Assert.assertEquals(
								String.valueOf(String.valueOf(
										new JsonPath(OrdersResponse.toString()).get("data.sponsor.id.unicity"))),
								userdata.get("sponsor"), "Major Response sponsor ");

						if (Market == "India") {
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.status"), "Pending",
									"Major Status");
						} else {
							Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.status"), "Active",
									"Major Status");
						}

						Assert.assertEquals(new JsonPath(OrdersResponse.toString()).get("data.type"),
								userdata.get("type"), "Major Response type");
						if (Market == "Norwary") {
							Assert.assertEquals(NONopackAccountNumber.getText(),
									new JsonPath(OrdersResponse.toString()).get("data.id.unicity"));
						}
					}
				}
			}
		}

		Thread.sleep(5000);

		Assert.assertEquals(StartCertification.getText(), getTranslation("getfit_nextstep", language), "Low NextStep");
		Assert.assertEquals(Congratulations.getText(), getTranslation("getfit_congratulations", language),
				"Low Congratulations");
		Assert.assertEquals(RegisteredAsCoach.getText(), getTranslation("getfit_registered", language),
				"Low RegisteredAs coach");

		Assert.assertEquals(GetFitSucessMSG1.getText(), getTranslation("getfit_msg1", language), "Low MSG1");
		Assert.assertEquals(GetFitSucesMSG2.getText(), getTranslation("getfit_msg2", language), "Low MSG2");

		Assert.assertEquals(GetFitFName.getText(), userdata.get("fname"), "Low NextStep");
		Assert.assertEquals(GetFitLName.getText(), userdata.get("lname"), "Low Congratulations");
		Assert.assertEquals(GetFitEmail.getText(), userdata.get("email"), "Low RegisteredAs coach");
		Assert.assertEquals(GetFitAddress1.getText(), userdata.get("address1"), "Low address1");
		Assert.assertEquals(GetFitAddress2.getText(), userdata.get("address2"), "Low address2");
		Assert.assertEquals(GetFitCity.getText(), userdata.get("city"), "Low city");
		Assert.assertEquals(GetFitPostal.getText(), userdata.get("zip"), "Low zip");

		try {
			Boolean signin = SignInToCourseNow.isDisplayed();
			Assert.assertTrue(signin);
		} catch (Exception e) {
			Assert.fail("Major signin is not displaying");
		}

	}

}
