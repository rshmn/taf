package qa.taf.adressbook.model;

public class ContactData {
    private final int id;
    private final String firstname;
    private final String lastname;
    private final String address;
    private final String homephonenumber;
    private final String workphonenumber;
    private final String email1;
    private final String groupname;
    private final String homepage;

    public ContactData(int id, String firstname,String lastname, String address, String homephonenumber, String workphonenumber, String email1, String homepage,  String groupname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.homephonenumber = homephonenumber;
        this.workphonenumber = workphonenumber;
        this.email1 = email1;
        this.groupname = groupname;
        this.homepage = homepage;
    }

    public ContactData(String firstname,String lastname, String address, String homephonenumber, String workphonenumber, String email1, String homepage,  String groupname) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.lastname = lastname;
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

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    public String getLastname() {
        return lastname;
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

    public int getId() {
        return id;
    }
}
