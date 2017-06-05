package qa.taf.adressbook.model;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String photopath;
    private final String address;
    private final String homephonenumber;
    private final String workphonenumber;
    private final String email1;
    private final String groupname;
    private final String homepage;

    public ContactData(String firstname,String lastname, String photopath, String address, String homephonenumber, String workphonenumber, String email1, String homepage,  String groupname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.photopath = photopath;
        this.address = address;
        this.homephonenumber = homephonenumber;
        this.workphonenumber = workphonenumber;
        this.email1 = email1;
        this.groupname = groupname;
        this.homepage = homepage;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhotopath() {
        return photopath;
    }

    public String getAddress() {
        return address;
    }

    public String getHomephonenumber() {
        return homephonenumber;
    }

    public String getWorkphonenumber() {
        return workphonenumber;
    }

    public String getEmail1() {
        return email1;
    }

    public String getGroupname() {
        return groupname;
    }

    public String getHomepage() { return homepage; }
}
