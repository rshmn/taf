package qa.taf.adressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by rushman on 5/29/17.
 */
public class DeleteContactTests extends TestBase{
    @Test
            public void DeleteContact(){
        app.getNavigationHelper().addNewContact();

    }

}
