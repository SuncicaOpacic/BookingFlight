package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TicketTypePage extends  BasePage{

    WebDriver driver;

    public TicketTypePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = (".InputRadio-module__field___16hZ8"))
    List<WebElement> ticketType;
    @FindBy(css = ("[data-testid='checkout_ticket_type_inner_next']"))
    WebElement nextButton;


    public void selectTicketType() throws InterruptedException {
        clickElement(ticketType.get(1));
    }

    public void clickNxtButton() throws InterruptedException {
        clickElement(nextButton);
    }
}
