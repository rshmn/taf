package qa.taf.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.taf.adressbook.model.ContactData;
import qa.taf.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class ContactCreationTests extends TestBase{


    @Test
    public void ContactCreation() {
        Contacts before = app.contact().all();
        app.goTo().addNewContact();
        ContactData contact = new ContactData()
                .withFirstname("Cyril")
                .withLastname("Puhalskiy")
                .withAddress("Ukraine,Dnipro")
                .withWorkphonenumber("+380682323232")
                .withHomephonenumber("+30562343434")
                .withEmail1("Email1@email.com")
                .withHomepage("http://www.Homepageurl.com")
                .withGroupname("Test group1");
        app.contact().create(contact,true);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}
