import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.openqa.selenium.Keys.ESCAPE;

public class FormRentOrder {
    private WebDriver driver;

    public FormRentOrder(WebDriver driver) {
        this.driver = driver;
    }


    //Поле Имя
    private final By FIELD_NAME = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    //Поле Фамилия
    private final By FIELD_SURNAME = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    //Поле Адрес
    private final By FIELD_ADDRESS = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    //Поле Станция
    private final By FIELD_STATION = By.className("select-search__input");

    //Список всех станций
    private final By MENU_STATION = By.className("Order_Text__2broi");
    //Поле Телефон
    private final By FIELD_NUMBER = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    //Кнопка Далее
    private final By NEXT_BUTTON = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");
    //Поле Дата
    private final By FIELD_DATE = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input");
    //Поле Срок Аренды
    private final By FIELD_PERIOD_RENT = By.className("Dropdown-control");
    //Меню выбора поля Срок Аренды
    private final By PERIOD_RENT_MENU = By.className("Dropdown-option");
    //Поле Цвет
    private final By FIELD_COLOR = By.className("Checkbox_Label__3wxSf");
    //Поле Комментарий
    private final By FIELD_COMMENT = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    //Кнопка Заказать при подтверждении
    private final By ORDER_BUTTON_ACCEPT = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");

    //Кнопка Да при подтерждении заказа
    private final By YES_BUTTON = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");
    //Окно с номером заказа
    private final By ORDER_WINDOW = By.className("Order_Modal__YZ-d3");


    //Метод заполняет поле Имя
    public void fillFieldName(String name) {
        driver.findElement(FIELD_NAME).clear();
        driver.findElement(FIELD_NAME).click();
        driver.findElement(FIELD_NAME).sendKeys(name);
    }

    //Метод заполняет поле Фамилия
    public void fillFieldSurname(String surname) {
        driver.findElement(FIELD_SURNAME).clear();
        driver.findElement(FIELD_SURNAME).click();
        driver.findElement(FIELD_SURNAME).sendKeys(surname);
    }

    //Метод заполняет поле Адрес
    public void fillFieldAddress(String address) {
        driver.findElement(FIELD_ADDRESS).clear();
        driver.findElement(FIELD_ADDRESS).click();
        driver.findElement(FIELD_ADDRESS).sendKeys(address);
    }

    //Метод заполняет поле Станция
    public void fillFieldStation(String station) {
        driver.findElement(FIELD_STATION).clear();
        driver.findElement(FIELD_STATION).click();

        driver.findElement(FIELD_STATION).sendKeys(station);
        List<WebElement> list = driver.findElements(MENU_STATION);
        list.get(0).click();
    }

    //Метод заполняет поле Телефон
    public void fillFieldNumber(String number) {
        driver.findElement(FIELD_NUMBER).clear();
        driver.findElement(FIELD_NUMBER).click();
        driver.findElement(FIELD_NUMBER).sendKeys(number);
    }

    //Метод кликает на кнопку Далее
    public void clickNextButton() {
        driver.findElement(NEXT_BUTTON).click();
    }

    //Метод заполняет поле Дата
    public void fillFieldDate(String date) {
        driver.findElement(FIELD_DATE).clear();
        driver.findElement(FIELD_DATE).click();
        driver.findElement(FIELD_DATE).sendKeys(date);
        driver.findElement(FIELD_DATE).sendKeys(ESCAPE);
    }

    //Метод заполняет поле Срок аренды
    public void fillFieldPeriod(int index_period) {
        driver.findElement(FIELD_PERIOD_RENT).click();
        List<WebElement> period = driver.findElements(PERIOD_RENT_MENU);
        period.get(index_period).click();
    }

    //Метод заполняет поле Цвет
    public void fillFieldColor(int index_color) {
        List<WebElement> color = driver.findElements(FIELD_COLOR);
        color.get(index_color).click();
    }

    //Метод заполняет поле Комментарий
    public void fillFieldComment(String comment) {
        driver.findElement(FIELD_COMMENT).clear();
        driver.findElement(FIELD_COMMENT).click();
        driver.findElement(FIELD_COMMENT).sendKeys(comment);
    }

    //Метод кликает на кнопку Заказать
    public void clickOrderButton() {
        driver.findElement(ORDER_BUTTON_ACCEPT).click();
    }

    //Метод кликает на кнопку Да
    public void clickYesButton() {
        driver.findElement(YES_BUTTON).click();
    }



    //Метод проверяет, что окно подтверждения заказа отобразилось
    public boolean isWindowAcceptDisabled() {
        driver.findElement(ORDER_WINDOW).isDisplayed();
        return true;
    }
}
