package Pages;

import POM.AutoRefillPage;

public class AutoRefill extends SuperTestNG{
	public void ARPacks(String country, String pack) throws InterruptedException{
		AutoRefillPage packs = new AutoRefillPage(driver);
		packs.AutoRefill(country, pack);
	}
}
