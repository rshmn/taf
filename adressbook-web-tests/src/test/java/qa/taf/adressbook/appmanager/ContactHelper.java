package qa.taf.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import qa.taf.adressbook.model.ContactData;



/**
 * Created by rushman on 5/29/17.
 */
public class ContactHelper extends HelperBase {



    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void submitContactForm() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"),contactData.getFirstname());
        type(By.name("middlename"),contactData.getMiddlename());
        type(By.name("lastname"),contactData.getLastname());
        type(By.name("nickname"),contactData.getNickname());
        selectphoto(By.xpath("//div[@id='content']/form/input[7]"),contactData.getPhotopath());
        type(By.name("title"),contactData.getTitle());
        type(By.name("company"),contactData.getCompany());
        type(By.name("address"),contactData.getAddress());
        type(By.name("home"),contactData.getHomephonenumber());
        type(By.name("mobile"),contactData.getMobilephonenumber());
        type(By.name("work"),contactData.getWorkphonenumber());
        type(By.name("fax"),contactData.getFaxphonenumber());
        type(By.name("email"),contactData.getEmail1());
        type(By.name("email2"),contactData.getEmail2());
        type(By.name("email3"),contactData.getEmail3());
        type(By.name("homepage"),contactData.getHomepage());
        setBirthday(contactData);
        setAnnDay(contactData);
        setGroupForContact(contactData);
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys(contactData.getAddress2());
        wd.findElement(By.name("theform")).click();
        wd.findElement(By.name("phone2")).click();
        wd.findElement(By.name("phone2")).clear();
        wd.findElement(By.name("phone2")).sendKeys(contactData.getPhonehome2());
        wd.findElement(By.name("notes")).click();
        wd.findElement(By.name("notes")).clear();
        wd.findElement(By.name("notes")).sendKeys(contactData.getNotes());

    }

    private void selectphoto(By locator, String photopath) {
        wd.findElement(locator).sendKeys(photopath);
    }

    private void setGroupForContact(ContactData contactData) {
        Select groupNameDropdown = new Select(wd.findElement(By.name("new_group")));
        groupNameDropdown.selectByVisibleText(contactData.getGroupname());
    }

    private void setAnnDay(ContactData contactData) {
        Select adaydd = new Select(wd.findElement(By.name("aday")));
        adaydd.selectByVisibleText(contactData.getAday());
        Select amonthdd = new Select(wd.findElement(By.name("amonth")));
        amonthdd.selectByVisibleText(contactData.getAmonth());
        type(By.name("ayear"),contactData.getAyear());
    }

    private void setBirthday(ContactData contactData) {
        Select bdaydd = new Select(wd.findElement(By.name("bday")));
        bdaydd.selectByVisibleText(contactData.getBday());
        Select bmonthdd = new Select(wd.findElement(By.name("bmonth")));
        bmonthdd.selectByVisibleText(contactData.getBmonth());
        type(By.name("byear"),contactData.getByear());
    }


}
