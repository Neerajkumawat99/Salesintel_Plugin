package org.stepdefinition;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.base.Global;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class Steps extends Global {
	public static WebDriver driver, driver1, driver2, driver3;

	@Given("Launch the url")
	public void launch_the_url() throws Throwable {
		driver = getDriver("https://www.dell.com/en-in?mn=F92EfZhN4hqOM7OGItEL0xm09mut9BVcKgBk.4B62eHLvurfYmY3C");
		maximizeWindow();
		implicitWait();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_CONTROL);
//		driver.close();
		/** To Switch into UK region */
//		launchURL("https://www.dell.com/en-uk/");
//		maximizeWindow();
//		implicitWait();
//		Thread.sleep(3000);
//		if (PageObjectManager.getInstance().getLoginPage().getRegionButton().size() != 0) {
//			clickButton(PageObjectManager.getInstance().getLoginPage().getRegionButton().get(0));
//		}
//		Thread.sleep(2000);
//		System.out.println("Switched UK Region Sucessfully");
		/** To Switch into UK region */
//		launchURL("https://www.dell.com/en-us/");
//		Thread.sleep(2000);
//		maximizeWindow();
//		implicitWait();
//		System.out.println(PageObjectManager.getInstance().getLoginPage().getRegionButton().size());
//		if(PageObjectManager.getInstance().getLoginPage().getRegionButton().size()!=0) {
//			clickButton(PageObjectManager.getInstance().getLoginPage().getRegionButton1());
//		}
//		Thread.sleep(2000);
//		System.out.println("Switched US Region Sucessfully");
	}

	@When("Click on Chrome Extensions")
	public void click_on_Chrome_Extensions() {
		waitForPageLoad();
		sikuliClickOnScreenObjects(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Image_File_Store\\Extensions.PNG");
	}

	@When("Click on RevDriver by SalesIntel")
	public void click_on_RevDriver_by_SalesIntel() {
		sikuliClickOnScreenObjects(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Image_File_Store\\RevDriverBySalesIntel.png");

	}

	@When("Enter the UserName")
	public void enter_the_UserName() {
		try {
			enterData(PageObjectManager.getInstance().getLoginPage().getUserName(),
					retrieveDataFromJson(
							System.getProperty("user.dir")
									+ "\\src\\test\\resources\\Json_Data_Storage\\Json_Data.json",
							"Login_Details", "Username"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("Enter the Password")
	public void enter_the_Password() {
		try {
			enterData(PageObjectManager.getInstance().getLoginPage().getPassword(),
					retrieveDataFromJson(
							System.getProperty("user.dir")
									+ "\\src\\test\\resources\\Json_Data_Storage\\Json_Data.json",
							"Login_Details", "Password"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("Click on Login CTA")
	public void click_on_Login_CTA() {
		clickButton(PageObjectManager.getInstance().getLoginPage().getLoginCTA());
		WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
		webDriverWait.until(
				ExpectedConditions.elementToBeClickable(PageObjectManager.getInstance().getLoginPage().getFilter()));
	}

	@When("Switch To Child Window")
	public void switch_To_Child_Window() throws Throwable {
//		driver.switchTo().frame(PageObjectManager.getInstance().getLoginPage().getSwitchTOFrame());
		maximizeWindow();
		waitForPageLoad();
		getWindowHandleForMultipleWindow();
	}

	@When("Switch To Frame")
	public void switch_To_Frame() throws Throwable {
		Thread.sleep(5000);
		driver.switchTo().frame(PageObjectManager.getInstance().getLoginPage().getSwitchTOFrame());
	}

	@When("Click on Filter Button")
	public void click_on_Filter_Button() {
		if (PageObjectManager.getInstance().getLoginPage().getFilter_List().size() != 0) {
			WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
			webDriverWait.until(ExpectedConditions
					.elementToBeClickable(PageObjectManager.getInstance().getLoginPage().getFilter()));
			clickButton(PageObjectManager.getInstance().getLoginPage().getFilter());
		}

	}

	@When("Click on Contacts Email Button")
	public void click_on_Contacts_Email_Button() {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
		webDriverWait.until(ExpectedConditions
				.elementToBeClickable(PageObjectManager.getInstance().getContactEmailPage().getContacts_Email()));
		PageObjectManager.getInstance();
		clickButton(PageObjectManager.getInstance().getContactEmailPage().getContacts_Email());
	}

	@When("Enter the Firstname")
	public void enter_the_Firstname() throws Throwable, Throwable {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
		webDriverWait.until(ExpectedConditions
				.visibilityOf(PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_First_Name()));
		enterData(PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_First_Name(),
				retrieveDataFromJson(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Json_Data_Storage\\Json_Data.json",
						"ContactName_Details", "FirstName"));
	}

	@When("Enter the Lastname")
	public void enter_the_Lastname() throws Throwable, Throwable {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
		webDriverWait.until(ExpectedConditions
				.visibilityOf(PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Last_Name()));
		enterData(PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Last_Name(),
				retrieveDataFromJson(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Json_Data_Storage\\Json_Data.json",
						"ContactName_Details", "LastName"));
	}

	@When("Click on Search Button")
	public void click_on_Search_Button() {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(
				PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Search()));
		clickButton(PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Search());
	}

	@When("Click on Reveal Button")
	public void click_on_Reveal_Button() {
		if (PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Reveal_Button_List().size() != 0) {
			WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
			webDriverWait.until(ExpectedConditions.elementToBeClickable(
					PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Reveal_Button()));
			clickButton(PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Reveal_Button());
		}
	}

	@When("Click on Cancel Button")
	public void click_on_Cancel_Button() {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(
				PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Cancel_Button()));
		clickButton(PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Cancel_Button());
	}

	@When("Wait Till Page Load To Display Select All Data")
	public void wait_Till_Page_Load_To_Display_Select_All_Data() {
		if (PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Select_All_List().size() != 0) {
			WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
			webDriverWait.until(ExpectedConditions.elementToBeClickable(
					PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Select_All()));
		}
	}

	@When("Enter the {int}nd Contacts Firstname")
	public void enter_the_nd_Contacts_Firstname(Integer int1) throws Throwable {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
		webDriverWait.until(ExpectedConditions
				.visibilityOf(PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_First_Name()));
		enterData(PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_First_Name(),
				retrieveDataFromJson(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Json_Data_Storage\\Json_Data.json",
						"ContactName_Details", "FirstName1"));
	}

	@When("Enter the {int}nd Contacts Lastname")
	public void enter_the_nd_Contacts_Lastname(Integer int1) throws Throwable {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
		webDriverWait.until(ExpectedConditions
				.visibilityOf(PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Last_Name()));
		enterData(PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Last_Name(),
				retrieveDataFromJson(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Json_Data_Storage\\Json_Data.json",
						"ContactName_Details", "LastName1"));
	}

	@When("Click on Contacts Name Email Button")
	public void click_on_Contacts_Name_Email_Button() {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(
				PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Button()));
		clickButton(PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Button());
	}

	@When("Enter the {int}st Contacts Email Address")
	public void enter_the_st_Contacts_Email_Address(Integer int1) throws Throwable {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
		webDriverWait.until(ExpectedConditions
				.visibilityOf(PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Input_Field()));
		enterData(PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Input_Field(),
				retrieveDataFromJson(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Json_Data_Storage\\Json_Data.json",
						"ContactName_Details", "Email"));
	}

	@When("Enter the {int}nd Contacts Email Address")
	public void enter_the_nd_Contacts_Email_Address(Integer int1) throws Throwable {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
		webDriverWait.until(ExpectedConditions
				.visibilityOf(PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Input_Field()));
		enterData(PageObjectManager.getInstance().getContactEmailPage().getContacts_Email_Input_Field(),
				retrieveDataFromJson(
						System.getProperty("user.dir") + "\\src\\test\\resources\\Json_Data_Storage\\Json_Data.json",
						"ContactName_Details", "Email1"));
	}

	@When("Click on Job Level Button")
	public void click_on_Job_Level_Button() throws Throwable {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
		webDriverWait.until(ExpectedConditions
				.elementToBeClickable(PageObjectManager.getInstance().getJobLevel().getJob_Level_Button()));
		clickButton(PageObjectManager.getInstance().getJobLevel().getJob_Level_Button());
		Thread.sleep(1000);
	}

	@When("Select All Checkbox Option in Job Level")
	public void select_All_Checkbox_Option_in_Job_Level() throws Throwable {
		System.out.println(PageObjectManager.getInstance().getJobLevel().getJob_Level_Select_All().getText());
		if (PageObjectManager.getInstance().getJobLevel().getJob_Level_Select_All().getText().contains("Select All ")) {
			WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
			webDriverWait.until(ExpectedConditions.elementToBeClickable(
					PageObjectManager.getInstance().getJobLevel().getJob_Level_Select_All_Check_Box()));
			Thread.sleep(5000);
			clickButton(PageObjectManager.getInstance().getJobLevel().getJob_Level_Select_All_Check_Box());
			Thread.sleep(2000);
		} else {
			WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
			webDriverWait.until(ExpectedConditions.elementToBeClickable(
					PageObjectManager.getInstance().getJobLevel().getJob_Level_Select_All_Check_Box()));
			Thread.sleep(5000);
			clickButton(PageObjectManager.getInstance().getJobLevel().getJob_Level_Select_All_Check_Box());
			Thread.sleep(2000);
		}
	}

	@When("Click on Job Department Button")
	public void click_on_Job_Department_Button() throws Throwable {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
		webDriverWait.until(ExpectedConditions
				.elementToBeClickable(PageObjectManager.getInstance().getJobDepartment().getJob_Department_Button()));
		clickButton(PageObjectManager.getInstance().getJobDepartment().getJob_Department_Button());
		Thread.sleep(1000);
	}

	@When("Select All Checkbox Option in Job Department")
	public void select_All_Checkbox_Option_in_Job_Department() throws Throwable {
		System.out.println(PageObjectManager.getInstance().getJobDepartment().getJob_Department_Select_All().getText());
		if (PageObjectManager.getInstance().getJobDepartment().getJob_Department_Select_All().getText()
				.contains("Select All ")) {
			WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
			webDriverWait.until(ExpectedConditions.elementToBeClickable(
					PageObjectManager.getInstance().getJobDepartment().getJob_Department_Select_All_Check_Box()));
			clickButton(PageObjectManager.getInstance().getJobDepartment().getJob_Department_Select_All_Check_Box());
			Thread.sleep(1000);
		} else {
			WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
			webDriverWait.until(ExpectedConditions.elementToBeClickable(
					PageObjectManager.getInstance().getJobDepartment().getJob_Department_Select_All_Check_Box()));
			clickButton(PageObjectManager.getInstance().getJobDepartment().getJob_Department_Select_All_Check_Box());
			Thread.sleep(1000);
		}
	}

	@When("Click on Job Title Button")
	public void click_on_Job_Title_Button() throws Throwable {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
		webDriverWait.until(
				ExpectedConditions.elementToBeClickable(PageObjectManager.getInstance().getJobTitle().getJob_Title()));
		clickButton(PageObjectManager.getInstance().getJobTitle().getJob_Title());
		Thread.sleep(1000);
	}

	@When("Click on Job Location Button")
	public void click_on_Job_Location_Button() throws Throwable {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
		webDriverWait.until(ExpectedConditions
				.elementToBeClickable(PageObjectManager.getInstance().getLocation().getLocationHome()));
		clickButton(PageObjectManager.getInstance().getLocation().getLocationHome());
		Thread.sleep(1000);
	}

	@When("UnSelect All Checkbox Option in Job Level")
	public void unselect_All_Checkbox_Option_in_Job_Level() throws Throwable {
		System.out.println(PageObjectManager.getInstance().getJobLevel().getUnSelect().getText());
		if (PageObjectManager.getInstance().getJobLevel().getUnSelect().getText().contains("Unselect")) {
			WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
			webDriverWait.until(ExpectedConditions.elementToBeClickable(
					PageObjectManager.getInstance().getJobLevel().getJob_Level_Select_All_Check_Box()));
			Thread.sleep(5000);
			clickButton(PageObjectManager.getInstance().getJobLevel().getJob_Level_Select_All_Check_Box());
			Thread.sleep(2000);
		} else {
			WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
			webDriverWait.until(ExpectedConditions.elementToBeClickable(
					PageObjectManager.getInstance().getJobLevel().getJob_Level_Select_All_Check_Box()));
			Thread.sleep(5000);
			clickButton(PageObjectManager.getInstance().getJobLevel().getJob_Level_Select_All_Check_Box());
			Thread.sleep(2000);
		}
	}

	@When("UnSelect All Checkbox Option in Job Department")
	public void unselect_All_Checkbox_Option_in_Job_Department() throws Throwable {
		System.out.println(PageObjectManager.getInstance().getJobDepartment().getUnSelect().getText());
		if (PageObjectManager.getInstance().getJobDepartment().getUnSelect().getText().contains("Unselect")) {
			WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
			webDriverWait.until(ExpectedConditions.elementToBeClickable(
					PageObjectManager.getInstance().getJobDepartment().getJob_Department_Select_All_Check_Box()));
			clickButton(PageObjectManager.getInstance().getJobDepartment().getJob_Department_Select_All_Check_Box());
			Thread.sleep(1000);
		} else {
			WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
			webDriverWait.until(ExpectedConditions.elementToBeClickable(
					PageObjectManager.getInstance().getJobDepartment().getJob_Department_Select_All_Check_Box()));
			clickButton(PageObjectManager.getInstance().getJobDepartment().getJob_Department_Select_All_Check_Box());
			Thread.sleep(1000);
		}
	}

	@Then("I Wait for Page Load")
	public void i_Wait_for_Page_Load() throws Throwable {
		Thread.sleep(10000);
	}

	@When("Close the Browser")
	public void close_the_Browser() throws Throwable {
		Thread.sleep(2000);
		driver.close();
	}
	
	@Given("Launch the url with Indian Region")
	public void launch_the_url_with_Indian_Region() throws Throwable {
		driver1 = getDriverIndianRegion("https://www.dell.com/en-in/");
		maximizeWindowIndianRegion();
		implicitWaitIndianRegion();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	@When("Switch To Frame with Indian Region")
	public void switch_To_Frame_with_Indian_Region() throws Throwable {
		Thread.sleep(5000);
		driver1.switchTo().frame(PageObjectManager.getInstance().getLogin_Page_With_Indian_Region().getSwitchTOFrame());
	}

	@When("Enter the UserName with Indian Region")
	public void enter_the_UserName_with_Indian_Region() {
		try {
			enterData(PageObjectManager.getInstance().getLogin_Page_With_Indian_Region().getUserName(),
					retrieveDataFromJson(
							System.getProperty("user.dir")
									+ "\\src\\test\\resources\\Json_Data_Storage\\Json_Data.json",
							"Login_Details", "Username"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("Enter the Password with Indian Region")
	public void enter_the_Password_with_Indian_Region() {
		try {
			enterData(PageObjectManager.getInstance().getLogin_Page_With_Indian_Region().getPassword(),
					retrieveDataFromJson(
							System.getProperty("user.dir")
									+ "\\src\\test\\resources\\Json_Data_Storage\\Json_Data.json",
							"Login_Details", "Password"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("Click on Login CTA with Indian Region")
	public void click_on_Login_CTA_with_Indian_Region() {
		clickButton(PageObjectManager.getInstance().getLogin_Page_With_Indian_Region().getLoginCTA());
		WebDriverWait webDriverWait = new WebDriverWait(driver1, 120);
		webDriverWait.until(
				ExpectedConditions.elementToBeClickable(PageObjectManager.getInstance().getLogin_Page_With_Indian_Region().getFilter()));
	}

	@When("Close the Browser with Indian Region")
	public void close_the_Browser_with_Indian_Region() throws Throwable {
		Thread.sleep(5000);
		driver1.close();
	}

	@Given("Launch the url with US Region")
	public void launch_the_url_with_US_Region() throws Throwable {
		driver2 = getDriverUSRegion("https://www.dell.com/en-us/");
		maximizeWindowUSRegion();
		implicitWaitUSRegion();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		if (PageObjectManager.getInstance().getLogin_Page_With_US_Region().getRegionButton().size() != 0) {
			clickButton(PageObjectManager.getInstance().getLogin_Page_With_US_Region().getRegionButton().get(0));
		}
	}

	@When("Switch To Frame with US Region")
	public void switch_To_Frame_with_US_Region() throws Throwable {
		Thread.sleep(5000);
		driver2.switchTo().frame(PageObjectManager.getInstance().getLogin_Page_With_US_Region().getSwitchTOFrame());
	}

	@When("Enter the UserName with US Region")
	public void enter_the_UserName_with_US_Region() {
		try {
			enterData(PageObjectManager.getInstance().getLogin_Page_With_US_Region().getUserName(),
					retrieveDataFromJson(
							System.getProperty("user.dir")
									+ "\\src\\test\\resources\\Json_Data_Storage\\Json_Data.json",
							"Login_Details", "Username"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("Enter the Password with US Region")
	public void enter_the_Password_with_US_Region() {
		try {
			enterData(PageObjectManager.getInstance().getLogin_Page_With_US_Region().getPassword(),
					retrieveDataFromJson(
							System.getProperty("user.dir")
									+ "\\src\\test\\resources\\Json_Data_Storage\\Json_Data.json",
							"Login_Details", "Password"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("Click on Login CTA with US Region")
	public void click_on_Login_CTA_with_US_Region() {
		clickButton(PageObjectManager.getInstance().getLogin_Page_With_US_Region().getLoginCTA());
		WebDriverWait webDriverWait = new WebDriverWait(driver2, 120);
		webDriverWait.until(
				ExpectedConditions.elementToBeClickable(PageObjectManager.getInstance().getLogin_Page_With_US_Region().getFilter()));
	}

	@When("Close the Browser with US Region")
	public void close_the_Browser_with_US_Region() throws Throwable {
		Thread.sleep(5000);
		driver2.close();
	}

	@Given("Launch the url with UK Region")
	public void launch_the_url_with_UK_Region() throws Throwable {
		driver3 = getDriverUKRegion("https://www.dell.com/en-uk/");
		maximizeWindowUKRegion();
		implicitWaitUKRegion();
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		if (PageObjectManager.getInstance().getLogin_Page_With_UK_Region().getRegionButton().size() != 0) {
			clickButton(PageObjectManager.getInstance().getLogin_Page_With_UK_Region().getRegionButton().get(0));
		}
	}

	@When("Switch To Frame with UK Region")
	public void switch_To_Frame_with_UK_Region() throws Throwable {
		Thread.sleep(5000);
		driver3.switchTo().frame(PageObjectManager.getInstance().getLogin_Page_With_UK_Region().getSwitchTOFrame());
	}

	@When("Enter the UserName with UK Region")
	public void enter_the_UserName_with_UK_Region() {
		try {
			enterData(PageObjectManager.getInstance().getLogin_Page_With_UK_Region().getUserName(),
					retrieveDataFromJson(
							System.getProperty("user.dir")
									+ "\\src\\test\\resources\\Json_Data_Storage\\Json_Data.json",
							"Login_Details", "Username"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("Enter the Password with UK Region")
	public void enter_the_Password_with_UK_Region() {
		try {
			enterData(PageObjectManager.getInstance().getLogin_Page_With_UK_Region().getPassword(),
					retrieveDataFromJson(
							System.getProperty("user.dir")
									+ "\\src\\test\\resources\\Json_Data_Storage\\Json_Data.json",
							"Login_Details", "Password"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("Click on Login CTA with UK Region")
	public void click_on_Login_CTA_with_UK_Region() {
		clickButton(PageObjectManager.getInstance().getLogin_Page_With_UK_Region().getLoginCTA());
		WebDriverWait webDriverWait = new WebDriverWait(driver3, 120);
		webDriverWait.until(
				ExpectedConditions.elementToBeClickable(PageObjectManager.getInstance().getLogin_Page_With_UK_Region().getFilter()));
	}

	@When("Close the Browser with UK Region")
	public void close_the_Browser_with_UK_Region() throws Throwable {
		Thread.sleep(5000);
		driver3.close();
	}
	
	@When("Click on Pin From Chrome Extensions")
	public void click_on_Pin_From_Chrome_Extensions() {
		sikuliClickOnScreenObjects(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Image_File_Store\\Pin_Image.png");
	}

}
