package my.company.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SendDataPage extends BasePageObject {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class=\"b-form-prog-box\"]")
    private WebElement sumOfInsurance;

    @FindBy(xpath = "//*[@class = \"b-form-button-section\"]/span/span")
    private WebElement toIssue;

    @FindBy(xpath = "//*[@name='insured0_surname']")
    private WebElement surname;

    @FindBy(xpath = "//*[@name='insured0_name']")
    private WebElement name;

    @FindBy(xpath = "//*[@name='insured0_birthDate']")
    private WebElement birthDate;

    @FindBy(xpath = "//*[@name='surname']")
    private WebElement surname_t;

    @FindBy(xpath = "//*[@name='name']")
    private WebElement name_t;

    @FindBy(xpath = "//*[@name='middlename']")
    private WebElement middlename;

    @FindBy(xpath = "//*[@name='birthDate']")
    private WebElement birthDate_t;

    @FindBy(xpath = "//*[@name='female']")
    private WebElement sex;

    @FindBy(xpath = "//*[@name='passport_series']")
    private WebElement seria;

    @FindBy(xpath = "//*[@name='passport_number']")
    private WebElement number;

    @FindBy(xpath = "//*[@name='issueDate']")
    private WebElement issueDate;

    @FindBy(xpath = "//*[@name='issuePlace']")
    private WebElement issuePlace;

    @FindBy(xpath = "//*[@class='b-continue-btn'][text()='Продолжить']")
    public WebElement button_continue;

    @FindBy(xpath = "//*[text()='Заполнены не все обязательные поля']")
    private WebElement text;

    public SendDataPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

        this.driver = driver;
    }

    public WebElement getElement(String fieldName) {
        if (fieldName == "text") {
            return text;
        }

        if (fieldName == "Сумма страхования") {
            return sumOfInsurance;
        }

        if (fieldName == "Кнопка Оформить") {
            return toIssue;
        }
        if (fieldName == "Кнопка Продолжить"){
            return button_continue;
        }
        else return null;
    }

    public void closeCalendar(WebElement element){
        element.click();
    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия":
                fillField(surname, value, driver);
                break;
            case "Имя":
                fillField(name, value, driver);
                break;
            case "Дата рождения":
                fillField(birthDate, value, driver);
                closeCalendar(surname);
                break;
            case "Фамилия страхователя":
                fillField(surname_t, value, driver);
                break;
            case "Имя страхователя":
                fillField(name_t, value, driver);
                break;
            case "Отчество страхователя":
                fillField(middlename, value, driver);
                break;
            case "Дата рождения страхователя":
                fillField(birthDate_t, value, driver);
                closeCalendar(surname);
                break;
            case "Пол":
                clicks(sex);
                break;
            case "Серия паспорта":
                fillField(seria, value, driver);
                break;
            case "Номер паспорта":
                fillField(number, value, driver);
                break;
            case "Дата выдачи":
                fillField(issueDate, value, driver);
                closeCalendar(surname);
                break;
            case "Место выдачи":
                fillField(issuePlace, value, driver);
                break;
            default: throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");

        }
    }
    public void checkField(String fieldName, String value) {
        if (fieldName == "Фамилия") {
            checkFillField(value, surname);
        }
        if (fieldName == "Имя") {
            checkFillField(value, name);
        }
        try{
        if (fieldName == "Дата рождения") {
            checkFillField(value, birthDate);
        }
        }catch (Exception e){
            System.out.println(e);
        }
        if (fieldName == "Фамилия страхователя") {
            checkFillField(value, surname_t);
        }
        if (fieldName == "Имя страхователя") {
            checkFillField(value, name_t);
        }
        if (fieldName == "Отчество страхователя") {
            checkFillField(value, middlename);
        }
        try {
            if (fieldName == "Дата рождения страхователя") {
                checkFillField(value, birthDate_t);
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        if (fieldName == "Пол") {
            checkFillField(value, sex);
        }
        if (fieldName == "Серия паспорта") {
            checkFillField(value, seria);
        }
        if (fieldName == "Номер паспорта") {
            checkFillField(value, number);
        }
        try {
            if (fieldName == "Дата выдачи") {
                checkFillField(value, issueDate);
            }
        }catch (Exception e){
            System.out.println(e);
        }
        if (fieldName == "Место выдачи") {
            checkFillField(value, issuePlace);
        }
    }
}
