package qa.taf.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import qa.taf.adressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by rushman on 5/29/17.
 */
public class GroupModificationTests extends TestBase {
    @Test
    public void GroupModification() {

        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test group", null, null));
        }
        app.getGroupHelper().selectGroup(before.size() -1);
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData("Test group1", "Group header test1", "group footer"));
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(before.size(), after.size());

        before.remove(before.size() - 1);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }
}
