package my.company.steps;



import my.company.pages.InsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.junit.Assert.assertTrue;


public class InsurancePageSteps extends BaseSteps{

    @Step("Проверен заголовок страницы Страхование путешественников")
    public void checkTitle(){
        new InsurancePage(getDriver()).checkTitle();
    }

    @Step("Выполнено нажатие на кнопку Оформить онлайн")
    public void getOnline(){
        new InsurancePage(getDriver()).getOnline();
    }
}
