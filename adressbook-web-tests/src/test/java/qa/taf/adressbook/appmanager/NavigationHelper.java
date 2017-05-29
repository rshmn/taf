package qa.taf.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by rushman on 5/29/17.
 */
public class NavigationHelper extends HelperBase{


    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void addNewContact() {
        click(By.linkText("add new"));
    }
}
