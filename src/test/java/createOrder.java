import config.AppConfig;
import config.WebDriverConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class createOrder {
    private WebDriver driver;
    private final int index_button;
    private final String name;
    private final String surname;
    private final String address;
    private final String station;
    private final String number;
    private final String date;
    private final int index_period;
    private final int index_color;
    private final String comment;


    public createOrder(int index_button, String name, String surname, String address, String station, String number, String date, int index_period, int index_color, String comment){
        this.index_button = index_button;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.station = station;
        this.number = number;
        this.date = date;
        this.index_period = index_period ;
        this.index_color = index_color;
        this.comment = comment;

    }

    @Parameterized.Parameters
    public static Object[][] getCreateOrder() {
        return new Object[][]{
                {0, "Дарья", "Волкова", "Измайловская", "Семеновская", "+79097778833", "27.04.23", 0, 0, "Тест"},
                {1, "Никита", "Климов", "Иерусалимская", "Пролетарская", "+79809874522", "30.04.23", 1, 1, "Тест"},
        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(WebDriverConfig.WAIT_SECONDS_TIMEOUT, TimeUnit.SECONDS);
        driver.navigate().to(AppConfig.URL);
    }

    @Test
    public void checkCreateOrder(){
        FormRentOrder order = new FormRentOrder(driver);
        MainPage page = new MainPage(driver);
        page.clickCookieButton();
        page.clickButtonOrderHeader(index_button);
        order.fillFieldName(name);
        order.fillFieldSurname(surname);
        order.fillFieldAddress(address);
        order.fillFieldStation(station);
        order.fillFieldNumber(number);
        order.clickNextButton();
        order.fillFieldDate(date);
        order.fillFieldPeriod(index_period);
        order.fillFieldColor(index_color);
        order.fillFieldComment(comment);
        order.clickOrderButton();
        order.clickYesButton();
        order.isWindowAcceptDisabled();
        order.clickButtonOrderStatus();

    }

    @After
    public void siteDown() {
        driver.quit();
    }
}
