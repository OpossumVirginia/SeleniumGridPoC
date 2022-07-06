package gridtest.tests.commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by opossum on 25.12.17.
 */
public class Commons {

    public boolean checkTitle(WebDriver wd, final String title) {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return wd.getTitle().equalsIgnoreCase(title);
    }

}
