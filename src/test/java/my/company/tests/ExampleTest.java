package my.company.tests;

import my.company.pages.BasePageObject;
import my.company.steps.*;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import java.util.LinkedHashMap;

public class ExampleTest extends BaseSteps {

    MainPageSteps mainPageSteps = new MainPageSteps();
    InsurancePageSteps insurancePageSteps = new InsurancePageSteps();
    InsuranceOfTravelersPageSteps insuranceOfTravelersPageSteps = new InsuranceOfTravelersPageSteps();
    SendDataPageSteps sendDataPageSteps = new SendDataPageSteps();
    LinkedHashMap<String, String> testData = new LinkedHashMap<>();

    @Title("Сбербанк Страхование")
    @Test

    public void Test() {
        getDriver().get(baseUrl + "/");
        mainPageSteps.closeCookies();
        mainPageSteps.selectMenuInsurance();
        insurancePageSteps.getOnline();
        insurancePageSteps.checkTitle();
        insuranceOfTravelersPageSteps.goToData();
        BasePageObject.openNewWindow(getDriver());
        sendDataPageSteps.getSumm();
        sendDataPageSteps.Issue();

        testData.put("Фамилия","Ivanov");
        testData.put( "Имя","Ivan");
        testData.put("Дата рождения", "01.01.1990");
        testData.put("Фамилия страхователя", "Петрова");
        testData.put("Имя страхователя", "Наталья");
        testData.put("Отчество страхователя", "Петровна");
        testData.put("Дата рождения страхователя", "01.01.2001");
        testData.put("Пол", "female");
        testData.put("Серия паспорта", "1234");
        testData.put("Номер паспорта", "123456");
        testData.put("Дата выдачи", "01.01.2000");
        testData.put("Место выдачи", "ОВД Красногорского района");

        sendDataPageSteps.fillFields(testData);
        testData = BasePageObject.clearElement("Пол", testData);
        sendDataPageSteps.checkFillFields(testData);
        sendDataPageSteps.Continue();
        sendDataPageSteps.errorMessage("Заполнены не все обязательные поля");
    }
}
