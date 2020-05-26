package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;

public class SuperTestNG {

	public static BrowserMobProxy server;
	public static WebDriver driver;
	// public static ExtentReports extent;
	// public static ExtentTest test;
	// public static HashMap<String, String> userdata = new HashMap<>();
	public static Map<String, String> userdata = new HashMap<String, String>();

	public static String hydra = "https://hydra.unicity.net/v5/";
	// public static String hydra = "https://hydraqa.unicity.net/v5-test/";
	public static String url = "http://enroll.ng.unicityqa.com/vjk_refId/#/enroll/start";
	public static String referralurl = "http://enroll.ng.unicityqa.com/vjk_refId/#/enroll/start/united-states/2";
	public static String getfit = "http://enroll.ng.unicityqa.com/vjk_refId/#/enroll/getfit";
	public static String patientportal = "http://enroll.ng.unicityqa.com/vjk_refId/#/enroll/unicity";
	public static String hcpflow = "http://enroll.ng.unicityqa.com/vjk_refId/#/enroll/hcp";
	// public static String url = "https://enroll.unicity.com/#/enroll/start";
	// public static JavascriptExecutor jse = (JavascriptExecutor)driver;

	// public static ArrayList<String> failed = new ArrayList<>();
	public static List<String> failed = new ArrayList<String>();
	// public static ArrayList<String> packs = new ArrayList<>();
	// public static ArrayList<String> Itemcode = new ArrayList<>();
	// public static ArrayList<String> vvv = new ArrayList<>();
	public static List<String> packs = new ArrayList<String>();
	public static List<String> Itemcode = new ArrayList<String>();
	public static List<String> vvv = new ArrayList<String>();
	public static List<String> al = new ArrayList<String>();
	public static String num;
	public static String akhil;
	// public static ArrayList<String> rrr = new ArrayList<>();
	// public static ArrayList<String> Quantity = new ArrayList<>();
	// public static ArrayList<String> addresses = new ArrayList<>();
	public static List<String> rrr = new ArrayList<String>();
	public static List<String> Quantity = new ArrayList<String>();
	public static List<String> addresses = new ArrayList<String>();

	// public static HashMap<String, String> countrycode = new HashMap<>();
	// public static HashMap<String, String> locale = new HashMap<>();

	public static Map<String, String> countrycode = new HashMap<String, String>();
	public static Map<String, String> locale = new HashMap<String, String>();

	// public static ArrayList<String> Critical = new ArrayList<>();
	// public static ArrayList<String> Major = new ArrayList<>();
	// public static ArrayList<String> Minor = new ArrayList<>();
	// public static ArrayList<String> Low = new ArrayList<>();

	public static List<String> Critical = new ArrayList<String>();
	public static List<String> Major = new ArrayList<String>();
	public static List<String> Minor = new ArrayList<String>();
	public static List<String> Low = new ArrayList<String>();

	protected String getTranslation(String key, String language) throws IOException {
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(
				"C:/Users/sumancb/git/Enrollment/Enrollment/src/main/java/Languages/" + language + ".txt");
		prop.load(new InputStreamReader(input, Charset.forName("Unicode")));
		input.close();
		return prop.getProperty(key);
	}

	public static ExtentReports extent;
	public static ExtentTest fp;
	public static ExtentTest pc;
	public static ExtentTest referral;
	public static ExtentTest fit;
	public static ExtentTest pp;
	public static ExtentTest hcp;
	public static ExtentTest childtest;

	@BeforeTest
	public void StartReport() {
		extent = new ExtentReports("C://xampp//htdocs//EnrollReport//EnrollQA.html");
		fp = extent.startTest("Franchise Partner");
		pc = extent.startTest("Prefered Customer");
		referral = extent.startTest("PassingReferralID");
		fit = extent.startTest("GetFit");
		pp = extent.startTest("PatientPortal");
		hcp = extent.startTest("HealthCareProduct");
	}

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void PreConditon() throws ParseException, URISyntaxException, MalformedURLException {

		countrycode.put("Australia", "AU");
		countrycode.put("Austria", "AT");
		countrycode.put("Bahamas", "BS");
		countrycode.put("Belgium", "BE");
		countrycode.put("Canada", "CA");
		countrycode.put("Colombia", "CO");
		countrycode.put("Denmark", "DK");
		countrycode.put("Dominican Republic", "DO");
		countrycode.put("France", "FR");
		countrycode.put("Germany", "DE");
		countrycode.put("Hungary", "HU");
		countrycode.put("India", "IN");
		countrycode.put("Italy", "IT");
		countrycode.put("Ireland", "IE");
		countrycode.put("Jamaica", "JM");
		countrycode.put("Luxembourg", "LU");
		countrycode.put("Mexico", "MX");
		countrycode.put("Netherlands", "NL");
		countrycode.put("New Zealand", "NZ");
		countrycode.put("Norway", "NO");
		countrycode.put("Poland", "PL");
		countrycode.put("Puerto Rico", "PR");
		countrycode.put("Sweden", "SE");
		countrycode.put("Switzerland", "CH");
		countrycode.put("Spain", "ES");
		countrycode.put("United States", "US");
		countrycode.put("Ukraine", "UA");
		countrycode.put("United Kingdom", "GB");

		locale.put("English", "en");
		locale.put("Deutsch", "de");
		locale.put("Français", "fr");
		locale.put("Dutch", "nl");
		locale.put("Español", "es");
		locale.put("Danish", "dn");
		locale.put("русский", "ru");
		locale.put("Hungarian", "hu");
		locale.put("Italiano", "it");
		locale.put("Norwegian", "no");
		locale.put("Polish", "pl");
		locale.put("Svenska", "sv");

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "driver/chromedriver_win32_2.36/chromedriver.exe");
		 * DesiredCapabilities cap = DesiredCapabilities.chrome();
		 * LoggingPreferences logPrefs = new LoggingPreferences();
		 * logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
		 * cap.setCapability(CapabilityType.LOGGING_PREFS, logPrefs); driver =
		 * new ChromeDriver(cap); driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 * driver.get(url);
		 */

		server = new BrowserMobProxyServer();
		server.start();
		Proxy seleniumProxy = ClientUtil.createSeleniumProxy(server);
		// seleniumProxy.setHttpProxy("http://sumancb@hostname:Aug@2019" + ":" +
		// server.getPort());
		// seleniumProxy.setSslProxy("http://sumancb@hostname:Aug@2019" + ":" +
		// server.getPort());

		server.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
		server.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
		server.enableHarCaptureTypes(CaptureType.REQUEST_HEADERS, CaptureType.RESPONSE_HEADERS);
		server.newHar("Enroll");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

		System.setProperty("webdriver.chrome.driver", "driver/chromedriver_win32_2.36/chromedriver.exe");
		driver = new ChromeDriver(capabilities);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		

		if (this.getClass().getSimpleName().toString().equals("ReferralIDPassing")) {
			driver.get(referralurl);
			userdata.put("testcase", "referalid");
		} 
		if (this.getClass().getSimpleName().toString().equals("FranchisePartner")) {
			driver.get(url);
			userdata.put("testcase", "normal");
		}
		if (this.getClass().getSimpleName().toString().equals("PrefferedCustomer")) {
			driver.get(url);
			userdata.put("testcase", "normal");
		}
		if (this.getClass().getSimpleName().toString().equals("Fit")) {
			driver.get(getfit);
			userdata.put("testcase", "getfit");
		}
		if (this.getClass().getSimpleName().toString().equals("PatientPortal")) {
			driver.get(patientportal);
			userdata.put("testcase", "PatientPortal");
		}
		if (this.getClass().getSimpleName().toString().equals("HealthCareProducts")) {
			driver.get(hcpflow);
			userdata.put("testcase", "hcp");
		}
		
		/*if (url.contains("https://")) {
			userdata.put("proto", "https://hydra.unicity.net/");
			userdata.put("version", "v5/");
			userdata.put("platform", "Live");
		}*/
		if (url.contains("http://")) {
			userdata.put("proto", "https://hydraqa.unicity.net/");
			userdata.put("version", "v5a-test/");
			userdata.put("platform", "QA");
		}
	}

	@AfterMethod
	public void PostCondition(ITestResult testResult) {

		if (testResult.isSuccess()) {
			childtest.log(LogStatus.PASS, "", "Test Passed");

		} else if (testResult.getStatus() == ITestResult.FAILURE) {
			String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
			String Suman = "data:image/png;base64," + screenshotBase64;
			childtest.log(LogStatus.INFO, "Snapshot :", fp.addBase64ScreenShot(Suman));
			childtest.log(LogStatus.FAIL, "", "Test Failed");
			childtest.log(LogStatus.INFO, "", testResult.getThrowable().getMessage());

			String[] xyz = testResult.getThrowable().getMessage().split(" ");
			if (xyz[0].equals("Critical")) {
				Critical.add(akhil);
			}

			if (xyz[0].equals("Major")) {
				Major.add(akhil);
			}

			if (xyz[0].equals("Minor")) {
				Minor.add(akhil);
			}

			if (xyz[0].equals("Low")) {
				Low.add(akhil);
			}

			failed.add(countrycode.get(userdata.get("market")));	
			
			driver.quit();

		} else if (testResult.getStatus() == ITestResult.SKIP) {
			childtest.log(LogStatus.SKIP, "", "Test Skipped");
		}

		driver.quit();
		packs.clear();
		Itemcode.clear();
		Quantity.clear();
		addresses.clear();
		userdata.clear();
		vvv.clear();
		rrr.clear();
		
	}

	@AfterSuite
	public void afterSuite() throws Exception {
		extent.endTest(fp);
		extent.endTest(pc);
		extent.endTest(referral);
		extent.endTest(childtest);
		extent.endTest(fit);
		extent.endTest(pp);
		extent.endTest(hcp);
		extent.flush();
		NoAttach.Sendmail();
	}

}
