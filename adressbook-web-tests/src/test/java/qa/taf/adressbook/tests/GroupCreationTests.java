package qa.taf.adressbook.tests;


import org.testng.annotations.Test;
import qa.taf.adressbook.model.GroupDate;


public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupDate("Test group1", "Group header test1", "group footer"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnGroupPage();

    }

}
