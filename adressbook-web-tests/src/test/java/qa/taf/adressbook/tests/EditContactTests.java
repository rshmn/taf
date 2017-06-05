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
        app.getContactHelper().fillContactForm(new ContactData("Cyril", "Puhalskiy", "/Users/rushman/Desktop/1.jpg", "Ukraine,Dnipro", "+380682323232", "+30562343434", "Email1@email.com", "http://www.Homepageurl.com","Test group1"), false);
        app.getContactHelper().updateContact();

    }

}
