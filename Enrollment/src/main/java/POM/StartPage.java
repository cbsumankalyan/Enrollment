package POM;

import java.io.IOException;

import java.text.ParseException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import Pages.SuperTestNG;

public class StartPage extends SuperTestNG {

	@FindBy(xpath = "//span[contains(@class,'stepper-title')]")
	private WebElement StepperTitle;

	@FindBy(xpath = "(//label[@class='ng-scope'])[1]")
	private WebElement SelectYourMarket;

	@FindBy(xpath = "(//label[@class='ng-scope'])[2]")
	private WebElement SelectYourLanguage;

	@FindBy(xpath = "(//span[@class='ng-scope'])[1]")
	private WebElement FP;

	@FindBy(xpath = "//input[@value='pc']")
	private WebElement PC;

	@FindBy(xpath = "//p[@class='ng-scope']")
	private WebElement PrefferedCustomer;

	@FindBy(xpath = "(//span[@class='ng-scope'])[2]")
	private WebElement FPDefinition;

	@FindBy(xpath = "(//span[@class='ng-scope'])[3]")
	private WebElement PCDefinition;

	@FindBys(@FindBy(xpath = "//select[@ng-model='selectedCountry']//option"))
	List<WebElement> Country;

	@FindBy(xpath = "//select[@ng-model='selectedCountry']")
	private WebElement SelectCountry;

	@FindBy(xpath = "//select[@ng-model='settings.locale']")
	private WebElement SelectLanguage;

	@FindBy(xpath = "//select[contains(@ng-options, 'language')]/option[@selected = 'selected']")
	private WebElement SelectedLanguage;

	@FindBy(xpath = "(//div[contains(@class, 'col-lg-8')]//span[contains(@class, 'ng')])[1]")
	private WebElement NeedHelp;

	@FindBy(xpath = "(//div[contains(@class, 'col-lg-8')]//span[contains(@class, 'ng')])[2]")
	private WebElement Support;

	@FindBy(xpath = "(//div[contains(@class, 'col-lg-8')]//span[contains(@class, 'ng')])[3]")
	private WebElement WorkingHours;

	@FindBy(xpath = "(//div[contains(@class, 'col-lg-8')]//span[contains(@class, 'ng')])[4]")
	private WebElement CSEmail;

	@FindBy(xpath = "(//div[contains(@class, 'col-lg-8')]//span[contains(@class, 'ng')])[6]")
	private WebElement INDCSEmail;

	@FindBy(xpath = "//span[contains(@class, 'ng-scope')]//span[contains(@class, 'ng-scope')]")
	private WebElement Copyright;

	@FindBy(xpath = "(//span[contains(@class, 'ng-scope')]//span[contains(@class, 'ng-scope')])[3]")
	private WebElement INDCopyright;

	@FindBy(xpath = "//button[contains(@class, 'continue-btn')]")
	private WebElement Continue;

	public StartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void Start(String Market, String language) throws InterruptedException, IOException, ParseException {

		userdata.put("market", Market);
		akhil = (countrycode.get(userdata.get("market"))) + "-" + locale.get(language);

		Thread.sleep(10000);
		String[] expected = { "Australia", "Austria", "Bahamas", "Belgium", "Cambodia ", "Canada ", "Colombia",
				"Denmark ", "Dominican Republic", "France", "Germany", "Hong Kong", "Hungary", "India", "Indonesia",
				"Italy", "Ireland", "Jamaica", "Japan", "Korea", "Laos", "Luxembourg", "Malaysia", "Mexico",
				"Netherlands", "New Zealand", "Norway", "Philippines", "Poland", "Puerto Rico ", "Singapore", "Sweden",
				"Switzerland", "Spain", "Taiwan", "Thailand", "United States", "Turkey", "Ukraine", "United Kingdom" };

		if (!(userdata.get("testcase") == "hcp")) {
			for (int i = 0; i < expected.length; i++) {
				Assert.assertEquals(Country.get(i).getText(), expected[i], "Major market is missing");
			}
		}

		Select selectCountry = new Select(SelectCountry);
		selectCountry.selectByVisibleText(Market);

		Select selectlanguage = new Select(SelectLanguage);
		selectlanguage.selectByVisibleText(language);

		Thread.sleep(7000);

		if (Market == "India") {
			Assert.assertEquals(StepperTitle.getText(), getTranslation("home_page_stepper_in", language), "Low footer");
			Assert.assertEquals(FP.getText(), getTranslation("franchise_partner_in", language), "Low footer");
		} else {
			if (!(userdata.get("testcase") == "hcp")) {
				if (Market == "Puerto Rico") {
					Assert.assertEquals(StepperTitle.getText(), getTranslation("home_page_stepper_in", language),
							"Low footer");
				}
				if (Market == "Spain") {
					Assert.assertEquals(StepperTitle.getText(), getTranslation("home_page_stepper_es", language),
							"Low footer");
				}
				if (!(Market == "Puerto Rico" || Market == "Spain")) {
					Assert.assertEquals(StepperTitle.getText(), getTranslation("home_page_stepper", language),
							"Low footer");
				}
				Assert.assertEquals(FP.getText(), getTranslation("franchise_partner", language), "Low footer");
			}
		}
		Assert.assertEquals(SelectYourMarket.getText().toLowerCase(),
				getTranslation("select_your_market", language).toLowerCase(), "Low footer");
		Assert.assertEquals(SelectYourLanguage.getText(), getTranslation("select_your_language", language),
				"Low footer");
		if (Market == "Canada") {
			if ((userdata.get("testcase") == "hcp")) {
				Assert.assertEquals(FPDefinition.getText(), getTranslation("join_as_hcp_desc_ca", language),
						"Low Description");
			} else {
				Assert.assertEquals(FPDefinition.getText(), getTranslation("join_as_fp_desc_ca", language),
						"Low Description");
			}
		}
		if (Market == "Colombia" || Market == "Mexico") {
			Assert.assertEquals(FPDefinition.getText(), getTranslation("join_as_fp_desc_co", language),
					"Low Description");
		}

		if (!(userdata.get("testcase") == "hcp")) {
			if (!(Market == "Canada" || Market == "Colombia" || Market == "Mexico")) {
				Assert.assertEquals(FPDefinition.getText(), getTranslation("join_as_fp_desc", language),
						"Low Description");
			}
		}

		childtest.log(Status.INFO, "Start ->"+"Checked Start Page Translations");

		if (Market == "Australia" || Market == "Austria" || Market == "Bahamas" || Market == "Canada"
				|| Market == "Denmark" || Market == "Hungary" || Market == "India" || Market == "Ireland"
				|| Market == "Jamaica" || Market == "Netherlands" || Market == "New Zealand" || Market == "Norway"
				|| Market == "Poland" || Market == "Spain" || Market == "United States" || Market == "Ukraine"
				|| Market == "United Kingdom") {
			Assert.assertEquals(SelectedLanguage.getText(), "English", "Minor Selected Language");
		}

		if (Market == "Belgium" || Market == "France" || Market == "Luxembourg") {
			Assert.assertEquals(SelectedLanguage.getText(), "Français", "Minor Selected Language");
		}

		if (Market == "Colombia" || Market == "Dominican Republic" || Market == "Mexico" || Market == "Puerto Rico") {
			Assert.assertEquals(SelectedLanguage.getText(), "Español", "Minor Selected Language");
		}

		if (Market == "Germany" || Market == "Switzerland") {
			Assert.assertEquals(SelectedLanguage.getText(), "Deutsch", "Minor Selected Language");
		}

		if (Market == "Italy") {
			Assert.assertEquals(SelectedLanguage.getText(), "Italiano", "Minor Selected Language");
		}

		if (Market == "Sweden") {
			Assert.assertEquals(SelectedLanguage.getText(), "Svenska", "Minor Selected Language");
		}

		userdata.put("prefferd", Market);
		userdata.put("marketcode", countrycode.get(Market));
		userdata.put("locale", locale.get(language));

		if (Market == "Netherlands") {
			if (language == "Dutch") {
				userdata.put("locale", "de");
			}
		}

		childtest.log(Status.INFO, Market);
		childtest.log(Status.INFO, language);

		if (Market == "Australia" || Market == "New Zealand") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_au", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_au", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email_au", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding", language), "Low footer");
		}

		if (Market == "Austria") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support", language), "Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding", language), "Low footer");
		}

		if (Market == "Belgium" || Market == "Denmark") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_be", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_be", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding_be", language), "Low footer");
		}

		if (Market == "Hungary") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_be", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_be", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding", language), "Low footer");
		}

		if (Market == "Bahamas" || Market == "United States") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_us", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_us", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email_us", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding", language), "Low footer");
		}

		if (Market == "Canada") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_ca", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_ca", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email_ca", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding_ca", language), "Low footer");
		}

		if (Market == "Colombia") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help_co", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_co", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_co", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email_co", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding_co", language), "Low footer");
		}

		if (Market == "Dominican Republic") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help_co", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_dr", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_dr", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email_dr", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding_dr", language), "Low footer");
		}

		if (Market == "France") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_fr", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_fr", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding", language), "Low footer");
		}

		if (Market == "Germany" || Market == "Ireland") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help_de", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_de", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_de", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding_de", language), "Low footer");
		}

		if (Market == "India") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help_de", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_in", language),
					"Low footer");
			Assert.assertEquals(INDCSEmail.getText(), getTranslation("footer_email_in", language), "Low footer");
			Assert.assertEquals(INDCopyright.getText(), getTranslation("footer_branding_in", language), "Low footer");
		}

		if (Market == "Italy") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_it", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_it", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding_it", language), "Low footer");
		}

		if (Market == "Jamaica") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_jm", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_jm", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email_jm", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding_jm", language), "Low footer");
		}

		if (Market == "Luxembourg") {
			Thread.sleep(1000);
			if (language == "Deutsch") {
				Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help_de", language), "Low footer");
				Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_de", language),
						"Low footer");
				Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_de", language), "Low footer");
				Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email", language), "Low footer");
				Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding_de", language), "Low footer");
			} else {
				Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help", language), "Low footer");
				Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_be", language),
						"Low footer");
				Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_be", language), "Low footer");
				Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email", language), "Low footer");
				Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding_be", language), "Low footer");
			}
		}

		if (Market == "Mexico") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help_co", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_mx", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_mx", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email_mx", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding_co", language), "Low footer");
		}

		if (Market == "Netherlands") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_nl", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_nl", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding_ca", language), "Low footer");
		}

		if (Market == "Norway" || Market == "Ukraine" || Market == "United Kingdom") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_no", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_no", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding", language), "Low footer");
		}

		if (Market == "Poland") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_pl", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_pl", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding", language), "Low footer");
		}

		if (Market == "Puerto Rico") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_pr", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_ca", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email_ca", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding_ca", language), "Low footer");
		}

		if (Market == "Sweden") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_se", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_se", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding_be", language), "Low footer");
		}

		if (Market == "Switzerland") {
			Thread.sleep(1000);
			if (language == "Deutsch" || language == "English") {
				Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help", language), "Low footer");
				Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_de", language),
						"Low footer");
				Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_de", language), "Low footer");
				Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email", language), "Low footer");
				Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding_de", language), "Low footer");
			}
			if (language == "Français") {
				Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help", language), "Low footer");
				Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_be", language),
						"Low footer");
				Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_be", language), "Low footer");
				Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email", language), "Low footer");
				Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding_be", language), "Low footer");
			}
			if (language == "Italiano") {
				Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help", language), "Low footer");
				Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_it", language),
						"Low footer");
				Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_ch", language), "Low footer");
				Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email", language), "Low footer");
				Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding_it", language), "Low footer");
			}
		}

		if (Market == "Spain") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help_sp", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_de", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_sp", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding_de", language), "Low footer");
		}
		
		if (Market == "Turkey") {
			Thread.sleep(1000);
			Assert.assertEquals(NeedHelp.getText(), getTranslation("footer_need_help_sp", language), "Low footer");
			Assert.assertEquals(Support.getText(), getTranslation("footer_executive_support_tr", language),
					"Low footer");
			Assert.assertEquals(WorkingHours.getText(), getTranslation("footer_hours_tr", language), "Low footer");
			Assert.assertEquals(CSEmail.getText(), getTranslation("footer_email", language), "Low footer");
			Assert.assertEquals(Copyright.getText(), getTranslation("footer_branding_tr", language), "Low footer");
		}

		childtest.log(Status.INFO, "Checked Footer");

		Continue.click();

		Thread.sleep(10000);
	}

	public void PC(String Market, String language) throws InterruptedException, IOException, ParseException {

		userdata.put("market", Market);
		akhil = (countrycode.get(userdata.get("market"))) + "-" + locale.get(language);

		Select selectCountry = new Select(SelectCountry);
		selectCountry.selectByVisibleText(Market);

		Select selectlanguage = new Select(SelectLanguage);
		selectlanguage.selectByVisibleText(language);

		PC.click();
		childtest.log(Status.INFO, "Type ->"+"PC Flow");

		Thread.sleep(5000);

		userdata.put("prefferd", Market);
		userdata.put("marketcode", countrycode.get(Market));
		userdata.put("locale", locale.get(language));

		childtest.log(Status.INFO, "Start ->"+ Market);
		childtest.log(Status.INFO, language);

		Assert.assertEquals(PrefferedCustomer.getText(), getTranslation("preferred_customer", language),
				"Low Prefferd Customer");

		if (Market == "Mexico" || Market == "Colombia") {
			Assert.assertEquals(PCDefinition.getText(), getTranslation("join_as_pc_desc_co", language),
					"Low PC Definition");
		} else {
			Assert.assertEquals(PCDefinition.getText(), getTranslation("join_as_pc_desc", language),
					"Low PC Definition");
		}

		Continue.click();

		Thread.sleep(10000);

	}

	public void PP(String Market, String language) throws InterruptedException, IOException, ParseException {

		userdata.put("market", Market);
		akhil = (countrycode.get(userdata.get("market"))) + "-" + locale.get(language);

		Select selectCountry = new Select(SelectCountry);
		selectCountry.selectByVisibleText(Market);

		Select selectlanguage = new Select(SelectLanguage);
		selectlanguage.selectByVisibleText(language);

		Thread.sleep(5000);

		userdata.put("prefferd", Market);
		userdata.put("marketcode", countrycode.get(Market));
		userdata.put("locale", locale.get(language));

		childtest.log(Status.INFO, "Start ->"+Market);
		childtest.log(Status.INFO, language);

		Continue.click();

		Thread.sleep(10000);

	}

	public void GetFitStart(String Market, String language) throws InterruptedException, IOException {

		userdata.put("market", Market);
		akhil = (countrycode.get(userdata.get("market"))) + "-" + locale.get(language);

		System.out.println("Start----" + (countrycode.get(userdata.get("market"))) + "-" + locale.get(language));

		Thread.sleep(10000);
		String[] expected = { "United States", "Canada ", "United Kingdom", };

		for (int i = 0; i < expected.length; i++) {
			Assert.assertEquals(Country.get(i).getText(), expected[i], "Major market is missing");
		}

		Select selectCountry = new Select(SelectCountry);
		selectCountry.selectByVisibleText(Market);

		Select selectlanguage = new Select(SelectLanguage);
		selectlanguage.selectByVisibleText(language);

		Thread.sleep(7000);

		Assert.assertEquals(SelectYourMarket.getText().toLowerCase(),
				getTranslation("home_page_stepper_getfit", language).toLowerCase(), "Low footer");
		Assert.assertEquals(SelectYourLanguage.getText(), getTranslation("select_your_language", language),
				"Low footer");

		childtest.log(Status.INFO, "Start  ->"+"Checked Start Page Translations");

		Assert.assertEquals(SelectedLanguage.getText(), "English", "Minor Selected Language");

		Assert.assertEquals(FP.getText(), getTranslation("franchise_partner_getfit", language), "Low footer");

		Assert.assertEquals(FPDefinition.getText(), getTranslation("join_as_fp_desc_getfit", language), "Low footer");

		userdata.put("prefferd", Market);
		userdata.put("marketcode", countrycode.get(Market));
		userdata.put("locale", locale.get(language));

		childtest.log(Status.INFO, Market);
		childtest.log(Status.INFO, language);

		Continue.click();

		Thread.sleep(10000);
	}

}
