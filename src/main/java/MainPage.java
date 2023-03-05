import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver = driver;
    }


    //Кнопка Заказать в шапке страницы
    private final By ORDER_BUTTON_HEADER = By.xpath("//button[contains(text(),'Заказать')]");

    //Кнопка Заказать после картинки
    private final By ORDER_BUTTON_HEADER_DOWN = By.className("Button_Button__ra12g Button_Middle__1CSJM");

    //Кнопка Куки
    private final By COOKIE_BUTTON = By.className("App_CookieButton__3cvqF");

    //Выпадающий список с вопросами
    private final By DROP_DOWN_LIST = By.className("Home_FAQ__3uVm4");

    //Массив со списком вопросов
    private final By QUESTIONS_LIST_ARRAY = By.className("accordion__heading");

    //Массив со списком ответов
    private final By QUESTIONS_LIST_TEXT_ARRAY = By.className("accordion__panel");


    //Метод нажимает на кнопку Куки
    public void clickCookieButton(){
        driver.findElement(COOKIE_BUTTON).click();
    }
    //Метод нажимает на кнопку Заказать в шапке сайта
    public void clickButtonOrderHeader(int index) {
        List<WebElement> buttons_list = driver.findElements(ORDER_BUTTON_HEADER);
        buttons_list.get(index).click();
    }

    //Метод нажимает на кнопку Заказать ниже на странице
    public void clickButtonOrderDown() {
        driver.findElement(ORDER_BUTTON_HEADER_DOWN).click();
    }

    //Скролл до выпадающего списка
    public void scrollDropDownList() {
        WebElement element = driver.findElement(DROP_DOWN_LIST);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //
    public String[] checkDropDownList(int index) {

        List<WebElement> questions = driver.findElements(QUESTIONS_LIST_ARRAY);
        List<WebElement> text_questions = driver.findElements(QUESTIONS_LIST_TEXT_ARRAY);
        questions.get(index).click();
        String[] array = {questions.get(index).getText(), text_questions.get(index).getText()};
        return array;

    }

}
