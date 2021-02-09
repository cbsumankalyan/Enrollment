package Tests;


import java.io.IOException;
import java.text.ParseException;
import org.json.JSONException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.Account;
import Pages.AutoRefill;
import Pages.InitialOrder;
import Pages.Payment;
import Pages.Start;
import Pages.Summary;
import Pages.SuperTestNG;

public class HealthCareProducts extends SuperTestNG {
	
	@DataProvider
	public Object[][] MarketConfig() {

		Object[][] data = new Object[4][3];
		
		data[0][0] = "United States";
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
	
	
		return data;

	}
	
	Start start = new Start();
	InitialOrder packs = new InitialOrder();
	AutoRefill arpack = new AutoRefill();
	Account account = new Account();
	Payment payment = new Payment();
	Summary summary = new Summary();
	
	
	@Test(dataProvider="MarketConfig")
	public void PassReferralID(String Market, String language, String pack) throws InterruptedException, IOException, JSONException, ParseException {
		
		childtest = hcp.createNode(Market + "  |  " + language);		
		childtest.log(Status.INFO, "HCP url Platform   "+"<a href=" + hcpflow + ">" + userdata.get("platform") + "</a>");
		
		start.SelectMarket(Market, language);
		packs.PacksChecking(Market, language, pack);
		arpack.ARPacks(Market, pack);
		account.PersonalDetails(Market, language, pack);
		payment.PaymentDetails(Market, language, pack);
		summary.SummaryDetails(Market,language, pack);
	}
}
