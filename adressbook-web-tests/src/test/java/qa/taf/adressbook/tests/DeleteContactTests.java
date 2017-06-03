package qa.taf.adressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by rushman on 5/29/17.
 */
public class DeleteContactTests extends TestBase{
    @Test(priority=1)
      public void DeleteContact(){
        app.getNavigationHelper().goHome();
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
