import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import base.Framework;

import pages.HomePage;



public class ClearscoreTest {

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
            HomePage.VerifyText();
            HomePage.ClickOnNoProblem();


        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }



    @After
    public void cleanUp() {

    }



}
