package qa.taf.adressbook.tests;

import org.testng.annotations.Test;
import qa.taf.adressbook.model.ContactData;


public class ContactCreationTests extends TestBase{


    @Test
    public void ContactCreation() {
        app.getNavigationHelper().addNewContact();
        app.getContactHelper().createContact(new ContactData("Cyril", "Puhalskiy", "/Users/rushman/Desktop/1.jpg", "Ukraine,Dnipro", "+380682323232", "+30562343434", "Email1@email.com", "http://www.Homepageurl.com","Test group1"),true);
        app.getContactHelper().submitContactForm();
    }

}
