
package base;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Driver {

    private static final Logger logger = LoggerFactory.getLogger(Driver.class); //NOPMD

    private FirefoxDriver getNewFirefoxDriverInstance() {
        //Firefox version 54.0 (en GB, 64) and Geckodriver version 0.17.0(64)
//        ProfilesIni listProfiles = new ProfilesIni();
//        FirefoxProfile firefoxprofile = listProfiles.getProfile("");

      // System.setProperty("webdriver.gecko.driver", "C:\\Users\\tumelo.gasetlolwe\\Desktop\\geckodriver.exe");
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\tumelo.gasetlolwe\\Downloads\\Tumelo_Clearscore\\chromedriver.exe");
//        firefoxprofile.setAcceptUntrustedCertificates(true);

//        DesiredCapabilities caps = DesiredCapabilities.firefox();
//        caps.setCapability(FirefoxDriver.PROFILE, firefoxprofile);
        return new FirefoxDriver();

    }
    
  
   
 
    public void get(String arg0) {
        this.webDriver.get(arg0);
    }

    private static Driver instance;
    WebDriver webDriver;

    public static Driver getInstance() {
        if (instance == null) {
            instance = new Driver();
        }
        return instance;
    }

    public static WebDriver getWebInstance() {
        if (instance == null) {
            instance = new Driver();
        }

        return instance.webDriver;
    }

    public <V> V wait(int timeOutInSeconds, Function<? super WebDriver, V> isTrue) {
        WebDriverWait wait = new WebDriverWait(this.webDriver, timeOutInSeconds);

        return wait.until(isTrue);
    }

    public <V> V wait(int timeOutInSeconds, Function<? super WebDriver, V> isTrue, Class<? extends Throwable> ignoreException) {
        WebDriverWait wait = new WebDriverWait(this.webDriver, timeOutInSeconds);

        return wait.ignoring(ignoreException).until(isTrue);
    }

    public WebDriver.Options manage() {
        return this.webDriver.manage();
    }

    public static void implicitlyWait(long seconds) {
        instance.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void quit() {
        this.webDriver.quit();
    }

    public void reset() {
        this.webDriver = getNewFirefoxDriverInstance();
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    protected Driver() {

    }

    public static Optional<JavascriptExecutor> getExecutor() {
        WebDriver checkdriver = Driver.getWebInstance();

        final JavascriptExecutor executor;

        if (checkdriver instanceof JavascriptExecutor) {

            executor = (JavascriptExecutor) checkdriver;

        } else {
            executor = null;
        }
        return Optional.ofNullable(executor);
    }
}