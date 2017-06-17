package qa.taf.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.taf.adressbook.model.ContactData;

import java.util.List;

/**
 * Created by rushman on 5/29/17.
 */
public class DeleteContactTests extends TestBase{

    @Test(enabled = false)
      public void DeleteContact() {
        app.goTo().homePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.goTo().addNewContact();
            ContactData contact = new ContactData("Cyril", "Puhalskiy", "Ukraine,Dnipro", "+380682323232", "+30562343434", "Email1@email.com", "http://www.Homepageurl.com", "Test group1");
            app.getContactHelper().createContact(contact, true);
        }
            List<ContactData> before = app.getContactHelper().getContactList();
            app.getContactHelper().selectContact(before.size() - 1);
            app.getContactHelper().deleteContact();
            app.getContactHelper().acceptAlert();
            app.goTo().homePage();
            List<ContactData> after = app.getContactHelper().getContactList();
            Assert.assertEquals(before.size(), after.size() + 1);

            before.remove(before.size() - 1);
            Assert.assertEquals(before, after);


    }

}
