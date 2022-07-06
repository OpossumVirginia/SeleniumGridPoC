package gridtest.tests;

import org.testng.annotations.Test;

/**
 * Created by opossum on 25.12.17.
 */
public class Test4 extends BaseTest {


    @Test (groups = { "row1test" })
    public void test_4_1(){
        System.out.println(" The test is in there 4.1 !!!");
        driver.navigate().to(baseURL);
        commons.checkTitle(driver, "Google");
    }

    @Test (groups = { "row2test" })
    public void test_4_2(){
        System.out.println(" The test is in there 4.2 !!!");
        driver.navigate().to(baseURL);
        commons.checkTitle(driver, "Google");
    }

    @Test (groups = { "row3test" })
    public void test_4_3(){
        System.out.println(" The test is in there 4.3 !!!");
        driver.navigate().to(baseURL);
        commons.checkTitle(driver, "Google");
    }
}
