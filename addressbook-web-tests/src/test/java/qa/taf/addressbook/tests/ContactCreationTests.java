package qa.taf.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.taf.addressbook.model.ContactData;
import qa.taf.addressbook.model.Contacts;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class ContactCreationTests extends TestBase{

    @DataProvider
    public Iterator<Object[]> validContactsJson() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
        String line;
        String json = "";
        while ((line = reader.readLine()) != null){
            json += line;
        }
        Gson gson = new Gson();
        List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
        return contacts.stream().map((c) -> new Object[] {c}).collect(Collectors.toList()).iterator();

    }

    @Test(dataProvider = "validContactsJson")
    public void ContactCreation(ContactData contact) {
        Contacts before = app.contact().all();
        app.goTo().addNewContact();
        app.contact().create(contact,true);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }


}
