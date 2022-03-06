package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.FiltersPage;
import pages.FlightsPage;
import pages.TicketTypePage;


public class BookingFlightTest extends BaseTest {

    @BeforeMethod
    @Parameters
            ({"BROWSER", "BROWSER_VERSION", "WAIT", "ENV"})
    public void setUp(String browser, String browserVersion, String wait, String env) throws Exception {
        setUPTest(browser, browserVersion, Integer.parseInt(wait));
        startApplication(env);
    }

    @AfterMethod
    public void tearDown() {

//        quit();
    }

    @Test

    @Parameters
            ({"whereFromString", "whereToString", "departDate", "returnDate", "airline"})

    public void bookingFlightTest(String whereFromString, String whereToString, String departDate, String returnDate, String airline) throws InterruptedException{

        BasePage basePage = new BasePage(driver);
        FlightsPage flightsPage = new FlightsPage(driver);
        FiltersPage filtersPage = new FiltersPage(driver);
        TicketTypePage ticketTypePage = new TicketTypePage(driver);

        flightsPage.WhereFrom(whereFromString);
        Thread.sleep(1000);
        flightsPage.WhereTo(whereToString);
        flightsPage.setDates(departDate, returnDate);
        flightsPage.clickSearch();
        filtersPage.selectStopsFliter();
        filtersPage.deselectAirline(airline);
        filtersPage.clickSeeFlightButton();
        filtersPage.clickSelectButton();
        ticketTypePage.selectTicketType();
        ticketTypePage.clickNxtButton();


    }

}
