package qa.taf.addressbook.tests;

import org.testng.annotations.Test;
import qa.taf.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by rushman on 6/25/17.
 */
public class ContactPhonesTests extends TestBase{

    @Test
    public void testContactsPhones(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEdit = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(),equalTo(mergePhones(contactInfoFromEdit)));

    }

    public String mergePhones (ContactData contact){
        return Arrays.asList(contact.getHomephonenumber(),contact.getMobilephone(),contact.getWorkphonenumber())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhonesTests::cleaned)
                .collect(Collectors.joining("\n"));

    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }

}
