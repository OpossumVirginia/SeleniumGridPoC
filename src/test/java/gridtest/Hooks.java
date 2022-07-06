package gridtest;

import org.testng.ITestContext;
import org.testng.annotations.*;

/**
 * Created by opossum on 05.06.17.
 */
public class Hooks {

    private Logger logger = new Logger();

    @BeforeTest
    public void beforeScenario(final ITestContext context) {
        logger.startTestCase(context.getName());
    }

    @AfterTest
    public void afterScenario(final ITestContext context) {
        logger.endTestCase(context.getName());
    }


    @BeforeSuite(groups = {"row3test"})
    public void beforeTestSuite1(final ITestContext context) {
        logger.startTestCase(context.getSuite().getName());
    }
}

