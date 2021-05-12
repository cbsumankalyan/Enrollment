package Pages;

import java.io.IOException;
import org.json.JSONException;
import POM.InitialOrderPage;

public class InitialOrder extends SuperTestNG{
	public void PacksChecking(String Market, String language, String pack, String Payment) throws InterruptedException, JSONException, IOException{
		InitialOrderPage packs = new InitialOrderPage(driver);
		packs.Packs(Market, language, pack, Payment);
		packs.AdditionalProducts(Market, pack, Payment);
	}
	
	public void PCPacksChecking(String Market, String language, String pack) throws InterruptedException, JSONException{
		InitialOrderPage packs = new InitialOrderPage(driver);
		packs.PCPacks(Market, language, pack);
		packs.PCAdditionalProducts(Market, pack);
	}
	
	public void GetFitPacks(String Market, String language, String pack) throws InterruptedException, JSONException, IOException{
		InitialOrderPage packs = new InitialOrderPage(driver);
		packs.GetFitPacks(Market, language, pack);
		
	}
}
