

/**
 *
 * @author Tumelo
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.Driver;
import base.SeleniumUtil;


import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertEquals;

public class HomePage {
    WebElement cookieElement;

   
    public static void LoadClearscoreWebsite() {
        Driver.getWebInstance().manage().window().maximize();
        Driver.getInstance().get(SeleniumUtil.BASE_URL_STRING);

        
    }

    private static WebElement ClickNoProblem() {
        return Driver.getInstance().wait(5, ExpectedConditions.
                presenceOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[4]/div/button")));
    }

    private static WebElement ClickSignUp() {
        return Driver.getInstance().wait(25, ExpectedConditions.
                presenceOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div/div[3]/form/div/button/div")));
    }

    public static void EnterYourFirstname(String name) {

        Driver.getInstance().wait(25, ExpectedConditions.presenceOfElementLocated(By.cssSelector("#firstName"))).sendKeys(name);
    }

    public static void EnterSurname(String surname) {

        Driver.getInstance().wait(10, ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"lastName\"]"))).sendKeys(surname);
    }

    public static void EnterIDno(String id) {

        Driver.getInstance().wait(15, ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"idType\"]"))).sendKeys(id);
    }

    public static void EnterYourEmail(String usermail) {

        Driver.getInstance().wait(15, ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"email\"]"))).sendKeys(usermail);
    }

    public static void EnterPassword(String password) {

        Driver.getInstance().wait(5, ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password\"]"))).sendKeys(password);
    }


    private static WebElement NowLogin() {
        return Driver.getInstance().wait(5, ExpectedConditions.
                presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[4]/div/form/fieldset/div[4]/button")));
    }
     
    public static void VerifyText(){
    
    WebElement message = Driver.getInstance().wait(5, ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[4]/div/div[2]/p")));
            String messageText = message.getText();
            assertEquals("We use cookies to improve your experience", messageText);
    }


    public static void VerifyLogInError(){

        WebElement message = Driver.getInstance().wait(5, ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[2]/p")));
        String messageText = message.getText();
        assertEquals("The email or password you've entered is incorrect.", messageText);
    }


    public static void ClickOnNoProblem() {
        ClickNoProblem().click();

    }

    public static void ClickOnSignUpButton() {
        ClickSignUp().click();

    }

    public static void ClickLoginB() {
        NowLogin().click();

    }

    
    

}
