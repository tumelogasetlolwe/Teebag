/**
 *
 * @author Tumelo
 */
package base;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;

public class Framework {

    
    public static void ElementIsDisplayed(WebElement element) {
        assertTrue("Element '" + element.getTagName() + "' is not displayed", element.isDisplayed());
    }

 
    public static void ElementIsHidden(WebElement element) {
        assertTrue("Element '" + element.getTagName() + "' is displayed", !element.isDisplayed());
    }

  
    public static void verifyElementByText(WebElement element, String text) {
        String elementText = element.getText();
        assertEquals("Element text is not '" + text + "'", text, elementText);
    }
    
    public static void closeBrowser() {
        Driver.getInstance().quit();
    }

    public static void resetDriver() {
        Driver.getInstance().reset();
    }
    
     public static String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
        
    }

    

   
}
