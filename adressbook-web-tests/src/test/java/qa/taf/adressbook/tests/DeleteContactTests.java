package qa.taf.adressbook.tests;

import org.testng.Assert;
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
            app.getContactHelper().createContact(new ContactData("Cyril", "Puhalskiy","Ukraine,Dnipro", "+380682323232", "+30562343434", "Email1@email.com", "http://www.Homepageurl.com","Test group1"), true);
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact(before -1);
        app.getContactHelper().deleteContact();
        app.getContactHelper().acceptAlert();
        app.getNavigationHelper().goHome();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(before, after + 1);

    }

//    @Test(priority=2)
//      public void DeleteAllContacts(){
//        app.getNavigationHelper().goHome();
//        app.getContactHelper().selectAllContact();
//        app.getContactHelper().deleteContact();
//        app.getContactHelper().acceptAlert();
//    }


}
