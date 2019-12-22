package my.company.steps;

import my.company.pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;


public class MainPageSteps extends BaseSteps{

    @Step("Закрыто окно предупреждения")
    public void closeCookies(){
        new MainPage(getDriver()).closeCoockies();
    }

    @Step("Выбран пункт меню: Страхование")
    public void selectMenuInsurance(){
        new MainPage(getDriver()).selectInsuranceItem();
    }

}
