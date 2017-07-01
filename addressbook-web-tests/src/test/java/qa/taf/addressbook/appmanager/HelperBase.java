package qa.taf.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;

import java.io.File;

/**
 * Created by rushman on 5/29/17.
 */
public class HelperBase {

    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text !=null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (! text.equals(existingText)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }

    }

    protected void attach(By locator, File file) {
        if (file !=null) {
                wd.findElement(locator).sendKeys(file.getAbsolutePath());
            }
        }


    public  boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true; }
        catch (NoSuchElementException ex) {
            return false;
        }

    }

    public void acceptAlert(){
            WebDriverWait  wait = new WebDriverWait(wd, 10);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = wd.switchTo().alert();
            alert.accept();


    }
}
