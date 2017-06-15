package qa.taf.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.taf.adressbook.model.ContactData;


public class ContactCreationTests extends TestBase{


    @Test
    public void ContactCreation() {
        int before = app.getContactHelper().getContactCount();
        app.getNavigationHelper().addNewContact();
        app.getContactHelper().createContact(new ContactData("Cyril", "Puhalskiy", "Ukraine,Dnipro", "+380682323232", "+30562343434", "Email1@email.com", "http://www.Homepageurl.com","Test group1"),true);
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(before, after - 1);
    }

}
