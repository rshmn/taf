package qa.taf.addressbook.tests;

import org.testng.annotations.Test;
import qa.taf.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by rushman on 6/25/17.
 */
public class ContactAddressTests extends TestBase {
    @Test
    public void testsContactAddress(){
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEdit = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAddress(), equalTo(contactInfoFromEdit.getAddress()));
    }

//    public String cleaned(String address) {
//        return address.replaceAll("\n\n","\n");
//    }
}
