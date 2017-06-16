package qa.taf.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.taf.adressbook.model.ContactData;

import java.util.List;

/**
 * Created by rushman on 5/29/17.
 */
public class DeleteContactTests extends TestBase{
    @Test(priority=1)
      public void DeleteContact() {
        app.getNavigationHelper().goHome();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().addNewContact();
            ContactData contact = new ContactData("Cyril", "Puhalskiy", "Ukraine,Dnipro", "+380682323232", "+30562343434", "Email1@email.com", "http://www.Homepageurl.com", "Test group1");
            app.getContactHelper().createContact(contact, true);
        }
            List<ContactData> before = app.getContactHelper().getContactList();
            app.getContactHelper().selectContact(before.size() - 1);
            app.getContactHelper().deleteContact();
            app.getContactHelper().acceptAlert();
            app.getNavigationHelper().goHome();
            List<ContactData> after = app.getContactHelper().getContactList();
            Assert.assertEquals(before.size(), after.size() + 1);

            before.remove(before.size() - 1);
            Assert.assertEquals(before, after);


    }

}
