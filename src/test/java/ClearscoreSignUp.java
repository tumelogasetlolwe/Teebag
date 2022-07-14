import base.Framework;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.HomePage;


public class ClearscoreSignUp {

    @Before
    public void setUp() {
        Framework.resetDriver();
        Framework.generateRandomNumber(0);
    }

    //execute test
    @Test
    public void execute() {
        try {
            HomePage.LoadClearscoreWebsite();
            HomePage.ClickOnNoProblem();
            HomePage.EnterYourEmail("ttyey7@gmail.com");

            HomePage.ClickOnSignUpButton();

            HomePage.EnterYourFirstname("Jaba");
            HomePage.EnterSurname("Gaasman");
            HomePage.EnterIDno("9003048399234");
             HomePage.EnterPassword("ttyeyget33om");

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }



    @After
    public void cleanUp() {

    }



}
