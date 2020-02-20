package POM;

import java.io.IOException;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Pages.SuperTestNG;
import io.restassured.path.json.JsonPath;
import net.lightbody.bmp.core.har.HarEntry;

public class AccountSetupPage extends SuperTestNG {

	@FindBys(@FindBy(xpath = "//select[contains(@ng-model, 'language')]//option"))
	List<WebElement> Languages;

	@FindBys(@FindBy(xpath = ".//*[@id='mobile_country']"))
	List<WebElement> Code;

	@FindBy(xpath = "//select[contains(@ng-options, 'language')]/option[@selected = 'selected']")
	private WebElement SelectedLanguage;

	@FindBys(@FindBy(xpath = "(//input[@ng-change='noIDs()'])[2] | //span[contains(@class, 'stepper-title')]"))
	List<WebElement> NoIDS;

	@FindBy(xpath = "(//input[@ng-change='noIDs()'])[2]")
	private WebElement NoID;

	@FindBy(id = "enrollername")
	private WebElement EnrollerName;

	@FindBy(id = "sponsorname")
	private WebElement SponsorName;

	@FindBys(@FindBy(xpath = "//h2[contains(@class, 'heading')]"))
	List<WebElement> Headings;

	@FindBy(id = "enroller_id")
	private WebElement EnrollerID;

	@FindBy(id = "sponsor_id")
	private WebElement SponsorID;

	@FindBy(id = "firstname")
	private WebElement FirstName;

	@FindBy(id = "lastname")
	private WebElement LastName;
	
	@FindBy(xpath = "//li[contains(@ng-if, 'enrollerProfile')]//p[@class='ng-binding']")
	private WebElement Referral;

	@FindBy(id = "dob")
	private WebElement DOB;

	@FindBy(id = "mobile_Market")
	private WebElement MarketCode;

	@FindBy(id = "account_phone")
	private WebElement Phone;

	@FindBy(id = "account_mobile")
	private WebElement Mobile;

	@FindBy(xpath = "//input[@ng-model='account.phone']")
	private WebElement INPhone;

	@FindBy(xpath = "//input[@ng-model='account.email']")
	private WebElement Email;

	@FindBy(id = "account_fax")
	private WebElement Fax;

	@FindBy(id = "government_id")
	private WebElement GovernmentID;

	@FindBy(xpath = "//input[@ng-model='account.government_id_rfc']")
	private WebElement Rfc;

	@FindBys(@FindBy(name = "gender"))
	List<WebElement> Gender;

	@FindBy(name = "gender")
	private WebElement GenderSelection;

	@FindBys(@FindBy(name = "marital_status"))
	List<WebElement> Martial;

	@FindBy(name = "marital_status")
	private WebElement MartialSelection;

	@FindBy(xpath = "//input[@id='account_taxid']")
	private WebElement Tax;

	@FindBy(xpath = "//input[@id='account_tax_id']")
	private WebElement ITTax;

	@FindBy(id = "account_birthplace")
	private WebElement BirthPlace;

	@FindBys(@FindBy(xpath = "//input[contains(@id,'email_')]"))
	List<WebElement> EmailUpline;

	@FindBys(@FindBy(xpath = "//input[@ng-model='account.coapplicantType']"))
	List<WebElement> CoApplicant;

	@FindBy(id = "payment")
	private WebElement Spouse;

	@FindBy(xpath = "//input[contains(@ng-model, 'account.spouse')]")
	private WebElement SpouseName;

	@FindBy(id = "coapplicant")
	private WebElement Company;

	@FindBys(@FindBy(xpath = "//select[@id='companytype']//option"))
	List<WebElement> CompanyType;

	@FindBy(xpath = "//select[@id='companytype']")
	private WebElement Selectcompanytype;

	@FindBy(xpath = "//input[@ng-model='account.companyname']")
	private WebElement CompanyName;

	@FindBys(@FindBy(xpath = "//input[contains(@ng-model, 'PaymentType')]"))
	List<WebElement> Commission;

	@FindBy(css = "input[value='Paylution']")
	private WebElement Paylution;

	@FindBy(id = "DirectDeposit")
	private WebElement DirectDeposit;

	@FindBy(id = "account_accountNumber")
	private WebElement IBAN;

	@FindBy(id = "account_bankName")
	private WebElement BankName;

	@FindBy(id = "account_accountHolder")
	private WebElement AccHolder;

	@FindBy(id = "account_bin")
	private WebElement BIC;

	@FindBys(@FindBy(xpath = "//input[@type='password']"))
	List<WebElement> Password;

	@FindBys(@FindBy(xpath = "//select[@ng-model='account.relationship']//option"))
	List<WebElement> Relation;

	@FindBy(name = "relationship")
	private WebElement SelectRelation;

	@FindBy(id = "address_line_1")
	private WebElement Address1;

	@FindBy(id = "address_line_2")
	private WebElement Address2;

	@FindBy(xpath = "(//input[@ng-model='account.address.postal_code'])")
	private WebElement PostalCode;

	@FindBy(id = "address_city")
	private WebElement City;

	@FindBy(xpath = "//select[@id='address_state']")
	private WebElement State;

	@FindBys(@FindBy(xpath = "//select[@id='address_state']//option"))
	List<WebElement> IndiaState;

	@FindBy(xpath = "//button[contains(@class, 'continue-btn')]")
	private WebElement Continue;

	public AccountSetupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void AccountDetails(String Market, String language, String pack)
			throws InterruptedException, JSONException, UnknownHostException, IOException {

		LocalDate startDate = LocalDate.of(1990, 1, 1); // start date
		long start = startDate.toEpochDay();

		LocalDate endDate = LocalDate.of(2001, 1, 1); // end date
		long end = endDate.toEpochDay();

		long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();

		LocalDate responsedob = LocalDate.ofEpochDay(randomEpochDay);
		userdata.put("responsedob", responsedob.toString());

		String eu = responsedob.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		String us = responsedob.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

		String referral = "2";
		String fname = "TestFirstName";
		String lname = "TestLastName";
		String ifname = RandomStringUtils.randomAlphabetic(6).toUpperCase();
		String ilname = RandomStringUtils.randomAlphabetic(6).toUpperCase();
		String phone = "9823746323";
		String indphone = "789" + RandomStringUtils.randomNumeric(7);
		String fax = "8217647322";
		String email = RandomStringUtils.randomAlphabetic(6).toUpperCase() + "@gmail.com";
		// String govid = "987168767";
		String govid = RandomStringUtils.randomNumeric(9);
		String itgovid = "IT" + RandomStringUtils.randomNumeric(14);
		String curp = "SABC" + RandomStringUtils.randomNumeric(6) + "MDFLRN" + RandomStringUtils.randomNumeric(2);
		String rfc = RandomStringUtils.randomAlphabetic(4).toUpperCase() + RandomStringUtils.randomNumeric(7)
				+ RandomStringUtils.randomAlphabetic(1).toUpperCase() + RandomStringUtils.randomNumeric(1);
		String pan = "DCMPS" + RandomStringUtils.randomNumeric(4) + "N";
		String spouse = "TestSpouseName";
		String company = "TestCompanyName";
		String ddmmyyyy = eu;
		String mmddyyyy = us;
		String birthplace = "TestBirthPlace";
		String tax = RandomStringUtils.randomNumeric(11);

		String ATIBAN = "AT611904300234573201";
		String BEIBAN = "BE68539007547034";
		String DNIBAN = "DK5000400440116243";
		String FRIBAN = "FR1420041010050500013M02606";
		String DEIBAN = "DE89370400440532013000";
		String HUIBAN = "HU42117730161111101800000000";
		String ITIBAN = "IT60X0542811101000000123456";
		String IRIBAN = "IE29AIBK93115212345678";
		String LXIBAN = "LU280019400644750000";
		String NLIBAN = "NL91ABNA0417164300";
		String NOIBAN = "NO9386011117947";
		String PLIBAN = "PL27114020040000300201355387";
		String SEIBAN = "SE3550000000054910000003";
		String CHIBAN = "CH9300762011623852957";
		String SPIBAN = "ES9121000418450200051332";
		String UAIBAN = "UA213996220000026007233566001";
		String GBIBAN = "GB29NWBK60161331926819";

		String bankname = "TestBankName";
		String holder = "TestName";
		String bic = "DEUTDEFF";
		String password = "Unicity";

		childtest.log(LogStatus.INFO, "Account Set-UP", "");

		Assert.assertEquals(SelectedLanguage.getText(), language, "Minor Selected Langauge");
		childtest.log(LogStatus.INFO, "", SelectedLanguage.getText());

		if (Market == "Australia" || Market == "Bahamas" || Market == "India" || Market == "Ireland"
				|| Market == "Jamaica" || Market == "New Zealand" || Market == "United Kingdom") {
			String[] expected = { "English" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}
		}

		if (Market == "Austria") {
			String[] expected = { "English", "Deutsch" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

			for (WebElement Symbol : Code) {
				String countrycode = Symbol.getText();
				Assert.assertEquals(countrycode, "+43");
			}
		}

		if (Market == "Bahamas") {
			String[] expected = { "English" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}
		}

		if (Market == "Belgium") {
			String[] expected = { "Français", "Dutch", "English" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

			for (WebElement Symbol : Code) {
				String countrycode = Symbol.getText();
				Assert.assertEquals(countrycode, "+32");
			}
		}

		if (Market == "Canada") {
			String[] expected = { "English", "Français" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}
		}

		if (Market == "Colombia" || Market == "Dominican Republic" || Market == "Mexico") {
			String[] expected = { "Español" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}
		}

		if (Market == "Denmark") {
			String[] expected = { "English", "Danish" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

			for (WebElement Symbol : Code) {
				String countrycode = Symbol.getText();
				Assert.assertEquals(countrycode, "+45");
			}
		}

		if (Market == "France") {
			String[] expected = { "Français", "English" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

			for (WebElement Symbol : Code) {
				String countrycode = Symbol.getText();
				Assert.assertEquals(countrycode, "+33");
			}
		}

		if (Market == "Germany") {
			String[] expected = { "Deutsch", "English" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

			for (WebElement Symbol : Code) {
				String countrycode = Symbol.getText();
				Assert.assertEquals(countrycode, "+49");
			}
		}

		if (Market == "Hungary") {
			String[] expected = { "English", "Hungarian" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

			for (WebElement Symbol : Code) {
				String countrycode = Symbol.getText();
				Assert.assertEquals(countrycode, "+36");
			}
		}

		if (Market == "Italy") {
			String[] expected = { "Italiano", "English" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

			for (WebElement Symbol : Code) {
				String countrycode = Symbol.getText();
				Assert.assertEquals(countrycode, "+39");
			}
		}

		if (Market == "Ireland") {
			String[] expected = { "English" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

			for (WebElement Symbol : Code) {
				String countrycode = Symbol.getText();
				Assert.assertEquals(countrycode, "+353");
			}
		}

		if (Market == "Luxembourg") {
			String[] expected = { "Français", "English", "Deutsch" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

			for (WebElement Symbol : Code) {
				String countrycode = Symbol.getText();
				Assert.assertEquals(countrycode, "+352");
			}
		}

		if (Market == "Netherlands") {
			String[] expected = { "English", "Dutch" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

			for (WebElement Symbol : Code) {
				String countrycode = Symbol.getText();
				Assert.assertEquals(countrycode, "+31");
			}
		}

		if (Market == "Norway") {
			String[] expected = { "English", "Norwegian" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

			for (WebElement Symbol : Code) {
				String countrycode = Symbol.getText();
				Assert.assertEquals(countrycode, "+47");
			}
		}

		if (Market == "Poland") {
			String[] expected = { "English", "Polish" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

			for (WebElement Symbol : Code) {
				String countrycode = Symbol.getText();
				Assert.assertEquals(countrycode, "+48");
			}
		}

		if (Market == "Puerto Rico") {
			String[] expected = { "Español", "English" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

		}

		if (Market == "Sweden") {
			String[] expected = { "Svenska", "English" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

			for (WebElement Symbol : Code) {
				String countrycode = Symbol.getText();
				Assert.assertEquals(countrycode, "+46");
			}
		}

		if (Market == "Switzerland") {
			String[] expected = { "Deutsch", "English", "Français", "Italiano" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

			for (WebElement Symbol : Code) {
				String countrycode = Symbol.getText();
				Assert.assertEquals(countrycode, "+41");
			}
		}

		if (Market == "Spain") {
			String[] expected = { "English", "Español" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

		}

		if (Market == "United States") {
			String[] expected = { "English", "Español" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}
		}

		if (Market == "Ukraine") {
			String[] expected = { "English", "русский" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

			for (WebElement Symbol : Code) {
				String countrycode = Symbol.getText();
				Assert.assertEquals(countrycode, "+380");
			}
		}

		if (Market == "United Kingdom") {
			String[] expected = { "English" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

			for (WebElement Symbol : Code) {
				String countrycode = Symbol.getText();
				Assert.assertEquals(countrycode, "+44");
			}
		}

		if (Market == "India") {
			String[] expected = { "English" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}

			for (WebElement Symbol : Code) {
				String countrycode = Symbol.getText();
				Assert.assertEquals(countrycode, "+91");
			}
		}

		ArrayList<String> Labels = new ArrayList<String>();

		for (int i = 0; i < Headings.size() - 1; i++) {
			Labels.add(Headings.get(i).getText());
		}

		if (!(Market == "Belgium" || Market == "Denmark" || Market == "Germany" || Market == "Ireland"
				|| Market == "Luxembourg" || Market == "Sweden" || Market == "Spain" || Market == "Bahamas"
				|| Market == "Canada" || Market == "Colombia" || Market == "Dominican Republic" || Market == "Jamaica"
				|| Market == "Puerto Rico" || Market == "United States" || Market == "Norway" || Market == "Italy"
				|| Market == "India" || Market == "Mexico" || Market == "Switzerland")) {
			Assert.assertEquals(Labels.toString(), getTranslation("eu", language), "Minor Lables");
		}

		if (Market == "Italy") {
			Assert.assertEquals(Labels.toString(), getTranslation("it", language), "Minor Lables");
		}

		if (Market == "Belgium" || Market == "Denmark" || Market == "Germany" || Market == "Ireland"
				|| Market == "Sweden" || Market == "Spain") {
			Assert.assertEquals(Labels.toString(), getTranslation("eu_a", language), "Minor Lables");
		}

		if (Market == "Luxembourg") {
			Assert.assertEquals(Labels.toString(), getTranslation("eu_lx", language), "Minor Lables");
		}

		if (Market == "Switzerland") {
			Assert.assertEquals(Labels.toString(), getTranslation("eu_ch", language), "Minor Lables");
		}

		if (Market == "Bahamas" || Market == "Canada" || Market == "Dominican Republic"
				|| Market == "Jamaica" || Market == "Puerto Rico" || Market == "United States" || Market == "Mexico") {
			Assert.assertEquals(Labels.toString(), getTranslation("us", language), "Minor Lables");
		}
		
		if (Market == "Colombia"){
			Assert.assertEquals(Labels.toString(), getTranslation("co", language), "Minor Lables");
		}

		if (Market == "Norway") {
			if (pack == "Pack") {
				Assert.assertEquals(Labels.toString(), getTranslation("no", language), "Minor Lables");
			} else {
				Assert.assertEquals(Labels.toString(), getTranslation("no_nopack", language), "Minor Lables");
			}
		}

		if (Market == "India") {
			Assert.assertEquals(Labels.toString(), getTranslation("in", language), "Minor Lables");
		}

		if (userdata.get("testcase") == "normal" || userdata.get("testcase") == "hcp") {

			if (Market == "Bahamas" || Market == "Dominican Republic" || Market == "Jamaica"
					|| Market == "United States") {

				try {
					Boolean NoReferralID = NoID.isDisplayed();
					Assert.assertTrue(NoReferralID);

					NoID.click();

					childtest.log(LogStatus.INFO, "", "No Enroller & Sponsor");

					Boolean Enroller = EnrollerName.isDisplayed();
					Assert.assertTrue(Enroller, "Major Enroller In Summay");

					Boolean Sponsor = SponsorName.isDisplayed();
					Assert.assertTrue(Sponsor, "Major Sponsor In Summay");

					childtest.log(LogStatus.INFO, "", "No Enroller & Sponsor text box is displaying");

					NoID.click();
				} catch (Exception e) {
					Assert.fail("Major NoReferralID is not Displaying");
				}
			}

			if (Market == "Bahamas" || Market == "Dominican Republic" || Market == "Jamaica"
					|| Market == "United States") {
				String[] xpath = { "(//input[@ng-change='noIDs()'])[2]", "//span[contains(@class, 'stepper-title')]" };

				Random random = new Random();
				int index = random.nextInt(xpath.length);
				NoIDS.get(index).click();

				Boolean Enroller = NoID.isSelected();
				if (Enroller == true) {
					EnrollerName.sendKeys("EnrollerTest");
					SponsorName.sendKeys("SponsorTest");
					userdata.put("enroller", "2");
					userdata.put("sponsor", "2");
					userdata.put("enrollerName", "EnrollerTest");
					userdata.put("sponsorName", "SponsorTest");
					userdata.put("api", "1");
					userdata.put("referral", "no");
				} else {
					EnrollerID.sendKeys(referral + Keys.TAB);
					SponsorID.sendKeys(referral + Keys.TAB);
					Thread.sleep(5000);
					childtest.log(LogStatus.INFO, "Enroller", referral);
					childtest.log(LogStatus.INFO, "Sponsor", referral);
					userdata.put("enroller", referral);
					userdata.put("sponsor", referral);
					userdata.put("api", "7");
					userdata.put("referral", "yes");
				}
			}

			if (!(Market == "Bahamas" || Market == "Colombia" || Market == "Dominican Republic" || Market == "Jamaica"
					|| Market == "India" || Market == "Mexico" || Market == "United States")) {
				EnrollerID.sendKeys(referral + Keys.TAB);
				SponsorID.sendKeys(referral + Keys.TAB);
				Thread.sleep(5000);
				childtest.log(LogStatus.INFO, "", referral);
				childtest.log(LogStatus.INFO, "", referral);
				userdata.put("enroller", referral);
				userdata.put("sponsor", referral);
				userdata.put("api", "7");
				userdata.put("referral", "yes");
			}
		} else {
			Thread.sleep(5000);
			childtest.log(LogStatus.INFO, "Enroller", referral);
			childtest.log(LogStatus.INFO, "Sponsor", referral);
			userdata.put("enroller", referral);
			userdata.put("sponsor", referral);
			userdata.put("api", "3");
			userdata.put("referral", "yes");
		}

		if (Market == "India" || Market == "Mexico" || Market == "Colombia") {
			EnrollerID.sendKeys(referral + Keys.TAB);
			SponsorID.sendKeys(referral + Keys.TAB);
			Thread.sleep(5000);
			childtest.log(LogStatus.INFO, "", referral);
			childtest.log(LogStatus.INFO, "", referral);
			userdata.put("enroller", referral);
			userdata.put("sponsor", referral);
			userdata.put("api", "8");
		}

		userdata.put("language", language);
		userdata.put("type", "Associate");

		Thread.sleep(10000);
		
		Assert.assertEquals(Referral.getText(), referral);

		List<HarEntry> entries = server.getHar().getLog().getEntries();
		for (HarEntry entry : entries) {
			if (entry.getRequest().getMethod().equals("GET")) {
				if (entry.getRequest().getUrl().contains("customers.js?callback=angular.callbacks._1")) {

					System.out.println("Request URL: " + entry.getRequest().getUrl());
					// System.out.println("Entry response : " +
					// entry.getResponse().getContent().getText());

					JSONObject referraldata = new JSONObject(entry.getResponse().getContent().getText().toString()
							.substring(entry.getResponse().getContent().getText().toString().indexOf("{")).trim());
					Assert.assertEquals(userdata.get("proto") + userdata.get("version")
							+ "customers.js?callback=angular.callbacks._1&expand=customer,profilePicture&id.unicity="
							+ userdata.get("enroller"), entry.getRequest().getUrl(), "Major Customer.js URL");
					Assert.assertTrue(new JsonPath(referraldata.toString()).get("data.items.href").toString()
							.contains("hydraqa.unicity.net"), "Major Customer Hydra");
					childtest.log(LogStatus.INFO, "Enroller",
							"<a href=" + entry.getRequest().getUrl() + ">Customer.js</a>");
				}
			}
		}

		if (!(Market == "India")) {
			FirstName.sendKeys(fname);
			LastName.sendKeys(lname);
			childtest.log(LogStatus.INFO, "", fname);
			childtest.log(LogStatus.INFO, "", lname);
			userdata.put("fname", fname);
			userdata.put("lname", lname);
		} else {
			FirstName.sendKeys(ifname);
			LastName.sendKeys(ilname);
			childtest.log(LogStatus.INFO, "", ifname);
			childtest.log(LogStatus.INFO, "", ilname);
			userdata.put("fname", ifname);
			userdata.put("lname", ilname);
		}

		if (Market == "Australia" || Market == "Austria" || Market == "Belgium" || Market == "Colombia" || Market == "Denmark"
				|| Market == "France" || Market == "Germany" || Market == "Hungary" || Market == "India"
				|| Market == "Italy" || Market == "Ireland" || Market == "Luxembourg" || Market == "Mexico"
				|| Market == "Netherlands" || Market == "New Zealand" || Market == "Norway" || Market == "Poland"
				|| Market == "Sweden" || Market == "Switzerland" || Market == "Spain" || Market == "Ukraine"
				|| Market == "United Kingdom") {
			DOB.sendKeys(ddmmyyyy);
			childtest.log(LogStatus.INFO, "", ddmmyyyy);
			userdata.put("dob", ddmmyyyy);
		}
		if (Market == "Bahamas" || Market == "Canada" || Market == "Dominican Republic"
				|| Market == "Jamaica" || Market == "Puerto Rico" || Market == "United States") {
			DOB.sendKeys(mmddyyyy);
			childtest.log(LogStatus.INFO, "", mmddyyyy);
			userdata.put("dob", mmddyyyy);
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

		if (!(Market == "India" || Market == "Switzerland")) {
			Phone.sendKeys(phone);
			childtest.log(LogStatus.INFO, "", phone);
			userdata.put("phone", phone);
		}

		if (Market == "Switzerland") {
			Mobile.sendKeys(phone);
			childtest.log(LogStatus.INFO, "", phone);
			userdata.put("phone", phone);
		}

		if (Market == "India") {
			INPhone.sendKeys(indphone);
			childtest.log(LogStatus.INFO, "", indphone);
			userdata.put("phone", indphone);
		}

		if (Market == "Austria" || Market == "Belgium" || Market == "Denmark" || Market == "France"
				|| Market == "Germany" || Market == "Hungary" || Market == "Italy" || Market == "Ireland"
				|| Market == "Luxembourg" || Market == "Netherlands" || Market == "Norway" || Market == "Poland"
				|| Market == "Sweden" || Market == "Switzerland" || Market == "Spain" || Market == "Ukraine"
				|| Market == "United Kingdom") {
			Fax.sendKeys(fax);
			childtest.log(LogStatus.INFO, "", fax);
			userdata.put("fax", fax);
		}

		Email.sendKeys(email + Keys.TAB);
		childtest.log(LogStatus.INFO, "", email);
		userdata.put("email", email);
		Thread.sleep(5000);

		if (!(Market == "Austria" || Market == "Belgium" || Market == "Canada" || Market == "Denmark"
				|| Market == "France" || Market == "Germany" || Market == "Hungary" || Market == "India"
				|| Market == "Ireland" || Market == "Luxembourg" || Market == "Mexico" || Market == "Netherlands"
				|| Market == "Norway" || Market == "Poland" || Market == "Sweden" || Market == "Switzerland"
				|| Market == "Spain" || Market == "Ukraine" || Market == "United Kingdom" || Market == "Italy")) {
			GovernmentID.sendKeys(govid);
			childtest.log(LogStatus.INFO, "", govid);
			userdata.put("govid", govid);
		}

		if (Market == "Italy") {
			BirthPlace.sendKeys(birthplace);
			GovernmentID.sendKeys(itgovid);
			childtest.log(LogStatus.INFO, "", birthplace);
			childtest.log(LogStatus.INFO, "", itgovid);
			userdata.put("birthplace", birthplace);
			userdata.put("documentid", itgovid);
		}

		if (Market == "Mexico") {
			GovernmentID.sendKeys(curp);
			Rfc.sendKeys(rfc);
			childtest.log(LogStatus.INFO, "", curp);
			childtest.log(LogStatus.INFO, "", rfc);
			userdata.put("documentid", curp);
			userdata.put("govid", rfc);
		}
		if (Market == "India") {
			GovernmentID.sendKeys(pan);
			childtest.log(LogStatus.INFO, "", pan);
			userdata.put("govid", pan);
		}
		if (Market == "Austria" || Market == "Belgium" || Market == "Denmark" || Market == "France"
				|| Market == "Germany" || Market == "Hungary" || Market == "Italy" || Market == "Ireland"
				|| Market == "Luxembourg" || Market == "Netherlands" || Market == "Norway" || Market == "Poland"
				|| Market == "Sweden" || Market == "Switzerland" || Market == "Spain" || Market == "Ukraine"
				|| Market == "United Kingdom") {
			jse.executeScript("window.scrollBy(0,250)", "");
			EmailUpline.get(new Random().nextInt(EmailUpline.size())).click();
		}
		int value = new Random().nextInt(Gender.size());
		Gender.get(value).click();
		userdata.put("genderoption", Gender.get(value).getAttribute("value"));
		userdata.put("gender", getTranslation(Gender.get(value).getAttribute("value"), language));

		if (!(Market == "Austria" || Market == "Belgium" || Market == "Denmark" || Market == "France"
				|| Market == "Germany" || Market == "Hungary" || Market == "Italy" || Market == "Ireland"
				|| Market == "Luxembourg" || Market == "Netherlands" || Market == "Norway" || Market == "Poland"
				|| Market == "Sweden" || Market == "Switzerland" || Market == "Spain" || Market == "Ukraine"
				|| Market == "United Kingdom")) {
			int mvalue = new Random().nextInt(Martial.size());
			Martial.get(mvalue).click();
			userdata.put("maritaloption", Martial.get(mvalue).getAttribute("value"));
			userdata.put("martial", getTranslation(Martial.get(mvalue).getAttribute("value"), language));
		}

		if (Market == "Australia" || Market == "Austria" || Market == "Belgium" || Market == "Denmark"
				|| Market == "France" || Market == "Germany" || Market == "Hungary" || Market == "Ireland"
				|| Market == "Luxembourg" || Market == "Netherlands" || Market == "New Zealand" || Market == "Poland"
				|| Market == "Sweden" || Market == "Switzerland" || Market == "Spain" || Market == "Ukraine"
				|| Market == "United Kingdom") {
			Thread.sleep(5000);
			jse.executeScript("window.scrollBy(0,250)", "");
			String[] coapplicant = { "Spouse", "Company" };
			for (int i = 0; i < coapplicant.length; i++) {
				Assert.assertEquals(CoApplicant.get(i).getAttribute("name"), coapplicant[i]);
			}
			CoApplicant.get(new Random().nextInt(CoApplicant.size())).click();

			if (Spouse.isSelected()) {
				SpouseName.sendKeys(spouse);
				childtest.log(LogStatus.INFO, "", spouse);
				userdata.put("coapplicanttype", "Spouse");
				userdata.put("coapplicant", spouse);
			}

			if (Company.isSelected()) {
				CompanyName.sendKeys(company);
				childtest.log(LogStatus.INFO, "", company);
				userdata.put("coapplicanttype", "company");
				userdata.put("coapplicant", company);
				if (Market == "Austria" || Market == "Belgium" || Market == "Denmark" || Market == "France"
						|| Market == "Germany" || Market == "Hungary" || Market == "Ireland" || Market == "Luxembourg"
						|| Market == "Netherlands" || Market == "Poland" || Market == "Sweden"
						|| Market == "Switzerland" || Market == "Spain" || Market == "Ukraine"
						|| Market == "United Kingdom") {

					String[] b = { "1", "2", "3", "4", };
					Select selectshipstate = new Select(Selectcompanytype);
					String u = b[new Random().nextInt(b.length)];
					int v = Integer.parseInt(u) - 1;
					selectshipstate.selectByValue(Integer.toString(v));

					userdata.put("companynametype", CompanyType.get(Integer.parseInt(u)).getText());
				}
			}
		}

		if (Market == "Bahamas" || Market == "Canada" || Market == "Dominican Republic" || Market == "India"
				|| Market == "Colombia" || Market == "Dominican Republic" || Market == "Jamaica" || Market == "Mexico"
				|| Market == "Puerto Rico" || Market == "United States") {
			SpouseName.sendKeys(spouse);
			childtest.log(LogStatus.INFO, "", spouse);
			userdata.put("coapplicant", spouse);
			userdata.put("coapplicanttype", "Spouse");
		}

		if (Market == "Norway") {
			Tax.sendKeys(tax);
			childtest.log(LogStatus.INFO, "", tax);
			userdata.put("govid", tax);
		}

		if (Market == "Italy") {
			ITTax.sendKeys("IT" + tax);
			childtest.log(LogStatus.INFO, "", tax);
			userdata.put("govid", "IT" + tax);
		}

		if (Market == "Austria" || Market == "Belgium" || Market == "Denmark" || Market == "France"
				|| Market == "Germany" || Market == "Hungary" || Market == "Italy" || Market == "Ireland"
				|| Market == "Luxembourg" || Market == "Netherlands" || Market == "Norway" || Market == "Poland"
				|| Market == "Sweden" || Market == "Switzerland" || Market == "Spain" || Market == "Ukraine"
				|| Market == "United Kingdom") {
			jse.executeScript("window.scrollBy(0,250)", "");
			String[] commission = { "Paylution", "DirectDeposit" };
			for (int i = 0; i < commission.length; i++) {
				Assert.assertEquals(Commission.get(i).getAttribute("value"), commission[i]);
			}
			Commission.get(new Random().nextInt(Commission.size())).click();

			if (DirectDeposit.isSelected()) {
				if (Market == "Austria") {
					IBAN.sendKeys(ATIBAN);
					childtest.log(LogStatus.INFO, "", ATIBAN);
					userdata.put("iban", ATIBAN);
					userdata.put("commission", "DD");
				}
				if (Market == "Belgium") {
					IBAN.sendKeys(BEIBAN);
					childtest.log(LogStatus.INFO, "", BEIBAN);
					userdata.put("iban", BEIBAN);
					userdata.put("commission", "DD");
				}
				if (Market == "Denmark") {
					IBAN.sendKeys(DNIBAN);
					childtest.log(LogStatus.INFO, "", DNIBAN);
					userdata.put("iban", DNIBAN);
					userdata.put("commission", "DD");
				}
				if (Market == "France") {
					IBAN.sendKeys(FRIBAN);
					childtest.log(LogStatus.INFO, "", FRIBAN);
					userdata.put("iban", FRIBAN);
					userdata.put("commission", "DD");
				}
				if (Market == "Germany") {
					IBAN.sendKeys(DEIBAN);
					childtest.log(LogStatus.INFO, "", DEIBAN);
					userdata.put("iban", DEIBAN);
					userdata.put("commission", "DD");
				}
				if (Market == "Hungary") {
					IBAN.sendKeys(HUIBAN);
					childtest.log(LogStatus.INFO, "", HUIBAN);
					userdata.put("iban", HUIBAN);
					userdata.put("commission", "DD");
				}
				if (Market == "Italy") {
					IBAN.sendKeys(ITIBAN);
					childtest.log(LogStatus.INFO, "", ITIBAN);
					userdata.put("iban", ITIBAN);
					userdata.put("commission", "DD");
				}
				if (Market == "Ireland") {
					IBAN.sendKeys(IRIBAN);
					childtest.log(LogStatus.INFO, "", IRIBAN);
					userdata.put("iban", IRIBAN);
					userdata.put("commission", "DD");
				}
				if (Market == "Luxembourg") {
					IBAN.sendKeys(LXIBAN);
					childtest.log(LogStatus.INFO, "", LXIBAN);
					userdata.put("iban", LXIBAN);
					userdata.put("commission", "DD");
				}
				if (Market == "Netherlands") {
					IBAN.sendKeys(NLIBAN);
					childtest.log(LogStatus.INFO, "", NLIBAN);
					userdata.put("iban", NLIBAN);
					userdata.put("commission", "DD");
				}
				if (Market == "Norway") {
					IBAN.sendKeys(NOIBAN);
					childtest.log(LogStatus.INFO, "", NOIBAN);
					userdata.put("iban", NOIBAN);
					userdata.put("commission", "DD");
				}
				if (Market == "Poland") {
					IBAN.sendKeys(PLIBAN);
					childtest.log(LogStatus.INFO, "", PLIBAN);
					userdata.put("iban", PLIBAN);
					userdata.put("commission", "DD");
				}
				if (Market == "Sweden") {
					IBAN.sendKeys(SEIBAN);
					childtest.log(LogStatus.INFO, "", SEIBAN);
					userdata.put("iban", SEIBAN);
					userdata.put("commission", "DD");
				}
				if (Market == "Switzerland") {
					IBAN.sendKeys(CHIBAN);
					childtest.log(LogStatus.INFO, "", CHIBAN);
					userdata.put("iban", CHIBAN);
					userdata.put("commission", "DD");
				}
				if (Market == "Spain") {
					IBAN.sendKeys(SPIBAN);
					childtest.log(LogStatus.INFO, "", SPIBAN);
					userdata.put("iban", SPIBAN);
					userdata.put("commission", "DD");
				}
				if (Market == "Ukraine") {
					IBAN.sendKeys(UAIBAN);
					childtest.log(LogStatus.INFO, "", UAIBAN);
					userdata.put("iban", UAIBAN);
					userdata.put("commission", "DD");
				}
				if (Market == "United Kingdom") {
					IBAN.sendKeys(GBIBAN);
					childtest.log(LogStatus.INFO, "", GBIBAN);
					userdata.put("iban", GBIBAN);
					userdata.put("commission", "DD");
				}
				BankName.sendKeys(bankname);
				AccHolder.sendKeys(holder);
				BIC.sendKeys(bic);
				childtest.log(LogStatus.INFO, "", bankname);
				childtest.log(LogStatus.INFO, "", holder);
				childtest.log(LogStatus.INFO, "", bic);
				userdata.put("bankname", bankname);
				userdata.put("holder", holder);
				userdata.put("bic", bic);
			}
		}

		if (!(Market == "India")) {
			for (int i = 0; i < Password.size(); i++) {
				Password.get(i).sendKeys(password);
			}
			childtest.log(LogStatus.INFO, "", password);
			userdata.put("password", password);
		}

		if (Market == "India") {
			String[] relation = { "", "Spouse", "Child", "Parent", "Sibling", };
			for (int i = 0; i < relation.length; i++) {
				Assert.assertEquals(Relation.get(i).getText(), relation[i]);
			}

			String[] indrelation = { "Spouse", "Child", "Parent", "Sibling", };
			Select selectrelation = new Select(SelectRelation);
			selectrelation.selectByValue(indrelation[new Random().nextInt(indrelation.length)]);

			Address1.sendKeys("23/2 2nd Floor");
			Address2.sendKeys("Haudin Road");
			City.sendKeys("Bangalore");
			Select selectStates = new Select(State);
			selectStates.selectByIndex(17);
			PostalCode.sendKeys("560050");

			String[] State = { "Select a state", "Andaman and Nicobar Islands", "Andhra Pradesh", "Arunachal Pradesh",
					"Assam", "Bihar", "Chandigarh", "Chhattisgarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi",
					"Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka",
					"Kerala", "Lakshadweep", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram",
					"Nagaland", "Orissa", "Pondicherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana",
					"Tripura", "Uttar Pradesh", "Uttaranchal", "West Bengal" };
			for (int i = 0; i < State.length; i++) {
				Assert.assertEquals(IndiaState.get(i).getText(), State[i]);
			}

			userdata.put("address1", "23/2 2nd Floor");
			userdata.put("address2", "Haudin Road");
			userdata.put("city", "Bangalore");
			userdata.put("zip", "560050");
		}

		for (HarEntry entry : entries) {
			if (entry.getRequest().getMethod().equals("GET")) {
				if (entry.getRequest().getUrl().contains("https://")) {
					if (entry.getRequest().getUrl().contains("&email")) {
						System.out.println("Request URL: " + entry.getRequest().getUrl());
						// System.out.println("Entry response : " +
						// entry.getResponse().getContent().getText());
						Assert.assertEquals(
								userdata.get("proto") + userdata.get("version")
										+ "customers.js?_httpMethod=HEAD&callback=angular.callbacks._"
										+ userdata.get("api") + "&email=" + userdata.get("email"),
								entry.getRequest().getUrl(), "Major Email.js URL");
						childtest.log(LogStatus.INFO, "", "<a href=" + entry.getRequest().getUrl() + ">Email.js</a>");
					}
				}
			}
		}

		if (pack == "NoPack") {
			if (Market == "Norway") {
				Address1.sendKeys("Address 1");
				Address2.sendKeys("Address 2");
				City.sendKeys("TestCity");
				PostalCode.sendKeys("1234");
				userdata.put("address1", "Address 1");
				userdata.put("address2", "Address 2");
				userdata.put("city", "TestCity");
				userdata.put("zip", "1234");
			}
		}
		Continue.click();
	}

	public void PCAccountDetails(String Market, String language, String pack)
			throws InterruptedException, JSONException, UnknownHostException, IOException {

		String referral = "2";
		String fname = "TestFirstName";
		String lname = "TestLastName";

		String phone = "9823746323";

		String email = RandomStringUtils.randomAlphabetic(6).toUpperCase() + "@gmail.com";
		String password = "Unicity";

		childtest.log(LogStatus.INFO, "Account Set-UP", "");

		Assert.assertEquals(SelectedLanguage.getText(), language, "Minor Selected Langauge");
		childtest.log(LogStatus.INFO, "", SelectedLanguage.getText());

		if (Market == "Bahamas") {
			String[] expected = { "English" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}
		}

		if (Market == "Canada") {
			String[] expected = { "English", "Français" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}
		}

		if (Market == "Colombia" || Market == "Dominican Republic" || Market == "Mexico") {
			String[] expected = { "Español" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}
		}

		if (Market == "Puerto Rico") {
			String[] expected = { "Español", "English" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}
		}

		if (Market == "United States") {
			String[] expected = { "English", "Español" };
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Languages.get(i).getText(), expected[i], "Minor Languages Missing");
			}
		}

		ArrayList<String> Labels = new ArrayList<String>();

		for (int i = 0; i < Headings.size() - 1; i++) {
			Labels.add(Headings.get(i).getText());
		}

		Assert.assertEquals(Labels.toString(), getTranslation("en_pc", language), "Minor Lables");

		if (Market == "Bahamas" || Market == "Dominican Republic"
				|| Market == "United States") {

			try {
				Boolean NoReferralID = NoID.isDisplayed();
				Assert.assertTrue(NoReferralID);

				NoID.click();

				childtest.log(LogStatus.INFO, "", "No Enroller & Sponsor");

				Boolean Enroller = EnrollerName.isDisplayed();
				Assert.assertTrue(Enroller, "Major Enroller In Summay");

				childtest.log(LogStatus.INFO, "", "No Enroller & Sponsor text box is displaying");

				NoID.click();
			} catch (Exception e) {
				Assert.fail("Major NoReferralID is not Displaying");
			}
		}

		if (Market == "Bahamas" || Market == "Dominican Republic"
				|| Market == "United States") {
			String[] xpath = { "(//input[@ng-change='noIDs()'])[2]", "//span[contains(@class, 'stepper-title')]" };

			Random random = new Random();
			int index = random.nextInt(xpath.length);
			NoIDS.get(index).click();

			Boolean Enroller = NoID.isSelected();
			if (Enroller == true) {
				EnrollerName.sendKeys("EnrollerTest");
				userdata.put("enroller", "2");
				userdata.put("sponsor", "2");
				userdata.put("enrollerName", "EnrollerTest");
				userdata.put("api", "1");
				userdata.put("referral", "no");
			} else {
				EnrollerID.sendKeys(referral + Keys.TAB);
				Thread.sleep(5000);
				childtest.log(LogStatus.INFO, "Enroller", referral);
				childtest.log(LogStatus.INFO, "Sponsor", referral);
				userdata.put("enroller", referral);
				userdata.put("sponsor", referral);
				userdata.put("api", "4");
				userdata.put("referral", "yes");
			}
		} else {
			EnrollerID.sendKeys(referral + Keys.TAB);
			Thread.sleep(5000);
			userdata.put("enroller", "2");
			userdata.put("sponsor", "2");
			userdata.put("enroller", referral);
			userdata.put("sponsor", referral);
			if (Market == "Mexico" || Market == "Colombia") {
				userdata.put("api", "5");
			} else {
				userdata.put("api", "4");
			}
			userdata.put("referral", "yes");
		}

		userdata.put("language", language);
		userdata.put("type", "PreferredCustomer");

		Thread.sleep(10000);

		List<HarEntry> entries = server.getHar().getLog().getEntries();
		for (HarEntry entry : entries) {
			if (entry.getRequest().getMethod().equals("GET")) {
				if (entry.getRequest().getUrl().contains("customers.js?callback=angular.callbacks._1")) {

					System.out.println("Request URL: " + entry.getRequest().getUrl());
					// System.out.println("Entry response : " +
					// entry.getResponse().getContent().getText());

					JSONObject referraldata = new JSONObject(entry.getResponse().getContent().getText().toString()
							.substring(entry.getResponse().getContent().getText().toString().indexOf("{")).trim());
					Assert.assertEquals(userdata.get("proto") + userdata.get("version")
							+ "customers.js?callback=angular.callbacks._1&expand=customer,profilePicture&id.unicity="
							+ userdata.get("enroller"), entry.getRequest().getUrl(), "Major Customer.js URL");
					Assert.assertTrue(new JsonPath(referraldata.toString()).get("data.items.href").toString()
							.contains("hydraqa.unicity.net"), "Major Customer Hydra");
					childtest.log(LogStatus.INFO, "Enroller",
							"<a href=" + entry.getRequest().getUrl() + ">Customer.js</a>");
				}
			}
		}

		FirstName.sendKeys(fname);
		LastName.sendKeys(lname);
		childtest.log(LogStatus.INFO, "", fname);
		childtest.log(LogStatus.INFO, "", lname);
		userdata.put("fname", fname);
		userdata.put("lname", lname);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

		Phone.sendKeys(phone);
		childtest.log(LogStatus.INFO, "", phone);
		userdata.put("phone", phone);

		Email.sendKeys(email + Keys.TAB);
		childtest.log(LogStatus.INFO, "", email);
		userdata.put("email", email);
		Thread.sleep(5000);

		int value = new Random().nextInt(Gender.size());
		Gender.get(value).click();
		userdata.put("genderoption", Gender.get(value).getAttribute("value"));
		userdata.put("gender", getTranslation(Gender.get(value).getAttribute("value"), language));

		int mvalue = new Random().nextInt(Martial.size());
		Martial.get(mvalue).click();
		userdata.put("maritaloption", Martial.get(mvalue).getAttribute("value"));
		userdata.put("martial", getTranslation(Martial.get(mvalue).getAttribute("value"), language));

		for (int i = 0; i < Password.size(); i++) {
			Password.get(i).sendKeys(password);
		}
		childtest.log(LogStatus.INFO, "", password);
		userdata.put("password", password);

		for (HarEntry entry : entries) {
			if (entry.getRequest().getMethod().equals("GET")) {
				if (entry.getRequest().getUrl().contains("https://")) {
					if (entry.getRequest().getUrl().contains("&email")) {
						System.out.println("Request URL: " + entry.getRequest().getUrl());
						// System.out.println("Entry response : " +
						// entry.getResponse().getContent().getText());
						Assert.assertEquals(
								userdata.get("proto") + userdata.get("version")
										+ "customers.js?_httpMethod=HEAD&callback=angular.callbacks._"
										+ userdata.get("api") + "&email=" + userdata.get("email"),
								entry.getRequest().getUrl(), "Major Email.js URL");
						childtest.log(LogStatus.INFO, "Customer",
								"<a href=" + entry.getRequest().getUrl() + ">Email.js</a>");
					}
				}
			}
		}

		Continue.click();
	}

	public void GetFitAccountDetails(String Market, String language, String pack)
			throws InterruptedException, JSONException, UnknownHostException, IOException {

		String referral = "2";
		String fname = "TestFirstName";
		String lname = "TestLastName";

		String phone = "9823746323";
		String govid = RandomStringUtils.randomNumeric(9);
		String email = RandomStringUtils.randomAlphabetic(6).toUpperCase() + "@gmail.com";
		String fax = "8217647322";
		String spouse = "TestSpouseName";
		String company = "TestCompanyName";
		String password = "Unicity";
		
		String GBIBAN = "GB29NWBK60161331926819";

		String bankname = "TestBankName";
		String holder = "TestName";
		String bic = "DEUTDEFF";

		LocalDate startDate = LocalDate.of(1990, 1, 1); // start date
		long start = startDate.toEpochDay();

		LocalDate endDate = LocalDate.of(2001, 1, 1); // end date
		long end = endDate.toEpochDay();

		long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();

		LocalDate responsedob = LocalDate.ofEpochDay(randomEpochDay);
		userdata.put("responsedob", responsedob.toString());

		String us = responsedob.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		String eu = responsedob.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String mmddyyyy = us;
		String ddmmyyyy = eu;

		childtest.log(LogStatus.INFO, "Account Set-UP", "");

		ArrayList<String> Labels = new ArrayList<String>();

		for (int i = 0; i < Headings.size() - 1; i++) {
			Labels.add(Headings.get(i).getText());
		}

		if (Market == "United Kingdom") {
			Assert.assertEquals(Labels.toString(), getTranslation("en_getfit_uk", language), "Minor Lables");
			Fax.sendKeys(fax);
			childtest.log(LogStatus.INFO, "", fax);
			userdata.put("fax", fax);

		} else {
			Assert.assertEquals(Labels.toString(), getTranslation("en_getfit", language), "Minor Lables");
		}

		EnrollerID.sendKeys(referral + Keys.TAB);
		Thread.sleep(5000);
		userdata.put("enroller", referral);
		userdata.put("sponsor", referral);

		userdata.put("api", "4");

		userdata.put("language", language);
		userdata.put("type", "GetFit");
		userdata.put("referral", "yes");

		Thread.sleep(10000);

		List<HarEntry> entries = server.getHar().getLog().getEntries();
		for (HarEntry entry : entries) {
			if (entry.getRequest().getMethod().equals("GET")) {
				if (entry.getRequest().getUrl().contains("customers.js?callback=angular.callbacks._1")) {

					System.out.println("Request URL: " + entry.getRequest().getUrl());
					// System.out.println("Entry response : " +
					// entry.getResponse().getContent().getText());

					JSONObject referraldata = new JSONObject(entry.getResponse().getContent().getText().toString()
							.substring(entry.getResponse().getContent().getText().toString().indexOf("{")).trim());
					Assert.assertEquals(userdata.get("proto") + userdata.get("version")
							+ "customers.js?callback=angular.callbacks._1&expand=customer,profilePicture&id.unicity="
							+ userdata.get("enroller"), entry.getRequest().getUrl(), "Major Customer.js URL");
					Assert.assertTrue(new JsonPath(referraldata.toString()).get("data.items.href").toString()
							.contains("hydraqa.unicity.net"), "Major Customer Hydra");
					childtest.log(LogStatus.INFO, "Enroller",
							"<a href=" + entry.getRequest().getUrl() + ">Customer.js</a>");
				}
			}
		}

		FirstName.sendKeys(fname);
		LastName.sendKeys(lname);
		childtest.log(LogStatus.INFO, "", fname);
		childtest.log(LogStatus.INFO, "", lname);
		userdata.put("fname", fname);
		userdata.put("lname", lname);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

		if (Market == "Canada" || Market == "United States") {
			DOB.sendKeys(mmddyyyy);
			childtest.log(LogStatus.INFO, "", mmddyyyy);
			userdata.put("dob", mmddyyyy);
		} else {
			DOB.sendKeys(ddmmyyyy);
			childtest.log(LogStatus.INFO, "", ddmmyyyy);
			userdata.put("dob", ddmmyyyy);
		}

		Phone.sendKeys(phone);
		childtest.log(LogStatus.INFO, "", phone);
		userdata.put("phone", phone);

		Email.sendKeys(email + Keys.TAB);
		childtest.log(LogStatus.INFO, "", email);
		userdata.put("email", email);
		Thread.sleep(5000);

		if (Market == "United States") {
			GovernmentID.sendKeys(govid);
			childtest.log(LogStatus.INFO, "", govid);
			userdata.put("govid", govid);
		}

		int value = new Random().nextInt(Gender.size());
		Gender.get(value).click();
		userdata.put("genderoption", Gender.get(value).getAttribute("value"));
		userdata.put("gender", getTranslation(Gender.get(value).getAttribute("value"), language));

		if (Market == "United Kingdom") {
			Thread.sleep(5000);
			jse.executeScript("window.scrollBy(0,250)", "");
			String[] coapplicant = { "Spouse", "Company" };
			for (int i = 0; i < coapplicant.length; i++) {
				Assert.assertEquals(CoApplicant.get(i).getAttribute("name"), coapplicant[i]);
			}
			CoApplicant.get(new Random().nextInt(CoApplicant.size())).click();

			if (Spouse.isSelected()) {
				SpouseName.sendKeys(spouse);
				childtest.log(LogStatus.INFO, "", spouse);
				userdata.put("coapplicanttype", "Spouse");
				userdata.put("coapplicant", spouse);
			}

			if (Company.isSelected()) {
				CompanyName.sendKeys(company);
				childtest.log(LogStatus.INFO, "", company);
				userdata.put("coapplicanttype", "company");
				userdata.put("coapplicant", company);

				String[] b = { "1", "2", "3", "4", };
				Select selectshipstate = new Select(Selectcompanytype);
				String u = b[new Random().nextInt(b.length)];
				int v = Integer.parseInt(u) - 1;
				selectshipstate.selectByValue(Integer.toString(v));

				userdata.put("companynametype", CompanyType.get(Integer.parseInt(u)).getText());

			}
		}

		if (Market == "United Kingdom") {
			jse.executeScript("window.scrollBy(0,250)", "");
			String[] commission = { "Paylution", "DirectDeposit" };
			for (int i = 0; i < commission.length; i++) {
				Assert.assertEquals(Commission.get(i).getAttribute("value"), commission[i]);
			}
			Commission.get(new Random().nextInt(Commission.size())).click();

			if (DirectDeposit.isSelected()) {

				IBAN.sendKeys(GBIBAN);
				childtest.log(LogStatus.INFO, "", GBIBAN);
				userdata.put("iban", GBIBAN);
				userdata.put("commission", "DD");

				BankName.sendKeys(bankname);
				AccHolder.sendKeys(holder);
				BIC.sendKeys(bic);
				childtest.log(LogStatus.INFO, "", bankname);
				childtest.log(LogStatus.INFO, "", holder);
				childtest.log(LogStatus.INFO, "", bic);
				userdata.put("bankname", bankname);
				userdata.put("holder", holder);
				userdata.put("bic", bic);
			}
		}

		for (int i = 0; i < Password.size(); i++) {
			Password.get(i).sendKeys(password);
		}
		childtest.log(LogStatus.INFO, "", password);
		userdata.put("password", password);

		for (HarEntry entry : entries) {
			if (entry.getRequest().getMethod().equals("GET")) {
				if (entry.getRequest().getUrl().contains("https://")) {
					if (entry.getRequest().getUrl().contains("&email")) {
						System.out.println("Request URL: " + entry.getRequest().getUrl());
						// System.out.println("Entry response : " +
						// entry.getResponse().getContent().getText());
						Assert.assertEquals(
								userdata.get("proto") + userdata.get("version")
										+ "customers.js?_httpMethod=HEAD&callback=angular.callbacks._"
										+ userdata.get("api") + "&email=" + userdata.get("email"),
								entry.getRequest().getUrl(), "Major Email.js URL");
						childtest.log(LogStatus.INFO, "Customer",
								"<a href=" + entry.getRequest().getUrl() + ">Email.js</a>");
					}
				}
			}
		}

		Continue.click();
	}

}
