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

public class FranchisePartner extends SuperTestNG {
	
	@DataProvider
	public Object[][] MarketConfig() {

		Object[][] data = new Object[51][3];
		
		data[0][0] = "Australia";
		data[0][1] = "English";
		data[0][2] = "Pack";

		data[1][0] = "Austria";
		data[1][1] = "English";
		data[1][2] = "Pack";

		data[2][0] = "Austria";
		data[2][1] = "Deutsch";
		data[2][2] = "Pack";

		data[3][0] = "Bahamas";
		data[3][1] = "English";
		data[3][2] = "Pack";

		data[4][0] = "Belgium";
		data[4][1] = "Français";
		data[4][2] = "Pack";

		data[5][0] = "Belgium";
		data[5][1] = "Dutch";
		data[5][2] = "Pack";

		data[6][0] = "Belgium";
		data[6][1] = "English";
		data[6][2] = "Pack";

		data[7][0] = "Canada";
		data[7][1] = "English";
		data[7][2] = "Pack";

		data[8][0] = "Canada";
		data[8][1] = "Français";
		data[8][2] = "Pack";

		data[9][0] = "Colombia";
		data[9][1] = "Español";
		data[9][2] = "Pack";
		
		data[10][0] = "Denmark";
        data[10][1] = "English";
        data[10][2] = "Pack";
        
        data[11][0] = "Denmark";
        data[11][1] = "Danish";
        data[11][2] = "Pack";
        
        data[12][0] = "Dominican Republic";
        data[12][1] = "Español";
        data[12][2] = "Pack";

        data[13][0] = "France";
        data[13][1] = "Français";
        data[13][2] = "Pack";
        
        data[14][0] = "France";
        data[14][1] = "English";
        data[14][2] = "Pack";

        data[15][0] = "Germany";
        data[15][1] = "Deutsch";
        data[15][2] = "Pack";
        
        data[16][0] = "Germany";
        data[16][1] = "English";
        data[16][2] = "Pack";

        data[17][0] = "Hungary";
        data[17][1] = "English";
        data[17][2] = "Pack";
        
        data[18][0] = "Hungary";
        data[18][1] = "Hungarian";
        data[18][2] = "Pack";

        data[19][0] = "India";
        data[19][1] = "English";
        data[19][2] = "NoPack";

        data[20][0] = "Italy";
        data[20][1] = "Italiano";
        data[20][2] = "Pack";
        
        data[21][0] = "Italy";
        data[21][1] = "English";
        data[21][2] = "Pack";
        
        data[22][0] = "Ireland";
        data[22][1] = "English";
        data[22][2] = "Pack";

        data[23][0] = "Jamaica";
        data[23][1] = "English";
        data[23][2] = "Pack";

        data[24][0] = "Luxembourg";
        data[24][1] = "Français";
        data[24][2] = "Pack";
        
        data[25][0] = "Luxembourg";
        data[25][1] = "English";
        data[25][2] = "Pack";
        
        data[26][0] = "Luxembourg";
        data[26][1] = "Deutsch";
        data[26][2] = "Pack";

        data[27][0] = "Mexico";
        data[27][1] = "Español";
        data[27][2] = "Pack";

        data[28][0] = "Netherlands";
        data[28][1] = "English";
        data[28][2] = "Pack";
        
        data[29][0] = "Netherlands";
        data[29][1] = "Dutch";
        data[29][2] = "Pack";

        data[30][0] = "New Zealand";
        data[30][1] = "English";
        data[30][2] = "Pack";

        data[31][0] = "Norway";
        data[31][1] = "English";
        data[31][2] = "Pack";
        
        data[32][0] = "Norway";
        data[32][1] = "English";
        data[32][2] = "NoPack";
        
        data[33][0] = "Norway";
        data[33][1] = "Norwegian";
        data[33][2] = "Pack";

        data[34][0] = "Poland";
        data[34][1] = "English";
        data[34][2] = "Pack";
        
        data[35][0] = "Poland";
        data[35][1] = "Polish";
        data[35][2] = "Pack";

        data[36][0] = "Puerto Rico";
        data[36][1] = "Español";
        data[36][2] = "Pack";
        
        data[37][0] = "Puerto Rico";
        data[37][1] = "English";
        data[37][2] = "Pack";

        data[38][0] = "Sweden";
        data[38][1] = "Svenska";
        data[38][2] = "Pack";
        
        data[39][0] = "Sweden";
        data[39][1] = "English";
        data[39][2] = "Pack";
        
        data[40][0] = "Switzerland";
        data[40][1] = "Deutsch";
        data[40][2] = "Pack";
        
        data[41][0] = "Switzerland";
        data[41][1] = "English";
        data[41][2] = "Pack";
        
        data[42][0] = "Switzerland";
        data[42][1] = "Français";
        data[42][2] = "Pack";
        
        data[43][0] = "Switzerland";
        data[43][1] = "Italiano";
        data[43][2] = "Pack";

        data[44][0] = "Spain";
        data[44][1] = "English";
        data[44][2] = "Pack";
        
        data[45][0] = "Spain";
        data[45][1] = "Español";
        data[45][2] = "Pack";
        
        data[46][0] = "United States";
        data[46][1] = "English";
        data[46][2] = "Pack";
        
        data[47][0] = "United States";
        data[47][1] = "Español";
        data[47][2] = "Pack";

        data[48][0] = "Ukraine";
        data[48][1] = "English";
        data[48][2] = "Pack";
        
        data[49][0] = "Ukraine";
        data[49][1] = "русский";
        data[49][2] = "Pack";

        data[50][0] = "United Kingdom";
        data[50][1] = "English";
		data[50][2] = "Pack";
        
        
        
		
		
		/*data[0][0] = "Colombia";
		data[0][1] = "Español";
		data[0][2] = "Pack";*/
		
		

		return data;

	}
	
	Start start = new Start();
	InitialOrder packs = new InitialOrder();
	AutoRefill arpack = new AutoRefill();
	Account account = new Account();
	Payment payment = new Payment();
	Summary summary = new Summary();
	
	
	@Test(dataProvider="MarketConfig")
	public void Enroll(String Market, String language, String pack) throws InterruptedException, IOException, JSONException, ParseException {
		
		childtest = extent.startTest(Market + "  |  " + language);
		fp.appendChild(childtest);
		childtest.log(LogStatus.INFO, "FP Enrollment", "Platform   "+"<a href=" + url + ">" + userdata.get("platform") + "</a>");
		
		start.SelectMarket(Market, language);
		packs.PacksChecking(Market, language, pack);
		arpack.ARPacks(Market, pack);
		account.PersonalDetails(Market, language, pack);
		payment.PaymentDetails(Market, language, pack);
		summary.SummaryDetails(Market,language, pack);
	}
}
