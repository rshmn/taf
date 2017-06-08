package qa.taf.adressbook.tests;

import org.testng.annotations.Test;
import qa.taf.adressbook.model.GroupDate;

public class GroupDeletionTests extends TestBase{

    
    @Test
    public void GroupDeletion()  {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupDate("test group", null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnGroupPage();
    }


}
