package qa.taf.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.taf.adressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;


public class ContactCreationTests extends TestBase{


    @Test
    public void ContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().addNewContact();
        ContactData contact = new ContactData("Cyril", "Puhalskiy", "Ukraine,Dnipro", "+380682323232", "+30562343434", "Email1@email.com", "http://www.Homepageurl.com","Test group1");
        app.getContactHelper().createContact(contact,true);
        List<ContactData> after = app.getContactHelper().getContactList();
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
