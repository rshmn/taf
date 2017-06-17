package qa.taf.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.taf.adressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if (app.group().list().size() == 0) {
            app.group().create(new GroupData("test group", null, null));
        }
    }
    
    @Test
    public void GroupDeletion()  {

        app.goTo().groupPage();
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        app.group().delete(index);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(before.size(),after.size() + 1);

        before.remove(index);
        Assert.assertEquals(before, after);
    }




}
