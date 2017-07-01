package qa.taf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by rushman on 5/29/17.
 */
public class NavigationHelper extends HelperBase{


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void groupPage() {
        if(isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("groups"));
    }

    public void addNewContact() {
        click(By.linkText("add new"));
    }

    public void homePage(){
        if (isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));
    }
}
