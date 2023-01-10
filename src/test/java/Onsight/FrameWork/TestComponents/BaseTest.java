package Onsight.FrameWork.TestComponents;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import onsight2.Pageobject.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public LoginPage loginPage;

	public WebDriver initializeDriver() throws IOException

	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--ignore-certificate-errors");
		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

////		options.addArguments("--ignore-ssl-	errors=yes");

		return driver;
	}

	@BeforeTest(alwaysRun = true)
	public LoginPage launchApplication() throws IOException {
		driver = initializeDriver();
		loginPage = new LoginPage(driver);
		loginPage.goTo();

		return loginPage;

	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		// read json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// String to HashMap- Jackson Databind

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

		// {map, map}

	}
	
	public void store_filename(String filename) {
		File textFile=new File(System.getProperty("user.dir") + "\\src\\test\\java\\Onsight\\FrameWork\\TestData\\reportname.txt");
		try {
			if (textFile.exists()) {
				BufferedWriter writer=new BufferedWriter(new FileWriter(textFile));
				writer.write(filename);
				writer.close();
			} else {
				textFile.createNewFile();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String get_filename() {
		String file_nameString = null;
		File textFile=new File(System.getProperty("user.dir") + "\\src\\test\\java\\Onsight\\FrameWork\\TestData\\reportname.txt");
		try {
			if (textFile.exists()) {
				BufferedReader bufferedReader=new BufferedReader(new FileReader(textFile));
				file_nameString=bufferedReader.readLine();
				bufferedReader.close();
				return file_nameString;
			} else {
				textFile.createNewFile();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return file_nameString;
	}
	 public ArrayList<String> readpdf(String file_name) throws IOException {
		 File file = new File(System.getProperty("user.dir") + "\\Download\\"+file_name+".pdf");
		 ArrayList<String> pdftotext=new ArrayList<String>();
		 if (file.exists()) {
				System.out.println("Its"+true	);
				PDDocument doc = PDDocument.load(file); 
	    		PDFTextStripper pdfStripper = new PDFTextStripper();
	    		pdftotext.add(pdfStripper.getText(doc));
	    		return pdftotext;
		 }
		return null;
	}
	 
	 public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
			FileUtils.copyFile(source, file);
			return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
			
			
		}

	@AfterTest(alwaysRun = true)

	public void tearDown() {
		driver.close();
	}

}
