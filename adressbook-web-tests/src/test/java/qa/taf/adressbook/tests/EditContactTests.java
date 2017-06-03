import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import qa.taf.adressbook.model.ContactData;
import qa.taf.adressbook.tests.TestBase;

import static org.openqa.selenium.OutputType.*;

public class EditContactTests extends TestBase {

    
    @Test
    public void EditContact() {

        app.getNavigationHelper().goHome();
        app.getContactHelper().editContact();
        app.getContactHelper().editContactForm(new ContactData("Name1", "MiddleName1", "LastName1", "Nickname1", "/Users/rushman/Desktop/1.jpg", "Title1", "Company1", "Address11", "Homephone1", "Mobilephone1", "Workphone1", "Faxphone1", "Email1", "Email1", "Email2", "Homepageurl.com", "20", "September", "1987", "15", "January", "2020", "Test group1", "Address2", "Home2", "Notest1"));
        app.getContactHelper().updateContact();

    }

}
