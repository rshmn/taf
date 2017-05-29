package qa.taf.adressbook.tests;

import org.testng.annotations.Test;
import qa.taf.adressbook.model.GroupDate;

/**
 * Created by rushman on 5/29/17.
 */
public class GroupModificationTests extends TestBase {
    @Test
    public void GroupModification() {

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupDate("Test group1", "Group header test1", "group footer"));
        app.getGroupHelper().submitGroupModification();

    }
}