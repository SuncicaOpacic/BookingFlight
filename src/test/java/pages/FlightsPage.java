package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FlightsPage extends BasePage {
    WebDriver driver;

    public FlightsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".css-k008qs")
    WebElement whereFrom;
    @FindBy(css ="[data-testid='searchbox_origin_input']")
    WebElement whereFromType;
    @FindBy(css = ".css-1tl2oa1")
    WebElement whereTo;
    @FindBy(css = "[data-testid='searchbox_calendar']")
    List<WebElement> dates;
    @FindBy(css = "[data-testid='searchbox_submit']")
    WebElement searchButton;



    public void WhereFrom(String whereFromString) throws InterruptedException {
            clickElement(whereFrom);
            clickElement(driver.findElement(By.xpath("//div[@class='css-1eii3rq']//.")));
            typeText(whereFromType, whereFromString);
            clickElement(driver.findElements(By.cssSelector("[data-testid='autocomplete_result']")).get(0));

    }

    public void WhereTo(String whereToString) throws InterruptedException {
            typeText(whereTo, whereToString);
            clickElement(driver.findElements(By.cssSelector("[data-testid='autocomplete_result']")).get(0));
    }


    public void setDates(String departDate, String returnDate) throws InterruptedException {
        clickElement(dates.get(0));
        clickElement(driver.findElement(By.xpath("//span[@data-date-cell='" + departDate + "']")));
        Thread.sleep(1000);
        clickElement(dates.get(1));
        clickElement(driver.findElement(By.xpath("//span[@data-date-cell='" + returnDate + "']")));

    }
    public void clickSearch() throws InterruptedException {
        clickElement(searchButton);
    }
}
