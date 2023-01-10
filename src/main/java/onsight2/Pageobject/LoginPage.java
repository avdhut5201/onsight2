package onsight2.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import onsight2.Commonutilities.BaseComponenets;

public class LoginPage extends BaseComponenets {
	 WebDriver driver;
	 By usernameBy=By.cssSelector("input[name='j_username']");
	 By passwordBy=By.cssSelector("input[type*='password']");
	 By loginBy=By.cssSelector("input[value*='Login']");
	 By username=By.cssSelector("span[id='user']");
	 public LoginPage(WebDriver driver) {
		 super(driver);
		this.driver=driver;
	}
	
	 public void login_username(String username_1) {
			WebElement username=driver.findElement(usernameBy);
			username.sendKeys(username_1);
			
			
	 }
	 public void EnterPassword( String password) {
		
       WebElement passwordElement=driver.findElement(passwordBy);
       passwordElement.sendKeys(password);
    }
	 
	public void click0nsubmit() {
		 IsClickable(loginBy);
		WebElement login=driver.findElement(loginBy);
		login.click();
	}
	public void goTo() {
		// TODO Auto-generated method stub
		driver.get("https://oinsightsvm1.westindia.cloudapp.azure.com:444/ctsOInsightsBMS/res/createReport.html");
		
	}
	public String check_username() {
		IsVisible(username);
		WebElement Username=driver.findElement(username);
		String nameString=Username.getText();
		return nameString;
	}	

}
