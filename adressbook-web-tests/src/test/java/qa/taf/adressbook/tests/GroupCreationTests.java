package qa.taf.adressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import qa.taf.adressbook.model.GroupData;

import java.util.List;


public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().createGroup(new GroupData("Test group1", "Group header test1", "group footer"));
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size() + 1);
    }

}
