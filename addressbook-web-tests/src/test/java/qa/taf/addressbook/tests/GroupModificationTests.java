package qa.taf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.taf.addressbook.model.GroupData;
import qa.taf.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by rushman on 5/29/17.
 */
public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData().withName("Test group1"));
        }
    }

    @Test
    public void GroupModification() {

        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("test1").withFooter("testfooter").withHeader("testheader");
        app.group().modify(group);
        Groups after = app.group().all();
        assertEquals(before.size(), after.size());
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

    }



}
