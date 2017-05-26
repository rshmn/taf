package qa.taf.adressbook;

public class ContactData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String photopath;
    private final String title;
    private final String company;
    private final String address;
    private final String homephonenumber;
    private final String mobilephonenumber;
    private final String workphonenumber;
    private final String faxphonenumber;
    private final String email1;
    private final String email2;
    private final String email3;
    private final String homepage;
    private final String bday;
    private final String bmonth;
    private final String byear;
    private final String aday;
    private final String amonth;
    private final String ayear;
    private final String groupname;
    private final String address2;
    private final String phonehome2;
    private final String notes;

    public ContactData(String firstname, String middlename, String lastname, String nickname, String photopath, String title, String company, String address, String homephonenumber, String mobilephonenumber, String workphonenumber, String faxphonenumber, String email1, String email2, String email3, String homepage, String bday, String bmonth, String byear, String aday, String amonth, String ayear, String groupname, String address2, String phonehome2, String notes) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.photopath = photopath;
        this.title = title;
        this.company = company;
        this.address = address;
        this.homephonenumber = homephonenumber;
        this.mobilephonenumber = mobilephonenumber;
        this.workphonenumber = workphonenumber;
        this.faxphonenumber = faxphonenumber;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.aday = aday;
        this.amonth = amonth;
        this.ayear = ayear;
        this.groupname = groupname;
        this.address2 = address2;
        this.phonehome2 = phonehome2;
        this.notes = notes;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPhotopath() {
        return photopath;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomephonenumber() {
        return homephonenumber;
    }

    public String getMobilephonenumber() {
        return mobilephonenumber;
    }

    public String getWorkphonenumber() {
        return workphonenumber;
    }

    public String getFaxphonenumber() {
        return faxphonenumber;
    }

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    public String getAday() {
        return aday;
    }

    public String getAmonth() {
        return amonth;
    }

    public String getAyear() {
        return ayear;
    }

    public String getGroupname() {
        return groupname;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPhonehome2() {
        return phonehome2;
    }

    public String getNotes() {
        return notes;
    }
}
