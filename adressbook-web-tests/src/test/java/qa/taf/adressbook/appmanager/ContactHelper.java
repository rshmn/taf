package qa.taf.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import qa.taf.adressbook.model.ContactData;



/**
 * Created by rushman on 5/29/17.
 */
public class ContactHelper extends HelperBase {



    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactForm() {

        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData) {
        fillFirstblock(contactData);
        setGroupForContact(contactData);
        fillSecondblock(contactData);

    }

    private void fillSecondblock(ContactData contactData) {
        type(By.name("address2"),contactData.getAddress2());
        type(By.name("phone2"),contactData.getPhonehome2());
        type(By.name("notes"),contactData.getNotes());
    }

    private void fillFirstblock(ContactData contactData) {
        type(By.name("firstname"),contactData.getFirstname());
        type(By.name("middlename"),contactData.getMiddlename());
        type(By.name("lastname"),contactData.getLastname());
        type(By.name("nickname"),contactData.getNickname());
        selectPhoto(By.xpath("//div[@id='content']/form/input[7]"),contactData.getPhotopath());
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
    }

    public void editContactForm(ContactData contactData) {
        fillFirstblock(contactData);
        fillSecondblock(contactData);

    }

    private void selectPhoto(By locator, String photopath) {
        wd.findElement(locator).sendKeys(photopath);
    }

    private void setGroupForContact(ContactData contactData) {
        Select groupNameDropdown = new Select(wd.findElement(By.name("new_group")));
        groupNameDropdown.selectByVisibleText(contactData.getGroupname());
    }
//    private void selectDropdown(ContactData contactData, By locator) {
//        Select dropdown = new Select(wd.findElement(locator));
//        dropdown.selectByVisibleText(contactData.getGroupname());
//    }

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
    public void editContact(){
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }
    public void updateContact(){
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void acceptAlert(){
        wd.switchTo().alert().accept();
    }

    public void selectContact() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[1]/input"));
    }

    public void deleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void selectAllContact() {
        click(By.id("MassCB"));
    }
}
