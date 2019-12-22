package my.company.pages;

import my.company.steps.BaseSteps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class  BasePageObject  {

    public BasePageObject() {

        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void waitToBeClickable(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void fillField(WebElement element, String value, WebDriver driver) {
        try {
           waitToBeClickable(driver, element);
           element.clear();
        }catch (Exception e) {
            System.out.println("Данный элемент невозможно очистить "+e);
        }
        element.sendKeys(value);
    }

    public void checkFillField(String value, WebElement element) {
        try {
            assertEquals(value, element.getAttribute("value"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void checkText(WebElement element, String value){
        assertEquals(value, element.getText());
    }

    public static LinkedHashMap clearElement(String value, LinkedHashMap testData){
        for(Iterator<Map.Entry<String, String>> it = testData.entrySet().iterator();
            it.hasNext(); ) {
            Map.Entry<String, String> entry = it.next();
            if(entry.getKey().equals(value)) {
                it.remove();
            }
        }
        return testData;
    }

    public static void clicks(WebElement element) {
        try {
            element.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            element.click();
        }
    }
    @Step("Открыто новое окно")
    public static void openNewWindow(WebDriver driver){
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }

}
