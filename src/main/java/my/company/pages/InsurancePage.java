package my.company.pages;

import my.company.pages.BasePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class InsurancePage extends BasePageObject {
    WebDriver driver;

    @FindBy(xpath = "//*[@class = 'uc-full__header'][text() = 'Страхование для путешественников']")
    WebElement openPage;

    @FindBy(xpath = "//*[@class='sbrf-rich-outer']/h1")
    WebElement header;

    public InsurancePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void checkTitle() {
        assertEquals("Страхование путешественников",
                header.getText());
    }
    public void getOnline() {
        clicks(openPage);
    }
}