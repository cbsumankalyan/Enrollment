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

public class EUBankWire extends SuperTestNG {

	@DataProvider
	public Object[][] MarketConfig() {

		Object[][] data = new Object[36][4];

		data[0][0] = "Austria";
		data[0][1] = "English";
		data[0][2] = "NoPack";
		data[0][3] = "BankWire";

		data[1][0] = "Austria";
		data[1][1] = "Deutsch";
		data[1][2] = "NoPack";
		data[1][3] = "BankWire";

		data[2][0] = "Belgium";
		data[2][1] = "Français";
		data[2][2] = "NoPack";
		data[2][3] = "BankWire";

		data[3][0] = "Belgium";
		data[3][1] = "Dutch";
		data[3][2] = "NoPack";
		data[3][3] = "BankWire";

		data[4][0] = "Belgium";
		data[4][1] = "English";
		data[4][2] = "NoPack";
		data[4][3] = "BankWire";

		data[5][0] = "Denmark";
		data[5][1] = "English";
		data[5][2] = "NoPack";
		data[5][3] = "BankWire";

		data[6][0] = "Denmark";
		data[6][1] = "Danish";
		data[6][2] = "NoPack";
		data[6][3] = "BankWire";

		data[7][0] = "France";
		data[7][1] = "Français";
		data[7][2] = "NoPack";
		data[7][3] = "BankWire";

		data[8][0] = "France";
		data[8][1] = "English";
		data[8][2] = "NoPack";
		data[8][3] = "BankWire";

		data[9][0] = "Germany";
		data[9][1] = "Deutsch";
		data[9][2] = "NoPack";
		data[9][3] = "BankWire";

		data[10][0] = "Germany";
		data[10][1] = "English";
		data[10][2] = "NoPack";
		data[10][3] = "BankWire";

		data[11][0] = "Hungary";
		data[11][1] = "English";
		data[11][2] = "NoPack";
		data[11][3] = "BankWire";

		data[12][0] = "Hungary";
		data[12][1] = "Hungarian";
		data[12][2] = "NoPack";
		data[12][3] = "BankWire";

		data[13][0] = "Italy";
		data[13][1] = "Italiano";
		data[13][2] = "NoPack";
		data[13][3] = "BankWire";

		data[14][0] = "Italy";
		data[14][1] = "English";
		data[14][2] = "NoPack";
		data[14][3] = "BankWire";

		data[15][0] = "Ireland";
		data[15][1] = "English";
		data[15][2] = "NoPack";
		data[15][3] = "BankWire";

		data[16][0] = "Luxembourg";
		data[16][1] = "Français";
		data[16][2] = "NoPack";
		data[16][3] = "BankWire";

		data[17][0] = "Luxembourg";
		data[17][1] = "English";
		data[17][2] = "NoPack";
		data[17][3] = "BankWire";

		data[18][0] = "Luxembourg";
		data[18][1] = "Deutsch";
		data[18][2] = "NoPack";
		data[18][3] = "BankWire";

		data[19][0] = "Netherlands";
		data[19][1] = "English";
		data[19][2] = "NoPack";
		data[19][3] = "BankWire";

		data[20][0] = "Netherlands";
		data[20][1] = "Dutch";
		data[20][2] = "NoPack";
		data[20][3] = "BankWire";

		data[21][0] = "Norway";
		data[21][1] = "English";
		data[21][2] = "NoPack";
		data[21][3] = "BankWire";

		data[22][0] = "Norway";
		data[22][1] = "Norwegian";
		data[22][2] = "NoPack";
		data[22][3] = "BankWire";

		data[23][0] = "Poland";
		data[23][1] = "English";
		data[23][2] = "NoPack";
		data[23][3] = "BankWire";

		data[24][0] = "Poland";
		data[24][1] = "Polish";
		data[24][2] = "NoPack";
		data[24][3] = "BankWire";

		data[25][0] = "Sweden";
		data[25][1] = "Svenska";
		data[25][2] = "NoPack";
		data[25][3] = "BankWire";

		data[26][0] = "Sweden";
		data[26][1] = "English";
		data[26][2] = "NoPack";
		data[26][3] = "BankWire";

		data[27][0] = "Switzerland";
		data[27][1] = "Deutsch";
		data[27][2] = "NoPack";
		data[27][3] = "BankWire";

		data[28][0] = "Switzerland";
		data[28][1] = "English";
		data[28][2] = "NoPack";
		data[28][3] = "BankWire";

		data[29][0] = "Switzerland";
		data[29][1] = "Français";
		data[29][2] = "NoPack";
		data[29][3] = "BankWire";

		data[30][0] = "Switzerland";
		data[30][1] = "Italiano";
		data[30][2] = "NoPack";
		data[30][3] = "BankWire";

		data[31][0] = "Spain";
		data[31][1] = "English";
		data[31][2] = "NoPack";
		data[31][3] = "BankWire";

		data[32][0] = "Spain";
		data[32][1] = "Español";
		data[32][2] = "NoPack";
		data[32][3] = "BankWire";

		data[33][0] = "Ukraine";
		data[33][1] = "English";
		data[33][2] = "NoPack";
		data[33][3] = "BankWire";

		data[34][0] = "Ukraine";
		data[34][1] = "русский";
		data[34][2] = "NoPack";
		data[34][3] = "BankWire";

		data[35][0] = "United Kingdom";
		data[35][1] = "English";
		data[35][2] = "NoPack";
		data[35][3] = "BankWire";

		return data;

	}

	Start start = new Start();
	InitialOrder packs = new InitialOrder();
	AutoRefill arpack = new AutoRefill();
	Account account = new Account();
	Payment payment = new Payment();
	Summary summary = new Summary();

	@Test(dataProvider = "MarketConfig")
	public void BankWire(String Market, String language, String pack, String Payment)
			throws InterruptedException, JSONException, IOException, ParseException {

		childtest = BankWire
				.createNode("<b><font color=407899>" + Market + "  |  " + language + "  |  " + Payment + "</font></b>");
		childtest.log(Status.INFO, "Platfome   ->   " + "<a href=" + url + ">" + userdata.get("platform") + "</a>");
		System.out.println(Market + "  |  " + language + "  |  " + Payment);
		start.SelectMarket(Market, language);
		packs.PacksChecking(Market, language, pack, Payment);
		arpack.ARPacks(Market, pack, Payment);
		account.PersonalDetails(Market, language, pack, Payment);
		payment.PaymentDetails(Market, language, pack, Payment);
		summary.SummaryDetails(Market, language, pack, Payment);

	}
}
