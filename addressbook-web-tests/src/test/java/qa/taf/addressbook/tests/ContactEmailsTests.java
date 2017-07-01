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
public class ContactEmailsTests extends TestBase{

    @Test
    public void testsContactsEmails(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEdit = app.contact().infoFromEditForm(contact);
        String sdf = mergeEmails(contactInfoFromEdit);
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEdit)));

    }

    public String mergeEmails(ContactData contact){
        return Arrays.asList(contact.getEmail1(),contact.getEmail2(),contact.getEmail3()).stream()
                .filter((s) -> ! s.equals(""))
                .collect(Collectors.joining("\n"));
    }
}
