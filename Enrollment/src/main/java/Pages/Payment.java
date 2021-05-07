package Pages;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.json.JSONException;

import POM.PaymentPage;

public class Payment extends SuperTestNG {
	public void PaymentDetails(String Market, String langauge, String pack, String Payment) throws InterruptedException, JSONException, JsonGenerationException, JsonMappingException, IOException{
		PaymentPage Details = new PaymentPage(driver);
		Details.PaymentDetails(Market, langauge, pack, Payment);
		Details.ShippingDetails(Market, langauge, pack);
	}
}
