package POM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import Pages.SuperTestNG;

public class PaymentPage extends SuperTestNG {

	@FindBys(@FindBy(xpath = "//h2"))
	List<WebElement> Headings;

	@FindBy(xpath = "(//ul[@class='summary-total colombia_sum_section']//li)[3]")
	private WebElement PersonalVolume;

	@FindBy(xpath = "//span[@class='ng-scope'][contains(.,'Pagos en Efectivo')]")
	private WebElement CashPayment;

	@FindBy(xpath = "//input[@value='sepaBankPayment']")
	private WebElement SEPA;

	@FindBy(xpath = "//input[@value='creditCard']")
	private WebElement CreditCard;

	@FindBys(@FindBy(xpath = "//input[@id='payment_option']"))
	List<WebElement> PaymentOptions;

	@FindBys(@FindBy(xpath = "//select[@id='cashpayoption']//option"))
	List<WebElement> CashBanks;

	@FindBy(xpath = "//select[@id='cashpayoption']")
	private WebElement SelectBank;

	@FindBy(xpath = "(//input[@id='confirm_sepa_bank_payment'])[2]")
	private WebElement ConfirmSEPA;

	@FindBy(id = "payment_account_number")
	private WebElement IBAN;

	@FindBy(id = "payment_bank_name")
	private WebElement BankName;

	@FindBy(id = "payment_account_holder")
	private WebElement AccHolder;

	@FindBy(id = "payment_bin")
	private WebElement BIC;

	@FindBy(id = "cc_name")
	private WebElement CCName;

	@FindBy(id = "cc_number")
	private WebElement CCNumber;

	@FindBy(xpath = "//select[@id='cc_exp_month']")
	private WebElement ExpiryMonth;

	@FindBy(xpath = "//select[@id='cc_exp_year']")
	private WebElement ExpiryYear;

	@FindBy(id = "cvv_code")
	private WebElement CVV;

	@FindBy(xpath = "//select[@id='address_country']//option[@selected='selected']")
	private WebElement SelectedBillingCountry;

	@FindBy(xpath = "(//h2)[2]")
	private WebElement BillingAddress;

	@FindBy(xpath = "(//h2)[3]")
	private WebElement ShippingAddress;

	@FindBy(xpath = "(//h2)[4]")
	private WebElement ShippingMethod;

	@FindBy(id = "address_line_1")
	private WebElement Address1;

	@FindBy(id = "address_line_2")
	private WebElement Address2;

	@FindBy(id = "address_postal_code")
	private WebElement PostalCode;

	@FindBy(id = "address_city")
	private WebElement City;

	@FindBy(xpath = "//select[@id='address_state']//option")
	List<WebElement> State;

	@FindBy(id = "address_state")
	private WebElement SelectState;

	@FindBy(xpath = "//select[@ng-model='order.payment.address.city']")
	private WebElement SelectOther;

	@FindBy(xpath = "//input[@ng-model='order.payment.address.city_other']")
	private WebElement SelectOtherCity;

	@FindBy(id = "shipping_address_line_1")
	private WebElement ShipAddress1;

	@FindBy(id = "shipping_address_postal_code")
	private WebElement ShipPostalCode;

	@FindBy(xpath = "//button[contains(@class, 'continue-btn')]")
	private WebElement Continue;

	@FindBy(xpath = "//button[@ng-click='useSuggestedAddress()']")
	private WebElement UseSuggestedAddress;

	@FindBy(xpath = "//button[@ng-click='continueWithSameAddress()']")
	private WebElement UseSameAddress;

	@FindBys(@FindBy(xpath = "//button[contains(@ng-click, 'Address()')]"))
	List<WebElement> SuggestedAddress;

	@FindBys(@FindBy(id = "shipping_method"))
	List<WebElement> ShipMethod;

	@FindBy(xpath = "//div[contains(@class,'modal-header')]")
	private WebElement Error;

	@FindBy(xpath = "//input[@value = 'bankWire']")
	private WebElement BankWireOption;
	
	@FindBy(xpath = "//span[contains(@ng-if, 'bankWire')]/div")
	private WebElement BankWire;

	public PaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void PaymentDetails(String Market, String language, String pack) throws IOException, InterruptedException {

		if (!(Market == "India" || pack == "NoPack" || Market == "Turkey")) {

			if (branch == "master") {

				Thread.sleep(10000);
				ArrayList<String> Labels = new ArrayList<String>();

				for (int i = 0; i < Headings.size() - 1; i++) {
					Labels.add(Headings.get(i).getText());
				}

				if (Market == "Australia" || Market == "Belgium" || Market == "Denmark" || Market == "France"
						|| Market == "Hungary" || Market == "Italy" || Market == "Ireland" || Market == "Luxembourg"
						|| Market == "New Zealand" || Market == "Sweden" || Market == "Spain" || Market == "Ukraine") {
					Assert.assertEquals(Labels.toString(), getTranslation("payment_eu", language), "Minor Labels");
				}

				if (Market == "Switzerland") {
					Assert.assertEquals(Labels.toString(), getTranslation("payment_ch", language), "Minor Labels");
				}

				if (Market == "Mexico") {
					Assert.assertEquals(Labels.toString(), getTranslation("mx", language), "Minor Labels");
				}

				if (Market == "Netherlands") {
					Assert.assertEquals(Labels.toString(), getTranslation("payment_nl", language), "Minor Labels");
				}

				if (Market == "Norway" || Market == "Poland") {
					Assert.assertEquals(Labels.toString(), getTranslation("payment_no", language), "Minor Labels");
				}

				if (Market == "Austria") {

					Assert.assertEquals(Labels.toString(), getTranslation("payment_eu_sepa", language), "Minor Labels");
				}

				if (Market == "Germany") {
					Assert.assertEquals(Labels.toString(), getTranslation("payment_eu_sepa_de", language),
							"Minor Labels");
				}

				if (Market == "Bahamas" || Market == "Canada" || Market == "Dominican Republic"
						|| Market == "United States" || Market == "Jamaica") {
					if (userdata.get("testcase") == "getfit") {
						Assert.assertEquals(Labels.toString(), getTranslation("getfit_payment_us", language),
								"Minor Labels");
					} else {
						Assert.assertEquals(Labels.toString(), getTranslation("payment_us", language), "Minor Labels");
					}
				}

				if (Market == "Colombia") {
					Assert.assertEquals(Labels.toString(), getTranslation("payment_co", language), "Minor Labels");
				}

				if (Market == "Puerto Rico") {
					Assert.assertEquals(Labels.toString(), getTranslation("payment_pr", language), "Minor Labels");
				}

			}

			String ccname = "CCNameTest";
			String cc = "4111111111111111";
			String mon = "10";
			String year = "2021";
			String cvv = "123";

			if (Market == "Austria" || Market == "Germany") {
				int pv = Integer.parseInt(PersonalVolume.getText());

				if (pv < 300) {

					try {
						Boolean NoPack = SEPA.isDisplayed();
						Assert.assertTrue(NoPack, "Major SEPA is Displaying");
						childtest.log(Status.INFO, "Payment ->" + "SEPA");

						int value = new Random().nextInt(PaymentOptions.size());
						PaymentOptions.get(value).click();

						if (value == 1) {
							SEPA.click();
							Thread.sleep(5000);
						}

					} catch (Exception e) {
						Assert.fail("Major SEPA is not Displaying");
					}
				} else {
					try {
						Boolean NoPack = SEPA.isDisplayed();
						Assert.assertFalse(NoPack, "Major SEPA is Displaying");
					} catch (Exception e) {
						Assert.fail("Major SEPA is not Displaying");
					}
				}
			}

			if (Market == "Austria" || Market == "Belgium" || Market == "Denmark" || Market == "France"
					|| Market == "Germany" || Market == "Hungary" || Market == "Italy" || Market == "Ireland"
					|| Market == "Luxembourg" || Market == "Netherlands" || Market == "Norway" || Market == "Poland"
					|| Market == "Sweden" || Market == "Switzerland" || Market == "Spain" || Market == "Ukraine"
					|| Market == "United Kingdom") {
				BankWireOption.click();
				
				if (Market == "Austria" || Market == "Belgium" || Market == "Denmark" || Market == "France"
						|| Market == "Germany" || Market == "Hungary" || Market == "Ireland"
						|| Market == "Luxembourg" || Market == "Netherlands" || Market == "Norway" || Market == "Poland"
						|| Market == "Sweden" ||  Market == "Spain" || Market == "Ukraine"
						|| Market == "United Kingdom"){

					Assert.assertEquals(BankWire.getText().toString(), getTranslation("bankwire_at", language), "Bank Wire Details");
		
				}
				
				if (Market == "Italy" ) {
					
					Assert.assertEquals(BankWire.getText().toString(), getTranslation("bankwire_it", language), "Bank Wire Details");
				}
				
				if (Market == "Switzerland") {
					
					Assert.assertEquals(BankWire.getText().toString(), getTranslation("bankwire_ch", language), "Bank Wire Details");
					
				}
				
			}
			if (Market == "Austria" || Market == "Germany") {
				if (SEPA.isSelected()) {
					String ATIBAN = "AT611904300234573201";
					String DEIBAN = "DE89370400440532013000";
					String bankname = "TestBankName";
					String holder = "TestName";
					String bic = "DEUTDEFF";
					ConfirmSEPA.click();
					if (Market == "Austria") {
						IBAN.sendKeys(ATIBAN);
						userdata.put("sepaiban", ATIBAN);
						childtest.log(Status.INFO, ATIBAN);
					}
					if (Market == "Germany") {
						IBAN.sendKeys(DEIBAN);
						userdata.put("sepaiban", DEIBAN);
						childtest.log(Status.INFO, DEIBAN);
					}
					BankName.sendKeys(bankname);
					AccHolder.sendKeys(holder);
					BIC.sendKeys(bic);

					userdata.put("payment", "sepa");
					userdata.put("sepabankname", bankname);
					userdata.put("sepaholder", holder);
					userdata.put("sepabic", bic);
				}
				if (CreditCard.isSelected()) {
					CCName.sendKeys(ccname);
					CCNumber.sendKeys(cc);
					new Select(ExpiryMonth).selectByVisibleText(mon);
					new Select(ExpiryYear).selectByVisibleText(year);
					CVV.sendKeys(cvv);
					childtest.log(Status.INFO, "Payment ->" + ccname);
					childtest.log(Status.INFO, cc);
					childtest.log(Status.INFO, mon);
					childtest.log(Status.INFO, year);
					childtest.log(Status.INFO, cvv);
				}
			}

			if (Market == "Mexico") {
				if (Float.parseFloat(userdata.get("cartprice")) <= 1000.00) {
					try {
						Boolean NoPack = CashPayment.isDisplayed();
						Assert.assertTrue(NoPack, "Major CashPayment is Displaying");
						childtest.log(Status.INFO, "Payment ->" + "Cash");

					} catch (Exception e) {
						Assert.fail("Major CashPayment is not Displaying");
					}

					int value = new Random().nextInt(PaymentOptions.size());
					PaymentOptions.get(value).click();

					Thread.sleep(5000);
					if (value == 1) {
						String[] Bank = { "Seleccione Banco", "SCOTIABANK", "SANTANDER", "BANCOMER", "OXXO",
								"7-ELEVEN" };

						for (int i = 0; i < Bank.length; i++) {
							Assert.assertEquals(CashBanks.get(i).getText(), Bank[i]);
						}

						String[] bank = { "SCOTIABANK", "SANTANDER", "BANCOMER", "OXXO", "7-ELEVEN" };

						Select selectbank = new Select(SelectBank);
						String b = bank[new Random().nextInt(bank.length)];
						selectbank.selectByValue(b);
						userdata.put("paymenttype", "bank");
						userdata.put("mxbank", b);
						Thread.sleep(5000);
						childtest.log(Status.INFO, "Bank ->" + b);
					} else {
						CCName.sendKeys(ccname);
						CCNumber.sendKeys(cc);
						new Select(ExpiryMonth).selectByVisibleText(mon);
						new Select(ExpiryYear).selectByVisibleText(year);
						CVV.sendKeys(cvv);
						childtest.log(Status.INFO, "Payment ->" + ccname);
						childtest.log(Status.INFO, cc);
						childtest.log(Status.INFO, mon);
						childtest.log(Status.INFO, year);
						childtest.log(Status.INFO, cvv);
						userdata.put("paymenttype", "creditcard");
					}
				} else {
					CCName.sendKeys(ccname);
					CCNumber.sendKeys(cc);
					new Select(ExpiryMonth).selectByVisibleText(mon);
					new Select(ExpiryYear).selectByVisibleText(year);
					CVV.sendKeys(cvv);
					childtest.log(Status.INFO, "Payment ->" + ccname);
					childtest.log(Status.INFO, cc);
					childtest.log(Status.INFO, mon);
					childtest.log(Status.INFO, year);
					childtest.log(Status.INFO, cvv);
					userdata.put("paymenttype", "creditcard");
				}
			}

			if (!(Market == "Austria" || Market == "Belgium" || Market == "Denmark" || Market == "France"
					|| Market == "Germany" || Market == "Hungary" || Market == "Italy" || Market == "Ireland"
					|| Market == "Luxembourg" || Market == "Netherlands" || Market == "Norway" || Market == "Poland"
					|| Market == "Sweden" || Market == "Switzerland" || Market == "Spain" || Market == "Ukraine"
					|| Market == "United Kingdom" || Market == "Mexico")) {
				CCName.sendKeys(ccname);
				CCNumber.sendKeys(cc);
				new Select(ExpiryMonth).selectByVisibleText(mon);
				new Select(ExpiryYear).selectByVisibleText(year);
				CVV.sendKeys(cvv);
				childtest.log(Status.INFO, "Payment ->" + ccname);
				childtest.log(Status.INFO, cc);
				childtest.log(Status.INFO, mon);
				childtest.log(Status.INFO, year);
				childtest.log(Status.INFO, cvv);
			}

			userdata.put("ccname", ccname);
		}
	}

	public void ShippingDetails(String Market, String language, String pack) throws InterruptedException, IOException {
		if (!(Market == "India" || pack == "NoPack" || Market == "Turkey")) {
			String address1 = "Address 1";
			String address2 = "Address 2";
			String postal = "1234";
			String city = "TestCity";

			String usaddress = "1209 N 800 E";
			String uspostal = "84097";
			String capostal = "B4V2K4";
			String prpostal = "00907";

			String usotheraddress = "4209 E STONECREEK";
			String usotherzip = "33024";

			if (Market == "Bahamas") {
				Assert.assertEquals(SelectedBillingCountry.getText(), "Bahamas", "Major Billing country");
			}

			if (!(userdata.get("testcase") == "getfit")) {
				if (Market == "Canada") {
					Assert.assertEquals(SelectedBillingCountry.getText(), "Canada", "Major Billing country");
				}
			}

			if (Market == "Dominican Republic") {
				Assert.assertEquals(SelectedBillingCountry.getText(), "Dominican Republic", "Major Billing country");
			}

			if (Market == "Jamaica") {
				Assert.assertEquals(SelectedBillingCountry.getText(), "Jamaica", "Major Billing country");
			}

			if (!(userdata.get("testcase") == "getfit")) {
				if (Market == "Puerto Rico" || Market == "United States") {
					Assert.assertEquals(SelectedBillingCountry.getText(), "United States", "Major Billing country");
				}
			}

			if (!(Market == "United States")) {
				Address1.sendKeys(address1);
				Address2.sendKeys(address2);
				childtest.log(Status.INFO, address1);
				childtest.log(Status.INFO, address2);
				userdata.put("address1", address1);
				userdata.put("address2", address2);
			}
			if (Market == "United States") {
				if (language == "English") {
					Address1.sendKeys(usotheraddress);
					userdata.put("address1", usotheraddress);
					childtest.log(Status.INFO, usotheraddress);
				} else {
					Address1.sendKeys(usaddress);
					userdata.put("address1", usaddress);
					childtest.log(Status.INFO, usaddress);
				}
			}

			if (Market == "France" || Market == "Germany" || Market == "Sweden" || Market == "Spain"
					|| Market == "Ukraine" || Market == "Italy" || Market == "Mexico") {
				PostalCode.sendKeys(uspostal);
				childtest.log(Status.INFO, uspostal);
				userdata.put("zip", uspostal);
			}

			if (Market == "Australia" || Market == "Austria" || Market == "Belgium" || Market == "Denmark"
					|| Market == "Hungary" || Market == "Ireland" || Market == "Luxembourg" || Market == "Netherlands"
					|| Market == "New Zealand" || Market == "Norway" || Market == "Switzerland") {
				PostalCode.sendKeys(postal);
				childtest.log(Status.INFO, postal);
				userdata.put("zip", postal);
			}

			if (Market == "Poland") {
				PostalCode.sendKeys("09-876");
				childtest.log(Status.INFO, "09-876");
				userdata.put("zip", "09-876");
			}
			if (Market == "United Kingdom") {
				PostalCode.sendKeys("ASCN 1ZZ");
				childtest.log(Status.INFO, "ASCN 1ZZ");
				userdata.put("zip", "ASCN 1ZZ");
			}
			if (Market == "Canada") {
				PostalCode.sendKeys(capostal);
				Thread.sleep(5000);
				childtest.log(Status.INFO, capostal);
				userdata.put("zip", capostal);
				userdata.put("city", "BRIDGEWATER");
			}
			if (Market == "United States") {
				if (language == "English") {
					PostalCode.sendKeys(usotherzip);
					Thread.sleep(5000);

					Select selectother = new Select(SelectOther);
					selectother.selectByVisibleText("Other");
					SelectOtherCity.sendKeys("HOLLYWOOD");
					Thread.sleep(5000);

					childtest.log(Status.INFO, usotherzip);
					userdata.put("zip", usotherzip);
				} else {
					PostalCode.sendKeys(uspostal);
					Thread.sleep(5000);
					childtest.log(Status.INFO, uspostal);
					userdata.put("zip", uspostal);
				}
			}
			if (Market == "Puerto Rico") {
				PostalCode.sendKeys(prpostal);
				PostalCode.sendKeys(Keys.TAB);
				Thread.sleep(10000);
				childtest.log(Status.INFO, prpostal);
				userdata.put("zip", prpostal);
				userdata.put("city", "SAN JUAN");
				Thread.sleep(10000);
			}
			if (!(Market == "Canada" || Market == "Puerto Rico" || Market == "United States")) {
				City.sendKeys(city);
				childtest.log(Status.INFO, city);
				userdata.put("city", city);
			}
			if (Market == "Australia") {
				String[] state = { "Select a state", "Australian Capital Territory", "New South Wales",
						"Northern Territory", "Queensland", "South Australia", "Tasmania", "Victoria",
						"Western Australia", };
				for (int i = 0; i < state.length; i++) {
					Assert.assertEquals(State.get(i).getText(), state[i]);
				}
				String[] State = { "0", "1", "2", "3", "4", "5", "6", "7" };
				Select selectshipstate = new Select(SelectState);
				String value = State[new Random().nextInt(State.length)];
				selectshipstate.selectByValue(value);

				WebElement v = driver
						.findElement(By.xpath("//select[@id='address_state']/option[@value=" + value + "]"));

				userdata.put("state", v.getText());

			}
			if (Market == "Bahamas") {
				String[] state = { "Select a state", "Acklins and Crooked Islands", "Bimini", "Cat Island", "Exuma",
						"Freeport", "Fresh Creek", "Governor's Harbour", "Green Turtle Cay", "Harbour Island",
						"High Rock", "Inagua", "Kemps Bay", "Long Island", "Marsh Harbour", "Mayaguana",
						"New Providence", "Nicholls Town and Berry Islands", "Ragged Island", "Rock Sound",
						"San Salvador and Rum Cay", "Sandy Point", };

				for (int i = 0; i < state.length; i++) {
					Assert.assertEquals(State.get(i).getText(), state[i]);
				}
				String[] State = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "16",
						"17", "18", "19", "20" };

				Select selectshipstate = new Select(SelectState);
				selectshipstate.selectByValue(State[new Random().nextInt(State.length)]);

			}

			if (Market == "Dominican Republic") {
				String[] state = { "seleccione un estado", "Azua", "Bahoruco", "Barahona", "Dajabon",
						"Distrito Nacional", "Duarte", "El Seibo", "Elias Pina", "Espaillat", "Hato Mayor",
						"Independencia", "La Altagracia", "La Romana", "La Vega", "Maria Trinidad Sanchez",
						"Monsenor Nouel", "Monte Cristi", "Monte Plata", "Pedernales", "Peravia", "Puerto Plata",
						"Salcedo", "Samana", "San Cristobal", "San Juan", "San Pedro de Macoris", "Sanchez Ramirez",
						"Santiago", "Santiago Rodriguez", "Valverde", };

				for (int i = 0; i < state.length; i++) {
					Assert.assertEquals(State.get(i).getText(), state[i]);
				}
				String[] State = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29" };

				Select selectshipstate = new Select(SelectState);
				selectshipstate.selectByValue(State[new Random().nextInt(State.length)]);
			}

			if (Market == "Colombia") {
				String[] state = { "seleccione un estado", "Amazonas", "Antioquia", "Arauca", "Atlantico", "Bolivar",
						"Boyaca", "Caldas", "Caqueta", "Casanare", "Cauca", "Cesar", "Choco", "Cordoba", "Cundinamarca",
						"Distrito Capital de Bogota", "Guainia", "Guaviare", "Huila", "La Guajira", "Magdalena", "Meta",
						"Narino", "Norte de Santander", "Putumayo", "Quindio", "Risaralda", "Santa Catalina",
						"Santander", "Sucre", "Tolima", "Valle del Cauca", "Vaupes", "Vichada", };

				for (int i = 0; i < state.length; i++) {
					Assert.assertEquals(State.get(i).getText(), state[i]);
				}
				String[] State = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31",
						"32" };

				Select selectshipstate = new Select(SelectState);
				selectshipstate.selectByValue(State[new Random().nextInt(State.length)]);
			}

			if (Market == "Jamaica") {
				String[] state = { "Select a state", "Clarendon", "Hanover", "Kingston", "Manchester", "Portland",
						"Saint Andrew", "Saint Ann", "Saint Catherine", "Saint Elizabeth", "Saint James", "Saint Mary",
						"Saint Thomas", "Trelawny", "Westmoreland", };

				for (int i = 0; i < state.length; i++) {
					Assert.assertEquals(State.get(i).getText(), state[i]);
				}

				String[] State = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" };
				Select selectshipstate = new Select(SelectState);
				selectshipstate.selectByValue(State[new Random().nextInt(State.length)]);
			}

			if (Market == "Mexico") {
				String[] state = { "seleccione un estado", "Aguascalientes", "Baja California", "Baja California Sur",
						"Campeche", "Chiapas", "Chihuahua", "Ciudad de México", "Coahuila", "Colima", "Durango",
						"Estado de México", "Guanajuato", "Guerrero", "Hidalgo", "Jalisco", "Michoacan", "Morelos",
						"Nayarit", "Nuevo Leon", "Oaxaca", "Puebla", "Querétaro", "Quintana Roo", "San Luis Potosi",
						"Sinaloa", "Sonora", "Tabasco", "Tamaulipas", "Tlaxcala", "Veracruz", "Yucatan", "Zacatecas", };

				for (int i = 0; i < state.length; i++) {
					Assert.assertEquals(State.get(i).getText(), state[i]);
				}

				String[] State = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };

				Select selectshipstate = new Select(SelectState);
				selectshipstate.selectByValue(State[new Random().nextInt(State.length)]);
			}

			if (Market == "New Zealand") {
				String[] state = { "Select a state", "Auckland", "Bay of Plenty", "Canterbury", "Gisborne",
						"Hawkes Bay", "Manawatu-Wanganui", "Marlborough", "Nelson", "Northland", "Otago", "Southland",
						"Taranaki", "Tasman", "Waikato", "Wellington", "West Coast" };

				for (int i = 0; i < state.length; i++) {
					Assert.assertEquals(State.get(i).getText(), state[i]);
				}

				String[] State = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
				Select selectshipstate = new Select(SelectState);
				selectshipstate.selectByValue(State[new Random().nextInt(State.length)]);
			}

			if (Market == "Bahamas" || Market == "Dominican Republic" || Market == "Jamaica") {
				ShipAddress1.sendKeys(usaddress);
				ShipPostalCode.sendKeys(uspostal);
				Thread.sleep(2000);
				childtest.log(Status.INFO, "Shipping ->" + usaddress);
				childtest.log(Status.INFO, uspostal);
				userdata.put("address1", usaddress);
				userdata.put("zip", uspostal);
				userdata.put("city", "OREM");
				Thread.sleep(10000);

			}
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)", "");
			int value = new Random().nextInt(ShipMethod.size());
			ShipMethod.get(value).click();
			Thread.sleep(5000);
			userdata.put("shippingmethod", ShipMethod.get(value).getAttribute("value"));
			childtest.log(Status.INFO, "Ship method ->" + userdata.get("shippingmethod").split("=")[1]);
			Thread.sleep(10000);

			if (Market == "Bahamas" || Market == "Dominican Republic" || Market == "Jamaica"
					|| Market == "United States" || Market == "Canada" || Market == "Puerto Rico") {

				if (Market == "Bahamas" || Market == "Jamaica" || Market == "United States") {
					userdata.put("city", "OREM");
				} else {

				}
				if (Market == "United States") {
					if (language == "English") {
						userdata.put("city", "HOLLYWOOD");

					} else {

					}
				} else {

				}
			}

			Continue.click();

			if (Market == "Bahamas" || Market == "Dominican Republic" || Market == "Jamaica"
					|| Market == "United States") {
				try {
					int count = new Random().nextInt(SuggestedAddress.size());
					SuggestedAddress.get(count).click();
					if (count == 0) {
						if (Market == "United States") {
							if (language == "English") {
								userdata.put("address1", "4209 E STONECREEK CIR");
							}
						}
					}
				} catch (Exception e) {
					Assert.fail("Critical Suggested Address Pop up");
				}
				Thread.sleep(10000);
				try {
					Boolean error = Error.isDisplayed();
					if (error == true) {
						Assert.fail("Critical Back end error");
					}
				} catch (Exception e) {
					/* System.out.println("No Pop UP"); */
				}
			}
		}
	}
}
