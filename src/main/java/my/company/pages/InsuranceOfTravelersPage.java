package my.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsuranceOfTravelersPage extends BasePageObject {
    public WebDriver driver;

    @FindBy(xpath = "//*[@class = 'sbrf-rich-outer']/p/a/img")
    WebElement imgToData;

    public InsuranceOfTravelersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void goToData() {
        clicks(imgToData);
    }
}