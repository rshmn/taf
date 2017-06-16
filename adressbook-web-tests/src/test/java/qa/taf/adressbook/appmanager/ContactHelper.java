package qa.taf.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import qa.taf.adressbook.model.ContactData;
import qa.taf.adressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;


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
        type(By.name("firstname"),contactData.getFirstname());
        type(By.name("lastname"),contactData.getLastname());
        //selectPhoto(By.xpath("//div[@id='content']/form/input[7]"),contactData.getPhotopath());
        type(By.name("address"),contactData.getAddress());
        type(By.name("home"),contactData.getHomephonenumber());
        type(By.name("work"),contactData.getWorkphonenumber());
        type(By.name("email"),contactData.getEmail1());
        type(By.name("homepage"),contactData.getHomepage());
        if (creation){
            setGroupForContact(contactData);
            } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
            }

    }

//    //private void selectPhoto(By locator, String photopath) {
//        wd.findElement(locator).sendKeys(photopath);
//    }

    private void setGroupForContact(ContactData contactData) {
        Select groupNameDropdown = new Select(wd.findElement(By.name("new_group")));
        groupNameDropdown.selectByVisibleText(contactData.getGroupname());
    }
    public void createContact(ContactData data, boolean b){

        fillContactForm(data, b);
        submitContactForm();
        returnHome();

    }
    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements){
            String name = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String lastname = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            String id = element.findElement(By.tagName("input")).getAttribute("value");
            ContactData contact = new ContactData(Integer.parseInt(id), name, lastname,null,null,null,null,null,null);
            contacts.add(contact);
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
    public void editContact(int index){
        int cell = 2 + index;
        click(By.xpath("//table[@id='maintable']/tbody/tr[" + cell + "]/td[8]/a/img"));
    }
    public void updateContact(){
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void returnHome() { click(By.linkText("home"));}

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
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
