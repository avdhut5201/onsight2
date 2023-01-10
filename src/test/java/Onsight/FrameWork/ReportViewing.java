package Onsight.FrameWork;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Onsight.FrameWork.TestComponents.BaseTest;
import onsight2.Pageobject.HomePage;
import onsight2.Pageobject.ViewRport;

@Test(dataProvider = "getData")
public class ReportViewing extends BaseTest {
	public void view_report_values(HashMap<String, String> input) throws IOException, InterruptedException {
		String titleString;
		String report_name="random";
		int pages;
		List<String> listoftable_row=new ArrayList<String>();
    	ArrayList<String> pdftotextList=new ArrayList<String>();
		List<String> table_header=new ArrayList<String>();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage = launchApplication();
		loginPage.login_username(input.get("username"));
		loginPage.click0nsubmit();
		loginPage.EnterPassword(input.get("password"));
		loginPage.click0nsubmit();
		Thread.sleep(20000);
		HomePage homePage = new HomePage(driver);
		homePage.view_report_values(report_name);
		ViewRport viewRport=new ViewRport(driver);
		viewRport.view_data();
		table_header=viewRport.get_headers();
		pages=viewRport.no_of_pages();
    	listoftable_row=viewRport.view_values(pages);
    	 pdftotextList=readpdf("random");
    	 Assert.assertTrue(pdftotextList.contains(listoftable_row));
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\Onsight\\FrameWork\\TestData\\credentials.json");
		return new Object[][] { { data.get(0) } };

	}
}
