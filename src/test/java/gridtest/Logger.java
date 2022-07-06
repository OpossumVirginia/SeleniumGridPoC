package gridtest;

import java.sql.Timestamp;

/**Logger class used for additional test execution data logging.*/
public class Logger {
    /**Default log4j logger defined.*/
    private static org.apache.log4j.Logger log =
            org.apache.log4j.Logger.getLogger(Logger.class.getName());

    /**Method to log the beginning of the test.
     * @param sTestCaseName - String name of executed test case.*/
    public static void startTestCase(final String sTestCaseName) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info("Started Test case : " + sTestCaseName);
        log.info("Starting Time : " + timestamp.toString());
    }

    /**Method to log the end of the test.
     * @param sTestCaseName - String name of executed test case.*/
    public static void endTestCase(final String sTestCaseName) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.info("Ending Test case : " + sTestCaseName);
        log.info("End Time : " + timestamp.toString());
    }

    /**Method for general logging.
     * @param message - */
    public static void info(final String message)  {
        log.info(message);
    }
}
