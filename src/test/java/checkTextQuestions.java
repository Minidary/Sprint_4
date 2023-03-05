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
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7},
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
