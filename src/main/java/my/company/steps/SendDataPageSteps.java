package my.company.steps;

import my.company.pages.BasePageObject;
import my.company.pages.SendDataPage;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

public class SendDataPageSteps extends BaseSteps {
    @Step("Выбрана сумма страхования")
    public void getSumm(){
        WebElement sum = new SendDataPage(getDriver()).getElement("Сумма страхования");
        BasePageObject.clicks(sum);
    }

    @Step("Нажата кнопка Оформить")
    public void Issue() {
        WebElement issue = new SendDataPage(getDriver()).getElement("Кнопка Оформить");
        BasePageObject.clicks(issue);
    }

    @Step("поле {0} заполнено значением {1}")
    public void fillField(String fieldName, String value) {
        SendDataPage send = new SendDataPage(getDriver());
       send.fillField(fieldName, value);
    }
    @Step("Заполняются поля")
    public void fillFields(HashMap<String, String> fields) {
        fields.forEach((k, v)-> fillField(k,v));
        }

    public void checkFillFields(HashMap<String, String> fields) {
        fields.forEach((k, v)-> checkFillField(k,v));
    }

    @Step("На ЭФ поле {0} заполнено значением {1}")
    public void checkFillField(String fieldName, String value){
        SendDataPage send = new SendDataPage(getDriver());
        send.checkField(fieldName, value);
    }
    @Step("Нажата кнопка Продолжить")
    public void Continue() {
        WebElement cont = new SendDataPage(getDriver()).getElement("Кнопка Продолжить");
        BasePageObject.clicks(cont);
    }

    @Step("Присутствует сообщение об ошибке: Заполнены не все обязательные поля")
    public void errorMessage(String value){
       WebElement text = new SendDataPage(getDriver()).getElement("text");
       BasePageObject.checkText(text, value);
    }



    }




