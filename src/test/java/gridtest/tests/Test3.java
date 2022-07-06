package gridtest.tests;

import org.testng.annotations.Test;

/**
 * Created by opossum on 25.12.17.
 */
public class Test3 extends BaseTest {
    @Test
    public void test_3_1(){
        System.out.println(" The test is in there 3.1 !!!");
        driver.navigate().to(baseURL);
        commons.checkTitle(driver, "Google");
    }

    @Test
    public void test_3_2(){
        System.out.println(" The test is in there 3.2 !!!");
        driver.navigate().to(baseURL);
        commons.checkTitle(driver, "Google");
    }

    @Test
    public void test_3_3(){
        System.out.println(" The test is in there 3.3 !!!");
        driver.navigate().to(baseURL);
        commons.checkTitle(driver, "Google");
    }
}
