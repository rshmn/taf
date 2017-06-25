package qa.taf.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.taf.adressbook.model.ContactData;
import qa.taf.adressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class ContactCreationTests extends TestBase{

    @DataProvider
    public Iterator<Object[]> validContacts(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {"test1","test1","test1"});
        list.add(new Object[] {"test2","test2","test2"});
        list.add(new Object[] {"test3","test3","test3"});
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void ContactCreation(String firstname, String lastname, String address) {
        File photo = new File("src/test/resources/1.jpg");
        Contacts before = app.contact().all();
        app.goTo().addNewContact();
        ContactData contact = new ContactData()
                .withFirstname("Cyril")
                .withLastname("Puhalskiy")
                .withAddress("Ukraine,Dnipro")
                .withWorkphonenumber("+380682323232")
                .withHomephonenumber("+30562343434")
                .withMobilephone("+30503204044")
                .withEmail1("Email1@email.com")
                .withHomepage("http://www.Homepageurl.com")
                .withGroupname("Test group1")
                .withPhoto(photo);
        app.contact().create(contact,true);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }


}
