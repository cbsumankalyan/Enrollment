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

public class FranchisePartner extends SuperTestNG {
	
	@DataProvider
	public Object[][] MarketConfig() {

		Object[][] data = new Object[51][3];

		data[0][0] = "Austria";
		data[0][1] = "English";
		data[0][2] = "Pack";

		data[1][0] = "Austria";
		data[1][1] = "Deutsch";
		data[1][2] = "Pack";

		data[2][0] = "Bahamas";
		data[2][1] = "English";
		data[2][2] = "Pack";

		data[3][0] = "Belgium";
		data[3][1] = "Français";
		data[3][2] = "Pack";

		data[4][0] = "Belgium";
		data[4][1] = "Dutch";
		data[4][2] = "Pack";

		data[5][0] = "Belgium";
		data[5][1] = "English";
		data[5][2] = "Pack";

		data[6][0] = "Canada";
		data[6][1] = "English";
		data[6][2] = "Pack";

		data[7][0] = "Canada";
		data[7][1] = "Français";
		data[7][2] = "Pack";

		data[8][0] = "Colombia";
		data[8][1] = "Español";
		data[8][2] = "Pack";
		
		data[9][0] = "Denmark";
        data[9][1] = "English";
        data[9][2] = "Pack";
        
        data[10][0] = "Denmark";
        data[10][1] = "Danish";
        data[10][2] = "Pack";
        
        data[11][0] = "Dominican Republic";
        data[11][1] = "Español";
        data[11][2] = "Pack";

        data[12][0] = "France";
        data[12][1] = "Français";
        data[12][2] = "Pack";
       
        data[13][0] = "France";
        data[13][1] = "English";
        data[13][2] = "Pack";

        data[14][0] = "Germany";
        data[14][1] = "Deutsch";
        data[14][2] = "Pack";
        
        data[15][0] = "Germany";
        data[15][1] = "English";
        data[15][2] = "Pack";

        data[16][0] = "Hungary";
        data[16][1] = "English";
        data[16][2] = "Pack";
        
        data[17][0] = "Hungary";
        data[17][1] = "Hungarian";
        data[17][2] = "Pack";

        data[18][0] = "India";
        data[18][1] = "English";
        data[18][2] = "NoPack";

        data[19][0] = "Italy";
        data[19][1] = "Italiano";
        data[19][2] = "Pack";
        
        data[20][0] = "Italy";
        data[20][1] = "English";
        data[20][2] = "Pack";
        
        data[21][0] = "Ireland";
        data[21][1] = "English";
        data[21][2] = "Pack";

        data[22][0] = "Jamaica";
        data[22][1] = "English";
        data[22][2] = "Pack";

        data[23][0] = "Luxembourg";
        data[23][1] = "Français";
        data[23][2] = "Pack";
        
        data[24][0] = "Luxembourg";
        data[24][1] = "English";
        data[24][2] = "Pack";
        
        data[25][0] = "Luxembourg";
        data[25][1] = "Deutsch";
        data[25][2] = "Pack";

        data[26][0] = "Mexico";
        data[26][1] = "Español";
        data[26][2] = "Pack";

        data[27][0] = "Netherlands";
        data[27][1] = "English";
        data[27][2] = "Pack";
        
        data[28][0] = "Netherlands";
        data[28][1] = "Dutch";
        data[28][2] = "Pack";

        data[29][0] = "Norway";
        data[29][1] = "English";
        data[29][2] = "Pack";
        
        data[30][0] = "Norway";
        data[30][1] = "English";
        data[30][2] = "NoPack";
        
        data[31][0] = "Norway";
        data[31][1] = "Norwegian";
        data[31][2] = "Pack";

        data[32][0] = "Poland";
        data[32][1] = "English";
        data[32][2] = "Pack";
        
        data[33][0] = "Poland";
        data[33][1] = "Polish";
        data[33][2] = "Pack";

        data[34][0] = "Puerto Rico";
        data[34][1] = "Español";
        data[34][2] = "Pack";
        
        data[35][0] = "Puerto Rico";
        data[35][1] = "English";
        data[35][2] = "Pack";

        data[36][0] = "Sweden";
        data[36][1] = "Svenska";
        data[36][2] = "Pack";
        
        data[37][0] = "Sweden";
        data[37][1] = "English";
        data[37][2] = "Pack";
        
        data[38][0] = "Switzerland";
        data[38][1] = "Deutsch";
        data[38][2] = "Pack";
        
        data[39][0] = "Switzerland";
        data[39][1] = "English";
        data[39][2] = "Pack";
        
        data[40][0] = "Switzerland";
        data[40][1] = "Français";
        data[40][2] = "Pack";
        
        data[41][0] = "Switzerland";
        data[41][1] = "Italiano";
        data[41][2] = "Pack";

        data[42][0] = "Spain";
        data[42][1] = "English";
        data[42][2] = "Pack";
        
        data[43][0] = "Spain";
        data[43][1] = "Español";
        data[43][2] = "Pack";
        
        data[44][0] = "United States";
        data[44][1] = "English";
        data[44][2] = "Pack";
        
        data[45][0] = "United States";
        data[45][1] = "Español";
        data[45][2] = "Pack";
        
        data[46][0] = "Turkey";
        data[46][1] = "English";
        data[46][2] = "NoPack";
        
        data[47][0] = "Turkey";
        data[47][1] = "Türkçe";
        data[47][2] = "NoPack";

        data[48][0] = "Ukraine";
        data[48][1] = "English";
        data[48][2] = "Pack";
        
        data[49][0] = "Ukraine";
        data[49][1] = "русский";
        data[49][2] = "Pack";

        data[50][0] = "United Kingdom";
        data[50][1] = "English";
		data[50][2] = "Pack";
       
		/*data[0][0] = "Austria";
		data[0][1] = "English";
		data[0][2] = "Pack";

		data[1][0] = "Austria";
		data[1][1] = "Deutsch";
		data[1][2] = "Pack";*/
		
		

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
		
		childtest = fp.createNode(Market + "  |  " + language);
		childtest.log(Status.INFO, "FP Enrollment Platform  ->"+"<a href=" + url + ">" + userdata.get("platform") + "</a>");
		
		start.SelectMarket(Market, language);
		packs.PacksChecking(Market, language, pack);
		arpack.ARPacks(Market, pack);
		account.PersonalDetails(Market, language, pack);
		payment.PaymentDetails(Market, language, pack);
		summary.SummaryDetails(Market,language, pack);
	}
}
