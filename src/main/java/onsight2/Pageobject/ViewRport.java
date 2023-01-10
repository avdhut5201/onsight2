package onsight2.Pageobject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import onsight2.Commonutilities.BaseComponenets;

public class ViewRport extends BaseComponenets {
	WebDriver driver;
	By view_dataBy = By.xpath("//button[contains(@title,'View data')]");
	By dataBy = By.xpath("//table[@id='reportDataTable-0']/tbody/tr	");
	By teable_headingBy = By.xpath(".//div[@class='dataTables_scrollHead']//tr[@id='report-data-table-header-0']/th");
	By data_baseTableBy=By.xpath("//table[@id='reportDataTable-0']");
	By dataTable_row=By.xpath("//table[@id='reportDataTable-0']/tbody/tr");
	By next_paginateBy = By.xpath("//li[@id='reportDataTable-0_next']");
	By next_pageBy = By.xpath("//div[@id='reportDataTable-0_paginate']/ul[@class='pagination']/li[@class='paginate_button page-item active']/following-sibling::li[1]");
	By current_pageBy=By.xpath( "//div[@id='reportDataTable-0_paginate']/ul[@class='pagination']/li[@class='paginate_button page-item active']");
	List<String> listoftable_row=new ArrayList<String>();  
	public ViewRport(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public List<String> get_headers() {
		IsVisible(teable_headingBy);
		List<WebElement> table_headerElement = driver.findElements(teable_headingBy);
		List<String> table_header=new ArrayList<String>();
		JavascriptExecutor js=(JavascriptExecutor)driver;
//		System.out.println("Total no. of headers: " + table_headerElement.size());
        
		System.out.println("Headers: ");
		System.err.println("========");
		for (WebElement header : table_headerElement) {
		    js.executeScript("arguments[0].scrollIntoView(true);", header);
		    table_header.add(header.getText());
		}
			return table_header;

	}
	
	public void view_data() {
		IsClickable(view_dataBy);
		WebElement view_data=driver.findElement(view_dataBy);
		view_data.click();
	}

	public List<String> view_values(int no_of_pages ) throws InterruptedException {
		
		int page_counter;
		String list;
		boolean flag=true;
		while (flag) {
			page_counter=Integer.parseInt(driver.findElement(current_pageBy).getText());
			if (page_counter==10) {
				listoftable_row.addAll(test());
				break;
			} else {
				listoftable_row.addAll(test());
				paginate(next_pageBy);
//				IsClickable(next_pageBy);
//				driver.findElement(next_pageBy).click();
////				System.out.println("in pagination"+page_counter);
	       		Thread.sleep(5000);
			}
		}
		
return listoftable_row;
	}

	public int no_of_pages() {
		IsClickable(next_paginateBy);
		WebElement nextBtn = driver.findElement(next_paginateBy);
		if (!nextBtn.getAttribute("class").contains("disabled")) {
		int maxNum = Integer.parseInt(driver.findElement(By.xpath("//li[@id='reportDataTable-0_next']/preceding-sibling::li[1]")).getText());
		return maxNum;
		}
			return 1;}
public List<String> test() {
	List<String> listoftable_row2=new ArrayList<String>();
	String statuString;
	IsVisible(data_baseTableBy);
	WebElement dataTablebasElement=driver.findElement(data_baseTableBy);
	List<WebElement> dataTable_roWebElement=driver.findElements(dataTable_row);
	for (int i=0;i<dataTable_roWebElement.size();i++) {
//	System.out.println(dataTable_roWebElement.get(i).getText());
	listoftable_row2.add(dataTable_roWebElement.get(i).getText());
	
	}
//	System.out.println(listoftable_row2);
//	return listoftable_row2;
	return listoftable_row2;
   
	
}
	


}
