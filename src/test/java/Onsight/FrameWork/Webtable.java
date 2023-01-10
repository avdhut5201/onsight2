package Onsight.FrameWork;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import onsight2.Pageobject.HomePage;
import onsight2.Pageobject.LoginPage;
import onsight2.Pageobject.ViewRport;

public class Webtable {

	public static void main(String[] args) throws InterruptedException, IOException {
//		List<String> listoftable_row=new ArrayList<String>();
//		List<String> formattedlistoftable_row=new ArrayList<String>();
//		List<String> table_header=new ArrayList<String>();
//		// TODO Auto-generated method stub
//		String urlString = "https://oinsightsvm1.westindia.cloudapp.azure.com:444/ctsOInsightsBMS/res/createReport.html";
//		String userEmailString = "User66";
//		String userPassword = "Avdhut@5201";
//		String titleString;
//		String textString="random";
//		int pages;
//		Faker faker = new Faker();
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		// options.addArguments("--ignore-ssl- errors=yes");
//		options.addArguments("--ignore-certificate-errors");
//		WebDriver driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.get(urlString);
//		LoginPage loginPage = new LoginPage(driver);
//		loginPage.login_username(userEmailString);
//		loginPage.click0nsubmit();
//		loginPage.EnterPassword(userPassword);
//		loginPage.click0nsubmit();
//		HomePage homePage = new HomePage(driver);
//		homePage.view_report_values(textString);
//		ViewRport viewRport=new ViewRport(driver);
//		viewRport.view_data();
//		table_header=viewRport.get_headers();
//		pages=viewRport.no_of_pages();
//    	listoftable_row=viewRport.view_values(pages);
//		for (String table_row:listoftable_row) {
//			System.out.println(table_row);
//			
//		}
		List<String> formattedlistoftable_row=new ArrayList<String>();
		File file = new File(System.getProperty("user.dir") + "\\Download\\random.pdf");
		if (file.exists()) {
			System.out.println("Its"+true	);
			PDDocument doc = PDDocument.load(file); 
    		PDFTextStripper pdfStripper = new PDFTextStripper();
//			pdfStripper.setStartPage(1);
//			pdfStripper.setEndPage(1);
//			
//			int count = doc.getNumberOfPages();
//			PDDocumentInformation pdd = doc.getDocumentInformation();
			System.out.println("tile"+pdfStripper.getText(doc));
			formattedlistoftable_row.add(pdfStripper.getText(doc));
			for (String string : formattedlistoftable_row) {
				System.out.println(string);
			}
//			System.out.println(count);
//			doc.close();
		}
		 
		
		
//		
		
		
//		

		
	}

}
