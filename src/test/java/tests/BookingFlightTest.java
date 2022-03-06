package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import java.io.IOException;


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

        quit();
    }

    @Test

    @Parameters
            ({"whereFromString", "whereToString", "departDate", "returnDate", "airline", "email", "phoneNumber", "firstName", "lastName", "genderSelectValue"})

    public void bookingFlightTest(String whereFromString, String whereToString, String departDate, String returnDate, String airline, String email, int phoneNumber, String firstName, String lastName, String genderSelectValue) throws InterruptedException, IOException {

        FlightsPage flightsPage = new FlightsPage(driver);
        FiltersPage filtersPage = new FiltersPage(driver);
        TicketTypePage ticketTypePage = new TicketTypePage(driver);
        WhoIsFlyingPage whoIsFlyingPage = new WhoIsFlyingPage(driver);

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
        whoIsFlyingPage.enterEmail(email);
        whoIsFlyingPage.enterPhoneNumber(phoneNumber);
        whoIsFlyingPage.enterFirstName(firstName);
        whoIsFlyingPage.enterLastName(lastName);
        whoIsFlyingPage.selectGender(genderSelectValue);
        reportScreenshot("PassagerDetails","Passanger details");
        whoIsFlyingPage.clickNextButton();
        String URL = driver.getCurrentUrl();
        Assert.assertTrue(URL.contains("https://flights.booking.com/checkout/"));
    }
}
