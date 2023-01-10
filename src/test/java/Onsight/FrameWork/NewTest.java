package Onsight.FrameWork;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Onsight.FrameWork.TestComponents.BaseTest;
import onsight2.Pageobject.CreateReport;
import onsight2.Pageobject.HomePage;
import onsight2.Pageobject.LoginPage;

@Test(dataProvider = "getData")
public class NewTest extends BaseTest {
	LoginPage loginPage;
	String username,titleString;
	

	public void f(HashMap<String, String> input) throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage = launchApplication();
		loginPage.login_username(input.get("username"));
		loginPage.click0nsubmit();
		loginPage.EnterPassword(input.get("password"));
		loginPage.click0nsubmit();
		Thread.sleep(20000);
		username = loginPage.check_username();
//  System.out.println(username);
		Assert.assertEquals(input.get("username"), username, "Login Unsuccessfully");

	}
	
	
	public void create_report(HashMap<String, String> input) throws InterruptedException, IOException{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage = launchApplication();
		loginPage.login_username(input.get("username"));
		loginPage.click0nsubmit();
		loginPage.EnterPassword(input.get("password"));
		loginPage.click0nsubmit();
		Faker faker = new Faker();
		HomePage homePage = new HomePage(driver);
		homePage.CreateReport_Button();
		CreateReport createReport = new CreateReport(driver);
		titleString=faker.name().firstName ();
		createReport.report_type("Alarm");
		createReport.report_query_no("100");
		createReport.report_query(titleString);
		createReport.report_template("DefaultAlarm");
		createReport.daterangepicker("Last 24 hours");
		createReport.access("public");
		createReport.select_paarameter();
		createReport.selectedAlarmColumntime();
		createReport.selectedAlarmColumnsourceName();
		createReport.selectedAlarmColumnsourceState();
		createReport.selectedAlarmColumnackState();
		createReport.selectedAlarmColumnmsgText();
		createReport.selectedAlarmColumnnotes();
		Thread.sleep(10000);
		createReport.save();
		createReport.pdf_toggle();
		createReport.genrate();
		store_filename(titleString);
	}
	
	@Test
	public void verify_report(HashMap<String, String> input) throws IOException {
		String report_title,reportString;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage = launchApplication();
		loginPage.login_username(input.get("username"));
		loginPage.click0nsubmit();
		loginPage.EnterPassword(input.get("password"));
		loginPage.click0nsubmit();
		report_title=get_filename();
		HomePage homePage=new HomePage(driver);
		 reportString= homePage.report_name();
		 
		

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\Onsight\\FrameWork\\TestData\\credentials.json");
		return new Object[][] { { data.get(0) } };

	}

}
