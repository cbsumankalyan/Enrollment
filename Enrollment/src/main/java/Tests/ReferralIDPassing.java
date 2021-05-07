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

public class ReferralIDPassing extends SuperTestNG {
	
	@DataProvider
	public Object[][] MarketConfig() {

		Object[][] data = new Object[2][4];
	
		data[0][0] = "United States";
		data[0][1] = "English";
		data[0][2] = "Pack";
		data[0][3] = "CreditCard";
		
		data[1][0] = "United States";
		data[1][1] = "Español";
		data[1][2] = "Pack";
		data[1][3] = "CreditCard";
	
	
		return data;

	}
	
	Start start = new Start();
	InitialOrder packs = new InitialOrder();
	AutoRefill arpack = new AutoRefill();
	Account account = new Account();
	Payment payment = new Payment();
	Summary summary = new Summary();
	
	
	@Test(dataProvider="MarketConfig")
	public void PassReferralID(String Market, String language, String pack, String Payment) throws InterruptedException, IOException, JSONException, ParseException {
		
		childtest = referral.createNode("<b><font color=407899>" + Market + "  |  " + language + "  |  " + Payment + "</font></b>");
		childtest.log(Status.INFO, "Passing Referall Platform   "+"<a href=" + referralurl + ">" + userdata.get("platform") + "</a>");
		System.out.println(Market + "  |  " + language);
		start.SelectMarket(Market, language);
		packs.PacksChecking(Market, language, pack, Payment);
		arpack.ARPacks(Market, pack, Payment);
		account.PersonalDetails(Market, language, pack, Payment);
		payment.PaymentDetails(Market, language, pack, Payment);
		summary.SummaryDetails(Market,language, pack, Payment);
	}
}
