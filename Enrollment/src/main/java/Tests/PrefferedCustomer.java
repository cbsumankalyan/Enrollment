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

public class PrefferedCustomer extends SuperTestNG {

	@DataProvider
	public Object[][] MarketConfig() {

		Object[][] data = new Object[10][4];
		
		data[0][0] = "Bahamas";
		data[0][1] = "English";
		data[0][2] = "Pack";
		data[0][3] = "CreditCard";

		data[1][0] = "Canada";
		data[1][1] = "English";
		data[1][2] = "Pack";
		data[1][3] = "CreditCard";

		data[2][0] = "Canada";
		data[2][1] = "Français";
		data[2][2] = "Pack";
		data[2][3] = "CreditCard";

		data[3][0] = "Colombia";
		data[3][1] = "Español";
		data[3][2] = "Pack";
		data[3][3] = "CreditCard";

		data[4][0] = "Dominican Republic";
		data[4][1] = "Español";
		data[4][2] = "Pack";
		data[4][3] = "CreditCard";

		data[5][0] = "Mexico";
		data[5][1] = "Español";
		data[5][2] = "Pack";
		data[5][3] = "CreditCard";
		
		data[6][0] = "Puerto Rico";
		data[6][1] = "English";
		data[6][2] = "Pack";
		data[6][3] = "CreditCard";

		data[7][0] = "Puerto Rico";
		data[7][1] = "Español";
		data[7][2] = "Pack";
		data[7][3] = "CreditCard";
		
		data[8][0] = "United States";
        data[8][1] = "English";
        data[8][2] = "Pack";
        data[8][3] = "CreditCard";
        
        data[9][0] = "United States";
        data[9][1] = "Español";
        data[9][2] = "Pack";
        data[9][3] = "CreditCard";
		
		return data;

	}

	Start start = new Start();
	InitialOrder packs = new InitialOrder();
	AutoRefill arpack = new AutoRefill();
	Account account = new Account();
	Payment payment = new Payment();
	Summary summary = new Summary();
	
	
	
	@Test(dataProvider="MarketConfig")
	public void Enroll(String Market, String language, String pack, String Payment) throws InterruptedException, IOException, JSONException, ParseException {
		
		childtest = pc.createNode("<b><font color=407899>" + Market + "  |  " + language + "  |  " + Payment + "</font></b>");
		childtest.log(Status.INFO, "PC Enrollment Platform   "+"<a href=" + url + ">" + userdata.get("platform") + "</a>");
		System.out.println(Market + "  |  " + language);
		start.PCFlow(Market, language);
		packs.PCPacksChecking(Market, language, pack);
		arpack.ARPacks(Market, pack, Payment);
		account.PCPersonalDetails(Market, language, pack);
		payment.PaymentDetails(Market, language, pack, Payment);
		summary.PCSummaryDetails(Market,language, pack);
	}
}
