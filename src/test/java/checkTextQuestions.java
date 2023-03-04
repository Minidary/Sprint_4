import config.AppConfig;
import config.WebDriverConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class checkTextQuestions {
    private WebDriver driver;
    private final String questions_expected;
    private final String textQuestions_expected;
    private final int index;

    public checkTextQuestions(String questions_expected, String textQuestions_expected, int index) {
        this.questions_expected = questions_expected;
        this.textQuestions_expected = textQuestions_expected;
        this.index = index;
    }

    @Parameterized.Parameters
    public static Object[][] getCheckText() {
        return new Object[][]{
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(WebDriverConfig.WAIT_SECONDS_TIMEOUT, TimeUnit.SECONDS);
        driver.navigate().to(AppConfig.URL);
    }

    @Test
    public void checkTestTextQuestions() {
        MainPage page = new MainPage(driver);
        page.clickCookieButton();
        page.scrollDropDownList();
        String question_actual = page.checkDropDownList(index)[0];
        String question_text_actual = page.checkDropDownList(index)[1];
        Assert.assertEquals("Вопрос", questions_expected, question_actual);
        Assert.assertEquals("Ответ", textQuestions_expected, question_text_actual);
    }

    @After
    public void siteDown() {
        driver.quit();
    }

}
