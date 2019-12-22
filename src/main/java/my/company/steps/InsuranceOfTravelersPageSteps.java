package my.company.steps;

import my.company.pages.InsuranceOfTravelersPage;
import ru.yandex.qatools.allure.annotations.Step;


public class InsuranceOfTravelersPageSteps extends BaseSteps {

    @Step("Открыта новая страница для заполнения формы")
    public void goToData(){
        new InsuranceOfTravelersPage(getDriver()).goToData();
    }
}
