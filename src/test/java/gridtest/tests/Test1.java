package gridtest.tests;

import org.testng.annotations.Test;

/**
 * Created by opossum on 25.12.17.
 */
public class Test1 extends BaseTest {
    @Test
    public void test_1_1(){
        System.out.println(" The test is in there 1.1 !!!");
        driver.navigate().to(baseURL);
        commons.checkTitle(driver, "Google");
    }

    @Test
    public void test_1_2(){
        System.out.println(" The test is in there 1.2 !!!");
        driver.navigate().to(baseURL);
        commons.checkTitle(driver, "Google");
    }

    @Test
    public void test_1_3(){
        System.out.println(" The test is in there 1.3 !!!");
        driver.navigate().to(baseURL);
        commons.checkTitle(driver, "Google");
    }
}
