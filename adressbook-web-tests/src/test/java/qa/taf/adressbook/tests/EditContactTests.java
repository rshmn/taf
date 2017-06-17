package qa.taf.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

import qa.taf.adressbook.model.ContactData;

public class EditContactTests extends TestBase {

    @Test(enabled = false)
    public void EditContact() {
        ContactData contact = new ContactData("Cyril", "Puhalskiy","Ukraine,Dnipro", "+380682323232", "+30562343434", "Email1@email.com", "http://www.Homepageurl.com","Test group1");
        if (! app.getContactHelper().isThereAContact()){
            app.goTo().addNewContact();
            app.getContactHelper().createContact(contact, true);
        }

        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().editContact(before.size() - 1);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().updateContact();
        app.goTo().homePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size(), after.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }

}
