package Tests;


import java.io.IOException;
import java.text.ParseException;
import org.json.JSONException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.Account;
import Pages.AutoRefill;
import Pages.InitialOrder;
import Pages.Payment;
import Pages.Start;
import Pages.Summary;
import Pages.SuperTestNG;

public class Fit extends SuperTestNG {
	
	@DataProvider
	public Object[][] MarketConfig() {

		Object[][] data = new Object[5][3];
	
		data[0][0] = "United Kingdom";
		data[0][1] = "English";
		data[0][2] = "Pack";

		data[1][0] = "United States";
		data[1][1] = "Español";
		data[1][2] = "Pack";

		data[2][0] = "Canada";
		data[2][1] = "English";
		data[2][2] = "Pack";

		data[3][0] = "Canada";
		data[3][1] = "Français";
		data[3][2] = "Pack";
		
		data[4][0] = "United States";
		data[4][1] = "English";
		data[4][2] = "Pack";

		return data;

	}
	
	Start start = new Start();
	InitialOrder packs = new InitialOrder();
	AutoRefill arpack = new AutoRefill();
	Account account = new Account();
	Payment payment = new Payment();
	Summary summary = new Summary();
	
	
	@Test(dataProvider="MarketConfig")
	public void GetFit(String Market, String language, String pack) throws InterruptedException, IOException, JSONException, ParseException {
	
		childtest = extent.startTest(Market + "  |  " + language);
		fit.appendChild(childtest);
		childtest.log(LogStatus.INFO, "GetFit", "Platform   "+"<a href=" + getfit + ">" + userdata.get("platform") + "</a>");
		
		start.GetFitFlow(Market, language);
		account.GetFitPersonalDetails(Market, language, pack);
		packs.GetFitPacks(Market, language, pack);
		payment.PaymentDetails(Market, language, pack);
		summary.GetFitSummaryDetails(Market,language, pack);
	}
}
