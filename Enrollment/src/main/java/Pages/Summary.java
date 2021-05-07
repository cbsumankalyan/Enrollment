package Pages;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONException;

import POM.SummaryPage;

public class Summary extends SuperTestNG {
	public void SummaryDetails(String Market, String language, String pack, String Payment) throws InterruptedException, JsonGenerationException, JsonMappingException, IOException, JSONException{
		SummaryPage Details = new SummaryPage(driver);
		Details.OrderSubmit(Market, language, pack, Payment);
	}
	
	public void PCSummaryDetails(String Market, String language, String pack) throws InterruptedException, JsonGenerationException, JsonMappingException, IOException, JSONException{
		SummaryPage Details = new SummaryPage(driver);
		Details.PCOrderSubmit(Market, language, pack);
	}
	
	public void GetFitSummaryDetails(String Market, String language, String pack) throws InterruptedException, JsonGenerationException, JsonMappingException, IOException, JSONException{
		SummaryPage Details = new SummaryPage(driver);
		Details.GetFitOrderSubmit(Market, language, pack);
	}
}
