package qa.taf.adressbook.model;

public class ContactData {
    private  int id = Integer.MAX_VALUE;
    private  String firstname;
    private  String lastname;
    private  String address;
    private  String homephonenumber;
    private  String workphonenumber;
    private  String email1;
    private  String groupname;
    private  String homepage;

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomephonenumber(String homephonenumber) {
        this.homephonenumber = homephonenumber;
        return this;
    }

    public ContactData withWorkphonenumber(String workphonenumber) {
        this.workphonenumber = workphonenumber;
        return this;
    }

    public ContactData withEmail1(String email1) {
        this.email1 = email1;
        return this;
    }

    public ContactData withGroupname(String groupname) {
        this.groupname = groupname;
        return this;
    }

    public ContactData withHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
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
