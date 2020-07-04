package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps {

	static WebDriver driver;
	public static String getcurrentdateandtime(){
		String str = null;
		try{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
		Date date = new Date(); //current system date time
		str= dateFormat.format(date);
		str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
		}
		catch(Exception E)
		{
		E.printStackTrace();
		}
		return str;
		}
	// opening Chrome browser
	@Given("^Open the browser$")
	public void open_the_browser() {

		String projectPath = System.getProperty("user.dir");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//FirefoxOptions options = new FirefoxOptions();
		//options.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		//WebDriverManager.firefoxdriver().setup();
		//driver = new FirefoxDriver();
		driver.get("https://149.122.54.224/");
	}

	@Given("^Enter the URL$")
	public void enter_the_URL() throws InterruptedException {
		// Entering scoot url
		//driver.get("https://149.122.54.224/");
		// Maximizing window
		driver.manage().window().maximize();
		// Handling security issue
		driver.findElement(By.xpath("//button[@id='details-button']")).click();
		driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
		Thread.sleep(3000);
	}

	/*
	 * @When("^Enter the details and click on search$") public void
	 * enter_the_details_and_click_on_search(DataTable credentials) throws
	 * InterruptedException, ParseException {
	 * 
	 * List<List<String>> data = credentials.raw(); int val=data.size();
	 * System.out.println("The length of val is"+val); for(int i=0;i<val;i++) {
	 * 
	 * driver.findElement(By.xpath("(//span[text()='One way'])[1]")).click();
	 * Thread.sleep(2000); // driver.findElement(By.xpath(
	 * "//div[@class='cc-compliance']//child::a[text()='Continue']")).click();
	 * driver.findElement(By.
	 * xpath("//div[@class='field field__from country-input']//input[@class='form-control form-input']"
	 * )).click(); driver.findElement(By.
	 * xpath("(//input[@placeholder='From (Country/Region)'])[1]")).clear();
	 * driver.findElement(By.
	 * xpath("(//input[@placeholder='From (Country/Region)'])[1]")).sendKeys(data.
	 * get(i).get(0)); driver.findElement(By.partialLinkText("SIN")).click();
	 * Thread.sleep(2000); driver.findElement(By.
	 * xpath("(//input[@placeholder='To (Country/Region)'])[1]")).click();
	 * driver.findElement(By.
	 * xpath("(//input[@placeholder='To (Country/Region)'])[1]")).clear();
	 * driver.findElement(By.
	 * xpath("(//input[@placeholder='To (Country/Region)'])[1]")).sendKeys(data.get(
	 * i).get(1)); driver.findElement(By.partialLinkText("KUL")).click();
	 * Thread.sleep(5000);
	 * 
	 * //driver.findElement(By.xpath("(//input[@datevalue='depart'])[1]")).click();
	 * //Thread.sleep(2000);
	 * if(!driver.findElement(By.xpath("(//input[@datevalue='depart'])[1]")).
	 * isDisplayed()) {
	 * driver.findElement(By.xpath("(//input[@datevalue='depart'])[1]")).click(); }
	 * //driver.findElement(By.xpath("//a[@title='Next']")).click();
	 * Thread.sleep(2000); String fdate ="2 January 2021"; String[]
	 * vdate=fdate.split("\\s"); int day= Integer.parseInt(vdate[0]); int year=
	 * Integer.parseInt(vdate[2]); Date date = new
	 * SimpleDateFormat("MMM").parse(vdate[1]); Calendar cal =
	 * Calendar.getInstance(); cal.setTime(date); int
	 * month=cal.get(Calendar.MONTH)+1 ; System.out.println(day);
	 * System.out.println(month); System.out.println(year); LocalDate
	 * currentdate=LocalDate.now(); int dom=currentdate.getDayOfMonth(); int
	 * mon=currentdate.getMonthValue();
	 * System.out.println("Current months is "+mon);
	 * 
	 * int year2=currentdate.getYear(); System.out.println(year2);
	 * //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); Date d1=new
	 * Date(year-1900,month-1,day); //Date d1=format.parse(source) Date d2= new
	 * Date(year2-1900,mon-1,dom); System.out.println(d1); System.out.println(d2);
	 * 
	 * String monthscreen=driver.findElement(By.xpath(
	 * "(//div[@class='ui-datepicker-title']//span[@class=\"ui-datepicker-month\"])[1]"
	 * )).getText(); int yearscreen= Integer.parseInt(driver.findElement(By.xpath(
	 * "(//div[@class='ui-datepicker-title']//span[@class=\"ui-datepicker-year\"])[2]"
	 * )).getText()); if(yearscreen!=year) { while( yearscreen<year ||
	 * !monthscreen.equalsIgnoreCase(vdate[1])) { Thread.sleep(2000);
	 * driver.findElement(By.xpath("//a[@title='Next']")).click(); yearscreen=
	 * Integer.parseInt(driver.findElement(By.xpath(
	 * "(//div[@class='ui-datepicker-title']//span[@class=\"ui-datepicker-year\"])[2]"
	 * )).getText()); monthscreen=driver.findElement(By.xpath(
	 * "(//div[@class='ui-datepicker-title']//span[@class=\"ui-datepicker-month\"])[1]"
	 * )).getText();
	 * 
	 * } month=month-1; } else if(month>=mon+2) { while(month>=mon+2) {
	 * Thread.sleep(2000);
	 * driver.findElement(By.xpath("//a[@title='Next']")).click(); mon++; } }
	 * 
	 * //driver.findElement(By.xpath(
	 * "//div[@id='ui-datepicker-div']//descendant::td[@data-month='"+ month
	 * +"' and data-year='"+ year +"']//child::a[text()='"+day+"']")).click();
	 * driver.findElement(By.
	 * xpath("//div[@id='ui-datepicker-div']//descendant::td[@data-month=\"0\" and @data-year='2021']//child::a[text()='2']"
	 * )).click(); //driver.findElement(By.xpath(
	 * "//div[@id='ui-datepicker-div']//following::div[2]//descendant::a[text()='24']"
	 * )).click(); Thread.sleep(2000); WebElement
	 * letsgobtn=driver.findElement(By.xpath("(//button[@type='submit'])[7]"));
	 * letsgobtn.click(); Thread.sleep(3000); } }
	 */
	@When("^Enter the origin \"([^\"]*)\" and  destination \"([^\"]*)\"$")
	public void enter_the_origin_and_destination(String origin, String destination)
			throws InterruptedException, ParseException {
		// select one way
		driver.findElement(By.xpath("(//span[text()='One way'])[1]")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//div[@class='cc-compliance']//child::a[text()='Continue']")).click();
		// select departure date
		driver.findElement(
				By.xpath("//div[@class='field field__from country-input']//input[@class='form-control form-input']"))
				.click();
		driver.findElement(By.xpath("(//input[@placeholder='From (Country/Region)'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@placeholder='From (Country/Region)'])[1]")).sendKeys(origin);
		driver.findElement(By.partialLinkText(origin)).click();
		Thread.sleep(2000);
		// select destination
		driver.findElement(By.xpath("(//input[@placeholder='To (Country/Region)'])[1]")).click();
		driver.findElement(By.xpath("(//input[@placeholder='To (Country/Region)'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@placeholder='To (Country/Region)'])[1]")).sendKeys(destination);
		driver.findElement(By.partialLinkText(destination)).click();
		Thread.sleep(5000);

		// driver.findElement(By.xpath("(//input[@datevalue='depart'])[1]")).click();
		// Thread.sleep(2000);
		if (!driver.findElement(By.xpath("(//input[@datevalue='depart'])[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//input[@datevalue='depart'])[1]")).click();
		}
		// driver.findElement(By.xpath("//a[@title='Next']")).click();
		Thread.sleep(2000);

	}

	@When("^Enter the date of booking \"([^\"]*)\" and click on search$")
	public void enter_the_date_of_booking_and_click_on_search(String fdate) throws ParseException, InterruptedException {
		// handling date picker to select date
		// String fdate ="2 January 2021";
		String[] vdate = fdate.split("\\s");
		int day = Integer.parseInt(vdate[0]);
		int year = Integer.parseInt(vdate[2]);
		Date date = new SimpleDateFormat("MMM").parse(vdate[1]);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH) + 1;
		System.out.println(day);
		System.out.println(month);
		System.out.println(year);
		LocalDate currentdate = LocalDate.now();
		int dom = currentdate.getDayOfMonth();
		int mon = currentdate.getMonthValue();
		System.out.println("Current months is " + mon);

		int year2 = currentdate.getYear();
		System.out.println(year2);
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = new Date(year - 1900, month - 1, day);
		// Date d1=format.parse(source)
		Date d2 = new Date(year2 - 1900, mon - 1, dom);
		System.out.println(d1);
		System.out.println(d2);

		String monthscreen = driver
				.findElement(By.xpath("(//div[@class='ui-datepicker-title']//span[@class=\"ui-datepicker-month\"])[1]"))
				.getText();
		int yearscreen = Integer.parseInt(driver
				.findElement(By.xpath("(//div[@class='ui-datepicker-title']//span[@class=\"ui-datepicker-year\"])[2]"))
				.getText());
		if (yearscreen != year) {
			while (yearscreen < year || !monthscreen.equalsIgnoreCase(vdate[1])) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@title='Next']")).click();
				yearscreen = Integer.parseInt(driver
						.findElement(By
								.xpath("(//div[@class='ui-datepicker-title']//span[@class=\"ui-datepicker-year\"])[2]"))
						.getText());
				monthscreen = driver
						.findElement(By.xpath(
								"(//div[@class='ui-datepicker-title']//span[@class=\"ui-datepicker-month\"])[1]"))
						.getText();

			}
			month = month - 1;
		} else if (month >= mon + 2) {
			while (month >= mon + 2) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@title='Next']")).click();
				mon++;
			}
			month = month - 1;
		} else {
			month = month - 1;
		}
		System.out.println("month is" + month);
		System.out.println("year is" + year);
		System.out.println("day is" + day);
		// driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//descendant::td[@data-month='"+
		// month +"' and data-year='"+ year +"']//child::a[text()='"+day+"']")).click();
		// driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//descendant::td[@data-month=\"0\"
		// and @data-year='2021']//child::a[text()='2']")).click();
		// driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//descendant::td[@data-month='"month"'
		// and data-year='"year"']//child::a[text()='"day"']")).click();
		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//descendant::td[@data-month="
				+ Integer.toString(month) + " and @data-year='" + Integer.toString(year) + "']//child::a[text()='"
				+ Integer.toString(day) + "']")).click();
		// driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//following::div[2]//descendant::a[text()='24']")).click();
		Thread.sleep(2000);
		WebElement letsgobtn = driver.findElement(By.xpath("(//button[@type='submit'])[7]"));
		letsgobtn.click();
		Thread.sleep(3000);
	}

	@When("^Select the flight$")
	public void select_the_flight() throws InterruptedException {
		// Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@data-fly-type='fly'])[1]")));
		driver.findElement(By.xpath("(//button[@data-fly-type='fly'])[1]")).click();
		if (!driver.findElement(By.xpath("(//span[@class='heading-4']//parent::label)[1]")).isDisplayed()) {
			driver.findElement(By.xpath("(//button[@data-fly-type='fly'])[1]")).click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='heading-4']//parent::label)[1]")));
		driver.findElement(By.xpath("(//span[@class='heading-4']//parent::label)[1]")).click();
	}

	@When("^Click on next page button$")
	public void click_on_next_page_button() throws InterruptedException {
		driver.findElement(By.xpath("//button[@title='Next please']")).click();
		Thread.sleep(5000);
	}

	@Then("^Keen title \"([^\"]*)\" , first name \"([^\"]*)\" , last name \"([^\"]*)\" , DOB \"([^\"]*)\" ,nationality \"([^\"]*)\" ,$")
	public void keen_title_first_name_last_name_DOB_nationality(String title, String firstname, String lastname,
			String DOB, String nationality) throws InterruptedException {
		String[] dob = DOB.split("-");
		String day = dob[0];
		String month = dob[1];
		String year = dob[2];
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='selecttitle1']")));
		// driver.findElement(By.xpath("//select[@id='selecttitle1']")).click();
		// driver.findElement(By.xpath("//select[@id='selecttitle1']//option[text()='"+title+"']")).click();
		Select titleBox = new Select(driver.findElement(By.xpath("//select[@id='selecttitle1']")));
		titleBox.selectByVisibleText(title);
		driver.findElement(By.xpath("//input[@id='revPassengersInput_PassengerInfantModels_PassengersInfo_0__First']"))
				.sendKeys(firstname);
		driver.findElement(By.xpath("//input[@id='revPassengersInput_PassengerInfantModels_PassengersInfo_0__Last']"))
				.sendKeys(lastname);
		// driver.findElement(By.xpath("//select[@id='revPassengersInput_PassengerInfantModels_PassengersInfo_0__DayOfBirth']")).click();
		// driver.findElement(By.xpath("//select[@id='revPassengersInput_PassengerInfantModels_PassengersInfo_0__DayOfBirth']//option[text()='"+day+"']")).click();
		Select DOBDropdown = new Select(driver.findElement(
				By.xpath("//select[@id='revPassengersInput_PassengerInfantModels_PassengersInfo_0__DayOfBirth']")));
		DOBDropdown.selectByVisibleText(day);
		// driver.findElement(By.xpath("//select[@id='revPassengersInput_PassengerInfantModels_PassengersInfo_0__MonthOfBirth']")).click();
		// driver.findElement(By.xpath("//select[@id='revPassengersInput_PassengerInfantModels_PassengersInfo_0__MonthOfBirth']//option[text()='"+month+"']")).click();
		Select MonthDropdown = new Select(driver.findElement(
				By.xpath("//select[@id='revPassengersInput_PassengerInfantModels_PassengersInfo_0__MonthOfBirth']")));
		MonthDropdown.selectByVisibleText(month);
		// driver.findElement(By.xpath("//select[@id='revPassengersInput_PassengerInfantModels_PassengersInfo_0__YearOfBirth']")).click();
		// driver.findElement(By.xpath("//select[@id='revPassengersInput_PassengerInfantModels_PassengersInfo_0__YearOfBirth']//option[text()='"+year+"']")).click();
		Select YearDropdown = new Select(driver.findElement(
				By.xpath("//select[@id='revPassengersInput_PassengerInfantModels_PassengersInfo_0__YearOfBirth']")));
		YearDropdown.selectByVisibleText(year);
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//select[@id='revPassengersInput_PassengerInfantModels_PassengersInfo_0__Nationality']")).click();
		// driver.findElement(By.xpath("//select[@id='revPassengersInput_PassengerInfantModels_PassengersInfo_0__Nationality']//option[text()='"+nationality+"']")).click();
		Select NationDropdown = new Select(driver.findElement(
				By.xpath("//select[@id='revPassengersInput_PassengerInfantModels_PassengersInfo_0__Nationality']")));
		NationDropdown.selectByVisibleText(nationality);
		driver.findElement(By.xpath("//span[text()= 'I am not residing in the EU or Switzerland']//parent::label"))
				.click();
	}

	@Then("^Click on continue payment button$")
	public void click_on_continue_payment_button() throws InterruptedException {

		driver.findElement(By.xpath("//div[@class='ico ico-next']")).click();
		Thread.sleep(8000);
	}
		@Then("^Enter contact details$")
		public void enter_contact_details()  {
		 
			driver.findElement(By.xpath("//input[@id='revContactInput_WorkPhone_Number']")).sendKeys("12345678");
			driver.findElement(By.xpath("//input[@id='emailContact']")).sendKeys("nidhi_mittal@flyscoot.com");
			driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("nidhi_mittal@flyscoot.com");
			driver.findElement(By.xpath("//span[text()= 'I am not residing in the EU or Switzerland']//parent::label")).click();
		}
		@Then("^Keen streetaddress \"([^\"]*)\", country \"([^\"]*)\", city \"([^\"]*)\", postal \"([^\"]*)\",$")
		public void keen_streetaddress_country_city_postal(String streetaddress, String country, String city, String postal)  {
			driver.findElement(By.xpath("//input[@id='revContactInput_ContactViewModel_AddressLine1']")).sendKeys(streetaddress);
			Select countrycode = new Select(driver.findElement(By.xpath("//select[@id='revContactInput_ContactViewModel_CountryCode']")));
			countrycode.selectByVisibleText(country);
			driver.findElement(By.xpath("//input[@id='revContactInput_ContactViewModel_City']")).sendKeys(city);
			Select postalcode = new Select(driver.findElement(By.xpath("//select[@id='revContactInput_ContactViewModel_ProvinceState']")));
		    postalcode.selectByVisibleText(postal);
		    driver.findElement(By.xpath("//input[@id='revContactInput_ContactViewModel_PostalCode']")).sendKeys("333333");
		}
		@Then("^Select payment method cardnumber \"([^\"]*)\", expirationdate \"([^\"]*)\", cardholdername \"([^\"]*)\", ccv \"([^\"]*)\"$")
		public void select_payment_method_cardnumber_expirationdate_cardholdername_ccv(String cardnumber, String expirationdate, String cardholdername, String ccv) throws InterruptedException  {
			String[] exp = expirationdate.split("-");
			String month = exp[0];
			String year = exp[1];
			
			
			
			
			driver.findElement(By.xpath("(//a[@href='#CreditCard-tab'])[1]")).click();
		    driver.findElement(By.xpath("//input[@id='paymentFactoryInput_PaymentFields_ExternalPaymentInputViewModel_CreditCardNumber_']")).sendKeys(cardnumber);
		    Select expiremonth = new Select(driver.findElement(By.xpath("//select[@name='paymentFactoryInput.PaymentFields[ExternalPaymentInputViewModel.ExpirationMonth]']")));
		    expiremonth.selectByVisibleText(month);
		   // driver.findElement(By.xpath("lect[@name='paymentFactoryInput.PaymentFields[ExternalPaymentInputViewModel.ExpirationYear]']")).click();
		    Select expireyear = new Select(driver.findElement(By.xpath("//select[@name='paymentFactoryInput.PaymentFields[ExternalPaymentInputViewModel.ExpirationYear]']")));
		    expireyear.selectByVisibleText(year);
		    //driver.findElement(By.xpath("//select[@name='paymentFactoryInput.PaymentFields[ExternalPaymentInputViewModel.ExpirationYear]']")).sendKeys("21");
		    driver.findElement(By.xpath("//input[@name='paymentFactoryInput.PaymentFields[ExternalPaymentInputViewModel.HolderName]']")).sendKeys(cardholdername);
		    driver.findElement(By.xpath("//input[@name='paymentFactoryInput.PaymentFields[ExternalPaymentInputViewModel.VerificationCode]']")).sendKeys(ccv);
            driver.findElement(By.xpath("(//label[@class='checkbox push-checkbox'])[2]//child::span")).click();
		    driver.findElement(By.xpath("//button[@class='btn btn-submit fareRulesAccepted']")).click();
		    Thread.sleep(10000);
		    WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
		    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1234");
		    //driver.findElement(By.cssSelector("input[type='password']")).sendKeys("1234");
		    //Actions builder = new Actions(driver);
		   // builder.moveByOffset(615,257).click().sendKeys("1234").build();
		   // builder.perform();
		   // WebElement pass=driver.findElement(By.xpath("//form[@name='form']//b//input[@name='external.field.password']"));
		    //JavascriptExecutor JS = (JavascriptExecutor)driver;
		   // JS.executeScript("document.getElementById('password').value='1234';");
		   // JS.executeScript(script, args)
		    driver.findElement(By.xpath("//input[@name='UsernamePasswordEntry']")).click();
		}
		

	

	/*
	 * @After(order = 0) public void afterScenario(Scenario scenario) { if
	 * (scenario.isFailed()) {
	 * 
	 * try { File sourcePath = ((TakesScreenshot)
	 * driver).getScreenshotAs(OutputType.FILE);
	 * 
	 * File destinationPath = new File(System.getProperty("user.dir") +
	 * "/target/cucumber-reports/screenshots/" + getcurrentdateandtime()+ ".png");
	 * 
	 * Files.copy(sourcePath, destinationPath);
	 * 
	 * Reporter.addScreenCaptureFromPath(destinationPath.toString()); } catch
	 * (IOException e) { } }
	 * 
	 * if (!scenario.isFailed()) {
	 * 
	 * try { File sourcePath = ((TakesScreenshot)
	 * driver).getScreenshotAs(OutputType.FILE);
	 * 
	 * File destinationPath = new File(System.getProperty("user.dir") +
	 * "/target/cucumber-reports/screenshots/" + getcurrentdateandtime()+ ".png");
	 * 
	 * Files.copy(sourcePath, destinationPath);
	 * 
	 * Reporter.addScreenCaptureFromPath(destinationPath.toString()); } catch
	 * (IOException e) { } }
	 * 
	 * } public static String getcurrentdateandtime(){ String str = null; try{
	 * DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS"); Date
	 * date = new Date(); //current system date time str= dateFormat.format(date);
	 * str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", ""); }
	 * catch(Exception E) { E.printStackTrace(); } return str; }
	 */

	/*
	 * @After(order = 0) public void embedScreenshot(Scenario scenario) { if
	 * (scenario.isFailed()) { try { File screenshot = ((TakesScreenshot)
	 * driver).getScreenshotAs(OutputType.FILE); //scenario.embed(screenshot,
	 * "image/png"); Reporter.addScreenCaptureFromPath(screenshot.toString()); }
	 * catch (Exception e) { e.printStackTrace(); } } if (!scenario.isFailed()) {
	 * try { byte[] screenshot = ((TakesScreenshot) driver)
	 * .getScreenshotAs(OutputType.BYTES); scenario.embed(screenshot, "image/png");
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } } }
	 */
	
	@Before
	public void beforeScenario(Scenario scenario) {
	Reporter.assignAuthor("Automated by - Nidhi");
	}
	@After(order=0)
	public void setdown()
	{
	//driver.close();
	//driver.quit();
	}
	@After(order = 1)
	public void afterScenario(Scenario scenario) {
	if (scenario.isFailed()) {
	try {

	File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


	File directory = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/");
	if (directory.exists())
	{
	}
	else {
	directory.mkdir();
	}

	File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + getcurrentdateandtime() + ".png");

	Files.copy(sourcePath, destinationPath);

	Reporter.addScreenCaptureFromPath(destinationPath.toString());
	} catch (IOException e) {
	}
	}

	if (!scenario.isFailed()) {

	try {
	//This takes a screenshot from the driver at save it to the specified location
	File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	File directory = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/");
	if (directory.exists())
	{
	}
	else {
	directory.mkdir();
	}

	File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + getcurrentdateandtime() + ".png");

	Files.copy(sourcePath, destinationPath);

	Reporter.addScreenCaptureFromPath(destinationPath.toString());
	} catch (IOException e) {
	}
	}
	}
}