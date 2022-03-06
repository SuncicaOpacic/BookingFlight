package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WhoIsFlyingPage extends BasePage{
    WebDriver driver;

    public WhoIsFlyingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name='email']")
    WebElement email;
    @FindBy(css = "[name='phone']")
    WebElement phoneNumber;
    @FindBy(css = "[name='passengers.0.firstName']")
    WebElement firstName;
    @FindBy(css = "[name='passengers.0.lastName']")
    WebElement lastName;
    @FindBy(css = "[name='passengers.0.gender']")
    WebElement gender;
    @FindBy(css = "[data-testid='checkout_extras_inner_next']")
    WebElement nextButton;


    public void enterEmail(String emailString) throws InterruptedException {
        typeText(email,emailString);
    }
    public void enterPhoneNumber(int phoneNumberInt) throws InterruptedException {
        clickElement(phoneNumber);
        typeText(phoneNumber, String.valueOf(phoneNumberInt));
    }
    public void enterFirstName(String name) throws InterruptedException {
        typeText(firstName, name);
    }
    public void enterLastName(String lastNameString) throws InterruptedException {
        typeText(lastName, lastNameString);
    }
    public void selectGender(String value) throws InterruptedException {
        clickElement(gender);
        selectByValue(gender,value);
    }
    public void clickNextButton() throws InterruptedException {
        clickElement(nextButton);
    }
}
