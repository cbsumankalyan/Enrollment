package Pages;

import java.io.IOException;
import java.text.ParseException;

import POM.StartPage;

public class Start extends SuperTestNG{
	public void SelectMarket(String Market, String language) throws InterruptedException, IOException, ParseException{
		StartPage start = new StartPage(driver);
		start.Start(Market, language);
	}
	
	public void PCFlow(String Market, String language) throws InterruptedException, IOException, ParseException{
		StartPage start = new StartPage(driver);
		start.PC(Market, language);
	}
	
	public void PPFlow(String Market, String language) throws InterruptedException, IOException, ParseException{
		StartPage start = new StartPage(driver);
		start.PP(Market, language);
	}
	
	public void GetFitFlow(String Market, String language) throws InterruptedException, IOException, ParseException{
		StartPage start = new StartPage(driver);
		start.GetFitStart(Market, language);
	}
}