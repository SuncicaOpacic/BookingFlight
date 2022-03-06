package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class FiltersPage extends BasePage {
    WebDriver driver;

    public FiltersPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = (".InputRadio-module__field___16hZ8"))
    List<WebElement> stopsFilters;
    @FindBy(css = ("[data-testid=\"flight_card_bound_select_flight\"]"))
    List<WebElement> seeFlightButtons;
    @FindBy(css = ("[data-testid='flight_details_inner_modal_select_button']"))
    WebElement selectButton;

    public void selectStopsFliter() throws InterruptedException {
        clickElement(stopsFilters.get(1));
    }

    public void deselectAirline(String airline) throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//input[@name=\""+airline+"\"]/ ..")));
    }

    public void clickSeeFlightButton() throws InterruptedException {
        clickElement(seeFlightButtons.get(0));
    }

    public void clickSelectButton() throws InterruptedException {
        clickElement(selectButton);
    }
}

