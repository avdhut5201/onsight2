package Onsight.FrameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import onsight2.Pageobject.CreateReport;
import onsight2.Pageobject.HomePage;
import onsight2.Pageobject.LoginPage;

public class Standalontest  {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		try {
//			String urlString = "https://oinsightsvm1.westindia.cloudapp.azure.com:444/ctsOInsightsBMS/res/createReport.html";
//			String userEmailString = "User66";
//			String userPassword = "Avdhut@5201";
//			String titleString;
//			Faker faker = new Faker();
//			WebDriverManager.chromedriver().setup();
//			ChromeOptions options = new ChromeOptions();
////			options.addArguments("--ignore-ssl-	errors=yes");
//			options.addArguments("--ignore-certificate-errors");
//			WebDriver driver = new ChromeDriver(options);
//			driver.get(urlString);
//			LoginPage loginPage = new LoginPage(driver);
//			loginPage.login_username(userEmailString);
//			loginPage.click0nsubmit();
//			loginPage.EnterPassword(userPassword);
//			loginPage.click0nsubmit();
//			HomePage homePage = new HomePage(driver);
//			homePage.CreateReport_Button();
//			CreateReport createReport = new CreateReport(driver);
//			titleString=faker.name().firstName ();
//			createReport.report_type("Alarm");
//			createReport.report_query_no("100");
//			createReport.report_query(titleString);
//			createReport.report_template("DefaultAlarm");
//			createReport.daterangepicker("Last 24 hours");
//			createReport.access("public");
//			createReport.select_paarameter();
//			createReport.selectedAlarmColumntime();
//			createReport.selectedAlarmColumnsourceName();
//			createReport.selectedAlarmColumnsourceState();
//			createReport.selectedAlarmColumnackState();
//			createReport.selectedAlarmColumnmsgText();
//			createReport.selectedAlarmColumnnotes();
//			Thread.sleep(10000);
//			// createReport.parameter("//tr[@class='draggable']//input[@id='selectedAlarmColumntimestamp']");
//			// createReport.parameter();
////			Thread.sleep(30000);
//			createReport.save();
//			createReport.pdf_toggle();
//			createReport.genrate();
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//
//	}


}
