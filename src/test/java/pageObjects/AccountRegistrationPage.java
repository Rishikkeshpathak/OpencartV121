package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@placeholder='First Name'] ")
	WebElement txtFirstname;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement txtLastname;

	@FindBy(xpath = "//input[@placeholder='E-Mail']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@placeholder='Telephone']")
	WebElement txtTelephone;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@placeholder='Password Confirm']")
	WebElement txtPasswordconfirm;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement ckdPolicy;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnSubmit;

	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setFirstName(String name) {
		txtFirstname.sendKeys(name);
	}

	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String tele) {
		txtTelephone.sendKeys(tele);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void setConfPassword(String pwd) {
		txtPasswordconfirm.sendKeys(pwd);
	}

	public void setPolicy() {
		ckdPolicy.click();
	}

	public void clickContinue() {
		btnSubmit.click();
	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}

	}
}
