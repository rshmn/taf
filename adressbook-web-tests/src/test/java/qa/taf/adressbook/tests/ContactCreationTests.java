package qa.taf.adressbook.tests;

import org.testng.annotations.Test;
import qa.taf.adressbook.model.ContactData;


public class ContactCreationTests extends TestBase{


    @Test
    public void ContactCreation() {
        app.getNavigationHelper().addNewContact();
        app.getContactHelper().fillContactForm(new ContactData("Name1", "MiddleName1", "LastName1", "Nickname1", "/Users/rushman/Desktop/1.jpg", "Title1", "Company1", "Address11", "Homephone1", "Mobilephone1", "Workphone1", "Faxphone1", "Email1", "Email1", "Email2", "Homepageurl.com", "20", "September", "1987", "15", "January", "2020", "Test group1", "Address2", "Home2", "Notest1"));
        app.getContactHelper().submitContactForm();
    }

}
