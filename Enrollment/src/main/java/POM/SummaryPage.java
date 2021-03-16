package POM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
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
import com.aventstack.extentreports.Status;
import Pages.SuperTestNG;

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

	@FindBy(xpath = "//span[contains(@ng-model, 'tax_id')]")
	private WebElement TaxID;

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

	@FindBy(id = "pp")
	private WebElement PP;

	@FindBy(id = "data_privacy")
	private WebElement DataPrivacy;

	@FindBy(id = "data_transfer")
	private WebElement DataTransfer;

	@FindBy(xpath = "//span[contains(text(), 'Account Number')]//following-sibling::span")
	private WebElement BankAccountNumber;

	@FindBy(xpath = "//span[contains(text(), 'Account Title')]//following-sibling::span")
	private WebElement BankAccountName;

	@FindBy(xpath = "//span[contains(text(), 'Bank Name')]//following-sibling::span")
	private WebElement IndiaBankName;

	@FindBy(xpath = "//span[contains(text(), 'Branch Name')]//following-sibling::span")
	private WebElement BranchName;

	@FindBy(xpath = "//span[contains(text(), 'IFSC')]//following-sibling::span")
	private WebElement IFSC;

	@FindBy(xpath = "//span[contains(text(), 'Opción de pago')]//following-sibling::span")
	private WebElement MXPayment;

	@FindBy(xpath = "//span[contains(text(), 'Nombre del banco')]//following-sibling::span")
	private WebElement MXBank;

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

	@FindBy(xpath = "(//div[contains(@class,'col-xs-5 text-right')])[5]")
	private WebElement GrandPV;

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
	
	@FindBy(xpath = "(//p[@ng-if='bean.order_number']//strong)[1]")
	private WebElement COOrderNumber;

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

	public void OrderSubmit(String Market, String language, String pack) throws IOException, InterruptedException {

		@SuppressWarnings("unused")
		int pvs = 0;
		if (!(Market == "India" || Market == "Turkey" || Market == "Colombia")) {
			pvs = Integer.parseInt(GrandPV.getText());
		}

		String sign = "TestSignature";

		Thread.sleep(10000);

		childtest.log(Status.INFO, "Summary");

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
		if (Market == "Turkey") {
			Assert.assertEquals(Labels.toString(), getTranslation("summary_tr", language),
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
		if (!(Market == "Turkey")) {
			Assert.assertEquals(Gender.getText(), userdata.get("genderoption"), "Major Summary Gender");
		}
		if (!(Market == "Austria" || Market == "Belgium" || Market == "Denmark" || Market == "France"
				|| Market == "Germany" || Market == "Hungary" || Market == "Italy" || Market == "Ireland"
				|| Market == "Luxembourg" || Market == "Netherlands" || Market == "Norway" || Market == "Poland"
				|| Market == "Sweden" || Market == "Switzerland" || Market == "Spain" || Market == "Ukraine"
				|| Market == "United Kingdom" || Market == "Turkey")) {
			Assert.assertEquals(Martial.getText(), userdata.get("maritaloption"), "Major Summary Marital");
		}

		if (!(Market == "Austria" || Market == "Belgium" || Market == "Canada" || Market == "Denmark"
				|| Market == "France" || Market == "Germany" || Market == "Hungary" || Market == "Italy"
				|| Market == "Ireland" || Market == "Luxembourg" || Market == "Mexico" || Market == "Netherlands"
				|| Market == "Norway" || Market == "Poland" || Market == "Sweden" || Market == "Switzerland"
				|| Market == "Spain" || Market == "Ukraine" || Market == "United Kingdom" || Market == "Turkey")) {
			Assert.assertEquals(GovID.getText(), userdata.get("govid"), "Major Summary GovID");
		}

		if (Market == "Mexico") {
			Assert.assertEquals(GovID.getText(), userdata.get("documentid"), "Summary CURP");
			Assert.assertEquals(RFC.getText(), userdata.get("govid"), "Major Summary RFC");
		}

		if (Market == "Turkey") {
			Assert.assertEquals(GovID.getText(), userdata.get("govid"), "Major Summary GovID");
			Assert.assertEquals(TaxID.getText(), "6111306880", "Major Summary TaxID");
		}
		if (Market == "Austria" || Market == "Belgium" || Market == "Denmark" || Market == "France"
				|| Market == "Germany" || Market == "Hungary" || Market == "Italy" || Market == "Ireland"
				|| Market == "Luxembourg" || Market == "Netherlands" || Market == "Norway" || Market == "Poland"
				|| Market == "Sweden" || Market == "Switzerland" || Market == "Spain" || Market == "Ukraine"
				|| Market == "United Kingdom" || Market == "Turkey") {
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
		if (!(Market == "India" || Market == "Turkey" || pack == "NoPack")) {
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
				if (userdata.get("paymenttype") == "bank") {
					Assert.assertEquals(MXBank.getText(), userdata.get("mxbank"), "Major MXBank");
				} else {
					Assert.assertEquals(CCName.getText(), userdata.get("ccname"), "Major Summary CCName");
				}
			}
		}
		if (Market == "United States" || Market == "Canada") {
			Assert.assertEquals(TermsandConditonsPDF.size(), 4, "Major Terms & Condition PDF's");
			childtest.log(Status.INFO, "Terms and Condtions PDF ->" + Integer.toString(TermsandConditonsPDF.size()));
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
			Assert.assertEquals(USShippingCity.getText(), "OREM", "Major Shipping City");
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

			Assert.assertEquals(BankAccountNumber.getText(), userdata.get("accountnumber"), "Major accountnumber");
			Assert.assertEquals(BankAccountName.getText(), userdata.get("holdername"), "Major holdername");
			Assert.assertEquals(IndiaBankName.getText(), userdata.get("bankname"), "Major bankname");
			Assert.assertEquals(BranchName.getText(), userdata.get("branch"), "Major branch");
			Assert.assertEquals(IFSC.getText(), userdata.get("ifsc"), "Major ifsc");
		}

		if (pack == "NoPack") {
			if (Market == "Norway" || Market == "Turkey") {
				Assert.assertEquals(ProfileBillingAddress1.getText(), userdata.get("address1"),
						"Major Billing Address1");
				Assert.assertEquals(ProfileBillingAddress2.getText(), userdata.get("address2"),
						"Major Billing Address 2");
				Assert.assertEquals(ProfileBillingCity.getText(), userdata.get("city"), "Major Billing City");
				Assert.assertEquals(ProfileBillingZip.getText(), userdata.get("zip"), "Major Billing Postal");
				/*
				 * Assert.assertEquals(ProfileBillingCountry.getText(),
				 * userdata.get("market"), "Major Billing Country");
				 */
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
		if (Market == "Turkey") {
			PP.click();
			DataPrivacy.click();
			DataTransfer.click();
		} else {
			Disclaimar.click();
		}
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

		if (!(Market == "India")) {
			if (Market == "Italy") {
				if (language == "Italiano"){
					childtest.log(Status.INFO, "Account Number ->" + ITAccountNumber.getText());
					childtest.log(Status.INFO, "Order Number ->" + ITOrderNumber.getText());
					childtest.log(Status.INFO, "AR Number ->" + ARNumber.getText());
				} else {
					childtest.log(Status.INFO, "Order Number ->" + OrderNumber.getText());
					childtest.log(Status.INFO, "Account Number ->" + AccountNumber.getText());
					childtest.log(Status.INFO, "AR Number ->" + ARNumber.getText());
				}

			} else if (!(Market == "Mexico" || Market == "Turkey" || Market == "Colombia" )){
				childtest.log(Status.INFO, "Order Number ->" + OrderNumber.getText());
				childtest.log(Status.INFO, "Account Number ->" + AccountNumber.getText());
				childtest.log(Status.INFO, "AR Number ->" + ARNumber.getText());
			}
		}
		
		if (Market == "Colombia") {
			childtest.log(Status.INFO, "Account Number ->"+ AccountNumber.getText());
			childtest.log(Status.INFO, "Order Number ->"+ COOrderNumber.getText());
		}
		
		if (Market == "Mexico") {
			childtest.log(Status.INFO, "Account Number ->"+ AccountNumber.getText());
			childtest.log(Status.INFO, "Order Number ->"+ MXOrderNumber.getText());

			if (userdata.get("paymenttype") == "bank") {
				try {
					Boolean paymentlink = MexicoBankPaymentLink.isDisplayed();
					Assert.assertTrue(paymentlink);
				} catch (Exception e) {
					Assert.fail("Major paymentlink is not displaying");
				}
			}
		}
		
		if (Market == "Turkey") {
			childtest.log(Status.INFO, "Order ID ->"+ NONopackAccountNumber.getText());
		}

		driver.findElement(By.cssSelector(".btn.btn-danger.uppercase")).click();
		if (userdata.get("testcase") == "normal") {
			Thread.sleep(5000);
			Assert.assertEquals(driver.getCurrentUrl(), url, "Low return url");
			String[] expected = { "Australia", "Austria", "Bahamas", "Belgium", "Cambodia ", "Canada ", "Colombia",
					"Denmark ", "Dominican Republic", "France", "Germany", "Hong Kong", "Hungary", "India", "Indonesia",
					"Italy", "Ireland", "Jamaica", "Japan", "Korea", "Laos", "Luxembourg", "Malaysia", "Mexico",
					"Netherlands", "New Zealand", "Norway", "Philippines", "Poland", "Puerto Rico ", "Singapore",
					"Sweden", "Switzerland", "Spain", "Taiwan", "Thailand", "United States", "Turkey", "Ukraine",
					"United Kingdom" };

			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Country.get(i).getText(), expected[i], "Major market is missing");
			}
		}

		if (userdata.get("testcase") == "hcp") {
			Thread.sleep(5000);
			Assert.assertEquals(driver.getCurrentUrl(), hcpflow, "Low return url");
			String[] expected = { "United States", "Canada ", };

			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Country.get(i).getText(), expected[i], "Major market is missing");
			}
		}

	}

	public void PCOrderSubmit(String Market, String language, String pack) throws IOException, InterruptedException {

		Thread.sleep(10000);

		childtest.log(Status.INFO, "Summary");

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
		
		childtest.log(Status.INFO, "Order Number ->" + OrderNumber.getText());
		childtest.log(Status.INFO, "Account Number ->" + AccountNumber.getText());
		childtest.log(Status.INFO, "AR Number ->" + ARNumber.getText());

		driver.findElement(By.cssSelector(".btn.btn-danger.uppercase")).click();

		Thread.sleep(5000);
		if (userdata.get("testcase") == "normal") {
			Assert.assertEquals(driver.getCurrentUrl(), url, "Low return url");
			String[] expected = { "Australia", "Austria", "Bahamas", "Belgium", "Cambodia ", "Canada ", "Colombia",
					"Denmark ", "Dominican Republic", "France", "Germany", "Hong Kong", "Hungary", "India", "Indonesia",
					"Italy", "Ireland", "Jamaica", "Japan", "Korea", "Laos", "Luxembourg", "Malaysia", "Mexico",
					"Netherlands", "New Zealand", "Norway", "Philippines", "Poland", "Puerto Rico ", "Singapore",
					"Sweden", "Switzerland", "Spain", "Taiwan", "Thailand", "United States", "Turkey", "Ukraine",
					"United Kingdom", };

			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Country.get(i).getText(), expected[i], "Major market is missing");
			}
		}

		if (userdata.get("testcase") == "PatientPortal") {
			Assert.assertEquals(driver.getCurrentUrl(), patientportal, "Low return url");
			String[] expected = { "United States", "Canada " };

			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Country.get(i).getText(), expected[i], "Major market is missing");
			}
		}
	}

	public void GetFitOrderSubmit(String Market, String language, String pack)
			throws IOException, InterruptedException {

		String sign = "TestSignature";

		Thread.sleep(10000);

		childtest.log(Status.INFO, "Summary");

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
			childtest.log(Status.INFO, "Terms and Condtions PDF ->" + Integer.toString(TermsandConditonsPDF.size()));
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
		/* System.out.println(userdata); */

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
		// Assert.assertEquals(GetFitAddress2.getText(),
		// userdata.get("address2"), "Low address2");
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
