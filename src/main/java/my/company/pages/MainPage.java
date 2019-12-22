package my.company.pages;



import my.company.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage extends BasePageObject {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"main\"]/div[5]/div/div/div")
    WebElement closeCoockie;

    @FindBy(xpath = "//*[@id=\"main\"]/div[5]/div/div/div/div/div/div[3]")
    WebElement closeBtn;

    @FindBy(xpath = "//*[@id=\"main\"]/div[4]/div/div/div/div[2]/nav/div[2]/div/div[5]/div[3]/a")
    WebElement Insurance;

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public void closeCoockies(){

        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main\"]/div[5]/div/div/div")));
            waitToBeClickable(driver, closeBtn);
        }
        catch (Exception e)
        {
            System.out.println("Ошибка: "+e);
        }
    }

    public void selectInsuranceItem(){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main\"]/div[4]/div/div/div/div[2]/nav/div[2]/div/div[5]/div[3]/a")));
            waitToBeClickable(driver,Insurance);
        }catch (Exception e){System.out.println("Error: "+e);}

    }
}


