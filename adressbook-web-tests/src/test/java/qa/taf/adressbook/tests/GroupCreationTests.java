package qa.taf.adressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import qa.taf.adressbook.model.GroupDate;


public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().createGroup(new GroupDate("Test group1", "Group header test1", "group footer"));
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before + 1);
    }

}
