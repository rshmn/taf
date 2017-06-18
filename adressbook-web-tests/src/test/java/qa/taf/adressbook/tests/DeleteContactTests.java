package qa.taf.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.taf.adressbook.model.ContactData;
import qa.taf.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by rushman on 5/29/17.
 */
public class DeleteContactTests extends TestBase{

    @BeforeMethod
    private void ensurePredictions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.goTo().addNewContact();
            ContactData contact = new ContactData()
                    .withFirstname("Cyril")
                    .withLastname("Puhalskiy")
                    .withAddress("Ukraine,Dnipro")
                    .withGroupname("Test group1");
            app.contact().create(contact, true);
        }
    }
    @Test
      public void DeleteContact() {

            Contacts before = app.contact().all();
            ContactData deletedContact = before.iterator().next();
            app.contact().delete(deletedContact);
            app.goTo().homePage();
            Contacts after = app.contact().all();
            assertEquals(before.size(), after.size() + 1);
            assertThat(before.without(deletedContact),equalTo(after));


    }



}
