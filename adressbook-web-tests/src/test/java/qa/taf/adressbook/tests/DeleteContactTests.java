package qa.taf.adressbook.tests;

import org.testng.annotations.Test;
import qa.taf.adressbook.model.ContactData;

/**
 * Created by rushman on 5/29/17.
 */
public class DeleteContactTests extends TestBase{
    @Test(priority=1)
      public void DeleteContact(){
        app.getNavigationHelper().goHome();
        if(! app.getContactHelper().isThereAContact()){
            app.getNavigationHelper().addNewContact();
            app.getContactHelper().createContact(new ContactData("kirill","Puhalskiy", null, null, null, null, null, null, null), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().acceptAlert();

    }

    @Test(priority=2)
      public void DeleteAllContacts(){
        app.getNavigationHelper().goHome();
        app.getContactHelper().selectAllContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().acceptAlert();
    }


}
