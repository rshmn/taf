package qa.taf.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import qa.taf.addressbook.appmanager.ApplicationManager;


/**
 * Created by rushman on 5/29/17.
 */
public class TestBase {

    protected  static final ApplicationManager app = new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));


    @BeforeSuite
    public void setUp() throws Exception {
        app.init();

    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
