package Pages;

import java.io.IOException;
import java.net.UnknownHostException;

import org.json.JSONException;

import POM.AccountSetupPage;

public class Account extends SuperTestNG{
	public void PersonalDetails(String Market, String language, String pack) throws InterruptedException, JSONException, UnknownHostException, IOException{
		AccountSetupPage Details = new AccountSetupPage(driver);
		Details.AccountDetails(Market, language, pack);
	}
	
	public void PCPersonalDetails(String Market, String language, String pack) throws InterruptedException, JSONException, UnknownHostException, IOException{
		AccountSetupPage Details = new AccountSetupPage(driver);
		Details.PCAccountDetails(Market, language, pack);
	}
	
	public void GetFitPersonalDetails(String Market, String language, String pack) throws InterruptedException, JSONException, UnknownHostException, IOException{
		AccountSetupPage Details = new AccountSetupPage(driver);
		Details.GetFitAccountDetails(Market, language, pack);
	}
}
