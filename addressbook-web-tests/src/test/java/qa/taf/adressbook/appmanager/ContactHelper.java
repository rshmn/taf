package qa.taf.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import qa.taf.adressbook.model.ContactData;
import qa.taf.adressbook.model.Contacts;



import java.util.List;
import java.util.Set;


/**
 * Created by rushman on 5/29/17.
 */
public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactForm() {

        click(By.name("submit"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        attach(By.xpath("//div[@id='content']/form/input[7]"),contactData.getPhoto());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomephonenumber());
        type(By.name("work"), contactData.getWorkphonenumber());
        type(By.name("email"), contactData.getEmail1());
        type(By.name("homepage"), contactData.getHomepage());
        if (creation) {
            setGroupForContact(contactData);
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    private void setGroupForContact(ContactData contactData) {
        Select groupNameDropdown = new Select(wd.findElement(By.name("new_group")));
        groupNameDropdown.selectByVisibleText(contactData.getGroupname());
    }

    public void create(ContactData data, boolean b) {

        fillContactForm(data, b);
        submitContactForm();
        returnHome();

    }

    public void edit(ContactData contact) {
        editContactById(contact.getId());
        fillContactForm(contact, false);
        updateContact();
    }


    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteContact();
        acceptAlert();
    }

    public ContactData infoFromEditForm(ContactData contact) {
        editContactById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email1 = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHomephonenumber(home).withWorkphonenumber(work).withMobilephone(mobile)
                .withEmail1(email1).withEmail2(email2).withEmail3(email3).withAddress(address);

    }


    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String name = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String lastname = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            String id = element.findElement(By.tagName("input")).getAttribute("value");
            String allPhones = element.findElement(By.cssSelector("td:nth-child(6)")).getText();
            String allEmails = element.findElement(By.cssSelector("td:nth-child(5)")).getText();
            String address = element.findElement(By.cssSelector("td:nth-child(4)")).getText();
            contacts.add(new ContactData().withId(Integer.parseInt(id)).withFirstname(name).withLastname(lastname)
                    .withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address));

        }
        return contacts;
    }

    //
//    private void setAnnDay(ContactData contactData) {
//        Select adaydd = new Select(wd.findElement(By.name("aday")));
//        adaydd.selectByVisibleText(contactData.getAday());
//        Select amonthdd = new Select(wd.findElement(By.name("amonth")));
//        amonthdd.selectByVisibleText(contactData.getAmonth());
//        type(By.name("ayear"),contactData.getAyear());
//    }
//
//    private void setBirthday(ContactData contactData) {
//        Select bdaydd = new Select(wd.findElement(By.name("bday")));
//        bdaydd.selectByVisibleText(contactData.getBday());
//        Select bmonthdd = new Select(wd.findElement(By.name("bmonth")));
//        bmonthdd.selectByVisibleText(contactData.getBmonth());
//        type(By.name("byear"),contactData.getByear());
//    }
//    private void fillSecondblock(ContactData contactData) {
//        type(By.name("address2"),contactData.getAddress2());
//        type(By.name("phone2"),contactData.getPhonehome2());
//        type(By.name("notes"),contactData.getNotes());
//    }
    public void editContactById(int id) {

        click(By.cssSelector("a[href ='edit.php?id=" + id + "']"));
    }

    public void updateContact() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void returnHome() {
        click(By.linkText("home"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "'")).click();
    }

    public void deleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void selectAllContact() {
        click(By.id("MassCB"));
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

}
