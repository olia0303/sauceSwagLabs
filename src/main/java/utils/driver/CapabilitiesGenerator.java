package utils.driver;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.PropertyManager;
import java.io.File;

@Log4j2
public class CapabilitiesGenerator {

    public static ChromeOptions getChromeOptions() {
        String driverPath = System.getProperty("user.dir") + File.separator + new PropertyManager().get("drivers.path");
        ChromeOptions options = new ChromeOptions();
        String os = System.getProperty("os.name").toLowerCase();
        log.debug("Operational system: " + os + "; Driver path: " + driverPath);
        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", driverPath + "/linux/chromedriver");
        }
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");

        //options.addArguments("--headless"); // only if you are ACTUALLY running headless
       // options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
        //options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
        //options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
        //options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
        //options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc

        return options;
    }
}