package qa.taf.adressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase{

    
    @Test
    public void GroupDeletion()  {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnGroupPage();
    }


}
