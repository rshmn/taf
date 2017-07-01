package qa.taf.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.taf.adressbook.model.ContactData;
import qa.taf.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;



public class EditContactTests extends TestBase {

    @BeforeMethod
    public void ensurePredictions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.goTo().addNewContact();
            app.contact().create(new ContactData()
                    .withFirstname("Cyril")
                    .withLastname("Puhalskiy")
                    .withAddress("Ukraine,Dnipro")
                    .withGroupname("test1"), true);
        }
    }

    @Test
    public void EditContact() {

        Contacts before = app.contact().all();
        ContactData editedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(editedContact.getId())
                .withFirstname("Cyril")
                .withLastname("Puhalskiy")
                .withAddress("Ukraine,Dnipro")
                .withWorkphonenumber("+380682323232")
                .withHomephonenumber("+30562343434")
                .withEmail1("Email1@email.com")
                .withHomepage("http://www.Homepageurl.com")
                .withGroupname("Test group1");
        app.contact().edit(contact);
        app.goTo().homePage();
        Contacts after = app.contact().all();
        assertEquals(before.size(), after.size());
        assertThat(after,equalTo(before.without(editedContact).withAdded(contact)));

    }



}
