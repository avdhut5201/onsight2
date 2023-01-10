package onsight2.Pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import onsight2.Commonutilities.BaseComponenets;

public class HomePage extends BaseComponenets {
	WebDriver driver;
	By createReportBy = By.cssSelector("button[data-target*='#addReportModal']");
	By baseTableBy = By.xpath("//table[@id='query-table']");
	By report_name_rowsBy = By.xpath("//table[@id='query-table']/tbody/tr/td[2]");
	By viewBy = By.xpath("//button[contains(@title,'View')]");
	By usernameBy=By.cssSelector("span[id='user']");
	List<String> report_name_list;
	String report_titleString;

//	By view_dataBy=By.xpath("//button[contains(@title,'View data')]");
//	By dataBy=By.xpath("//table[@id='reportDataTable-0']/tbody/tr	");
//	By teable_headingBy=By.xpath("//div[@class='dataTables_scrollHeadInner']//tr[@id='report-data-table-header-0']/th");
//	By next_paginateBy=By.xpath("//li[@id='reportDataTable-0_next']");
//	By paginateBy=By.xpath("//div[@id='reportDataTable-0_paginate']/ul[@class='pagination']/li[@class='paginate_button page-item ']");
//	By no_of_pagesBy=By.xpath("//div[@id='reportDataTable-0_info']");
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void CreateReport_Button() {

		IsClickable(createReportBy);
		WebElement create_Report = driver.findElement(createReportBy);
		create_Report.click();
	}

	

	public void view_report_values(String report_title) throws InterruptedException {
		int no_of_pages;
		IsVisible(baseTableBy);
		WebElement baseTable = driver.findElement(baseTableBy);
		List<WebElement> table_roWebElement = baseTable.findElements(report_name_rowsBy);
		List<String> list = new ArrayList<String>();
		for (WebElement webElement : table_roWebElement) {
			if (webElement.getText().contains(report_title)) {
				WebElement view_button=webElement.findElement(By.xpath("//table[@id='query-table']/tbody/tr/td[text()='"+report_title+"']//following-sibling::td//button[contains(@title,'View')]"));
				view_button.click();
			} //
		}
	}
	
	public String report_name() {
		IsVisible(report_name_rowsBy);
		report_name_list=new ArrayList<>();
		WebElement report_name_rows =driver.findElement(report_name_rowsBy);
		report_titleString=report_name_rows.getText();
		return report_titleString;
		
		
		
	}
	
	}


